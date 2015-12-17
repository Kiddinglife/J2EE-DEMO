package uts.edu.eao;

import java.util.*;

/**
 *
 */
public interface Eao
{
	/**
	 * find entity
	 * @param <T> dynamic load entity
	 * @param entityClass 
	 * @param pk 
	 * @return return entity bean by pk
	 */
	<T> T get(Class<T> entityClass, Object pk);
	
	/**
	 * store entity bean
	 * @param entity  need to be stored
	 */
	void save(Object entity);
	
	/**
	 * update entity
	 * @param entity  need to be updated
	 */
	void update(Object entity);
	
	/**
	 * delete entity
	 * @param entityClass needing to be deleted
	 * @param pk needing to be deleted
	 */
	void delete(Class<?> entityClass, Object pk);

	/**
	 * get list
	 * @param entityClass 
	 * */
	<T> List<T> getResultList(Class<T> entityClass);
	
	public <T> List<T> getResultList(Class<T> entityClass , String whereJpql , LinkedHashMap<String, String> orderBy, Object... args);
	

}
