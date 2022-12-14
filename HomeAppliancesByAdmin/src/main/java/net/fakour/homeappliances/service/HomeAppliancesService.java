package net.fakour.homeappliances.service;

import net.fakour.homeappliances.dto.RequestUserDto;
import net.fakour.homeappliances.dto.ResponsUserDto;
import net.fakour.homeappliances.entity.HomeAppliancesEntity;

import java.math.BigDecimal;
import java.util.List;

public interface HomeAppliancesService {

    HomeAppliancesEntity insertProductbyAdmin(RequestUserDto requestUserDto,String token);

    List<HomeAppliancesEntity> getAllProduct(RequestUserDto requestUserDto,String token);

}
