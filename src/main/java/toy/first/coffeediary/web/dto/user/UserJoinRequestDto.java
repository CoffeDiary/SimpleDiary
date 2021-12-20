package toy.first.coffeediary.web.dto.user;

import lombok.*;
import toy.first.coffeediary.domain.user.User;

@Getter
@Setter
@NoArgsConstructor
public class UserJoinRequestDto {
    private String nickName;
    private String userName;
    private String password;
    private String eMail;
    private String role;

    @Builder
    public UserJoinRequestDto(String nickName, String eMail, String role,String password, String userName) {
        this.nickName = nickName;
        this.userName = userName;
        this.eMail = eMail;
        this.role = role;
        this.password = password;
    }
    public User toEntity(){
        return User.builder()
                .nickName(nickName)
                .eMail(eMail)
                .role(role)
                .password(password)
                .userName(userName)
                .build();
    }
}
