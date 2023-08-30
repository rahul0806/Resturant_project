package dao;

import java.util.List;

import dto.Customer;
import dto.food_item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class mydao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void save(Customer c)
	{
		transaction.begin();
		manager.persist(c);
		transaction.commit();
	}
	public void save(food_item item)
	{
		transaction.begin();
		manager.persist(item);
		transaction.commit();
	}

	public Customer fetchemail(String email) {
		 Query query = manager.createQuery("select x from Customer x where email=?1").setParameter(1, email);
	     List<Customer> list = query.getResultList();
	     if(list.isEmpty())
	    	 return null;
	     else
	    	 return list.get(0);
	}
	
	public Customer fetchmobile(long mobile) {
		 Query query = manager.createQuery("select x from Customer x where number=?1").setParameter(1, mobile);
	     List<Customer> list = query.getResultList();
	     if(list.isEmpty())
	    	 return null;
	     else
	    	 return list.get(0);
	
	}
	public List<food_item> fetchAllfooditem(){
		return manager.createQuery("select x from food_item x").getResultList();
	}
	
	public food_item find(int id)
	{
		return manager.find(food_item.class,id);
	}
	
	public void delete(food_item item)
	{
		transaction.begin();
		manager.remove(item);
		transaction.commit();
	}

}
