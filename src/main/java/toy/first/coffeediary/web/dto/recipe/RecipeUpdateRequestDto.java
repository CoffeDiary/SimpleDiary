package toy.first.coffeediary.web.dto.recipe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;

@Getter
@NoArgsConstructor
public class RecipeUpdateRequestDto {

    public boolean secret;
    public String title;
    public String content;

    @Builder
    public RecipeUpdateRequestDto(boolean secret, String title, String content){
        this.secret = secret;
        this.title = title;
        this.content = content;
    }

    public Diary toEntity(){
        return Diary.builder()
                .secret(secret)
                .title(title)
                .content(content)
                .build();
    }
}
