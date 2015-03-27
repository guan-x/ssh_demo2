package cn.gx.domain.view;

import java.io.Serializable;

public class Json  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3052651681837121250L;
	
	private boolean success=false;//默认返回不成�?
	private String msg="";//返回消息
	private Object obj=null;//返回的数�?
	private boolean valid=false;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
