package by.ecp.services;

import by.ecp.db.SystemUserDao;
import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import by.ecp.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SystemUser on 20.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final SystemUserDao systemUserDao;

    @Autowired
    public UserServiceImpl(SystemUserDao systemUserDao) {
        this.systemUserDao = systemUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        SystemUser foundSystemUser = systemUserDao.findByEmail(userEmail);
        if (foundSystemUser == null) {
            throw new UsernameNotFoundException("Такой E-Mail не найден в Базе Данных!");
        }
        return new User(foundSystemUser.getEmail(),
                foundSystemUser.getPasswordUser(),
                getUserAuthorities(foundSystemUser));
    }

    private Set<GrantedAuthority> getUserAuthorities(SystemUser systemUser) {
        Set<Privilege> roles = systemUser.getPrivilege();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Privilege role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNamePrivilege()));
        }
        return grantedAuthorities;
    }

    @Override
    public SystemUser findByEmail(String name) {
        return systemUserDao.findByEmail(name);
    }

    @Override
    @LoggableOne
    public void saveUser(
            String nameUser,
            Set<Long> privilegeSet,
            String family,
            String eMail,
            Gender gender,
            String pass) {
        systemUserDao.saveUser(
                nameUser,
                family,
                eMail,
                quickPasswordEncodingGenerator(pass),
                gender,
                privilegeSet
        );
    }

    @Override
    @Loggable
    public List<SystemUser> findAll() {
        return systemUserDao.findAll();
    }

    @Override
    @LoggableOne
    public SystemUser findById(Long id) {
        return systemUserDao.findOne(id);
    }

    public String quickPasswordEncodingGenerator(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
