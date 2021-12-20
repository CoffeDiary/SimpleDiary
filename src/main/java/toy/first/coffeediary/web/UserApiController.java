package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import toy.first.coffeediary.config.auth.PrincipalDetails;
import toy.first.coffeediary.service.UserService;
import toy.first.coffeediary.web.dto.user.UserJoinRequestDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserApiController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    // Tip : JWT를 사용하면 UserDetailsService를 호출하지 않기 때문에 @AuthenticationPrincipal 사용 불가능.
    // 왜냐하면 @AuthenticationPrincipal은 UserDetailsService에서 리턴될 때 만들어지기 때문이다.
    // 유저 혹은 매니저 혹은 어드민이 접근 가능
    @GetMapping
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal : "+principal.getUser().getUserId());
        System.out.println("principal : "+principal.getUser().getUserName());
        System.out.println("principal : "+principal.getUser().getPassword());
        return "<h1>user: "  + principal.getUsername() + " 입니다. 비번은 : " + principal.getPassword();
    }

    @PostMapping("join")
    public String join(@RequestBody UserJoinRequestDto requestDto) {
        userService.save(requestDto);
        return "회원가입완료";
    }

}
