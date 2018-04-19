package dcmsxcx.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class WechatRelaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加或编辑企业微信-易汇帐号关系
     * <p/>
     * 2018-4-19 by wwp
     */
    public int addOrEditRela(String user_id, String account_id) {
        String sql = "" 
                + " INSERT INTO dcms_wechat_rela ( user_id, account_id, gmt_create, gmt_modified ) "
                + " VALUES ( ?, ?, NOW(), NOW() ) " 
                + " ON DUPLICATE KEY UPDATE account_id = ?, gmt_modified = NOW()";
        int effRow = jdbcTemplate.update(sql, new Object[] { user_id, account_id, account_id });
        return effRow;
    }

}
