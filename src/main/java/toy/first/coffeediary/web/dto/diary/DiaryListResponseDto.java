package toy.first.coffeediary.web.dto.diary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class DiaryListResponseDto {
    private Long diaryId;
    private String title;
    private String content;
    private LocalDateTime modifiedDate;
    private LocalDateTime createdDate;
    private boolean secret;

    public DiaryListResponseDto(Diary entity) {
        this.diaryId = entity.getDiaryId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.secret = entity.isSecret();
    }
}

