package com.founder.rhip.uthealth.controller.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    private static final Logger log = Logger.getLogger(HttpClientUtil.class);
    private HttpClientUtil() {
    }
    /**
     *
     * 向指定URL发送GET方法的请求
     * @param url  发送请求的URL
     * @return URL所代表远程资源的响应
     */

    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            // 建立实际的连接
            conn.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定URL发送POST方法的请求
     * @param url 请求地址
     * @param param  body参数
     * @return  返回参数
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    // 提供主方法，测试发送GET请求和POST请求
    public static void main(String args[]) {
        // 发送GET请求
//		String s = HttpClientUtil.sendGet("http://api.ihealthyun.com:8089/his/baseinfo/dept/00000011");
//		System.out.println(s);
//        JSONObject jResult = JSONObject.fromObject(s);
//        JSONArray jList = (JSONArray) (((Map)jResult).get("result"));
//        for (int i = 0; i < jList.size(); i++) {
//
//        }

//        Map map = new HashMap();
//        map.put("hospital","00000011");
//        map.put("card_no","52212119791007001X");
//        map.put("mobile_num","13205178637");
//        map.put("reg_no","44884");
//        map.put("doctor_date","2016-04-15 00:00:00");
//        map.put("name","严凯");
//        map.put("user_id","1234");
//        JSONObject jRequset = JSONObject.fromObject(map);
//        String param = jRequset.toString();
//        // 发送POST请求
//        JSONObject s1 = HttpClientUtil.sendPost("http://api.ihealthyun.com:8089/his/reg/visit",	param);
//        JSONArray res = (JSONArray)(((Map) s1).get("data"));
//        Map resMap = (Map)res.get(0);
//        JSONObject data = (JSONObject)(((Map) s1).get("err"));
//        System.out.println(s1.toString());
    	
//    	Map map = new HashMap();
//        map.put("referralCode","00000011");
//        map.put("result","accept");
//        JSONObject jRequset = JSONObject.fromObject(map);
//        String param = jRequset.toString();
        // 发送POST请求
//        String sr = HttpClientUtil.sendPost1("http://120.92.3.57:7413/notice/transform/","referralCode=00000011&result=accept");
//    	System.out.println(sr);
//        JSONArray res = (JSONArray)(((Map) s1).get("data"));
//        Map resMap = (Map)res.get(0);
//        JSONObject data = (JSONObject)(((Map) s1).get("err");

        JSONObject jRequset = new JSONObject();
        jRequset.put("keyword","27621");
        String param = jRequset.toString();
        // 发送POST请求
        String s2 = HttpClientUtil.sendPost("http://tttjw.yc.uthealth.com.cn/healthHome/h_users/searchWO", "keyword=27822");

        System.out.println(s2);
        JSONObject s1 = JSONObject.fromObject(s2);
        Map resMap = (Map)s1;
        if((int)resMap.get("code") == 200) {
            JSONObject rr= (JSONObject)resMap.get("data");
            System.out.println(rr);

        }

    }
}
