<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv" style="margin-top: 10px;">

<input type="hidden" name="eventId" id="eventId" value="${managementDto.eventId}">
<input type="hidden" name="statusId" id="statusId" value="${managementDto.statusId}">
<input type="hidden" name="mhmFollowup.followupStatus" value="${managementDto.mhmFollowup.followupStatus}"/>
<fieldset class="layui-elem-field">
	<legend>失访信息</legend>
	    <table class="posttable" id="lostFollowUpTable">
       		<colgroup>
	           <col style="min-width: 120px; width: 20%;"/>
	           <col style="min-width: 180px; width: 30%;"/>
	           <col style="min-width: 80px; width: 20%;"/>
	           <col style="min-width: 250px; width: 30%;"/>
   			</colgroup>
            <tbody>
            <tr>
                <th><label class="required">失访原因:</label></th>
                <td colspan="3">
                    <ehr:dic-list  id="lfLostReason" name="mhmFollowup.loseReason" dicmeta="MH00018" value=""  reg='{"required":"true"}'
                                   code="1,2,3,4,5,6" onchange="lostFollowUpEdit.toggleLostReason()"/>
			           	<span id="spanLfLostReasonId">
			           		<input type="text" name="mhmFollowup.loseReasonOther" value=""
                                   style="width: 100px;" reg='{"maxlength":"100"}'/>
			           	</span>
                </td>
            </tr>
            <tr>
                <th>姓名:</th>
                <td>
                	<input type="text" id="lfName" name="mhmFollowup.name"  value="${managementDto.mhmFollowup.name}" reg='{"maxlength":"50"}' style="width:150px;" />
                </td>
                <th>性别:</th>
                <td>
                    <ehr:dic-radio  name="mhmFollowup.gender" dicmeta="GBT226112003" value="${managementDto.mhmFollowup.gender}" code="1,2"/>
                </td>
            </tr>
            <tr>
                <th>居民身份证号:</th>
                <td>
                	<input type="text" id="lfIdCard" name="mhmFollowup.idcard" value="${managementDto.mhmFollowup.idcard}" reg='{"idCard":"true"}' style="width:150px;"/>
                </td>
                <th>年龄:</th>
                <td>
                    <input type="text" id="lfAge" style="width: 50px;" name="mhmFollowup.age" value="" reg='{"digits":"true","min":"1","max":"200"}' style="width:150px;"/>岁
                </td>
            </tr>
            <tr>
                <th>关锁情况:</th>
                <td colspan="3">
                    <ehr:dic-list name="mhmFollowup.lockState" value="" dicmeta="MH00007"/>
                </td>
            </tr>
            <tr>
                <th>住院情况:</th>
                <td colspan="3">
	                <ehr:dic-list id="lfhospitalCourse" name="mhmFollowup.hospitalCourse" value="" dicmeta="MH00019"
                        	onchange="lostFollowUpEdit.toggleHospitalCourse();"/>
                    <span id="spanLfHospitalCourse">
                        	末次出院时间
                        <%-- <tag:dateInput name="mhmFollowup.lastleaveHospitalDate" style="width: 100px;" reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"/> --%>
                        <input type="text" reg='{"regex":"date"}' class="layui-input x-admin-content-sm-date"  name="mhmFollowup.lastleaveHospitalDate" id="mhmFollowupLastleaveHospitalDateId"  style="padding-left: 0px;width: 100px;" />
                    </span>
                </td>
            </tr>
            <tr>
                <th>住院患者有否获得经费补助:</th>
                <td colspan="3">
                    <ehr:dic-radio  name="mhmFollowup.economicGrantDept" dicmeta="PH00002" value=""   code="2,1"/>
                </td>
            </tr>
            <tr>
                <th>失访原因说明:</th>
                <td colspan="3">
                    <input type="text" name="mhmFollowup.loseReasonDetail" value="" reg='{"maxlength":"100"}'/>
                </td>
            </tr>
            <tr>
                <th>报告时间:</th>
                <td colspan="3">
                    <%-- <tag:dateInput name="mhmFollowup.reportDt" 
                                   style="width: 100px;" reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput> --%>
                                   <input type="text" reg='{"regex":"date"}' class="layui-input x-admin-content-sm-date"  name="mhmFollowup.reportDt" id="mhmFollowupReportDtId"  style="padding-left: 0px;width: 100px;" />
                </td>
            </tr>
            <tr id="deathId1">
                <th>如为死亡，死亡日期:</th>
                <td colspan="3">
                    <%-- <tag:dateInput name="mhmFollowup.dieDt" 
                                   style="width: 100px;" reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput> --%>
                                   <input type="text" reg='{"regex":"date"}' class="layui-input x-admin-content-sm-date"  name="mhmFollowup.dieDt" id="mhmFollowupDieDtId"  style="padding-left: 0px;width: 100px;" />
                </td>
            </tr>
            <tr id="deathId2">
                <th>死亡原因:</th>
                <td colspan="3">
                    <ehr:dic-list  name="mhmFollowup.dieReason" value="" dicmeta="MH00020"
                                   code="1,2,3,4,5,6" onchange="toggleOtherSC('mhmFollowup.dieReason','spanFrDieReason','6');"/>
			           	<span id="spanFrDieReason">
			           		<input type="text" name="mhmFollowup.dieReasonOther" value=""
                                   style="width: 100px;" reg='{"maxlength":"100"}'/>
			           	</span>
                </td>
            </tr>
            <tr id="deathId3">
                <th>死亡原因说明:</th>
                <td colspan="3">
                    <input type="text" name="mhmFollowup.dieReasonDetail" value="" reg='{"maxlength":"100"}' style="width: 95%;" />
                </td>
            </tr>
            </tbody>
	  </table>
	</fieldset>
		<fieldset style="margin-top: 10px;" class="layui-elem-field">
		    <table class="posttable">
		        <colgroup>
		           <col style="min-width: 120px; width: 20%;"/>
		           <col style="min-width: 180px; width: 30%;"/>
		           <col style="min-width: 80px; width: 20%;"/>
		           <col style="min-width: 250px; width: 30%;"/>
		        </colgroup>
		        <tr>
		            <th><label class="required">本次随访时间：</label></th>
		            <td><%-- <tag:dateInput id="lostfollowupDt" name="mhmFollowup.followupDt" date="${managementDto.mhmFollowup.followupDt}" pattern="yyyy/MM/dd" reg='{"regex":"date","required":"true"}'/> --%>
		            <input type="text" reg='{"regex":"date","required":"true"}' class="layui-input x-admin-content-sm-date"  name="mhmFollowup.followupDt" id="lostfollowupDt" value="<fmt:formatDate value='${managementDto.mhmFollowup.followupDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
		            </td>
		            <th>随访医生签名：</th>
		            <td><ehr:user userCode="${managementDto.mhmFollowup.fillDoctorId}"/></td>
		        </tr>
		    </table>
		</fieldset>	
	</div>
	
	<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#mhmFollowupLastleaveHospitalDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    laydate.render({
      elem: '#mhmFollowupReportDtId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
    
    laydate.render({
        elem: '#mhmFollowupDieDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#lostfollowupDt' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
  });
</script>