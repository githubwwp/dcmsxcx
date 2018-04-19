package dcmsxcx.service.db;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 获取员工测试
     * 2018-4-19 by wwp
     */
        String sql = "select * from (select Emp_id emp_id, Emp_name emp_name from dcms_employee_information limit 10 ) aa";
        public List<Map<String, Object>> getSomeEmployee(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        
        return list;
    }
    
    
}
