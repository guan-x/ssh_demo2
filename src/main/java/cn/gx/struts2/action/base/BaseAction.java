package cn.gx.struts2.action.base;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.gx.domain.view.SessionUser;
import cn.gx.util.ConfigUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	protected T model = null;

	protected Class<T> modelClass;

	protected Map<String, Object> jsonMap = new HashMap<String, Object>(0);
	protected int pageNum=1;
	protected static  Long loginUserId;
	
	public BaseAction() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		modelClass = (Class) pt.getActualTypeArguments()[0];
	}

	public T getModel() {
		// TODO Auto-generated method stub

		if (model == null) {
			try {
				model = modelClass.newInstance();

			} catch (final Exception e) {
				// TODO Auto-generated catch block
				LOG.error(e.getMessage());

			}
		}
		return model;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Long getLUIDfromSession(HttpSession session) {

		SessionUser sessionInfo = (SessionUser) session.getAttribute(ConfigUtil
				.getSessionInfoName());
		return sessionInfo.getId();
	}

}
