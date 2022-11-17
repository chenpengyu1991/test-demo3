<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
	
<div class="section" id="createNewOrg" style="padding-top: 5px;">
    <form id="createNewOrgFrom" action="#">
        <table class=formtable style="width: 95%;">
            <tr>
		        <c:forEach var="role"  items="${roles}" varStatus="status">
		            <td style="width:20%">
		                <input type="checkbox" name="rolecheck" class="chk_selectone" value="${role.id}"/>&nbsp;
		                <a id="v${role.id}">${role.name}</a>
		            </td>
		        </c:forEach>
	        </tr>
	    </table>
        <input id="createOrgUserId" type="hidden" name="userCode" value="${userCode}"/>
        <input id="createOrgorgId" type="hidden" name="orgId" value="${orgId}"/>
	</form>
	<p align="center"> 
        <input type="button" id="#" name="#" value="确认" onclick = "updateUser.setRole();" class="btnopr" style="font-size:14px"/>            
	</p>
</div>
