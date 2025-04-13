package bussiness.model.departmentModel;

import bussiness.model.Inputable;
import bussiness.model.LengthConstraint;
import validator.BooleanValidator;
import validator.StringValidator;

import java.util.Scanner;

public class Department implements Inputable{
    private static int ID_SEQUENCE = 0;
    private int departmentId;
    private String departmentName;
    private String departmentDescription;
    private boolean departmentStatus;

    public Department(String departmentName, String departmentDescription, boolean departmentStatus){
        this.departmentId = ++ID_SEQUENCE;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentStatus = departmentStatus;
    }

    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }

    public Department(){
        this.departmentId = ++ID_SEQUENCE;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription(){
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription){
        this.departmentDescription = departmentDescription;
    }

    public boolean isDepartmentStatus(){
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus){
        this.departmentStatus = departmentStatus;
    }

    @Override
    public void inputData(Scanner input){
        this.departmentName = inputDepartmentName(input);
        this.departmentDescription = inputDepartmentDescription(input);
        this.departmentStatus = inputDepartmentStatus(input);
    }

    public String inputDepartmentName(Scanner input){
        return StringValidator.validate(input, "Enter the department name: ", new LengthConstraint(10, 100));
    }

    public String inputDepartmentDescription(Scanner input){
        return StringValidator.validate(input, "Enter the department description: ", new LengthConstraint(0, 255));
    }

    public boolean inputDepartmentStatus(Scanner input){
        return BooleanValidator.validateBoolean(input, "Enter the department status: ");
    }

    @Override
    public String toString(){
        return "ID: " + this.departmentId + " Name: " + this.departmentName + " Description: " + this.departmentDescription + " Status: " + (this.departmentStatus? "ACTIVE" : "INACTIVE");
    }
}
