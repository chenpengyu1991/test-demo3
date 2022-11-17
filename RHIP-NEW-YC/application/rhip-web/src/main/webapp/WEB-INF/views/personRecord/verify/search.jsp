<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/personRecord/verify/search.js" type="text/javascript"></script>

<div>
	<ul id=tags>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">档案核实</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">档案修改</a>
	    </li>
	</ul>
	
	<div id="tagContent" style="width: 99.5%">
	   	<div id="tagContent0" class="selectTag">
			<div class="searchbox">
				<form method="post" id="form_search">
					<div class="searchbox" id="searchTable">
						<table>
							<colgroup>
								<col style="width: 7%;" />
								<col style="width: 10%;" />
								<col style="width: 8%;" />
								<col style="width: 14%;" />
								<col style="width: 6%;" />
								<col style="width: 10%;" />
								<col style="width: 40%;" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<td class="coltext"><div align="right">姓名</div></td>
									<td class="colinput"><input type="text" name="name"
										id="name" style="width: 80px;"/></td>
									<td class="coltext"><div align="right">身份证</div></td>
									<td class="colinput"><input type="text" name="idcard"
										id="idcard" style="width: 100px;"/></td>
							      	<td class="coltext"><div align="right">状态</div></td>
							      	<td class="colinput">
							      		<select name="filingFlag" style="width: 60px;" id="filingFlagSelect">
							      			<option value="1">已建档</option>
							      			<option value="2" selected="selected">待审核</option>
							      		</select>
							      	</td>
									<td class="colinput">
										<div id="addressDiv">
										地址&nbsp;<ehr:dic-town-village villageId="village_address" 
											townId="town_address" villageName="pastreet"
											townName="patownShip" width="100px;" reg="{'required':false}"/>
										</div>	
							      	</td>
							      	<td nowrap="nowrap" align="right">
							      		<input type="button" value="查询" id="personInfoQuery" class="search_btn" style="width: 80px;"/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<table>
						<tr>
							<td colspan="6" class="colbottom"><span
								onclick="verifySearch.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="personInfoList"></div>
	   	</div>
	   	
	 	<div id="tagContent1" style="display:none" >
			<div class="searchbox">
				<form method="post" id="form_update">
					<div class="searchbox" id="updateTable">
						<table>
							<colgroup>
								<col style="width: 7%;" />
								<col style="width: 10%;" />
								<col style="width: 8%;" />
								<col style="width: 14%;" />
								<col style="width: 6%;" />
								<col style="width: 10%;" />
								<col style="width: 5%;" />
							</colgroup>
							<tbody>
								<tr>
									<td class="coltext"><div align="right">姓名</div></td>
									<td class="colinput"><input type="text" name="name"
										id="name" style="width: 100px;"/></td>
									<td class="coltext"><div align="right">身份证</div></td>
									<td class="colinput"><input type="text" name="idcard"
										id="idcard" style="width: 130px;"/></td>
							      	<td class="coltext"><div align="right">状态</div></td>
							      	<td class="colinput">
							      		<select name="filingFlag" style="width: 70px;">
							      			<option value="">请选择</option>
							      			<option value="1">已核实</option>
							      			<option value="0" selected="selected">待审核</option>
							      		</select>
							      	</td>
							      	<td nowrap="nowrap" align="right">
							      		<input type="button" value="查询" id="personInfoTempQuery" class="search_btn" style="width: 80px;"/>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<table>
						<tr>
							<td colspan="6" class="colbottom"><span
								onclick="verifySearch.toggle(this,'updateTable')" class="ico-bottom">&nbsp;</span></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="personInfoTempList"></div>
		</div>
	</div>
</div>
