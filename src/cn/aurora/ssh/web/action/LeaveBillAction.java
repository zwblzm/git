package cn.aurora.ssh.web.action;

import java.util.List;

import cn.aurora.ssh.domain.Employee;
import cn.aurora.ssh.domain.LeaveBill;
import cn.aurora.ssh.service.ILeaveBillService;
import cn.aurora.ssh.utils.SessionContext;
import cn.aurora.ssh.utils.ValueContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class LeaveBillAction extends ActionSupport implements ModelDriven<LeaveBill> {

	private LeaveBill leaveBill = new LeaveBill();
	
	@Override
	public LeaveBill getModel() {
		return leaveBill;
	}
	
	private ILeaveBillService leaveBillService;

	public void setLeaveBillService(ILeaveBillService leaveBillService) {
		this.leaveBillService = leaveBillService;
	}

	/**
	 * 请假管理首页显示
	 * @return
	 */
	public String home(){
		Employee employee = SessionContext.get();
		List<LeaveBill> leaveBillList = leaveBillService.findLeaveBillListByEmployee(employee.getId());
		
		ValueContext.putValueContext("leaveBillList", leaveBillList);
		
		return "home";
	}
	
	/**
	 * 添加请假申请
	 * @return
	 */
	public String input(){
		return "input";
	}
	
	/**
	 * 保存/更新，请假申请
	 * 
	 * */
	public String save() {
		
		Long id = leaveBill.getId();
		if(id!=null) {
			
		}
		leaveBillService.saveLeaveBill(leaveBill);
		
		
		return "save";
	}
	
	/**
	 * 删除，请假申请
	 * 
	 * */
	public String delete(){
		return "save";
	}
	
}
