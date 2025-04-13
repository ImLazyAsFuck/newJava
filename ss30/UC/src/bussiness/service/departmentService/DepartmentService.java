package bussiness.service.departmentService;

import bussiness.model.departmentModel.Department;
import bussiness.service.AppService;

public interface DepartmentService extends AppService<Department>{
    Department findDepartment (String departmentName);
}
