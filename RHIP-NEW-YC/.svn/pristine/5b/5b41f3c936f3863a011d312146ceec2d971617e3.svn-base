<%@tag import="com.founder.rhip.ehr.common.ReserveStauts"%>
<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="stauts" type="java.lang.String" required="true"%>
<%
	String descp = "";
	if(stauts != null){
		ReserveStauts reserveStauts = ReserveStauts.getByStauts(stauts);
		if( reserveStauts != null){
			descp = reserveStauts.getDescription();
		}
	}
%>
<%=descp%>