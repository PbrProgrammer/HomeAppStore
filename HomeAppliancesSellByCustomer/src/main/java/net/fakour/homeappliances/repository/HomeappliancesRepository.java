package net.fakour.homeappliances.repository;

import net.fakour.homeappliances.entity.HomeAppliancesEntity;
import net.fakour.homeappliances.entity.Comment1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface HomeappliancesRepository extends JpaRepository<HomeAppliancesEntity,Long> {

    boolean existsByCode(String code);

    List<HomeAppliancesEntity> findAllByCategory(String category);

    List<HomeAppliancesEntity> findAllByCategoryOrderByPriceDesc(String category);

    List<HomeAppliancesEntity> findAllByCategoryOrderByPriceAsc(String category);

    List<HomeAppliancesEntity> findAllByPriceBetween(BigDecimal a , BigDecimal b);

    List<HomeAppliancesEntity> findAllByCategoryAndPriceBetween(String category,BigDecimal a , BigDecimal b);

    List<HomeAppliancesEntity> findAllByName(String name);

    HomeAppliancesEntity findByNameAndCode(String name,String code);

    HomeAppliancesEntity findByCode(String code);

    @Transactional
    @Modifying
    @Query("update HomeAppliancesEntity c set c.stock=:newNumberOfProducts  where c.code =:code")
    void updateNumberOfProducts(String code, int newNumberOfProducts);


//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update HomeAppliancesEntity c set c.comment1List=:comment1List  where c.code =:code")
//    void updateComment(String code, List<Comment1> comment1List);

//    @Transactional
//    @Modifying
//    @Query( "update HomeAppliancesEntity c set c.comments=concat_ws
//
//            ///(comments,",comment1") where c.code=:code")
//    void updateComeent(long code, Comment1 comment1);
}
