/**
 * 
 */
package com.leif.baidu.api.direction;

/**
 * @author pulifan
 *
 */
public class DirectionTest {
	
	private static String mode = "transit";
	private static String origin = "西安软件园";
	private static String destination = "钟楼";
	private static String region = "西安";
	private static String output = "json";
	private static String ak = "ySGFqnIjxxNBHviKeLtansEL";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 *  request example : http://api.map.baidu.com/direction/v1?mode=transit&origin=锟较碉拷锟斤拷锟�destination=锟斤拷锟斤拷锟斤拷学&region=锟斤拷锟斤拷&output=json&ak=E4805d16520de693a3fe707cdc962045
		 */
		
		String params = "mode=" + mode +
						"&origin=" + origin + 
						"&destination=" + destination +
						"&region=" + region +
						"&output=" + output + 
						"&ak=" + ak;
		String s=HttpRequest.sendGet("http://api.map.baidu.com/direction/v1", params);
        System.out.println(s);

	}

}
