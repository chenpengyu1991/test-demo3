<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="toolbarsublist">
    <a href="javascript:void(0)" id="addEfcList" onclick="havCase.popEfc()"><b class="xinz">添加</b></a>
    <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('2031')"><b class="import">导入</b></a>    
</div>
<table id="efcTable">
    <tr>
        <th class="centerth" style="width: 9%">姓名</th>
        <th class="centerth" style="width: 6%">性别</th>
        <th class="centerth" style="width: 6%">年龄</th>
        <th class="centerth" style="width: 10%">关系</th>
        <th class="centerth" style="width: 15%" >单位或住址</th>
        <th class="centerth" style="width: 9%">是否发病</th>
        <th class="centerth" style="width: 12%">发病日期</th>
        <th class="centerth">实验室检查</th>
        <th class="centerth" style="width: 80px;">操作</th>
    </tr>
    <c:forEach var="patients" items="${caseDto.idmListEfcList}" varStatus="status">
        <tr>
            <td field="name"><ehr:tip>${patients.name}</ehr:tip></td>
            <td field="sexStr"><ehr:tip>${patients.sexStr}</ehr:tip></td>
            <td field="age"><ehr:tip>${patients.age}</ehr:tip></td>
            <td field="relation"><ehr:tip>${patients.relation}</ehr:tip></td>
            <td field="unitAddr"><ehr:tip>${patients.unitAddr}</ehr:tip></td>
            <td field="attackStr"><ehr:tip>${patients.attackStr}</ehr:tip></td>
            <td field="attackDt"><ehr:tip><fmt:formatDate pattern='yyyy/MM/dd' value='${patients.attackDt}'/></ehr:tip></td>
            <td field="labExamination"><ehr:tip>${patients.labExamination}</ehr:tip></td>
            <td field="sex" style="display:none;"><ehr:tip>${patients.sex}</ehr:tip></td>
            <td field="attack" style="display:none;"><ehr:tip>${patients.attack}</ehr:tip></td>
            <td class="btnsublist" field="btn">
                <a href="javascript:void(0)" onclick="havCase.editTr(this, 'efcList')">修改</a>
                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>


