<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
    $(function() {
       staffMergeSplit.confirmStart();
    });
</script>
<div class="content">
	<table class="formtable">
		<th width="25%">请选择最佳记录</th>
		<td>
			<select id="smpiSelect">
				<c:forTokens var="sid" items="${sids}" delims=",">
					<option value="${sid}">${sid}</option>
				</c:forTokens>
			</select>
		</td>
	</table>
	<div id="staffMainDetailDiv">
		<div class="titlebar" style="margin-top: 10px;">
			<div class="title">人员业务号信息</div>
			<div class="toobar"></div>
		</div>
		<table class="formtable">
			<tiles:insertAttribute name="staffCareerInfo"/>
		</table>
		<tiles:insertAttribute name="staffBasicInfo"/>
	</div>
	<div>
		<input id="doMergeBtn" type="button" value="合并"/>&nbsp;&nbsp;&nbsp;
		<input id="cancelMergeBtn" type="button" value="取消"/>
	</div>
</div>