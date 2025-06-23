package com.jamesobin.database.services;

import java.util.List;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Department;

public interface DepartmentService {
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception;

    public Department getItem(Department input) throws ServiceNoResultException, Exception;

    public int getCount(Department input) throws ServiceNoResultException, Exception;

    public Department addItem(Department input) throws ServiceNoResultException, Exception;

    public Department editItem(Department input) throws ServiceNoResultException, Exception;

    public int deleteItem(Department input) throws ServiceNoResultException, Exception;
}
