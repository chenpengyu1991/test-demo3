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
        healthEducationUpload.uploadFile("cdmCardHbpFile", "/he/upload/uploadFile/mbglkgxy", "/he/upload/deleteFile/mbglkgxy");
    });
</script>

	<table class="posttable">
		<colgroup>
			<col style="width: 15%" />
			<col style="width: 35%" />
			<col style="width: 15%" />
			<col style="width: 35%" />
		</colgroup>
		<c:choose>
			<c:when test="${isBringIntoManage==true}">
				<tr>
					<th><label class="required" for="hbpSbp">血压</label></th>
					<td>
						<input type="text" name="hbpSbp" style="width:60px" value="${diseaseInfo.hbpSbp}"/>/
						<input type="text" name="hbpDbp" style="width:60px" value="${diseaseInfo.hbpDbp}"/>(收缩压/舒张压)
					</td>
					<th><label class="required" for="hbpManageLevel">高血压管理等级</label></th>
					<td><ehr:dic-list width="180px;"  dicmeta="DMD00025"  value="${diseaseInfo.hbpManageLevel}" id="hbpManageLevel" name="hbpManageLevel"  reg="{'required':true}" /></td>
				</tr>
				<tr>
					<th><label class="required" for="hbpType">高血压类型</label></th>
					<td><ehr:dic dicmeta="DMD00006" code="${diseaseInfo.hbpType}" /><input type="hidden" name="hbpType" value='${diseaseInfo.hbpType}' /></td>
					<th><label class="required" for="hbpDiagnosedDate">确诊时间</label></th>
					<td>
						<input type="hidden" name="hbpDiagnosedDate" value='<fmt:formatDate value="${diseaseInfo.hbpDiagnosedDate}" pattern="yyyy/MM/dd" />' />
						<fmt:formatDate value="${diseaseInfo.hbpDiagnosedDate}"  pattern="yyyy/MM/dd" />
						<%--<tag:dateInput onlypast="true" id="hbpDiagnosedDate" name="hbpDiagnosedDate" date="${diseaseInfo.hbpDiagnosisDate}" reg="{'required':true}"  />--%>
					</td>
				</tr>
				<tr>
					<th><label class="required" for="hbpDiagnosedOrganCode">确诊医院</label></th>
					<td>
						<input type="hidden" name="hbpDiagnosedOrganCode" value="${diseaseInfo.hbpDiagnosedOrganCode}"  />
						<input type="hidden" name="hbpOtherDiagnosisOrganFlag" value="${diseaseInfo.hbpOtherDiagnosisOrganFlag}"/>
						<input type="hidden" name="hbpOtherDiagnosisOrganName" value="${diseaseInfo.hbpOtherDiagnosisOrganName}"/>
						<c:if test="${diseaseInfo.hbpOtherDiagnosisOrganFlag eq '2' }">
							${diseaseInfo.hbpOtherDiagnosisOrganName} 
						</c:if> 
						<c:if test="${diseaseInfo.hbpOtherDiagnosisOrganFlag ==null || diseaseInfo.hbpOtherDiagnosisOrganFlag != '2' }">
							<ehr:org flag="0" code="${diseaseInfo.hbpDiagnosedOrganCode}"></ehr:org>
						</c:if>
					</td>
					<c:if test="${diseaseInfo.hbpManagedDate != null}">
						<th><label>管理卡创建时间</label></th>
						<td style="vertical-align:top">
							<%-- <tag:dateInput onlypast="true" id="hbpManagedDate" name="hbpManagedDate" date="${diseaseInfo.hbpManagedDate}" disabled="true"  /> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" name="hbpManagedDate" id="hbpManagedDate" value="<fmt:formatDate value='${diseaseInfo.hbpManagedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</c:if>
				</tr>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${isHealth==true}"><%--健康档案创建慢病管理卡 --%>
						<tr>
							<th><label class="required" for="hbpSbp">血压</label></th>
							<td><tag:numberInput style="width:60px" id="hbpSbp" name="hbpSbp" value="${diseaseInfo.hbpSbp}" reg="{'digits':true,'required':true,'min':0,'max':9999,'compare':['hbpDbp','gt','收缩压不能小于或者等于舒张压']}" />/
								<tag:numberInput id="hbpDbp" style="width:60px" name="hbpDbp" value="${diseaseInfo.hbpDbp}" reg="{'digits':true,'required':true,'min':0,'max':9999,'compare':['hbpSbp','lt','舒张压不能大于或者等于收缩压']}" />(收缩压/舒张压)</td>
							<th><label class="required" for="hbpManageLevel">高血压管理等级</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00025"  value="${diseaseInfo.hbpManageLevel}" id="hbpManageLevel" name="hbpManageLevel"  reg="{'required':true}" /></td>
						</tr>
						<tr>
							<th><label class="required" for="hbpType">高血压类型</label></th>
							<td>
								<ehr:dic-list width="180px;" uninclude="2" defaultval="true" dicmeta="DMD00006" id="hbpType" name="hbpType" value="${diseaseInfo.hbpType}" reg="{'required':true}" />
							</td>
							<th><label class="required" for="hbpDiagnosedDate">确诊时间</label></th>
							<td>
								<%-- <tag:dateInput onlypast="true" id="hbpDiagnosedDate" name="hbpDiagnosedDate" date="${diseaseInfo.hbpDiagnosedDate}" reg="{'required':true}"  /> --%>	
								<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="hbpDiagnosedDate" id="hbpDiagnosedDate" value="<fmt:formatDate value='${diseaseInfo.hbpDiagnosedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />					
							</td>
						</tr>
						<tr>
							<th><label class="required" for="hbpDiagnosedOrganCode">确诊医院</label></th>
							<td>
								<span id="hbpDiagnosedSpanId" style="display:<c:if test="${diseaseInfo.hbpOtherDiagnosisOrganFlag eq '2'}">none;</c:if>">
									<tag:autoSelect reg="{'required':false}"  name="hbpDiagnosedOrganCode" id="hbpDiagnosedOrganCode" codeValue="${diseaseInfo.hbpDiagnosedOrganCode}" style="width: 50%;"/>
								</span>
								外地诊断:<input id="hbpOtherDiagnosisOrganFlag" type="checkbox" value="2" name="hbpOtherDiagnosisOrganFlag" ${diseaseInfo.hbpOtherDiagnosisOrganFlag eq '2' ?'checked':''}/>
								<span id="hbpDiagnosedNameSpanId" style="display:<c:if test="${!diseaseInfo.hbpOtherDiagnosisOrganFlag ne '2'}">none;</c:if>">
								<input id="hbpOtherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'hbpOtherDiagnosisOrganFlag','required':true}" type="text" value="${diseaseInfo.hbpOtherDiagnosisOrganName}" name="hbpOtherDiagnosisOrganName">
								</span>
							</td>
						</tr>
					</c:when>
					<c:otherwise><%--查看慢病管理卡 --%>
						<tr>
							<th><label class="required" for="hbpSbp">血压</label></th>
							<td><tag:numberInput style="width:60px" id="hbpSbp" name="hbpSbp" value="${diseaseInfo.hbpSbp}" reg="{'digits':true,'required':true,'min':0,'max':9999,'compare':['hbpDbp','gt','收缩压不能小于或者等于舒张压']}" />/
								<tag:numberInput id="hbpDbp" style="width:60px" name="hbpDbp" value="${diseaseInfo.hbpDbp}" reg="{'digits':true,'required':true,'min':0,'max':9999,'compare':['hbpSbp','lt','舒张压不能大于或者等于收缩压']}" />(收缩压/舒张压)</td>
							<th><label class="required" for="hbpManageLevel">高血压管理等级</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00025"  value="${diseaseInfo.hbpManageLevel}" id="hbpManageLevel" name="hbpManageLevel"  reg="{'required':true}" /></td>
						</tr>
						<tr>
							<th><label class="required" for="hbpType">高血压类型</label></th>
							<td>
								<ehr:dic dicmeta="DMD00006" code="${diseaseInfo.hbpType}"/>
								<input type="hidden" name="hbpType" value="${diseaseInfo.hbpType}" />
							</td>
							<th><label class="required" for="hbpDiagnosedDate">确诊时间</label></th>
							<td>
								<%--<fmt:formatDate value="${diseaseInfo.hbpDiagnosedDate}" pattern="yyyy/MM/dd" />
								<input type="hidden" name="hbpDiagnosedDate" value='<fmt:formatDate value="${diseaseInfo.hbpDiagnosedDate}" pattern="yyyy/MM/dd" />' />--%>
								<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="hbpDiagnosedDate" id="hbpDiagnosedDate" value="<fmt:formatDate value='${diseaseInfo.hbpDiagnosedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
						</tr>
						<tr>
							<th><label class="required" for="hbpDiagnosedOrganCode">确诊医院</label></th>
							<td>
