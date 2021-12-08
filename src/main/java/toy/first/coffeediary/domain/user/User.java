package toy.first.coffeediary.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * new ArrayList<>()를 하는 것이 관례
     */

    /**
     *  User의 참조키를 가지고 있는 Diary 클래스에서 User 객체의 이름
     *  mappedby 'user' user 라는 이름이로 엮여있다.
     */
    @OneToMany(mappedBy = "user")
    private List<Diary> diaries = new ArrayList<>();

    @Column(length = 20, nullable = false)
    private String nickName;

    @Builder
    public User(String nickName){
        this.nickName = nickName;
    }
}
