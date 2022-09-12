package net.fakour.homeappliances.dto;

import net.fakour.homeappliances.entity.Comment1;
import net.fakour.homeappliances.entity.HomeAppliancesEntity;
import net.fakour.homeappliances.entity.UserEntity;
import org.apache.catalina.LifecycleState;

import java.util.List;

public class RequestUserDto {

    private UserEntity userEntity;

    private HomeAppliancesEntity homeAppliancesEntity;

    private List<Comment1> comment1;

    private int numberOfProducts;

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public List<Comment1> getComment1() {
        return comment1;
    }

    public void setComment1(List<Comment1> comment1) {
        this.comment1 = comment1;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public HomeAppliancesEntity getHomeAppliancesEntity() {
        return homeAppliancesEntity;
    }

    public void setHomeAppliancesEntity(HomeAppliancesEntity homeAppliancesEntity) {
        this.homeAppliancesEntity = homeAppliancesEntity;
    }
}
