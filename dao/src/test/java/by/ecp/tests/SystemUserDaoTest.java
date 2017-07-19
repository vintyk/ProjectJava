package by.ecp.tests;

import by.ecp.db.PrivilegeDao;
import by.ecp.db.SystemUserDao;
import by.ecp.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vinty on 18.06.2017.
 */
public class SystemUserDaoTest extends BaseTest {

    @Autowired
    private PrivilegeDao privilegeDao;
    @Autowired
    private SystemUserDao systemUserDao;

    @Test
    public void getByEmailTest() {

        Privilege privilege1 = new Privilege();
        privilege1.setNamePrivilege("Admin");
        privilegeDao.save(privilege1);
        Privilege privilege2 = new Privilege();
        privilege2.setNamePrivilege("User");
        privilegeDao.save(privilege2);
        Set<Long> privilegeLongs = new HashSet<>();
        privilegeLongs.add(1L);
        privilegeLongs.add(2L);
        systemUserDao.saveUser(
                "MeeMo",
                "Loo_Lee",
                "MeeMo@gmail.com",
                "qwerty2",
                Gender.MALE,
                privilegeLongs
        );
        SystemUser systemUser = systemUserDao.findByEmail("MeeMo@gmail.com");
        System.out.println(systemUser);
        assertEquals(systemUser.getEmail(), "MeeMo@gmail.com");
    }

    @Test
    public void saveUser() {
        Address address = new Address();
        address.setCity("Minsk");
        address.setCountry("RB");
        Privilege privilege1 = new Privilege();
        privilege1.setNamePrivilege("Admin");
        privilegeDao.save(privilege1);
        Privilege privilege2 = new Privilege();
        privilege2.setNamePrivilege("User");
        privilegeDao.save(privilege2);
        Set<Long> privilegeLongs = new HashSet<>();
        privilegeLongs.add(1L);
        privilegeLongs.add(2L);
        systemUserDao.saveUser(
                "MeeMo",
                "Loo_Lee",
                "MeeMo@gmail.com",
                "qwerty2",
                Gender.MALE,
                privilegeLongs
        );
        List<SystemUser> result = systemUserDao.findAll();
        System.out.println(result);
        assertNotNull(result);
    }
}

