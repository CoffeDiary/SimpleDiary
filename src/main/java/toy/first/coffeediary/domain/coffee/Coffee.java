package toy.first.coffeediary.domain.coffee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.first.coffeediary.domain.coffee.enums.Process;
import toy.first.coffeediary.domain.coffee.enums.ProductionArea;
import toy.first.coffeediary.domain.coffee.enums.RoastingPoint;
import toy.first.coffeediary.domain.coffee.enums.Variety;
import toy.first.coffeediary.domain.store.Store;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeId;
    private String coffeeName;
    //Enum 으로 만들고 싶은뎅..
    @Enumerated(EnumType.STRING)
    private RoastingPoint roastingPoint;

    @Enumerated(EnumType.STRING)
    private Variety variety;

    @Enumerated(EnumType.STRING)
    private ProductionArea productionArea;

    @Enumerated(EnumType.STRING)
    private Process process;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Store store;
}
