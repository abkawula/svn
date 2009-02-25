package beer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beer.domain.Additive;
import beer.domain.Barley;
import beer.domain.Flavoring;
import beer.domain.Hop;
import beer.domain.Recipe;
import beer.domain.Yeast;


@Service("beerService")
@Repository
public class BeerService implements IBeerService {

	private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
	this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Recipe> getRecipe(SearchCriteria searchCriteria) {
    	
    	String style = searchCriteria.getStyle();
    	
    	List<Recipe> recipes = em.createQuery("select r from Recipe r")
	    .getResultList();
    	
	    return recipes; 
	
    }

    @Transactional(readOnly = true)
	public Hop findHopById(Integer id) {
		return em.find(Hop.class, id);
	}

    @Transactional(readOnly = true)
	public Additive findAdditiveById(Integer id) {
		return em.find(Additive.class, id);
	}

    @Transactional(readOnly = true)
	public Barley findBarleyById(Integer id) {
		return em.find(Barley.class, id);	}

    @Transactional(readOnly = true)
	public Flavoring findFlavoringById(Integer id) {
		return em.find(Flavoring.class, id);
	}

    @Transactional(readOnly = true)
	public Recipe findRecipeById(Integer id) {
		return (Recipe) em.createQuery("Select r " +
				"from Recipe r " +
				"inner join fetch r.additives " +
				"inner join fetch r.flavorings " +
				"inner join fetch r.barlies " +
				"inner join fetch r.yeasts" +
				"where r.id = " + id).getSingleResult();
	
	}

    @Transactional(readOnly = true)
	public Yeast findYeastById(Integer id) {
		return em.find(Yeast.class, id);
	}
	
    @Transactional
	public void persist(Object object) {
		em.persist(object);
		System.out.println("object saved:" + object);
	}
}
