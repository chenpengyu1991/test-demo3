<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table>
	<tr>
		<td style="width: 200px; vertical-align: top;">
			<div class="postdiv">
				<fieldset>
					<legend>随访列表</legend>
					<form id="dm-followup-plan-coronary-form">
						年度 <tag:dateInput date="${currentDate }"  style="width:50px;" name="planYear" pattern="yyyy"></tag:dateInput>
					</form>
					<div class="repeattable">
						<div id="dm-followup-plan-coronary-list"></div>
					</div>
				</fieldset>
			</div>
		</td>
		<td>
			<div id="coronaryFollowupInputDiv"></div>
		</td>
	</tr>
</table>