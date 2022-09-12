package net.fakour.homeappliances.serviceimpl;

import net.fakour.homeappliances.dto.RequestUserDto;
import net.fakour.homeappliances.dto.ResponsUserDto;
import net.fakour.homeappliances.entity.Comment1;
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


    public List<HomeAppliancesEntity> getAllProduct(RequestUserDto requestUserDto,String token) {

        if(userRepository.existsByToken(token)) {
            return homeappliancesRepository.findAllByCategory(requestUserDto.getHomeAppliancesEntity().getCategory());
        }
        return null;
    }

    public List<HomeAppliancesEntity> getAllByCategoryPrice(RequestUserDto requestUserDto,String token) {

        if (userRepository.existsByToken(token)) {
            return homeappliancesRepository.findAllByCategoryOrderByPriceDesc(requestUserDto.getHomeAppliancesEntity().getCategory());
        }
        return null;
    }


    public List<HomeAppliancesEntity> getFilterPrice(String category, BigDecimal down, BigDecimal up,String token) {

        if(userRepository.existsByToken(token)) {
            return homeappliancesRepository.findAllByCategoryAndPriceBetween(category,down,up);

      }
        return null;
       }

    public ResponsUserDto getCommentByProduct(String name, String code,String token) {

        if (userRepository.existsByToken(token)) {
            ResponsUserDto responsUserDto = new ResponsUserDto();
            Map<HomeAppliancesEntity, List<Comment1>> userResponseComment = new HashMap<>();

            userResponseComment.put(homeappliancesRepository.findByNameAndCode(name, code), commentRepository.findAllByNameAndCode(name, code));

            responsUserDto.setUserResponseComment(userResponseComment);
            return responsUserDto;
        }
        return null;
    }

    public HomeAppliancesEntity userDoChoiceProduct(RequestUserDto requestUserDto,String token) {
        if (userRepository.existsByToken(token)) {
            int stuckOfP = homeappliancesRepository.findByCode(requestUserDto.getHomeAppliancesEntity().getCode()).getStock();
            stuckOfP = stuckOfP - (requestUserDto.getNumberOfProducts());

            homeappliancesRepository.updateNumberOfProducts(homeappliancesRepository.findByCode(requestUserDto.getHomeAppliancesEntity().getCode()).getCode(), stuckOfP);

            return homeappliancesRepository.findByCode(requestUserDto.getHomeAppliancesEntity().getCode());
        }
        return null;
    }
}

