<%@tag import="java.text.NumberFormat"%>
<%@ attribute name="value" type="java.lang.Object" required="true"%>
<%@ attribute name="align" type="java.lang.String" required="false"%>
<%@ attribute name="type" type="java.lang.String" required="false"%>
<%@ attribute name="userGroup" type="java.lang.Boolean" required="false"%>
<%@ attribute name="defaultValue" type="java.lang.Object" required="false"%>
<%@ attribute name="fractionDigits" type="java.lang.Integer" required="false"%>
<%@ attribute name="styleIf" type="java.lang.Boolean" required="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	if (null == value||"".equals(value)) {
		value=defaultValue;
	}
	if (null == value||"".equals(value)) {
		return;
	} else {
		if (String.class.isAssignableFrom(value.getClass())) {
			if (value.toString().trim().length() < 1) {
				return;
			}
			if (((String) value).indexOf('.') != -1) {
				value = Double.valueOf((String) value);
			} else {
				value = Long.valueOf((String) value);
			}
		}
	}

	NumberFormat formatter = null;
	if ("currency".equalsIgnoreCase(type)) {
		formatter = NumberFormat.getCurrencyInstance();
	} else if ("percent".equalsIgnoreCase(type)) {
		formatter = NumberFormat.getPercentInstance();
	} else {
		formatter = NumberFormat.getNumberInstance();
	}
	if (null != fractionDigits) {
		formatter.setMaximumFractionDigits(fractionDigits);
		formatter.setMinimumFractionDigits(fractionDigits);
	}
	
	if (null == userGroup) {
		userGroup = true;
	}
	formatter.setGroupingUsed(userGroup);
	String formatedValue = formatter.format(value);
	if (null == align || align.trim().length() < 1) {
		align = "right";
	}
%>
<span title=" <%=formatedValue%>" <c:if test="${null == styleIf}">style="width: 100%; display: inline-block; text-align: <%=align%>;"</c:if>> <%=formatedValue%>
</span>