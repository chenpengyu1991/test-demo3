<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <div class="searchbox">
    <form id="medicalGoods_search_form">
      <table id="medicalGoodsSearch" >
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
              <label>医院名称</label>
            </td>
            <td>
                 <ehr:org-type-list id="organCode" type="hospital,centre" name="organCode"  width="200px;"/>
            </td>
            <td class="coltext">
              <label>项目类型</label>
            </td>
            <td class="colinput">
                 <ehr:dic-list type="true" name="projectNamesHP" id="projectNamesHP3" dicmeta="JC00001" value="da01,da03"
                 code="da01,da02,da03,da04,da05,da06,da07,da08,da09,da0,da10,da11,da12,da13,da14,da15,da16,da17,da18,da19,da20,da21,da22,da23,da24,da25" width="195px" />
            </td>
           <td class="coltext">
              <label>时间段</label>
            </td>
            <td class="colinput">
                 <tag:dateInput name="createBeginTime" id="createBeginTimeMG"  onlypast="true" style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTimeMG"  onlypast="true" style="width: 36%;"/>
            </td>
             <td>
                 <input id="medical_goods_search_btn" class="search_btn" type="button" value="查询" />
             </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="medical_goods_bottom"  class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>