package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import toy.first.coffeediary.service.DiaryService;
import toy.first.coffeediary.web.dto.diary.DiaryListResponseDto;
import toy.first.coffeediary.web.dto.diary.DiaryResponseDto;
import toy.first.coffeediary.web.dto.diary.DiarySaveRequestDto;
import toy.first.coffeediary.web.dto.diary.DiaryUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/diary")
public class DiaryApiController {

    private final DiaryService diaryService;

    @PostMapping
    public Long save(@RequestBody DiarySaveRequestDto requestDto){

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

    @GetMapping("/list")
    public List<DiaryListResponseDto> findAll() {
        return diaryService.findAllDesc();
    }
}