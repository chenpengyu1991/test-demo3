<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
	
<div class="postcontent">
	<div class="postdiv">
	<fieldset>
		<legend>患者信息</legend>
		<table class="posttable">
			<colgroup>
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
			</colgroup>
			<tr>
				<th><label class="required">身份证</label></th>
				<td>${reserveRegister.idcard}</td>
				<th><label class="required">姓名</label></th>
				<td>${reserveRegister.name}</td>
			</tr>
			<tr>
				<th><label class="required">出生日期</label></th>
				<td>
					<fmt:formatDate value="${reserveRegister.birthday}" pattern="yyyy年MM月"/>
				</td>
				<th><label class="required">性别</label></th>
				<td><ehr:dic code="${reserveRegister.gender}" dicmeta="GBT226112003"/></td>
			</tr>
			<tr>
				<th>工作单位</th>
				<td>${reserveRegister.unitName}</td>
				<th><label class="required">电话</label></th>
				<td>${reserveRegister.phoneNumber}</td>
			</tr>
			<%-- <tr>
				<th><label>医保卡号</label></th>
				<td>${reserveRegister.idcardHos}</td>
				<th><label>新农合号</label></th>
				<td>${reserveRegister.idcardFarm}</td>
			</tr> --%>
			<%-- <tr>
				<th><label class="required">现地址</label></th>
				<td colspan="3">
					<ehr:dic dicmeta="FS990001" code="${reserveRegister.patownShip}"></ehr:dic>
                    <ehr:dic dicmeta="FS990001" code="${reserveRegister.pastreet}"></ehr:dic>
					${reserveRegister.pahouseNumber}
				</td>
			</tr> --%>
		</table>
	</fieldset>
	</div>
	<div class="postdiv">
	<fieldset>
	<legend>号源信息</legend>
		<table style="width:99%" class="posttable">
	    	<colgroup>
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
			</colgroup>
			<tbody>
				<tr>
					<th>医院：</th>
					<td>
						${reserveRegister.hospitalName}
					</td>
					<th>科室：</th>
					<td>
						${reserveRegister.deptName}
					</td>
				</tr>
				<tr>
					<th>医生：</th>
					<td>
						${reserveRegister.doctorName}
					</td>
					<th>
						号别：</th>
					<td>
						<c:if test="${reserveRegister.clinicType == '01'}">
							普通号
						</c:if>
						<c:if test="${reserveRegister.clinicType == '02'}">
							专家号
						</c:if>
					</td>
				</tr>
				<tr>
					<th>挂号费：</th>
					<td>
						${reserveRegister.registerFee} 元
					</td>
					<th>到诊日期：</th>
					<td>
						<fmt:formatDate value="${reserveRegister.requestDate}" pattern="yyyy年MM月dd日"/>
						<c:if test="${reserveRegister.ampm eq 'a'}">上午</c:if>
						<c:if test="${reserveRegister.ampm eq 'p'}">下午</c:if>
						${reserveRegister.timeIntervalStart}~${reserveRegister.timeIntervalEnd}
					</td>
				</tr>
				<tr>
					<th>查询码：</th>
					<td >
						${reserveRegister.searchCode}
					</td>
					<th>提示信息：</th>
					<td >
						${promptMessage}
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	</div>
	<div class="postdiv">
	<fieldset>
	<legend>操作信息</legend>
		<table style="width:99%" class="posttable">
	    	<colgroup>
				<col style="width: 10%;min-width:100px;" />
				<col style="width: 23%;min-width:200px;" />
				<col style="width: 10%;min-width:100px;" />
				<col style="width: 23%;min-width:200px;" />
				<col style="width: 10%;min-width:100px;" />
				<col style="width: 23%;min-width:200px;" />
			</colgroup>
			<tbody>
				<tr>
					<th>预约者：</th>
					<td>
						${reserveRegister.submitUserName}
					</td>
					<th>预约时间：</th>
					<td>
						<fmt:formatDate value="${reserveRegister.submitDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
					</td>
					<th>预约来源：</th>
					<td>
						<ehr:dic code="${reserveRegister.regFrom}" dicmeta="FS990005"/>
					</td>
				</tr>
				<c:if test="${not empty reserveRegister.cancelUser}">
				<tr>
					<th>取消人：</th>
					<td>
						${reserveRegister.cancelUser}
					</td>
					<th>取消时间：</th>
					<td>
						<fmt:formatDate value="${reserveRegister.cancelTime}" pattern="yyyy/MM/dd HH:mm:ss"/>
					</td>
					<th></th>
					<td>
						
					</td>
				</tr>
				</c:if>
			</tbody>
		</table>
	</fieldset>
	</div>
</div>
