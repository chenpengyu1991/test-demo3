<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%--与卫生局页面共用一个js--%>
<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/popDistribution.js" type="text/javascript"></script>

<div  class="section" >
	<ehr:authorize ifAnyGranted="01,04">
	    <div class="toolbar">
	       <span id="modifyCommunityIdSpan">
	            <!-- <a href="javascript:void(0)" id="modifyCommunityId" ><b class="xiug">修改</b></a> -->
	            <a href="javascript:void(0)" id="modifyCommunityId"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe642;</i>修改</button></a>
	        </span>
	        <span id="cancelCommunityIdSpan">
	            <!-- <a href="javascript:void(0)" id="cancelCommunityId" ><b class="quxiao">取消</b></a> -->
	            <a href="javascript:void(0)" id="cancelCommunityId"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>取消</button></a>
	            <!-- <a href="javascript:void(0)" id="saveCommunityId" ><b class="baocun">保存</b></a> -->
	            <a href="javascript:void(0)" id="saveCommunityId" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	        </span>
	    </div>
    </ehr:authorize>
    <div class="searchbox searchSection x-admin-sm"  >
        <form method="post" id="communityInfoSearchForm">
            <input type="hidden" name="PopulaceDTO.gbCode" value="${organization.gbCode}" >
            <input type="hidden" name="PopulaceDTO.organCode" value="${organization.organCode}" >
            <table id="health-card-search-table" >
	
                <tbody>
                <tr>
                	<td>年度：
                	<%-- <tag:dateInput name="PopulaceDTO.countYear" id="countYear"  onlypast="true" style="width:120px;"  date="${currentYear}"  pattern="yyyy" reg='{"required":"true"}'/> --%>
                	<input type="text" class="layui-input x-admin-sm-date"  name="PopulaceDTO.countYear" id="countYear" reg='{"required":"true"}' value="<fmt:formatDate value="${currentYear}" pattern="yyyy"/>" style="padding-left: 0px;width: 120px;" />
                	</td>
                        <td>
                        <%-- <input type="button" value="查询" class="search_btn" id="popSearch"/> --%>
                        <button class="layui-btn layui-btn-sm" id="popSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <form   id="communityInfoForm">
        <div id="pop_dis_result_div"  class="repeattable">
            <jsp:include page="result.jsp"/>
        </div>
    </form>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
        	type:"year",
          	elem: '#countYear', 
       	    max:0
        });

    });
    </script>