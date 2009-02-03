package repository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.xml.internal.ws.util.StringUtils;

import domain.Hop;
import domain.HopIngredient;
import domain.Recipe;

public class RecipeDao extends BeerHibernateUtil {
	
	public Recipe fetchById(int id, String[] relations) {
    	Session session = null;
    	Transaction transaction = null;
    	
    	Recipe recipe = null;
    	try {
    		session = sessionFactory.getCurrentSession();
    		transaction = session.beginTransaction();
    		
    		recipe = (Recipe) session.get(Recipe.class, id);
    		
    		for (String relation : relations) {
    			
    			String methodName = "get" + StringUtils.capitalize(relation);
    			Method relationshipMethod = Recipe.class.getMethod(methodName, new Class[0]);
    			try {
    				Collection collection = (Collection) relationshipMethod.invoke(recipe, new Object[0]);
    				collection.size();
    			} catch (ClassCastException e) {
    				e.printStackTrace();
    			}
    		}
    		
    		
    		transaction.commit();
    	} catch (Exception e) {
    		e.printStackTrace();
    		transaction.rollback();
    	} finally {
    		if (session != null && session.isOpen()) {
    			session.close();
    		}
    	}
    	
    	return recipe;
    }
	
	
	public static void main (String[] args) {
		
//		testSaveRecipe();
		testFetchRecipe();
		
		
	}
	
	private static void testFetchRecipe() {
		RecipeDao rDao = new RecipeDao();
		Recipe recipe = (Recipe) rDao.fetchById(2, new String[] {"hops", "barlies"});
		
		System.out.println("Id: " + recipe.getId() + " Name: " + recipe.getName());
		
		System.out.println("There are: \n " +
				"" + recipe.getHops().size() + " different types of hops \n" +
				"" + recipe.getBarlies().size() + " different types of barlies " +
						"in this recipe");
	}
	private static void testSaveRecipe() {
		try {
			Recipe recipe = new Recipe();
			recipe.setName("Test");
			
			Hop hop1 = new Hop();
			hop1.setId(1);
			
			HopIngredient hopIngredient1 = new HopIngredient();
			hopIngredient1.setBoilTime(0);
			hopIngredient1.setHop(hop1);
			hopIngredient1.setIbu(0);
			hopIngredient1.setQuantity(0);
			hopIngredient1.setUtilizationRate(0);
			
			List<HopIngredient> hops = new ArrayList<HopIngredient>();
			hops.add(hopIngredient1);
			
			recipe.setHops(hops);
			
			RecipeDao rDao = new RecipeDao();
//			rDao.save(hopIngredient1);
			rDao.save(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
