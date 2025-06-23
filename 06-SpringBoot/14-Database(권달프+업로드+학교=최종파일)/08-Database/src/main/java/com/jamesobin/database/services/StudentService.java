package com.jamesobin.database.services;

import java.util.List;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Student;

public interface StudentService {
    public List<Student> getList(Student input) throws ServiceNoResultException, Exception;

    public Student getItem(Student input) throws ServiceNoResultException, Exception;

    public int getCount(Student input) throws ServiceNoResultException, Exception;

    public Student addItem(Student input) throws ServiceNoResultException, Exception;

    public Student editItem(Student input) throws ServiceNoResultException, Exception;

    public int deleteItem(Student input) throws ServiceNoResultException, Exception;
}
