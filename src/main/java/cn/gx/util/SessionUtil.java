package cn.gx.util;

import com.opensymphony.xwork2.ActionContext;

public class SessionUtil{

	public static final String SESSIONINFO = ConfigUtil.getSessionInfoName();
	public static SessionInfo info;
	
	
	public static void object2Session(Object object){
		
		ActionContext.getContext().getSession().put(SESSIONINFO, object);
	}

	public static boolean isLogin(){
		
		info = (SessionInfo) ActionContext.getContext().getSession().get(SESSIONINFO);
		
		return info==null?false:true;
	}
	
	public static Long getIdFromSession(){
		
		return isLogin()==true?info.getId():null;
	}

	public static void removeSessionInfo() {
		if(info!=null){
			ActionContext.getContext().getSession().remove(SESSIONINFO);
			System.out.println("ç”¨æˆ·ï¼?"+info.getUsername()+"é€?å‡ºç³»ç»Ÿã??");
		}
	}
	
}
