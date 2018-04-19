package dcmsxcx.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dcmsxcx.util.StringUtil;

public class LoginFilter implements Filter {

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper((HttpServletResponse) arg1);
        HttpSession session = request.getSession();

        String requestUri = request.getRequestURI();
        log.debug("requestUri: " + requestUri);

        // 登录用户没有限制
        String userId = StringUtil.trimNull(session.getAttribute("userId"));
        if (StringUtil.isNotBlank(userId)) {
            chain.doFilter(arg0, arg1);
            return;
        }

        // 开放地址
        if((request.getContextPath()+"/").equals(requestUri)){
            chain.doFilter(arg0, arg1);
            return;
        }
        List<String> openAddList = new ArrayList<String>();
        openAddList.add("/doLogin.do");
        openAddList.add("/login.jsp");
        openAddList.add("/wechatLogin.do");
        for (String s : openAddList) {
            if (requestUri.indexOf(s) != -1) {
                chain.doFilter(arg0, arg1);
                return;
            }
        }

        // TODO自定义js不缓存

        responseWrapper.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
