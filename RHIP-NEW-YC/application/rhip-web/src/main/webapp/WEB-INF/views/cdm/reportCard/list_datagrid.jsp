<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--viewType用来标志是否显示审核操作列,由其form查询页面设置 --%>
<ehr:authorize ifAnyGranted="0207,0107,0307">
	<c:set var="appAble" value="${viewType eq 1 and selectedReportStatus ne '9'}" ></c:set>
</ehr:authorize>
<ehr:authorize ifAnyGranted="0407">
	<c:set var="appAble" value="${viewType eq 1 and selectedReportStatus eq 7}" ></c:set>
</ehr:authorize>
<table id="reportCard_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style=" width: 9%;" />
			<col style="width: 8%" />
			<col style="width: 18%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 8%" />
			<col style="width: 11%" />
			<col style="width: 11%" />
			<c:if test="${appAble}">
					<col  style="width: 6%" />
			</c:if>
		</colgroup>
			
		
		<thead> 
			<tr>
					<th >姓名</th>
					<th >性别</th> 
					<th>身份证号</th>
					<th>出生日期</th>
					<th>患病类型</th>
					<th >上报医生</th>
					<th >上报机构</th>
					<th >上报时间</th>
					<th >报卡状态</th>
					<c:if test="${appAble}">
						<th >操作</th>
					</c:if>
			</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach var="personInfo" items="${personInfoList}" varStatus="status">
                        <tr  id="reportRow${status.index}"  class="reportRow${status.index}" >
                        	 <%--reportSize 计算出需要合并的行,实现一个人多个报卡的效果 --%>
                        	<c:set var="reportSize" value="${fn:length(personInfo.reportInfoList)}"></c:set>
                            <td  rowspan="${reportSize}" class="centertd">
	                            <input class="selectedValue" type="hidden" value="${personInfo.personId}" />
	                            <a title="点击查看 ${personInfo.name} 的报卡详细信息" class="report-link" data-personid="${personInfo.personId}"  href="javascript:void(0)" >${personInfo.name}</a>
	                        </td>
                            <td rowspan="${reportSize}" class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code = "${personInfo.gender}"/></ehr:tip></td>
                             <td rowspan="${reportSize}" class="centertd"><ehr:ehrBrwLink personId="${personInfo.personId}" ><ehr:tip>${personInfo.idcard}</ehr:tip></ehr:ehrBrwLink>
                             </td>
                             <td rowspan="${reportSize}" class="centertd">
                             		<ehr:tip><fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/></ehr:tip>
                             </td>
                             <%--此处只循环一次 --%>
                       	 	<c:forEach var="disease" end="0" items="${personInfo.reportInfoList}">
                             					<td class="centertd"><ehr:tip><ehr:dic dicmeta="DMD00004"  code="${disease.disType}" /><c:if test="${ disease.reportType == '2'}">(死亡)</c:if></ehr:tip></td>
                             					<td class="centertd"><ehr:tip trim="true">
                             					<c:if test="${not empty disease.createDoctorCode }">
                             						<ehr:user userCode="${disease.createDoctorCode}"></ehr:user> 
                             					</c:if>
                             					<c:if test="${ empty disease.createDoctorCode }">
                             						${disease.createDoctorName}
                             					</c:if>
                             					</ehr:tip></td>
                             					<td ><ehr:tip><ehr:org code="${disease.createOrganCode}"></ehr:org> </ehr:tip></td>
                             					<td class="centertd"><ehr:tip><fmt:formatDate value='${disease.createDate}' pattern='yyyy/MM/dd'/></ehr:tip></td>
                             					<td class="centertd"><ehr:tip><ehr:dic dicmeta="DMD00005" code="${disease.reportStatus}"></ehr:dic></ehr:tip></td>
												<c:if test="${appAble}">
													<%--
																selectedReportStatus的说明:
																<option title="防保科待审批" value="1">防保科待审批</option>
																<option title="慢病科退回" value="2">慢病科退回</option>
																<option title="慢病科已审批" value="4">慢病科已审批</option>
																<option title="社区站分配退回" value="8">社区站分配退回</option>
																<option title="防保科已审批" value="3">防保科已审批</option>
																<option title="防保科分配退回" value="6">防保科分配退回</option>
													--%>
													<c:choose >
														<c:when test="${ disease.reportStatus eq '7' }">
															<td rowspan="${reportSize}" >
																<%-- <a title="处理报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)">处理</a> --%>
																<a title="处理报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)"><i class="layui-icon">&#xe620;</i></a>
															</td>
														</c:when>

														<c:when test="${disease.reportStatus eq '1' || disease.reportStatus eq '2' || disease.reportStatus eq '1,2' || disease.reportStatus eq '3'  }">
															<td rowspan="${reportSize}" >
																<%-- <a title="审核报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)">审核</a> --%>
																<a title="审核报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)"><i class="layui-icon">&#xe642;</i></a>
															</td>
														</c:when>

														<c:when test="${disease.reportStatus eq '4' || disease.reportStatus eq '8' || disease.reportStatus eq '4,8'  || disease.reportStatus eq '6' || disease.reportStatus eq '12' }">
															<td rowspan="${reportSize}" >
																<%-- <a title="分配报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)">分配/退回</a> --%>
																<a title="分配报卡-分配/退回" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)"><i class="layui-icon">&#xe631;</i></a>
															</td>
														</c:when>
														<c:otherwise>
															<td rowspan="${reportSize}" >
																<%-- <a title="审核报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)">审核</a> --%>
																<a title="审核报卡" class="app-report-link" data-selectedreportstatus="${selectedReportStatus}" data-personid="${personInfo.personId}" href="javascript:void(0)"><i class="layui-icon">&#xe642;</i></a>
															</td>
														</c:otherwise>

													</c:choose>

												</c:if>
                        	</c:forEach>
                        </tr>
                        <%--此处从第二次开始循环 --%>
                        <c:forEach var="disease" begin="1" items="${personInfo.reportInfoList}">
                             				<tr  id="reportRow${status.index}"  class="reportRow${status.index}" >
                             					<td class="centertd"><ehr:tip><ehr:dic dicmeta="DMD00004"  code="${disease.disType}"     /><c:if test="${ disease.reportType == '2'}">(死亡)</c:if></ehr:tip></td>
                             					<td class="centertd"><ehr:tip trim="true">
                             					<c:if test="${not empty disease.createDoctorCode }">
                             						<ehr:user userCode="${disease.createDoctorCode}"></ehr:user> 
                             					</c:if>
                             					<c:if test="${ empty disease.createDoctorCode }">
                             						${disease.createDoctorName}
                             					</c:if>
                             					</ehr:tip></td>
                             					<td ><ehr:tip><ehr:org code="${disease.createOrganCode}"></ehr:org></ehr:tip></td>
                             					<td class="centertd"><ehr:tip><fmt:formatDate value='${disease.createDate}' pattern='yyyy/MM/dd'/></ehr:tip></td>
                             					<td class="centertd"><ehr:tip> <ehr:dic dicmeta="DMD00005" code="${disease.reportStatus}"></ehr:dic></ehr:tip> </td>
                           				</tr>
                        </c:forEach>
           </c:forEach>
           <tr>
           	<c:if test="${appAble}">
							<ehr:pagination colspan="10" action="reportCardList.search" ></ehr:pagination>
			</c:if>
			
           	<c:if test="${true !=appAble}">
							<ehr:pagination colspan="9" action="reportCardList.search" ></ehr:pagination>
			</c:if>
           </tr>
		</tbody> 
	</table>
