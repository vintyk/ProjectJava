package by.ecp.tests;

import by.ecp.dto.SystemUserDto;
import by.ecp.entity.Gender;
import by.ecp.entity.SystemUser;
import by.ecp.services.PrivilegeService;
import by.ecp.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PrivilegeService privilegeService;


    @Test
    public void testSaveFindUser() {
        SystemUserDto systemUsersDto = new SystemUserDto();
        systemUsersDto.setNameUser("VVV");
        systemUsersDto.setFamilyUser("xxx");
        systemUsersDto.setEmail("vvv@vvv.by");
        systemUsersDto.setGender(Gender.MALE);
        systemUsersDto.setPasswordUser("1");
        Set<Long> privilegeSet = new HashSet<>();
        privilegeSet.add(1L);
        userService.saveUser(
                systemUsersDto.getNameUser(),
                privilegeSet,
                systemUsersDto.getFamilyUser(),
                systemUsersDto.getEmail(),
                systemUsersDto.getGender(),
                systemUsersDto.getPasswordUser()
        );
        SystemUser systemUser = userService.findById(1L);
        assertThat(systemUser, notNullValue());
        List<SystemUser> systemUser1 = userService.findAll();
        assertThat(systemUser1, notNullValue());
    }
    @Test
    public void findByEmail(){
        SystemUserDto systemUsersDto = new SystemUserDto();
        systemUsersDto.setNameUser("VVV2");
        systemUsersDto.setFamilyUser("xxx2");
        systemUsersDto.setEmail("vvv@vvv2.by");
        systemUsersDto.setGender(Gender.MALE);
        systemUsersDto.setPasswordUser("2");
        Set<Long> privilegeSet = new HashSet<>();
        privilegeSet.add(1L);
        userService.saveUser(
                systemUsersDto.getNameUser(),
                privilegeSet,
                systemUsersDto.getFamilyUser(),
                systemUsersDto.getEmail(),
                systemUsersDto.getGender(),
                systemUsersDto.getPasswordUser()
        );
        userService.findByEmail("vvv@vvv2.by");
        assertEquals(systemUsersDto.getEmail(), "vvv@vvv2.by");
    }
}

