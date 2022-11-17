<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div>
	<form id="addOptionForm" method="get">
		<input type="hidden" id="rowIndexed" value="${rowIndex}"/>
		<div>
			<table class="formtable" id="popOptionTable">
				<colgroup>
						<col style="width: 30%" />
						<col style="width: 70%" />
				</colgroup>
				<tr>
					<th><label class="required">选项值：</label></th>
					<td>
						<input type="text" name="value" reg='{"maxlength":"100","required":"true"}' value="${option.value}">
					</td>
				</tr>
				<tr>
					<th><label class="required">选项描述：</label></th>
					<td>
						<input type="text" name="item" reg='{"maxlength":"100","required":"true"}' value="${option.item}">
						<input type="hidden" name="id" value="${option.id}"/>
						<input type="hidden" name="itemId" value="${option.itemId}"/>
					</td>
				</tr>
                <tr ${labelTypeCode eq 'TEXT' ? "style = 'display: none'" : ''}>
                    <th><label class="required">是否默认选中：</label></th>
                    <td>
                    	<ehr:dic-radio name="isDefault" reg='{"required":"true"}' dicmeta="FS10009" value="${option.isDefault == null ? 1 : option.isDefault }"/><!-- FS10009  code="1,2" -->
					</td>
                </tr>
			</table>
		</div>
	</form>
    <div class="toolbarpop">
            <c:if test="${type == 'add'}">
                <input type="button" id="saveContact" value="添加" onclick="itemDetail.saveOptionData('add','${rowIndex}')" class="btnopr">
            </c:if>
            <c:if test="${type == 'edit'}">
                <input type="button" id="editContact" value="修改" onclick="itemDetail.saveOptionData('edit','${rowIndex}')" class="btnopr">
            </c:if>
            <input type="button" id="cancelContact" value="取消" onclick="itemDetail.closePopUp()" class="btnopr">
    </div>
</div>