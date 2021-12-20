package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import toy.first.coffeediary.config.auth.PrincipalDetails;
import toy.first.coffeediary.domain.user.User;
import toy.first.coffeediary.domain.user.UserRepository;
import toy.first.coffeediary.service.UserService;
import toy.first.coffeediary.web.dto.user.UserJoinRequestDto;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    // Tip : JWT를 사용하면 UserDetailsService를 호출하지 않기 때문에 @AuthenticationPrincipal 사용 불가능.
    // 왜냐하면 @AuthenticationPrincipal은 UserDetailsService에서 리턴될 때 만들어지기 때문이다.
    // 유저 혹은 매니저 혹은 어드민이 접근 가능
//    @ResponseBody
//    @PostMapping("login")
//    public String login(Authentication authentication){
//        return "login";
////        System.out.println("a___________________________________a");
////        Optional<PrincipalDetails> principal = Optional.ofNullable((PrincipalDetails) authentication.getPrincipal());
////        if (principal.isEmpty()){
////            return "fail";
////        }
////        System.out.println("principal.get() = " + principal.get().getUsername() +"반가워");
////        return principal.get().getUser().getUserName();
//    }

    @PostMapping("join")
    public String join(@RequestBody UserJoinRequestDto requestDto) {
        requestDto.setPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        userService.save(requestDto);
        return "회원가입완료";
    }
}
