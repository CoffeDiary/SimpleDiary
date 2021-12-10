package toy.first.coffeediary.domain.grinder;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Grinder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grinderId;

    private String grinderName;

    private int grinderRange;

    @Builder
    public Grinder(String grinderName, int grinderRange){
        this.grinderName = grinderName;
        this.grinderRange = grinderRange;
    }
}
