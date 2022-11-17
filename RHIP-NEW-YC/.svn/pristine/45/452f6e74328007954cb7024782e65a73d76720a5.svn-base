<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<table id="reportCard_table">
	<colgroup>
			<col style=" width: 10%;" />
			<col style="width: 10%" />
			<col style="width: 20%" />
			<col style="width: 15%" />
			<col style="width: 15%" />
			<col style="width: 30%" />
		</colgroup>
		<thead> 
			<tr>
					<th >姓名</th>
					<th >性别</th> 
					<th >身份证号</th>
					<th >出生日期</th>
					<th >家庭住址</th>
					<th >患病类型</th>
			</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach var="personInfo" items="${personInfoList}">
                        <tr>
                            <td>
                            <a title="报卡详细信息" class="report-link"  data-disid="${personInfo.id }">${personInfo.name}</a>
                            </td>
                            <td><ehr:dic dicmeta="GBT226112003" code = "${personInfo.gender}"/></td>
                             <td>${personInfo.idcard}</td>
                             <td><fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/></td>
                             <td>
                             	<c:out value="${personInfo.paprovince}"></c:out>
								<c:out value="${personInfo.pacity}"></c:out>
								<c:out value="${personInfo.pacounty}"></c:out>
								<ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"></ehr:dic>
								<ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"></ehr:dic>
								<c:out value="${personInfo.pahouseNumber}"></c:out>
                             </td>
                             <td style="width: 18%"><c:if test="${not empty personInfo.hbpFlag}">高血压&nbsp;</c:if><c:if test="${not empty personInfo.diFlag}">糖尿病&nbsp;</c:if>
           						<c:if test="${not empty personInfo.tumorFlag}">肿瘤&nbsp;</c:if><c:if test="${not empty personInfo.coronaryFlag}">冠心病&nbsp;</c:if>
           						<c:if test="${not empty personInfo.strokeFlag}">脑卒中</c:if>
                          	</td>

                        </tr>
           </c:forEach>
		</tbody> 
		<ehr:pagination action="followupList.search" colspan="9"/>
	</table>