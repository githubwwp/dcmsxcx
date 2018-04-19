package dcmsxcx.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.spring.web.servlet.view.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dcmsxcx.service.db.WechatRelaService;
import dcmsxcx.service.manage.SessionManaService;
import dcmsxcx.util.HttpUtil;
import dcmsxcx.util.StringUtil;


@Controller
@RequestMapping("login")
@Scope("prototype")
public class LoginController extends BaseController {
    
    @Autowired
    private SessionManaService sessionManaService;
    
    @Autowired
    private WechatRelaService wechatRelaService;
    
    
    /**
     * 登录操作
     * 2018-4-17 by wwp
     */
    @RequestMapping("doLogin")
    public ModelAndView doLogin(String username, String password, String userId, HttpServletRequest request) {
        log.info("doLogin, username: " + username);
        HttpSession session = request.getSession();
        Map<String, Object> rstMap = new HashMap<String, Object>();
        // 验证参数
        if(StringUtil.isNotBlank(username) && StringUtil.isNotBlank(password)){
            
            boolean isAccount = this.isAccountValid(username, password); // 登录验证
            if(isAccount){
                sessionManaService.setSessionByAccountId(username, session);
                // 同步企业微信和 易汇帐号关系
                wechatRelaService.addOrEditRela(userId, username);
                
                rstMap.put(RST_CODE, RST_SUCC);
                rstMap.put(RST_MSG, "登录成功");
            } else{
                rstMap.put(RST_CODE, "01");
                rstMap.put(RST_MSG, "帐号或密码错误!");
            }
        } else{
            rstMap.put(RST_CODE, "01");
            rstMap.put(RST_MSG, "请输入帐号或密码");
        }

        return new ModelAndView(new JsonView(), rstMap);
    }
    
    /**
     * 登出
     * 2018-4-19 by wwp
     */
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpServletRequest request) { 
        HttpSession session = request.getSession();
        session.removeAttribute("userId"); // 移除用户属性
        
        return new ModelAndView("redirect:/login.jsp");
    }
    
    /**
     * 帐号，密码验证
     * 2018-4-18 by wwp
     */
    private boolean isAccountValid(String account, String password){
        String dcmsUrl = "http://localhost:8080/dcms/iwap.ctrl";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("txcode", "xcx1001");
        paramMap.put("account", account);
        paramMap.put("password", password);
        
        try{
            String str = HttpUtil.sendGet(dcmsUrl);
            log.info(str);
            JSONObject json = JSONObject.fromObject(str);
            // TODO 判断是否成功
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}
