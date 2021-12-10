package toy.first.coffeediary.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import toy.first.coffeediary.service.DiaryService;
import toy.first.coffeediary.web.dto.DiaryListResponseDto;
import toy.first.coffeediary.web.dto.DiaryResponseDto;
import toy.first.coffeediary.web.dto.DiarySaveRequestDto;
import toy.first.coffeediary.web.dto.DiaryUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryApiContorller {

    private final DiaryService diaryService;

    @PostMapping("/api/diary")
    public Long save(@RequestBody DiarySaveRequestDto requestDto){

        return diaryService.save(requestDto);
    }

    @PutMapping("/api/diary/{id}")
    public Long update(@PathVariable Long id, @RequestBody DiaryUpdateRequestDto requestDto) {
        return diaryService.update(id, requestDto);
    }

    @DeleteMapping("/api/diary/{id}")
    public Long delete(@PathVariable Long id) {
        diaryService.delete(id);
        return id;
    }

    @GetMapping("/api/diary/{id}")
    public DiaryResponseDto findById(@PathVariable Long id) {
        return diaryService.findById(id);
    }

    @GetMapping("/api/diary/list")
    public List<DiaryListResponseDto> findAll() {
        return diaryService.findAllDesc();
    }
}
