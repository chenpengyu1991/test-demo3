<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%--报告登记页面--%>
<form>
	<div class="postcontent">
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
				</colgroup>
				<tr>
					<th><label for="discoveryDate">发现时间</label></th>
					<td><input type="text" id="discoveryDate" name="discoveryDate" value="${discoveryDate}" reg="{}"></input></td>
				</tr>
				<tr>
					<th><label for="infoTypeCode">信息类别</label></th>
					<td><select name="infoTypeCode">
							<option value="食品安全">食品安全</option>
							<option value="公共场所卫生">公共场所卫生</option>
							<option value="生活饮用水">生活饮用水</option>
							<option value="职业病危害">职业病危害</option>
							<option value="学校卫生">学校卫生</option>
							<option value="非法行医（采供血）">非法行医（采供血）</option>
							<option value="全部">全部</option>
					</select></td>
				</tr>
				<tr>
					<th>可疑职业病人</th>
					<td colspan="3"><jsp:include page="../sodp/add/main.jsp"></jsp:include></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th><label for="infoContent">信息内容</label></th>
					<td><textarea style="min-width: 500px; height: 120px" id="infoContent" name="infoContent" reg="{'maxlength':300}">${infoContent}</textarea></td>
				</tr>
				<tr>
					<th><label for="reportDate">报告时间</label></th>
					<td><input type="text" id="reportDate" name="reportDate" value="${reportDate==null?'2013/08/01':''}" reg="{}"></input></td>
					<th><label for="reporterName">报告人姓名</label></th>
					<td><input type="text" readonly="readonly" value="<ehr:user userCode='${reporterName}' />" />
				</tr>
			</table>
		</div>
	</div>
</form>
