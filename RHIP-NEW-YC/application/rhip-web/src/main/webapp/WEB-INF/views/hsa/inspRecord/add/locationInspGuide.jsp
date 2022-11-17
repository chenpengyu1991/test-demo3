<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<fieldset>
	<legend>巡查指导</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%; min-width: 55px;" />
			<col style="width: 35%; min-width: 200px;" />
			<col style="width: 15%; min-width: 100px;" />
			<col style="width: 40%; min-width: 300px;" />
		</colgroup>
		<tr>
			<th><label class="required"  for="inspGuideTypeName">巡查指导类型</label></th>
			<c:if test="${type!='2'}">
				<td><ehr:dic-list dicmeta="HSA00001" name="inspGuideRecord.inspGuideTypeCode" id="hsa-guide-type"  reg="{'required':true}" /></td>
			</c:if>
			<c:if test="${type=='2'}">
				<td><ehr:dic-list dicmeta="HSA00001" name="inspGuideRecord.inspGuideTypeCode" id="hsa-guide-type"  reg="{'required':true}" uninclude="1,3,4"/></td>
			</c:if>
		</tr>
		<tr>
			<th><label for="inspGuideTypeName">内容</label></th>
			<td colspan="3">
				<div>
					<table class="posttable hide" id="hsa-guide-food">
						<colgroup>
							<col style="width: 7%;" />
							<col style="width: 56%;" />
							<col style="width: 25%;" />
						</colgroup>
						<tr>
							<td><label >项目</label></td>
							<td align="center"><label >巡查内容</label></td>
							<td><label >巡查结果</label></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-cyxkz' ${inspRecord.inspGuideRecord.cyxkz !=5  && inspRecord.inspGuideRecord.cyxkz!=null? 'checked':''}  ></input></td>
							<td><label >餐饮服务许可证</label></td>
							<td class="${inspRecord.inspGuideRecord.cyxkz !=5 &&inspRecord.inspGuideRecord.cyxkz !=null ? '':'hide'}" id="td-cyxkz" ><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.cyxkz"   /></td>
						</tr>
						<tr>
							<td><input type="checkbox" data-target='td-bcb' ${inspRecord.inspGuideRecord.bcb !=5 &&inspRecord.inspGuideRecord.bcb !=null ? 'checked':''}></input></td>
							<td><label >亮证经营</label></td>
							<td class="${inspRecord.inspGuideRecord.bcb !=5 &&inspRecord.inspGuideRecord.bcb !=null ? '':'hide'}" id="td-bcb"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.bcb"   /></td>
						</tr>
						<tr>
							<td><input id="hsa-paramName-type1" type="checkbox"  data-target2='td-praNames' data-target3='td-praCount' ${inspRecord.inspGuideRecord.inspGuideTypeCode==1 && inspRecord.inspGuideRecord.praNames !=null? 'checked':''}></input></td>
							<td colspan="2" valign="top" style="vertical-align: top;">
								<c:choose >
								<c:when test="${inspRecord.inspGuideRecord.inspGuideTypeCode==1}">
								<label >从业人员</label> <input type="text" id="td-praNames" style="width: 120px"  name="inspGuideRecord.praNames"  ${inspRecord.inspGuideRecord.praNames!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-paramName-type1","maxlength":20}'></input>
										等 <input type="text" style="width: 50px"  name="inspGuideRecord.praCount"  id="td-praCount" ${inspRecord.inspGuideRecord.praCount!=null ? '':'readonly'}  reg='{"required":true,"dependOn":"hsa-paramName-type1","regex":"digits","maxlength":10}' ></input> 名无健康合格证明和卫生知识培训合格证明
								</c:when>
								<c:otherwise>
									<label >从业人员</label> <input type="text" id="td-praNames" style="width: 120px"  name="inspGuideRecord.praNames"  readonly="readonly" reg='{"required":true,"dependOn":"hsa-paramName-type1","maxlength":20}'></input>
										等 <input type="text" style="width: 50px"  name="inspGuideRecord.praCount"  id="td-praCount" readonly="readonly" reg='{"required":true,"dependOn":"hsa-paramName-type1","regex":"digits","maxlength":10}'></input> 名无健康合格证明和卫生知识培训合格证明
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-bfhin' ${inspRecord.inspGuideRecord.bfhin !=5 &&inspRecord.inspGuideRecord.bfhin !=null ? 'checked':''}></input></td>
							<td><label >建立食品安全管理组织网络、卫生制度等</label></td>
							<td class="${inspRecord.inspGuideRecord.bfhin !=5 &&inspRecord.inspGuideRecord.bfhin !=null ? '':'hide'}" id="td-bfhin"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.bfhin" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-fblfbr'  ${inspRecord.inspGuideRecord.fblfbr !=5 &&inspRecord.inspGuideRecord.fblfbr !=null ? 'checked':''}></input></td>
							<td><label>建立食品采购查验和索证索票制度，食品原辅料采购记录</label></td>
							<td class="${inspRecord.inspGuideRecord.fblfbr !=5 &&inspRecord.inspGuideRecord.fblfbr !=null ? '':'hide'}" id="td-fblfbr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}'  dicmeta="HSA00002" name="inspGuideRecord.fblfbr" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-osnu'  ${inspRecord.inspGuideRecord.osnu !=5 &&inspRecord.inspGuideRecord.osnu !=null ? 'checked':''}></input></td>
							<td><label >经营超过保质期、无标签、或使用非食品原料生产食品等</label></td>
							<td class="${inspRecord.inspGuideRecord.osnu !=5 &&inspRecord.inspGuideRecord.osnu !=null ? '':'hide'}" id="td-osnu"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.osnu" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ict'  ${inspRecord.inspGuideRecord.ict !=5 &&inspRecord.inspGuideRecord.ict !=null ? 'checked':''}></input></td>
							<td><label >内外环境整洁有序，无杂物堆放，垃圾桶密闭加盖</label></td>
							<td class="${inspRecord.inspGuideRecord.ict !=5 &&inspRecord.inspGuideRecord.ict !=null ? '':'hide'}" id="td-ict"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.ict" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-lpau' ${inspRecord.inspGuideRecord.lpau !=5 &&inspRecord.inspGuideRecord.lpau !=null ? 'checked':''}></input></td>
							<td><label >设凉菜间，有消毒水池、空调、紫外线灯</label></td>
							<td class="${inspRecord.inspGuideRecord.lpau !=5 &&inspRecord.inspGuideRecord.lpau !=null ? '':'hide'}" id="td-lpau"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.lpau" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-lhs' ${inspRecord.inspGuideRecord.lhs !=5 &&inspRecord.inspGuideRecord.lhs !=null ? 'checked':''}></input></td>
							<td><label >设食品原料仓库/区域，有货架</label></td>
							<td class="${inspRecord.inspGuideRecord.lhs !=5 &&inspRecord.inspGuideRecord.lhs !=null ? '':'hide'}" id="td-lhs"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.lhs" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-lcd' ${inspRecord.inspGuideRecord.lcd !=5 &&inspRecord.inspGuideRecord.lcd !=null ? 'checked':''}></input></td>
							<td><label >设餐具消毒间（场所），清洗、消毒设施（水池）</label></td>
							<td class="${inspRecord.inspGuideRecord.lcd !=5 &&inspRecord.inspGuideRecord.lcd !=null ? '':'hide'}" id="td-lcd"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.lcd" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-acf'  ${inspRecord.inspGuideRecord.acf !=5 &&inspRecord.inspGuideRecord.acf !=null ? 'checked':''}></input></td>
							<td><label >有生、熟冰箱，生、熟食品分开存放</label></td>
							<td class="${inspRecord.inspGuideRecord.acf !=5 &&inspRecord.inspGuideRecord.acf !=null ? '':'hide'}" id="td-acf"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.acf" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wfcf' ${inspRecord.inspGuideRecord.wfcf !=5 &&inspRecord.inspGuideRecord.wfcf !=null ? 'checked':''}></input></td>
							<td><label >配备除“四害”防治设施、开展除“四害”活动</label></td>
							<td class="${inspRecord.inspGuideRecord.wfcf !=5 &&inspRecord.inspGuideRecord.wfcf !=null ? '':'hide'}" id="td-wfcf"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.wfcf" /></td>
						</tr>
						<tr>
							<td><input id="hsa-other1" type="checkbox"  data-target4='td-other1' ${inspRecord.inspGuideRecord.inspGuideTypeCode==1 && inspRecord.inspGuideRecord.other !=null? 'checked':''}></input></td>
							<td><label >其他</label>
							<c:choose >
								<c:when test="${inspRecord.inspGuideRecord.inspGuideTypeCode==1}">
									<input  type="text" name="inspGuideRecord.other" id="td-other1" ${inspRecord.inspGuideRecord.other!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-other1","maxlength":500}'/>
								</c:when>
								<c:otherwise>
									<input  type="text" name="inspGuideRecord.other"  readonly="readonly" id="td-other1" reg='{"required":true,"dependOn":"hsa-other1","maxlength":500}'/>
								</c:otherwise>
							</c:choose>
							</td>
							<td></td>
						</tr>
					</table>
					<table class="posttable hide" id="hsa-guide-water">
						<colgroup>
							<col style="width: 8%;" />
							<col style="width: 56%;" />
							<col style="width: 25%;" />
						</colgroup>
						<tr>
							<td><label >项目</label></td>
							<td align="center"><label >巡查内容</label></td>
							<td><label >巡查结果</label></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hms' ${inspRecord.inspGuideRecord.hms !=5 &&inspRecord.inspGuideRecord.hms !=null ? 'checked':''}></input></td>
							<td><label >卫生管理制度</label></td>
							<td class="${inspRecord.inspGuideRecord.hms !=5 &&inspRecord.inspGuideRecord.hms !=null ? '':'hide'}" id="td-hms"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hms" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hmp' ${inspRecord.inspGuideRecord.hmp !=5 &&inspRecord.inspGuideRecord.hmp !=null ? 'checked':''}></input></td>
							<td><label >卫生管理人员</label></td>
							<td class="${inspRecord.inspGuideRecord.hmp !=5 &&inspRecord.inspGuideRecord.hmp !=null ? '':'hide'}" id="td-hmp"><ehr:dic-radio hideCodes="1,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hmp" /> </td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hcandhk' ${inspRecord.inspGuideRecord.hcandhk !=5 &&inspRecord.inspGuideRecord.hcandhk !=null ? 'checked':''}></input></td>
							<td><label >供、管水从业人员健康合格证明和卫生知识培训合格证明</label></td>
							<td class="${inspRecord.inspGuideRecord.hcandhk !=5 &&inspRecord.inspGuideRecord.hcandhk !=null ? '':'hide'}" id="td-hcandhk"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hcandhk" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wt' ${inspRecord.inspGuideRecord.wt !=5 &&inspRecord.inspGuideRecord.wt !=null ? 'checked':''}></input></td>
							<td><label >水质检测记录 / 检测报告（学校）</label></td>
							<td class="${inspRecord.inspGuideRecord.wt !=5 &&inspRecord.inspGuideRecord.wt !=null ? '':'hide'}" id="td-wt"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wt" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wdd' ${inspRecord.inspGuideRecord.wdd !=5 &&inspRecord.inspGuideRecord.wdd !=null ? 'checked':''}></input></td>
							<td><label >水质净化消毒设施正常运转/ 饮水机消毒（学校）</label></td>
							<td class="${inspRecord.inspGuideRecord.wdd !=5 &&inspRecord.inspGuideRecord.wdd !=null ? '':'hide'}" id="td-wdd"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wdd" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wpsw' ${inspRecord.inspGuideRecord.wpsw !=5 &&inspRecord.inspGuideRecord.wpsw !=null ? 'checked':''}></input></td>
							<td><label >水源卫生防护措施 / 贮存仓库（学校）</label></td>
							<td class="${inspRecord.inspGuideRecord.wpsw !=5 &&inspRecord.inspGuideRecord.wpsw !=null ? '':'hide'}" id="td-wpsw"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wpsw" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hygienicLicense' ${inspRecord.inspGuideRecord.inspGuideTypeCode ==2 && inspRecord.inspGuideRecord.hygienicLicenseWater !=5 &&inspRecord.inspGuideRecord.hygienicLicenseWater !=null ? 'checked':''}></input></td>
							<td><label >卫生许可证（仅限集中式供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.hygienicLicenseWater !=5 &&inspRecord.inspGuideRecord.hygienicLicenseWater !=null ? '':'hide'}" id="td-hygienicLicense"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hygienicLicenseWater" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ud' ${inspRecord.inspGuideRecord.ud !=5 &&inspRecord.inspGuideRecord.ud !=null ? 'checked':''}></input></td>
							<td><label >使用的涉水产品、消毒剂卫生许可批件</label></td>
							<td class="${inspRecord.inspGuideRecord.ud !=5 &&inspRecord.inspGuideRecord.ud !=null ? '':'hide'}" id="td-ud"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.ud" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-rcwt' ${inspRecord.inspGuideRecord.rcwt !=5 &&inspRecord.inspGuideRecord.rcwt !=null ? 'checked':''}></input></td>
							<td><label >定期清洗消毒和水质检验（仅限二次供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.rcwt !=5 &&inspRecord.inspGuideRecord.rcwt !=null ? '':'hide'}" id="td-rcwt"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.rcwt" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-sdw' ${inspRecord.inspGuideRecord.sdw !=5 &&inspRecord.inspGuideRecord.sdw !=null ? 'checked':''}></input></td>
							<td><label >二次供水水箱饮用水专用（仅限二次供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.sdw !=5 &&inspRecord.inspGuideRecord.sdw !=null ? '':'hide'}" id="td-sdw"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.sdw" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ssp' ${inspRecord.inspGuideRecord.ssp !=5 &&inspRecord.inspGuideRecord.ssp !=null ? 'checked':''}></input></td>
							<td><label >二次供水水箱周围污染（仅限二次供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.ssp !=5 &&inspRecord.inspGuideRecord.ssp !=null ? '':'hide'}" id="td-ssp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.ssp" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-dosp' data-target1='td-dostv' ${inspRecord.inspGuideRecord.dosp !=5 &&inspRecord.inspGuideRecord.dosp !=null ? 'checked':''}></input></td>
							<td><label >饮用水水质感官性状检测:</label></td>
						</tr>
						<tr>
							<td></td>
							<td><label >①异味: </label></td>
							<td class="${inspRecord.inspGuideRecord.dosp !=5 &&inspRecord.inspGuideRecord.dosp !=null ? '':'hide'}" id="td-dosp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.dosp" /></td>
						</tr>
						<tr>
							<td></td>
							<td><label >②肉眼可见物: </label></td>
							<td class="${inspRecord.inspGuideRecord.dostv !=5 &&inspRecord.inspGuideRecord.dostv !=null ? '':'hide'}" id="td-dostv"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.dostv" /></td>
						</tr>
						<tr>
							<td><input id="hsa-other2" type="checkbox"  data-target4='td-other2' ${inspRecord.inspGuideRecord.inspGuideTypeCode==2 && inspRecord.inspGuideRecord.otherWater !=null? 'checked':''}></input></td>
							<td><label >其他</label>
							<c:choose >
								<c:when test="${inspRecord.inspGuideRecord.inspGuideTypeCode==2}">
									<input  type="text" name="inspGuideRecord.otherWater"  id="td-other2" ${inspRecord.inspGuideRecord.otherWater!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-other2","maxlength":500}'/>
								</c:when>
								<c:otherwise>
									<input  type="text" name="inspGuideRecord.otherWater"   readonly="readonly" id="td-other2" reg='{"required":true,"dependOn":"hsa-other2","maxlength":500}'/>
								</c:otherwise>
							</c:choose>
							</td>
							<td></td>
						</tr>
					</table>
					<table class="posttable hide" id="hsa-guide-idp">
						<colgroup>
							<col style="width: 8%;" />
							<col style="width: 56%;" />
							<col style="width: 25%;" />
						</colgroup>
						<tr>
							<td><label >项目</label></td>
							<td align="center"><label >巡查内容</label></td>
							<td><label >巡查结果</label></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wbgz' ${inspRecord.inspGuideRecord.wbgz !=5 &&inspRecord.inspGuideRecord.wbgz !=null ? 'checked':''}></input></td>
							<td><label >卫生防病管理组织</label></td>
							<td class="${inspRecord.inspGuideRecord.wbgz !=5 &&inspRecord.inspGuideRecord.wbgz !=null ? '':'hide'}" id="td-wbgz"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wbgz" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-erp' ${inspRecord.inspGuideRecord.erp !=5 &&inspRecord.inspGuideRecord.erp !=null ? 'checked':''}></input></td>
							<td><label >疫情报告专（兼）职人员</label></td>
							<td class="${inspRecord.inspGuideRecord.erp !=5 &&inspRecord.inspGuideRecord.erp !=null ? '':'hide'}" id="td-erp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.erp" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pep' ${inspRecord.inspGuideRecord.pep !=5 &&inspRecord.inspGuideRecord.pep !=null ? 'checked':''}></input></td>
							<td><label >突发公共卫生应急预案</label></td>
							<td class="${inspRecord.inspGuideRecord.pep !=5 &&inspRecord.inspGuideRecord.pep !=null ? '':'hide'}" id="td-pep"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.pep" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-idms' ${inspRecord.inspGuideRecord.idms !=5 &&inspRecord.inspGuideRecord.idms !=null ? 'checked':''}></input></td>
							<td><label >传染病管理制度</label></td>
							<td class="${inspRecord.inspGuideRecord.idms !=5 &&inspRecord.inspGuideRecord.idms !=null ? '':'hide'}" id="td-idms"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.idms" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-mcr'  ${inspRecord.inspGuideRecord.mcr !=5 &&inspRecord.inspGuideRecord.mcr !=null ? 'checked':''}></input></td>
							<td><label >晨检制度及晨检记录</label></td>
							<td class="${inspRecord.inspGuideRecord.mcr !=5 &&inspRecord.inspGuideRecord.mcr !=null ? '':'hide'}" id="td-mcr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.mcr" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-scr' ${inspRecord.inspGuideRecord.scr !=5 &&inspRecord.inspGuideRecord.scr !=null ? 'checked':''}></input></td>
							<td><label >因病缺勤病因追查与登记制度</label></td>
							<td class="${inspRecord.inspGuideRecord.scr !=5 &&inspRecord.inspGuideRecord.scr !=null ? '':'hide'}" id="td-scr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.scr" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pvi' ${inspRecord.inspGuideRecord.pvi !=5 &&inspRecord.inspGuideRecord.pvi !=null ? 'checked':''}></input></td>
							<td><label >小学新生入学接种证查验</label></td>
							<td class="${inspRecord.inspGuideRecord.pvi !=5 &&inspRecord.inspGuideRecord.pvi !=null ? '':'hide'}" id="td-pvi"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.pvi" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-shr' ${inspRecord.inspGuideRecord.shr !=5 &&inspRecord.inspGuideRecord.shr !=null ? 'checked':''}></input></td>
							<td><label >学生健康档案</label></td>
							<td class="${inspRecord.inspGuideRecord.shr !=5 &&inspRecord.inspGuideRecord.shr !=null ? '':'hide'}" id="td-shr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.shr" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ktc' ${inspRecord.inspGuideRecord.ktc !=5 &&inspRecord.inspGuideRecord.ktc !=null ? 'checked':''}></input></td>
							<td><label >开展传染病防治知识培训并做好记录</label></td>
							<td class="${inspRecord.inspGuideRecord.ktc !=5 &&inspRecord.inspGuideRecord.ktc !=null ? '':'hide'}" id="td-ktc"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.ktc" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-iro' ${inspRecord.inspGuideRecord.iro !=5 &&inspRecord.inspGuideRecord.iro !=null ? 'checked':''}></input></td>
							<td><label >疫情信息按规定上报</label></td>
							<td class="${inspRecord.inspGuideRecord.iro !=5 &&inspRecord.inspGuideRecord.iro !=null ? '':'hide'}" id="td-iro"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.iro" /></td>
						</tr>
						<tr>
							<td><input id="hsa-other3" type="checkbox" data-target4='td-other3' ${inspRecord.inspGuideRecord.inspGuideTypeCode==3 && inspRecord.inspGuideRecord.otherIdm !=null? 'checked':''}></input></td>
							<td><label >其他</label>
							<c:choose >
								<c:when test="${inspRecord.inspGuideRecord.inspGuideTypeCode==3}">
									<input  type="text" name="inspGuideRecord.otherIdm"  id="td-other3" ${inspRecord.inspGuideRecord.otherIdm!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-other3","maxlength":500}'/>
								</c:when>
								<c:otherwise>
									<input  type="text" name="inspGuideRecord.otherIdm"   readonly="readonly" id="td-other3" reg='{"required":true,"dependOn":"hsa-other3","maxlength":500}'/>
								</c:otherwise>
							</c:choose>
							</td>
							<td></td>
						</tr>
					</table>
					<table class="posttable hide}" id="hsa-guide-plocation">
						<colgroup>
							<col style="width: 8%;" />
							<col style="width: 56%;" />
							<col style="width: 25%;" />
						</colgroup>
						<tr>
							<td><label >项目</label></td>
							<td align="center"><label >巡查内容</label></td>
							<td><label >巡查结果</label></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-phygienicLicense' ${ inspRecord.inspGuideRecord.inspGuideTypeCode ==4 && inspRecord.inspGuideRecord.hygienicLicense !=5 &&inspRecord.inspGuideRecord.hygienicLicense !=null ? 'checked':''}></input></td>
							<td><label >卫生许可证</label></td>
							<td class="${inspRecord.inspGuideRecord.hygienicLicense !=5 &&inspRecord.inspGuideRecord.hygienicLicense !=null ? '':'hide'}" id="td-phygienicLicense"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hygienicLicense" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pbcb'  ${inspRecord.inspGuideRecord.bcbPlace !=5 &&inspRecord.inspGuideRecord.bcbPlace !=null ? 'checked':''}></input></td>
							<td><label >亮证经营</label></td>
							<td class="${inspRecord.inspGuideRecord.bcbPlace !=5 &&inspRecord.inspGuideRecord.bcbPlace !=null ? '':'hide'}" id="td-pbcb"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.bcbPlace" /></td>
						</tr>
						<tr>
							<td><input id="hsa-paramName-type4" type="checkbox"  data-target2='td-ppraNames' data-target3='td-ppraCount' ${inspRecord.inspGuideRecord.inspGuideTypeCode==4 &&inspRecord.inspGuideRecord.praPlaceNames !=null? 'checked':''}></input></td>
							<td  colspan="2" valign="top" style="vertical-align: top;">
								<c:choose >
								<c:when test="${inspRecord.inspGuideRecord.inspGuideTypeCode==4}">
								<label >从业人员</label> <input type="text" id="td-ppraNames" style="width: 120px"  name="inspGuideRecord.praPlaceNames"  ${inspRecord.inspGuideRecord.praPlaceNames!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-paramName-type4","maxlength":500}' ></input>
										等 <input type="text" style="width: 50px"  name="inspGuideRecord.praPlaceCount"  id="td-ppraCount" ${inspRecord.inspGuideRecord.praPlaceCount!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-paramName-type4","regex":"digits","maxlength":10}' ></input> 名无健康合格证明和卫生知识培训合格证明
								</c:when>
								<c:otherwise>
									<label >从业人员</label> <input type="text" id="td-ppraNames" style="width: 120px"  name="inspGuideRecord.praPlaceNames"  readonly="readonly" reg='{"required":true,"dependOn":"hsa-paramName-type4","maxlength":20}'></input>
										等 <input type="text" style="width: 50px"  name="inspGuideRecord.praPlaceCount" id="td-ppraCount" readonly="readonly" reg='{"required":true,"dependOn":"hsa-paramName-type4","regex":"digits","maxlength":10}'></input> 名无健康合格证明和卫生知识培训合格证明
								</c:otherwise>
							</c:choose>
								</td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wpdd' ${inspRecord.inspGuideRecord.wpdd !=5 &&inspRecord.inspGuideRecord.wpdd !=null ? 'checked':''}></input></td>
							<td><label >卫生管理组织网络、卫生制度和有关岗位制度</label></td>
							<td class="${inspRecord.inspGuideRecord.wpdd !=5 &&inspRecord.inspGuideRecord.wpdd !=null ? '':'hide'}" id="td-wpdd"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wpdd" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-whpm' ${inspRecord.inspGuideRecord.whpm !=5 &&inspRecord.inspGuideRecord.whpm !=null ? 'checked':''}></input></td>
							<td><label >建立化妆品、一次性卫生用品采购索证制度，有索证登记</label></td>
							<td class="${inspRecord.inspGuideRecord.whpm !=5 &&inspRecord.inspGuideRecord.whpm !=null ? '':'hide'}" id="td-whpm"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.whpm" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hpc' ${inspRecord.inspGuideRecord.hpc !=5 &&inspRecord.inspGuideRecord.hpc !=null ? 'checked':''}></input></td>
							<td><label >专用消毒间（场所）</label></td>
							<td class="${inspRecord.inspGuideRecord.hpc !=5 &&inspRecord.inspGuideRecord.hpc !=null ? '':'hide'}" id="td-hpc"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hpc" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-uwp' ${inspRecord.inspGuideRecord.uwp !=5 &&inspRecord.inspGuideRecord.uwp !=null ? 'checked':''}></input></td>
							<td><label >足够容量清洗消毒保洁设施</label></td>
							<td class="${inspRecord.inspGuideRecord.uwp !=5 &&inspRecord.inspGuideRecord.uwp !=null ? '':'hide'}" id="td-uwp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.uwp" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-rc'  ${inspRecord.inspGuideRecord.rc !=5 &&inspRecord.inspGuideRecord.rc !=null ? 'checked':''}></input></td>
							<td><label >供顾客使用的公共用品、用具一客一换一消毒</label></td>
							<td class="${inspRecord.inspGuideRecord.rc !=5 &&inspRecord.inspGuideRecord.rc !=null ? '':'hide'}" id="td-rc"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.rc" /></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-swt' ${inspRecord.inspGuideRecord.swt !=5 &&inspRecord.inspGuideRecord.swt !=null ? 'checked':''}></input></td>
							<td><label >空调等通风设施运转、保养、维修、洗消等工作状态良好</label></td>
							<td class="${inspRecord.inspGuideRecord.swt !=5 &&inspRecord.inspGuideRecord.swt !=null ? '':'hide'}" id="td-swt"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.swt" /></td>
						<tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pwfcf' ${inspRecord.inspGuideRecord.wfcfPlace !=5 &&inspRecord.inspGuideRecord.wfcfPlace !=null ? 'checked':''}></input></td>
							<td><label >配备除“四害”防治设施、开展除“四害”活动</label></td>
							<td class="${inspRecord.inspGuideRecord.wfcfPlace !=5 &&inspRecord.inspGuideRecord.wfcfPlace !=null ? '':'hide'}" id="td-pwfcf"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.wfcfPlace" /></td>
						</tr>
						<tr>
							<td><input id="hsa-other4" type="checkbox" data-target4='td-other4' ${inspRecord.inspGuideRecord.inspGuideTypeCode==4 && inspRecord.inspGuideRecord.otherPlace !=null? 'checked':''}></input></td>
							<td><label >其他</label>
							<c:choose >
								<c:when test="${inspRecord.inspGuideRecord.inspGuideTypeCode==4}">
									<input  type="text" name="inspGuideRecord.otherPlace"  id="td-other4"    ${inspRecord.inspGuideRecord.otherPlace!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-other4","maxlength":500}'/>
								</c:when>
								<c:otherwise>
									<input  type="text" name="inspGuideRecord.otherPlace"    id="td-other4" reg='{"required":true,"dependOn":"hsa-other4","maxlength":500}'/>
								</c:otherwise>
							</c:choose>
							</td>
							<td></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</fieldset>