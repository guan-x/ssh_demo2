package cn.gx.dao.base;

import java.util.List;

import cn.gx.domain.view.ComplexPage;
import cn.gx.domain.view.Page;
import cn.gx.domain.view.PageBean;
import cn.gx.util.HqlHelper;

/**
 * 
 * 基础数据库操作类
 * 
 * 其他DAO继承此类获取常用的数据库操作方法
 * @author always_w_u
 *
 * @param <T>
 */
public interface BaseDao<T> {


	/**
	 * 保存实体
	 *
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 更新实体
	 *
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 删除实体
	 *
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 获取实体，如果id为null，则返回null
	 *
	 * @param id
	 * @return
	 */
	T getById(Long id);

	/**
	 * 获取实体
	 *
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 获取实体
	 *
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids, String idAlias);


	/**
	 *
	 * @param key
	 * 			数据库中字段
	 * @param value
	 * 			用户输入的字段的�?
	 * @return
	 * 		true 唯一
	 * 		false 不唯�?
	 */
	public boolean checkUnique(String key, String value);
	
	/**
	 * 
	 * @param hqlHelper
	 * 		拼接的hql语句
	 * @return
	 * 		返回集合
	 */
	public List<T> getAll(HqlHelper hqlHelper);
	/**
	 * 
	 * @param currentPage
	 * 			要显示第几页
	 * @param pageSize
	 * 			每页显示多少条记�?
	 * @param hqlHelper
	 * 			拼接的hql语句
	 * @return
	 * 			返回Page
	 */
	public Page getPage(int currentPage, int pageSize, HqlHelper hqlHelper);

	public ComplexPage getComplexPage(int currentPage, int pageSize, HqlHelper hqlHelper);
	public ComplexPage getComplexPage(int currentPage,HqlHelper hqlHelper);

	public Page getPage(int currentPage, HqlHelper hqlHelper);
	
	public PageBean getPageBean(int currentPage, HqlHelper hqlHelper);


	void deleteByIds(String ids);

	List<T> getAll();
}
