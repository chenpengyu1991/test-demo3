<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                  <input id="front_machine_search_btn" class="search_btn" type="button" value="查询" />
              </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="front_machine_search_bottom"  class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>