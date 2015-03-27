package cn.gx.dao.base;


import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import cn.gx.domain.view.ComplexPage;
import cn.gx.domain.view.Page;
import cn.gx.domain.view.PageBean;
import cn.gx.util.ConfigUtil;
import cn.gx.util.HqlHelper;
import cn.gx.util.StringUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;

	protected  Class<T> clazz;


	public BaseDaoImpl(){

		ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz= (Class<T>) pt.getActualTypeArguments()[0];

		System.out.println("---------------->clazz:" + clazz);
	}

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}


	
	public void save(T entity) {
		this.getCurrentSession().save(entity);
	}

	
	public void update(T entity) {
		
		this.getCurrentSession().update(entity);
	}

	
	public void delete(Long id) {
		Object obj=this.getCurrentSession().get(clazz, id);
		this.getCurrentSession().delete(obj);
	}

	
	public T getById(Long id) {
		if(id!=null){
			return  (T) this.getCurrentSession().get(clazz,id);
		}
		return null;
	}

	
	public List<T> getByIds(Long[] ids) {
		return this.getByIds(ids,"id");
	}

	
	public List<T> getByIds(Long[] ids, String idAlias) {

		if(ids!=null&&ids.length>0){
			List<T> list=this.getCurrentSession().createCriteria(clazz)//
					.add(Restrictions.in(idAlias,ids))//
					.list();

			return list;
		}
		return Collections.emptyList();
	}

	
	public boolean checkUnique(String key,String value) {

		return this.getCurrentSession().createCriteria(clazz)//
				.add(Restrictions.eq(key,value))//
				.uniqueResult()// if have many return exception
				==null?true:false;
	}

	public List<T> getAll(HqlHelper hqlHelper){
		List<Object> parameters = hqlHelper.getParameters();
		// 查询数据列表
		Query listQuery = getCurrentSession().createQuery(// 生成查询对象
				hqlHelper.getQueryListHql());
		for (int i = 0; i < parameters.size(); i++) {// 设置参数
			listQuery.setParameter(i, parameters.get(i));
		}
		List<T> lists=listQuery.list();

		if(!lists.isEmpty()){
			return lists;
		}

		return Collections.emptyList();
	}
	
	public ComplexPage getComplexPage(int currentPage, int pageSize, HqlHelper hqlHelper) {	
		return new ComplexPage(this.getPage(currentPage,pageSize,hqlHelper));
	}
	
	public ComplexPage getComplexPage(int currentPage,HqlHelper hqlHelper) {	
		return new ComplexPage(this.getPage(currentPage,hqlHelper));
	}
	
	
	public Page getPage(int currentPage, int pageSize, HqlHelper hqlHelper) {
		System.out.println("----->新的分页方法");

		List<Object> parameters = hqlHelper.getParameters();
		// 查询数据总记录数
		Query countQuery = getCurrentSession().createQuery(
				hqlHelper.getQueryCountHql());// 生成查询对象
		for (int i = 0; i < parameters.size(); i++) {// 设置参数
			countQuery.setParameter(i, parameters.get(i));
		}

		int recordCount = ((Long) countQuery.uniqueResult())//
				.intValue();

		// 查询数据列表
		Query listQuery = getCurrentSession().createQuery(// 生成查询对象
				hqlHelper.getQueryListHql());
		for (int i = 0; i < parameters.size(); i++) {// 设置参数
			listQuery.setParameter(i, parameters.get(i));
		}
		List recordList = listQuery
				.setFirstResult((currentPage - 1) * pageSize)// (pageNum-1)*pageSize+1-1
				.setMaxResults(pageSize).list();
		return new Page(currentPage, pageSize, recordList, recordCount);
	}

	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		int pageSize = Integer.parseInt(ConfigUtil.get("pageSize"));//默认�??
		return this.getPage(currentPage, pageSize, hqlHelper);
	}

	
	public void deleteByIds(String ids) {

		if(!StringUtil.isEmpty(ids)){
			
			Long [] deLongsLong=StringUtil.parseArrayLong(ids);
			for(Long id:deLongsLong){
				this.delete(id);
			}
		}

	}

	
	public List<T> getAll() {
		List<T> tList=this.getCurrentSession().createCriteria(clazz).list();
		if(!tList.isEmpty()){
			return tList;
		}
		return Collections.emptyList();
	}

	public PageBean getPageBean(int currentPage, HqlHelper hqlHelper) {
		System.out.println("----->新的分页方法");
		List<Object> parameters = hqlHelper.getParameters();
		// 查询数据总记录数
		Query countQuery = getCurrentSession().createQuery(
				hqlHelper.getQueryCountHql());// 生成查询对象
		for (int i = 0; i < parameters.size(); i++) {// 设置参数
			countQuery.setParameter(i, parameters.get(i));
		}

		int recordCount = ((Long) countQuery.uniqueResult())//
				.intValue();

		// 查询数据列表
		Query listQuery = getCurrentSession().createQuery(// 生成查询对象
				hqlHelper.getQueryListHql());
		for (int i = 0; i < parameters.size(); i++) {// 设置参数
			listQuery.setParameter(i, parameters.get(i));
		}
		int pageSize = Integer.parseInt(ConfigUtil.get("pageSize"));
		
		List recordList = listQuery
				.setFirstResult((currentPage - 1) * pageSize)// (pageNum-1)*pageSize+1-1
				.setMaxResults(pageSize).list();
		return new PageBean(currentPage, pageSize, recordList, recordCount);
	}

	


}
