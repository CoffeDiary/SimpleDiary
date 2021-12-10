package toy.first.coffeediary.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;
import toy.first.coffeediary.service.DiaryService;


@Getter
@NoArgsConstructor
public class DiarySaveRequestDto {
    private User user;
    private Recipe recipe;
    private boolean secret;
    private String title;
    private String content;

    @Builder
    public DiarySaveRequestDto(boolean secret,String title, String content){
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
