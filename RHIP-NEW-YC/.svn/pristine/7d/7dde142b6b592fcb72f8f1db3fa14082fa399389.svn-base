<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/personRecord/verify/check_update.js" type="text/javascript" ></script>
<div id="beforeSaveDiv" class="postcontent">
	<form id="personInfoForm" method="post">
		<div class="postdiv"> 
			<fieldset>
				<table class="posttable">
					<tr>
						<th style="width: 15%">姓名</th>
						<td>
							${personInfoTemp.name}
						</td>
						<th style="width: 15%">性别</th>
						<td>
							<ehr:dic dicmeta="GBT226112003" code="${personInfoTemp.gender}"/>
						</td>
					</tr>
					<tr>
						<th>出生日期</th>
						<td>
						 	<fmt:formatDate value='${personInfoTemp.birthday}' pattern='yyyy/MM/dd'/>
						</td>
						<th>身份证号</th>
						<td><c:out value="${personInfoTemp.idcard}" />
						</td>
					</tr>
					<tr>
						<th>工作单位</th>
						<td>
							<c:out value="${personInfoTemp.unitName}" />
						</td>
						<th>本人电话</th>
						<td>
							<c:out value="${personInfoTemp.phoneNumber}" />
						</td>
					</tr>
					<tr>
						<th>监护人姓名</th>
						<td>
						<c:out value="${personInfoTemp.firstGuardian}" />
						</td>
						<th>监护人联系电话</th>
						<td>
						<c:out value="${personInfoTemp.guardianPhoneOne}" />
						</td>
					</tr>
					<tr>
						<th>常住类型</th>
						<td>
							<ehr:dic dicmeta="FS10005" code="${personInfoTemp.householdType}"/>
						</td>
						<th>民族</th>
						<td>
							<ehr:dic dicmeta="GBT3304" code="${personInfoTemp.nation}"/>
						</td>
					</tr>
					<tr>
						<th>血型</th>
						<td>
							<ehr:dic dicmeta="CV0450005" code="${personInfoTemp.aboBloodType}"/>
						</td>
						<th>RH阴性：</th>
						<td>
							<ehr:dic dicmeta="FS10010" code="${personInfoTemp.rhBloodType}"/>
						</td>
					</tr>
					<tr>
						<th>文化程度</th>
						<td style="vertical-align:top;">
							<ehr:dic dicmeta="GBT46582006" code="${personInfoTemp.education}"/>
						</td>
						<th>职业</th>
						<td>
							<ehr:dic dicmeta="GBT6565" code="${personInfoTemp.occupation}"/>
						</td>
					</tr>
					<tr>
						<th style="width: 19%">婚姻状况</th>
						<td>
							<ehr:dic dicmeta="GBT226122003" code="${personInfoTemp.marriage}"/>
						</td>
						<th>医疗费用支付方式</th>
						<td>
							<ehr:dic dicmeta="CV0710003" code="${personInfoTemp.expenseInfoStr}"/>
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
							<ehr:dic dicmeta="CV0300302" code="${personInfoTemp.outWindType}"/>
						</td>
					</tr>
					<tr>
						<th>燃料类型</th>
						<td>
							<ehr:dic dicmeta="CV0300303" code="${personInfoTemp.fuel}"/>
						</td>
					</tr>
					<tr>
						<th>饮水</th>
						<td>
							<ehr:dic dicmeta="CV0300115" code="${personInfoTemp.water}"/>
						</td>
					</tr>
					<tr>
						<th>厕所</th>
						<td>
							<ehr:dic dicmeta="CV0300304" code="${personInfoTemp.hastoilet}"/>                                                                               
						</td>
					</tr>
					<tr>
						<th>禽畜栏</th>
						<td>
							<ehr:dic dicmeta="FS10015" code="${personInfoTemp.fowlType}"/>     
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
						<input type="button" class="btn" value="审核" onclick="verifyUpdateList.doCheck(${personInfoTemp.id})"/>
					</c:if>
					<input type="button" class="btn" value="返回" onclick="verifyUpdateList.cancel()"/>
				</td>
			</tr>
		</table>
	</form>
</div>
