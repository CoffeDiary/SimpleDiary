package toy.first.coffeediary.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.first.coffeediary.domain.user.User;
import toy.first.coffeediary.domain.user.UserRepository;
import toy.first.coffeediary.web.dto.diary.DiaryUpdateRequestDto;
import toy.first.coffeediary.web.dto.user.UserJoinRequestDto;
import toy.first.coffeediary.web.dto.user.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserJoinRequestDto requestDto){
        return userRepository.save(requestDto.toEntity()).getUserId();
    }

    @Transactional
    public Long update(Long userId, DiaryUpdateRequestDto requestDto){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("id = "+ userId +" 사용자가 없습니다. "));
        user.update(requestDto.getContent());
        return userId;
    }

    @Transactional
    public void delete(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("id = "+ userId +" 사용자가 없습니다. "));
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("id = "+ userId +" 사용자가 없습니다. "));
        return new UserResponseDto(user);
    }

}
