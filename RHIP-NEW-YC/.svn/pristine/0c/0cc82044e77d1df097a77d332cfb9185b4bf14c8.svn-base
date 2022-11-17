<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	require(['views/integration/log'],function(integrationLog){
		integrationLog.load();
	});
</script>
<div class="section" id="mainSearchDiv">
	  <div class="searchbox">
	    <form id="integration_log_from">
	      <table id="integrationLogSearch">
	      	<colgroup>
	  			<col style="min-width:50px; width: 10%;"/>
				<col style="min-width:200px; width: 20%;"/>
				<col style="min-width:50px; width: 10%;"/>
				<col style="min-width:200px; width: 20%;"/>
	            <col style="min-width:50px; width: 10%;"/>
				<col style="min-width:160px; width: 20%;"/>
	            <col style="min-width:60px; width: 10%;"/>
	      	</colgroup>
	        <tbody>
			<tr>
				<td class="coltext">
					<label>医院名称</label>
				</td>
				<td>
					<ehr:org-type-list id="organizationLog" name="organCode" width="200px;"/>
				</td>
				<td class="coltext">
					<label>编码名称</label>
				</td>
				<td>
					<ehr:dic-list name="numberCode" dicmeta="JC00001"/>
				</td>
				<td class="col-text" style="text-align: right;">集成日期</td>
				<td class="col-input"><tag:dateInput name="recordDateBegin" id="recordDateBeginLog" onlypast="true"
													 style="width: 36%;"/>~<tag:dateInput name="recordDateEnd"
																						  id="recordDateEndLog"
																						  onlypast="true"
																						  style="width: 36%;"/>
				</td>
			</tr>
			<tr>
                <td class="coltext">
                    <label>异常分类</label>
                </td>
                <td>
                    <select name="abnormalType">
                        <option value="">请选择</option>
                        <option value="1">核心数据不完整</option>
                        <option value="2">值域代码不符合标志</option>
                        <option value="3">值域范围不符合逻辑</option>
                    </select>
                </td>
                <td colspan="4"></td>
                <td>
                    <input id="integration_log_search_btn" class="search_btn" type="button" value="查询"/>
                </td>
            </tr>
	        </tbody>
	      </table>
	       <table>
	       <tr>
	           <td colspan="6" class="colbottom">
	                 <span id="integrationLogTop" class="ico-bottom">&nbsp;</span>
	           </td>
	       </tr>
		</table>
	    </form>
	  </div>
  		<div id="listDivIntegrationLog"></div>
	</div>
