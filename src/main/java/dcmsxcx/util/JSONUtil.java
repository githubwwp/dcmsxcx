package dcmsxcx.util;

import net.sf.json.JSONObject;


/**
 * json util
 * 
 * @author wwp
 * @date 2017-9-27
 */
public class JSONUtil {

    private JSONUtil() {
    }

    /**
     * 如果val 为null,'' 或 "null" 返回null <br />
     * 2017-9-27 by wwp
     */
    public static String getStr(JSONObject json, String key) {
        String val = json.getString(key);
        if (StringUtil.isBlank(val) || "null".equals(val)) {
            return null;
        } else {
            return val;
        }
    }

    /**
     * 获取Double
     * 2017-9-27 by wwp
     */
    public static Double getDouble(JSONObject json, String key) {
        String val = getStr(json, key);
        return val == null ? null : Double.parseDouble(val);
    }
    
    /**
     * 获取Integer
     * 2017-9-29 by xiaowk
     */
    public static Integer getInteger(JSONObject json, String key) {
    	String val = getStr(json, key);
    	return val == null ? null : Integer.parseInt(val);
    }

    public static void main(String[] args) {
        String str = "{a: 23, b: 'cc', c: null}";
        JSONObject jsonObj = JSONObject.fromObject(str);
        System.out.println(JSONUtil.getStr(jsonObj, "c") == null);

    }

}
