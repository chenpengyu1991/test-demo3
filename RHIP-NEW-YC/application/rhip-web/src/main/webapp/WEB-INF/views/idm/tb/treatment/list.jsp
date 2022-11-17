<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<c:set var="DCMR" value="<%=TbStatus.DCMR.getValue()%>"/>
<c:set var="TREATMENT" value="<%=TbStatus.TREATMENT.getValue()%>"/>
<c:set var="ASSIGN" value="<%=TbStatus.ASSIGN.getValue()%>"/>
<c:set var="ACCEPT" value="<%=TbStatus.ACCEPT.getValue()%>"/>
<c:set var="RETURN" value="<%=TbStatus.RETURN.getValue()%>"/>
<c:set var="CANCEL" value="<%=TbStatus.CANCEL.getValue()%>"/>
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>
<c:set var="REASSIGN" value="<%=TbStatus.REASSIGN.getValue()%>"/>

<%--<c:set var="JFS" value="18" />
<c:set var="SQZX" value="03" />
<c:set var="SJYYFBK" value="19" />
<c:set var="SQZ" value="02" />
<c:set var="JKJH" value="91" />
<c:set var="DDCRBYY" value="21" />--%>

<c:set var="JFS" value="0109" />
<c:set var="SQZX" value="0209" />
<c:set var="SJYYFBK" value="0309" />
<c:set var="SQZ" value="0409" />
<c:set var="JKJH" value="0109" />
<c:set var="DDCRBYY" value="0320" />
<div class="repeattable">
	<input type="hidden" id="currentPageTreatment" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:8%;"/>
	        <col style="width:5%;"/>
	        <col style="width:15%;"/>
			<col style="width:8%;"/>
			<col style="width:10%;"/>		
			<col style="width:10%;"/>	
			<col style="width:10%;"/>
			<col style="width:8%;"/>
			<col style="width:26%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证号</th>
				<th>诊断结果</th>
				<th>管理方式</th>
				<th>管理状态</th>
				<th>接纳单位</th>
				<th>治疗分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="treatment" items="${treatments}" varStatus="status">
				<tr <c:if test="${treatment.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${treatment.tbDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${treatment.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${treatment.tbDto.idcard}"><ehr:tip>${treatment.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td>
                        <ehr:tip>
<ehr:dic code="${treatment.tbDto.diagnosisType}" dicmeta="IDM00224"/><c:if test="${treatment.tbDto.lastDiagnosis!=null && treatment.tbDto.lastDiagnosis!=''}"><ehr:dic code="${treatment.tbDto.lastDiagnosis}" dicmeta="IDM00237"/></c:if>
<c:if test="${treatment.tbDto.diagnosisAccording!=null && treatment.tbDto.diagnosisAccording!=''}"><c:if test="${treatment.tbDto.diagnosisAccording==1}">结核性胸膜炎Ⅳ型</c:if><c:if test="${treatment.tbDto.diagnosisAccording==2}">其他肺外结核Ⅴ型</c:if></c:if>
<c:if test="${treatment.tbDto.diagnosisReasonMulti!=null && treatment.tbDto.diagnosisReasonMulti!=''}">【<ehr:dic code="${treatment.tbDto.diagnosisReasonMulti}" dicmeta="IDM00238"/></c:if>&nbsp;${treatment.tbDto.diagnosisOther}<c:if test="${treatment.tbDto.diagnosisReasonMulti!=null && treatment.tbDto.diagnosisReasonMulti!=''}">】</c:if>
                        </ehr:tip>
					</td>
					<td class="centertd"><ehr:tip><ehr:dic code="${treatment.tbDto.manageType}" dicmeta="IDM00243"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${treatment.specialStatus == ASSIGN}">已分派</c:when>
							<c:when test="${treatment.specialStatus == ACCEPT}">已管理</c:when>
							<c:when test="${treatment.specialStatus == RETURN}">已退回</c:when>
							<c:when test="${treatment.specialStatus == REASSIGN}">已重派</c:when>
							<c:when test="${treatment.specialStatus == CANCEL}">已作废</c:when>
							<c:when test="${treatment.specialStatus == STOP}">停止治疗</c:when>
							<c:otherwise>未管理</c:otherwise>
						</c:choose>
					</td>
					<td>
						<ehr:tip><ehr:org code="${treatment.currentUnit}"/></ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
							<c:when test="${treatment.tbDto.thisType == '1'}">初治</c:when>
							<c:when test="${treatment.tbDto.thisType == '99'}">复治</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>
					</td>
					<td class="centertd">
						<c:choose>
							<c:when test="${treatment.specialStatus == STOP}">
								<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="停止治疗"><i class="layui-icon">&#xe651;</i></a>&nbsp;
							</c:when>
							<c:when test='${ROLE==JFS||ROLE eq DDCRBYY ||ROLE eq JKJH}'>
								<c:choose>
									<c:when test="${treatment.specialStatus == DCMR}">
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="查看"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="新建"><i class="layui-icon">&#xe608;</i>新建</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="查看"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'1','Treatment')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="新建" ><i class="layui-icon">&#xe608;</i>新建</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:when test="${treatment.specialStatus == TREATMENT}">
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'2','Treatment')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
												<a title="指派" href="javascript:void(0)" onclick="treatment.initAssign('${treatment.id}','${treatment.tbDto.singleId}')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;"><i class="layui-icon">&#xe631;</i>指派</a>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:when test="${treatment.specialStatus == RETURN && treatment.currentUnit == null}">
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'2','Treatment')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
												<a title="指派" href="javascript:void(0)" onclick="treatment.initAssign('${treatment.id}','${treatment.tbDto.singleId}')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;"><i class="layui-icon">&#xe631;</i>指派</a>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'2','Treatment')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:when>
							
							<c:when test='${ROLE==SJYYFBK || ROLE==SQZ}'>
								<c:choose>
									<c:when test="${treatment.specialStatus == ASSIGN || treatment.specialStatus == REASSIGN }">
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="接受"><i class="layui-icon">&#xe605;</i>接受</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="退回"><i class="layui-icon">&#xe65c;</i>退回</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a href="javascript:void(0)" onclick="treatment.updateSpecialStatus('${treatment.id}','${treatment.tbDto.singleId}','${ACCEPT}','${treatment.tbDto.name}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="接受" ><i class="layui-icon">&#xe605;</i>接受</a>
												<a href="javascript:void(0)" onclick="treatment.updateSpecialStatus('${treatment.id}','${treatment.tbDto.singleId}','${RETURN}','${treatment.tbDto.name}')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;" title="退回" ><i class="layui-icon">&#xe65c;</i>退回</a>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'2','Treatment')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:when>
							
							<c:when test='${ROLE==SQZX}'>
								<c:choose>
									<c:when test="${treatment.specialStatus == ASSIGN || treatment.specialStatus == REASSIGN || treatment.specialStatus == RETURN}">
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="指派"><i class="layui-icon">&#xe631;</i>指派</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="接受"><i class="layui-icon">&#xe605;</i>接受</a>&nbsp;
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="退回"><i class="layui-icon">&#xe65c;</i>退回</a>&nbsp;
											</c:when>
											<c:when test="${treatment.logoff != 1&&currentLoginInfo.organization.organCode ==treatment.currentUnit}" >
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a title="指派" href="javascript:void(0);" onclick="treatment.initAssign('${treatment.id}','${treatment.tbDto.singleId}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;"><i class="layui-icon">&#xe631;</i>指派</a>
												<a href="javascript:void(0)" onclick="treatment.updateSpecialStatus('${treatment.id}','${treatment.tbDto.singleId}','${ACCEPT}','${treatment.tbDto.name}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="接受" ><i class="layui-icon">&#xe605;</i>接受</a>
												<a href="javascript:void(0)" onclick="treatment.updateSpecialStatus('${treatment.id}','${treatment.tbDto.singleId}','${RETURN}','${treatment.tbDto.name}')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;" title="退回" ><i class="layui-icon">&#xe65c;</i>退回</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:when test="${treatment.specialStatus == REASSIGN}">
										<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
										<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${treatment.logoff == 1}">
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'3','Treatment')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
												<a href="javascript:void(0)" onclick="tbCommon.add('${treatment.tbDto.singleId}',${TREATMENT},'2','Treatment')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="treatment.search" colspan="9" />
			</tr>
		</tbody>
	</table>
</div>