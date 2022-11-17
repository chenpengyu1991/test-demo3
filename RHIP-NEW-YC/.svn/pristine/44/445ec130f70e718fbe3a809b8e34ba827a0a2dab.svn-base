<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div id="beforeSaveDiv" style="height: 475px">
    <form id="personInfoForm" method="post">
        <span class="span_floatleft"><b>姓名:</b>${personBasicInfoDto.personInfo.name }</span>
        <c:choose>
            <c:when test="${not empty personBasicInfoDto.personInfo.healthFileNoHtml}">
                ${personBasicInfoDto.personInfo.healthFileNoHtml}
            </c:when>
            <c:otherwise>
                <s class="pop_No">
                    <span class="text"><b>编号：</b></span>
                    <span></span><span></span><span></span><span></span><span></span>
                    <span class="line">-</span>
                    <span></span><span></span><span></span>
                    <span class="line">-</span>
                    <span></span><span></span><span></span>
                    <span class="line">-</span>
                    <span></span><span></span><span></span><span></span>
                </s>
            </c:otherwise>
        </c:choose>
        <div class="table-basic">
            <table>
                <colgroup>
                    <col style="width:8%;"/>
                    <col style="width:10%;"/>
                    <col style="width:8%;"/>
                    <col style="width:12%;"/>
                    <col style="width:8%;"/>
                    <col style="width:8%;"/>
                    <col style="width:8%;"/>
                    <col style="width:8%;"/>
                </colgroup>
                <tr>
                    <th >性别</th>
                    <td >
                        <ehr:dic dicmeta="GBT226112003" code="${personBasicInfoDto.personInfo.gender}"/>
                    </td>
                    <th >出生日期</th>
                    <td colspan="2">
                        <fmt:formatDate value='${personBasicInfoDto.personInfo.birthday}' pattern='yyyy/MM/dd'/>
                    </td>
                    <th >身份证号</th>
                    <td colspan="2">${personBasicInfoDto.personInfo.idcard }</td>
                </tr>
                <tr>
                    <th colspan="2">家庭住址</th>
                    <td colspan="6">${personBasicInfoDto.personInfo.unitName }</td>
                </tr>
                <tr>
                    <th width="20px">父亲</th>
                    <td ></td>
                    <th width="20px">职业</th>
                    <td ></td>
                    <th width="20px">联系电话</th>
                    <td ></td>
                    <th width="20px">出生日期</th>
                    <td ></td>
                </tr>
                <tr>
                    <th >母亲</th>
                    <td ></td>
                    <th>职业</th>
                    <td ></td>
                    <th>联系电话</th>
                    <td ></td>
                    <th>出生日期</th>
                    <td ></td>
                </tr>
                <tr>
                    <th colspan="2">出生孕周</th>
                    <td >周</td>
                    <th colspan="2">母亲妊娠期患病情况</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <th colspan="2">助产机构</th>
                    <td colspan="2">九龙医院</td>
                    <th colspan="2">出生情况</th>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <th colspan="2">新生儿窒息</th>
                    <td colspan="2">有(Apgar评分:1min 5min 不详)</td>
                    <th colspan="2">畸形</th>
                    <td colspan="2">无</td>
                </tr>
                <tr>
                    <th colspan="2">新生儿听力筛查</th>
                    <td colspan="2">通过/未通过/未筛查/不详</td>
                    <th colspan="2">新生儿疾病筛查</th>
                    <td colspan="2">未进行/检查均为阴性</td>
                </tr>
                <tr>
                    <th colspan="2">新生儿出生体重</th>
                    <td >kg</td>
                    <th >目前体重</th>
                    <td >kg</td>
                    <th >出生身长</th>
                    <td colspan="2">cm</td>
                </tr>
                <tr>
                    <th colspan="2">喂养方式</th>
                    <td >纯母乳混合人工</td>
                    <th >吃奶量</th>
                    <td >mg/次</td>
                    <th >吃奶次数</th>
                    <td colspan="2">次/日</td>
                </tr>
                <tr>
                    <th colspan="2">呕吐</th>
                    <td >无/有</td>
                    <th >大便</th>
                    <td >糊状/稀/其他</td>
                    <th >大便次数</th>
                    <td colspan="2">次/日</td>
                </tr>
                <tr>
                    <th colspan="2">体温</th>
                    <td >C</td>
                    <th >心率</th>
                    <td >次/分钟</td>
                    <th >呼吸频率</th>
                    <td colspan="2">次/分钟</td>
                </tr>
                <tr>
                    <th >面色</th>
                    <td colspan="3">红润/黄染/其他____</td>
                    <th >黄疸部位</th>
                    <td colspan="3">1无2面部3躯干4四肢5手足</td>
                </tr>
                <tr>
                    <th >前囟</th>
                    <td colspan="2">2cmX3cm</td>
                    <td colspan="5">1正常2膨隆3凹陷4其他</td>
                </tr>
                <tr>
                    <th >眼睛</th>
                    <td >未见异常</td>
                    <th >四肢活动度</th>
                    <td >未见异常</td>
                    <th >耳外观</th>
                    <td >异常</td>
                    <th >颈部包块</th>
                    <td >无/有 </td>
                </tr>
                <tr>
                    <th >鼻</th>
                    <td >未见异常</td>
                    <th >皮肤</th>
                    <td >未见异常</td>
                    <th >口腔</th>
                    <td >未见异常</td>
                    <th >肛门</th>
                    <td >未见异常</td>
                </tr>
                <tr>
                    <th >心肺听诊</th>
                    <td >未见异常</td>
                    <th >胸部</th>
                    <td >未见异常</td>
                    <th >腹部触诊</th>
                    <td >未见异常</td>
                    <th >脊柱</th>
                    <td >未见异常</td>
                </tr>
                <tr>
                    <th colspan="2">外生殖器</th>
                    <td colspan="2">未见异常</td>
                    <th colspan="2">脐带</th>
                    <td colspan="2">脱落</td>
                </tr>
                <tr>
                    <th colspan="2">转诊建议</th>
                    <td colspan="2">无/有  原因</td>
                    <th colspan="2">机构及科室:</th>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <th >指导</th>
                    <td colspan="7">喂养指导 发育指导 防病指导 预防上海指导 口腔保健指导 其他</td>
                </tr>
                <tr>
                    <th >本次访视日期</th>
                    <td ></td>
                    <th >下次随访地点:</th>
                    <td ></td>
                    <th >下次随访日期:</th>
                    <td ></td>
                    <th >随访医生:</th>
                    <td ></td>
                </tr>
            </table>
        </div>
    </form>
</div>