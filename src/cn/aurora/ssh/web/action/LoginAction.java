package cn.aurora.ssh.web.action;

import cn.aurora.ssh.domain.Employee;
import cn.aurora.ssh.service.IEmployeeService;
import cn.aurora.ssh.utils.SessionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<Employee> {

	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {
		return employee;
	}
	
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	/**
	 * 登录
	 * @return
	 */
	public String login(){
		String name = employee.getName();
		if(name!=null) {
			
			Employee currentUser = employeeService.findEmployeeByName(name);
			if(currentUser!=null) {
				SessionContext.setUser(currentUser);
				return "success";
				
			}
		}
		
		
		
		
		return "login";
	}
	
	/**
	 * 标题
	 * @return
	 */
	public String top() {
		return "top";
	}
	
	/**
	 * 左侧菜单
	 * @return
	 */
	public String left() {
		return "left";
	}
	
	/**
	 * 主页显示
	 * @return
	 */
	public String welcome() {
		return "welcome";
	}
	
	public String logout(){
		return "login";
	}
}
