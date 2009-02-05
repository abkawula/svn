package beer.service;

import java.util.List;

import beer.domain.Recipe;


public interface IBeerService {

	List<Recipe> findRecipeByCategory(Recipe.Style style);
}
