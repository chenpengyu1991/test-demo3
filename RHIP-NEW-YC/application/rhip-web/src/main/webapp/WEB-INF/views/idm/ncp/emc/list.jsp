<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script type="text/javascript">
    $(function(){
        if($("#emcFlagId").val() == 0) {
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("您查询的信息不在已排查的管护范围内！", {icon:0,title:'提示'});
    		});
		}
    })
</script>
<div class="repeattable">
	<input type="hidden" id="emcFlagId" value="${emcFlag}">
<table id="manageCardList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 10%;" />
		<col style="width: 15%" />
		<col style="width: 10%" />
		<col style="width: 40%" />
		<col style="width: 20%" />
	</colgroup>
	<thead>
		<tr>
			<th>姓名</th>
			<th>身份证号</th>
			<th>联系电话</th>
			<th>住址</th>
			<th>结论</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="idmNcp" items="${idmNcpList}" varStatus="status">
			<tr>
				<td><ehr:tip>${idmNcp.name}</ehr:tip></td>
				<td><ehr:tip>${idmNcp.idcard}</ehr:tip></td>
				<td><ehr:tip>${idmNcp.tel}</ehr:tip></td>
				<td><tags:textWithTip value="${idmNcp.paAddress}" /></td>
				<td>
					<c:choose>
						<c:when test="${idmNcp.surveyResult eq '1' || idmNcp.surveyResult eq '2'}">
							<span style="color: red">不能办理健康通行卡</span>
						</c:when>
						<c:otherwise>
						<span style="color: green">可以办理健康通行卡</span>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table>
  <tr>
  	<ehr:pagination action="questionnaireSearch.search"/>
  </tr>
</table>
</div>

