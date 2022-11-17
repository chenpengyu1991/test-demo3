<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div class="searchbox">
    <form id="drug_category_from">
      <table id="drugcategorySearch">
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
                 <ehr:org-type-list id="organizationDC" type="centre" name="organCode"  width="200px;"/>
            </td>
            <td class="col-text" style="text-align: right;">时间段</td>
			<td class="col-input"><tag:dateInput name="createBeginTime" id="createBeginTimeDC"  onlypast="true" style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTimeDC"  onlypast="true" style="width: 36%;"/></td>
              <td>
                  <input id="drug_category_search_btn" class="search_btn" type="button" value="查询" />
              </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="drugcategorySearchToggle" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>