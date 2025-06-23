package kr.yjh.database.services;

import java.util.List;

import kr.yjh.database.exceptions.ServiceNoResultException;
import kr.yjh.database.models.Professor;

public interface ProfessorService {
    public List<Professor> getList(Professor params) throws ServiceNoResultException, Exception;

    public Professor getItem(Professor params) throws ServiceNoResultException, Exception;

    public int addItem(Professor params) throws ServiceNoResultException, Exception;

    public Professor editItem(Professor params) throws ServiceNoResultException, Exception;

    public int deleteItem(Professor params) throws ServiceNoResultException, Exception;

    public int getCount(Professor params) throws ServiceNoResultException, Exception;
}


