package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class ThirdLoginUtil {

    //自己的开发者id
    private static String client_id = "75VDDkaX2obdoNWAwkAPidGT";
    //自己的开发者secret
    private static String client_secret="392tZef4xIW2Kh31m70S1YcFXe1voGag";
    //自己定义的请求成功回调地址
    private static String redirect_uri="http://localhost:9009/user/baiduCode";

    public static Map<String, Object> post(String address) {
        String message = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response;
        try {
            HttpPost postReq = new HttpPost(address);
            postReq.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            postReq.addHeader("Accept-Encoding", "gzip, deflate, sdch, br");
            postReq.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
            postReq.addHeader("Cache-Control","max-age=0");
            postReq.addHeader("Connection", "keep-alive");
            postReq.addHeader("Host", "openapi.baidu.com");
            postReq.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
            response = httpClient.execute(postReq);
            HttpEntity entity = response.getEntity();
            message = EntityUtils.toString(entity);
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String, Object> map = JSON.parseObject(message, new TypeReference<Map<String, Object>>(){});
        return map;
    }

    public String getUserid(String code) {
        String url = "https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code="+code+"&client_id="+client_id+"&client_secret="+client_secret+"&redirect_uri="+redirect_uri;
        Map<String,Object> map1 = this.post(url);
        String access_token  = (String) map1.get("access_token");
        String url2="https://openapi.baidu.com/rest/2.0/passport/users/getInfo?access_token="+access_token;
        Map<String,Object> map2 = this.post(url2);
        System.out.println(map2);
        return  (String) map2.get("userid");
    }
}
