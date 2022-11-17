<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>

<script type="text/javascript">
	 require(['views/portal/infoType/subAdd'],function(subAdd){
		 subAdd.load();
	 });
</script>
<div id="subInfoTypeAdd">
	<form method="post" id="info_Type_form">
		<input id="id" name="id" type="hidden" value="${id} " />
		<input name="parentCode" type="hidden" value="${subInfoType.parentCode} " />
		<div class="postcontent">
		<fieldset>
			<legend>服务信息</legend>
			<table style="width: 99%" class="posttable">
				<tbody>
                <colgroup>
                    <col style="width:8%;"/>
                    <col style="width:70%;"/>
                </colgroup>
					<tr>
						<th class="coltext"><label class="required">名&nbsp;称:</label></th>
						<td class="colinput"><input type="text" id="serviceTypeName"   style="width: 50%"
                                                    name="name" reg='{"required":"true","maxlength":"10"}' value="${subInfoType.name}" />
                        </td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		</div>
	</form>
</div>
<div style="text-align: center">
    <div>
        <br>
        <br>
		<input id="subinfoTypeSave" class="btnopr" type="button" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="subInfoTypeCancle" class="btnopr" type="button" value="取消" />
	</div>
</div>