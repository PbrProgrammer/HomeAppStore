package net.fakour.homeappliances.controller;

import net.fakour.homeappliances.dto.RequestUserDto;
import net.fakour.homeappliances.dto.ResponsUserDto;
import net.fakour.homeappliances.entity.HomeAppliancesEntity;
import net.fakour.homeappliances.service.HomeAppliancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class HomeAppliancesController {

    private final HomeAppliancesService homeAppliancesService;

    @Autowired
    public HomeAppliancesController(HomeAppliancesService homeAppliancesService) {
        this.homeAppliancesService = homeAppliancesService;
    }

    //----------------------- Enter product by admin

    @PostMapping("insertadmin")
    public HomeAppliancesEntity insertProductbyAdmin(@RequestBody RequestUserDto requestUserDto,@RequestHeader(value = "Token") String token){

        return homeAppliancesService.insertProductbyAdmin(requestUserDto,token);
    }

    @GetMapping("getall")
    public List<HomeAppliancesEntity> getAllProduct(@RequestBody RequestUserDto requestUserDto,@RequestHeader(value = "Token") String token){
        return homeAppliancesService.getAllProduct(requestUserDto,token);

    }

    @GetMapping("getbycategory")
    public List<HomeAppliancesEntity> getAllByCategoryPrice(@RequestBody RequestUserDto requestUserDto,@RequestHeader(value = "Token") String token){

        return homeAppliancesService.getAllByCategoryPrice(requestUserDto,token);
    }

    @GetMapping("filterbycatandpri")
    public List<HomeAppliancesEntity> getFilterPrice(@RequestParam(value = "cat") String category,@RequestParam(value = "pdown") BigDecimal down, @RequestParam(value = "pup")BigDecimal up,@RequestHeader(value = "Token") String token) {

        return homeAppliancesService.getFilterPrice(category,down,up,token);

    }

    @GetMapping("commentofproduct")
    public ResponsUserDto getCommentByProduct(
            @RequestParam(value = "product") String name,
            @RequestParam(value = "code")String code,@RequestHeader(value = "Token") String token) {

        return homeAppliancesService.getCommentByProduct(name, code,token);

    }

    @GetMapping("usersell")
    public HomeAppliancesEntity userDoChoiceProduct(@RequestBody RequestUserDto requestUserDto,@RequestHeader(value = "Token") String token){

        return homeAppliancesService.userDoChoiceProduct(requestUserDto,token);

    }

}
