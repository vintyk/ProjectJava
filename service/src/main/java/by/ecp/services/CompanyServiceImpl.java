package by.ecp.services;

import by.ecp.RootConfig;
import by.ecp.db.CompanyDao;
import by.ecp.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 27.06.2017.
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl (CompanyDao companyDao){
        this.companyDao = companyDao;
    }
    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public Company findById(Long id) {
       return companyDao.findOne(id);
    }

    @Override
    public void save(Company company) {
        companyDao.save(company);
    }
}
