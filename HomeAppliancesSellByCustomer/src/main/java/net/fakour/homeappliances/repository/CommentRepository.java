package net.fakour.homeappliances.repository;

import net.fakour.homeappliances.entity.Comment1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment1,Long> {


    List<Comment1> findAllByNameAndCode(String name,String code);


}
