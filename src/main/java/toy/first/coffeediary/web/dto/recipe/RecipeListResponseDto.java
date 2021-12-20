package toy.first.coffeediary.web.dto.recipe;

import lombok.Getter;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class RecipeListResponseDto {
    private Long diaryId;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;

    private User user;
    private Recipe recipe;
    private boolean secret;

    public RecipeListResponseDto(Diary entity) {
        this.diaryId = entity.getDiaryId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.user = entity.getUser();
        this.recipe =entity.getRecipe();
        this.secret = entity.isSecret();
    }
}

