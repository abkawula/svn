package beer.service;

import java.util.List;

import beer.domain.Additive;
import beer.domain.Barley;
import beer.domain.Flavoring;
import beer.domain.Hop;
import beer.domain.Recipe;
import beer.domain.Yeast;


public interface IBeerService {

	List<Recipe> getRecipe(SearchCriteria searchCriteria);
	Hop findHopById(Integer id);
	Barley findBarleyById(Integer id);
	Yeast findYeastById(Integer id);
	Additive findAdditiveById(Integer id);
	Flavoring findFlavoringById(Integer id);
	Recipe findRecipeById(Integer id);
	void persist(Object object);
}
