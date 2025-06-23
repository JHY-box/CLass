package kr.yjh.services;

import java.util.List;

import kr.yjh.models.AnimalIns;


public interface AnimalInsService {
    
    public List<AnimalIns> getList(AnimalIns input) throws Exception;

    public int getCount(AnimalIns input) throws Exception;
 
    public AnimalIns getItem(AnimalIns input) throws Exception;

    public AnimalIns addItem(AnimalIns input) throws Exception;

    public AnimalIns editItem(AnimalIns input) throws Exception;

    public int deleteItem(AnimalIns input) throws Exception;
    

    

}
