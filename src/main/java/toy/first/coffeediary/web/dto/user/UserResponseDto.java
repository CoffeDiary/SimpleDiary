package toy.first.coffeediary.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;
import toy.first.coffeediary.web.dto.diary.DiaryListResponseDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String nickName;
    private List<Diary> diaries;
    private List<Recipe> recipes;

    public UserResponseDto(User user){

        this.userId = user.getUserId();
        this.nickName = user.getNickName();
        this.diaries = user.getDiaries();
        this.recipes = user.getRecipes();
    }
}
