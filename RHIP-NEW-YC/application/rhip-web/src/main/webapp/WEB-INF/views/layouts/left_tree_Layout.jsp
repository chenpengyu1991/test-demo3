<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

	<TABLE id="Container">
		<TBODY>
			<TR>
				<TD id="SideBar">
					<tiles:insertAttribute name="left"/>
				</TD>
				<TD id="MainBody">
					<div id="Main1">
						<tiles:insertAttribute name="content" />
					</div>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
