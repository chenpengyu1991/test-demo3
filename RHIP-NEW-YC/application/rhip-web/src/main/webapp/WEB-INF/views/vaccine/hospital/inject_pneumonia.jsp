<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/inject_vaccine.js" type="text/javascript"></script>

<form id="vaccine_contine_save">
	<div class="postdiv">
		<input type="hidden" name="ehrId" value="${ehrId}"/>
		<fieldset class="layui-elem-field">
		<legend>接种情况登记</legend>
		<table style="width:99%" class="posttable">
			<tbody>
				<tr>
					<th>
						<label class="required">接种日期：</label>
					</th>
					<td>

						<%--<tag:dateInput  name="vaccinationDate" date="${currentDate}"--%>
							 <%--reg='{"required":true}' onlypast="true" />--%>
						<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="vaccinationDate" id="vaccinationDate" value="<fmt:formatDate value='${currentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
					</td>
					<th>
						<label class="required">剂量：</label>
					</th>
					<td>
						<select style="width: 80%;" name="vaccineMeasurement" reg='{"required":"true"}'>
                            <option value="">请选择</option>
							<option <c:if test="${vaccinationInfo.vaccineMeasurement eq '1'}">selected="selected"</c:if> value="1">1</option>
							<option <c:if test="${vaccinationInfo.vaccineMeasurement eq '2'}">selected="selected"</c:if> value="2">2</option>
							<option <c:if test="${vaccinationInfo.vaccineMeasurement eq '3'}">selected="selected"</c:if> value="3">3</option>
						</select>&nbsp; 剂
					</td>
					<!-- <th>
						<label class="required">制品名称： </label>
					</th>
					<td>
						<input type="text" name="vaccineName"
							 reg='{"required":"true","maxlength":"33"}' />
					</td> -->
					<th>
						<label class="required">疫苗规格： </label>
					</th>
					<td>
						<select name="vaccineSpec" style="width: 80%;">
							<option value="0.1ML">0.1ML</option>
							<option value="0.5ML" selected="selected">0.5ML</option>
							<option value="1ML">1ML</option>
							<option value="其他">其他</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						<label class="required">生产厂家：</label>
					</th>
					<td>
						<tag:autoSelect name="vaccineCompanyCode" id="vaccineCompanyCode" nameValue="成都生物制品研究所" codeValue="12" style="width:150px"  reg='{"required":"true","maxlength":"33"}'></tag:autoSelect>
						<input type="hidden" name="vaccineFactory" id="vaccineFactory"/>
						<!--<input type="text" class="factoryClass" name="vaccineFactory" reg='{"required":"true","maxlength":"33"}' /> -->
					</td>
					<th>
						<label class="required">疫苗批号：</label>
					</th>
					<td>
						<input type="text" name="vaccineLotNumber" 
							reg='{"required":"true","maxlength":"20","regex":"^[A-Za-z0-9]+$"}' tip="请输入英文大小写或者数字符号" value="${vaccinationInfo.vaccineLotNumber}"/>
						</td>
					<th>
						<label class="required">接种人：</label>
					</th>
					<td>
						<input type="text" name="vaccinationDoctorName" 
							reg='{"required":"true","maxlength":"16"}' value="${vaccinationInfo.vaccinationDoctorName}"/>
					</td>
				</tr>
				<tr>
					<th>
						<label class="required">接种部位：</label>
					</th>
					<td>
						<ehr:dic-list name="immuPosition" dicmeta="FS990031" reg='{"required":"true"}' value="${vaccinationInfo.immuPosition}" width="80%;" uninclude="05"/>
					</td>
					<th>
						<label class="required">接种途径：</label>
					</th>
					<td>
						<ehr:dic-list name="vaccineWay" dicmeta="FS990032" reg='{"required":"true"}' value="${vaccinationInfo.vaccineWay}" width="80%;"></ehr:dic-list>
					<th>
						<label class="required">是否收费：</label>
					</th>
					<td>
						<ehr:dic-radio name="feeFlag" dicmeta="PH00001"
                    	value="${vaccinationInfo.feeFlag}" code="1,2" reg='{"required":"true"}' onchange="injectVaccine.viewFeeArea(this.value)"/>
                    	<div id="feeDiv" style="float: right;padding-right: 10px;"></div>
					</td>
				</tr>
			</tbody>
		</table>
		</fieldset>
		
		<!-- 备注 -->
		<div class="postdiv">
			<fieldset class="layui-elem-field">
			<legend>备注</legend>
			<table class="posttable" style="width: 98%;">
			<tr>
			<td>
			<textarea class="vacnte" name="comment" style="width: 100%;" rows="5" cols="40">${vaccinationEvent.comments}</textarea>
			</td>
			</tr>
			</table>
			</fieldset>
		</div>
		
		<div class="vacbtn">
			<!-- <input id="rabiesContineSave" class="btn" type="button" value="保存"/> -->
			<button class="layui-btn layui-btn-sm"  id="rabiesContineSave">保存</button>
		</div>
	</div>
</form>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#vaccinationDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
    });
</script>