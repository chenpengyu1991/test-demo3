<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKWJ" value="<%=RoleType.JKWJ.getValue()%>"/>
<script type="text/javascript">
    $(document).ready(function() {
        healthEducationUpload.uploadFile("cdmCardDiFile", "/he/upload/uploadFile/mbglktnb", "/he/upload/deleteFile/mbglktnb");
        healthEducationUpload.uploadFile("cdmCardDiFile_1", "/he/upload/uploadFile/mbglktnb", "/he/upload/deleteFile/mbglktnb");
        
        layui.use('multiSelect', function() {
        	var multiSelect =  layui.multiSelect;
        	multiSelect.render(); // 解决多选框不显示问题
        	});
    });
</script>

	<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<c:choose>
			<c:when test="${isBringIntoManage==true}">
				<tr>
					<th><label class="required" >糖尿病类型</label></th>
					<td>
						<input type="hidden" name="diType" value="${diseaseInfo.diType}"/>
						<ehr:dic dicmeta="DMD00007" code="${diseaseInfo.diType}" />
					</td>
					<th><label class="required" for="diDiagnosedOrganCode">确诊医院</label></th>
					<td>
						<%--<input type="hidden" name="diDiagnosedOrganCode" value="${diseaseInfo.diDiagnosedOrganCode}"  />  <input type="text" reg="{'required':true}" readonly="readonly" value='<ehr:org  code="${diseaseInfo.diDiagnosedOrganCode}"/>'/>
                        --%>
						<input type="hidden" name="diDiagnosedOrganCode" value="${diseaseInfo.diDiagnosedOrganCode}"  />
						<input type="hidden" name="diOtherDiagnosisOrganFlag" value="${diseaseInfo.diOtherDiagnosisOrganFlag}"  />
						<input type="hidden" name="diOtherDiagnosisOrganName" value="${diseaseInfo.diOtherDiagnosisOrganName}"  />
                        <c:if test="${diseaseInfo.diOtherDiagnosisOrganFlag eq '2' }">
                            ${diseaseInfo.diOtherDiagnosisOrganName}
                        </c:if>
						<c:if test="${diseaseInfo.diOtherDiagnosisOrganFlag ==null || diseaseInfo.diOtherDiagnosisOrganFlag != '2' }">
                            <ehr:org flag="0" code="${diseaseInfo.diDiagnosedOrganCode}"></ehr:org>
                        </c:if>
					</td>
				</tr>
				<tr>
					<th ><label class="required" for="diDiagnosedDate">确诊时间</label></th>
					<td valign="top" style="vertical-align:top">
						<input type="hidden" name="diDiagnosedDate" value='<fmt:formatDate value="${diseaseInfo.diDiagnosedDate}" pattern="yyyy/MM/dd" />' />
						<fmt:formatDate value="${diseaseInfo.diDiagnosedDate}"  pattern="yyyy/MM/dd" />
					</td>
					<th><label  for="diDiagnosedWay">确诊方式</label></th>
					<td><ehr:dic dicmeta="DMD00010" code="${diseaseInfo.diDiagnosedWay}" /><input type="hidden" name="diDiagnosedWay" value='${diseaseInfo.diDiagnosedWay}' /></td>
				</tr>
				<%-- <tr id="diFileViewTrId">
					<th><label class="required" >糖尿病附件</label></th>
					<td colspan="3">
						<div style="width: 690px;">
							<c:forEach items="${attchesDi}" var="attche" >
								<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
									<c:if test="${attche.imageFlag eq true}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																				   src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
										/></a>
									</c:if>
									<c:if test="${attche.imageFlag eq false}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
									</c:if>
									<br />
									<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
								</div>
							</c:forEach>
						</div>
					</td>
				</tr> --%>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${isHealth==true}"><%--健康档案创建慢病管理卡 --%>
						<tr>
							<th><label class="required" >糖尿病类型</label></th>
							<td style="vertical-align:top">
								<ehr:dic-list width="180px;" dicmeta="DMD00007" name="diType" value="${diseaseInfo.diType}" reg="{'required':true}" code="2"/>
							</td>
							<th ><label class="required" for="diDiagnosedOrganCode">确诊医院</label></th>
							<td>
								<span id="diDiagnosedSpanId" style="display:<c:if test="${diseaseInfo.diOtherDiagnosisOrganFlag eq '2'}">none;</c:if>">
									<tag:autoSelect name="diDiagnosedOrganCode" id="diDiagnosedOrganCode" codeValue="${diseaseInfo.diDiagnosedOrganCode}" reg="{'required':false}"  ></tag:autoSelect>
								</span>
								外地诊断:<input id="diOtherDiagnosisOrganFlag" type="checkbox" value="2" name="diOtherDiagnosisOrganFlag" ${diseaseInfo.diOtherDiagnosisOrganFlag eq '2' ?'checked':''} />
								<span id="diDiagnosedNameSpanId" style="display:<c:if test="${!diseaseInfo.diOtherDiagnosisOrganFlag ne '2'}">none;</c:if>">
									<input id="diOtherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'diOtherDiagnosisOrganFlag','required':true}" type="text" value="${diseaseInfo.diOtherDiagnosisOrganName}" name="diOtherDiagnosisOrganName">
								</span>
							</td>
						</tr>
						<tr>
							<th ><label class="required" for="diDiagnosedDate">确诊时间</label></th>
							<td valign="top" style="vertical-align:top">
								<%-- <tag:dateInput style="width:180px;" onlypast="true" id="diDiagnosedDate" name="diDiagnosedDate" date="${diseaseInfo.diDiagnosedDate}" reg="{'required':true}" /> --%>
								<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="diDiagnosedDate" id="diDiagnosedDate" value="<fmt:formatDate value='${diseaseInfo.diDiagnosedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
							<th><label  for="diDiagnosedWay">确诊方式</label></th>
							<td>
							<div class="layui-form">
								<ehr:dic-list width="150px;" id="diDiagnosedWay"  type="true"  dicmeta="DMD00010"  name="diDiagnosedWay" value="${diseaseInfo.diDiagnosedWay}" reg="{'required':true}" />
							</div>
							</td>
						</tr>
						 <tr id="">
							<th></th>
							<td colspan="3">
								<div style="width: 690px;">
									<c:forEach items="${attchesDi}" var="attche" >
										<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
											<c:if test="${attche.imageFlag eq true}">
												<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																						   src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
												/></a>
											</c:if>
											<c:if test="${attche.imageFlag eq false}">
												<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
											</c:if>
											<br />
											<%--<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>--%>
										</div>
									</c:forEach>
								</div>
							</td>
						</tr>
						<%--<tr>
							<th><label class="required">附件</label></th>
							<td colspan="3"><div id="cdmCardDiFile_1"></div>
								<span style="color: red;">本附件需提供乡镇及乡镇以上医疗机构疾病诊断相关佐证材料（诊断证明、处方、病历、病案） </span>
								<br/>
                                <span style="color: blue;">注：单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改),附件数量不能超过5个</span>
                            </td>
						</tr>--%>
					</c:when>
					<c:otherwise><%--查看慢病管理卡 --%>
						<tr>
							<th><label class="required" >糖尿病类型</label></th>
							<td style="vertical-align:top">
								<ehr:dic dicmeta="DMD00007" code="${diseaseInfo.diType}"/>
								<input type="hidden" id="diType" name="diType" value="${diseaseInfo.diType}"/>
							</td>
							<th ><label class="required" for="diDiagnosedOrganCode">确诊医院</label></th>
							<td>
