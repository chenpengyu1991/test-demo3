<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
	<table class="posttable" >
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
							<td class="${inspRecord.inspGuideRecord.hms !=5 &&inspRecord.inspGuideRecord.hms !=null ? '':'hide'}" id="td-hms"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hms" value="${inspRecord.inspGuideRecord.hms}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hmp' ${inspRecord.inspGuideRecord.hmp !=5 &&inspRecord.inspGuideRecord.hmp !=null ? 'checked':''}></input></td>
							<td><label >卫生管理人员</label></td>
							<td class="${inspRecord.inspGuideRecord.hmp !=5 &&inspRecord.inspGuideRecord.hmp !=null ? '':'hide'}" id="td-hmp"><ehr:dic-radio hideCodes="1,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hmp" value="${inspRecord.inspGuideRecord.hmp}"/> </td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hcandhk' ${inspRecord.inspGuideRecord.hcandhk !=5 &&inspRecord.inspGuideRecord.hcandhk !=null ? 'checked':''}></input></td>
							<td><label >供、管水从业人员健康合格证明和卫生知识培训合格证明</label></td>
							<td class="${inspRecord.inspGuideRecord.hcandhk !=5 &&inspRecord.inspGuideRecord.hcandhk !=null ? '':'hide'}" id="td-hcandhk"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hcandhk" value="${inspRecord.inspGuideRecord.hcandhk}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wt' ${inspRecord.inspGuideRecord.wt !=5 &&inspRecord.inspGuideRecord.wt !=null ? 'checked':''}></input></td>
							<td><label >水质检测记录 / 检测报告</label></td>
							<td class="${inspRecord.inspGuideRecord.wt !=5 &&inspRecord.inspGuideRecord.wt !=null ? '':'hide'}" id="td-wt"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wt" value="${inspRecord.inspGuideRecord.wt}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wdd' ${inspRecord.inspGuideRecord.wdd !=5 &&inspRecord.inspGuideRecord.wdd !=null ? 'checked':''}></input></td>
							<td><label >水质净化消毒设施正常运转/ 饮水机消毒</label></td>
							<td class="${inspRecord.inspGuideRecord.wdd !=5 &&inspRecord.inspGuideRecord.wdd !=null ? '':'hide'}" id="td-wdd"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wdd" value="${inspRecord.inspGuideRecord.wdd}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wpsw' ${inspRecord.inspGuideRecord.wpsw !=5 &&inspRecord.inspGuideRecord.wpsw !=null ? 'checked':''}></input></td>
							<td><label >水源卫生防护措施 / 贮存仓库</label></td>
							<td class="${inspRecord.inspGuideRecord.wpsw !=5 &&inspRecord.inspGuideRecord.wpsw !=null ? '':'hide'}" id="td-wpsw"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wpsw" value="${inspRecord.inspGuideRecord.wpsw}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hygienicLicense' ${inspRecord.inspGuideRecord.hygienicLicense !=5 &&inspRecord.inspGuideRecord.hygienicLicense !=null ? 'checked':''}></input></td>
							<td><label >卫生许可证（仅限集中式供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.hygienicLicense !=5 &&inspRecord.inspGuideRecord.hygienicLicense !=null ? '':'hide'}" id="td-hygienicLicense"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hygienicLicense" value="${inspRecord.inspGuideRecord.hygienicLicense}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ud' ${inspRecord.inspGuideRecord.ud !=5 &&inspRecord.inspGuideRecord.ud !=null ? 'checked':''}></input></td>
							<td><label >使用的涉水产品、消毒剂卫生许可批件</label></td>
							<td class="${inspRecord.inspGuideRecord.ud !=5 &&inspRecord.inspGuideRecord.ud !=null ? '':'hide'}" id="td-ud"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.ud" value="${inspRecord.inspGuideRecord.ud}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-rcwt' ${inspRecord.inspGuideRecord.rcwt !=5 &&inspRecord.inspGuideRecord.rcwt !=null ? 'checked':''}></input></td>
							<td><label >定期清洗消毒和水质检验（仅限二次供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.rcwt !=5 &&inspRecord.inspGuideRecord.rcwt !=null ? '':'hide'}" id="td-rcwt"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.rcwt" value="${inspRecord.inspGuideRecord.rcwt}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-sdw' ${inspRecord.inspGuideRecord.sdw !=5 &&inspRecord.inspGuideRecord.sdw !=null ? 'checked':''}></input></td>
							<td><label >二次供水水箱饮用水专用（仅限二次供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.sdw !=5 &&inspRecord.inspGuideRecord.sdw !=null ? '':'hide'}" id="td-sdw"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.sdw" value="${inspRecord.inspGuideRecord.sdw}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ssp' ${inspRecord.inspGuideRecord.ssp !=5 &&inspRecord.inspGuideRecord.ssp !=null ? 'checked':''}></input></td>
							<td><label >二次供水水箱周围污染（仅限二次供水单位填写）</label></td>
							<td class="${inspRecord.inspGuideRecord.ssp !=5 &&inspRecord.inspGuideRecord.ssp !=null ? '':'hide'}" id="td-ssp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.ssp" value="${inspRecord.inspGuideRecord.ssp}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-dosp' data-target1='td-dostv' ${inspRecord.inspGuideRecord.dosp !=5 &&inspRecord.inspGuideRecord.dosp !=null ? 'checked':''}></input></td>
							<td><label >饮用水水质感官性状检测:</label></td>
						</tr>
						<tr>
							<td></td>
							<td><label >①异味: </label></td>
							<td class="${inspRecord.inspGuideRecord.dosp !=5 &&inspRecord.inspGuideRecord.dosp !=null ? '':'hide'}" id="td-dosp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.dosp" value="${inspRecord.inspGuideRecord.dosp}"/></td>
						</tr>
						<tr>
							<td></td>
							<td><label >②肉眼可见物: </label></td>
							<td class="${inspRecord.inspGuideRecord.dostv !=5 &&inspRecord.inspGuideRecord.dostv !=null ? '':'hide'}" id="td-dostv"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.dostv" value="${inspRecord.inspGuideRecord.dostv}"/></td>
						</tr>
						<tr>
							<td><input id="hsa-other2" type="checkbox"  data-target4='td-other2' ${inspRecord.inspGuideRecord.other !=null? 'checked':''}></input></td>
							<td><label >其他</label>
									<input  type="text" name="inspGuideRecord.other" value="${inspRecord.inspGuideRecord.other}" id="td-other2" ${inspRecord.inspGuideRecord.other!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-other2","maxlength":500}'/>
							</td>
							<td></td>
						</tr>
					</table>