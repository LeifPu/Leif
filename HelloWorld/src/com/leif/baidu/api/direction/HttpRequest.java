
package com.leif.baidu.api.direction;

/**
 * @author pulifan
 *
 */

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;





import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequest {
    /**
     * 锟斤拷指锟斤拷URL锟斤拷锟斤拷GET锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
     * 
     * @param url
     *            锟斤拷锟斤拷锟斤拷锟斤拷锟経RL
     * @param param
     *            锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷应锟斤拷锟斤拷 name1=value1&name2=value2 锟斤拷锟斤拷式锟斤拷
     * @return URL 锟斤拷锟斤拷远锟斤拷锟斤拷源锟斤拷锟斤拷应锟斤拷锟�
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        HttpResponse response;
        try {
            String urlNameString = url + "?" + param;
            HttpGet httpgets = new HttpGet(urlNameString);
            
            HttpClient httpclient = new DefaultHttpClient();
            response = httpclient.execute(httpgets);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
				InputStream instreams = entity.getContent();
				String str = convertStreamToString(instreams);
				JSONArray jsonArray=new JSONObject(str).getJSONArray("forecasts");
				   for(int i=0;i<jsonArray.length();i++){
					JSONObject jsonObject=(JSONObject)jsonArray.get(i);
					String strDate = jsonObject.getString("date");
					result= strDate;
					//JSONObject geometry = jsonObject.getJSONObject("date");
					//JSONObject locations = geometry.getJSONObject("text");
					//ret = locations.getString("lat") + ", "
							//+ locations.getString("lng");
				   }

				httpgets.abort();
				
			}
        } catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally{
        	
        }
        return result;
    }


	public static String convertStreamToString(InputStream is){    
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("utf-8")));    
	    StringBuilder sb = new StringBuilder();    
	 
	    String line = null;    
	    try {    
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");    
	        }    
	    } catch (IOException e) {    
	        e.printStackTrace();    
	    } finally {    
	        try {    
	            is.close();    
	        } catch (IOException e) {    
	           e.printStackTrace();    
	        }    
	    }    
	    return sb.toString();    
	}

    /**
     * 锟斤拷指锟斤拷 URL 锟斤拷锟斤拷POST锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
     * 
     * @param url
     *            锟斤拷锟斤拷锟斤拷锟斤拷锟�URL
     * @param param
     *            锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷应锟斤拷锟斤拷 name1=value1&name2=value2 锟斤拷锟斤拷式锟斤拷
     * @return 锟斤拷锟斤拷远锟斤拷锟斤拷源锟斤拷锟斤拷应锟斤拷锟�
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        InputStream in = null;
        ByteArrayOutputStream outStream = null;
        byte[] data = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 锟津开猴拷URL之锟斤拷锟斤拷锟斤拷锟�
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 锟斤拷锟斤拷通锟矫碉拷锟斤拷锟斤拷锟斤拷锟斤拷
            conn.setRequestMethod("POST");
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 锟斤拷锟斤拷POST锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 锟斤拷取URLConnection锟斤拷锟斤拷锟接︼拷锟斤拷锟斤拷锟斤拷
            
            byte[] b_params = param.getBytes();
            conn.getOutputStream().write(b_params);
            
            in = conn.getInputStream();
            outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = in.read(buffer)) != -1){
            	outStream.write(buffer, 0, len);
            }
            
            data = outStream.toByteArray();
            result = new String(data, "UTF-8");
            
//            out = new PrintWriter(conn.getOutputStream());
//            // 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
//            out.print(param);
//            // flush锟斤拷锟斤拷锟斤拷幕锟斤拷锟�
//            out.flush();
//            // 锟斤拷锟斤拷BufferedReader锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷取URL锟斤拷锟斤拷应
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
        } catch (Exception e) {
            System.out.println("调用post失败"+e);
            e.printStackTrace();
        }
        //使锟斤拷finally锟斤拷锟斤拷锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
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
}
