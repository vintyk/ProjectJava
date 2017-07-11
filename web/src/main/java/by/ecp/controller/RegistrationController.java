package by.ecp.controller;

import by.ecp.dto.SystemUserDto;
import by.ecp.entity.Gender;
import by.ecp.services.PrivilegeService;
import by.ecp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vinty on 02.07.2017.
 */
@Controller
public class RegistrationController {

    private final UserService userService;
    private final PrivilegeService privilegeService;

    @Autowired
    public RegistrationController(UserService userService, PrivilegeService privilegeService){
        this.userService = userService;
        this.privilegeService = privilegeService;
    }
    @ModelAttribute("systemUsersDto")
    public SystemUserDto systemUsersDto() {
        return new SystemUserDto();
    }

    @ModelAttribute("genders")
    public List<Gender> genders() {
        return Arrays.asList(Gender.values());
    }

    @GetMapping(path = "/registration")
    public  String showRegistrationForm(){
        return "Registration";
    }

    @PostMapping(path = "/registration")
    public String tempSystemUsersDto(SystemUserDto systemUsersDto, Model model){

        Set<Long> privilegeSet = new HashSet<>();
        privilegeSet.add(2L);
        userService.saveUser(
                systemUsersDto.getNameUser(),
                privilegeSet,
                systemUsersDto.getFamilyUser(),
                systemUsersDto.getEmail(),
                systemUsersDto.getGender(),
                systemUsersDto.getPasswordUser()
        );
        return "/Registration";
    }
}
