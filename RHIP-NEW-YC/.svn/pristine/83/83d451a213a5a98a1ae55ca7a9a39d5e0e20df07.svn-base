<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/bmi/detail.js" type="text/javascript"></script>

<div class="bmi_content">
	<div class="test_info">
		<strong>请输入您的身高、体重</strong>
		<form id="bmiFormId">
			<dl class="list1">
				<dt>身高：</dt>
				<dd><tag:numberInput id="heightId" name="height"  placeholder="例：165" maxlength="3"/> 厘米</dd>
				<dt>体重：</dt>
				<dd><tag:numberInput id="weightId" name="weight"  placeholder="例：50" maxlength="3"/> 公斤</dd>
			</dl>
		</form>
	</div>
	<div class="test_result" style="display:none">
		<strong>测试结果</strong>
		<ul class="list1">
			<li>您的BMI指数为：<span id="bmiResultTdId" class="result_span"></span></li>
			<li>您的体重状况为：<span id="weigthStatusTdId" class="result_span"></span></li>
		</ul>
	</div>
	<div class="test_btn" style="clear:both;">
		<input type="button" id="seeResultBtnId" name="save" class="test_1"/>
      	<input type="button" id="resetingBtnId" name="save" class="test_2"/>
	</div>
	<div class="test_end" style="display:none">
		<div class="result_info">
			<table class="table" cellspacing="1" cellpadding="0" border="0">
		        <tr>
		          <th class="td1">体重状况</th>
		          <th class="td2">中国参考标准</th>
		          <th class="td3">相关疾病发病的危险性</th>
		        </tr>
		        <tr>
		          <td class="blue">偏瘦</td>
		          <td>BMI指数<18.5</td>
		          <td>增加（相关疾病：贫血、血尿等）</td>
		        </tr>
		        <tr>
		          <td  class="green">正常</td>
		          <td>18.5≤BMI指数≤23.9</td>
		          <td>平均水平</td>
		        </tr>
		        <tr>
		          <td class="yellow">偏胖</td>
		          <td>23.9<BMI指数≤26.9</td>
		          <td>增加（相关疾病：高血压、心脏病等</td>
		        </tr>
		        <tr>
		          <td class="red">肥胖</td>
		          <td>26.9<BMI指数≤29.9</td>
		          <td>中度增加（相关疾病：高血压、心脏病等</td>
		        </tr>
		        <tr>
		          <td class="black">重度肥胖</td>
		          <td>29.9<BMI指数</td>
		          <td>严重增加（相关疾病：高血压、心脏病等）</td>
		        </tr>
	      </table>
	      <div class="bmitext">
			<p> 减肥的两大原则是减少摄入和增加消耗，最好能够双管齐下，一方面调整饮食，一方面加强运动。另外，多补充复合维生素对减肥也极有帮助，而且事实上不管是采取哪一种减肥方式，维生素的补充都是不能忽略的。 </p>
		 </div>
		</div>
	</div>
</div>
<div class="test_bottom"></div>