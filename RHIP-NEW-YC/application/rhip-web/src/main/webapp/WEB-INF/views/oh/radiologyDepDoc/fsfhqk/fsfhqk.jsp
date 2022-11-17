<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/fsfhqk/fsfhqk.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:editRecord.backToSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<!-- 放射科机房信息  -->
<div id="radiologyDeptArea">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>放射科情况</legend>
				<label>放射科总面积:</label>
				<c:choose>
				    <c:when test="${empty totleArea }">0</c:when>
				    <c:otherwise>${totleArea }</c:otherwise>
				</c:choose>
				<label>㎡</label>
				<label>,其中:机房面积小计:</label>
				<c:choose>
				    <c:when test="${empty machineHouseArea }">0</c:when>
				    <c:otherwise>${machineHouseArea }</c:otherwise>
				</c:choose>
				<label>㎡</label> 
				<label>,放射科其他场所面积小计:</label>
				<c:choose>
				    <c:when test="${empty otherArea }">0</c:when>
				    <c:otherwise>${otherArea }</c:otherwise>
				</c:choose>
				<label>㎡</label>
				<div id="fskjfxxAdd" class="toolbar">
					<a href="javascript:fsfhqk.addMachineRoomRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
				</div>
				<div id="machineRoomList"></div>
			</fieldset>
		</div>
	</div>
</div>
<div id="alarm">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>放射科位置布置情况</legend>
				<div class="repeattable">
					<table class="layui-table x-admin-sm-table-list-middle">
						<colgroup>
							<col style="width: 4%;" />
							<col style="width: 10%;" />
							<col style="width: 15%;" />
							<col style="width: 16%;" />
							<col style="width: 30%;">
						</colgroup>
						<thead>
							<tr>
								<th class="centerth">警示标识</th>
								<th class="centerth">工作指示灯</th>
								<th class="centerth">门机联锁装置</th>
								<th class="centerth">报警仪</th>
								<th class="centerth">操作</th>
							</tr>
						</thead>
						<tbody class="tbody">
							<tr>
								<td title="<ehr:dic dicmeta="PH00002" code="${record.caution }"></ehr:dic>" style="text-align: center"><ehr:dic dicmeta="PH00002" code="${record.caution }"></ehr:dic></td>
								<td title="<ehr:dic dicmeta="PH00002" code="${record.indicator }"></ehr:dic>" style="text-align: center"><ehr:dic dicmeta="PH00002" code="${record.indicator }"></ehr:dic></td>
								<td title="<ehr:dic dicmeta="PH00002" code="${record.doorInterlock }"></ehr:dic>" style="text-align: center"><ehr:dic dicmeta="PH00002" code="${record.doorInterlock }"></ehr:dic></td>
								<td title="<ehr:dic dicmeta="PH00002" code="${record.alarm }"></ehr:dic>" style="text-align: center"><ehr:dic dicmeta="PH00002" code="${record.alarm }"></ehr:dic></td>
								<td style="text-align: center">
								    <c:if test="${not empty record.layoutUrl }">
								    	<ehr:imageShow imgUrl="${record.layoutUrl}" title="放射科布置图"></ehr:imageShow>
								    </c:if>
								    <c:if test="${not empty record.localtionUrl}">
								    	<ehr:imageShow imgUrl="${record.localtionUrl}" title="放射科位置图"></ehr:imageShow>
								    </c:if>
									<a id="fskwzbzqkModify" href="javascript:void(0);"  onclick="fsfhqk.editRadiologicalPostion('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
	</div>
</div>
<div class="postcontent">
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>其他防护措施</legend>
			<div id="qtfhcsAdd" class="toolbar">
				<a href="javascript:fsfhqk.addCautionAlarmRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>

			</div>
			<div id="cautionAlarmList"></div>
		</fieldset>
	</div>
</div>

