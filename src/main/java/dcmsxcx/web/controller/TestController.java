package dcmsxcx.web.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.spring.web.servlet.view.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dcmsxcx.constant.WebConstant;
import dcmsxcx.util.StringUtil;

@Controller
@RequestMapping("test")
@Scope("prototype")
public class TestController {

    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    @RequestMapping("jdbcTest2")
    public ModelAndView jdbcTest(@RequestParam Map<String, Object> map) {
        Map<String, Object> rstMap = new HashMap<String, Object>();
        
        String a = StringUtil.trimNull(map.get("a"));
        System.out.println("a: " + a);
        // 获取数据
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select user_id, username, age from t_user");
        
        rstMap.put(WebConstant.RST_DATA, list);
        rstMap.put(WebConstant.RST_CODE, WebConstant.RST_SUCC);

        return new ModelAndView(new JsonView(), rstMap);
    }
    
    
    @RequestMapping("wxCode")
    public ModelAndView wxCode(){
        Map<String, Object> rstMap = new HashMap<String, Object>();
        
        return new ModelAndView(new JsonView(), rstMap);
    }
    
    public static void main(String[] args) {
        System.out.println(URLEncoder.encode("http://wwp123.top:8083/dcmsxcx"));
    }

}
