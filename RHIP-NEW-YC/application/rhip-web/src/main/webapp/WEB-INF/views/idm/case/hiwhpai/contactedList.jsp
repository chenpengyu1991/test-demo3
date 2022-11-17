<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="repeattable">
    <div class="toolbarsublist">
        4 请填写以下就诊情况
  <a href="javascript:void(0)" id="addEfcList" onclick="hiwhpaiCase.popupEfc(this,'add')"><b class="xinz">添加</b></a>
  <a href="javascript:void(0)" id="importEfc" onclick="caseEdit.contactedImport('205')"><b class="import">导入</b></a>            
    </div>
    <table id="efcTable">
        <thead>
        <tr>
            <th class="centerth" style="width: 20%">姓名</th>
            <th class="centerth" style="width: 15%">性别</th>
            <th class="centerth">与患者关系</th>
            <th class="centerth" style="width: 25%">联系电话</th>
            <th class="centerth" style="width: 140px;">操作</th>
        </tr>
        </thead>
        <c:forEach var="efcObj" items="${caseDto.idmListEfcList}" varStatus="status">
            <tr>
                <td field="name"><ehr:tip>${efcObj.name}</ehr:tip></td>
                <td field="sexStr"><ehr:tip>${efcObj.sexStr}</ehr:tip></td>
                <td field="relation"><ehr:tip>${efcObj.relation}</ehr:tip></td>
                <td field="tel"><ehr:tip>${efcObj.tel}</ehr:tip></td>
                <td field="sex" style="display:none;">${efcObj.sex}</td>
                <td class="btnsublist" field="btn">
                    <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEfc(this,'edit')">修改</a>&nbsp;
                    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


