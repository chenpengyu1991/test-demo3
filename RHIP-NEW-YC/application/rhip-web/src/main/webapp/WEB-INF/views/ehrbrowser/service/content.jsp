<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%--<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/main.js" type="text/javascript"></script>--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/service/main.css" />

<div style="padding: 9px 2px 2px 9px; background-color: #fff">
	<div >
			<form id="data-range-form">
                <table>
                    <tr class="sm_bg"  >
                        <td ></td>
                        <td style="width:320px;" >  <div id="ehrservice-list-organ-code-select-content" ></div></td>
                        <td style="width: 210px;">
                                <label><input class="daterange-radio" type="radio" value="1" name="timeType" checked="checked" />最近三个月</label>
                                <label><input class="daterange-radio" name="timeType" value="2" type="radio" />最近一年</label>
                                <label><input class="daterange-radio" name="timeType" value="3" type="radio" />全部</label>
                        </td>
                    </tr>
                </table>

			</form>
	</div>
	<div  id="medical_index_content"></div>
</div>

