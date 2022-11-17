<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
	$(function() {
		$("#projectNamesHP1").multiselect({
			 header:false,
			 noneSelectedText: '请选择项目类型',
			 selectedList: 2//最多可选中几个
		});
		$("select[id='organization']").append('<option title="常熟市社区卫生服务站" value="320000000">常熟市社区卫生服务站</option>');
	});
	
//-->
</script>
  <div class="searchbox">
    <form id="bloodStation_search_form">
      <table id="bloodStationSearch" >
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
                    <option value="FS-05">血站</option>
                </select>
            </td>
            <td class="coltext">
              <label>项目类型</label>
            </td>
            <td class="colinput">
                 <ehr:dic-list type="true" name="projectNamesHP" id="projectNamesHP1" dicmeta="JC00001" value="bs01,bs02"
                 code="bs01,bs02,bs03,bs04" width="195px" />
            </td>
           <td class="coltext">
              <label>时间段</label>
            </td>
            <td class="colinput">
                 <tag:dateInput name="createBeginTime" id="createBeginTimeBS"  onlypast="true" style="width: 36%;"/>~<tag:dateInput name="createEndTime" id="createEndTimeBS"  onlypast="true" style="width: 36%;"/>
            </td>
             <td>
                 <input id="hospital_medical_search_btn2" class="search_btn" type="button" value="查询"/>
             </td>
          </tr>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span id="bloodStationSearchToggle" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>