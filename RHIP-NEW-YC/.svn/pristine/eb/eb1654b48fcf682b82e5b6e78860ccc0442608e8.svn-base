<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="toolbar">
	<a href="javascript:void(0)" id="back" onclick="ceSearch.search();"><b class="fanhui">返回</b></a>
</div>
<form id="continueEducation_form" class="postcontent">
    <div class="postdiv">
        <fieldset>
            <legend>继续教育</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tbody>
	                <tr>
						<th>医护人员</th>
						<td>
							<ehr:staff-name staffCode="${continueEducation.staffCode}" />
						</td>
						<th>登记年份</th>
						<td>
							${continueEducation.recordYear}
						</td>
					</tr>
					<tr>
						<th>项目代号</th>
						<td>
							${continueEducation.projectNo}
						</td>
						<th>项目名称</th>
						<td>
							${continueEducation.projectName}
						</td>
					</tr>
					<tr>
						<th>举办单位</th>
						<td>
							${continueEducation.organizer}
						</td>
						<th>学时数</th>
						<td>
							${continueEducation.period}
						</td>
					</tr>
					<tr>
						<th>一类学分</th>
						<td>
							${continueEducation.creditA}
						</td>
						<th>二类学分</th>
						<td>
							${continueEducation.creditB}
						</td>
					</tr>
					<tr>
						<th>创建机构编码</th>
						<td>
							<ehr:org code="${continueEducation.createOrganCode}" />
						</td>
						<th>创建操作人</th>
						<td>
							<ehr:user userCode="${continueEducation.createUserCode}" />
						</td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td>
							<fmt:formatDate value="${continueEducation.createDate}" pattern="yyyy/MM/dd"/>
						</td>
						<th>更新机构编码</th>
						<td>
							<ehr:org code="${continueEducation.updateOrganCode}" />
						</td>
					</tr>
					<tr>
						<th>更新操作人</th>
						<td>
							<ehr:user userCode="${continueEducation.updateUserCode}" />
						</td>
						<th>更新时间</th>
						<td>
							<fmt:formatDate value="${continueEducation.updateDate}" pattern="yyyy/MM/dd"/>
						</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</form>