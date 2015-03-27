package cn.gx.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class DemoAction {
	
	public String hello(){
		return "hello";
	}
}
