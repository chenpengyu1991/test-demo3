<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 8%;"/>
	        <col style="min-width:120px;width: 14%;"/>
			<col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:100px;width: 14%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 12%;"/>
			<col style="min-width:80px;width: 12%;"/>
			<col style="min-width:60px;width: 7%;"/>
            <col style="min-width:60px;width: 7%;"/>
			<c:choose>
				<c:when test="${'1' == logoff}">
					<col style="min-width:80px;"/>
				</c:when>
				<c:otherwise>
					<ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
						<col style="min-width:80px;"/>
					</ehr:authorize>
				</c:otherwise>
			</c:choose>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>性别</th>
				<th>传染病名称</th>
				<th>上报日期</th>
				<th>上报单位</th>
				<th>填写单位</th>
				<th>作废</th>
                <th>状态</th>
				<c:choose>
					<c:when test="${'1' == logoff}">
						<th>操作</th>
					</c:when>
					<c:otherwise>
						<ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
							<th>操作</th>
						</ehr:authorize>
					</c:otherwise>
				</c:choose>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
                <c:if test="${'1' == report.logoff}">
                    <tr class="offedperson">
	                    <td class="centertd" title="${report.name}">
	                        ${report.name}
	                    </td>
						<c:choose>
							<c:when test="${'HIV' eq report.infectiousName || '艾滋病' eq report.infectiousName }">
								<td title="${report.idcard}" class="centertd"><ehr:ehrBrwLink personId="${report.personId}" idCard="${report.idcard}">${fn:substring(report.idcard, 0, 6)}************</ehr:ehrBrwLink></td>
							</c:when>
							<c:otherwise>
								<td title="${report.idcard}" class="centertd"><ehr:ehrBrwLink personId="${report.personId}" idCard="${report.idcard}">${report.idcard}</ehr:ehrBrwLink></td>
							</c:otherwise>
						</c:choose>
						<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
						<td title="${report.infectiousName}">${report.infectiousName}</td>
						<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
						<td title="${report.fillOrganName}">${report.fillOrganName}</td>
						<td title="<ehr:org code="${report.modifySurveyOrg}"/>"><ehr:org code="${report.modifySurveyOrg}"/></td>
	                    <td class="centertd">
		                    <c:choose>
		                        <c:when test="${report.validCaseStatus=='0'}">
		                            	已作废&nbsp;
		                        </c:when>
		                     </c:choose>
		                </td>
	                    <td class="centertd">
	                        <c:choose>
	                            <c:when test="${tab=='case'}">
	                               <ehr:dic code="${report.caseStatus}"  dicmeta="IDM00619"></ehr:dic>
	                            </c:when>
	                        </c:choose>
	                    </td>
						<td class="centertd">
						    <c:choose>
								<c:when test="${report.caseStatus==3 && report.isOperate == 1}">
									<a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',3, '${report.logoff}')"class="person-link-btn">
	                                    <c:if test="${tab == 'case'}">处置查看</c:if>
	                                </a>&nbsp;
								</c:when>
								<c:otherwise>
									结案
								</c:otherwise>
							</c:choose>
						</td>
	                </tr>
                </c:if>
                <c:if test="${'1' != report.logoff}">
                    <tr>
	                    <td class="centertd" title="${report.name}">
	                        <%--<a href="javascript:void(0)" onclick="caseSearch.print(${report.id})"class="person-link-btn">${report.name}</a>--%>
	                        ${report.name}
	                    </td>
						<c:choose>
							<c:when test="${'HIV' eq report.infectiousName || '艾滋病' eq report.infectiousName }">
								<td title="${report.idcard}" class="centertd"><ehr:ehrBrwLink personId="${report.personId}" idCard="${report.idcard}">${fn:substring(report.idcard, 0, 6)}************</ehr:ehrBrwLink></td>
							</c:when>
							<c:otherwise>
								<td title="${report.idcard}" class="centertd"><ehr:ehrBrwLink personId="${report.personId}" idCard="${report.idcard}">${report.idcard}</ehr:ehrBrwLink></td>
							</c:otherwise>
						</c:choose>
						<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
						<td title="${report.infectiousName}">${report.infectiousName}</td>
						<%--<td class="centertd">--%>
							<%--<ehr:dic  dicmeta="FS10063" code="${report.infectiousType}" />--%>
						<%--</td>--%>
						<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
						<td title="${report.fillOrganName}">${report.fillOrganName}</td>
						<td title="<ehr:org code="${report.modifySurveyOrg}"/>"><ehr:org code="${report.modifySurveyOrg}"/></td>
	                    <td class="centertd">
		                    <c:choose>
		                        <c:when test="${report.validCaseStatus=='0'}">
		                            	已作废&nbsp;
		                        </c:when>
		                     </c:choose>
		                </td>
	                    <td class="centertd">
	                        <c:choose>
	                            <c:when test="${tab=='case'}">
	                               <ehr:dic code="${report.caseStatus}"  dicmeta="IDM00619"></ehr:dic>
	                            </c:when>
	                        </c:choose>
	                    </td>
	                	<ehr:authorize ifAnyGranted="${ZCRB}">
							<td class="centertd">
								<c:choose>
									<c:when test="${report.caseStatus==1 || report.caseStatus==null || report.caseStatus==4}">
										<c:choose>
											<c:when test="${report.isOperate == 1 &&  report.validCaseStatus!='0'}">							
	                                            <c:if test="${ '1' ne report.assignmentStatus}">                                            
	                                            	<c:if test="${report.caseStatus==4}">
			                                            <a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')" class="person-link-btn">
			                                                	<c:if test="${tab == 'case'}">处置修改${report.validCaseStatus}</c:if>
			                                            </a>&nbsp;
		                                            </c:if>
	     
		                                            <c:if test="${report.caseStatus==1 || report.caseStatus==null}">
		                                            	<a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',1, '${report.logoff}')" class="person-link-btn">
		                                                	<c:if test="${tab == 'case'}">处置填写${report.validCaseStatus}</c:if>
		                                                </a>&nbsp;
			                                            <a href="javascript:void(0)" onclick="caseSearch.assign(${report.id})" class="person-link-btn">
			                                                                                                                      处置分配             
			                                            </a>
			                                         </c:if>
	                                            </c:if> 
	                                            <c:if test="${report.assignmentStatus == '1' && report.assignedToUnit == currentOrgCode}"> 
	                                             	<a href="javascript:void(0)" onclick="caseSearch.confirm(${report.id})" class="person-link-btn">
		                                                                                                                      处置纳入          
		                                            </a>
	                                            </c:if> 
	                                            <c:if test="${report.assignmentStatus == '1' && report.currentUnit == currentOrgCode}"> 
		                                                                                                                      等待纳入          
	                                            </c:if> 
											</c:when>
										</c:choose>
									</c:when>
									<c:when test="${report.caseStatus==2 &&  report.validCaseStatus!='0'}">
										<c:choose>
											<c:when test="${report.isOperate == 1}">
												<a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"class="person-link-btn">
	                                                <c:if test="${tab == 'case'}">处置修改</c:if>
	                                            </a>&nbsp;
											</c:when>
										</c:choose>
	
									</c:when>
									<c:when test="${report.caseStatus==3}">
										<c:choose>
											<c:when test="${report.isOperate == 1}">
												<a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',3, '${report.logoff}')"class="person-link-btn">
	                                                <c:if test="${tab == 'case'}">处置查看</c:if>
	                                            </a>&nbsp;
											</c:when>
										</c:choose>
	
									</c:when>
								</c:choose>
							</td>
	                	</ehr:authorize>
	                 	<ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB}">
							<td class="centertd">
								<c:choose>
									<c:when test="${report.caseStatus==1 || report.caseStatus==null || report.caseStatus==4}">
										<c:choose>
											<c:when test="${report.isOperate == 1 &&  report.validCaseStatus!='0'}">							
	                                            <c:if test="${ '1' ne report.assignmentStatus}">                                            
	                                            	<c:if test="${report.caseStatus==4}">
			                                           <%--  <a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"class="person-link-btn">
			                                                	<c:if test="${tab == 'case'}">处置修改${report.validCaseStatus}</c:if>
			                                            </a> --%>
			                                            
			                                            <a <c:if test="${tab == 'case'}">title="处置修改"</c:if> href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"class="person-link-btn">
			                                                	<c:if test="${tab == 'case'}"><i class="layui-icon">&#xe642;</i>${report.validCaseStatus}</c:if>
			                                            </a>
			                                            &nbsp;
		                                            </c:if>
	     
		                                            <c:if test="${report.caseStatus==1 || report.caseStatus==null}">
		                                            	<%-- <a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',1, '${report.logoff}')" class="person-link-btn">
		                                                	<c:if test="${tab == 'case'}">处置填写${report.validCaseStatus}</c:if>
		                                                </a> --%>
		                                                <a <c:if test="${tab == 'case'}">title="处置填写"</c:if> href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',1, '${report.logoff}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;">
		                                                	<c:if test="${tab == 'case'}"><i class="layui-icon">&#xe642;</i>填写${report.validCaseStatus}</c:if>
		                                                </a>
		                                                &nbsp;
			                                            <a title="处置分配" href="javascript:void(0)" onclick="caseSearch.assign(${report.id})" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;">
			                                                                                                                      <%-- 处置分配  --%> 
			                                                                  <i class="layui-icon">&#xe672;分配</i>
			                                            </a>
			                                         </c:if>
	                                            </c:if> 
	                                            <c:if test="${report.assignmentStatus == '1' && report.assignedToUnit == currentOrgCode}"> 
	                                             	<a title="处置纳入" href="javascript:void(0)" onclick="caseSearch.confirm(${report.id})" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;">
		                                                                                                                      <%-- 处置纳入 --%>      
		                                                                       <i class="layui-icon">&#xe601;纳入</i>
		                                            </a>
	                                            </c:if> 
	                                            <c:if test="${report.assignmentStatus == '1' && report.currentUnit == currentOrgCode}"> 
		                                                                                                                      等待纳入          
	                                            </c:if> 
											</c:when>
										</c:choose>
									</c:when>
									<c:when test="${report.caseStatus==2 &&  report.validCaseStatus!='0'}">
										<c:choose>
											<c:when test="${report.isOperate == 1&& (report.infectiousCode=='101' || report.infectiousCode=='102' || report.infectiousCode=='2121' || report.infectiousCode=='204' || report.infectiousCode=='201')}">
												<a <c:if test="${tab == 'case'}">title="处置修改"</c:if> href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"class="person-link-btn">
	                                                <c:if test="${tab == 'case'}"><i class="layui-icon">&#xe642;</i></c:if>
	                                            </a>&nbsp;
											</c:when>
										</c:choose>
										<c:choose>
											<c:when test="${report.isOperate == 1 && !(report.infectiousCode=='101' || report.infectiousCode=='102' || report.infectiousCode=='2121' || report.infectiousCode=='204' || report.infectiousCode=='201')}">
												<a <c:if test="${tab == 'case'}">title="审核"</c:if>  href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"class="person-link-btn">
	                                                <c:if test="${tab == 'case'}"><i class="layui-icon">&#xe672;</i></c:if>
	                                            </a>&nbsp;
											</c:when>
										</c:choose>
									</c:when>		
									<c:when test="${report.caseStatus==3}">
										<c:choose>
											<c:when test="${report.isOperate == 1}">
												<a <c:if test="${tab == 'case'}">处置查看</c:if> href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',3, '${report.logoff}')"class="person-link-btn">
	                                                <c:if test="${tab == 'case'}"><i class="layui-icon">&#xe615;</i></c:if>
	                                            </a>&nbsp;
											</c:when>
										</c:choose>
	
									</c:when>
								</c:choose>
							</td>
	                	</ehr:authorize>
						<ehr:authorize ifAnyGranted="${JKFYK}">
							<td class="centertd">
								<c:choose>
									<c:when test="${report.caseStatus==1 || report.caseStatus==null}">
										<c:choose>
											<c:when test="${report.isOperate == 1 && report.validCaseStatus!='0'}">
											   <c:if test="${ '1' ne report.assignmentStatus}">
													<%-- <a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',1, '${report.logoff}')" class="person-link-btn">
														<c:if test="${tab == 'case'}">处置填写</c:if>
													</a> --%>

													<a <c:if test="${tab == 'case'}">title="处置填写"</c:if> href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',1, '${report.logoff}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;">
														<c:if test="${tab == 'case'}"><i class="layui-icon">&#xe642;</i>填写</c:if>
													</a>
													&nbsp;
												   <%--  <a href="javascript:void(0)" onclick="caseSearch.assign(${report.id})" class="person-link-btn">
																															  处置分配
													</a> --%>

													<a href="javascript:void(0)" onclick="caseSearch.assign(${report.id})" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="处置分配" ><i class="layui-icon">&#xe672;</i>分配</a>
												</c:if>
												<c:if test="${report.assignmentStatus == '1' && report.assignedToUnit == currentOrgCode}">
													<%-- <a href="javascript:void(0)" onclick="caseSearch.confirm(${report.id})" class="person-link-btn">
																															  处置纳入
													</a> --%>
													<a href="javascript:void(0)" onclick="caseSearch.confirm(${report.id})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="处置纳入"><i class="layui-icon">&#xe601;纳入</i>
													</a>
												</c:if>
												<c:if test="${report.assignmentStatus == '1' && report.currentUnit != currentOrgCode}">
													等待纳入
												</c:if>
											</c:when>
										</c:choose>
									</c:when>
									<c:when test="${report.caseStatus==2 && report.validCaseStatus!='0'}">
										<c:choose>
											<c:when test="${report.isOperate == 1 && (report.infectiousCode=='101' || report.infectiousCode=='102' || report.infectiousCode=='2121' || report.infectiousCode=='204' || report.infectiousCode=='201')}">
												<a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" class="advanceSearchSection" style="display: none;" <c:if test="${tab == 'case'}">title="审核"</c:if> >
													<c:if test="${tab == 'case'}">
														<%-- 审核 --%>
														<i class="layui-icon">&#xe672;审核</i>
														</c:if>
												</a>&nbsp;
											</c:when>
										</c:choose>

									</c:when>
									<c:when test="${report.caseStatus==3}">
										<c:choose>
											<c:when test="${report.isOperate == 1}">
												<a href="javascript:void(0)" onclick="caseSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',3, '${report.logoff}')"class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" <c:if test="${tab == 'case'}">title="处置查看"</c:if> >
													<c:if test="${tab == 'case'}">
															<%-- 处置查看 --%>
															<i class="layui-icon">&#xe615;查看</i>
													</c:if>
												</a>&nbsp;
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>
							</td>
						</ehr:authorize>
                </tr>
                </c:if>
			</c:forEach>
			<tr>
			    <c:choose>
				<c:when test="${'1' == logoff}">
					<ehr:pagination action="caseSearch.search" colspan="10" />
				</c:when>
				<c:otherwise>
					<ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
						<ehr:pagination action="caseSearch.search" colspan="10" />
					</ehr:authorize>
					<ehr:authorize ifNotGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
						<ehr:pagination action="caseSearch.search" colspan="9" />
					</ehr:authorize>
				</c:otherwise>
			</c:choose>
		    </tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="caseSearch.search" />
		</tr>
	</table> --%>
</div>