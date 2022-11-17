		<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
			<table class="posttable">
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
							<td><input type="checkbox"  data-target='td-wbgz' ${inspRecord.inspGuideRecord.wbgz !=5 &&inspRecord.inspGuideRecord.wbgz !=null ? 'checked':''}></input></td>
							<td><label >卫生防病管理组织</label></td>
							<td class="${inspRecord.inspGuideRecord.wbgz !=5 &&inspRecord.inspGuideRecord.wbgz !=null ? '':'hide'}" id="td-wbgz"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.wbgz" value="${inspRecord.inspGuideRecord.wbgz}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-erp' ${inspRecord.inspGuideRecord.erp !=5 &&inspRecord.inspGuideRecord.erp !=null ? 'checked':''}></input></td>
							<td><label >疫情报告专（兼）职人员</label></td>
							<td class="${inspRecord.inspGuideRecord.erp !=5 &&inspRecord.inspGuideRecord.erp !=null ? '':'hide'}" id="td-erp"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.erp" value="${inspRecord.inspGuideRecord.erp}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pep' ${inspRecord.inspGuideRecord.pep !=5 &&inspRecord.inspGuideRecord.pep !=null ? 'checked':''}></input></td>
							<td><label >突发公共卫生应急预案</label></td>
							<td class="${inspRecord.inspGuideRecord.pep !=5 &&inspRecord.inspGuideRecord.pep !=null ? '':'hide'}" id="td-pep"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.pep" value="${inspRecord.inspGuideRecord.pep}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-idms' ${inspRecord.inspGuideRecord.idms !=5 &&inspRecord.inspGuideRecord.idms !=null ? 'checked':''}></input></td>
							<td><label >传染病管理制度</label></td>
							<td class="${inspRecord.inspGuideRecord.idms !=5 &&inspRecord.inspGuideRecord.idms !=null ? '':'hide'}" id="td-idms"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.idms" value="${inspRecord.inspGuideRecord.idms}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-mcr'  ${inspRecord.inspGuideRecord.mcr !=5 &&inspRecord.inspGuideRecord.mcr !=null ? 'checked':''}></input></td>
							<td><label >晨检制度及晨检记录</label></td>
							<td class="${inspRecord.inspGuideRecord.mcr !=5 &&inspRecord.inspGuideRecord.mcr !=null ? '':'hide'}" id="td-mcr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.mcr" value="${inspRecord.inspGuideRecord.mcr}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-scr' ${inspRecord.inspGuideRecord.scr !=5 &&inspRecord.inspGuideRecord.scr !=null ? 'checked':''}></input></td>
							<td><label >因病缺勤病因追查与登记制度</label></td>
							<td class="${inspRecord.inspGuideRecord.scr !=5 &&inspRecord.inspGuideRecord.scr !=null ? '':'hide'}" id="td-scr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.scr" value="${inspRecord.inspGuideRecord.scr}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-pvi' ${inspRecord.inspGuideRecord.pvi !=5 &&inspRecord.inspGuideRecord.pvi !=null ? 'checked':''}></input></td>
							<td><label >小学新生入学接种证查验</label></td>
							<td class="${inspRecord.inspGuideRecord.pvi !=5 &&inspRecord.inspGuideRecord.pvi !=null ? '':'hide'}" id="td-pvi"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.pvi" value="${inspRecord.inspGuideRecord.pvi}"/></td>
						</tr>
						<tr>
						
							<td><input type="checkbox"  data-target='td-shr' ${inspRecord.inspGuideRecord.shr !=5 &&inspRecord.inspGuideRecord.shr !=null ? 'checked':''}></input></td>
							<td><label >学生健康档案</label></td>
							<td class="${inspRecord.inspGuideRecord.shr !=5 &&inspRecord.inspGuideRecord.shr !=null ? '':'hide'}" id="td-shr"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.shr" value="${inspRecord.inspGuideRecord.shr}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-ktc' ${inspRecord.inspGuideRecord.ktc !=5 &&inspRecord.inspGuideRecord.ktc !=null ? 'checked':''}></input></td>
							<td><label >开展传染病防治知识培训并做好记录</label></td>
							<td class="${inspRecord.inspGuideRecord.ktc !=5 &&inspRecord.inspGuideRecord.ktc !=null ? '':'hide'}" id="td-ktc"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.ktc" value="${inspRecord.inspGuideRecord.ktc}"/></td>
						</tr>
						<tr>
							<td><input type="checkbox"  data-target='td-iro' ${inspRecord.inspGuideRecord.iro !=5 &&inspRecord.inspGuideRecord.iro !=null ? 'checked':''}></input></td>
							<td><label >疫情信息按规定上报</label></td>
							<td class="${inspRecord.inspGuideRecord.iro !=5 &&inspRecord.inspGuideRecord.iro !=null ? '':'hide'}" id="td-iro"><ehr:dic-radio hideCodes="3,4,5" reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.iro" value="${inspRecord.inspGuideRecord.iro}"/></td>
						</tr>
						<tr>
							<td><input id="hsa-other3" type="checkbox" data-target4='td-other3' ${ inspRecord.inspGuideRecord.other !=null? 'checked':''}></input></td>
							<td><label >其他</label>
									<input  type="text" name="inspGuideRecord.other" value="${inspRecord.inspGuideRecord.other}" ${ inspRecord.inspGuideRecord.other !=null? '':'readonly'}  id="td-other3"  reg='{"required":true,"dependOn":"hsa-other3","maxlength":500}'/>
							</td>
							<td></td>
						</tr>
					</table>