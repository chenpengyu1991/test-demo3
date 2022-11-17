<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="toolbar">
	<a href="javascript:ceSearch.back()" id="back"><b class="fanhui">返回</b></a> 
	<a href="javascript:ceSearch.updateStaff()" id="updateStaff"><b class="baocun" style="padding-left: 20px">保存</b></a>
</div>
<form id="staff_form" class="postcontent">
	<div class="postdiv">
		<fieldset>
			<legend>人员信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 10%;" />
					<col style="width: 20%;" />
					<col style="width: 10%;" />
					<col style="width: 20%;" />
					<col/>
				</colgroup>
				<tr>
					<th>
						<label class="required">姓名</label>
					</th>
					<td>
					    <div>
					        <input type="hidden" id="staffCode" name="staffCode" value="${staff.staffCode}"/>
						    <input type="text" id="name" name="name" value="${staff.name}" reg="{'required':true,'maxlength':20}" readonly="readonly" title="请选择人员" style="cursor:hand"/>
					    </div>
					</td>
					<th>
						<label class="required">身份证号</label>
					</th>
					<td>
						<input type="text" id="idCard" name="idCard" value="${staff.idCard}" reg="{'required':true,'maxlength':18}" readonly="readonly"/>
					</td>
					<td/>
				<tr/>
				<tr>
				    <th>
						<label>技术职称</label>
					</th>
					<td>
						<input type="text" id="technicalName" name="technicalName" value="${staff.technicalName}" reg="{'required':false,'maxlength':20}" readonly="readonly"/>
					</td>
					<th>
						<label>总学时</label>
					</th>
					<td>
						<input type="text" id="period_all" name="period" value="${staff.period}" reg="{'required':false,'maxlength':6}"/>
					</td>
					<td/>
				<tr/>
				<tr>
					<th>
						<label>总一类学分</label>
					</th>
					<td>
						<input type="text" id="creditA_all" name="creditA" value="${staff.creditA}" reg="{'required':false,'maxlength':6}"/>
					</td>
					<th>
						<label>总二类学分</label>
					</th>
					<td>
						<input type="text"  id="creditB_all" name="creditB" value="${staff.creditB}" reg="{'required':false,'maxlength':6}"/>
					</td>
					<td/>
				</tr>
			</table>
		</fieldset>
	</div>
</form>
<form id="continue_education_form" class="postcontent">
	<div class="postdiv">
        <fieldset>
            <legend>项目信息</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 80%"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td colspan="2">
                        <div class="repeattable" style="text-align: left">
                            <table style="width: 100%" id="projectTable">
                                <tr>
                                    <th style="text-align: center;width: 10%">登记年份</th>
                                    <th style="text-align: center;width: 15%">项目代号</th>
                                    <th style="text-align: center;width: 15%">项目名称</th>
                                    <th style="text-align: center;width: 20%">举办单位</th>
                                    <th style="text-align: center;width: 10%">学时数</th>
                                    <th style="text-align: center;width: 10%">一类学分</th>
                                    <th style="text-align: center;width: 10%">二类学分</th>
                                    <th style="text-align: center;width: 10%">操作</th>
                                </tr>
	                           <c:forEach var="continueEducation" items="${continueEducationList}" varStatus="status">
				                    <tr>
				                        <td field="projectNo">${continueEducation.recordYear}</td>
				                        <td field="projectNo">${continueEducation.projectNo}</td>
				                        <td field="projectName">${continueEducation.projectName}</td>
				                        <td field="organizer">${continueEducation.organizer}</td>
				                        <td field="period">${continueEducation.period}</td>
				                        <td field="creditA">${continueEducation.creditA}</td>
				                        <td field="creditB">${continueEducation.creditB}</td>
				                        <td class="btnsublist" field="btn">
					        	            <a href="javascript:void(0)" onclick="ceSearch.popupProject(${continueEducation.id})">修改</a>&nbsp;
					                        <a href="javascript:void(0)" onclick="ceSearch.removeTr(this,${continueEducation.id},'${continueEducation.staffCode}')">删除</a>
					                    </td>
					                </tr>
	                			</c:forEach>
                            </table>
                        </div>
                    </td>
                    <td style="vertical-align: top;text-align: right">
                        <a href="javascript:ceSearch.popupProject($('#staffCode').val(),'add')" style="padding-left: 20px;" id="addStaffBtn">
                            <b class="xinz" style="padding-left: 20px;">添加</b>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
