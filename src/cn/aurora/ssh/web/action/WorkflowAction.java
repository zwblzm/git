package cn.aurora.ssh.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.repository.Deployment;

import cn.aurora.ssh.service.ILeaveBillService;
import cn.aurora.ssh.service.IWorkflowService;
import cn.aurora.ssh.utils.ValueContext;
import cn.aurora.ssh.web.form.WorkflowBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class WorkflowAction extends ActionSupport implements ModelDriven<WorkflowBean> {

	private WorkflowBean workflowBean = new WorkflowBean();
	
	@Override
	public WorkflowBean getModel() {
		return workflowBean;
	}
	
	private IWorkflowService workflowService;
	
	private ILeaveBillService leaveBillService;

	public void setLeaveBillService(ILeaveBillService leaveBillService) {
		this.leaveBillService = leaveBillService;
	}

	public void setWorkflowService(IWorkflowService workflowService) {
		this.workflowService = workflowService;
	}

	/**
	 * 部署管理首页显示
	 * @return
	 */
	public String deployHome(){
		List<Deployment> deployments = workflowService.findDeploymentAll();
		ValueContext.putValueContext("deployments", deployments);
		return "deployHome";
	}
	
	/**
	 * 发布流程
	 * @return
	 */
	public String newdeploy(){
		
		File file = workflowBean.getFile();
		String fileName = workflowBean.getFilename();
		ZipInputStream in;
		try {
			in = new ZipInputStream(new FileInputStream(file));
			workflowService.saveDeployByZIP(in,fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "list";
	}
	
	/**
	 * 删除部署信息
	 */
	public String delDeployment(){
		return "list";
	}
	
	/**
	 * 查看流程图
	 */
	public String viewImage(){
		return null;
	}
	
	// 启动流程
	public String startProcess(){
		return "listTask";
	}
	
	
	
	/**
	 * 任务管理首页显示
	 * @return
	 */
	public String listTask(){
		return "task";
	}
	
	/**
	 * 打开任务表单
	 */
	public String viewTaskForm(){
		return "viewTaskForm";
	}
	
	// 准备表单数据
	public String audit(){
		return "taskForm";
	}
	
	/**
	 * 提交任务
	 */
	public String submitTask(){
		return "listTask";
	}
	
	/**
	 * 查看当前流程图（查看当前活动节点，并使用红色的框标注）
	 */
	public String viewCurrentImage(){
		return "image";
	}
	
	// 查看历史的批注信息
	public String viewHisComment(){
		return "viewHisComment";
	}
}
