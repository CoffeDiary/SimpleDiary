package toy.first.coffeediary.domain.diary;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 데이터 베이스의 컬럼과 연결 userId == USER_ID
    private User user;

    @OneToOne
    private Recipe recipe;

    private boolean secret;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Diary(boolean secret, String title, String content){
        this.secret = secret;
        this.title = title;
        this.content = content;
    }
}
