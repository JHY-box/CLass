package kr.yjh.services;

import java.util.List;

import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Professors;

public interface ProfessorsService {
    public List<Professors> getList(Professors params) throws ServiceNoResultException, Exception;

    public Professors getItem(Professors params) throws ServiceNoResultException, Exception;

    public Professors addItem(Professors params) throws ServiceNoResultException, Exception;

    public Professors editItem(Professors params) throws ServiceNoResultException, Exception;

    public int deleteItem(Professors params) throws ServiceNoResultException, Exception;

    public int getCount(Professors params) throws ServiceNoResultException, Exception;
}


