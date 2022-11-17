<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table>
	<tr>
		<td style="width: 200px; vertical-align: top;">
			<div class="repeattable">
				<fieldset>
					<legend>随访列表</legend>
					<form id="dm-followup-plan-stroke-form">
						<tag:dateInput name="planYear" pattern="yyyy"></tag:dateInput>
					</form>
					<div id="dm-followup-plan-stroke-list"></div>
				</fieldset>
			</div>
		</td>
		<td>
			<div class="Menubox">
				<ul id="dm-followup-stroke-tab">
					<li id="stroke1" onclick="setTab('stroke',1,2)" class="hover"><a style="display: block"  data-target="con_stroke_1">常规管理</a></li>
					<li id="stroke2" onclick="setTab('stroke',2,2)"><a  style="display: block" data-target="con_stroke_2">规范化管理</a></li>
				</ul>
			</div>
			<div id="dm-followup-stroke-tabcontent" style="width: 100%; text-align: left" class="contentbox">
				<div id="con_stroke_1">
					<jsp:include page="normal.jsp"></jsp:include>
				</div>
				<div id="con_stroke_2" style="display: none">
					<jsp:include page="standard.jsp"></jsp:include>
				</div>
			</div>
		</td>
	</tr>
</table>