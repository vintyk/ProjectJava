package by.ecp.services;

import by.ecp.entity.Company;

import java.util.List;

/**
 * Created by User on 27.06.2017.
 */
public interface CompanyService {
    List<Company> findAll();
}