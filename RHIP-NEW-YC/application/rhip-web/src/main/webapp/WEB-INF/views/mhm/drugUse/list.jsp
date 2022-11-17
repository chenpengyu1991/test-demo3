<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:20px;width:4%;"/>
	        <col style="min-width:60px;width:8%;"/>
			<col style="min-width:30px;width:5%;"/>
			<col style="min-width:30px;width:5%;"/>
			<col style="min-width:80px;width:12%;"/>
			<col style="min-width:60px;width:8%;"/>
			<col style="min-width:80px;width:10%;"/>
			<col style="min-width:80px;width:8%;"/>
			<col style="min-width:80px;width:8%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身份证号</th>
				<th>所属乡镇</th>
				<th>登记日期</th>
				<th>诊断</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
        <c:forEach var="mgnt" items="${mhmMgnts}" varStatus="status">
            <tr>
                <td class="centertd">${status.count}</td>
                <td class="centertd"><ehr:tip>${mgnt.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${mgnt.gender}" /></ehr:tip></td>
                <td class="centertd">${mgnt.age}</td>
                <td class="centertd"><ehr:tip>${mgnt.idcard}</ehr:tip></td>
                <td>
                    <ehr:tip><ehr:dic dicmeta="FS990001" code="${mgnt.managementTown}"/></ehr:tip>
                </td>
                <td class="centertd">
                    <fmt:formatDate value="${mgnt.fillDate}" pattern="yyyy/MM/dd" />
                </td>
                <td><ehr:tip>${mgnt.diagnosisContent}</ehr:tip></td>
                <td class="centertd">
                    <c:if test="${mgnt.logoff=='0'}">
                        <%-- <a href="javascript:void(0)" onclick="drugUseSearch.editDrugUse(${mgnt.statusId})" class="person-link-btn">发药登记</a> --%>
                        <a href="javascript:void(0)" onclick="drugUseSearch.editDrugUse(${mgnt.statusId})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="发药登记"><i class="layui-icon">&#xe608;</i>发药登记</a>
                    </c:if>
                    <c:if test="${mgnt.logoff=='1'}">发药登记
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
			<ehr:pagination action="drugUseSearch.searchDrugUse" colspan="9"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="drugUseSearch.searchDrugUse" />
		</tr>
	</table> --%>
</div>