<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="REGISTER" value="<%=MalariaStatus.REGISTER.getValue()%>" />
<div class="repeattable">
	<table>
		<colgroup>
			<c:if test="${approveFlag=='1'}">
				<col style="min-width:20px;width:20px;"/>
			</c:if>
	        <col style="min-width:70px;width:70px;"/>
			<col style="min-width:60px;width:60px;"/>
	        <col style="min-width:50px;width:50px;"/>
			<col style="min-width:120px;width:80px;"/>
			<col style="min-width:80px;width:80px;"/>
			<col style="min-width:150px;width:200px;"/>
            <col style="min-width:80px;width:80px;"/>
		</colgroup>	
		<thead>
			<tr>
				<c:if test="${approveFlag=='1'}">
					<th><input type="checkbox" id="checkAllId" name="checkedAll"  onclick="chkAll(this);"/></th>
				</c:if>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>联系电话</th>
				<th>血检结果</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="register" items="${statusInfo}" varStatus="status">
				<tr>
					<c:if test="${approveFlag=='1'}">
						<td<%-- title="${register.malariaQueryDto.singleId}"--%>>
							<c:if test="${(register.specialStatus == REGISTER) && register.malariaQueryDto.tentativeDiagnosis == '1' && (register.malariaQueryDto.testResult == '1' || register.malariaQueryDto.testResult==2)}">
								<input type="checkbox" name="check"  value="${register.malariaQueryDto.singleId}" onclick="doChk(this);"/>
								<input type="hidden" id="name" value="${register.malariaQueryDto.name}">
							</c:if>
						</td>
					</c:if>
					<td title="${register.malariaQueryDto.name}">
       					<a href="javascript:void(0)" onclick='javascript:malariaIndex.editRegister(${register.malariaQueryDto.singleId},${register.malariaQueryDto.idmId},"view")' class="person-link-btn">${register.malariaQueryDto.name}</a>
					</td>
					<td class="centertd" title="<ehr:dic dicmeta="GBT226112003" code="${register.malariaQueryDto.gender}" />"><ehr:dic dicmeta="GBT226112003" code="${register.malariaQueryDto.gender}" /></td>
					<td title="${register.malariaQueryDto.age}">${register.malariaQueryDto.age}</td>
					<td title="${register.malariaQueryDto.phoneNumber}">${register.malariaQueryDto.phoneNumber}</td>
					<td>
						<ehr:tip><ehr:dic dicmeta="IDM00258" code="${register.malariaQueryDto.testResult}" /></ehr:tip>
					</td>
					<td>
                        <ehr:tip>${register.malariaQueryDto.paAddress}</ehr:tip>
					</td>
					<td>
                       <c:choose>
                             <c:when test="${approveFlag=='1' && register.specialStatus == REGISTER}">
								<a href="javascript:void(0)" onclick="malariaIndex.editRegister(${register.malariaQueryDto.singleId},${register.malariaQueryDto.idmId},'add')"class="person-link-btn">血检核实</a>
                            </c:when>
							<c:otherwise>
								<label class="loadclass"><ehr:dic dicmeta="IDM00259"  code="${register.specialStatus}"/></label>
							</c:otherwise>
                        </c:choose>					
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="malariaIndex.searchRegister" />
		</tr>
	</table>
</div>