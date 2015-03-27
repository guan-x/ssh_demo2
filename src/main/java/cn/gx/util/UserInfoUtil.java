package cn.gx.util;

import java.util.HashMap;
import java.util.Map;

public class UserInfoUtil {
	
	public static Map gender=new HashMap<Boolean, String>();
	public static Map phyCondition=new HashMap<Integer, String>();
	public static Map polStatus=new HashMap<Integer, String>();
	public static Map marStatus=new HashMap<Integer, String>();
	public static Map education=new HashMap<Integer, String>();
	public static Map grade=new HashMap<Integer, String>();

	static{
		gender.put(false, "�?");
		gender.put(true, "�?");
		
		phyCondition.put(0, "健康");
		phyCondition.put(1, "良好");
		phyCondition.put(2, "不健�?");
		
		polStatus.put(0, "�?般群�?");
		polStatus.put(1, "团员");
		polStatus.put(2, "党员");
		
		marStatus.put(0, "未婚");
		marStatus.put(1, "已婚");
		
		education.put(0, "专科");
		education.put(1, "本科");
		education.put(2, "研究�?");
		education.put(3, "博士�?");
		education.put(4, "其他");
		
		grade.put(2, "优秀");
		grade.put(1, "�?");
		grade.put(0, "及格");
		grade.put(-1, "不及�?");
	}
	
}
