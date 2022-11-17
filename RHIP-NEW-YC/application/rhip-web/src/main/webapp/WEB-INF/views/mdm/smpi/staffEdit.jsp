<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function () {
		staffEdit.editStart();
	});
</script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<div class="toolbar">
	<a href="javascript:void(0)" id="close"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a href="javascript:void(0)" id="save" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="staffEditForm" >
	<div class="postcontent">
		<div class="postdiv">
		<input type="hidden" id="id" name="id" value="${staff.id}"/>
		<input type="hidden" id="staffCode" name="staffCode" value="${staff.staffCode}"/>
		<input type="hidden" id="smpiId" name="smpiId" value="${staff.smpiId}"/>
		<fieldset class="layui-elem-field">
			<legend>人员机构信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
				</colgroup>
				<tbody>
				<tr>
					<th><label class="required">所在机构</label></th>
					<td colspan="3">
						<c:if test="${staff.organCode eq null}">
							<ehr:authorize ifAnyGranted="${ADMIN}">
								<ehr:medical-organ centreName="village" stationName="station" townName="town" width="21%;"
															 townId="selectTown"	centreId="selectCenter" stationId="selectStation"
															 isShowHealthOversight="true" isShow="true" isShowOther="true" isShowJk="true" shoQwjw="true"/>
								<input type="hidden" id="organCode" name="organCode"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${YY_GLY}">
								<ehr:org-type-list id="organCode" name="organCode" type="hospital"
												   defaultval="false"  width="30%;"/>
							</ehr:authorize>

							<ehr:authorize ifAnyGranted="${ZX_GLY}">
								<ehr:org-type-list id="organCode" name="organCode" parentCode="${currentLoginInfo.organization.organCode}"
												   defaultval="false" includeParent="true" width="30%;"/>
							</ehr:authorize>

							<ehr:authorize ifAnyGranted="${Z_GLY}">
								<select id="organCode" name="organCode" style="width: 30%;">
									<option value="${currentLoginInfo.organization.organCode}">
										<ehr:org code="${currentLoginInfo.organization.organCode}"/>

									</option>
								</select>
							</ehr:authorize>
						</c:if>
						<c:if test="${staff.organCode ne null}">
							<div id="organName">
									${org.organName}<a href="#" onclick="staffEdit.changeOrgan()">修改</a>
							</div>
							<div id="changeOrgan" style="display: none">
								<ehr:medical-organ centreName="village" stationName="station" townName="town" width="21%;"
															 townId="selectTown" centreId="selectCenter" stationId="selectStation"
								townValue="${townValue}" centreValue="${centreValue}" stationValue="${stationValue}" isShowHealthOversight="true" isShow="true" isShowOther="true" isShowJk="true" shoQwjw="true"/>
								<input type="hidden" id="organCode" name="organCode" value="${staff.organCode}"/>
							</div>
							<input type="hidden" id="changeOrganStatus" value="0"/>
						</c:if>
						<input type="hidden" name="localId" value="${staff.localId}"/>
					</td>
				</tr>
				<tr>
					<th>所在科室</th>
					<td>
						<select name="deptCode" id="deptSelect" style="width: 150px">
							<staffOrg value="">请选择</staffOrg>
							<c:forEach var="dept" items="${deptList}">
								<staffOrg value="${dept.deptCode}" ${staff.deptCode eq dept.deptCode ? "selected" : ""}>${dept.deptName}</staffOrg>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>工作证号</th>
					<td><input type="text" name="workIdCard" value="${staff.workIdCard}" reg="{'maxlength':20}"/></td>
					<th>胸牌号</th>
					<td><input type="text" name="cardNum" value="${staff.cardNum}" reg="{'maxlength':20}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<fieldset style="margin-top: 10px" class="layui-elem-field">
			<legend>兼职机构</legend>

				<div class="toolbarsublist">
					<!-- <a href="javascript:void(0)" id="addOpintList" onclick="staffEdit.popup('','add')" ><b class="xinz">添加兼职机构</b> </a> -->
					<a title="添加兼职机构" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" id="addOpintList" onclick="staffEdit.popup('','add')" title="添加兼职机构" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>添加兼职机构</a>
				</div>
				<div id="staffOrgDivId"></div>
				<div class="repeattable">
					<table id="staffOrgTable" class="layui-table x-admin-sm-table-list-small">
						<colgroup>
							<col style="width: 25%" />
							<col style="width: 20%" />
							<col style="width: 15%" />
							<col style="width: 15%" />
							<col style="width: 25%" />
						</colgroup>
						<thead>
						<tr>
							<th class="centerth" style="width: 5%">机构名称</th>
							<th class="centerth" style="width: 10%">科室名称</th>
							<th class="centerth" style="width: 5%">工作证号</th>
							<th class="centerth" style="width: 5%">胸牌号</th>
							<th class="centerth" style="width: 5%">操作</th>
						</tr>
						</thead>
						<c:forEach var="staffOrg" items="${staff.staffOrgs}" varStatus="status">
							<tr>
								<td field="organCode" style="display: none;">${staffOrg.organCode}</td>
								<td field="deptCode" style="display: none;">${staffOrg.deptCode}</td>
								<td field="organName"><ehr:org code="${staffOrg.organCode}"/></td>
								<td field="deptName"><ehr:dept organCode="${staffOrg.organCode}" deptCode="${staffOrg.deptCode}"/></td>
								<td field="workIdCard">${staffOrg.workIdCard}</td>
								<td field="cardNum">${staffOrg.cardNum}</td>
								<td class="btnsublist" field="btn">
									<a class="layui-btn layui-btn-xs" href="javascript:void(0)" onclick="staffEdit.popup(this, 'edit')"title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon" style="font-weight: normal;">&#xe608;</i></a>&nbsp;
									<a class="layui-btn layui-btn-danger layui-btn-xs" href="javascript:void(0)" onclick="staffEdit.removeTr(this)" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>人员基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
				</colgroup>
				<tbody>
				<tr>
					<th><label class="required">姓名</label></th>
					<td><input type="text" name="name" value="${staff.name}" reg="{'required':'true','maxlength':16}"/></td>
					<th>民族</th>
					<td><ehr:dic-list name="nation" dicmeta="GBT3304" value="${staff.nation}" width="150px"/></td>
				</tr>
				<tr>
					<th>性别</th>
					<td><ehr:dic-radio name="gender" dicmeta="GBT226112003" value="${staff.gender}"/></td>
					<th>婚姻状况</th>
					<td><ehr:dic-list name="marriage" dicmeta="GBT226122003" value="${staff.marriage}" width="150px"/></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><%-- <tag:dateInput name="birthday" date="${staff.birthday}" pattern="yyyy/MM/dd" style="width: 100px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" name="birthday" id="birthday" value="<fmt:formatDate value='${staff.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
					</td>
					<th>最高学历</th>
					<td>
						<ehr:dic-list name="educationCategory" dicmeta="FS990006" value="${staff.educationCategory}" width="70px"/>
						<ehr:dic-list name="education" dicmeta="GBT46582006" value="${staff.education}" width="150px" code="11,10,IDM12,IDM04,IDM03,IDM02,IDM07,90"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">身份证号</label></th>
					<td><tag:idcardInput id="idcard" name="idCard" value="${staff.idCard}" reg="{'required':'true','creditcard':'true'}"/></td>
					<th>最高学位</th>
					<td><ehr:dic-list name="degree" dicmeta="GBT6864" value="${staff.degree}" width="150px" code="0,2,3,4"/></td>
				</tr>
				<tr>
					<th>行政区划代码</th>
					<td><input type="text" name="gbCode" value="${staff.gbCode}"/></td>
				</tr>
				<tr>
					<th>党派</th>
					<td><ehr:dic-list name="party" dicmeta="GBT47631984" value="${staff.party}" width="150px"/></td>
					<th>入党时间</th>
					<td><%-- <tag:dateInput name="partyDate" date="${staff.partyDate}" pattern="yyyy/MM/dd" style="width: 100px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" name="partyDate" id="partyDate" value="<fmt:formatDate value='${staff.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
					</td>
				</tr>
				<tr>
					<th>党派职务</th>
					<td><input type="text" name="partyJob" value="${staff.partyJob}" reg="{'maxlength':20}"/></td>
					<th>学术团体任职情况</th>
					<td><input type="text" name="jobCondition" value="${staff.jobCondition}" reg="{'maxlength':100}"/></td>
				</tr>
				<tr>
					<th>家庭地址</th>
					<td>
						<input type="text" id="text_pahouseNumber"  reg='{"maxlength":33}'
							   name="paHouseNumber" value="${staff.paHouseNumber}"/>
					</td>
					<th>住宅电话</th>
					<td><input type="text" name="homeTel" value="${staff.homeTel}" reg="{'maxlength':20}"/></td>
				</tr>
				<tr>
					<th>邮编</th>
					<td><input type="text" name="paPostcode" value="${staff.paPostcode}" reg='{"maxlength":6}'></td>
					<th>手机</th>
					<td><input type="text" name="mobile" value="${staff.mobile}" reg="{'maxlength':20}"/></td>
				</tr>
				<tr>
					<th>电子邮箱</th>
					<td><input type="text" name="mail" value="${staff.mail}" reg="{'maxlength':50}"/></td>
				</tr>
				<tr>
					<td><!-- <a href="javascript:void(0)" id="addHonorBtn" ><b class="xinz" style="padding-left:22px;" onclick="staffEdit.addHonor()">添加个人荣誉</b></a> -->
					<a title="添加个人荣誉" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" id="addHonorBtn" onclick="staffEdit.addHonor()" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>添加个人荣誉</a>
					
					<!-- <a href="javascript:void(0)" id="addHonorBtn" onclick="staffEdit.addHonor()" title="添加个人荣誉"><i class="layui-icon">&#xe608;</i>&nbsp;添加个人荣誉</a> -->
					</td>
				</tr>
				</tbody>
			</table>
			<table id="honorTable" class="posttable">
				<c:forEach var="honor" items="${staff.staffHonors}" varStatus="status">
					<tr>
						<th width="15%">个人荣誉</th>
						<td><input type="text" name="honorContent" value="${honor.honorContent}" reg='{"maxlength":"20"}' style="width:90%"/></td>
						<th>授予时间</th>
						<td><input type="text" name="honorDate" value="${honor.honorDate}" reg='{"maxlength":"20"}' style="width:90%"/></td>
						<th>授予单位</th>
						<td><input type="text" name="honorUnit" value="${honor.honorUnit}" reg='{"maxlength":"20"}' style="width:90%"/></td>
						<th>执业地点</th>
						<td><input type="text" name="honorAddr" value="${honor.honorAddr}" reg='{"maxlength":"20"}' style="width:90%"/></td>
						<td><a href="javascript:void(0)" onclick="staffEdit.removeTr(this)" title="删除"><i class="layui-icon" style="font-weight: normal;">&#xe640;</i></a></td>
					</tr>
				</c:forEach>
				<%--<tr>--%>
					<%--<th style="width: 60px;"><label class="required">个人荣誉</label></th>--%>
					<%--<td><input type="text" name="honorContent" reg='{"required":"true"}'  style="width: 90%"></td>--%>
					<%--<th style="width: 50px;">授予时间</th>--%>
					<%--<td><input type="text" name="honorDate" style="width: 90px;"></td>--%>
					<%--<th style="width: 50px;">授予单位</th>--%>
					<%--<td><input type="text" name="honorUnit" style="width: 90%"></td>--%>
					<%--<th style="width: 50px;">执业地点</th>--%>
					<%--<td><input type="text" name="honorAddr" style="width: 90%"></td>--%>
					<%--<td width="40px;"></td>--%>

					<%--<td style="width: 60px;"></td>--%>
					<%--<td ></td>--%>
					<%--<td style="width: 50px;"></td>--%>
					<%--<td></td>--%>
					<%--<td style="width: 50px;"></td>--%>
					<%--<td></td>--%>
					<%--<td style="width: 50px;"></td>--%>
					<%--<td></td>--%>
					<%--<td width="40px;"></td>--%>
				<%--</tr>--%>
			</table>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>人员背景信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
				</colgroup>
				<tbody>
				<tr>
					<th>职工分类</th>
					<td><ehr:dic-list name="type" dicmeta="FS10012" value="${staff.type}" width="150px"/></td>
					<th>从业分类</th>
					<td><ehr:dic-list name="cyType" dicmeta="JS00001" value="${staff.cyType}" width="150px"/></td>
				</tr>
				<tr>
					<th>人员分类</th>
					<td><ehr:dic-list name="ryType" dicmeta="JS00002" value="${staff.ryType}" width="150px"/></td>
					<th>毕业学校</th>
					<td><input type="text" name="university" value="${staff.university}" reg="{'maxlength':33}"/></td>
				</tr>
				<tr>
					<th>从事专业</th>
					<td><input type="text" name="work" value="${staff.work}" reg="{'maxlength':33}"/></td>
					<th>毕业日期</th>
					<td><%-- <tag:dateInput name="graduateDate" date="${staff.graduateDate}" pattern="yyyy/MM/dd" style="width: 100px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" name="graduateDate" id="graduateDate" value="<fmt:formatDate value='${staff.graduateDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
					</td>
				</tr>
				<tr>
					<th>职称等级</th>
					<td><ehr:dic-list name="technical" dicmeta="FS10011" value="${staff.technical}" width="150px"/></td>
					<th>所学专业名称</th>
					<td><input type="text" name="speciality" value="${staff.speciality}" reg="{'maxlength':33}"/></td>
				</tr>
				<tr>
					<th>职称名称</th>
					<td><input type="text" name="technicalName" value="${staff.technicalName}" reg="{'maxlength':10}"/></td>
					<th>参加工作日期</th>
					<td><%-- <tag:dateInput name="startWorkDate" date="${staff.startWorkDate}" pattern="yyyy/MM/dd" style="width: 100px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" name="startWorkDate" id="startWorkDate" value="<fmt:formatDate value='${staff.startWorkDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
					</td>
				</tr>
				<tr>
					<th>职务等级</th>
					<td><ehr:dic-list name="business" dicmeta="FS990007" value="${staff.business}" width="150px"/></td>
					<th>到本单位日期</th>
					<td><%-- <tag:dateInput name="orgWorkDate" date="${staff.orgWorkDate}" pattern="yyyy/MM/dd" style="width: 100px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" name="orgWorkDate" id="orgWorkDate" value="<fmt:formatDate value='${staff.orgWorkDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
					</td>
				</tr>
				<tr>
					<th>职务名称</th>
					<td><input type="text" name="businessName" value="${staff.businessName}" reg="{'maxlength':30}"/></td>
				</tr>
				<tr>
					<th>办公室电话</th>
					<td><input type="text" name="officeTel" value="${staff.officeTel}" reg="{'maxlength':20}"/></td>
				</tr>
				<tr>
					<th>办公室传真</th>
					<td><input type="text" name="officeFax" value="${staff.officeFax}" reg="{'maxlength':20}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>执业信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
					<col style="min-width: 80px; width: 15%;"/>
					<col style="min-width: 150px; width: 35%;"/>
				</colgroup>
				<tbody>
				<tr>
					<th>执业状态</th>
					<td><input type="text" name="practiceStatus" value="${staff.practiceStatus}" reg="{'maxlength':33}"/></td>
					<th>资格证书编码</th>
					<td><input type="text" name="qualCert" value="${staff.qualCert}" reg="{'maxlength':33}"/></td>
				</tr>
				<tr>
					<th>执业级别</th>
					<td><input type="text" name="practiceLevel" value="${staff.practiceLevel}" reg="{'maxlength':33}"/></td>
					<th>执业证书编码</th>
					<td><input type="text" name="pracCert" value="${staff.pracCert}" reg="{'maxlength':33}"/></td>
				</tr>
				<tr>
					<th>执业类别(专业)</th>
					<td>
						<ehr:dic-list name="practiceType" dicmeta="FS990008" value="${staff.practiceType}" width="150px"/>
					</td>
					<th>批准日期</th>
					<td><%-- <tag:dateInput name="approvalDate" date="${staff.approvalDate}" pattern="yyyy/MM/dd" style="width: 100px"/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" name="approvalDate" id="approvalDate" value="<fmt:formatDate value='${staff.approvalDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
					</td>
				</tr>
				<tr>
					<th>执业科目</th>
					<td><input type="text" name="practiceSubject" value="${staff.practiceSubject}" reg="{'maxlength':33}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
	</div>
    <input type="hidden" name="honorString" id="honorString">
</form>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#birthday' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click'
    });
    
    laydate.render({
        elem: '#partyDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
    laydate.render({
        elem: '#graduateDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
    laydate.render({
        elem: '#startWorkDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
    laydate.render({
        elem: '#orgWorkDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });

    laydate.render({
      elem: '#approvalDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
  });
</script>