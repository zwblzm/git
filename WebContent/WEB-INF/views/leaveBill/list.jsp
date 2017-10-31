<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/js/commons.jspf" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假管理</title>
</head>
<body>
 	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td width="6%" height="19" valign="bottom"><div align="center"><img src="${pageContext.request.contextPath }/images/tb.gif" width="14" height="14" /></div></td>
		                <td width="94%" valign="bottom"><span class="STYLE1">请假申请列表列表</span></td>
		              </tr>
		            </table></td>
		            <td><div align="right"><span class="STYLE1">
		              </span></div></td>
		          </tr>
		        </table></td>
		      </tr>
		    </table></td>
		  </tr>
		  <tr>
		        <td height="20" bgcolor="#FFFFFF" class="STYLE10" colspan="8"><div align="left">
					<a href="${pageContext.request.contextPath }/leaveBillAction_input.action">添加请假申请</a>
				</div></td>
		  </tr> 
		  <tr>
		    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
		      <tr>
		        <td width="5%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">ID</span></div></td>
		        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">请假人</span></div></td>
		        <td width="5%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">请假天数</span></div></td>
		        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">请假事由</span></div></td>
		        <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">请假备注</span></div></td>
		        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">请假时间</span></div></td>
		        <td width="5%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">请假状态</span></div></td>
		        <td width="25%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">操作</span></div></td>
		      </tr>
		       
			    
			    <s:iterator value="leaveBillList">
			    	<tr>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center">${id}</div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${user.name}</div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${days}</div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${content}</div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${remark}</div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:date name="leaveDate" format="yyyy-MM-dd HH:mm:ss"/> </div></td>
			        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
			        	<s:if test="state==0">
		            		<div align="center">
			 					异常
		            		</div>
		            	</s:if>
			        	
		            	<s:if test="state==1">
		            		<div align="center">
			 					初始录入
		            		</div>
		            	</s:if>
		            	<s:if test="state==2">
		            		<div align="center">
			 					审核中
		            		</div>
		            	</s:if>
		            	<s:if test="state==3">
		            		<div align="center">
			 					审核通过
		            		</div>
		            	</s:if>
		            </td>
			        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">
			        	
			        	<s:a action="leaveBillAction_input.action">
			        		修改
			        		<s:param name="id" value="id"/>
			        	</s:a>
						
						<s:a action="leaveBillAction_delete.action">
			        		删除
			        		<s:param name="id" value="id"/>
			        	</s:a>
						
						<s:a action="workflowAction_viewHisComment.action">
			        		查看审核记录
			        		<s:param name="id" value="id"/>
			        	</s:a>
			        </div></td>
			    </tr> 
			    
			    </s:iterator>
		      
		    </table></td>
		  </tr>
	</table>
</body>
</html>