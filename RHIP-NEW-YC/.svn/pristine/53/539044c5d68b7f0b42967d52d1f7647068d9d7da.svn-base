<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ism/reportCard/view.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)"  id="report-input-back-btn"><b class="fanhui">返回</b></a>
	<ehr:authorize ifAnyGranted="03,11,02" >
		<a href="javascript:void(0);" id="report-input-save-btn"><b class="tijiao">提交</b></a>
	</ehr:authorize>
</div>
<div id="report-card-main" class="postdiv"  >
	<form id="report-input-form">
		<i class="popno">全国伤害监测报告卡</i>
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
				</colgroup>
				<tr>
					<th><label for="hospitalCode">监测医院编号</label></th>
					<td><input type="text" id="hospitalCode" name="hospitalCode" value="${reportInfo.hospitalCode}" readonly="readonly"></input></td>
					<th><label for="reportNo">卡片编号</label></th>
					 <td>
				 		<c:choose>
                              <c:when test="${empty(reportNo)}">
                                  <span>自动生成</span>
                              </c:when>
                              <c:otherwise>
                                <input type="text"  value="${reportNo}" readonly="readonly"/>
                              </c:otherwise>
                          </c:choose>
					</td>
				</tr>
			</table>
			<fieldset>
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="ism_report_idcard">身份证</label></th>
						<td><input type="text" id="ism_report_idcard" name="idcard" value="${idcard}" placeholder="输入身份证获取人员信息" reg='{"idCard":true}'></input></td>
						<th><label for="ism_report_name" class="required" >姓名</label></th>
						<td><input type="text" id="ism_report_name" name="name" value="${name}" reg="{'required':true,'maxlength':16}"></input></td>
					</tr>
					<tr>
						<th><label for="age" class="required">年龄</label></th>
						<td><input type="text" id="age" name="age" value="${age}" reg="{'required':true,'maxlength':2}"></input></td>
						<th><label for="gender" class="required">性别</label></th>
						<td><ehr:dic-list  dicmeta="GBT226112003"  id="gender" name="gender" value="${gender}" reg="{'required':true}" ></ehr:dic-list></td>
					</tr>
					<tr>
						<th><label for="registration" class="required">户籍</label></th>
						<td><ehr:dic-list id="registration" dicmeta="CV0201104"  name="registration" value="${registration}" reg="{'required':true}"/></td>
						<th><label for="education" class="required">文化程度</label></th>
						<td><ehr:dic-list id="education" dicmeta="GBT46582006"  name="education" value="${education}"  reg="{'required':true}"/></td>
					</tr>
					<tr>
						<th><label for="occupation" class="required">职业</label></th>
						<td><ehr:dic-list dicmeta="GBT6565" width="180px;" id="occupation" name="occupation" value="${occupation}"  reg="{'required':true}"/></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>基本情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%; min-width: 100px;" />
						<col style="width: 80%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label class="required" for="inhosDate">就诊日期</label></th>
						<td><tag:dateInput  name="inhosDateToString" id="inhosDate" onlypast="true" date="${planInfo.createDate}"
								reg="{'required':true}" pattern="yyyy-MM-dd HH:mm:ss" style="width:300px"
							/></td>
					</tr>
					<tr>
						<th><label class="required" for="occurTime">伤害发生日期时间</label></th>
							<td><tag:dateInput  name="occurTimeToString" id="occurTime" onlypast="true" date="${planInfo.createDate}"
								reg="{'required':true}" pattern="yyyy-MM-dd HH:mm:ss" style="width:300px"
							/></td>
					</tr>
					<tr>
						<th><label for="occurReasonCode">伤害发生原因</label></th>
						<td><ehr:dic-radio dicmeta="DMD00055" name="occurReasonCode" value="${occurReasonCode}"  reg="{'maxlength':2}"/>
							<input id="occurReasonOther" style="width:150px " reg="{'maxlength':100,'required':true}"  type="text" value="${reportInfo.occurReasonOther}" name="occurReasonOther">
						</td>
					</tr>
					<tr>
						<th><label for="occurPalceCode">伤害发生地点</label></th>
						<td><ehr:dic-radio dicmeta="DMD00056"  name="occurPalceCode" value="${occurPalceCode}" reg="{'maxlength':2}"/>
						<input id="occurPalceOther" style="width:150px "  reg="{'maxlength':100,'required':true}" type="text" value="${reportInfo.occurPalceOther}" name="occurPalceOther"/>
						</td>
						
					</tr>
					<tr>
						<th><label for="occurBehaviorCode">伤害发生时活动类别</label></th>
						<td><ehr:dic-radio dicmeta="DMD00057"  name="occurBehaviorCode" value="${occurBehaviorCode}" reg="{'maxlength':2}"/>
							<input id="occurBehaviorOther" style="width:150px "  reg="{'maxlength':100,'required':true}" type="text" value="${reportInfo.occurBehaviorOther}" name="occurBehaviorOther"/>
						</td>
					</tr>
					<tr>
						<th><label for="intendsCode">伤害意图类别</label></th>
						<td><ehr:dic-radio dicmeta="DMD00058"  id="intendsCode" name="intendsCode" value="${intendsCode}" reg="{'maxlength':2}"/></td>
					</tr>
					<tr>
						<th><label for="natureCode">伤害性质</label></th>
						<td><ehr:dic-radio dicmeta="DMD00059"  name="natureCode" value="${natureCode}" reg="{'maxlength':2}"/>
						<input id="natureOther" style="width:150px "  reg="{'maxlength':100,'required':true}" type="text" value="${reportInfo.natureOther}" name="natureOther"/>
						</td>
					</tr>
					<tr>
						<th><label for="partCode">伤害部位</label></th>
						<td><ehr:dic-radio dicmeta="DMD00060"  name="partCode" value="${partCode}" reg="{'maxlength':2}"/>
						<input id="partOther" style="width:150px "  reg="{'maxlength':100,'required':true}" type="text" value="${reportInfo.partOther}" name="partOther"/>
						</td>
					</tr>
					<tr>
						<th><label for="severityCode">伤害严重程度</label></th>
						<td><ehr:dic-radio dicmeta="DMD00061"  name="severityCode" value="${severityCode}" reg="{'maxlength':2}"/></td>
					</tr>
					<tr>
						<th><label for="clinical＿diagnosis">临床诊断</label></th>
						<td><input type="text" id="clinical＿diagnosis" name="clinical＿diagnosis"  reg="{'maxlength':200}" style="width:300px"></input></td>
					</tr>
					<tr>
						<th><label for="result">伤害结局</label></th>
						<td><ehr:dic-radio dicmeta="DMD00062" name="result" value="${result}" reg="{'maxlength':2}"/>
						<input id="resultOther" style="width:150px "  reg="{'maxlength':100,'required':true}" type="text" value="${reportInfo.resultOther}" name="resultOther"/>
						</td>
					</tr>
					<tr>
						<th><label for="createOrganName"  class="required">填报机构名称</label></th>
						<td><input type="text" id="createOrganName" name="createOrganName" style="width:300px" value="${reportInfo.createOrganName}" readonly="readonly"></input> 
					</tr>
					<tr>
						<th><label for="createDoctorName"  class="required">填报人姓名</label></th>
						<td><input type="text" id="createDoctorName" name="createDoctorName" style="width:300px" value="${reportInfo.createDoctorName}"  readonly="readonly"></input></td>
					</tr>
					<tr>
						<th><label for="createDate"  class="required">填报时间</label></th>
						
						<td><tag:dateInput  id="createDate"  name="createDate"  style="width:300px" date="${reportInfo.createDate}" pattern="yyyy/MM/dd" reg="{'required':true}"/></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form>
</div>