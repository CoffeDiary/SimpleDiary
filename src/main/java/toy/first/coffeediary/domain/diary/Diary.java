package toy.first.coffeediary.domain.diary;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.base.BaseTimeEntity;
import toy.first.coffeediary.domain.recipe.Recipe;
import toy.first.coffeediary.domain.user.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 데이터 베이스의 컬럼과 연결 userId == user_id
    private User user;

    @OneToOne
    private Recipe recipe;

    @Column(nullable = false)
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

    public void update(boolean secret, String title, String content) {
        this.secret = secret;
        this.title = title;
        this.content = content;
    }
}
