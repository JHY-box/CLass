package com.jamesobin.database.services;

import java.util.List;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Enrollment;

public interface EnrollmentService {
    public List<Enrollment> getList(Enrollment input) throws ServiceNoResultException, Exception;

    public Enrollment getItem(Enrollment input) throws ServiceNoResultException, Exception;

    public int getCount(Enrollment input) throws ServiceNoResultException, Exception;

    public Enrollment addItem(Enrollment input) throws ServiceNoResultException, Exception;

    public Enrollment editItem(Enrollment input) throws ServiceNoResultException, Exception;

    public int deleteItem(Enrollment input) throws ServiceNoResultException, Exception;
}
