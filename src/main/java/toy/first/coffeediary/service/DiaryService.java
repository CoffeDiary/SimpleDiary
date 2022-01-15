package toy.first.coffeediary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.first.coffeediary.config.auth.PrincipalDetails;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.diary.DiaryRepository;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.recipe.RecipeRepository;
import toy.first.coffeediary.domain.user.User;
import toy.first.coffeediary.domain.user.UserRepository;
import toy.first.coffeediary.web.dto.diary.DiaryListResponseDto;
import toy.first.coffeediary.web.dto.diary.DiaryResponseDto;
import toy.first.coffeediary.web.dto.diary.DiarySaveRequestDto;
import toy.first.coffeediary.web.dto.diary.DiaryUpdateRequestDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 자바 주석을 달면 스웨거에 적용이 될까?
 */
@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(DiarySaveRequestDto requestDto){
        /**
         * 자바 주석을 달면 스웨거에 적용이 될까?
         */
        System.out.println("requestDto = " + requestDto);
        Long recipeId = recipeRepository.save(requestDto.toRecipeEntity()).getRecipeId();
        Long diaryId = diaryRepository.save(requestDto.toDiaryEntity()).getDiaryId();
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        Optional<Diary> diary = diaryRepository.findById(diaryId);
        Optional<User> user = userRepository.findById(requestDto.getUserId());
        recipe.get().setUser(user.get());
        diary.get().setRecipe(recipe.get());
        diary.get().setUser(user.get());
        return diaryId;
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

    @Transactional(readOnly = true)
    public List<Diary> myDiary(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        Optional<User> userOptional = userRepository.findById(principal.getUser().getUserId());
        return userOptional.get().getDiaries();
    }
}
