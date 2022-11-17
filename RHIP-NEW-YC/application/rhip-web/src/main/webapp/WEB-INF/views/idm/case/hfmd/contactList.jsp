<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--密切接触者--%>
<div class="toolbarsublist">
	 患者接触史：<a href="javascript:void(0)" id="addEsList" onclick="hfmdCase.popEs()"><b class="xinz">添加</b></a>
	<%--<a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('3111')"><b class="import">导入</b></a>--%>
</div>
 <input type="hidden" name="epidemiologicalSurvey.id" value="${caseDto.epidemiologicalSurvey.id}"/>
<div  class="repeattable">
   <table id="esTable">
        <thead>
            <tr>
                <th class="centerth" style="width: 8%">病例姓名</th>
                <th class="centerth" style="width: 5%">性别</th>
                <th class="centerth" style="width: 5%">年龄</th>
                <th class="centerth" style="width: 10%">与病例关系</th>
                <th class="centerth" style="width: 10%">发病时间</th>
                <th class="centerth" style="width: 8%">临床诊断</th>
                <th class="centerth" style="width: 18%">接触时间（起止）</th>
                <th class="centerth" style="width: 8%">住院是否</th>
                <th class="centerth">备注</th>
                <th class="centerth" style="width: 80px;">操作</th>
            </tr>
        </thead>
        <c:forEach var="patients" items="${caseDto.idmListEsList}" varStatus="status">
        <tr>
            <td field="name"><ehr:tip>${patients.name}</ehr:tip></td>
            <td field="sexStr"><ehr:tip>${patients.sexStr}</ehr:tip></td>
            <td field="age" reg='{"maxlength":"20"}'><ehr:tip>${patients.age}</ehr:tip></td>
            <td field="relation"><ehr:tip>${patients.relation}</ehr:tip></td>
            <td field="attackDt" ><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.attackDt}"/></ehr:tip></td>
            <td field="clinicalDiagnosis"><ehr:tip>${patients.clinicalDiagnosis}</ehr:tip></td>
            <td field="contactBeginDt" style="display:none;"><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactBeginDt}"/></td>
            <td field="contactEndDt" style="display:none;"><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactEndDt}"/></td>
            <td field="contactDtStr"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactBeginDt}"/>-<fmt:formatDate pattern="yyyy/MM/dd" value="${patients.contactEndDt}"/></ehr:tip></td>
            <td field="inhospitalStr"><ehr:tip>${patients.inhospitalStr}</ehr:tip></td>
            <td field="comments"><ehr:tip>${patients.comments}</ehr:tip></td>
            <td field="sex" style="display:none;"><ehr:tip>${patients.sex}</ehr:tip></td>
            <td field="inhospital" style="display:none;"><ehr:tip>${patients.inhospital}</ehr:tip></td>
            <td class="btnsublist" field="btn">
                <a href="javascript:void(0)" onclick="hfmdCase.editTr(this, 'esList')">修改</a>&nbsp;
                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
            </td>
        </tr>
         </c:forEach>
    </table>
</div>


