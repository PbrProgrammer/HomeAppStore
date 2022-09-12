package net.fakour.homeappliances.dto;

import net.fakour.homeappliances.entity.HomeAppliancesEntity;


import java.util.List;
import java.util.Map;

public class ResponsUserDto {

    Map<HomeAppliancesEntity, List<Comment1>> userResponseComment;

    public Map<HomeAppliancesEntity, List<Comment1>> getUserResponseComment() {
        return userResponseComment;
    }

    public void setUserResponseComment(Map<HomeAppliancesEntity, List<Comment1>> userResponseComment) {
        this.userResponseComment = userResponseComment;
    }
}
