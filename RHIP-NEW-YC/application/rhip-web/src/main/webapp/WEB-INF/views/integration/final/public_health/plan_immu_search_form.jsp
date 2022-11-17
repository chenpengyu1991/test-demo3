<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div class="searchbox">
    <form id="plan_immu_from">
      <table id="planimmuSearch">
      	<colgroup>
              <col style="width:50px;"/>
              <col style="width:160px"/>
              <col style="width:70px;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="col-text" style="text-align: right;">时间段</td>
			<td class="col-input"><tag:dateInput name="createBeginTime" id="createBeginTimePI" style="width: 150px;" onlypast="true"/>~<tag:dateInput name="createEndTime" id="createEndTimePI" style="width: 150px;"  onlypast="true"/></td>
             <td>
                 <input id="splan_immu_search_btn" class="search_btn" type="button" value="查询" />
             </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="planimmuToggle" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>