package toy.first.coffeediary.web.dto.login;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String userName;
    private String password;
}
