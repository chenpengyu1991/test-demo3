<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div>
<div class="postcontent">
    <div class="postdiv">
		<table class="posttable">
			<colgroup>
				<col style="min-width: 80px; width: 15%;" />
				<col style="min-width: 350px; width: 35%;" />
				<col style="min-width: 80px; width: 15%;" />
				<col style="min-width: 350px; width: 35%;" />					
			</colgroup>
			<tr>
				<th>常住类型</th>
				<td><ehr:dic-radio dicmeta="" name=""/></td>
				<th>？？？</th>
				<td>
					<ehr:dic-town-village villageName="" townName=""/>
				</td>
			</tr>
			<tr>
				<th>病例登记号</th>
				<td><input type="text" name=""/></td>
				<th>年</th>
				<td><input type="text" name=""/></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input type="text" name=""/></td>
				<th>职业</th>
				<td><ehr:dic-list name="" dicmeta=""/></td>
			</tr>
			<tr>
				<th>详细地址</th>
				<td colspan="3"><input type="text" name=""/></td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3"><input type="text" name=""/></td>
			</tr>
			<tr>
				<th>工作单位</th>
				<td colspan="3"><input type="text" name=""/></td>
			</tr>
			<tr>
				<th>电话</th>
				<td><input type="text" name=""/></td>
				<th>X线号</th>
				<td><input type="text" name=""/></td>
			</tr>
		</table>
	</div>
	 <div class="postdiv">
		<table class="posttable">
			<colgroup>
				<col style="min-width: 80px; width: 15%;" />
				<col style="min-width: 350px; width: 35%;" />
				<col style="min-width: 80px; width: 15%;" />
				<col style="min-width: 350px; width: 35%;" />					
			</colgroup>
			<tr>
				<th>1、性别</th>
				<td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name=""/> </td>
				<th>2、年龄</th>
				<td><input type="text" name=""/>(周岁)</td>
			</tr>
			<tr>
				<th>3、病人来源</th>
				<td><ehr:dic-radio dicmeta="" name=""/><input type="text" name=""/></td>
				<th>4、症状</th>
				<td>
					<ehr:dic-list name="" dicmeta=""/>
					<ehr:dic-radio dicmeta="" name=""/> <input type="text" name=""/>
				</td>
			</tr>
			<tr>
				<th>5、结核史</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="" code="1,2"/></td>
				<th>6、诊断</th>
				<td>
					<ehr:dic-list name="" dicmeta=""/>
					<ehr:dic-list dicmeta="" name=""/>
					<ehr:dic-list dicmeta="" name=""/><input type="text" name=""/>
				</td>
			</tr>
			<tr>
				<th>7、初治</th>
				<td><ehr:dic-radio dicmeta="" name=""/> <input type="text" name=""/></td>
				<th>8、复发</th>
				<td><ehr:dic-radio dicmeta="" name=""/> <input type="text" name=""/></td>
			</tr>
			<tr>
				<th>9、复治病人最近：&nbsp;&nbsp;1.实施</th>
				<td><ehr:dic-radio dicmeta="" name=""/></td>
				<th>治疗情况：&nbsp;&nbsp;2.治疗单位</th>
				<td><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>10、痰检&nbsp;&nbsp;1.登记时查痰</th>
				<td colspan="3"><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>治疗：&nbsp;&nbsp;2. 治疗满两个月</th>
				<td colspan="3"><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>3. 治疗满三个月</th>
				<td colspan="3"><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>11、肺结核空洞</th>
				<td><ehr:dic-radio dicmeta="" name=""/></td>
				<th>12、合并症</th>
				<td><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>13、化疗 &nbsp;&nbsp;1，初治涂阳</th>
				<td colspan="3"><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>方案 &nbsp;&nbsp;2，初治涂阴</th>
				<td colspan="3"><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>3，初治涂阳</th>
				<td colspan="3"><ehr:dic-radio dicmeta="" name=""/></td>
			</tr>
			<tr>
				<th>4，其它</th>
				<td colspan="3"><input type="text" name=""/></td>
			</tr>
			<tr>
				<th>14、药费来源</th>
				<td><ehr:dic-radio dicmeta="" name=""/><span><input type="text" name=""/>%</span> </td>
				<th>15、管理方式</th>
				<td><ehr:dic-list name="" dicmeta="PH00002" uninclude="3"/> </td>
			</tr>
			<tr>
				<th>16、转归</th>
				<td colspan="3"><ehr:dic-radio name="" dicmeta=""/> </td>
			</tr>
			<tr>
				<th>17、登记日期</th>
				<td><tag:dateInput nullToToday="true" name="" pattern="yyyy/MM/dd" onlypast="true"></tag:dateInput>	</td>
				<th>18、确诊日期</th>
				<td><tag:dateInput nullToToday="true" name="" pattern="yyyy/MM/dd" onlypast="true"></tag:dateInput>	</td>
			</tr>
			<tr>
				<th>19、始治日期</th>
				<td><tag:dateInput nullToToday="true" name="" pattern="yyyy/MM/dd" onlypast="true"></tag:dateInput>	</td>
				<th>20、停止治疗日期</th>
				<td><tag:dateInput nullToToday="true" name="" pattern="yyyy/MM/dd" onlypast="true"></tag:dateInput>	</td>
			</tr>
		</table>
	</div>
	<div class="postdiv">
		<table class="posttable">
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 23%;" />
				<col style=" width: 10%;" />
				<col style=" width: 23%;" />
				<col style="width: 10%;" />
				<col/>					
			</colgroup>
			<tr>
				<th>填卡单位</th>
				<td></td>
				<th>填卡人</th>
				<td></td>
				<th>填卡日期</th>
				<td></td>
			</tr>
		</table>
	</div>
</div>
</div>