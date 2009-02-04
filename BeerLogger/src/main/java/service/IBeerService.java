package service;

import java.util.List;

import domain.Recipe;

public interface IBeerService {

	List<Recipe> findRecipeByCategory(Recipe.Style style);
}
