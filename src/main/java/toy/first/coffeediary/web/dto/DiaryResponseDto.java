package toy.first.coffeediary.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;

@Getter
@NoArgsConstructor
public class DiaryResponseDto {
    private Long diaryId;
    private String title;
    private String content;
    private Recipe recipe;
    private User user;
    private boolean secret;
    public DiaryResponseDto(Diary diary){
        this.diaryId = diary.getDiaryId();
        this.title = diary.getTitle();
        this.secret = diary.isSecret();
        this.recipe = diary.getRecipe();
        this.content = diary.getContent();
        this.user = diary.getUser();
    }
}
