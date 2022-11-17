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
							<td><input type="checkbox"  data-target='td-phygienicLicense' ${ inspRecord.inspGuideRecord.hygienicLicense !=5 &&inspRecord.inspGuideRecord.hygienicLicense !=null ? 'checked':''}></input></td>
							<td><label >卫生许可证</label></td>
							<td class="${inspRecord.inspGuideRecord.hygienicLicense !=5 &&inspRecord.inspGuideRecord.hygienicLicense !=null ? '':'hide'}" id="td-phygienicLicense"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hygienicLicense" value="${inspRecord.inspGuideRecord.hygienicLicense}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pbcb'  ${ inspRecord.inspGuideRecord.bcb !=5&&inspRecord.inspGuideRecord.bcb !=null ? 'checked':''}></input></td>
							<td><label >亮证经营</label></td>
							<td class="${ inspRecord.inspGuideRecord.bcb !=5&&inspRecord.inspGuideRecord.bcb !=null ? '':'hide'}" id="td-pbcb"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.bcb" value="${inspRecord.inspGuideRecord.bcb}"/></td>
						</tr>
						<tr>
							<td><input id="hsa-paramName-type4" type="checkbox"  data-target2='td-ppraNames' data-target3='td-ppraCount' ${inspRecord.inspGuideRecord.praNames !=null? 'checked':''}></input></td>
							<td  colspan="2" valign="top" style="vertical-align: top;">
								<label >从业人员</label> <input type="text" id="td-ppraNames" style="width: 120px"  name="inspGuideRecord.praNames" value="${inspRecord.inspGuideRecord.praNames}"  ${inspRecord.inspGuideRecord.praNames!=null ? '':'readonly'}   reg='{"required":true,"dependOn":"hsa-paramName-type4","maxlength":300}' ></input>
										等 <input type="text" style="width: 50px"  name="inspGuideRecord.praCount" value="${inspRecord.inspGuideRecord.praCount}" id="td-ppraCount" ${inspRecord.inspGuideRecord.praCount!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-paramName-type4","regex":"digits","maxlength":6}' ></input> 名无健康合格证明和卫生知识培训合格证明
								</td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wpdd' ${inspRecord.inspGuideRecord.wpdd !=5 &&inspRecord.inspGuideRecord.wpdd !=null ? 'checked':''}></input></td>
							<td><label >卫生管理组织网络、卫生制度和有关岗位制度</label></td>
							<td class="${inspRecord.inspGuideRecord.wpdd !=5 &&inspRecord.inspGuideRecord.wpdd !=null ? '':'hide'}" id="td-wpdd"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wpdd" value="${inspRecord.inspGuideRecord.wpdd}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-whpm' ${inspRecord.inspGuideRecord.whpm !=5 &&inspRecord.inspGuideRecord.whpm !=null ? 'checked':''}></input></td>
							<td><label >建立化妆品、一次性卫生用品采购索证制度，有索证登记</label></td>
							<td class="${inspRecord.inspGuideRecord.whpm !=5 &&inspRecord.inspGuideRecord.whpm !=null ? '':'hide'}" id="td-whpm"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.whpm" value="${inspRecord.inspGuideRecord.whpm}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-hpc' ${inspRecord.inspGuideRecord.hpc !=5 &&inspRecord.inspGuideRecord.hpc !=null ? 'checked':''}></input></td>
							<td><label >专用消毒间（场所）</label></td>
							<td class="${inspRecord.inspGuideRecord.hpc !=5 &&inspRecord.inspGuideRecord.hpc !=null ? '':'hide'}" id="td-hpc"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.hpc" value="${inspRecord.inspGuideRecord.hpc}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-uwp' ${inspRecord.inspGuideRecord.uwp !=5 &&inspRecord.inspGuideRecord.uwp !=null ? 'checked':''}></input></td>
							<td><label >足够容量清洗消毒保洁设施</label></td>
							<td class="${inspRecord.inspGuideRecord.uwp !=5 &&inspRecord.inspGuideRecord.uwp !=null ? '':'hide'}" id="td-uwp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.uwp" value="${inspRecord.inspGuideRecord.uwp}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-rc'  ${inspRecord.inspGuideRecord.rc !=5 &&inspRecord.inspGuideRecord.rc !=null ? 'checked':''}></input></td>
							<td><label >供顾客使用的公共用品、用具一客一换一消毒</label></td>
							<td class="${inspRecord.inspGuideRecord.rc !=5 &&inspRecord.inspGuideRecord.rc !=null ? '':'hide'}" id="td-rc"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.rc" value="${inspRecord.inspGuideRecord.rc}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-swt' ${inspRecord.inspGuideRecord.swt !=5 &&inspRecord.inspGuideRecord.swt !=null ? 'checked':''}></input></td>
							<td><label >空调等通风设施运转、保养、维修、洗消等工作状态良好</label></td>
							<td class="${inspRecord.inspGuideRecord.swt !=5 &&inspRecord.inspGuideRecord.swt !=null ? '':'hide'}" id="td-swt"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.swt" value="${inspRecord.inspGuideRecord.swt}"/></td>
						<tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pwfcf' ${inspRecord.inspGuideRecord.wfcf !=5&&inspRecord.inspGuideRecord.wfcf !=null ? 'checked':''}></input></td>
							<td><label >配备除“四害”防治设施、开展除“四害”活动</label></td>
							<td class="${inspRecord.inspGuideRecord.wfcf !=5&&inspRecord.inspGuideRecord.wfcf !=null ? '':'hide'}" id="td-pwfcf"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.wfcf" value="${inspRecord.inspGuideRecord.wfcf}"/></td>
						</tr>
						<tr>
							<td><input id="hsa-other4" type="checkbox" data-target4='td-other4' ${inspRecord.inspGuideRecord.other !=null? 'checked':''}></input></td>
							<td><label >其他</label>
									<input  type="text" name="inspGuideRecord.other" value="${inspRecord.inspGuideRecord.other}" id="td-other4"    ${inspRecord.inspGuideRecord.other!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-other4","maxlength":500}'/>
							</td>
							<td></td>
						</tr>
					</table>