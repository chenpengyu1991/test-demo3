<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<fieldset>
			<legend>自我评价</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label for="smoking">吸烟量与以前相比</label></th>
					<td>
					<ehr:dic dicmeta="DMD00028" code="${strtum.smoking}"></ehr:dic>
					</td>
				</tr>
				<tr>
					<th><label for="drinking">饮酒量与以前相比</label></th>
					<td>
					<ehr:dic dicmeta="DMD00028" code="${strtum.drinking}"></ehr:dic>
					</td>
				</tr>
				<tr>
					<th><label for="meat">肉类较以前摄入</label></th>
					<td>
					<ehr:dic dicmeta="DMD00028" code="${strtum.meat}"></ehr:dic>
					</td>
				</tr>
				<tr>
					<th><label for="produce">蔬菜水果较以前摄入</label></th>
					<td>
					<ehr:dic dicmeta="DMD00028" code="${strtum.produce}"></ehr:dic>
					</td>
				</tr>
				<tr>
					<th><label for="physicalActivity">体力活动较以前</label></th>
				<td>
					<ehr:dic dicmeta="DMD00028" code="${strtum.physicalActivity}"></ehr:dic>
					</td>
				</tr>
				<tr>
					<th><label for="ecgTimes">测心电图次数</label></th>
					<td>
					<ehr:dic dicmeta="DMD00029" code="${strtum.ecgTimes}" ></ehr:dic>
					</td>
				</tr>
				<tr>
					<th><label for="bloodTimes">测血生化指标次数</label></th>
					
					<td>
					<ehr:dic dicmeta="DMD00030" code="${strtum.bloodTimes}" ></ehr:dic>
					</td>

				</tr>
				<tr>
					<th><label for="drugPayments">月平均药费支出（元）</label></th>
					
					<td>
					<ehr:dic dicmeta="DMD00031" code="${strtum.drugPayments}" ></ehr:dic>
					</td>
					
				</tr>
			</table>
		</fieldset>
