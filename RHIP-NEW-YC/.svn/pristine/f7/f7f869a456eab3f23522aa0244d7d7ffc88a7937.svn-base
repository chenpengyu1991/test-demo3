<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<div>
		<fieldset>
			<legend>导出列名</legend>
			 ${colNames}
		</fieldset>
	</div>
	<div style="text-align: center">
		<input type="button" id="export" name="exportBtn" onclick="exportTable.exportList()" value="导出"/>
	</div>
	<table id="exportTable"  style="display:none">
		<thead>
			<tr>
				<c:forEach var="col" items="${cloumnMap}">   
		           <th>${col.value}</th>
		        </c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				 <tr>
					<c:forEach var="colm" items="${cloumnMap}"> 
			           <td>${report[colm.key]}</td>
			        </c:forEach>
			    </tr>
			</c:forEach>
		</tbody>
	</table>
</div>