package toy.first.coffeediary.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void clean(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("JpaRepository 기본 기능을 확인해보자 1. save()")
    public void save(){
        //given
        String nickName = "lowkey";
        userRepository.save(User.builder()
                .nickName(nickName)
                .build());
        //when
        List<User> users = userRepository.findAll();
        //then
        User newUser = users.get(0);
        assertThat(newUser.getNickName()).isEqualTo(nickName);
    }
}