package uts.edu.eao;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 */
public  abstract class AbstractEao implements Eao
	{
		// inject entityManager
		@PersistenceContext
		protected EntityManager em;

		public <T> T get(Class<T> entityClass, Object primaryKey)
			{
				T obj = em.find(entityClass, primaryKey);
				return obj;
			}

		public void save(Object entity)
			{
				em.persist(entity);
			}

		public void update(Object entity)
			{
				em.merge(entity);
			}


		public void delete(Class<?> entityClass, Object primaryKey)
			{
				em.remove(em.getReference(entityClass, primaryKey));
			}

		@SuppressWarnings("unchecked")
		public <T> List<T> getResultList(Class<T> entityClass)
		{
			// Get name of entity
			String entityName = entityClass.getSimpleName();
			
			// create query
			Query query = em.createQuery("select o from " + entityName + " o");
			
			// return result list
			return (List<T>) query.getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public <T> List<T> getResultList(Class<T> entityClass 
				, String whereJpql 
				, LinkedHashMap<String, String> orderBy
				, Object... args)
			{
				// Get name of entity
				String entityName = entityClass.getSimpleName();
				
				// create query
				Query query = em.createQuery("select o from "+ entityName
					+ " as o " + whereJpql);
				
				//set up parameter values in query
				for (int i = 0 ; i < args.length ; i++)
				{
					query.setParameter(i + 1 , args[i]);
				}
				
				//return result list
				return (List<T>)query.getResultList();
			}
		

	}
