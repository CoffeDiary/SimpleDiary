package toy.first.coffeediary.web.dto.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;


@Getter
@NoArgsConstructor
public class RecipeSaveRequestDto {
    private User user;
    private Recipe recipe;
    private boolean secret;
    private String title;
    private String content;

    @Builder
    public RecipeSaveRequestDto(boolean secret, String title, String content){
        this.secret = secret;
        this.title = title;
        this.content = content;
    }

    public Diary toEntity(){
        return Diary.builder()
                .title(title)
                .content(content)
                .secret(secret)
                .build();
    }
}
