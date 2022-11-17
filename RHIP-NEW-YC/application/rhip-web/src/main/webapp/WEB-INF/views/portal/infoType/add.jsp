<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>

<script type="text/javascript">
	 require(['views/portal/infoType/add'],function(infoTypeAdd){
		 infoTypeAdd.load();
	 });
</script>
<div id="infoTypeAdd">
	<form method="post" id="info_Type_form">
		<input name="id" type="hidden" value="${infoType.id} " />
		<div class="postcontent"><!-- postdiv -->
		<fieldset>
			<legend>服务类别信息</legend>
			<table style="width: 99%" class="posttable">
				<tbody>
                <colgroup>
                    <col style="width:8%;"/>
                    <col style="width:70%;"/>
                </colgroup>
                	<tr>
						<th>
							<label class="required">名&nbsp;称:</label>
						</th>
						<td>
							<input type="text" id="serviceTypeName"   style="width: 50%"
                                                    name="name" reg='{"required":"true","maxlength":"10"}' value="${infoType.name}" />
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
		<input id="infoTypeSave" class="btnopr" type="button" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="infoTypeCancle" class="btnopr" type="button" value="取消" />
	</div>
</div>