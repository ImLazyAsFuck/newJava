package bussiness.service.departmentService;

import bussiness.model.departmentModel.Department;
import bussiness.service.BaseService;

public interface DepartmentService extends BaseService<Department>{
    Department findDepartment (String departmentName);
}
