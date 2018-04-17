package dcmsxcx.web.controller;

import org.apache.log4j.Logger;

/**
 * 基类
 * @author wwp
 * @date 2018-4-17
 */
public class BaseController {

    // 日志对象
    protected Logger log = Logger.getLogger(this.getClass());
    
    /**
     * 返回成功
     */
    protected static final String RST_SUCC = "00";

    /**
     * 返回状态码键
     */
    protected static final String RST_CODE = "rst_code";

    /**
     * 返回信息键
     */
    protected static final String RST_MSG = "rst_msg";

}
