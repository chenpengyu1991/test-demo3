<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/vaccine/inoculation/index.js" type="text/javascript"></script>
<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table>
        <colgroup>
            <col style="width:5%;"/>        
            <col style="width:5%;"/>
            <col style="width:10%;"/>
            <col style="width:12%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:8%;"/>
            <col style="width:15%;"/>
        </colgroup>
			<thead>
				<tr>
					<th>姓名</th>
					<th>性别</th>
					<th>电话号码</th>
					<th>身份证</th>
					<th>住址</th> 
					<th>预约时间</th>
					<th>预约机构</th>
					<th>预约疫苗类型</th>
					<th>是否接种</th>
                   	<th>操作</th>
				</tr>
			</thead>
			
			<tbody class="tbody"> 
				<c:forEach items="${list}" var="inoculation">
					<tr>
						<td><ehr:tip>${inoculation.personName}</ehr:tip></td>
						<td style="text-align: center;"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${inoculation.personGender}"/></ehr:tip></td>
						<td><ehr:tip>${inoculation.phoneNumber}</ehr:tip></td>
						<td><ehr:tip>${inoculation.personIdcard}</ehr:tip></td>
						<td><ehr:tip>${inoculation.personAddress}</ehr:tip></td>
						<td><fmt:formatDate value="${inoculation.createDate}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
						<td><ehr:tip><ehr:org code="${inoculation.organCode}"></ehr:org></ehr:tip></td>
						<td><ehr:tip>
							<c:choose>
								<c:when test="${inoculation.vaccineType eq '1'}">老年人23价疫苗预约</c:when>
								<c:when test="${inoculation.vaccineType eq '3'}">3价流感疫苗预约</c:when>
								<c:when test="${inoculation.vaccineType eq '4'}">4价流感疫苗预约</c:when>
								<c:when test="${inoculation.vaccineType eq '5'}">4价HPV疫苗预约</c:when>
								<c:when test="${inoculation.vaccineType eq '6'}">9价HPV疫苗预约</c:when>
							</c:choose>
							</ehr:tip>
						</td>
						<td><ehr:tip>
								<c:if test="${inoculation.vaccineType eq 1 || inoculation.vaccineType eq 3 || inoculation.vaccineType eq 4 }">
								<c:choose>
								<c:when test="${inoculation.pneumoniaVaccFlag eq 1 }">
									已接种
								</c:when>
								<c:otherwise>
									未接种	
								</c:otherwise>
								</c:choose>
								</c:if>
								<c:if test="${inoculation.vaccineType eq 5 || inoculation.vaccineType eq 6 }">
								<c:choose>
								<c:when test="${inoculation.inoculateMark eq 1 }">
									已接种
								</c:when>
								<c:when test="${inoculation.inoculateMark eq 0 }">
									放弃接种
								</c:when>
								<c:otherwise>
									未接种	
								</c:otherwise>
								</c:choose>
								</c:if>
							</ehr:tip>
						</td>
					    <td style="text-align: center;">
					    	<a href="javascript:void(0);" onclick="inoculationIndex.viewInoculation(${inoculation.id})" >查看</a>
					    	<a href="javascript:void(0);" onclick="inoculationIndex.deleteInoculation(${inoculation.id})" >删除</a>
					    	<c:if test="${(inoculation.vaccineType eq 5 || inoculation.vaccineType eq 6) && inoculation.inoculateMark eq null}">
					    		<a href="javascript:void(0);" onclick="inoculationIndex.finishInoculation(${inoculation.id})" >已接钟</a>
					    		<a href="javascript:void(0);" onclick="inoculationIndex.giveUpInoculation(${inoculation.id})" >放弃接种</a>
					    	</c:if>
					    </td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="inoculationIndex.search"/>
		</tr>
	</table>	
</div>
