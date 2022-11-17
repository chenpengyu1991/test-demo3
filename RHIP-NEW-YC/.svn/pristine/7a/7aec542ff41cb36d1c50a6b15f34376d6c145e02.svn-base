<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
.f-test td{
width:20px;
}
</style>
<div id="exam-collapse-box">
	<c:forEach items="${examReportsDtos}" var="item" varStatus="status">
        <div class="f-collapse ">
            <div class="f-collapse-title">
               <span class="f-collspse-btn" id="f-collapse-btn-${status.index}"> <a ><c:out value="${item.examineEvent.checkListTitle}"></c:out></a></span>
                <span class="f-collspse-more-btn"><a  title="检验报告单" class="summary_exam_report_btn" href="<c:url value="/exam/report/${item.examineEvent.id}"  />">详细</a></span>
            </div>

            <div id="f-collapse-target-${status.index}" class="f-collapse-target">
                <table class="f-test layui-table x-admin-sm-table-list-small" >
                	<thead>
                		<tr>
	                		<th>项目</th>
	                		<th>结果</th>
	                		<th>参考范围</th>
	                		<th>单位</th>
	                		<th>提示</th>
                		</tr>
                	</thead>
                    <c:forEach items="${item.examineDetails}" var="detail">
                        <tr>
                            <td style="width: 20%;"><ehr:tip>${detail.inspectionItemName}</ehr:tip></td>
                            <td><c:out value="${detail.inspectionResult}"></c:out></td>
                            <td><c:out value="${detail.referenceRange}"></c:out></td>
                            <td><c:out value="${detail.inspectionUnit}"></c:out></td>
                            <td>
                                <c:choose>
                                    <c:when test="${detail.prompt eq '0'}">
                                    </c:when>
                                    <c:otherwise>
                                        <c:out value="${detail.prompt}"></c:out>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
	</c:forEach>
</div>
