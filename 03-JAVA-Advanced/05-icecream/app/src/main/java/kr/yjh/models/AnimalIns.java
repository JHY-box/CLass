package kr.yjh.models;

import lombok.Data;

@Data
public class AnimalIns {
    
    private String animalId;
    private String animalType;
    private String datetime;
    private String intakeCondition;
    private String name;
    private String sexUponIntake;

}
