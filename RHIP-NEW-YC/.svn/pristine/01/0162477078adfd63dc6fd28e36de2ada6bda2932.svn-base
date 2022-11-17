<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/wonmenHealth/search.js" type="text/javascript"></script>
 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        /* laydate.render({
          elem: '#inputExamYear' 
       	   ,type: 'year'
       	   ,max:0
        }); */

        laydate.render({
          elem: '#updateDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
        laydate.render({
          elem: '#updateDateEnd'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        });
      
        laydate.render({
            elem: '#createDate'
             ,format: 'yyyy/MM/dd'
          	   ,max:0
          });
          
          laydate.render({
            elem: '#createDateEnd'
          	  ,format: 'yyyy/MM/dd'
          		  ,max:0
          });
      });

    </script>
<div class="section" id="child-exam-list-box">
	 <div class="toolbar">
	 	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">孕产妇健康管理</a>
		        <a>
		          <cite>孕产妇健康基本信息</cite></a>
		      </span>
		</div>
	 
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                 <colgroup>
                     <col style="width: 15%; min-width: 70px;"/>
                     <col style="width: 20%; min-width: 70px;"/>
                     <col style="width: 15%; min-width: 70px;"/>
                     <col style="width: 20%; min-width: 70px;"/>
                     <col style="width: 10%; min-width: 70px;"/>
                     <col style="width: 20%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" style="width: 100%" class="x-layui-input">
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idCard" style="width: 100%" class="x-layui-input">
                    </td>
                    <td class="col-text">更新日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date" name="updateDate" id="updateDate" style="padding-left: 0px;width: 38%;" /> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="updateDateEnd" id="updateDateEnd" style="padding-left: 0px;width: 38%;" />
                    </td>
                </tr>
                <tr>
                    <td class="col-text">创建日期</td>
                    <td class="col-input">
                    	<input type="text" class="layui-input x-admin-sm-date" name="createDate" id="createDate" style="padding-left: 0px;width: 38%;" /> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="createDateEnd" id="createDateEnd" style="padding-left: 0px;width: 38%;" />
                        
                        <%-- <tag:dateInput name="createDate" id="createDate" style="width:45%;"/>
                        ~
                        <tag:dateInput name="createDateEnd" id="createDate" style="width:45%;"/> --%>
                    </td>
                    <td class="col-text">性别</td>
                    <td class="col-input">
                        <ehr:dic-list name="gender" dicmeta="GBT226112003" cssClass="x-layui-input"></ehr:dic-list>
                    </td>
                    <td class="col-text">是否指导</td>
                    <td class="colinput">
                        <select name="healthGuideStatus" class="x-layui-input">
                            <option value="">请选择</option>
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </td>
                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="col-text">管理机构</td>
                    <td class="col-input" colspan="5">
                        <ehr:authorize ifAnyGranted="03">
                            <ehr:dic-org-list width="180px" name="orgCode" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,0205">
                            <ehr:dic-org-list width="180px" name="orgCode" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,0105,11,62,63">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"  townName="searchTown" width="180px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04,0405">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="orgCode" townName="searchTown" width="180px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                     <td colspan="5"></td>
                    <td style="text-align: left;">
                    <!-- <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon"></i>查询</button> -->
                     <!-- <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" /> -->
                     <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon"></i>查询</button>
                     <button class="layui-btn layui-btn-sm" id="gjBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
        <a href="javascript:void(0)" id="ehr-person-export-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe67d;</i>导出</button></a>
    </div>
    <div id="womenListDiv">
        <%--<jsp:include page="${listpath}"></jsp:include>--%>
    </div>
</div>
<div id="child-exam-input-box"></div>