<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="repeattable">
    <div class="toolbarsublist">
        <a href="javascript:void(0)" onclick="meningitisCase.initPopEfc()"><b class="xinz">添加</b></a>
        <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('216')"><b class="import">导入</b></a>     
    </div>
    <table id="efcTable">
        <tr>
            <th class="centerth" style="width:8%">姓名</th>
            <th class="centerth" style="width:6%">性别</th>
            <th class="centerth" style="width:6%">年龄</th>
            <th class="centerth" style="width:10%">职业</th>
            <th class="centerth" style="width:15%">住址</th>
            <th class="centerth" style="width:15%">与该病例接触情况</th>
            <th class="centerth" style="width:20%">疫苗接种史</th>
            <th class="centerth">备注</th>
            <th class="centerth" style="width:80px;">操作</th>
        </tr>
        <c:forEach var="efcList" items="${caseDto.idmListEfcList}" varStatus="status">
            <tr>
                <td field="name"><ehr:tip>${efcList.name}</ehr:tip></td>
                <td field="sexStr"><ehr:tip>${efcList.sexStr}</ehr:tip></td>
                <td field="age"><ehr:tip>${efcList.age}</ehr:tip></td>
                <td field="profession"><ehr:tip>${efcList.profession}</ehr:tip></td>
                <td field="unitAddr"><ehr:tip>${efcList.unitAddr}</ehr:tip></td>
                <td field="contactTypeStr"><ehr:tip>${efcList.contactTypeStr}</ehr:tip></td>
                <td field="vaccineHistory"><ehr:tip>${efcList.vaccineHistory}</ehr:tip></td>
                <td field="comments"><ehr:tip>${efcList.comments}</ehr:tip></td>
                <td field="sex" style="display:none;"><ehr:tip>${efcList.sex}</ehr:tip></td>
                <td field="contactType" style="display:none;"><ehr:tip>${efcList.contactType}</ehr:tip></td>
                <td class="btnsublist" field="btn">
                    <a href="javascript:void(0)" onclick="meningitisCase.editTr(this, 'efcList')">修改</a>&nbsp;
                    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


