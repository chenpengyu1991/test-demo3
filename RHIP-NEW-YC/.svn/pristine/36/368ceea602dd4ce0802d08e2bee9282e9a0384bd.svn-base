<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>
<script src="${pageContext.request.contextPath}/js/views/serviceInfo/init.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/medicineOperation/search.js" type="text/javascript"></script>

<div class="navRight">
  <div class="contentlist">
    <div class="location">
      当前位置：<a id="title103" class="space" data-code="103">信息查询</a>&gt;&gt;<label>国家基本药物目录查询</label>
    </div>
    	<div class="medicineSearch radius6">
            <form id="medicineSearchForm" method="post" onkeydown="if(event.keyCode==13){return false;}">
            	<div class="select_box">
					<div class="select_showbox" style="cursor: pointer;">搜索全部</div>
					<ul class="select_option" style="display: none;">
						<li val="">搜索全部</li>
						<c:forEach items="${categoryOne}" var="categoryOne">
	                  		<li val="${categoryOne}">${categoryOne}</li>
	                  	</c:forEach>
					</ul>
				</div>
				<input type="hidden" id="categoryNameOne" name="categoryNameOne"/>
				<input type="text" id="commonName" name="commonName" class="inp_srh" placeholder="请输入药物名称">
				<input id="searchMedicineId" class="btn_srh" type="button" value="查询">
            </form>
        </div>
    <div id="listMedicineDivId">
    </div>
  </div>
</div>