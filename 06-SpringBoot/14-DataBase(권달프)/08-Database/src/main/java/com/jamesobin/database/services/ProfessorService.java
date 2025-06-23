package com.jamesobin.database.services;

import java.util.List;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Professor;

public interface ProfessorService {
    public List<Professor> getList(Professor input) throws ServiceNoResultException, Exception;

    public Professor getItem(Professor input) throws ServiceNoResultException, Exception;

    public int getCount(Professor input) throws ServiceNoResultException, Exception;

    public Professor addItem(Professor input) throws ServiceNoResultException, Exception;

    public Professor editItem(Professor input) throws ServiceNoResultException, Exception;

    public int deleteItem(Professor input) throws ServiceNoResultException, Exception;
}
