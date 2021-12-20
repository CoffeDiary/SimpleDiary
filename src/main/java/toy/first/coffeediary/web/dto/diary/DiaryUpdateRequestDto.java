package toy.first.coffeediary.web.dto.diary;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;

@Getter
@NoArgsConstructor
public class DiaryUpdateRequestDto {

    public boolean secret;
    public String title;
    public String content;

    @Builder
    public DiaryUpdateRequestDto(boolean secret, String title, String content){
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
