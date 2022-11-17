<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	<a href="javascript:void(0)" id="addEfcList" onclick="pertussisCase.popEfc()" ><b class="xinz">添加</b></a>
<!-- 	<a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('3112')"><b class="import">导入</b></a>  -->                                   
</div>
<div class="repeattable">
	<table id="efcTable">
    	<thead>
        	<tr>
            	<th class="centerth" style="width: 8%">密接姓名</th>
                <th class="centerth" style="width: 5%">性别</th>
                <th class="centerth" style="width: 5%">年龄</th>
                <th class="centerth" style="width: 10%">与患者关系</th>
                <th class="centerth" style="width: 8%">接触方式</th>
                <th class="centerth" style="width: 18%">接触时间</th>
                <th class="centerth">医学观察结果</th>
                <th class="centerth" style="width: 80px;">操作</th>
            </tr>
		</thead>
		<c:forEach var="patients" items="${caseDto.idmListEfcList}" varStatus="status">
			<tr>
				<td field="name"><ehr:tip>${patients.name}</ehr:tip></td>
				<td field="sexStr"><ehr:tip>${patients.sexStr}</ehr:tip></td>
				<td field="sex" style="display:none;" title="${patients.sex}">${patients.sex}</td>
				<td field="age"><ehr:tip>${patients.age}</ehr:tip></td>
				<td field="relation"><ehr:tip>${patients.relation}</ehr:tip></td>
				<td field="contactTypeStr"><ehr:tip>${patients.contactTypeStr}</ehr:tip></td>
				<td field="contactType" style="display:none;"><ehr:tip>${patients.contactType}</ehr:tip></td>
				<td field="contactBeginDt" style="display:none;"><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactBeginDt}"/></td>
	            <td field="contactEndDt" style="display:none;"><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactEndDt}"/></td>
				<td field="contactDtStr"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactBeginDt}"/>-<fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactEndDt}"/></ehr:tip></td>
				<td field="medicalObservationResults"  title="${patients.medicalObservationResults}"><ehr:tip>${patients.medicalObservationResults}</ehr:tip></td>
				<td class="btnsublist" field="btn">
				    <a href="javascript:void(0)" onclick="pertussisCase.editTr(this, 'efcList')">修改</a>&nbsp;
				    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>


