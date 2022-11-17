<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div>
	<form id="addDdForm" method="get">
		<input type="hidden" id="rowIndex" value="${rowIndex}"/>
		<div>
			<table class="formtable" id="popDdTable">
				<colgroup>
						<col style="width: 30%" />
						<col style="width: 70%" />
					</colgroup>
				<tr>
					<th><label class="required">日期：</label></th>
					<td>
                         <%--<tag:dateInput name="recordDate" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                         	 date="${listDd.recordDate}" reg='{"required":"true"}'/>--%>
                        <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" name="recordDate" id="recordDate" value="<fmt:formatDate value='${listDd.recordDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                    </td>
				</tr>
				<tr>
					<th>补治次数：</th>
					<td>
						<input type="text" name="repairTreatNumber" reg='{"maxlength":"20"}' value="${listDd.repairTreatNumber }">
						<input type="hidden" name="idmId" value="${singleId}"/>
					</td>
				</tr>
				<tr>
					<th>断药次数：</th>
					<td>
						<input type="text" name="brokenNum" value="${listDd.brokenNum }" reg='{"maxlength":"20"}'>
					</td>
				</tr>
                <tr>
                    <th>漏治次数：</th>
                    <td>
						<input type="text" name="leakageNum" value="${listDd.leakageNum}" reg='{"maxlength":"20"}' >
					</td>
                </tr>
                <tr>
                    <th>漏治原因：</th>
                    <td>
						<input type="text" name="leakageReason" value="${listDd.leakageReason }" reg='{"maxlength":"100"}' >
					</td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <%--<input type="button" id="saveContact" value="添加" onclick="standardization.saveDdData('add','${rowIndex}')">--%>
				<button class="layui-btn layui-btn-sm"  id="saveContact" onclick="standardization.saveDdData('add','${rowIndex}')">添加</button>
            </c:if>
            <c:if test="${type == 'edit'}">
                <%--<input type="button" id="editContact" value="修改" onclick="standardization.saveDdData('edit','${rowIndex}')">--%>
				<button class="layui-btn layui-btn-sm"  id="editContact" onclick="standardization.saveDdData('edit','${rowIndex}')">修改</button>
            </c:if>
            <%--<input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('ddDialog')">--%>
		<button class="layui-btn layui-btn-sm"  id="cancelContact" onclick="idmCommon.closePopUp('ddDialog')">取消</button>
    </div>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#recordDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
            	,done:function (value) {
       				if(!$.isEmpty(value)){
       					$("#recordDate").removeClass("lose");
       				}else{
       					$("#recordDate").addClass("lose");
       				}
       			}
        });
    });
</script>