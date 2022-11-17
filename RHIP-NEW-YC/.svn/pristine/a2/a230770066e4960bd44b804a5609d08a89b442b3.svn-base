<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css"/>
<script src="${pageContext.request.contextPath}/js/views/woman/delivery/add.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
          elem: '#inpatientdate'
           ,format: 'yyyy/MM/dd'
        });
        
        laydate.render({
          elem: '#deliveryDate',
          type:'datetime'
        	  ,format: 'yyyy/MM/dd HH:mm'
        });
      
        laydate.render({
            elem: '#outpatientdate'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
          
      });

    </script>
<div class="toolbar">
	<a href="javascript:void(0)" id="BackId"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	<a href="javascript:void(0);" id="SaveId"><button class="layui-btn layui-btn-sm button "><i class="layui-icon"></i>保存</button></a>
</div>
<div style="background-color: white;top: 65px;" class="divFixed105">
    <ul>
        <li style="text-align: center; font-size: 25px;">分娩信息记录</li>
    </ul>
    <br/>
    <form id="DelivFromId">
        <input type="hidden" name="id" value="${deliveryRecordInfo.id}"/>
        <input type="hidden" name="personId" value="${deliveryRecordInfo.personId}" id="text_personId"/>
        <div class="posttable">
            <fieldset>
                <legend> 产妇信息：</legend>
                <table>
                    <colgroup>
                        <col style="width: 15%;"/>
                        <col style="width: 30%;"/>
                        <col style="width: 15%;"/>
                        <col style="width: 30%;"/>
                    </colgroup>
                    <tr>
                        <th>健康档案编号</th>
                        <td>
                            <input type="text" name="healthFileNo" value="${deliveryRecordInfo.healthFileNo}"
                                   readonly id="healthFileNoId"/>
                        </td>
                    </tr>

                    <tr>
                        <th><label class="required">产妇身份证号</label></th>
                        <td>
                            <tag:idcardInput reg='{"required":true}' id="textIdCard" name="idCard"
                                             value="${deliveryRecordInfo.idCard}"/>
                        </td>
                        <th>产妇姓名</th>
                        <td>
                            <input type="text" name="name" value="${deliveryRecordInfo.name}"
                                   id="text_name"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">住院日期</label></th>
                        <td>
                            <input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="inpatientdate" id="inpatientdate" 
                            value="<fmt:formatDate value='${deliveryRecordInfo.inpatientdate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />               
                        </td>
                        <th><label class="required">分娩日期</label></th>
                        <td>
                           <input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="deliveryDate" id="deliveryDate" 
                            value="<fmt:formatDate value='${deliveryRecordInfo.deliveryDate}' pattern='yyyy/MM/dd HH:mm'/>" style="padding-left: 0px;" />                     
                    </tr>
                    <tr>
                        <th><label class="required">分娩孕周</label></th>
                        <td>
                            <tag:numberInput reg="{'min':0,'max':9999,'required':true}"  name="deliveryWeek"
                                   value="${deliveryRecordInfo.deliveryWeek}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>分娩方式</th>
                        <td colspan="3">
                            <ehr:dic-radio name="deliveryWay"
                                           value="${empty deliveryRecordInfo.deliveryWay ? '1':deliveryRecordInfo.deliveryWay}"
                                           dicmeta="FS10308"
                                           onchange="toggleOther('deliveryWay','deliveryWaySpanID',4);"/>
                            <span id="deliveryWaySpanID" ${empty deliveryRecordInfo.deliveryOther ?"class='hidediv'" : ""}>
                           <input reg='{"maxlength":16}' type="text" name="deliveryOther"
                                  value="${deliveryRecordInfo.deliveryOther}" style="width: 10%"/>
                       </span>
                        </td>
                    </tr>
                    <tr>
                        <th>会阴情况</th>
                        <td colspan="3">
                            <label><input type="radio" name="perineumCutFlag"
                                          value="0" ${deliveryRecordInfo.perineumCutFlag eq 0 ? "checked" : ""}
                                          onchange="toggleOther('perineumCutFlag','perineumTearId',1);">完整</label>
                            <label><input type="radio" name="perineumCutFlag"
                                          value="1" ${deliveryRecordInfo.perineumCutFlag eq 1 ? "checked" : ""}
                                          onchange="toggleOther('perineumCutFlag','perineumTearId',1);">切开,裂伤</label>

                        </td>
                    </tr>
                    <tr id="perineumTearId" ${empty deliveryRecordInfo.perineumTearDegree ?"class='hidediv'" : ""} >
                        <th>产妇会阴裂伤程度</th>
                        <td>
                            <ehr:dic-radio name="perineumTearDegree" code="2,3,4"
                                           value="${deliveryRecordInfo.perineumTearDegree}"
                                           dicmeta="CV0501010"></ehr:dic-radio>
                        </td>
                        <th>产妇会阴缝合针数</th>
                        <td>
                            <tag:numberInput name="perineumTearNeedleNumber" reg="{'min':0,'max':9999}"
                                   value="${deliveryRecordInfo.perineumTearNeedleNumber}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>产科合并症及并发症</th>
                        <td colspan="3">
                            <%--<ehr:dic-radio name="complicationsCode"
                                           value="${empty deliveryRecordInfo.complicationsCode ? '1':deliveryRecordInfo.complicationsCode}"
                                           dicmeta="FS10309"
                                           onchange="toggleOther('complicationsCode','complicationsCodeID',6);"/>--%>
                            <ehr:dic-checkbox name="complicationsCode" value="${deliveryRecordInfo.complicationsCode}"
                                              onchange="toggleOtherCK('complicationsCode','complicationsCodeID',6);"
                                              dicmeta="FS10309"></ehr:dic-checkbox>
                            <span id="complicationsCodeID">
                            <input reg='{"maxlength":16}' type="text" name="complicationsDesc"
                                   value="${deliveryRecordInfo.complicationsDesc}" style="width: 10%"/>
                        </span>
                        </td>
                    </tr>
                    <tr>
                        <th>胎盘</th>
                        <td>
                            <label><input type="radio" name="placenta"
                                          value="0" ${deliveryRecordInfo.placenta eq 0 ? "checked" : "" }
                                          onchange="toggleOther('placenta','placentaID',1);">自然娩出</label>
                            <label><input type="radio" name="placenta"
                                          value="1" ${deliveryRecordInfo.placenta eq 1 ? "checked" : "" }
                                          onchange="toggleOther('placenta','placentaID',1);">人工剥离</label>
                            <span id="placentaID" ${empty deliveryRecordInfo.peelStatus ?"class='hidediv'" : ""}>
                                <lable><input type="radio" name="peelStatus"
                                              value="0" ${deliveryRecordInfo.peelStatus eq 0 ? "checked" : ""}>完整</lable>
                                <lable><input type="radio" name="peelStatus"
                                              value="1" ${deliveryRecordInfo.peelStatus eq 1 ? "checked" : ""}>不完整</lable>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>产后出血</th>
                        <td colspan="3">
                            <label><input type="radio" name="deliveryBleed"
                                          value="0" ${deliveryRecordInfo.deliveryBleed eq 0 ? "checked" : "" }
                                          onchange="toggleOther('deliveryBleed','deliveryBleedID',0);">是</label>
                            <label><input type="radio" name="deliveryBleed"
                                          onchange="toggleOther('deliveryBleed','deliveryBleedID',0);"
                                          value="1" ${deliveryRecordInfo.deliveryBleed eq 1? "checked" : "" }>否</label>
                            <span id="deliveryBleedID" ${empty deliveryRecordInfo.deliveryBleedAfterTwoHours ?"class='hidediv'" : ""}>
                            <input type="text" name="deliveryBleedAfterTwoHours" style="width: 100px;"
                                   value="${deliveryRecordInfo.deliveryBleedAfterTwoHours}"/>ml/24小时
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>本次胎数</th>
                        <td>
                            <tag:numberInput  name="gestationalNumber" reg="{'min':0,'max':99}"
                                   value="${deliveryRecordInfo.gestationalNumber}"/>胎
                        </td>
                    </tr>

                    <tr>
                        <th>产后休养地址</th>
                        <td colspan="3">
                            <input type="text" name="postpartumAdress" value="${deliveryRecordInfo.postpartumAdress}">
                        </td>
                    </tr>

                    <tr>

                        <th>出院日期</th>
                        <td>
                        <input type="text"  class="layui-input x-admin-content-sm-date"  name="outpatientdate" id="outPatientDate" 
                            value="<fmt:formatDate value='${deliveryRecordInfo.outpatientdate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                        </td>
                    </tr>
                    <tr>
                        <th>医院名称</th>
                        <td colspan="2">
                            <input type="text" name="deliveryHospitalName"
                                   value="${deliveryRecordInfo.deliveryHospitalName}">
                        </td>
                    </tr>
                    <tr>
                        <th>新生儿情况</th>
                        <td colspan="3">
                        	<a href="javascript:void(0)" id="addChildBtn" class="add-link layui-btn layui-btn-xs" title="增加胎儿数" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>增加胎儿数</a>
                            <!-- <a href="javascript:void(0)" id="addChildBtn" ><b class="xinz" style="padding-left:22px;" >增加胎儿数</b></a> -->
                            <!-- <a href="javascript:void(0)" id="delTwins" ><b class="zuofei" style="padding-left:22px;" >删除</b></a> -->
                            <a href="javascript:void(0)" id="delTwins" class="delete-link layui-btn layui-btn-danger layui-btn-xs" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
                            
                            
                        </td>
                    </tr>
                </table>
            </fieldset>
            <div id="xseDiv">
                <c:if test="${not empty deliveryRecordInfo.neonatalList}">
                    <c:forEach items="${deliveryRecordInfo.neonatalList}" var="neonatal" varStatus="status">
                    <fieldset id="xseFieldset"${status.index+1}>
                        <legend>新生儿情况${status.index+1}</legend>
                        <table id="xseTable"${status.index+1}>
                            <colgroup>
                                <col style="width: 15%;"/>
                                <col style="width: 30%;"/>
                                <col style="width: 15%;"/>
                                <col style="width: 30%;"/>
                            </colgroup>
                            <tr>
                                <th>出生性别</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].neonatalGender"
                                                   value="${neonatal.neonatalGender}"
                                                   code="1,2,0" dicmeta="GBT226112003"></ehr:dic-radio>&nbsp;&nbsp;&nbsp;&nbsp;
                                    出生体重(g)<tag:numberInput name="neonatalList[${status.index}].birthWeight" reg="{'min':0,'max':9999}" style="width: 10%"
                                                            value="${neonatal.birthWeight}"/>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    出生身长(cm)<tag:numberInput name="neonatalList[${status.index}].birthStature" style="width: 10%"
                                                             value="${neonatal.birthStature}"
                                                             reg="{'min':0,'max':99}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>妊娠结局</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].puerperaResult" value="${neonatal.puerperaResult}"
                                                   dicmeta="FS10310"
                                                   onchange="toggleOther('neonatalList[${status.index}].puerperaResult','puerperaResultSpan_${status.index}',4);"/>

                                    <span class="other ${empty neonatal.deathDay ?'hidediv' : ''}" id="puerperaResultSpan_${status.index}">
                                        <label>出生后</label><input type="text" name="neonatalList[${status.index}].deathDay" value="${neonatal.deathDay}" style="width: 20px"/>
                                        <label>天</label><input type="text" name="neonatalList[${status.index}].deathHour" value="${neonatal.deathHour}" style="width: 20px"/>
                                        <label>小时</label><input type="text" name="neonatalList[${status.index}].deathMin" value="${neonatal.deathMin}" style="width: 20px"/><label>分</label>
                                        <label>死亡诊断</label><input type="text" name="neonatalList[${status.index}].deathDiagnose" value="${neonatal.deathDiagnose}" style="width: 70px"/>
                                </span>
                                </td>
                            </tr>
                            <tr>
                                <th>阿氏评分，1分钟</th>
                                <td>
                                    <tag:numberInput name="neonatalList[${status.index}].apgarValueOne" value="${neonatal.apgarValueOne}" reg="{'min':0,'max':999}" />
                                </td>
                                <th>阿氏评分，5分钟</th>
                                <td>
                                    <tag:numberInput name="neonatalList[${status.index}].apgarValueFive" value="${neonatal.apgarValueFive}" reg="{'min':0,'max':999}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>出生缺陷</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].birthDefectFlag" dicmeta="FS10187"
                                                   value="${neonatal.birthDefectFlag}"
                                                   onchange="toggleOther('neonatalList[${status.index}].birthDefectFlag','birthDefectFlagID_${status.index}',2);"/>
                            <span class="other ${empty neonatal.birthDefectDesc ?'hidediv' : ''}"id="birthDefectFlagID_${status.index}" >
                               <input reg='{"maxlength":16}' type="text" name="neonatalList[${status.index}].birthDefectDesc"
                                      value="${neonatal.birthDefectDesc}" style="width: 10%"/>
                           </span>
                                </td>
                            </tr>

                            <tr>
                                <th>新生儿并发症</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].neonatalComplicationsFlag" dicmeta="FS10187"
                                                   value="${neonatal.neonatalComplicationsFlag}"
                                                   onchange="toggleOther('neonatalList[${status.index}].neonatalComplicationsFlag','neonatalComplicationsFlagID_${status.index}',2);"/>
                                    <span class="other ${empty neonatal.neonatalComplicationsDesc ?'hidediv' : ''}"id="neonatalComplicationsFlagID_${status.index}">
                               <input reg='{"maxlength":16}' type="text" name="neonatalList[${status.index}].neonatalComplicationsDesc"
                                      value="${neonatal.neonatalComplicationsDesc}" style="width: 10%"/>
                           </span>
                                </td>
                            </tr>

                            <tr>
                                <th>卡介疫苗接种</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].bcgStates" dicmeta="FS10187"
                                                   value="${neonatal.bcgStates}"
                                                   onchange="toggleOther('neonatalList[${status.index}].bcgStates','BCGStatesId_${status.index}',1);"/>

                                    <span class="other ${empty neonatal.bcgResult ?'hidediv' : ''}"id="BCGStatesId_${status.index}" >
                               未种原因<input reg='{"maxlength":16}' type="text" name="neonatalList[${status.index}].bcgResult"
                                          value="${neonatal.bcgResult}" style="width: 10%"/>
                        </span>
                                </td>
                            </tr>

                            <tr>
                                <th>乙肝疫苗接种</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].hepatitisBvaccine" dicmeta="FS10187"
                                                   value="${neonatal.hepatitisBvaccine}"
                                                   onchange="toggleOther('neonatalList[${status.index}].hepatitisBvaccine','hepatitisBVaccineId_${status.index}',1);"/>
                                    <span class="other ${empty neonatal.bvaccineResult ?'hidediv' : ''}"id="hepatitisBVaccineId_${status.index}" >
                               未种原因<input reg='{"maxlength":16}' type="text" name="neonatalList[${status.index}].bvaccineResult"
                                          value="${neonatal.bvaccineResult}" style="width: 10%"/>
                           </span>
                                </td>

                            </tr>

                            <tr>
                                <th>新生儿听力筛查</th>
                                <td colspan="3">
                                    <ehr:dic-radio name="neonatalList[${status.index}].hearingScreeningState" dicmeta="FS10025"
                                                   value="${neonatal.hearingScreeningState}"/>

                                </td>
                            </tr>

                            <tr>
                                <th>新生儿疾病筛查</th>
                                <td colspan="3">
                                    <ehr:dic-checkbox name="neonatalList[${status.index}].diseaseScreeningProject" dicmeta="CV0450008" code="1,2,4,3"
                                                      value="${neonatal.diseaseScreeningProject}"
                                                      onchange="toggleOtherCK('neonatalList[${status.index}].diseaseScreeningProject','diseaseScreeningProjectId_${status.index}',3);"/>
                                    <span class="other ${empty neonatal.diseaseScreeningResults ?'hidediv' : ''}" id="diseaseScreeningProjectId_${status.index}">
                               <input reg='{"maxlength":16}' type="text" name="neonatalList[${status.index}].diseaseScreeningResults"
                                      value="${neonatal.diseaseScreeningResults}" style="width: 10%"/>
                           </span>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </form>
