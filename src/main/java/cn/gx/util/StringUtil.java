package cn.gx.util;

import java.text.DecimalFormat;

public class StringUtil {

	/**
	 * 
	 * @param str
	 * 		输入�?个字符串
	 * @return
	 * 		返回是否有�??
	 */
	public static boolean isEmpty(String str){
		
		if(str!=null&&str.trim().length()!=0){
			return false;
		}
		
		return true;
	}

	/**
	 *
	 * @param str
	 * 		字符�? "1,2..."
	 * @return
	 * 		[1][2][3]
	 */
	public static Long[] parseArrayLong(String str) {
		String [] arrayStr=str.split(",");
		int len=arrayStr.length;
		Long [] arrayLong=new Long[len];
		for (int i = 0; i < len; i++) {
			arrayLong[i]=Long.parseLong(arrayStr[i]);
		}
		return arrayLong;
	}
	
	public static String leave2Number(Object num){
		 DecimalFormat df = new DecimalFormat("#.0");
		 return df.format(num);
	}
}
