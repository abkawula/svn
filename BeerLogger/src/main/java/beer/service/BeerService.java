package beer.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beer.domain.MashSchedule;
import beer.domain.MashStep;
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
    	
    	MashSchedule m = new MashSchedule();
    	m.setCategory("British Infusion Mash");
    	m.setName("Pale Ale / Bitter / Light Ale");
    	
    	List<MashStep> steps = new ArrayList<MashStep>();
    	m.setMashSteps(steps);
    	
    	MashStep step1 = new MashStep();
    	step1.setOrder(1);
    	step1.setTemp(170);
    	step1.setWaterQuantity(1.3);
    	
    	steps.add(step1);
    	
    	em.persist(m);
    	
	    return recipes; 
	
    }
}
