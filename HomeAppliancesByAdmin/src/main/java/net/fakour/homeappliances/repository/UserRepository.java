package net.fakour.homeappliances.repository;

import net.fakour.homeappliances.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUsernameAndAndPassword(String username, String password);

    UserEntity findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByToken(String token);



    @Transactional
    @Modifying
    @Query("update UserEntity c set c.token =:token where c.username =:username ")
    void updateToken(String username, String token);
}
