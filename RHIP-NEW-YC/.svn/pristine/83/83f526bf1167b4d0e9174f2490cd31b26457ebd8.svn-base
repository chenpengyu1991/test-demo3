<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/sanitaryBureau/popDistribution.js" type="text/javascript"></script>

<div  class="section" >
    <div class="toolbar">
       <span id="modifyCommunityIdSpan">
            <%-- <a href="javascript:void(0)" id="modifyCommunityId" ><b class="xiug">修改</b></a> --%>
            <a href="javascript:void(0)" id="modifyCommunityId" title="修改"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe642;</i>修改</button></a>
        </span>
        <span id="cancelCommunityIdSpan">
            <%-- <a href="javascript:void(0)" id="cancelCommunityId" ><b class="quxiao">取消</b></a> --%>
            <a href="javascript:void(0)" id="cancelCommunityId" title="取消"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>取消</button></a>
            <%-- <a href="javascript:void(0)" id="saveCommunityId" ><b class="baocun">保存</b></a> --%>
            <a href="javascript:void(0)" id="saveCommunityId"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        </span>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="communityInfoSearchForm" >
            <table id="health-card-search-table" style="width: 98%;">
	
                <tbody>
                <tr>
                	<td style="width: 50px;text-align:right; padding-right: 0px;">年度：</td>
                	<td style="width: 125px;text-align: left;padding-left: 0px;"><input class="layui-input" name="countYear" id="countYear" value="<fmt:formatDate value='${currentYear}' pattern='yyyy'/>" style="height: 25px;width: 120px;"></td>
                    <td>机构选择：
                        <ehr:authorize ifAnyGranted="01">
                            <ehr:dic-town-centre-station townName="PopulaceDTO.gbCode"
                                                         centreName="PopulaceDTO.organCode" width="200px" />
                        </ehr:authorize>
                        <ehr:authorize ifNotGranted="01">
                            <ehr:dic-town-centre-station townName="PopulaceDTO.gbCode" includeTownCodes="${userGbCode}"
                                                         centreName="PopulaceDTO.organCode" width="200px" townValue="${userGbCode}"/>
                        </ehr:authorize>
                        <!-- <input type="button" value="查询" class="search_btn" id="popSearch"> -->
                       </td>
                    <td style="width: 100px;"><button class="layui-btn layui-btn-sm"  id="popSearch"><i class="layui-icon">&#xe615;</i>查询</button> </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <form   id="communityInfoForm">
        <div id="pop_dis_result_div"  class="repeattable" style="height: 350px;overflow: auto">
                <jsp:include page="result.jsp"/>
        </div>
    </form>
    <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          type:"year",
          elem: '#countYear', //指定元素
          max:0,
          value: new Date()
        });

      });

    </script>
</div>
