package toy.first.coffeediary.domain.recipe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toy.first.coffeediary.domain.coffee.Coffee;
import toy.first.coffeediary.domain.base.BaseTimeEntity;
import toy.first.coffeediary.domain.diary.Diary;
import toy.first.coffeediary.domain.grinder.Grinder;
import toy.first.coffeediary.domain.user.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id") // 데이터 베이스의 컬럼과 연결 userId == user_id
    private User user;

    /**
     * 추후 개발할 내용들
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "grinder_id")
    Grinder grinder;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "coffee_id")
    Coffee coffee;
    */
    private float coffeeAmount;
    private int grindingPoint;
    private int waterDegree;
    private int waterAmount;

    private String coffeeBean;

    @Builder
    public Recipe(float coffeeAmount, int grindingPoint,int waterDegree, int waterAmount, String coffeeBean){
        this.coffeeAmount = coffeeAmount;
        this.grindingPoint = grindingPoint;
        this.waterDegree = waterDegree;
        this.waterAmount = waterAmount;
        this.coffeeBean = coffeeBean;
    }

    public void update(float coffeeAmount, int grindingPoint,int waterDegree, int waterAmount, String coffeeBean){
        this.coffeeAmount = coffeeAmount;
        this.grindingPoint = grindingPoint;
        this.waterDegree = waterDegree;
        this.waterAmount = waterAmount;
        this.coffeeBean = coffeeBean;
    }
}
