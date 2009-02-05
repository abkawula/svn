package beer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Recipe> findRecipeByCategory(Recipe.Style style) {
	
	    return em.createQuery("select r from Recipe r where r.style = :style ")
		    .getResultList();
	
    }
}
