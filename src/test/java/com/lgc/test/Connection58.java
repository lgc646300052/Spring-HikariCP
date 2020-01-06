package com.lgc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection58 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String requestHeaderFilePath = "/requestHeader.txt";
		String url = "https://luoyang.58.com/fangchan/37393893985417x.shtml?iuType=p_0&PGTID=0d30576d-0022-f709-65f3-a7aca67ea4d9&ClickID=3";
		for (int i = 0; i < 10; i++) {
			String response = sendPost(url, "");
			System.out.println(response +"\n");
			Thread.sleep(800L);
		}
//		byte[] requestHeader = readRequestHeader(requestHeaderFilePath);
//		Socket s = new Socket(url, port);
//		s.getOutputStream().write(requestHeader);
	}
	
	    /**
	     * @作用 使用urlconnection
	     * @param url
	     * @param Params
	     * @return
	     * @throws IOException
	     */
	    public static String sendPost(String url,String Params)throws IOException{
	        OutputStreamWriter out = null;
	        BufferedReader reader = null;
	        String response="";
	        try {
	            URL httpUrl = null; //HTTP URL类 用这个类来创建连接
	            //创建URL
	            httpUrl = new URL(url);
	            //建立连接
	            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setRequestProperty("connection", "keep-alive");
	            conn.setRequestProperty("accept-language", "zh-CN,zh;q=0.9");
	            conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	            conn.setRequestProperty("user-agent", "https://luoyang.58.com/fangchan/37393893985417x.shtml?iuType=p_0&PGTID=0d30576d-0022-f709-65f3-a7aca67ea4d9&ClickID=3");
	            conn.setUseCaches(false);//设置不要缓存
	            conn.setInstanceFollowRedirects(true);
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.connect();
	            //POST请求
	            out = new OutputStreamWriter(
	                    conn.getOutputStream());
	            out.write(Params);
	            out.flush();
	            //读取响应
	            reader = new BufferedReader(new InputStreamReader(
	                    conn.getInputStream()));
	            String lines;
	            while ((lines = reader.readLine()) != null) {
	                lines = new String(lines.getBytes(), "utf-8");
	                response+=lines;
	            }
	            reader.close();
	            // 断开连接
	            conn.disconnect();

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
	            if(reader!=null){
	                reader.close();
	            }
	        }
	        catch(IOException ex){
	            ex.printStackTrace();
	        }
	    }

	        return response;
	    }
	
	private static byte[] readRequestHeader(String path) throws Exception {
		byte[] result = new byte[0];
		InputStream in = null;
		try {
			in = Connection58.class.getResourceAsStream(path);
			int available = in.available();
			if (available > 0) {
				result = new byte[available];
				in.read(result, 0, available);
			} else {
				result = new byte[0];
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		System.out.println(new String(result));
		return result;
	}

}
