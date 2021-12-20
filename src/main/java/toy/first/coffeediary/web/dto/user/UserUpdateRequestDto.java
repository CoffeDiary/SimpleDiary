package toy.first.coffeediary.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.user.User;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    public String nickname;

    @Builder
    public UserUpdateRequestDto(String nickname){
        this.nickname = nickname;
    }

    public User toEntity(){
        return User.builder()
                .nickName(nickname)
                .build();
    }
}
