package bussiness.service.departmentService;

import bussiness.model.departmentModel.Department;
import bussiness.service.AppService;

public interface DepartmentService extends AppService{
    Department findDepartment (String departmentName);
}
