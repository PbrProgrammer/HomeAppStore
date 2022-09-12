package net.fakour.homeappliances.serviceimpl;

import net.fakour.homeappliances.entity.UserEntity;
import net.fakour.homeappliances.repository.UserRepository;
import net.fakour.homeappliances.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService {

    private UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(UserEntity userEntity){

           final int MAX = 10;
           final int MIN_Uppercase = 1;
           int uppercaseCounter = 0;
           int digitCounter = 0;
           int specialCounter = 0;

           String password = userEntity.getPassword();
           String output = null;

           for (int i = 0; i < password.length(); i++) {
               char c = password.charAt(i);
               if (Character.isUpperCase(c))
                   uppercaseCounter++;
               else if (Character.isDigit(c))
                   digitCounter++;
               if (c == '$' || c == '#' || c == '?' || c == '!' || c == '_' || c == '=' || c == '%' || c == '@') {
                   specialCounter++;
               }
           }
           String username = userEntity.getUsername();

           if (specialCounter == 1 && password.length() >= MAX && uppercaseCounter >= MIN_Uppercase && digitCounter >= 2 && !username.equals("") && !userRepository.existsByUsername(userEntity.getUsername())) {

               userRepository.save(userEntity);
               return "User name and Password is Valid  \n" +
                       "Register successful";
           } else {
               output = "Your password our username does not contain the following: ";

               if (userRepository.existsByUsername(userEntity.getUsername()))
                   output = output + "\n User name is already taken \n Enter another user name ";
               if (username.length() < 3 && username.equals(""))
                   output = output + "\n Enter user name atleast 3 characters";
               if (password.length() < MAX)
                   output = output + "\n Enter password atleast 10 characters";
               if (uppercaseCounter < MIN_Uppercase)
                   output = output + "\n Enter password at least 1 uppercase character";
               if (digitCounter <= 2)
                   output = output + "\n Enter password either 2 or 3 digits";
               if (specialCounter < 1)
                   output = output + "\n Password should contain only 1 special characters such as \"!,@,#,$,%,^,&,*\"";
           }
           return output;
       }



    public UserEntity login(UserEntity users) {

        if (userRepository.findByUsernameAndAndPassword(users.getUsername(), users.getPassword()) != null) {
            String token=givenTokenUserToNextLogin();
            userRepository.updateToken(users.getUsername(),token);
            users.setToken(token);
            return users;
        }
        return null;

    }
    public String givenTokenUserToNextLogin() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 16;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
