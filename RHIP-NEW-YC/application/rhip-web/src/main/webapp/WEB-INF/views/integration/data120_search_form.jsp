<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


  <div class="searchbox">
    <form id="data120_search_form">
      <table id="data120Search" >
      	<colgroup>
  			<col style="width: 10%;"/>
			<col style="width: 20%;"/>
            <col style="width: 10%;"/>
			<col style="width: 20%;"/>
			<col style="width: 10%;"/>
			<col style="width: 20%;"/>
            <col style="width: 10%;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="coltext">
              <label>名称</label>
            </td>
            <td>
                 <%--<ehr:org-type-list id="organCode" type="hospital,centre" name="organCode"  width="200px;"/>--%>
                <select name="organCode"  width="200px;">
                    <option value="">请选择</option>
                    <option value="FS-04">医疗急救中心</option>
                    <option value="320003328">市医疗急救站</option>
                </select>
            </td>
            <td class="coltext">
              <label>项目类型</label>
            </td>
            <td class="colinput">
                 <ehr:dic-list type="true" name="projectNamesHP" id="projectNamesHP2" dicmeta="JC00001" value="jj01,jj02"
                 code="jj01,jj02,jj03,jj04" width="195px" />
            </td>
           <td class="coltext">
              <label>时间段</label>
            </td>
            <td class="colinput">
                 <tag:dateInput name="createBeginTime" id="createBeginTimeJJ"  onlypast="true" style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTimeJJ"  onlypast="true" style="width: 36%;"/>
            </td>
             <td>
                 <input id="data120_search_btn" class="search_btn" type="button" value="查询" />
             </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="data120_search_bottom"  class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>