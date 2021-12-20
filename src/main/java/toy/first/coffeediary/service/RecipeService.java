package toy.first.coffeediary.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.first.coffeediary.domain.recipe.RecipeRepository;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

}
