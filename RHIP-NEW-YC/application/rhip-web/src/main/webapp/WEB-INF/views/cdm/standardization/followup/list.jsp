<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/followup/list.js" type="text/javascript"></script>
<div  class="section" id="list_view">
	<div class="toolbar">
          <a href="javascript:void(0)" id="followup-new-btn"><b class="xinz">新增</b></a>
    </div>   
		<div class="searchbox"  >
			<form method="post" id="form_search">
				<table>
				<colgroup>
				<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext" >姓名：</td>
							<td class="colinput"><input type="text" name="personName" id="personName" /></td>
							<td class="coltext" >身份证号：</td>
							<td class="colinput"><tag:idcardInput name="idCard"  style="ime-mode:Disabled;"></tag:idcardInput> </td>
							<td class="coltext"  >患病类型：</td>
							<td class="colinput">
								<input type="checkbox" name="disType" value="1"/>高血压
								<input type="checkbox" name="disType" value="2"/>糖尿病
								<input type="checkbox" name="disType" value="3"/>脑卒中
								<input type="checkbox" name="disType" value="4"/>冠心病
								<input type="checkbox" name="disType" value="5"/>肿瘤
							</td>
						</tr>
						<tr>
							<td class="coltext">年龄段：</td>
							<td class="colinput">
								<input type="text" class="textClass" name="startAge" id="startAge" style="width:80px"
									onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
									onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode:Disabled"
									ondragenter="return false" maxlength="3"/> ~ 
								<input type="text" class="textClass" name="endAge" id="endAge" style="width:80px"
									onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
									onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode:Disabled"
									ondragenter="return false" maxlength="3"/> 岁
							</td>
							
							<td class="coltext">性别：</td>
							<td class="colinput">
								<ehr:dic-list dicmeta="GBT226112003" name="gender"/>
							</td>
							
							<td class="coltext" ></td>
							<td class="colinput">
							</td>
							
								<td class="coltext" align="left">
										<input type="button" id="reportCard_search_btn" value="查询" onclick="" class="search_btn"/>
							</td>	
						</tr>
					</tbody>
				</table>
				  <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span  class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			
			</form>
		</div>
	
	<div id="list_datagrid" 	class="repeattable" >
	</div>

</div>

<div id="input_view" style="display: none">
</div>



