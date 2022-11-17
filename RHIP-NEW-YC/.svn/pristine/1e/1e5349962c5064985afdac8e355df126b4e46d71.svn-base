<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	layui.use('laydate', function(){
        var laydate = layui.laydate;
		//年月日
		laydate.render({
		  elem: '#monitorTime'
		  ,format: 'yyyy/MM/dd'
		  ,max:0 //今天之后不可选
		});
		laydate.render({
		  elem: '#manufactureDate'
		  ,format: 'yyyy/MM/dd'
		  ,max:0 //今天之后不可选
		});
	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorEdit.js"/>
<div>
	<form id="editForm" class="postcontent">
		<div class="postdiv">
			<c:if test="${surveyType eq 1}">
				<i class="popno">盐业零售层次食盐碘含量监测表</i>
			</c:if>
			<c:if test="${surveyType eq 2}">
				<i class="popno">盐业批发层次食盐碘含量监测表</i>
			</c:if>
			<table class="posttable">
				<input type="hidden" name="id" value="${record.id}"/>
				<input type="hidden" name="surveyType" value="${surveyType}"/>
				<input type="hidden" name="function" value="iodineContent"/>
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<c:if test="${surveyType eq 1}">
					<tr>
						<th><label class="required">采样零售店名称</label></th>
						<td><input type="text" name="name" value="${record.name}" style="width: 150px" reg="{'required':'true','maxlength':100}"/></td>
						<th><label class="required">采样日期</label></th>
						<td>
							<input type="text" name="monitorTime" id="monitorTime" value="<fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 100px;" reg="{'required':'true'}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">采样零售店地址</label></th>
						<td><input type="text" name="houseNumber" value="${record.houseNumber}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
						<th>生产日期</th>
						<td>
							<input type="text" name="EndemicPreventDTO.saltTestRecords[0].manufactureDate" id="manufactureDate" value="<fmt:formatDate value="${test.manufactureDate}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">盐样编号</label></th>
						<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltSamplingNumber" value="${test.saltSamplingNumber}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
						<th>保质期</th>
						<td><tag:numberInput name="EndemicPreventDTO.saltTestRecords[0].bestBeforeDate" value="${test.bestBeforeDate}" style="width: 100px" reg="{'max':9999}"/> 月</td>
					</tr>
					<tr>
						<th>盐样品种</th>
						<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltType" value="${test.saltType}" style="width: 150px;"/></td>
						<th><label class="required">食盐碘含量</label></th>
						<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltIodineContent" value="${test.saltIodineContent}" style="width: 100px" reg='{"required":"true","number":"true","scale":2,"max":999999.99}'/> mg/Kg</td>
					</tr>
					<tr>
						<th>盐样包装规格</th>
						<td><tag:numberInput name="EndemicPreventDTO.saltTestRecords[0].saltPackingSize" value="${test.saltPackingSize}" style="width: 150px" reg="{'maxlength':10}"/> g/袋</td>
						<th>零售价格</th>
						<td><tag:numberInput name="EndemicPreventDTO.saltTestRecords[0].saltPrice" value="${test.saltPrice}" point="point" style="width: 100px" reg="{'scale':2,'max':999.99}"/> 元/袋</td>
					</tr>
				</c:if>
				<c:if test="${surveyType eq 2}">
					<tr>
						<th><label class="required">盐业批发企业名称</label></th>
						<td><input type="text" name="name" value="${record.name}" style="width: 150px;vertical-align: top;" reg="{'required':'true','maxlength':100}"/></td>
						<th><label class="required">采样日期</label></th>
						<td><input type="text" id="monitorTime" name="monitorTime" value="<fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/>"  style="width: 100px;vertical-align: top;" reg="{'required':'true'}"/></td>
					</tr>
					<tr>
						<th><label class="required">盐样编号</label></th>
						<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltSamplingNumber" value="${test.saltSamplingNumber}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
						<th>生产日期</th>
						<td>
							<input type="text"   name="EndemicPreventDTO.saltTestRecords[0].manufactureDate" id="manufactureDate" value="<fmt:formatDate value="${test.manufactureDate}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th>盐样品种</th>
						<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltType" value="${test.saltType}" style="width: 150px;"/></td>
						<th>保质期</th>
						<td><tag:numberInput name="EndemicPreventDTO.saltTestRecords[0].bestBeforeDate" value="${test.bestBeforeDate}" style="width: 100px" reg="{'max':9999}"/> 月</td>
					</tr>
					<tr>
						<th>盐样包装规格</th>
						<td><tag:numberInput name="EndemicPreventDTO.saltTestRecords[0].saltPackingSize" value="${test.saltPackingSize}" style="width: 150px" reg="{'maxlength':10}"/> g/袋</td>
						<th><label class="required">食盐碘含量</label></th>
						<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltIodineContent" value="${test.saltIodineContent}" style="width: 100px" reg='{"required":"true","number":"true","scale":2,"max":999999.99}'/> mg/Kg</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3"><textarea name="EndemicPreventDTO.saltTestRecords[0].testRemark" rows="3" reg="{'maxlength':100}">${test.testRemark}</textarea></td>
					</tr>
				</c:if>
				</tbody>
			</table>
		</div>
	</form>
	<!-- <div class="toolbarpop" style="margin-top: -30px;">
		<a href="javascript:void(0);" id="save"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</div> -->
	<div><input type="hidden" id="dialogId" value="iodineContentDialog"/></div>
</div>