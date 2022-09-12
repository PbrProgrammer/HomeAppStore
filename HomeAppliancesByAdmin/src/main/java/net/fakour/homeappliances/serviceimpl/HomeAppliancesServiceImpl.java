package net.fakour.homeappliances.serviceimpl;

import net.fakour.homeappliances.dto.RequestUserDto;
import net.fakour.homeappliances.dto.ResponsUserDto;
import net.fakour.homeappliances.entity.HomeAppliancesEntity;
import net.fakour.homeappliances.repository.CommentRepository;
import net.fakour.homeappliances.repository.HomeappliancesRepository;
import net.fakour.homeappliances.repository.UserRepository;
import net.fakour.homeappliances.service.HomeAppliancesService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeAppliancesServiceImpl implements HomeAppliancesService {


    private final HomeappliancesRepository homeappliancesRepository;

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    public HomeAppliancesServiceImpl(HomeappliancesRepository homeappliancesRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.homeappliancesRepository = homeappliancesRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    //---------------------------Enter product by admin

    //static List<Comment1> comUpdate=new ArrayList<>();

//    public HomeAppliancesEntity insertProductbyAdmin(RequestUserDto requestUserDto) {
//
//        if(homeappliancesRepository.existsByCode(requestUserDto.getHomeAppliancesEntity().getCode())){
//
//            for (HomeAppliancesEntity obj:
//            homeappliancesRepository.findAll()) {
//                if(requestUserDto.getHomeAppliancesEntity().getCode().equals(obj.getCode())) {
//                  //  comUpdate =  obj.getComments();
//                    System.out.println(comUpdate.get(0).getComment());
//                }
//            }
//            //comUpdate.addAll(requestUserDto.getHomeAppliancesEntity().getComments());
//            System.out.println(comUpdate.get(3).getComment());
//           // homeappliancesRepository.updateComment(requestUserDto.getHomeAppliancesEntity().getCode(),comUpdate);
//
//            return requestUserDto.getHomeAppliancesEntity();
//            }  else if ( requestUserDto.getUserEntity().getUsername().equals("admin")) {  ///userRepository.existsByToken(requestUserDto.getUserEntity().getToken()) &&
//            return homeappliancesRepository.save(requestUserDto.getHomeAppliancesEntity());
//        }
//
//       return null;
//    }


    public HomeAppliancesEntity insertProductbyAdmin(RequestUserDto requestUserDto,String token) {

        if(userRepository.existsByToken(token)) {

            if (homeappliancesRepository.existsByCode(requestUserDto.getHomeAppliancesEntity().getCode())) {

                commentRepository.saveAll(requestUserDto.getComment1());
                return requestUserDto.getHomeAppliancesEntity();
            }
            //  homeappliancesRepository.updateComment(requestUserDto.getHomeAppliancesEntity().getCode(), requestUserDto.getHomeAppliancesEntity().getComment1List());

            else if (requestUserDto.getUserEntity().getUsername().equals("admin")) {

                commentRepository.saveAll(requestUserDto.getComment1());
                return homeappliancesRepository.save(requestUserDto.getHomeAppliancesEntity());

            }
        }
        return null;
    }

    public List<HomeAppliancesEntity> getAllProduct(RequestUserDto requestUserDto,String token) {

        if(userRepository.existsByToken(token)) {
            return homeappliancesRepository.findAllByCategory(requestUserDto.getHomeAppliancesEntity().getCategory());
        }
        return null;
    }


}

