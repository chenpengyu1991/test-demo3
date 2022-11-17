<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script type="text/javascript">
	 require(['views/portal/interaction/unitSearch'],function(unitSearch){
		 unitSearch.load();
	 });
</script>
<!-- <div id="infoTypeAdd"> -->
	<form method="post" id="unit_form">
	<%-- <input type="hidden" id="id" value="${hospitalInfo.hospitalInfoNo}"> --%>
	<input id="id" type="hidden" name="id" value="${interaction.id}"/>
		<div class="postdiv">
		<fieldset>
			<legend>转交单位信息</legend>
			<table style="width: 99%" class="posttable">
				<tbody>
                <colgroup>
                    <col style="width:18%;"/>
                    <col style="width:70%;"/>
                </colgroup>
					<tr>
						<th class="coltext"><label>名&nbsp;称:</label></th>
						<td class="colinput">
						 <select id="unit" name="unit">
							<c:forEach items="${hospitalInfo}" var="unit">
									<option value="${unit.hospitalNo}" selected="selected">${unit.hospitalName}</option>
							</c:forEach>
						  </select> 
                        </td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		</div>
	</form>
<!-- </div> -->
<div style="text-align: center">
    <div>
        <br>
        <br>
		<input id="unitSave" class="btnopr" type="button" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="unitCancle" class="btnopr" type="button" value="取消" />
	</div>
</div>