<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/personRecord/verify/check.js" type="text/javascript" ></script>
<div id="beforeSaveDiv" class="postcontent">
	<form id="personInfoForm" method="post">
		<div class="postdiv"> 
			<fieldset>
				<table class="posttable">
					<tr>
						<th style="width: 14%">姓名</th>
						<td style="width: 40%">
							${personInfo.name}
						</td>
						<th style="width: 14%">性别</th>
						<td style="width: 40%">
							<ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th>出生日期</th>
						<td>
							<fmt:formatDate value='${personInfo.birthday}' pattern="yyyy-MM-dd"/> 
						</td>
						<th>身份证号</th>
						<td><c:out value="${personInfo.idcard}" />
						</td>
					</tr>
					<tr>
						<th>工作单位</th>
						<td>
							<c:out value="${personInfo.unitName}"></c:out>
						</td>
						<th>本人电话</th>
						<td>
							<c:out value="${personInfo.phoneNumber}" />
						</td>
					</tr>
					<tr>
						<th>监护人姓名</th>
						<td>
						<c:out value="${personInfo.firstGuardian}" />
						</td>
						<th>监护人联系电话</th>
						<td>
						<c:out value="${personInfo.guardianPhoneOne}" />
						</td>
					</tr>
					<tr>
						<th>常住类型</th>
						<td>
							<ehr:dic dicmeta="FS10005" code="${personInfo.householdType}"/>
						</td>
						<th>民族</th>
						<td>
							<ehr:dic dicmeta="GBT3304" code="${personInfo.nation}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th>血型</th>
						<td>
							<ehr:dic dicmeta="CV0450005" code="${personInfo.aboBloodType}"></ehr:dic>
						</td>
						<th>RH阴性：</th>
						<td>
							<ehr:dic dicmeta="FS10010" code="${personInfo.rhBloodType}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th style="vertical-align:top;">文化程度</th>
						<td>
							<ehr:dic dicmeta="GBT46582006" code="${personInfo.education}"></ehr:dic>
						</td>
						<th>职业</th>
						<td  style="vertical-align:top;">
							<ehr:dic dicmeta="GBT6565" code="${personInfo.occupation}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th style="width: 19%">婚姻状况</th>
						<td>
							<ehr:dic dicmeta="GBT226122003" code="${personInfo.marriage}"></ehr:dic>
						</td>
						<th>医疗费用支付方式</th>
						<td>
							<ehr:dic dicmeta="CV0710003" code="${expenseInfoStr}"/>
						</td>
					</tr>
				</table>
			</fieldset>
			<div class="postdiv">
			<fieldset>
				<legend>生活环境</legend>
				<table class="posttable">
					<tr>
						<th style="width: 17%">厨房排风设施</th>
						<td>
							<ehr:dic dicmeta="CV0300302" code="${personInfo.outWindType}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th>燃料类型</th>
						<td>
							<ehr:dic dicmeta="CV0300303" code="${personInfo.fuel}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th>饮水</th>
						<td>
							<ehr:dic dicmeta="CV0300115" code="${personInfo.water}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th>厕所</th>
						<td> 
							<ehr:dic dicmeta="CV0300304" code="${personInfo.hastoilet}"></ehr:dic>                                                                              
						</td>
					</tr>
					<tr>
						<th>禽畜栏</th>
						<td>
							<ehr:dic dicmeta="FS10015" code="${personInfo.fowlType}"></ehr:dic>
						</td>
					</tr>
				</table>
			</fieldset>
			</div>
		</div>
		<table border="0">
			<tr>
				<td style="text-align: center;">
					<c:if test="${operationType eq 'check'}">
						<input type="button" class="btn" value="审核" onclick="verifyList.doCheck(${personInfo.id})"/>
					</c:if>
					<input type="button" class="btn" value="返回" onclick="verifyList.cancel()"/>
				</td>
			</tr>
		</table>
	</form>
</div>
