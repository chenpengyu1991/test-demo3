<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div class="searchbox">
    <form id="physical_exam_search_form">
      <table id="physicalexamSearch">
      	<colgroup>
  			<col style="min-width:50px; width: 8%;"/>
			<col style="min-width:200px; width: 25%;"/>
            <col style="min-width:50px; width: 8%;"/>
			<col style="min-width:160px; width: 23%;"/>
            <col style="min-width:60px; width: 10%;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="coltext">
              <label>医院名称</label>
            </td>
            <td>
                 <ehr:org-type-list id="organizationPE" type="hospital,centre" name="organCode"  width="200px;"/>
            </td>
            <td class="col-text" style="text-align: right;">
            	<label>时间段</label>
            </td>
			<td class="colinput">
				<tag:dateInput name="createBeginTime" id="createBeginTimePE"  onlypast="true" style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTimePE"  onlypast="true" style="width: 36%;"/>
			</td>
              <td>
                  <input id="physical_exam_search_btn" class="search_btn" type="button" value="查询"/>
              </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="physicalExamToggle" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>