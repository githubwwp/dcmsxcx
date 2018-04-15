package dcmsxcx.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import dcmsxcx.constant.WebConstant;


/**
 *
 */
public class HttpUtil {

    private static final CloseableHttpClient httpclient = HttpClients.createDefault();

    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {

        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity1 = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // 测试
    public static void main(String[] args) {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("a", "233");
    	map.put("b", "武汉");
    	String str = HttpUtil.sendPost("http://localhost/dcmsxcx/test/jdbcTest2.do", map);
    	JSONObject json = JSONObject.fromObject(str);
    	System.out.println(JSONUtil.getStr(json, WebConstant.RST_CODE));
    	System.out.println(str);
    	
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("appid", "wx4b74be6daadcd723");
//        map.put("secret", "d2d297108246268ddcea011f0b4d3190");
//        map.put("js_code", "003LFBFI1JjH090n9zFI1jDnFI1LFBFt");
//        map.put("grant_type", "authorization_code");
//        String rst = HttpUtil.sendPost("https://api.weixin.qq.com/sns/jscode2session", map);
//        
//        JSONObject jsonObj = JSONObject.fromObject(rst);
//        for(Object o: jsonObj.keySet()){
//            System.out.println(o + ": " + jsonObj.get(o));
//        }
//        String openId = null;
//        try {
//            openId = JSONUtil.getStr(jsonObj, "openid");
//        } catch (JSONException e) {
//            openId = null;
//        }
//        System.out.println(openId);
    }

}