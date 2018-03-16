package com.jk.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            //4.处理结果，这里将结果返回为字符串
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
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
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个post请求
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.处理结果，这里将结果返回为字符串
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
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
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //给参数赋值
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
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*// /test/view post 提交数据，模拟表单
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public void viewTest(PrintWriter out, HttpServletResponse response, @RequestParam("param1") String param1,
                         @RequestParam("param2") String param2) {
        response.setContentType("application/json;charset=UTF-8");
        Gson gson = new GsonBuilder().create();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("param1", param1);
        map.put("param2", param2);
        System.out.println(gson.toJson(map));
        out.print(gson.toJson(map));
    }

    // /test/view?param1=aaa&param2=bbb get
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public void viewTest3(PrintWriter out, HttpServletResponse response, @RequestParam("param1") String param1,
                          @RequestParam("param2") String param2) {
        response.setContentType("application/json;charset=UTF-8");
        Gson gson = new GsonBuilder().create();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("param1", param1);
        map.put("param2", param2);
        System.out.println(gson.toJson(map));
        out.print(gson.toJson(map));
    }

    // /test/view2/{courseId}
    @RequestMapping(value = "/view2/{param}", method = RequestMethod.GET)
    public void viewTest1(PrintWriter out, HttpServletResponse response, @PathVariable("param") String param) {
        response.setContentType("application/json;charset=UTF-8");
        Gson gson = new GsonBuilder().create();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("param", param);
        out.print(gson.toJson(map));
    }

    // /test/view3
    @RequestMapping(value = "/view3", method = RequestMethod.POST)
    public void viewTest2(PrintWriter out, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        Gson gson = new GsonBuilder().create();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "success");
        out.print(gson.toJson(map));
    }*/











    /*@Test
    public void testGet() {
        //百度天气的api
        //String url1 = "http://api.map.baidu.com/telematics/v3/weather?location=%E5%8C%97%E4%BA%AC&output=json&ak=W69oaDTCfuGwzNwmtVvgWfGH";
        String url1 = "http://localhost:8080/wechat/test/view2/你好世界";
        String result1 = HttpUtil.sendGet(url1);
        System.out.println(result1);
        //输出{"param":"你好世界"}
    }
    @Test
    public void testPost() throws UnsupportedEncodingException{
        String url = "http://localhost:8080/wechat/test/view";
        Map<String,String> map = new HashMap<String,String>();
        map.put("param1", "你好世界");
        map.put("param2", "哈哈");
        String result = HttpUtil.sendPost(url, map);
        System.out.println(result);
        //输出结果{"param1":"你好世界","param2":"哈哈"}

    }

    @Test
    public void testPost1() throws UnsupportedEncodingException{
        String url = "http://localhost:8080/wechat/test/view3";
        String result = HttpUtil.sendPost(url);
        System.out.println(result);
        //输出结果{"status":"success"}

    }*/
}
