<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<input id="ehrbrowser_person_id_input" type="hidden" value="${personId}"/>
<input id="ehrbrowser_person_idcard_input" type="hidden" value="${personIdcard}"/>
<jsp:include page="content.jsp"></jsp:include>