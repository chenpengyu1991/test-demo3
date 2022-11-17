<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div>
	<form id="addFrForm" method="get">
		<input type="hidden" id="rowIndexed" value="${rowIndex}"/>
		<div>
			<table class="formtable" id="popFrTable">
				<colgroup>
						<col style="width: 30%" />
						<col style="width: 70%" />
					</colgroup>
				<tr>
					<th>日期：</th>
					<td>
                         <%--<tag:dateInput name="visitDt" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                         	 date="${listFr.visitDt==null ? nowDate : listFr.visitDt}"/>--%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="visitDt" id="visitDt" value="<fmt:formatDate value='${listFr.visitDt==null ? nowDate : listFr.visitDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
					</td>
				</tr>
				<tr>
					<th>督导访视内容及改进意见：</th>
					<td>
						<input type="text" name="visitContent" reg='{"maxlength":"200"}' value="${listFr.visitContent}">
						<input type="hidden" name="idmId" value="${singleId}"/>
						<input type="hidden" name="visitInst" value="${listFr.visitInst==null ? currentLoginInfo.organization.organCode : listFr.visitInst }">
						<input type="hidden" name="visitById" value="${listFr.visitById == null ? currentLoginInfo.user.id : listFr.visitById}"/>
					</td>
				</tr>
				<tr>
					<th>访视单位：</th>
					<td>
						<c:choose>
							<c:when test="${listFr.idmId == null}"><input type="text" name="visitInstStr" value="${currentLoginInfo.organization.organName}" disabled="disabled"></c:when>
							<c:otherwise><input type="text" name="visitInstStr" value="${listFr.visitInstStr}" disabled="disabled"></c:otherwise>
						</c:choose>
					</td>
				</tr>
                <tr>
                    <th>访视人：</th>
                    <td>
                    	<c:choose>
							<c:when test="${listFr.idmId == null}"><input type="text" name="visitByIdStr" value="${currentLoginInfo.user.name}" disabled="disabled"></c:when>
							<c:otherwise><input type="text" name="visitByIdStr" value="${listFr.visitByIdStr}" disabled="disabled"></c:otherwise>
						</c:choose>
					</td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <%--<input type="button" id="saveContact" value="添加" onclick="standardization.saveFrData('add','${rowIndex}')">--%>
                <button class="layui-btn layui-btn-sm"  id="saveContact" onclick="standardization.saveFrData('add','${rowIndex}')">添加</button>
            </c:if>
            <c:if test="${type == 'edit'}">
                <%--<input type="button" id="editContact" value="修改" onclick="standardization.saveFrData('edit','${rowIndex}')">--%>
                <button class="layui-btn layui-btn-sm"  id="editContact" onclick="standardization.saveFrData('edit','${rowIndex}')">修改</button>
            </c:if>
            <%--<input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('frDialog')">--%>
            <button class="layui-btn layui-btn-sm"  id="cancelContact" onclick="idmCommon.closePopUp('frDialog')">取消</button>
    </div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#visitDt'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
    });
</script>
