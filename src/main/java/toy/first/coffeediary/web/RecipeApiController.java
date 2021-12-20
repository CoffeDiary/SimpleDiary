package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import toy.first.coffeediary.service.RecipeService;

@RestController
@RequiredArgsConstructor
public class RecipeApiController {
    private final RecipeService recipeService;
}
