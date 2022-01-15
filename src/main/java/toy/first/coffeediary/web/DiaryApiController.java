package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import toy.first.coffeediary.config.auth.PrincipalDetails;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.service.DiaryService;
import toy.first.coffeediary.service.UserService;
import toy.first.coffeediary.web.dto.diary.DiaryListResponseDto;
import toy.first.coffeediary.web.dto.diary.DiaryResponseDto;
import toy.first.coffeediary.web.dto.diary.DiarySaveRequestDto;
import toy.first.coffeediary.web.dto.diary.DiaryUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/diary")
public class DiaryApiController {
    private final UserService userService;
    private final DiaryService diaryService;

    @PostMapping
    public Long save(@RequestBody DiarySaveRequestDto requestDto, Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        //
        requestDto.addUserInfo(authentication);
        //
        return diaryService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody DiaryUpdateRequestDto requestDto) {
        return diaryService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        diaryService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public DiaryResponseDto findById(@PathVariable Long id) {
        return diaryService.findById(id);
    }
    @GetMapping("/mylist")
    public List<Diary> findMine(Authentication authentication){
        return diaryService.myDiary(authentication);
    }
    @GetMapping("/list")
    public List<DiaryListResponseDto> findAll() {
        return diaryService.findAllDesc();
    }
}
