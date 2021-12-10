package toy.first.coffeediary.domain.diary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    @Query("SELECT p FROM Diary p ORDER BY p.createdDate DESC")
    List<Diary> findAllDesc();
}