<%--							<c:choose>
								<c:when test="${diseaseInfo.hbpOtherDiagnosisOrganFlag eq '2' }">
									${diseaseInfo.hbpOtherDiagnosisOrganName}
		 							<input type="hidden" id="hbpOtherDiagnosisOrganFlag" name="hbpOtherDiagnosisOrganFlag" value="${diseaseInfo.hbpOtherDiagnosisOrganFlag}"/>
		  							<input type="hidden" id="hbpOtherDiagnosisOrganName" name="hbpOtherDiagnosisOrganName" value="${diseaseInfo.hbpOtherDiagnosisOrganName}"/>
								</c:when>
								<c:when test="${diseaseInfo.hbpDiagnosedOrganCode != null }">
									<ehr:org flag="0" code="${diseaseInfo.hbpDiagnosedOrganCode}"></ehr:org>
		 							<input type="hidden" id="hbpDiagnosedOrganCode" name="hbpDiagnosedOrganCode" value="${diseaseInfo.hbpDiagnosedOrganCode}"/>
								</c:when>
							</c:choose>	--%>
							<span id="hbpDiagnosedSpanId" style="display:<c:if test="${diseaseInfo.hbpOtherDiagnosisOrganFlag eq '2'}">none;</c:if>">
								<tag:autoSelect reg="{'required':false}"  name="hbpDiagnosedOrganCode" id="hbpDiagnosedOrganCode" codeValue="${diseaseInfo.hbpDiagnosedOrganCode}" style="width: 50%;"/>
							</span>
							外地诊断:<input id="hbpOtherDiagnosisOrganFlag" type="checkbox" value="2" name="hbpOtherDiagnosisOrganFlag" ${diseaseInfo.hbpOtherDiagnosisOrganFlag eq '2' ?'checked':''}/>
							<span id="hbpDiagnosedNameSpanId" style="display:<c:if test="${diseaseInfo.hbpOtherDiagnosisOrganFlag ne '2'}">none;</c:if>">
							<input id="hbpOtherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'hbpOtherDiagnosisOrganFlag','required':true}" type="text" value="${diseaseInfo.hbpOtherDiagnosisOrganName}" name="hbpOtherDiagnosisOrganName">
							</span>
							<th><label>管理卡创建时间</label></th>
							<td style="vertical-align:top">
								<fmt:formatDate value="${diseaseInfo.hbpManagedDate}" pattern="yyyy/MM/dd" />
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<%-- <c:if test="${attchesHbp != null }">
			<tr>
				<th><label class="required">高血压附件</label></th>
				<td colspan="3">
					<div style="width: 690px;" id="hbpHaveAttemp">
						<c:forEach items="${attchesHbp}" var="attche" >
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
                                    <c:if test="${isBringIntoManage != true}">
									<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
                                    </c:if>
								</ehr:authorize>
							</div>
						</c:forEach>
					</div>
				</td>
			</tr>
		</c:if> --%>
        <%--<c:if test="${isBringIntoManage != true}">
			<ehr:authorize ifNotGranted="${ADMIN},${JKWJ}">
				<tr id="hbpFileAddTrId" &lt;%&ndash;style="display:<c:if test="${diseaseInfo.hbpOtherDiagnosisOrganFlag ne '2'}">none;</c:if>"&ndash;%&gt;>
					<th><label class="required">附件</label></th>
					<td colspan="3">
						<div id="cdmCardHbpFile"></div>
						<span style="color: red;">本附件需提供乡镇及乡镇以上医疗机构疾病诊断相关佐证材料（诊断证明、处方、病历、病案） </span><br/>
						<span style="color: blue;">注：单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改),附件数量不能超过5个</span>
					</td>
				</tr>
			</ehr:authorize>
        </c:if>--%>
	</table>
	<fieldset class="layui-elem-field">
			<legend>高血压并发症情况</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 15%" />
							<col style="width: 35%" />
							<col style="width: 15%" />
							<col style="width: 35%" />
						</colgroup>
						<tr>
							<th><label for="hbpCerebrovascularFlag">脑血管疾病</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00019" id="hbpCerebrovascularFlag" defaultval="4" name="hbpCerebrovascularFlag" value='${not empty  diseaseInfo.hbpCerebrovascularFlag ? diseaseInfo.hbpCerebrovascularFlag : "4" }'  /></td>
							<th><label for="hbpHeartFlag">心脏疾病</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00020" id="hbpHeartFlag"  defaultval="4" name="hbpHeartFlag" value='${not empty diseaseInfo.hbpHeartFlag ? diseaseInfo.hbpHeartFlag : "4"}'  /></td>
						</tr>
						<tr>
							<th><label for="hbpKidneyFlag">肾脏疾病</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00021" id="hbpKidneyFlag"  defaultval="3" name="hbpKidneyFlag" value='${not empty diseaseInfo.hbpKidneyFlag ? diseaseInfo.hbpKidneyFlag : "3"}'  /></td>
							<th><label for="hbpVascularFlag">血管疾病</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00022" id="hbpVascularFlag"  defaultval="3" name="hbpVascularFlag" value='${not empty diseaseInfo.hbpVascularFlag ? diseaseInfo.hbpVascularFlag : "3"}'  /></td>
						</tr>
						<tr>
							<th><label for="hbpRetinopathyFlag">高度性视网膜病变</label></th>
							<td><ehr:dic-list width="180px;"  dicmeta="DMD00023" id="hbpRetinopathyFlag"  defaultval="3" name="hbpRetinopathyFlag" value='${not empty diseaseInfo.hbpRetinopathyFlag ? diseaseInfo.hbpRetinopathyFlag : "3"}' 	/></td>
							<th><label for="hbpSelfliveFlag">生活自理能力</label></th>
							<td colspan="3"><ehr:dic-list width="180px;"  dicmeta="DMD00024" id="hbpSelfliveFlag"  defaultval="1" name="hbpSelfliveFlag" value='${not empty diseaseInfo.hbpSelfliveFlag ? diseaseInfo.hbpSelfliveFlag : "1"}' /></td>
						</tr>
					</table>
	</fieldset>

	<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#hbpManagedDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
   		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#hbpManagedDate").removeClass("lose");
			}else{
				$("#hbpManagedDate").addClass("lose");
			}
		}
    });

    laydate.render({
      elem: '#hbpDiagnosedDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
   		,done:function (value) {
				if(!$.isEmpty(value)){
					$("#hbpDiagnosedDate").removeClass("lose");
				}else{
					$("#hbpDiagnosedDate").addClass("lose");
				}
			}
    });
  });
</script>