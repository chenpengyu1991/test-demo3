<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
	<table class="posttable">
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
							<td><input  type="checkbox"  data-target='td-cyxkz' ${inspRecord.inspGuideRecord.cyxkz !=5  && inspRecord.inspGuideRecord.cyxkz!=null? 'checked':''}  ></input></td>
							<td><label >餐饮服务许可证</label></td>
							<td class="${inspRecord.inspGuideRecord.cyxkz !=5 &&inspRecord.inspGuideRecord.cyxkz !=null ? '':'hide'}" id="td-cyxkz" ><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.cyxkz"  value="${inspRecord.inspGuideRecord.cyxkz}"  /></td>
						</tr>
						<tr>
							<td><input type="checkbox" data-target='td-bcb' ${inspRecord.inspGuideRecord.bcb !=5 &&inspRecord.inspGuideRecord.bcb !=null ? 'checked':''}></input></td>
							<td><label >亮证经营</label></td>
							<td class="${inspRecord.inspGuideRecord.bcb !=5 &&inspRecord.inspGuideRecord.bcb !=null ? '':'hide'}" id="td-bcb"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.bcb"   value="${inspRecord.inspGuideRecord.bcb}"/></td>
						</tr>
						<tr>
							<td><input id="hsa-paramName-type1" type="checkbox"  data-target2='td-praNames' data-target3='td-praCount' ${inspRecord.inspGuideRecord.praNames !=null? 'checked':''}></input></td>
							<td colspan="2" valign="top" style="vertical-align: top;">
								<label >从业人员</label> <input type="text" id="td-praNames" style="width: 120px"  name="inspGuideRecord.praNames" value="${inspRecord.inspGuideRecord.praNames}" ${inspRecord.inspGuideRecord.praNames!=null ? '':'readonly'} reg='{"required":true,"dependOn":"hsa-paramName-type1","maxlength":300}'></input>
										等 <input type="text" style="width: 50px"  name="inspGuideRecord.praCount" value="${inspRecord.inspGuideRecord.praCount}" id="td-praCount" ${inspRecord.inspGuideRecord.praCount!=null ? '':'readonly'}  reg='{"required":true,"dependOn":"hsa-paramName-type1","regex":"digits","maxlength":6}' ></input> 名无健康合格证明和卫生知识培训合格证明
							</td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-bfhin' ${inspRecord.inspGuideRecord.bfhin !=5 &&inspRecord.inspGuideRecord.bfhin !=null ? 'checked':''}></input></td>
							<td><label >建立食品安全管理组织网络、卫生制度等</label></td>
							<td class="${inspRecord.inspGuideRecord.bfhin !=5 &&inspRecord.inspGuideRecord.bfhin !=null ? '':'hide'}" id="td-bfhin"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.bfhin" value="${inspRecord.inspGuideRecord.bfhin}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-fblfbr'  ${inspRecord.inspGuideRecord.fblfbr !=5 &&inspRecord.inspGuideRecord.fblfbr !=null ? 'checked':''}></input></td>
							<td><label>建立食品采购查验和索证索票制度，食品原辅料采购记录</label></td>
							<td class="${inspRecord.inspGuideRecord.fblfbr !=5 &&inspRecord.inspGuideRecord.fblfbr !=null ? '':'hide'}" id="td-fblfbr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}'  dicmeta="HSA00002" name="inspGuideRecord.fblfbr" value="${inspRecord.inspGuideRecord.fblfbr}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-osnu'  ${inspRecord.inspGuideRecord.osnu !=5 &&inspRecord.inspGuideRecord.osnu !=null ? 'checked':''}></input></td>
							<td><label >经营超过保质期、无标签、或使用非食品原料生产食品等</label></td>
							<td class="${inspRecord.inspGuideRecord.osnu !=5 &&inspRecord.inspGuideRecord.osnu !=null ? '':'hide'}" id="td-osnu"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.osnu" value="${inspRecord.inspGuideRecord.osnu}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ict'  ${inspRecord.inspGuideRecord.ict !=5 &&inspRecord.inspGuideRecord.ict !=null ? 'checked':''}></input></td>
							<td><label >内外环境整洁有序，无杂物堆放，垃圾桶密闭加盖</label></td>
							<td class="${inspRecord.inspGuideRecord.ict !=5 &&inspRecord.inspGuideRecord.ict !=null ? '':'hide'}" id="td-ict"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.ict" value="${inspRecord.inspGuideRecord.ict}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-lpau' ${inspRecord.inspGuideRecord.lpau !=5 &&inspRecord.inspGuideRecord.lpau !=null ? 'checked':''}></input></td>
							<td><label >设凉菜间，有消毒水池、空调、紫外线灯</label></td>
							<td class="${inspRecord.inspGuideRecord.lpau !=5 &&inspRecord.inspGuideRecord.lpau !=null ? '':'hide'}" id="td-lpau"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.lpau" value="${inspRecord.inspGuideRecord.lpau}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-lhs' ${inspRecord.inspGuideRecord.lhs !=5 &&inspRecord.inspGuideRecord.lhs !=null ? 'checked':''}></input></td>
							<td><label >设食品原料仓库/区域，有货架</label></td>
							<td class="${inspRecord.inspGuideRecord.lhs !=5 &&inspRecord.inspGuideRecord.lhs !=null ? '':'hide'}" id="td-lhs"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.lhs" value="${inspRecord.inspGuideRecord.lhs}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-lcd' ${inspRecord.inspGuideRecord.lcd !=5 &&inspRecord.inspGuideRecord.lcd !=null ? 'checked':''}></input></td>
							<td><label >设餐具消毒间（场所），清洗、消毒设施（水池）</label></td>
							<td class="${inspRecord.inspGuideRecord.lcd !=5 &&inspRecord.inspGuideRecord.lcd !=null ? '':'hide'}" id="td-lcd"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.lcd" value="${inspRecord.inspGuideRecord.lcd}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-acf'  ${inspRecord.inspGuideRecord.acf !=5 &&inspRecord.inspGuideRecord.acf !=null ? 'checked':''}></input></td>
							<td><label >有生、熟冰箱，生、熟食品分开存放</label></td>
							<td class="${inspRecord.inspGuideRecord.acf !=5 &&inspRecord.inspGuideRecord.acf !=null ? '':'hide'}" id="td-acf"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.acf" value="${inspRecord.inspGuideRecord.acf}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-wfcf' ${inspRecord.inspGuideRecord.wfcf !=5 &&inspRecord.inspGuideRecord.wfcf !=null ? 'checked':''}></input></td>
							<td><label >配备除“四害”防治设施、开展除“四害”活动</label></td>
							<td class="${inspRecord.inspGuideRecord.wfcf !=5 &&inspRecord.inspGuideRecord.wfcf !=null ? '':'hide'}" id="td-wfcf"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00002" name="inspGuideRecord.wfcf" value="${inspRecord.inspGuideRecord.wfcf}"/></td>
						</tr>
						<tr>
							<td><input id="hsa-other1" type="checkbox"  data-target4='td-other1' ${ inspRecord.inspGuideRecord.other !=null? 'checked':''}></input></td>
							<td><label >其他</label>
									<input  type="text" name="inspGuideRecord.other" value="${inspRecord.inspGuideRecord.other}" ${inspRecord.inspGuideRecord.other!=null ? '':'readonly'} id="td-other1"  reg='{"required":true,"dependOn":"hsa-other1","maxlength":500}'/>
							</td>
							<td></td>
						</tr>
					</table>