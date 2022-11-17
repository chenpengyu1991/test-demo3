<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
    function examDetail(ehrId,personId,examinationNumber){

        var dialog = {
        	id :"serviceLisDetail",
            url : "/userSpace/service/lisDetail",
            height : 'auto',
            width : 750,
            title : "检验",
            param : {"ehrId":ehrId,"personId":personId,"examinationNumber":examinationNumber}
        };
        $.dialog(dialog);
    };
</script>
<div  class="rightnav">
	<table >
		<tr>
      		<td class="crumbs"><div id="location" parentMenu="medical-activties" childMenu="lis">当前位置:&gt;&gt;医疗活动&gt;&gt;检验</div>
			</td>
	  	</tr>
	</table>	

	<div class="table-basic">
		<table>
			<thead>
				<tr>
					<th>姓名</th>
					<th>检验单标题</th>
                    <th>检验机构</th>
					<th>检验日期</th>
                    <th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${examineEvents}" var="examineEvent">
					<tr>
                        <td><tags:textWithTip value="${examineEvent.name}"></tags:textWithTip></td>
						<td><tags:textWithTip linkStyle="true" value="${examineEvent.checkListTitle}"></tags:textWithTip></td>
                        <td><tags:textWithTip value="${examineEvent.hospitalName}"></tags:textWithTip></td>
                        <td style="text-align: center; padding-left: 2px;"><fmt:formatDate value="${examineEvent.checkDate}" pattern="yyyy/MM/dd" /></td>
                        <td style="text-align: center; padding-left: 2px;">
                            <a href="javascript:void(0)" class="link" onclick="examDetail('${examineEvent.ehrId}','${examineEvent.personId}','${examineEvent.examinationNumber}')">查看</a>
                        </td>

					</tr>
				</c:forEach>
		</tbody>
	</table>
	</div>
</div>
