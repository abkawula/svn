package beer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beer.domain.Hop;
import beer.domain.Recipe;


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

	public Hop findHopById(Integer id) {
		return em.find(Hop.class, id);
	}
}
