<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="name" type="java.lang.String" required="true"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="nameValue" type="java.lang.String" required="false"%>
<%@ attribute name="codeValue" type="java.lang.String" required="false"%>
<%@ attribute name="reg" type="java.lang.String" required="false"%>
<%@ attribute name="style" type="java.lang.String" required="false"%>
<%--//TODO 外层div和id--%>
<div style="position: relative;">
	<input id="${id}" type="text" name="${name}_name" value="${nameValue}" <%if (null != reg) {%> reg="<%=reg.replaceAll("\"", "'")%>"    <%}%> <%if (null != style) {%> style="<%=style%>" <%}%>  />
	<a class="hide" id="${id}ShowTreeBtn" href="javascript:void(0)"  >▼</a> 
	<input type="hidden" name="${name}" ref="${id}" value="${codeValue}" />
	<div id="${id}TreeContent" class="treeContent hide" style="position: absolute; border: 1px #888 solid;height:300px;overflow:auto; background-color: white;">
		<ul id="${id}Tree" class="ztree" style="margin-top: 0; "></ul>
	</div>
</div>