<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/evaluation/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<form id="evaluationForm">
<div class="postcontent postdiv" style="margin-top: 10px;">
<fieldset class="layui-elem-field">
	<input name="statusId" value="${statusId}" type="hidden"/>
	<input id="eventId"  name="eventId" value="${mhmAssess.eventId}" type="hidden"/>
	<input name="mhmAssess.id" value="${mhmAssess.id}" type="hidden"/>
	<legend>个案管理效果评估表</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 180px; width: 30%;"/>
           <col style="min-width: 200px; width: 35%;"/>
           <col style="min-width: 200px; width: 35%;"/>
   		</colgroup>
      	<tbody>
       		<tr>
       			<th><label class="required">评估日期:</label></th>
           		<td colspan="2">
                    <%-- <tag:dateInput name="mhmAssess.assessDt" date="${mhmAssess.assessDt}" reg='{"regex":"date","required":"true"}' pattern="yyyy/MM/dd" onlypast="true"/> --%>
                    <input type="text" reg='{"regex":"date","required":"true"}' class="layui-input x-admin-content-sm-date"  name="mhmAssess.assessDt" id="mhmAssessAssessDtId" value="<fmt:formatDate value='${mhmAssess.assessDt}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;" />
           		</td>
			</tr>
			<tr>   
				<th>栏1的主要问题:</th>                 
           		<td colspan="2">
		           	<ehr:dic-radio name="mhmAssess.problem_1" value="${mhmAssess.problem_1}" dicmeta="MH00024" />
                </td>
			</tr>
			<tr>                 
                <th>栏2的目标和指标:</th>
                <td colspan="2">
	               	<ehr:dic-radio name="mhmAssess.problem_2" value="${mhmAssess.problem_2}" dicmeta="MH00025" />
                </td>                
			</tr>
			<tr>
		       	<th>栏3采取的治疗和康复策略:</th>
		       	<td colspan="2">
		 			<ehr:dic-radio name="mhmAssess.problem_3" value="${mhmAssess.problem_3}" dicmeta="MH00026" />
		       	</td>
       		</tr>			
       		<tr>
            	<th>栏4责任人：</th>
	            <td colspan="2">
		 			<ehr:dic-radio name="mhmAssess.problem_4User" value="${mhmAssess.problem_4User}" dicmeta="MH00026" />
		        </td>
	     	</tr> 
       		<tr>
            	<th>栏4是否按时完成：</th>
	            <td colspan="2">
		 			<ehr:dic-radio name="mhmAssess.problem_4Finish" value="${mhmAssess.problem_4Finish}" dicmeta="MH00027" />
		        </td>
	     	</tr> 	
       		<tr>
            	<th>病情总体评估<br>(与入组时相比)：</th>
	            <td colspan="2">
		 			<ehr:dic-list name="mhmAssess.evaluation" value="${mhmAssess.evaluation}" dicmeta="MH00028" />
		        </td>
	     	</tr>	
       		<tr>
            	<th rowspan="6">社会功能状况<br>(与入组时相比,填写0-7评分)：</th>
	            <td>个人生活料理</td>
	            <td>
	            	<input type="text" name="mhmAssess.liveArrange" value="${mhmAssess.liveArrange}"
		           		style="width: 100px;" reg='{"digits":"true","min":0,"max":7}'/>分(0～7分)
	            </td>
	     	</tr>
       		<tr>
	            <td>家务劳动</td>
	            <td>
	            	<input type="text" name="mhmAssess.housework" value="${mhmAssess.housework}"
		           		style="width: 100px;" reg='{"digits":"true","min":0,"max":7}'/>分(0～7分)
	            </td>
	     	</tr>	
       		<tr>
	            <td>生产劳动及工作</td>
	            <td>
	            	<input type="text" name="mhmAssess.productiveLabor" value="${mhmAssess.productiveLabor}"
		           		style="width: 100px;" reg='{"digits":"true","min":0,"max":7}'/>分(0～7分)
	            </td>
	     	</tr>
       		<tr>
	            <td>学习能力</td>
	            <td>
	            	<input type="text" name="mhmAssess.studyCapacity" value="${mhmAssess.studyCapacity}"
		           		style="width: 100px;" reg='{"digits":"true","min":0,"max":7}'/>分(0～7分)
	            </td>
	     	</tr>
       		<tr>
	            <td>社会人际交往</td>
	            <td>
	            	<input type="text" name="mhmAssess.interpersonalCommunication" value="${mhmAssess.interpersonalCommunication}"
		           		style="width: 100px;" reg='{"digits":"true","min":0,"max":7}'/>分(0～7分)
	            </td>
	     	</tr>
       		<tr>
	            <td>社会功能总评</td>
	            <td>
	            	<input type="text" name="mhmAssess.socialFunction" value="${mhmAssess.socialFunction}"
		           		style="width: 100px;" reg='{"digits":"true","min":0,"max":7}'/>分(0～7分)
	            </td>
	     	</tr>
            </tbody>
        </table>
    </fieldset>
    <fieldset class="layui-elem-field">
        <table class="posttable">
            <colgroup>
                <col style="min-width: 180px; width: 30%;"/>
                <col style="min-width: 200px; width: 70%;"/>
            </colgroup>
            <tbody>
       		<tr>
	            <th>评估人签名:</th>
	            <td>
	            	<ehr:user userCode="${mhmAssess.modifyDoctorId == null ? currentUser.id : mhmAssess.modifyDoctorId}"/>
					<input type="hidden" name="mhmAssess.modifyDoctorId" value="${mhmAssess.modifyDoctorId == null ? currentUser.id : mhmAssess.modifyDoctorId}"/>
	            </td>
	     	</tr>	     	     		     		     		     	     		     		     	     		     	     	     	
       </tbody>
  </table>
</fieldset>
</div>
</form>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#mhmAssessAssessDtId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

  });
</script>