<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<script type="text/javascript">
	
</script>

<c:if test="${not empty roles}">
<div class="section">
	<div class="titlebar">
           <label class="required">角色设定</label>
       </div>
	
	<table class=formtable>
        <tr>
			<c:forEach var="role"  items="${roles}" varStatus="status">
			 	<td style="width:20%">
					<input type="checkbox" name="role" class="chk_selectone" value="${role.id}"/>&nbsp;${role.description}
				</td>
			</c:forEach>
        </tr>
	</table>
</div>
</c:if>