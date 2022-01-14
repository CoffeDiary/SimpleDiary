package toy.first.coffeediary.web.dto.diary;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import toy.first.coffeediary.config.auth.PrincipalDetails;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;


@Getter
@NoArgsConstructor
public class DiarySaveRequestDto {
    private boolean secret;
    private Long userId;
    private String title;
    private String content;
    private float coffeeAmount;
    private int grindingPoint;
    private int waterDegree;
    private int waterAmount;
    private String coffeeBean;

    @Builder
    public DiarySaveRequestDto(boolean secret,String title, String content ,float coffeeAmount, int grindingPoint, int waterAmount, int waterDegree,String coffeeBean){
        this.secret = secret;
        this.title = title;
        this.content = content;
        this.waterAmount = waterAmount;
        this.waterDegree = waterDegree;
        this.grindingPoint = grindingPoint;
        this.coffeeAmount = coffeeAmount;
        this.coffeeBean = coffeeBean;
    }

    public Diary toDiaryEntity(){
        return Diary.builder()
                .title(title)
                .content(content)
                .secret(secret)
                .build();
    }

    public void addUserInfo(Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal.getUser().getUserId() = " + principal.getUser().getUserId());
        this.userId = principal.getUser().getUserId();
    }



    public Recipe toRecipeEntity(){
        return Recipe.builder()
                .coffeeBean(coffeeBean)
                .coffeeAmount(coffeeAmount)
                .waterAmount(waterAmount)
                .waterDegree(waterDegree)
                .build();
    }
}
