<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:30px;"/>
			<col style="width:35px;"/>
			<col style="width:40px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:30px;"/>
		</colgroup>
		<thead>
			  <tr>
				 <th>姓名</th>
				 <th>性别</th>
				 <th>出生年月</th>
				 <th>第一类危险因素</th>
				 <th>第二类危险因素</th>
				 <th>操作</th>
			  </tr>
	   </thead>
	   <tbody style="text-align: center">
			 <c:forEach var="personInfoList" items="${personInfo}">
			 	<tr id="tr${personInfoList.personId}">
			 		<td class="centertd"><a title="${personInfoList.name}" href="javascript:void(0)" id = "preventiveManageSelect${personInfoList.personId}" data-id = "${personInfoList.personId}" >${personInfoList.name}</a></td>
			 		<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${personInfoList.gender}"/></ehr:tip></td>
			 		<td class="centertd"><ehr:tip><fmt:formatDate value="${personInfoList.birthday}" pattern="yyyy/MM/dd"/></ehr:tip></td>
			 		<td class="centertd">
			 			<ehr:tip>
							<c:forEach var="firstClassStandardList" items="${personInfoList.firstClassStandard}">
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000001'}"> 吸烟;</c:if>
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000002'}"> &nbsp;血糖</c:if>
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000003'}"> &nbsp;血脂</c:if>
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000004'}"> &nbsp;腰围(男)</c:if>
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000005'}"> &nbsp;腰围(女)</c:if>
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000014'}"> &nbsp;收缩压</c:if>
								<c:if test="${firstClassStandardList.parameterId eq 'CDM0000015'}"> &nbsp;舒张压</c:if>
							</c:forEach>
						</ehr:tip>
			 		</td>
			 		<td class="centertd">
						<c:choose>
							<%--园区一期的危险因素迁移数据时存入属性df中--%>
							<c:when test="${personInfoList.secondClassStandard.size()== null && personInfoList.secondClassStandard.size()== null}">
								${personInfoList.dfName}
							</c:when>
							<c:otherwise>
								<ehr:tip>
									<c:forEach var="secondClassStandardList" items="${personInfoList.secondClassStandard}">
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000007'}"> 超重</c:if>
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000008'}"> &nbsp;缺少运动</c:if>
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000009'}"> &nbsp;吸烟</c:if>
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000010'}"> &nbsp;饮酒</c:if>
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000011'}"> &nbsp;总胆固醇</c:if>
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000012'}"> &nbsp;甘油三酯</c:if>
										<c:if test="${secondClassStandardList.parameterId eq 'CDM0000013'}"> &nbsp;遗传</c:if>
									</c:forEach>
								</ehr:tip>
							</c:otherwise>
						</c:choose>
			 		<td class="centertd">
			 		<%-- <a href="#"  id = "preventiveManageInto${personInfoList.personId}" data-id = "${personInfoList.personId}" >纳入管理</a> --%>
			 		<a href="#" title="纳入管理" id="preventiveManageInto${personInfoList.personId}" data-id = "${personInfoList.personId}" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>纳入</a>
			 		</td>
			 	</tr>
			 </c:forEach>
			 <tr>
			 	<td colspan="6">
			 		<ehr:paging />
			 	</td>
			 </tr>
	   </tbody>
	</table>
	<%-- <ehr:paging /> --%>
</div>