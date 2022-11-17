<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<div class="repeattable" style="width:100%;overflow:auto;">
    <table id="echStatisticsTable" class="layui-table x-admin-sm-table-list-middle" style="overflow: auto">
        <colgroup>
           <c:if test="${genrecode=='1' || (genrecode=='2' && patownShip_flag==0)}"><col style="min-width:200px;width: 12%;"/></c:if>
           <c:if test="${genrecode=='2' && patownShip_flag==1}">
           	 <col style="min-width:100px;width: 6%;"/>
           	 <col style="min-width:100px;width: 6%;"/>
           </c:if>
            <col style="min-width:100px;width: 6%;"/>
            <col style="min-width:100px;width: 6%;"/>
            <col style="min-width:100px;width: 7%;"/>
            <col style="min-width:100px;width: 6%;"/>
            <col style="min-width:100px;width: 6%;"/>
            <col style="min-width:100px;width: 7%;"/>
            <col style="min-width:100px;width: 6%;"/>
            <c:if test="${genrecode=='1'}">
	            <col style="min-width:100px;width: 6%;"/>
	            <col style="min-width:100px;width: 7%;"/>
	            <col style="min-width:100px;width: 6%;"/>
	            <col style="min-width:100px;width: 7%;"/>
	            <col style="min-width:100px;width: 6%;"/>
	            <col style="min-width:100px;width: 7%;"/>
	       </c:if>
        </colgroup>
        <thead>
        <tr>
            <c:if test="${genrecode=='1'}"><th>机构名称</th></c:if>
            <c:if test="${genrecode=='2'}">
            	<th>所在镇</th>
            	<c:if test="${patownShip_flag==1}"><th>所在居委会</th></c:if>
            </c:if>
            
            <c:if test="${genrecode=='1'}"><th>老年人人数</th></c:if>
            <th>建档数</th>
            <c:if test="${genrecode=='1'}"><th>建档率(%)<br>建档数/老年人人数</th></c:if>
            <th>体检人数</th>
            <th>体检人次数</th>
            <c:if test="${genrecode=='1'}"><th>体检率(%)<br>体检人数/老年人人数</th></c:if>
            <th>体检健康指导人数</th>
            <th>健康评估人数</th>
            <c:if test="${genrecode=='1'}"><th>评估率(%)<br>健康评估人数/老年人人数</th></c:if>
            <th>健康管理人数</th>
            <c:if test="${genrecode=='1'}"><th>管理率(%)<br>健康管理人数/老年人人数</th></c:if>
            <th>中医辨识人数</th>
            <c:if test="${genrecode=='1'}"><th>辨识率(%)<br>中医辨识人数/老年人人数</th></c:if>
        </tr>
        </thead>
        <tbody>
        	<c:forEach var="result" items="${results}">
            	<tr>
            		<c:if test="${genrecode=='1'}">
						<td><ehr:tip><ehr:org code="${result.org_code}"/></ehr:tip></td>
						<%-- 老年人人数 --%>
	                    <td class="righttd">${result.older_num}</td>
                    </c:if>
                    <c:if test="${genrecode=='2'}">
                    	<c:if test="${patownShip_flag==1}"><td class="righttd"><ehr:dic code="${result.parent_code}" dicmeta="FS990001"/></td></c:if>
                    	<td class="righttd"><ehr:dic code="${result.item_code}" dicmeta="FS990001"/></td>
                    </c:if>
                    <%-- 建档数 --%>
                    <td class="righttd">${result.fill_count}</td>
                    <%-- 建档率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${result.older_num==0?0:(result.fill_count*1000/result.older_num*0.1)}" pattern="#,##0.0"/>%</td></c:if>
                    <%-- 体检人数 --%>
                    <td class="righttd">${result.exam_count}</td>
                    <%-- 体检人次数 --%>
                    <td class="righttd">${result.exam_sum}</td>
                    <%-- 体检率 --%>
                   <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${result.older_num==0?0:(result.exam_count*1000/result.older_num*0.1)}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 体检健康指导人数 --%>
                    <td class="righttd">${result.guide_sum}</td>
                    <%-- 健康评估人数 --%>
                    <td class="righttd">${result.estimate_sum}</td>
                    <%-- 评估率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${result.older_num==0?0:(result.estimate_sum*1000/result.older_num*0.1)}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 健康管理人数 --%>
                    <td class="righttd">${result.manage_sum}</td>
                    <%-- 管理率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${result.older_num==0?0:(result.manage_sum*1000/result.older_num*0.1)}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 中医辨识人数--%>
                   	<td class="righttd">${result.tcm_count}</td>
                    <%-- 辨识率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${result.older_num==0?0:(result.tcm_count*1000/result.older_num*0.1)}" pattern="#,##0.0"/>% </td></c:if>
            </tr>
			</c:forEach>
			<c:if test="${total!=null}">
               <tr>
                    <c:if test="${genrecode=='1' || (genrecode=='2' && patownShip_flag==0)}"><td><b>合计</b></td></c:if>
                    <c:if test="${genrecode=='2' && patownShip_flag==1}">
                    	<td colspan="2"><b>合计</b></td>
                    </c:if>
                  	<%-- 老年人人数 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd">${total.older_num}</td></c:if>
                    <%-- 建档数 --%>
                    <td class="righttd">${total.fill_count}</td>
                    <%-- 建档率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${total.older_num==0?0:(total.fill_count*100)/total.older_num}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 体检人数 --%>
                    <td class="righttd">${total.exam_count}</td>
                    <%-- 体检人次数 --%>
                    <td class="righttd">${total.exam_sum}</td>
                    <%-- 体检率 --%>
                   <c:if test="${genrecode=='1'}"> <td class="righttd"><fmt:formatNumber value="${total.older_num==0?0:(total.exam_count*100)/total.older_num}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 体检健康指导人数 --%>
                    <td class="righttd">${total.guide_sum}</td>
                    <%-- 健康评估人数 --%>
                    <td class="righttd">${total.estimate_sum}</td>
                    <%-- 评估率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${total.older_num==0?0:(total.estimate_sum*100)/total.older_num}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 健康管理人数 --%>
                    <td class="righttd">${total.manage_sum}</td>
                    <%-- 管理率 --%>
                    <c:if test="${genrecode=='1'}"><td class="righttd"><fmt:formatNumber value="${total.older_num==0?0:(total.manage_sum*100)/total.older_num}" pattern="#,##0.0"/>% </td></c:if>
                    <%-- 中医辨识人数--%>
                    <td class="righttd">${total.tcm_count}</td>
                    <%-- 辨识率 --%>
                   <c:if test="${genrecode=='1'}"> <td class="righttd"><fmt:formatNumber value="${total.older_num==0?0:(total.tcm_count*100)/total.older_num}" pattern="#,##0.0"/>% </td></c:if>
               </tr>
              </c:if>
        </tbody>
    </table>
</div>