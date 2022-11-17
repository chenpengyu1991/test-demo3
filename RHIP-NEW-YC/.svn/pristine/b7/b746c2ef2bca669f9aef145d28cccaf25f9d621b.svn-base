<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>

  <div class="searchbox searchSection x-admin-sm contentItem">
    <form id="record_statistics_from" action="">
      <table id="recordSearch">
      	<colgroup>
            <%--  <col style="min-width:70px; width: 9%;"/>
              <col style="min-width:400px; width: 50%;"/>
              <col style="min-width:70px; width: 9%;"/>
              <col style="min-width:150px; width: 25%;"/>    --%>
              <col style="min-width:60px; width: 10%;"/>
              <col style="min-width:160px; width: 25%;"/>
              <col style="min-width:80px; width: 10%;"/>
              <col style="min-width:160px; width: 25%;"/>
              <col style="min-width:60px; width: 10%;"/>
              <col style="min-width:160px; width: 25%;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="coltext">
                <label>时间范围</label>
            </td>
            <td class="colinput">
              <%-- <tags:dateInput id="recordStartDate" style="width: 35%;" name="startDate">
              </tags:dateInput>
              ~
              <tags:dateInput id="recordEndDate" style="width:35%;" name="endDate">
              </tags:dateInput> --%>
              <input type="text" class="layui-input x-admin-sm-date"  name="startDate" id="recordStartDate" style="padding-left: 0px;width: 35%;" /> ~
              <input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="recordEndDate" style="padding-left: 0px;width: 35%;" />
            </td>
              <td class="coltext">
                  年龄范围
              </td>
              <td class="colinput">
              <span>
                <tags:numberInput  id="recordStartAge" style="width:35%;" name="startAge" cssClass="x-layui-input" reg="">
                </tags:numberInput>
                ~
                <tags:numberInput  id="recordEndAge" style="width:35%;" name="endAge" cssClass="x-layui-input">
                </tags:numberInput>
              </span>
              </td>

              <td class="coltext">
                  <label>性别</label>
              </td>
              <td class="colinput">
                  <label>
                          <ehr:dic-list dicmeta="GBT226112003" name="gender" value="${PersonalBasicInfoDTO.personInfo.gender}" width="80%" cssClass="x-layui-input"/>
                  </label>
              </td>
          </tr>
          <tr>
            <ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN}">
              <td class="coltext">
                  <label>管理机构</label>
              </td>
              <td class="colinput">
                  <ehr:org-type-list name="orgCode" type="centre" cssClass="x-layui-input" width="80%;"/>
              </td>
            </ehr:authorize>
             <td class="coltext">
                 显示方式
             </td>
             <td class="colinput">
             <div class="layui-form">
				<div class="layui-form-item">
					<div class="layui-input-block" style="margin-left: 0px;margin-bottom: -5px;">
	                 <label><input type="radio" value="0"  name="record_chart_toggle"  /> 表格</label>
	                 <label><input type="radio" value="1"  checked="checked" name="record_chart_toggle" />图表</label>
                 </div>
                 </div>
               </div>
             </td>
             <ehr:authorize ifNotGranted="${ADMIN},${JKJKDN}">
                 <td></td> <td></td>
             </ehr:authorize>
            <td></td>
            <td>
                 <%-- <input id="record_statistics_search_btn" class="search_btn" type="button" value="查询"/> --%>
                 <button class="layui-btn layui-btn-sm" id="record_statistics_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
             </td>
         </tr>
      </tbody>
    </table>
    <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span onclick="statisticsMain.toggle(this,'recordSearch')" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
  </form>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#recordStartDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#recordEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });

    </script>
  