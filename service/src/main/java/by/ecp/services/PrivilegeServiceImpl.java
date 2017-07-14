package by.ecp.services;

import by.ecp.db.PrivilegeDao;
import by.ecp.entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    private  final PrivilegeDao privilegeDao;

    @Autowired
    public PrivilegeServiceImpl(PrivilegeDao privilegeDao){
        this.privilegeDao = privilegeDao;
    }

    @Override
    @LoggableOne
    public void save(Privilege privilege) {
        privilegeDao.save(privilege);
    }

    @Override
    @LoggableOne
    public Privilege findOne(Long id) {
        return privilegeDao.findOne(id);
    }

    @Override
    @Loggable
    public List<Privilege> findAll() {
        return privilegeDao.findAll();
    }


}
