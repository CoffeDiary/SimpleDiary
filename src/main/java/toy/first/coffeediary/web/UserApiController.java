package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import toy.first.coffeediary.config.auth.PrincipalDetails;
import toy.first.coffeediary.service.UserService;
import toy.first.coffeediary.web.dto.user.UserResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserApiController {
    private final UserService userService;
    @ResponseBody
    @GetMapping
    public UserResponseDto user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        return userService.findById(principal.getUser().getUserId());
    }
}
