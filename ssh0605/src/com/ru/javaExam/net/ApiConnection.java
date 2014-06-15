package com.ru.javaExam.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;

public class ApiConnection {
	public static void main(String[] args) {
		String city = "beijing";//参数
		String title = URLEncoder.encode("速度与激情6");
		String url = "http://v.juhe.cn/weather/index?cityname=苏州";//url为请求的api接口地址
	    String key= "5531b1cdc5ad00840018dcf0387b45fe";//申请的对应key
//		String urlAll = new StringBuffer(url).append("&key=" + key).toString(); 
	    String urlAll = "http://api.k780.com:88/?app=weather.future&weaid=1&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
		String charset ="UTF-8";
		String jsonResult = get(urlAll, charset);//得到JSON字符串
		
		JSONObject object = JSONObject.fromObject(jsonResult);//转化为JSON类
		String code = object.getString("error_code");//得到错误码
		//错误码判断
		if(code.equals("0")){
			//根据需要取得数据
			JSONObject jsonObject =  (JSONObject)object.getJSONArray("result").get(0);
			System.out.println(jsonObject.getString("title"));
		}else{
			System.out.println("error_code:"+code+",reason:"+object.getString("reason"));
		}
	}
	   /**
	    * 
	    * @param urlAll:请求接口
	    * @param charset:字符编码
	    * @return 返回json结果
	    */
	   public static String get(String urlAll,String charset){
		   BufferedReader reader = null;
		   String result = null;
		   StringBuffer sbf = new StringBuffer();
		   String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";//模拟浏览器
		   try {
			   URL url = new URL(urlAll);
			   HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			   connection.setRequestMethod("GET");
			   connection.setReadTimeout(30000);
			   connection.setConnectTimeout(30000);
			   connection.setRequestProperty("User-agent",userAgent);
			   connection.connect();
			   InputStream is = connection.getInputStream();
			   reader = new BufferedReader(new InputStreamReader(
						is, charset));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sbf.append(strRead);
					sbf.append("\r\n");
				}
				reader.close();
				result = sbf.toString();
			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		   System.out.println("结果：" + result);
		   return result;
	   }
}