</div>
<table id="childTable" class="hidediv">
    <colgroup>
        <col style="width: 15%;"/>
        <col style="width: 30%;"/>
        <col style="width: 15%;"/>
        <col style="width: 30%;"/>
    </colgroup>
    <tr>
        <th>出生性别</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].neonatalGender"
                           value=""
                           code="1,2,0" dicmeta="GBT226112003"></ehr:dic-radio>&nbsp;&nbsp;&nbsp;&nbsp;
            出生体重(g)<tag:numberInput name="neonatalList[i].birthWeight" reg="{'min':0,'max':9999}" style="width: 10%"
                                    value=""/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            出生身长(cm)<tag:numberInput name="neonatalList[i].birthStature" style="width: 10%"
                                     value=""
                                     reg="{'min':0,'max':99}"/>
        </td>
    </tr>
    <tr>
        <th>妊娠结局</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].puerperaResult" value=""
                           dicmeta="FS10310"
                           onchange="toggleOther('neonatalList[i].puerperaResult','puerperaResultSpan_i',4);"/>

            <span class="other hidediv" id="puerperaResultSpan_i" >
                                        <label>出生后</label><input type="text" name="neonatalList[i].deathDay" value="${neonatal.deathDay}" style="width: 20px"/>
                                        <label>天</label><input type="text" name="neonatalList[i].deathHour" value="${neonatal.deathHour}" style="width: 20px"/>
                                        <label>小时</label><input type="text" name="neonatalList[i].deathMin" value="${neonatal.deathMin}" style="width: 20px"/><label>分</label>
                                        <label>死亡诊断</label><input type="text" name="neonatalList[i].deathDiagnose" value="${neonatal.deathDiagnose}" style="width: 70px"/>
                                </span>
        </td>
    </tr>
    <tr>
        <th>阿氏评分，1分钟</th>
        <td>
            <tag:numberInput name="neonatalList[i].apgarValueOne" value="" reg="{'min':0,'max':999}" />
        </td>
        <th>阿氏评分，5分钟</th>
        <td>
            <tag:numberInput name="neonatalList[i].apgarValueFive" value="" reg="{'min':0,'max':999}"/>
        </td>
    </tr>
    <tr>
        <th>出生缺陷</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].birthDefectFlag" dicmeta="FS10187"
                           value=""
                           onchange="toggleOther('neonatalList[i].birthDefectFlag','birthDefectFlagID_i',2);"/>
            <span class="other hidediv"id="birthDefectFlagID_i">
                               <input reg='{"maxlength":16}' type="text" name="neonatalList[i].birthDefectDesc"
                                      value="" style="width: 10%"/>
                           </span>
        </td>
    </tr>

    <tr>
        <th>新生儿并发症</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].neonatalComplicationsFlag" dicmeta="FS10187"
                           value=""
                           onchange="toggleOther('neonatalList[i].neonatalComplicationsFlag','neonatalComplicationsFlagID_i',2);"/>
            <span class="other hidediv"id="neonatalComplicationsFlagID_i">
                               <input reg='{"maxlength":16}' type="text" name="neonatalList[i].neonatalComplicationsDesc"
                                      value="${neonatal.neonatalComplicationsDesc}" style="width: 10%"/>
                           </span>
        </td>
    </tr>

    <tr>
        <th>卡介疫苗接种</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].bcgStates" dicmeta="FS10187"
                           value=""
                           onchange="toggleOther('neonatalList[i].bcgStates','BCGStatesId_i',1);"/>

            <span class="other hidediv"id="BCGStatesId_i">
                               未种原因<input reg='{"maxlength":16}' type="text" name="neonatalList[i].bcgResult"
                                          value="" style="width: 10%"/>
                        </span>
        </td>
    </tr>

    <tr>
        <th>乙肝疫苗接种</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].hepatitisBvaccine" dicmeta="FS10187"
                           value=""
                           onchange="toggleOther('neonatalList[i].hepatitisBvaccine','hepatitisBVaccineId_i',1);"/>
            <span class="other hidediv"id="hepatitisBVaccineId_i">
                               未种原因<input reg='{"maxlength":16}' type="text" name="neonatalList[i].bvaccineResult"
                                          value="" style="width: 10%"/>
                           </span>
        </td>

    </tr>

    <tr>
        <th>新生儿听力筛查</th>
        <td colspan="3">
            <ehr:dic-radio name="neonatalList[i].hearingScreeningState" dicmeta="FS10025"
                           value=""/>

        </td>
    </tr>

    <tr>
        <th>新生儿疾病筛查</th>
        <td colspan="3">
            <ehr:dic-checkbox name="neonatalList[i].diseaseScreeningProject" dicmeta="CV0450008" code="1,2,4,3"
                              value="" onchange="toggleOtherCK('neonatalList[i].diseaseScreeningProject','diseaseScreeningProjectId_i',3);"/>
            <span id="diseaseScreeningProjectId_i" class="other hidediv">
                               <input reg='{"maxlength":16}' type="text" name="neonatalList[i].diseaseScreeningResults"
                                      value="" style="width: 10%"/>
                           </span>
        </td>
    </tr>
</table>
