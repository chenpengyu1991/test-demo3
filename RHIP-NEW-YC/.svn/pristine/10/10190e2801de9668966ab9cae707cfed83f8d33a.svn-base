<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--<script src="${pageContext.request.contextPath}/js/views/ehr/family/member.js" type="text/javascript"></script>--%>
<%--<script type="text/javascript">
	require(['views/ehr/family/member'],function(memberFamily){
		memberFamily.load();
	});
</script>--%>
<script src="${pageContext.request.contextPath}/js/views/ehr/family/member2.js" type="text/javascript"></script>
<c:if test="${not empty msg}">
  <input type="hidden" id="firstMsg" value="${msg}">
</c:if>
<form id="memberForm" name="memberForm" action="" method="post">
	<div class="postdiv">
	<fieldset style="margin:8px 5px 5px 5px;float:left;width:480px; height:320px;" class="layui-elem-field">
		<legend>待加入成员:</legend>
		<i style="font-size: 14px;">
			姓名<input type="text" id="personName" value="${personName}" style="width:70px" class="x-layui-input"/>
		           身份证号 <input type="text" id="idCard" value="${idCard}"  style="width:200px" class="x-layui-input"/>
			<%--<input type="button" id="memberFamilySearchId" class="width50" value="查询"/>--%>
			<button class="layui-btn layui-btn-sm" id="memberFamilySearchId"><i class="layui-icon">&#xe615;</i>查询</button>
		</i>
		<div class="repeattable">
		<table id="allMembers" class="layui-table x-admin-sm-table-list-small">
			<thead>
				<tr>
					<th style="text-align: center;" width="8%"><input type="checkbox" name="personCheck" id="personAllCheck"/></th>
					<th style="text-align: center;">姓名</th>
					<th style="text-align: center;">出生日期</th>
					<th style="text-align: center;">性别</th>
				</tr>
			</thead>
      		<tbody>
   			<c:forEach items="${personList }" var="person" varStatus="status">
		   		 <tr>
		   		 	<td>
		   		 		<c:if test="${not empty person.id}">
		   		 			<input type="checkbox" chkRef="personCheck" name="FamilyRecordDTO.personInfoList[${status.index}].id" value="${person.id}"/>
		   		 		</c:if>
		   		 	</td>
		   		 	<td>
		   		 		&nbsp;${person.name }
		   		 		<input type="hidden" name="FamilyRecordDTO.personInfoList[${status.index}].name" value="${person.name}"/>
                        <input type="hidden" name="FamilyRecordDTO.personInfoList[${status.index}].idcard" value="${person.idcard}"/>
		   		 	</td>
		   		 	<td>&nbsp;<fmt:formatDate value="${person.birthday }" pattern="yyyy/MM/dd"/>
		   		 		<input type="hidden" name="FamilyRecordDTO.personInfoList[${status.index}].birthday"
		   		 		 value="<fmt:formatDate value='${person.birthday }' pattern='yyyy/MM/dd'/>"/>
		   		 	</td>
		   		 	<td>&nbsp;   <ehr:dic dicmeta="GBT226112003" code="${person.gender }"/>
                          <input type="hidden" name="FamilyRecordDTO.personInfoList[${status.index}].gender" value="${person.gender}"/>
	   		 		</td>
		   		 </tr>
	   		</c:forEach>
	   		<tr>
	   			<td colspan="4">
	   				<ehr:paging  hidePageSize="true" action="familyMember.personSearch"/>
	   			</td>
	   		</tr>
   			</tbody>
		</table>
		<%-- <ehr:paging  hidePageSize="true"/> --%>
		<%-- <table class="mini">
   			<tr>
   				<ehr:pagination-mini action="memberFamily.personSearch" colspan="4" hidePageSize="true"/>
   			</tr>
   		</table> --%>
		</div>
	</fieldset>
	</div>	
	<table style="position:absolute;left:500px;top:150px;width:40px;border:0">
		<tr>
		  	<td>
		  		<%-- <input type="button" name="button2" id="memberAddBtn"  value="添加" style="width: 40px;"/> --%>
		  		
		  		<a class="layui-btn layui-btn-xs" name="button2" id="memberAddBtn" href="#" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe608;</i>添加</a>
		  		<!-- <button class="layui-btn layui-btn-sm" name="button2" id="memberAddBtn"><i class="layui-icon">&#xe608;</i>添加</button> -->
		  		<br/>
		  		<br/>
		   		<%-- <input type="button" name="button3" id="memberDeleBtn" value="删除" style="width: 40px;" />--%>
		   		<a class="layui-btn layui-btn-danger layui-btn-xs" href="#" name="button3" id="memberDeleBtn" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
			</td>
		 </tr>
	</table>
	<div class="postdiv" >
	<fieldset style="margin:8px 5px 5px 5px;float:right;width:353px;height:320px;overflow: auto" class="layui-elem-field">
		<legend>已加入成员</legend>
		<div class="repeattable">
		<table id="memberTables"  class="layui-table x-admin-sm-table-list-small">
	        <thead>
				<tr>
					<th style="text-align: center;" width="8%"><input type="checkbox" name="memberCheck" id="memberAllCheck"/></th>
					<th style="text-align: center;" width="25%">姓名</th>
					<th style="text-align: center;" width="25%">出生日期</th>
					<th style="text-align: center;" width="10%">性别</th>
					<th style="text-align: center;" width="25%">家庭角色</th>
				</tr>
	         </thead>
	         <tbody>	        
			   <c:forEach items="${memberList }" var="member" varStatus="status">
			   		 <tr>
			   		 	<td>
			   		 		<c:if test="${not empty member.id}">
	                           <input type="checkbox" chkRef="memberCheck" name="FamilyRecordDTO.memberList[${status.index}].id" value="${member.id}"/>
                               <input type="hidden" name="FamilyRecordDTO.memberList[${status.index}].idcard" value="${member.idcard}"/>
                               <input type="hidden" name="FamilyRecordDTO.memberList[${status.index}].selected" value="${member.id}"/>
		   		 			</c:if>
			   		 	</td>
			   		 	<td>
			   		 		${member.name }
			   		 		<input type="hidden" name="FamilyRecordDTO.memberList[${status.index}].name" value="${member.name}"/>
			   		 	</td>
			   		 	<td>
			   		 		<fmt:formatDate value="${member.birthday }" pattern="yyyy/MM/dd"/> 
			   		 		<input type="hidden" name="FamilyRecordDTO.memberList[${status.index}].birthday" value="<fmt:formatDate value="${member.birthday }" pattern="yyyy/MM/dd"/>"/>
			   		 	</td>
			   		 	<td>&nbsp;
			   		 		  <ehr:dic dicmeta="GBT226112003" code="${member.gender }"/>
			   		 		<input type="hidden" name="FamilyRecordDTO.memberList[${status.index}].gender" value="${member.gender}"/>
			   		 	</td>
			   		 	<td>
			   		 		<c:if test="${not empty member.id}">
								<%-- <select style="width:80px;" name="FamilyRecordDTO.memberList[${status.index}].familyMemTypeCode">
									<option value="02" ${member.familyMemTypeCode eq '02' ? 'selected' : ''}>户主</option>
									<option value="10" ${member.familyMemTypeCode eq '10' ? 'selected' : ''}>配偶</option>
									<option value="20" ${member.familyMemTypeCode eq '20' ? 'selected' : ''}>子</option>
									<option value="30" ${member.familyMemTypeCode eq '30' ? 'selected' : ''}>女</option>
									<option value="40" ${member.familyMemTypeCode eq '40' ? 'selected' : ''}>孙子\孙女</option>
								</select> --%>
								<ehr:dic-list width="80px;" value="${member.familyMemTypeCode }" name="FamilyRecordDTO.memberList[${status.index}].familyMemTypeCode" dicmeta="GBT4761"/>
							</c:if>
			   		 	</td>
			   		 </tr>
			 </c:forEach>
			 </tbody>
			</table>
			</div>
		</fieldset>
	</div>
</form>