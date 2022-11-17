<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="CURE"  value="<%=MalariaStatus.CURE.getValue()%>" />
<div class="repeattable">
	<table>
		<colgroup>
	        <col style="min-width:70px;width:70px;"/>
			<col style="min-width:60px;width:60px;"/>
	        <col style="min-width:50px;width:50px;"/>
			<col style="min-width:120px;width:80px;"/>
			<col style="min-width:80px;width:80px;"/>
			<col style="min-width:180px;width:50%;"/>
			<col style="min-width:120px;width:120px;"/>
		</colgroup>	
		<thead>
			<tr>
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
			<c:forEach var="standard" items="${malariaQueryDto}" varStatus="status">
				<tr id="${standard.idmId}" <c:if test="${standard.logoff == 1}">class="offedperson"</c:if>>
					<td title="${standard.name}">
       					${standard.name}
					</td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${standard.gender}" /></ehr:tip></td>
					<td><ehr:tip>${standard.age}</ehr:tip></td>
					<td><ehr:tip>${standard.phoneNumber}</ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="IDM00258" code="${standard.testResult}" /></ehr:tip></td>
					<td>
						<ehr:tip>${standard.paAddress}</ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
							<c:when test="${standard.specialStatus == CURE}">
								<label class="loadclass">病人死亡</label>
							</c:when>
							<c:otherwise>
		                        <c:choose>
		                            <c:when test="${standardType==1}">
										<a id="drugRegId" href="javascript:void(0)" onclick="standardSearch.addDrugreg(${standard.idmId},${standard.logoff})" >
											<c:choose>
					                 			<c:when test="${not empty standard.dId}">修改</c:when>
					                 			<c:otherwise>新增</c:otherwise>
				                 			</c:choose>
										</a>&nbsp;
		                            </c:when>
		                            <c:when test="${standardType==2}">
										<a id="drugRegId" href="javascript:void(0)" onclick="standardSearch.addEpidemicFocus(${standard.idmId},${standard.logoff})" >
											<c:choose>
					                 			<c:when test="${not empty standard.eId}">修改</c:when>
					                 			<c:otherwise>新增</c:otherwise>
				                 			</c:choose>									
										</a>&nbsp;
		                            </c:when>
		                            <c:when test="${standardType==3}">
										<a id="drugRegId" href="javascript:void(0)" onclick="standardSearch.addVisit(${standard.idmId},${standard.logoff})" >访视记录</a>&nbsp;
		                            </c:when>
		                            <c:when test="${standardType==4}">
										<a id="drugRegId" href="javascript:void(0)" onclick="standardSearch.addRestDrugreg(${standard.idmId},${standard.logoff})" >
											<c:choose>
					                 			<c:when test="${not empty standard.rId}">修改</c:when>
					                 			<c:otherwise>新增</c:otherwise>
				                 			</c:choose>											
										</a>&nbsp;
		                            </c:when>
		                            <c:when test="${standardType==5}">
										<a id="drugRegId" href="javascript:void(0)" onclick="standardSearch.addDrugreg()" >重点人群休止期服药</a>&nbsp;
		                            </c:when>
		                            <c:when test="${standardType==6}">
										<a id="restinPhase" href="javascript:void(0)" onclick="standardSearch.addRestDrugreg()">主动病例侦查记录</a>
		                            </c:when>
		                        </c:choose>								
							</c:otherwise>
						</c:choose>

                	</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="standardSearch.searchStandard" />
		</tr>
	</table>
</div>