<%--								<c:choose>
									<c:when test="${diseaseInfo.diOtherDiagnosisOrganFlag eq '2' }">
										${diseaseInfo.diOtherDiagnosisOrganName}
										<input type="hidden" id="diOtherDiagnosisOrganFlag" name="diOtherDiagnosisOrganFlag" value="${diseaseInfo.diOtherDiagnosisOrganFlag}"/>
										<input type="hidden" id="diOtherDiagnosisOrganName" name="diOtherDiagnosisOrganName" value="${diseaseInfo.diOtherDiagnosisOrganName}"/>
									</c:when>
									<c:when test="${diseaseInfo.diDiagnosedOrganCode != null }">
										<ehr:org flag="0" code="${diseaseInfo.diDiagnosedOrganCode}"></ehr:org>
		 								<input type="hidden" id="diDiagnosedOrganCode" name="diDiagnosedOrganCode" value="${diseaseInfo.diDiagnosedOrganCode}"/>
									</c:when>
								</c:choose>	--%>
								<span id="diDiagnosedSpanId" style="display:<c:if test="${diseaseInfo.diOtherDiagnosisOrganFlag eq '2'}">none;</c:if>">
									<tag:autoSelect name="diDiagnosedOrganCode" id="diDiagnosedOrganCode" codeValue="${diseaseInfo.diDiagnosedOrganCode}" reg="{'required':false}"  ></tag:autoSelect>
								</span>
								外地诊断:<input id="diOtherDiagnosisOrganFlag" type="checkbox" value="2" name="diOtherDiagnosisOrganFlag" ${diseaseInfo.diOtherDiagnosisOrganFlag eq '2' ?'checked':''} />
								<span id="diDiagnosedNameSpanId" style="display:<c:if test="${diseaseInfo.diOtherDiagnosisOrganFlag ne '2'}">none;</c:if>">
									<input id="diOtherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'diOtherDiagnosisOrganFlag','required':true}" type="text" value="${diseaseInfo.diOtherDiagnosisOrganName}" name="diOtherDiagnosisOrganName">
								</span>
							</td>
						</tr>
						<%-- <c:if test="${attchesDi != null }">
							<tr id="">
								<th><label class="required" >糖尿病附件</label></th>
								<td colspan="3">
									<div style="width: 690px;" id="diHaveAttemp">
										<c:forEach items="${attchesDi}" var="attche" >
											<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
												<c:if test="${attche.imageFlag eq true}">
													<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																							   src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
													/></a>
												</c:if>
												<c:if test="${attche.imageFlag eq false}">
													<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
												</c:if>
												<br />
												<ehr:authorize ifNotGranted="${ADMIN},${JKWJ}">
													<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
												</ehr:authorize>
											</div>
										</c:forEach>
									</div>
								</td>
							</tr>
						</c:if> --%>
						<%--<ehr:authorize ifNotGranted="${ADMIN},${JKWJ}">
							<tr>
								<th><label class="required">附件</label></th>
								<td colspan="3" style="width: 120px;">
									<div id="cdmCardDiFile"></div>
									<span style="color: red;">本附件需提供乡镇及乡镇以上医疗机构疾病诊断相关佐证材料（诊断证明、处方、病历、病案） </span>
									<br/>
									<span style="color: blue;">注：提供宣传材料样张照片，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span>
								</td>
							</tr>
						</ehr:authorize>--%>
						<tr>
							<th ><label class="required" for="diDiagnosedDate">确诊时间</label></th>
							<td valign="top" style="vertical-align:top">
								<%--<fmt:formatDate value="${diseaseInfo.diDiagnosedDate}" pattern="yyyy/MM/dd" />
								<input type="hidden" name="diDiagnosedDate" value='<fmt:formatDate value="${diseaseInfo.diDiagnosedDate}" pattern="yyyy/MM/dd" />' />--%>
								<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="diDiagnosedDate" id="diDiagnosedDate" value="<fmt:formatDate value='${diseaseInfo.diDiagnosedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
							<th><label  for="diDiagnosedWay">确诊方式</label></th>
							<td>
								<%--<ehr:dic dicmeta="DMD00010" code="${diseaseInfo.diDiagnosedWay}"/>
								<input type="hidden" id="diDiagnosedWay" name="diDiagnosedWay" value="${diseaseInfo.diDiagnosedWay}"/>--%>
								<div class="layui-form">
									<ehr:dic-list width="150px;" id="diDiagnosedWay"  type="true"  dicmeta="DMD00010"  name="diDiagnosedWay" value="${diseaseInfo.diDiagnosedWay}" reg="{'required':true}" />
								</div>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<c:if test="${diseaseInfo.diManagedDate != null}">
			<tr>
				<th><label>管理卡创建时间</label></th>
				<td>
					<fmt:formatDate value="${diseaseInfo.diManagedDate}" pattern="yyyy/MM/dd" />
				</td>
			</tr>
		</c:if>
	</table>
