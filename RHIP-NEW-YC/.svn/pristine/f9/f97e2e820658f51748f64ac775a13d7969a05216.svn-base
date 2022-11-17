<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
    	<col style="width: 30px;" />
        <col style="width: 40px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
        <col style="width: 35px;" />
    </colgroup>
        <thead>
        <tr>
         	<th>区县</th>
            <th>机构</th>
            <th>规范建立服务单位数</th>
            <th>发现的事件或线索次数</th>
            <th>报告的事件或线索次数</th>
            <th>卫生计生监督协管信息报告率</th>
            <th>协助开展的食源性疾病、生活饮用水安全、学校卫生、非法行医和非法采供血、计划生育实地巡查次数</th>
        </tr>
        </thead>
        <tbody id="noModifyTbody">
           <c:forEach items="${reports}" var="report">
           <tr>
           		<td>
					<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip>
				</td>
               <td>
					<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
			   </td>
               <td><c:out value="${report.unitnum}"></c:out></td>
               <td><c:out value="${report.findnum}"></c:out></td>
               <td><c:out value="${report.reportnum}"></c:out></td>
               <td>
               		<fmt:formatNumber value="${report.findnum==0?0:(report.reportnum*10000/report.findnum*0.01)}" pattern="#,##0.00"/>%
               </td>
               <td><c:out value="${report.patrolnum}"></c:out></td>
           </tr>
           </c:forEach>
          	 <c:if test="${total!=null}">
	               <tr>
	                   <td colspan="2"><b>合计</b></td>
		               <td><c:out value="${total.unitnum}"></c:out></td>
		               <td><c:out value="${total.findnum}"></c:out></td>
	                   <td><c:out value="${total.reportnum}"></c:out></td>
	                   <td>
							<fmt:formatNumber value="${total.findnum==0?0:(total.reportnum*10000/total.findnum*0.01)}" pattern="#,##0.00"/>%
	                   </td>
                       <td><c:out value="${total.patrolnum}"></c:out></td>
	               </tr>
               </c:if>
        </tbody>
    </table>
</div>
