package by.ecp;

import by.ecp.entity.Country;
import by.ecp.services.CountryService;
import by.ecp.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by User on 20.06.2017.
 */
public class Starter {
      public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);


        //        UserService userService = context.getBean(UserService.class);
//        userService.saveUser(
//                "Valera",
//                2L,
//                "Nechay",
//                "vn@ecp.by",
//                Gender.MALE,
//                "12345");
//
//        CountryService countryService = context.getBean(CountryService.class);
//        List<Country> countryList = countryService.findAll();
//        System.out.println(countryList);
//


//        UserService userService = context.getBean(UserService.class);
//        List<User> users = userService.findAll();
//        users.forEach(System.out::println);
//        System.out.println(userService.findById(1L));







//        Address address = new Address();
//        address.setCountry("РБ");
//        address.setCity("Минск");
//        Address address1 = new Address();
//        address1.setCountry("Великобритания");
//        address1.setCity("Лондон");
//        User user = new User();
//        user.setNameUser("Valera");
//        user.setFamilyUser("Nechay");
//        user.setPrivilege(privilege);
//        user.setFirstAddress(address);
//        user.setSecondAddress(address1);
//        user.setPasswordUser("12345");
//        user.setGender(Gender.MALE);
//        user.setemail("vn@ecp.by");
    }

}