<fieldset class="layui-elem-field">
	<legend>确诊时并发症情况</legend>
		<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label for="diComHbpFlag">高血压</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComHbpFlag" name="diComHbpFlag" value="${diseaseInfo.diComHbpFlag}" /></td>
			<th><label for="diComDiFootFlag">糖尿病足</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComDiFootFlag" name="diComDiFootFlag" value="${diseaseInfo.diComDiFootFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComNeuropathyFlag">神经病变</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComNeuropathyFlag" name="diComNeuropathyFlag" value="${diseaseInfo.diComNeuropathyFlag}" /></td>
			<th><label for="diComStrokeFlag">脑卒中</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComStrokeFlag" name="diComStrokeFlag" value="${diseaseInfo.diComStrokeFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComRetyFlag">视网膜病变</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComRetyFlag" name="diComRetyFlag" value="${diseaseInfo.diComRetyFlag}" /></td>
			<th><label for="diComKidneyFlag">糖尿病肾病</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComKidneyFlag" name="diComKidneyFlag" value="${diseaseInfo.diComKidneyFlag}" /></td>
		</tr>
		<tr>
			<th><label for="diComHbcFlag">高血脂</label></th>
			<td colspan="3"><ehr:dic-radio dicmeta="FS10238" id="diComHbcFlag" name="diComHbcFlag" value="${diseaseInfo.diComHbcFlag}" /></td>
		</tr>
		<tr>
			<th><label  class="required"  for="diComFpg">既往空腹血糖</label></th>
			<td><tag:numberInput id="diComFpg" style="width:50px" point="point" name="diComFpg" value="${diseaseInfo.diComFpg}" reg="{'required':true,'max':999.9}" />mmol/L</td>
			<th><label  for="diComHgb">既往糖化血红蛋白</label></th>
			<td><tag:numberInput  id="diComHgb" style="width:50px"   point="point"  name="diComHgb" reg="{'min':0,'max':999.9}" value="${diseaseInfo.diComHgb}"/>%</td>
		</tr>
		<tr>
			<th><label for="diComSmokingFlag">吸烟</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComSmokingFlag" name="diComSmokingFlag" value="${diseaseInfo.diComSmokingFlag}" /></td>
			<th><label for="diComSmokingDailyNum">吸烟每日数量</label></th>
			<td><tag:numberInput disabled="${diseaseInfo.diComSmokingFlag != '2'}" id="diComSmokingDailyNum" name="diComSmokingDailyNum" value="${diseaseInfo.diComSmokingDailyNum}"
					reg="{'min':0,'max':999}"
				></tag:numberInput>支</td>
		</tr>
		<tr>
			<th><label for="diComDrinkingFlag">饮酒</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diComDrinkingFlag" name="diComDrinkingFlag" value="${diseaseInfo.diComDrinkingFlag}" /></td>
			<th><label for="diComDrinkingdailyNum">饮酒每日数量</label></th>
			<td><tag:numberInput disabled="${diseaseInfo.diComDrinkingFlag != '2'}" id="diComDrinkingdailyNum" name="diComDrinkingdailyNum" value="${diseaseInfo.diComDrinkingdailyNum}"
					reg="{'min':0,'max':999}"
				></tag:numberInput>两</td>
		</tr>
	</table>
</fieldset>
<fieldset class="layui-elem-field">
	<legend>糖尿病目前并发症情况</legend>
		<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<td>并发症</td>
			<td>有无</td>
			<td>诊断时间</td>
			<td>治疗方式</td>
		</tr>
		<tr>
			<th>冠心病</th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomCoronaryFlag" name="diCcomCoronaryFlag" value="${diseaseInfo.diCcomCoronaryFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomCoronaryFlag != '2'}" onlypast="true" id="diCcomCoronaryDisDate" name="diCcomCoronaryDisDate" date="${diseaseInfo.diCcomCoronaryDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomCoronaryFlag != '2'}" class="layui-input x-admin-content-sm-date" name="diCcomCoronaryDisDate" id="diCcomCoronaryDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomCoronaryDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomCoronaryFlag != '2' ? 'disabled' :''}  type="text"  id="diCcomCoronaryTreatment" name="diCcomCoronaryTreatment" value="${diseaseInfo.diCcomCoronaryTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th>高血压</th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomHbpFlag" name="diCcomHbpFlag" value="${diseaseInfo.diCcomHbpFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomHbpFlag != '2'}" onlypast="true" id="diCcomHbpDisDate" name="diCcomHbpDisDate" date="${diseaseInfo.diCcomHbpDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomHbpFlag != '2'}" class="layui-input x-admin-content-sm-date" name="diCcomHbpDisDate" id="diCcomHbpDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomHbpDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomHbpFlag != '2' ? 'disabled' :''}   type="text"  id="diCcomHbpTreatment" name="diCcomHbpTreatment" value="${diseaseInfo.diCcomHbpTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th><label for="diCcomHbcFlag">高血脂</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomHbcFlag" name="diCcomHbcFlag" value="${diseaseInfo.diCcomHbcFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomHbcFlag != '2'}"   onlypast="true" id="diCcomHbcDisDate" name="diCcomHbcDisDate" date="${diseaseInfo.diCcomHbcDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomHbcFlag != '2'}"  class="layui-input x-admin-content-sm-date" name="diCcomHbcDisDate" id="diCcomHbcDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomHbcDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomHbcFlag != '2' ? 'disabled' :''}   type="text"  id="diCcomHbcTreatment" name="diCcomHbcTreatment" value="${diseaseInfo.diCcomHbcTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th><label for="diCcomRetyFlag">视网膜病变</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomRetyFlag" name="diCcomRetyFlag" value="${diseaseInfo.diCcomRetyFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomRetyFlag != '2'}"  onlypast="true" id="diCcomRetyDisDate" name="diCcomRetyDisDate" date="${diseaseInfo.diCcomRetyDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomRetyFlag != '2'}"  class="layui-input x-admin-content-sm-date" name="diCcomRetyDisDate" id="diCcomRetyDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomRetyDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomRetyFlag != '2' ? 'disabled' :''}   type="text"  id="diCcomRetypTreatment" name="diCcomRetypTreatment" value="${diseaseInfo.diCcomRetypTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th><label for="diCcomNerveFlag">周围神经病变</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomNerveFlag" name="diCcomNerveFlag" value="${diseaseInfo.diCcomNerveFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomNerveFlag != '2'}"  onlypast="true" id="diCcomNerveDisDate" name="diCcomNerveDisDate" date="${diseaseInfo.diCcomNerveDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomNerveFlag != '2'}"  class="layui-input x-admin-content-sm-date" name="diCcomNerveDisDate" id="diCcomNerveDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomNerveDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomNerveFlag != '2' ? 'disabled' :''}   type="text"  id="diCcomNerveTreatment" name="diCcomNerveTreatment" value="${diseaseInfo.diCcomNerveTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th><label for="diCcomKidneyFlag">肾病</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomKidneyFlag" name="diCcomKidneyFlag" value="${diseaseInfo.diCcomKidneyFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomKidneyFlag != '2'}"  onlypast="true" id="diCcomKidneyDisDate" name="diCcomKidneyDisDate" date="${diseaseInfo.diCcomKidneyDisDate}" /> --%>
			    <input type="text" disabled="${diseaseInfo.diCcomKidneyFlag != '2'}" class="layui-input x-admin-content-sm-date" name="diCcomKidneyDisDate" id="diCcomKidneyDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomKidneyDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomKidneyFlag != '2' ? 'disabled' :''}   type="text"  id="diCcomKidneyTreatment" name="diCcomKidneyTreatment" value="${diseaseInfo.diCcomKidneyTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th><label for="diCcomFootFlag">足部病变</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomFootFlag" name="diCcomFootFlag" value="${diseaseInfo.diCcomFootFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomFootFlag != '2'}"  onlypast="true" id="diCcomFootDisDate" name="diCcomFootDisDate" date="${diseaseInfo.diCcomFootDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomFootFlag != '2'}" class="layui-input x-admin-content-sm-date" name="diCcomFootDisDate" id="diCcomFootDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomFootDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomFootFlag != '2' ? 'disabled' :''}  type="text"   id="diCcomFootTreatment" name="diCcomFootTreatment" value="${diseaseInfo.diCcomFootTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
		<tr>
			<th><label for="diCcomStrokeFlag">脑卒中</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diCcomStrokeFlag" name="diCcomStrokeFlag" value="${diseaseInfo.diCcomStrokeFlag}" /></td>
			<td><%-- <tag:dateInput disabled="${diseaseInfo.diCcomStrokeFlag != '2'}"  onlypast="true" id="diCcomStrokeDisDate" name="diCcomStrokeDisDate" date="${diseaseInfo.diCcomStrokeDisDate}" /> --%>
				<input type="text" disabled="${diseaseInfo.diCcomStrokeFlag != '2'}"  class="layui-input x-admin-content-sm-date" name="diCcomStrokeDisDate" id="diCcomStrokeDisDate" value="<fmt:formatDate value='${diseaseInfo.diCcomStrokeDisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<td><input ${diseaseInfo.diCcomStrokeFlag != '2' ? 'disabled' :''}   type="text"    id="diCcomStrokeTreatment" name="diCcomStrokeTreatment" value="${diseaseInfo.diCcomStrokeTreatment}" reg="{'maxlength':66}"></input></td>
		</tr>
	</table>
</fieldset>
<fieldset class="layui-elem-field">
	<legend>近期治疗情况</legend>
		<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 20%;min-width:150px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label for="diRtDietControlFlag">饮食控制</label></th>
			<td colspan="3"><ehr:dic-radio dicmeta="FS10238" id="diRtDietControlFlag" name="diRtDietControlFlag"
					value="${diseaseInfo.diRtDietControlFlag}"
				></ehr:dic-radio></td>
		</tr>
		<tr>
			<th><label for="diRtQuitSmokingFlag">戒烟</label></th>
			<td colspan="3"><ehr:dic-radio dicmeta="FS10238" id="diRtQuitSmokingFlag" name="diRtQuitSmokingFlag"
					value="${diseaseInfo.diRtQuitSmokingFlag}"
				/></td>
		<tr>
			<th><label for="diRtLimitDrinkingFlag">限酒</label></th>
			<td colspan="3"><ehr:dic-radio dicmeta="FS10238" id="diRtLimitDrinkingFlag" name="diRtLimitDrinkingFlag"
					value="${diseaseInfo.diRtLimitDrinkingFlag}"
				/></td>
		</tr>
		<tr>
			<th><label for="diRtPhyActivityFlag">体力活动</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diRtPhyActivityFlag" name="diRtPhyActivityFlag" value="${diseaseInfo.diRtPhyActivityFlag}" /></td>
			<td>每周<tag:numberInput disabled="${diseaseInfo.diRtPhyActivityFlag != '2'}" style="width:40px;" id="diRtPhyActivityWeekCount" name="diRtPhyActivityWeekCount" value="${diseaseInfo.diRtPhyActivityWeekCount}"
					reg="{'min':0,'max':9999}"
				></tag:numberInput>次
			</td>
			<td>每次<tag:numberInput disabled="${diseaseInfo.diRtPhyActivityFlag != '2'}"  style="width:40px;" id="diRtPhyActivityTime" name="diRtPhyActivityTime" value="${diseaseInfo.diRtPhyActivityTime}"
					reg="{'min':0,'max':99999}"
				></tag:numberInput>分钟
			</td>
		</tr>
		<tr>
			<th><label for="diRtHypDrugsFlag">口服降糖药</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diRtHypDrugsFlag" name="diRtHypDrugsFlag" value="${diseaseInfo.diRtHypDrugsFlag}" /></td>
			<td>每日<tag:numberInput disabled="${diseaseInfo.diRtHypDrugsFlag != '2'}"  style="width:40px;" id="diRtHypDrugsDailyCount" name="diRtHypDrugsDailyCount" value="${diseaseInfo.diRtHypDrugsDailyCount}"
					reg="{'min':0,'max':99}"
				></tag:numberInput>次
			</td>
			<td>每次<tag:numberInput point="true" disabled="${diseaseInfo.diRtHypDrugsFlag != '2'}"  style="width:40px;" id="diRtHypDrugsperDose" name="diRtHypDrugsperDose" value="${diseaseInfo.diRtHypDrugsperDose}"
					reg="{'min':0,'max':999.9,'number':true,'scale':1}"
				></tag:numberInput>
				<ehr:dic-list dicmeta="DMD00067" value="${diseaseInfo.diRtHypDrugsperDoseUnit}"  name="diRtHypDrugsperDoseUnit" id="diRtHypDrugsperDoseUnit"></ehr:dic-list>
				
			</td>
		</tr>
		<tr>
			<th><label for="diRtInsulinFlag">胰岛素</label></th>
			<td><ehr:dic-radio dicmeta="FS10238" id="diRtInsulinFlag" name="diRtInsulinFlag" value="${diseaseInfo.diRtInsulinFlag}" /></td>
			<td>每日<tag:numberInput disabled="${diseaseInfo.diRtInsulinFlag != '2'}"  style="width:40px;" id="diRtInsulinDailyCount" name="diRtInsulinDailyCount" value="${diseaseInfo.diRtInsulinDailyCount}"
					reg="{'min':0,'max':99}"
				></tag:numberInput>次
			</td>
			<td>每次<tag:numberInput point="true" disabled="${diseaseInfo.diRtInsulinFlag != '2'}"  style="width:40px;" id="diRtInsulinPerDose" name="diRtInsulinPerDose" value="${diseaseInfo.diRtInsulinPerDose}" reg="{'min':0,'max':9999.9,'number':true,'scale':1}" ></tag:numberInput>
							<ehr:dic-list dicmeta="DMD00067" value="${diseaseInfo.diRtInsulinPerDoseUnit}"   name="diRtInsulinPerDoseUnit" id="diRtInsulinPerDoseUnit"></ehr:dic-list>
			
			</td>
		</tr>
		</table>
	</fieldset>

	<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#diDiagnosedDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
   		,done:function (value) {
				if(!$.isEmpty(value)){
					$("#diDiagnosedDate").removeClass("lose");
				}else{
					$("#diDiagnosedDate").addClass("lose");
				}
			}
    });

    laydate.render({
      elem: '#diCcomCoronaryDisDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
    
    laydate.render({
        elem: '#diCcomHbpDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diCcomHbcDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diCcomRetyDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diCcomNerveDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diCcomKidneyDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diCcomFootDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diCcomStrokeDisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
  });
</script>