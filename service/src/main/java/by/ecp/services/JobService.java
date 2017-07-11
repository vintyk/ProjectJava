package by.ecp.services;


import by.ecp.entity.Job;

import java.util.List;

/**
 * Created by SystemUser on 28.06.2017.
 */
public interface JobService {

    void save(Job job);

    List<Job> findAll();

}
