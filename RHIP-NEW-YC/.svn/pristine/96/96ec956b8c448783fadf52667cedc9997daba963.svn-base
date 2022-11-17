<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/js/views/integration/front_machine.js" type="text/javascript"></script>

<div class="searchbox">
    <form id="front_machine_from">
      <table id="frontMachineSearch">
      	<colgroup>
              <col style="min-width:70px; width: 9%;"/>
              <col style="min-width:160px; width: 27%;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="coltext">
              <label>医院</label>
            </td>
            <td class="colinput">
                <ehr:org-type-list id="organization" type="centre" name="organCode"  width="200px;"/>
            </td>
              <td>
                  <input id="star_statistics_search_btn" class="search_btn" type="button" value="查询" onclick="front_machine.search('front_machine_from','1','front_machine_content')" />
              </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span onclick="front_machine.toggle(this,'frontMachineSearch','frontMachineDiv','contentfixed126')" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>
  <div id="front_machine_content" style="height: 400px;" ></div>