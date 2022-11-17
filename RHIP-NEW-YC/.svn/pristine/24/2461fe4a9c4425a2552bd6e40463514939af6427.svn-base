<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
    <table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 12%"/>
     <%--       <col style="width: 13%"/>--%>
            <col style="width: 13%"/>
            <col style="width: 30%"/>
            <col style="width: 9%"/>
            <col style="width: 15%"/>
            <col style="width: 9%"/>
            <col style="width: 13%"/>
        </colgroup>
        <thead>
			<tr>
				<th>提问者</th>
				<%--<th>提问机构</th>--%>
				<th>关键词</th>
				<th>内容</th>
				<th>提问时间</th>
				<th>回答人</th>
				<th>回答时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${questions}" var="question">
				<tr>
					<td>
						<ehr:user userCode="${question.submitor}"></ehr:user>
					</td>
					<%--<td><ehr:user userCode="${question.submitor}"/></td>--%>
					<td><ehr:tip>${question.keyWord}</ehr:tip></td>
					<td><ehr:tip>${question.content}</ehr:tip></td>
					<td>
						<fmt:formatDate value='${question.submitTime}' pattern='yyyy/MM/dd'/>
					</td>	
					<td>
						<ehr:user userCode="${question.answer}"></ehr:user>
					</td> 
					<td>
						<fmt:formatDate value='${question.answerTime}' pattern='yyyy/MM/dd'/>
					</td> 
					<td>
						<ehr:authorize ifNotGranted="01">
                        	<c:if test="${empty question.answer}">
                        	<c:if test="${submitor eq question.submitor  || createrOrg eq '_999'}">
                        		<%-- <a href="javascript:void(0)" onclick="questionSearch.addQuestion(${question.id})">修改 </a> --%>
                        		<a href="javascript:void(0)" onclick="questionSearch.addQuestion(${question.id})" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;
                        		<%-- <a href="javascript:void(0)" onclick="questionSearch.deleteQuestion(${question.id})">删除 </a> --%>
                        		<a href="javascript:void(0)" onclick="questionSearch.deleteQuestion(${question.id})" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;
                        		</c:if>
                        	</c:if>
                        	<%-- <c:if test="${not empty question.answer}"> --%>
                    			<%-- <a href="javascript:void(0)" onclick="homepageInit.viewQuestion(${question.id})">查看 </a> --%>
                    			<a href="javascript:void(0)" onclick="homepageInit.viewQuestion(${question.id})" title="查看"><i class="layui-icon">&#xe615;</i></a>&nbsp;
                    		<%-- </c:if> --%>
                        </ehr:authorize>
                        
                        <ehr:authorize ifAnyGranted="01">
                    	    <%-- <a href="javascript:void(0)" onclick="questionSearch.answerQuestion(${question.id})">解答 </a> --%>
                    	    <a href="javascript:void(0)" onclick="questionSearch.answerQuestion(${question.id})" title="解答"><i class="layui-icon">&#xe611;</i></a>&nbsp;
                            <%-- <a href="javascript:void(0)" onclick="questionSearch.deleteQuestion(${question.id})">删除 </a> --%>
                            <a href="javascript:void(0)" onclick="questionSearch.deleteQuestion(${question.id})" title="删除"><i class="layui-icon">&#xe640;</i></a>
                        </ehr:authorize>
					</td>
				</tr>
			</c:forEach>
				<!-- 分页加上后，样式有问题 -->				
			<tr>
				<ehr:pagination action="questionSearch.search" colspan="10" />
			</tr>
		</tbody> 
	</table>
</div>

