<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>

  <div class="searchbox searchSection x-admin-sm contentItem">
    <form id="star_statistics_from">
      <table id="reportSearch">
      	<colgroup>
             <%-- <col style="min-width:70px; width: 9%;"/>
              <col style="min-width:400px; width: 60%;"/>
              <col style="min-width:70px; width: 9%;"/>
              <col style="min-width:150px; width: 20%;"/>   --%>
              <col style="min-width:70px; width: 9%;"/>
              <col style="min-width:160px; width: 18%;"/>
              <col style="min-width:80px; width: 9%;"/>
              <col style="min-width:160px; width: 15%;"/>
              <col style="min-width:60px; width: 9%;"/>
              <col style="min-width:160px; width: 35%;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="coltext">
              <label>常住类型</label>
            </td>
            <td class="colinput">
            <div class="layui-form">
				<div class="layui-form-item">
					<div class="layui-input-block" style="margin-left: 0px;margin-bottom: -10px;">
		              <label>
		                  <input checked="checked" value="1" type="radio" name="houseType">
		                      全部
		              </label>
		              <label>
		                <input type="radio" value="2" name="houseType">
		               	 	户籍
		              </label>
		              <label>
		                <input type="radio" value="3" name="houseType">
		               	 	非户籍
		              </label>
					</div>
 				</div>
			</div>
            </td>
              <td class="coltext">时间范围</td>
              <td class="colinput" >
              <div class="layui-form">
				<div class="layui-form-item">
					<div class="layui-input-block" style="margin-left: 0px;margin-bottom: -5px;">
		              <span id="time_range_con">
		                <label>
		                    <input checked="checked" id="ranget_all_btn" value="1" type="radio" name="rangeType">
		                    全部
		                </label>
		                <label>
		                    <input id="ranget_month_btn" type="radio" value="2" name="rangeType">
		                    月
		                </label>
		                <label>
		                    <input id="ranget_season_btn" type="radio" value="3" name="rangeType">
		                    季度
		                </label>
		                <label>
		                    <input id="ranget_year_btn" type="radio" value="4" name="rangeType">
		                    年
		                </label>
		                <label>
		                    <input id="ranget_time_btn" type="radio" value="5" name="rangeType">
		                    时间段
		                </label>
		              </span>
					</div>
 				</div>
			</div>
              
              </td>
              <td colspan="2" style="text-align: left;padding-left: 0px;">
              	<span class=" time_range_targets hidediv" id="ranget_all_target">
              </span>
                  <select class="time_range_targets hidediv x-layui-input" name="ranget_month" id="ranget_month_target" style="width: 80px;">
                      <c:forEach var="item" items="${monthsmMap}">
                          <option value="${item.key}">
                                  ${item.value}月
                          </option>
                      </c:forEach>
                  </select>
                  <select class="time_range_targets hidediv x-layui-input" name="ranget_season" id="ranget_season_target" style="width: 80px;">
                      <c:forEach var="item" items="${seasonsMap}">
                          <option value="${item.key}">
                              第${item.value}季度
                          </option>
                      </c:forEach>

                  </select>
              <span class="time_range_targets hidediv" id="ranget_year_target">
                <select name="ranget_year" style="width: 80px;" class="x-layui-input">
                    <c:forEach var="item" items="${years}">
                        <option value="${item}">
                                ${item}年
                        </option>
                    </c:forEach>
                </select>
                <label>
                    <input checked="checked" value="0" type="radio" name="rangeYearType" >
                    统计年
                </label>
                <label>
                    <input type="radio" value="1" name="rangeYearType" >
                    自然年
                </label>
              </span>
              <span class="time_range_targets hidediv" id="ranget_time_target">
                <%-- <tags:dateInput style="width: 80px" name="startDate" id="starStartDate">
                </tags:dateInput>
                ~
                <tags:dateInput name="endDate" id="starEndDate" style="width: 80px">
                </tags:dateInput> --%>
                <input type="text" class="layui-input x-admin-sm-date"  name="startDate" id="starStartDate" style="padding-left: 0px;width: 80px;" /> ~
                 <input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="starEndDate" style="padding-left: 0px;width: 80px;" />
              </span>
              </td>
          </tr>
          <tr>
              <ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN}">
                  <td class="coltext">
                      管理机构
                  </td>
                  <td class="colinput">
                      <ehr:org-type-list name="orgCode" type="centre" cssClass="x-layui-input"/>
                  </td>
              </ehr:authorize>
              <td class="coltext">
                  显示方式
              </td>
              <td class="colinput" >
              <div class="layui-form" >
				<div class="layui-form-item" >
					<div class="layui-input-block" style="margin-left: 0px;margin-bottom: -5px;">
		              <label>
		                  <input type="radio" value="0" name="star_chart_toggle" />
		                 表格</label>
		                 <label>
		                  <input type="radio" value="1" checked="checked" name="star_chart_toggle" />
		                  图表</label>
					</div>
				</div>
			  </div>
              </td>
               <ehr:authorize ifNotGranted="${ADMIN},${JKJKDN}">
                 <td></td> <td></td>
             </ehr:authorize>
              <td style="float: right;">
                  <%-- <input id="star_statistics_search_btn" class="search_btn" type="button" value="查询" /> --%>
                  <button class="layui-btn layui-btn-sm" id="star_statistics_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
              </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span onclick="statisticsMain.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
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
          elem: '#starStartDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#starEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });

    </script>
  