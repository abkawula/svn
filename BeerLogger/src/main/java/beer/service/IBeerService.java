package beer.service;

import java.util.List;

import beer.domain.Additive;
import beer.domain.Barley;
import beer.domain.Clarifier;
import beer.domain.Flavoring;
import beer.domain.Hop;
import beer.domain.Recipe;
import beer.domain.SpiceHerb;
import beer.domain.Yeast;


public interface IBeerService {

	List<Recipe> getRecipe(SearchCriteria searchCriteria);
	Hop findHopById(Integer id);
	Barley findBarleyById(Integer id);
	Yeast findYeastById(Integer id);
	Additive findAdditiveById(Integer id);
	Flavoring findFlavoringById(Integer id);
	Recipe findRecipeById(Integer id);
	Clarifier findClarifierById(Integer id);
	SpiceHerb findSpiceHerbById(Integer id);
	void persist(Object object);
	void merge(Object object);
	void refresh(Object object);
	List<Hop> getAllHops();
	List<Barley> getAllBarlies();
	List<Yeast> getAllYeasts();
	List<Additive> getAllAdditives();
	List<Flavoring> getAllFlavorings();
	List<Clarifier> getAllClarifiers();
	List<SpiceHerb> getAllSpiceHerbs();
}
