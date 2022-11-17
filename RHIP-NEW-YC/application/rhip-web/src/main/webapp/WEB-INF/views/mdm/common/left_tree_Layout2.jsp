<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

	<TABLE class="container">
		<TBODY>
			<TR>
				<TD id="SideBar">
					<tiles:insertAttribute name="left"/>
				</TD>
				<TD id="MainBody">
					<tiles:insertAttribute name="content"/>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
