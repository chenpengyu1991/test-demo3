<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<fieldset class="layui-elem-field">
			<legend>自我评价</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label for="smoking">吸烟量与以前相比</label></th>
					<td>
					<ehr:dic-radio dicmeta="DMD00028" name="smoking"  uninclude="7,8,9,10" value="${strtum.smoking}"></ehr:dic-radio>
					</td>
				</tr>
				<tr>
					<th><label for="drinking">饮酒量与以前相比</label></th>
					<td>
					<ehr:dic-radio dicmeta="DMD00028" name="drinking"  uninclude="6,8,9,10" value="${strtum.drinking}"></ehr:dic-radio>
					</td>
				</tr>
				<tr>
					<th><label for="meat">肉类较以前摄入</label></th>
					<td>
					<ehr:dic-radio dicmeta="DMD00028" name="meat"  uninclude="6,7,9,10" value="${strtum.meat}"></ehr:dic-radio>
					</td>
				</tr>
				<tr>
					<th><label for="produce">蔬菜水果较以前摄入</label></th>
					<td>
					<ehr:dic-radio dicmeta="DMD00028" name="produce"  uninclude="6,7,8,10" value="${strtum.produce}"></ehr:dic-radio>
					</td>
				</tr>
				<tr>
					<th><label for="physicalActivity">体力活动较以前</label></th>
				<td>
					<ehr:dic-radio dicmeta="DMD00028" name="physicalActivity"  uninclude="7,8,9,6" value="${strtum.physicalActivity}"></ehr:dic-radio>
					</td>
				</tr>
				<tr>
					<th><label for="ecgTimes">测心电图次数</label></th>
					<td>
					<ehr:dic-radio name="ecgTimes" dicmeta="DMD00029" value="${strtum.ecgTimes}" ></ehr:dic-radio>
					</td>
				</tr>
				<tr>
					<th><label for="bloodTimes">测血生化指标次数</label></th>
					
					<td>
					<ehr:dic-radio name="bloodTimes" dicmeta="DMD00030" value="${strtum.bloodTimes}" ></ehr:dic-radio>
					</td>

				</tr>
				<tr>
					<th><label for="drugPayments">月平均药费支出（元）</label></th>
					
					<td>
					<ehr:dic-radio name="drugPayments" dicmeta="DMD00031" value="${strtum.drugPayments}" ></ehr:dic-radio>
					</td>
					
				</tr>
			</table>
		</fieldset>
