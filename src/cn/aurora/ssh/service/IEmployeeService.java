package cn.aurora.ssh.service;

import cn.aurora.ssh.domain.Employee;


public interface IEmployeeService {

	Employee findEmployeeByName(String name);


}
