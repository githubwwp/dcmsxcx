package dcmsxcx.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.spring.web.servlet.view.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dcmsxcx.service.db.EmployeeService;

@Controller
@RequestMapping("test")
@Scope("prototype")
public class TestController extends BaseController {

    @Autowired
    private EmployeeService employeeService; 
    
    @RequestMapping("test")
    public ModelAndView test(@RequestParam Map<String, String> parMap) {
        Map<String, Object> rstMap = new HashMap<String, Object>();
        List<Map<String, Object>> emps = employeeService.getSomeEmployee();
        rstMap.put("emps", emps);
        
        return new ModelAndView(new JsonView(), rstMap);
    }
    
}

