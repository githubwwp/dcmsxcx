package dcmsxcx.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dcmsxcx.constant.QYWXConstant;
import dcmsxcx.service.manage.SessionManaService;
import dcmsxcx.util.HttpUtil;
import dcmsxcx.util.StringUtil;

@Controller
@RequestMapping("")
@Scope("prototype")
public class WechatController extends BaseController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private SessionManaService sessionManaService;
    
    /**
     * 根据code尝试登录
     * <p />
     * 2018-4-19 by wwp
     */
    @RequestMapping("wechatLogin")
    public ModelAndView wechatLogin(String code, HttpServletRequest request) {
        log.info("loginByCode, code: " + code);
        Map<String, String> rstMap = new HashMap<String, String>();
        HttpSession session = request.getSession();

        if (StringUtil.isNotBlank(code)) {
            // 获取企业微信UserId
            String userId = this.getUserIdByCode(code);

            if (StringUtil.isNotBlank(userId)) {
                rstMap.put("userId", userId); // 添加企业微信id
                // 模拟登录
                boolean isLogin = this.doginByUserId(userId, session);
                if (isLogin) {
                    return new ModelAndView("redirect:index.jsp");
                }
            }
        }

        return new ModelAndView("redirect:/login.jsp", rstMap);
    }
    
    
    /**
     * 根据code 获取企业微信userId
     * 2018-4-19 by wwp
     */
    private String getUserIdByCode(String code) {

        try {
            // 获取access_token
            String tokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + QYWXConstant.CORPID + "&corpsecret="
                    + QYWXConstant.CORPSECRET;
            String tokenReturnStr = HttpUtil.sendGet(tokenUrl);
            log.info("获取access_token返回字符串：" + tokenReturnStr);
            JSONObject tokenJson = JSONObject.fromObject(tokenReturnStr);
            String access_token = tokenJson.getString("access_token");

            // 获取用户信息
            String userUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=" + access_token + "&code=" + code;
            String userReturnStr = HttpUtil.sendGet(userUrl);
            log.info("获取用户信息返回字符串: " + userReturnStr);
            JSONObject userJson = JSONObject.fromObject(userReturnStr);
            String userId = userJson.getString("UserId");
            return userId;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }
    
    
    
    /**
     * 模拟登录
     * <p />
     * 2018-4-19 by wwp
     */
    private boolean doginByUserId(String userId, HttpSession session) {
        String sql = "SELECT user_id, account_id FROM dcms_wechat_rela WHERE user_id = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[] { userId });
        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            String account_id = StringUtil.trimNull(map.get("account_id"));
            // 存入session
            sessionManaService.setSessionByAccountId(account_id, session);
            return true;
        } else {
            return false;
        }
    }
    
}
