<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>
<div class="repeattable">
	<table id="person_record_table">
        <colgroup>
        	<col style="width:15%;"/>
            <col style="width:15%;"/>
            <col style="width:15%;"/>
            <col style="width:15%;"/>
            <col style="width:20%;"/>
            <col style="width:20%;"/>
        </colgroup>
			<thead> 
				<tr>
                    <th>被调阅者姓名</th>
					<th>被调阅者身份证</th>
					<th>调阅人姓名</th> 
					<th>调阅机构</th> 
					<th>调阅时间</th> 
					<th>调阅端来源</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${readHealthRecords}" var="readHealthRecord" varStatus="status"> 
					<tr>
						<td style="text-align:center">${readHealthRecord.personName}</td>
				
						<td style="text-align:center">${readHealthRecord.personIdcard}</td>
				
						<td style="text-align:center">${readHealthRecord.readerName}</td>
						
				     	<td style="text-align:center"><ehr:tip><ehr:org code="${readHealthRecord.readerOrgancode}"/></ehr:tip></td>
				     	
						<td style="text-align:center">${readHealthRecord.readDate}</td>
					
						<td style="text-align:center"><ehr:dic  dicmeta="FS990100" code="${readHealthRecord.source}"/> </td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="recordSearch.search" colspan="10"/>
		<!-- 实现分页功能 -->
	</table>
</div>
