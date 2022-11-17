<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/inject_vaccine.js" type="text/javascript"></script>

<form id="vaccine_contine_save">
	<div id="vaccinationAgain" class="postdiv">
		<input type="hidden" name="ehrId" value="${ehrId}"/>
		<fieldset class="layui-elem-field">
		<legend>接种情况登记</legend>
		<table style="width:99%" class="posttable">
            <colgroup >
                <col width="13%" />
                <col width="20%" />
                <col width="10%" />
                <col width="26%" />
                <col width="10%" />
                <col width="20%" />
            <colgroup>
			<tbody>
				<tr>
					<th>接种次数：</th>
					<td>
						<select id="vaccineType" name="inoculationTimes">
							<c:if test="${fn:indexOf(timesString,'1')==-1}">
								<option value="1">第一次接种</option>
							</c:if>
							<c:if test="${fn:indexOf(timesString,'2')==-1}">
								<option value="2">第二次接种</option>	
							</c:if>
							<c:if test="${fn:indexOf(timesString,'3')==-1}">
								<option value="3">第三次接种</option>
							</c:if>	
							<c:if test="${fn:indexOf(timesString,'4')==-1}">
								<option value="4">第四次接种</option>
							</c:if>	
							<c:if test="${fn:indexOf(timesString,'5')==-1}">
								<option value="5">第五次接种</option>
							</c:if>
						</select>
					</td>
					<th>
                        <label class="required">接种日期：</label>
                    </th>
					<td>
                        <%--<tag:dateInput  name="vaccinationDate" reg='{"required":"true"}' date="${currentDate}" onlypast="true" />--%>
						<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="vaccinationDate" id="vaccinationDate" value="<fmt:formatDate value='${currentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
					</td>
					<th>
                        <label class="required">剂量：</label>
                    </th>
					<td>
                        <select style="width: 70px;" name="vaccineMeasurement" reg='{"required":"true"}'>
                        	<option value="">请选择</option>
                        	<option value="1">1</option>
                        	<option value="2">2</option>
                        	<option value="3">3</option>
                        </select>&nbsp;剂
                    </td>
				</tr>
				<tr>
					<th>
                        <label class="required">生产厂家：</label>
                    </th>
					<td>
						<tag:autoSelect name="vaccineCompanyCode" id="vaccineCompanyCode" nameValue="辽宁成大苗" codeValue="4" style="width:150px"  reg='{"required":"true","maxlength":"33"}'></tag:autoSelect>
						<input type="hidden" name="vaccineFactory" id="vaccineFactory"/>					
                        <%--<input type="text" name="vaccineFactory" class="factoryClass" reg='{"required":"true","maxlength":"33"}'/> --%>
                    </td>
     				<!-- <th>
                        <label class="required">制品名称：</label>
                    </th>
					<td>
						<input type="text" name="vaccineName" reg='{"required":"true","maxlength":"33"}'/>
					</td> -->
					<th>
                        <label class="required">疫苗批号：</label>
                    </th>
					<td>
						<input type="text" name="vaccineLotNumber"
                        reg='{"required":"true","maxlength":"20",	"regex":"^[A-Za-z0-9]+$"}' tip="请输入英文大小写或者数字符号"/>
					</td>
					<th>
                        <label class="required">接种人：</label>
                    </th>
					<td>
                        <input type="text" name="vaccinationDoctorName" reg='{"required":"true","maxlength":"16"}'/>
                    </td>
				</tr>
				<!-- <tr>
					<th>
                        <label class="required">接种人：</label>
                    </th>
					<td>
                        <input type="text" name="vaccinationDoctorName" reg='{"required":"true","maxlength":"16"}'/>
                    </td>
				</tr> -->
			</tbody>
		</table>
		</fieldset>
	</div>
		
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