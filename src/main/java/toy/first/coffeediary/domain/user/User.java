package toy.first.coffeediary.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.recipe.Recipe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * User의 참조키를 가지고 있는 Diary 클래스에서 User 객체의 이름
 * mappedby 'user' user 라는 이름이로 엮여있다.
 * new ArrayList<>()를 하는 것이 관례
 */
@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(length = 20, nullable = false)
    private String nickName;
    private String userName;
    private String password;
    private String eMail;
    private String roles;
    @OneToMany(mappedBy = "user")
    private List<Diary> diaries = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes = new ArrayList<>();

    @Builder
    public User(String nickName, String eMail, String role,String password, String userName) {
        this.nickName = nickName;
        this.userName = userName;
        this.eMail = eMail;
        this.roles = role;
        this.password = password;
    }

    public void initPassword(String password) {
        this.password = password;
    }
    public void initRoles(String roles){
        this.roles = roles;
    }
    public void update(String nickName) {
        this.nickName = nickName;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
