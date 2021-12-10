package toy.first.coffeediary.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;

import java.time.LocalDateTime;

@Getter
public class DiaryListResponseDto {
    private Long diaryId;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;
    private User user;
    private Recipe recipe;
    private boolean secret;

    public DiaryListResponseDto(Diary entity) {
        this.diaryId = entity.getDiaryId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
        this.user = entity.getUser();
        this.recipe =entity.getRecipe();
        this.secret = entity.isSecret();
    }
}

