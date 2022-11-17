<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend>非药物治疗措施</legend>
	<table class="posttable" >
		<tr>
			<td style="height: 50px">
				<ehr:dic-checkbox dicmeta="DMD00054" name="nonDrugs" value="${strtum.nonDrugs}"></ehr:dic-checkbox>
				<br />
				<input style="width:82%" type="text" reg="{'maxlength':100}" name="nonDrugsOther" value="${strtum.nonDrugsOther}" />(其他措施详细)
			</td>
		</tr>
	</table>
</fieldset>