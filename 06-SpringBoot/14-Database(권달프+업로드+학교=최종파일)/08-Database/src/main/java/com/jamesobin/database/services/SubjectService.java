package com.jamesobin.database.services;

import java.util.List;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Subject;

public interface SubjectService {
    public List<Subject> getList(Subject input) throws ServiceNoResultException, Exception;

    public Subject getItem(Subject input) throws ServiceNoResultException, Exception;

    public int getCount(Subject input) throws ServiceNoResultException, Exception;

    public Subject addItem(Subject input) throws ServiceNoResultException, Exception;

    public Subject editItem(Subject input) throws ServiceNoResultException, Exception;

    public int deleteItem(Subject input) throws ServiceNoResultException, Exception;
}
