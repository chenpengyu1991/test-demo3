<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
    function risDetail(id,personId){
        var dialog = {
        	id :"serviceLisDetail",
            url : "/userSpace/service/risDetail",
            height : 'auto',
            width : 650,
            title : "检查",
            param : {"id":id,"personId":personId}
        };
        $.dialog(dialog);
    };
</script>
<div class="rightnav">
	<table style="">
		<tr>
      		<td class="crumbs"><div id="location" parentMenu="medical-activties" childMenu="ris">当前位置:&gt;&gt;医疗活动&gt;&gt;检查</div>
			</td>
	  	</tr>
	</table>	
	<div class="table-basic">
		<table>
			<thead>
				<tr>
                    <th>姓名</th>
					<th>检查项目名称</th>
					<th>检查机构</th>
                    <th>检查日期</th>
                    <th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studyEvents}" var="studyEvent">
					<tr>
                        <td><tags:textWithTip value="${studyEvent.name}"></tags:textWithTip></td>
						<td><tags:textWithTip linkStyle="true" value="${studyEvent.inspectionItemName}"></tags:textWithTip></td>
						<td><tags:textWithTip value="${studyEvent.hospitalName}"></tags:textWithTip></td>
                        <td style="text-align: center; padding-left: 2px;"><fmt:formatDate value="${studyEvent.checkDate}" pattern="yyyy/MM/dd" /></td>
                        <td style="text-align: center; padding-left: 2px;">
                            <a href="javascript:void(0)" class="link" onclick="risDetail('${studyEvent.id}','${studyEvent.personId}')">查看</a>
                        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>