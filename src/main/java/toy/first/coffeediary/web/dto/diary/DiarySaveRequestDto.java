package toy.first.coffeediary.web.dto.diary;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;


@Getter
@NoArgsConstructor
public class DiarySaveRequestDto {
    private boolean secret;
    private String title;
    private String content;
    private float coffeeAmount;
    private int grindingPoint;
    private int waterDegree;
    private int waterAmount;

    @Builder
    public DiarySaveRequestDto(boolean secret,String title, String content ,float coffeeAmount, int grindingPoint, int waterAmount, int waterDegree){
        this.secret = secret;
        this.title = title;
        this.content = content;
        this.waterAmount = waterAmount;
        this.waterDegree = waterDegree;
        this.grindingPoint = grindingPoint;
        this.coffeeAmount = coffeeAmount;
    }

    public Diary toDiaryEntity(){
        return Diary.builder()
                .title(title)
                .content(content)
                .secret(secret)
                .build();
    }

    public Recipe toRecipeEntity(){
        return Recipe.builder()
                .build();
    }
}
