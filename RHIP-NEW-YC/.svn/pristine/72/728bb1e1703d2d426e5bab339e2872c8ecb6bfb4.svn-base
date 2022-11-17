<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
    $(function () {
        $("#cancelButton").click(function (e) {
            e.preventDefault();
            layer.closeAll();
        });
    })
</script>
<div>
	<form id="addLcForm" method="get">
        <input type="hidden" id="rowIndex" value="${rowIndex}" />
        <input type="hidden" id="frType" value="${type}" />
        <input type="hidden" id="recommendType" value="${recommendType}" />
		<div>
			<table  class="layui-table x-admin-sm-table-list-middle" id="popLcTable">
                <colgroup>
                    <col style="width:18%"/>
                    <col style="width:32%"/>
                    <col style="width:18%"/>
                    <col style="width:32%"/>
                </colgroup>
				<tr>
					<th><label class="required">推荐方法：</label></th>
					<td>
                        <c:if test="${total == 12}">
                            <ehr:dic-list id="recommend" name="recommendType" dicmeta="IDM00293" value="${idmListLc.recommendType}" onchange="filStandard.isSelected()" reg='{"required":"true"}'/>
                        </c:if>
                        <c:if test="${total == 21}">
                            <ehr:dic-list id="recommend" name="recommendType" dicmeta="IDM00294" value="${idmListLc.recommendType}" onchange="filStandard.isSelected()" reg='{"required":"true"}'/>
                        </c:if>
                        <c:if test="${total == 11}">
                            <ehr:dic-list id="recommend" name="recommendType" dicmeta="IDM00335" value="${idmListLc.recommendType}" onchange="filStandard.isSelected()" reg='{"required":"true"}'/>
                        </c:if>
                    </td>
					<th>自我照料情况评价：</th>
					<td><ehr:dic-radio name="mindEvaluate" dicmeta="IDM00295" value="${idmListLc.mindEvaluate}"/></td>
				</tr>
				<tr>
					<th>存在问题：</th>
					<td colspan="3"><input type="text" name="existingProblem" value="${idmListLc.existingProblem}" reg='{"maxlength":"200"}' style="width: 220px;"></td>
				</tr>
                <tr>
                    <th>建议：</th>
                    <td colspan="3"><input type="text" name="suggest" value="${idmListLc.suggest}" reg='{"maxlength":"200"}' style="width: 220px;"></td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <button class="layui-btn layui-btn-sm" onclick="filStandard.saveLcData('add')">添加</button>
        </c:if>
        <c:if test="${type == 'edit'}">
            <button class="layui-btn layui-btn-sm" onclick="filStandard.saveLcData('edit')">修改</button>
        </c:if>
        <button id="cancelButton" class="layui-btn layui-btn-sm">取消</button>
    </div>
</div>