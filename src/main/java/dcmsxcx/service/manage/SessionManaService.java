package dcmsxcx.service.manage;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class SessionManaService {

    /**
     * 添加登录状态
     * <p />
     * 2018-4-19 by wwp
     */
    public void setSessionByAccountId(String account_id, HttpSession session) {
        // 获取用户信息
        session.setAttribute("userId", account_id);
    }

}
