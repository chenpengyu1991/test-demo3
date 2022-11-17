<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/assessment.js" type="text/javascript"></script>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="toolbar" align="right">
	<a id="saveValues" ><b class="baocun">保存</b></a>
</div>
<div class="postcontent">
	<i class="popno">生活事件心理应激测试评定量表</i>
	<div style="margin-bottom: 5px;">
		<form id="basicInfo_From">
			<table>
				<col style="width: 50%" />
				<col style="width: 30%"/>
				<tr >
					<td>&nbsp;&nbsp;&nbsp;<input id="agreement" type="checkbox" value="0"/>  签署知情同意书</td>
					<td>签署日期：<tag:dateInput style="width:178px;" name="assessDate"  id="assessDate" onlypast="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div class=repeattable>
		<form id="assessment_form">
			<table style="float:left;width:50%;">
				<colgroup>
					<col style="width: 4%" />
					<col style="width: 35%"/>
					<col style="width: 5%" />
				</colgroup>
				<tr >
					<th></th>
					<th><h3 align="center">变化事件</h3></th>
					<th><h3 align="center">LCU</h3></th>
				</tr>
				<tr>
					<td ><input type="checkbox" value="1" name="lcu" data-value="100"></td>
					<td>1.配偶死亡</td>
					<td>100</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="2" name="lcu" data-value="73"></td>
					<td>2.离婚</td>
					<td>73</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="3" name="lcu" data-value="65"></td>
					<td>3.夫妇分居</td>
					<td>65</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="4" name="lcu" data-value="63"></td>
					<td>4.坐牢</td>
					<td>63</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="5" name="lcu" data-value="63"></td>
					<td>5.亲密家庭成员丧亡</td>
					<td>63</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="6" name="lcu" data-value="53"></td>
					<td>6.个人受伤或患病	</td>
					<td>53</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="7" name="lcu" data-value="50"></td>
					<td>7.结婚</td>
					<td>50</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="8" name="lcu" data-value="47"></td>
					<td>8.被解雇	</td>
					<td>47</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="9" name="lcu" data-value="45"></td>
					<td>9.复婚</td>
					<td>45</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="10" name="lcu" data-value="45"></td>
					<td>10.退休</td>
					<td>45</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="11" name="lcu" data-value="44"></td>
					<td>11.家庭成员健康变化</td>
					<td>44</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="12" name="lcu" data-value="40"></td>
					<td>12.妊娠</td>
					<td>40</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="13" name="lcu" data-value="39"></td>
					<td>13.性功能障碍</td>
					<td>39</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="14" name="lcu" data-value="39"></td>
					<td>14.增加新的家庭成员(如出生、过继、老人迁入）</td>
					<td>39</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="15" name="lcu" data-value="39"></td>
					<td>15.业务上的再调整</td>
					<td>39</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="16" name="lcu" data-value="38"></td>
					<td>16.经济状态的变化</td>
					<td>38</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="17" name="lcu" data-value="17"></td>
					<td>17.好友丧亡</td>
					<td>37</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="18" name="lcu" data-value="36"></td>
					<td>18.改行</td>
					<td>36</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="19" name="lcu" data-value="35"></td>
					<td>19.夫妻多次吵架</td>
					<td>35</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="20" name="lcu" data-value="31"></td>
					<td>20.中等负债</td>
					<td>31</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="21" name="lcu" data-value="30"></td>
					<td>21.取消赎回抵押品</td>
					<td>30</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="22" name="lcu" data-value="29"></td>
					<td>22.所担负工作责任方面的变化</td>
					<td>29</td>
				</tr>
			</table>
			<table style="float:right;width:50%;">
				<colgroup>
					<col style="width: 4%" />
					<col style="width: 35%"/>
					<col style="width: 5%" />
				</colgroup>
				<tr>
					<th></th>
					<th><h3 align="center">变化事件</h3></th>
					<th><h3 align="center">LCU</h3></th>
				</tr>
				<tr>
					<td ><input type="checkbox" value="23" name="lcu" data-value="29"></td>
					<td>23.子女离家</td>
					<td>29</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="24" name="lcu" data-value="29"></td>
					<td>24.姻亲纠纷</td>
					<td>29</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="25" name="lcu" data-value="28"></td>
					<td>25.个人取得显著成就</td>
					<td>28</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="26" name="lcu" data-value="26"></td>
					<td>26.配偶参加或停止工作</td>
					<td>26</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="27" name="lcu" data-value="26"></td>
					<td>27.入学或毕业</td>
					<td>26</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="28" name="lcu" data-value="25"></td>
					<td>28.生活条件变化</td>
					<td>25</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="29" name="lcu" data-value="24"></td>
					<td>29.个人习惯的改变(如衣着、习俗交际等)</td>
					<td>24</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="30" name="lcu" data-value="23"></td>
					<td>30.与上级矛盾</td>
					<td>23</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="31" name="lcu" data-value="20"></td>
					<td>31.工作时间或条件的变化</td>
					<td>20</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="32" name="lcu" data-value="20"></td>
					<td>32.迁居</td>
					<td>20</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="33" name="lcu" data-value="20"></td>
					<td>33.转学</td>
					<td>20</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="34" name="lcu" data-value="19"></td>
					<td>34.消遣娱乐的变化</td>
					<td>19</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="35" name="lcu" data-value="19"></td>
					<td>35.宗教活动的变化(远多于或少于正常)</td>
					<td>19</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="36" name="lcu" data-value="18"></td>
					<td>36.社会活动的变化</td>
					<td>18</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="37" name="lcu" data-value="17"></td>
					<td>37.少量负债</td>
					<td>17</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="38" name="lcu" data-value="16"></td>
					<td>38.睡眠习惯变异</td>
					<td>16</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="39" name="lcu" data-value="15"></td>
					<td>39.生活在一起的家庭人数变化</td>
					<td>15</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="40" name="lcu" data-value="15"></td>
					<td>40.饮食习惯变异</td>
					<td>15</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="41" name="lcu" data-value="13"></td>
					<td>41.休假</td>
					<td>13</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="42" name="lcu" data-value="12"></td>
					<td>42.春节</td>
					<td>12</td>
				</tr>
				<tr>
					<td ><input type="checkbox" value="43" name="lcu" data-value="11"></td>
					<td>43.微小的违法行为(如违章穿马路)</td>
					<td>11</td>
				</tr>
				<tr style="text-align: left: ;">
					<td colspan="3">
						总计得分：<input style="width: 60px;margin-top: 3px" type="text" readonly="readonly" id="total">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
