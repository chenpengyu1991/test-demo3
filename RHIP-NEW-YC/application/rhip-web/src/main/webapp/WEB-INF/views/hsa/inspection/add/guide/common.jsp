<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<table class="posttable ">
	<colgroup>
		<col style="width: 100%;" />
	</colgroup>
	<tr>
		<td>
			<textarea reg="{'maxlength':1000,'required':true}" style="min-height: 250px;" name="inspGuideRecord.commonContent">${inspRecord.inspGuideRecord.commonContent}</textarea>
		</td>
	</tr>
</table>