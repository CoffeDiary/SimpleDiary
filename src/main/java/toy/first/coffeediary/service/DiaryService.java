package toy.first.coffeediary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.diary.DiaryRepository;
import toy.first.coffeediary.web.dto.diary.DiaryListResponseDto;
import toy.first.coffeediary.web.dto.diary.DiaryResponseDto;
import toy.first.coffeediary.web.dto.diary.DiarySaveRequestDto;
import toy.first.coffeediary.web.dto.diary.DiaryUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Transactional
    public Long save(DiarySaveRequestDto requestDto){
        return diaryRepository.save(requestDto.toEntity()).getDiaryId();
    }

    @Transactional
    public Long update(Long diaryId, DiaryUpdateRequestDto requestDto){
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(()-> new IllegalArgumentException("id = "+ diaryId +" 사용자가 없습니다. "));
        diary.update(requestDto.isSecret(), requestDto.getTitle(), requestDto.getContent());
        return diaryId;
    }

    @Transactional
    public void delete(Long diaryId){
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new IllegalArgumentException("id = "+ diaryId +" 사용자가 없습니다. "));
        diaryRepository.delete(diary);
    }

    @Transactional(readOnly = true)
    public DiaryResponseDto findById(Long diaryId){
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new IllegalArgumentException("id = "+ diaryId +" 사용자가 없습니다. "));
        return new DiaryResponseDto(diary);
    }

    @Transactional(readOnly = true)
    public List<DiaryListResponseDto> findAllDesc(){
        return diaryRepository.findAllDesc().stream()
                .map(DiaryListResponseDto::new)
                .collect(Collectors.toList());
    }
}
