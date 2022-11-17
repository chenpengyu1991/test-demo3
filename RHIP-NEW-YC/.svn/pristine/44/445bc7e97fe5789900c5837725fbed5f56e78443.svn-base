<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/life/deathMedicineCertificate/search.js" type="text/javascript"></script>
<div class="section" id="search">
	<div class="toolbar">
       <div class="x-nav">
	      <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">居民健康管理</a>
	        <a>
	          <cite>死亡管理</cite></a>
	      </span>
    </div>
    </div>
	<div class="searchBox searchSection x-admin-sm">
		<input type="hidden" id="searchType" value="${searchType}">
		<form id="searchForm">
            <table id="searchTableLife">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput">
                        <input type="text" name="name" class="x-layui-input" />
                    </td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput">
                        <input type="text" name="idCard" class="x-layui-input" />
                    </td>

                </tr>
                 <tr>
               		 <td class="coltext">是否结案</td>
                     <td class="colinput">
                        <input name="cancelStatus" value="" type="radio"> 全部
                        <input name="cancelStatus" value="1" type="radio"> 是
                        <input name="cancelStatus" value="0" type="radio"> 否
                    </td>
                     <td class="coltext">死亡日期</td>
                     <td class="colinput">
                         <%-- <tag:dateInput name="deathDate" onlypast="true"/> --%>
                         <input type="text" class="layui-input x-admin-sm-date"  name="deathDate" id="deathDateId" style="padding-left: 0px;" />
                     </td>
                </tr>
                <tr>
                    <td class="righttd" colspan="5">
                        <!-- <input type="button" id="btnSearch" value="查询" class="search_btn" /> -->
                        <button class="layui-btn layui-btn-sm"  id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTableLife')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection x-admin-sm">
		 <%--<a href="javascript:void(0)" id="lifeEventImport" onclick="lifeEventSearch.importExcel()"><b class="import">导入</b></a>--%>
        <!-- <a href="javascript:void(0)" id="lifeEventCancel" onclick="deathMedicineCertificateSearch.cancel()"><b class="quxiao">一键结案</b></a> -->
         <a href="javascript:void(0)" id="lifeEventCancel" onclick="deathMedicineCertificateSearch.cancel()"><button class="layui-btn layui-btn-sm"><i class="layui-icon"> &#x1006;</i>一键结案</button></a>
        <!-- <a href="javascript:void(0)" id="lifeEventCancel" onclick="deathMedicineCertificateSearch.add()"><b class="xinz">新增</b></a> -->
        <a href="javascript:void(0)" id="lifeEventAdd" onclick="deathMedicineCertificateSearch.add()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
        
    </div>
	<div id="resultDiv">
		<jsp:include page="list.jsp"></jsp:include>
	</div>
</div>
<div id="detailDivId" >

</div>

<script type="text/javascript">
 layui.use('laydate', function(){
     var laydate = layui.laydate;
     
     laydate.render({
       elem: '#deathDateId' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });

     
   });

 </script>