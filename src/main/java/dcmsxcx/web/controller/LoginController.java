package dcmsxcx.web.controller;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.spring.web.servlet.view.JsonView;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dcmsxcx.constant.QYWXConstant;
import dcmsxcx.util.HttpUtil;
import dcmsxcx.util.StringUtil;


@Controller
@RequestMapping("login")
@Scope("prototype")
public class LoginController extends BaseController {

    /**
     * 根据code 获取用户信息 2018-4-17 by wwp
     */
    @RequestMapping("getUserIdByCode")
    public ModelAndView getUserIdByCode(@RequestParam Map<String, String> parMap) {
        Map<String, Object> rstMap = new HashMap<String, Object>();
        String code = parMap.get("code");
        log.info("getUserIdByCode, code: " + code);
        // 判断code是否为空
        if (StringUtil.isNotBlank(code)) {
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

                rstMap.put("userId", userId);
                rstMap.put(RST_CODE, RST_SUCC);
                rstMap.put(RST_MSG, "获取成功");
            } catch (Exception e) {
                e.printStackTrace();
                rstMap.put(RST_CODE, "01");
                rstMap.put(RST_MSG, "code获取失败");
            }
        } else {
            rstMap.put(RST_CODE, "01");
            rstMap.put(RST_MSG, "code为空");
        }

        log.info("rstMap: " + rstMap);
        return new ModelAndView(new JsonView(), rstMap);
    }
    
    
    /**
     * 登录操作
     * 2018-4-17 by wwp
     */
    @RequestMapping("doLogin")
    public ModelAndView doLogin(String username, String password) {
        log.info("doLogin, username: " + username);
        Map<String, Object> rstMap = new HashMap<String, Object>();
        // 验证参数
        if(StringUtil.isNotBlank(username) && StringUtil.isNotBlank(password)){
            
            rstMap.put(RST_CODE, RST_SUCC);
            rstMap.put(RST_MSG, "登录成功");
        } else{
            rstMap.put(RST_CODE, "01");
            rstMap.put(RST_MSG, "请输入帐号或密码");
        }

        return new ModelAndView(new JsonView(), rstMap);
    }
}
