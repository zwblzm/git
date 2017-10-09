package cn.aurora.ssh.service.impl;

import cn.aurora.ssh.dao.IEmployeeDao;
import cn.aurora.ssh.domain.Employee;
import cn.aurora.ssh.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDao;

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee findEmployeeByName(String name) {
		if(name!=null) {
			
			Employee currentUser = employeeDao.findEmployeeByName(name);
			return currentUser;
			
		}
		return null;
	}
	
	
}
