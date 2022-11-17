<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="toolbar" >
	<%--<a href="javascript:populationIndexChart.back()" id="cancelContact"><b class="fanhui">返回</b></a>--%>
	<%-- <a onclick="javascript:baseLayoutLoad.loadMenuContent('${pageContext.request.contextPath}/ihm/ehr/population');"><b class="fanhui">返回</b></a> --%>
	<a href="javascript:void(0)" id = "back"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<jsp:include page="../../searchByOrg.jsp"/>

<script type="text/javascript">
	!(function () {
		$(function () {
			$("#resultDiv").on("click", ".pop", function () {
				var $link = $(this);
				getDataAndOpen($link);
			});
			
			$("#back").on("click", function () {
				back();
			});
		});

		function getDataAndOpen($link) {
			debugger;
			var $tds = $link.parentsUntil("tr").siblings();
			var man = [];
			var woman = [];
			$tds.each(function () {
				var $td = $(this);

				if ($td.data("isData")) {
					var level = $td.data("totalLevel");
					man[level] = $td.data("totalMan");
					woman[level] = $td.data("totalWoman");
				}

			});
			//openDialog();
			layer.open({
  			  type: 1,
  			  id:'populationChartDialog',
  			  area: ['900px', '580px'],
  			  title:"人口统计",
  			  content: '<div id="person-pop-chart-con" style="width: 800px;height: 450px;padding-left:60px;"></div>'
  		  });
			openChart(man, woman);
			
		}

		function openDialog() {
			$('#person-pop-chart-con').dialog({
				width: 840,
				height: 480,
				modal: true,
				resizable: false,
				title: "人口统计"
			});
		}

		function openChart(maleData, femaleData) {
			var max = 0;
			var i = 0;
			for (; i < maleData.length; i++) {
				var value = maleData[i] || 0;
				if (value > max) {
					max = value;
				}
				maleData[i] = 0 - value;
			}

			for (i = 0; i < femaleData.length; i++) {
				var value = femaleData[i] || 0;
				if (value > max) {
					max = value;
				}
			}

			var categories = ['0-5', '5-10', '10-15', '15-20',
				'20-25', '25-30', '30-35', '35-40', '40-45',
				'45-50', '50-55', '55-60', '60-65', '65-70',
				'70-75', '75-80', '80-85', '85-90', '90+'];
			var chart = new Highcharts.Chart(
					{
						chart: {
							renderTo: "person-pop-chart-con",
							type: 'bar',
							marginLeft: 40,
							marginRight: 40,
							width: 780,
							height: 430
						}, credits: {
						enabled: false
					}, exporting: {
						enabled: false
					},
						title: {
							text: '人口统计'
						},
						subtitle: {
							text: ''
						},
						xAxis: [
							{
								categories: categories,
								reversed: false,
								labels: {
									step: 1
								}
							},
							{ // mirror axis on right side
								opposite: true,
								reversed: false,
								categories: categories,
								linkedTo: 0,
								labels: {
									step: 1
								}
							}
						],
						yAxis: {
							title: {
								text: null
							}, labels: {
								formatter: function () {
									return (Math.abs(this.value) );
								}
							}, max: max,
							min: 0 - max

						},

						plotOptions: {
							series: {
								stacking: 'normal'
							}
						},

						tooltip: {
							formatter: function () {
								return  this.series.name + '<br/>年龄:' + this.point.category + '<br/>' +
										'人口: ' + Highcharts.numberFormat(Math.abs(this.point.y), 0);
							}
						},

						series: [
							{
								name: '男',
								data: maleData
							},
							{
								name: '女',
								data: femaleData
							}
						]
					});
		};
		
		function back() {
			$("#populationChart").show();
			$("#populationDetail").hide();
			location.reload();
		}
		
		return {
			back : back
		}
	})();

</script>