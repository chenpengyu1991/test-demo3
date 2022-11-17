<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-4-17
  Time: 下午1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk135/question/editQuestion.js" type="text/javascript"></script>


<div class="toolbar" align="right" style="margin-top: 8px;">
    <%-- <a href="javascript:void(0)" id="backToSearchBtn"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" id="backToSearchBtn" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
<c:if test="${dm.appraiseResult ne 1}" >
    <c:if test="${type eq 1}">
    <%-- <a href="javascript:void(0)" id="saveQuestionBtn"><b class="baocun">保存</b></a> --%>
    <a href="javascript:void(0)" id="saveQuestionBtn" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
    <c:if test="${type eq 2}">
        <c:if test="${personInfo.riskManageStatus ne 1}">
        <%-- <a href="javascript:void(0)" id="saveQuestionBtn"><b class="baocun">保存</b></a> --%>
        <a href="javascript:void(0)" id="saveQuestionBtn" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
        </c:if>
    </c:if>
    <c:if test="${abc eq 1}">
    <%-- <a href="javascript:void(0)" onclick="question135.deleteQuestion('${question.id}', 1)"><b class="zuofei">删除</b></a> --%>
    <a href="javascript:void(0)" onclick="question135.deleteQuestion('${question.id}', 1)"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe640;</i>删除</button></a>
</c:if>
</c:if>
    </div>
<div class="postcontent">
    <i class="popno"><i class="popno">慢性病社区综合防治调查问卷</i></i>
    <div class="postdiv">
        <form id="questionForm" action="">
            <input type="hidden" name="id" value="${question.id}">
            <input type="hidden" name="idNo" value="${dm.idNo}">
            <input type="hidden" name="type" value="${type}">
            <fieldset class="layui-elem-field">
                <legend>调查对象</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 15%"/>
                        <col style="width: 35%"/>
                        <col style="width: 15%"/>
                        <col style="width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>地区编码</th>
                        <td><input type="text" name="areaCode" value="${question.areaCode}"></td>
                        <%--<th>调查对象</th>--%>
                        <%--<td><input type="text" name="surveyTarget" value="${question.surveyTarget}" reg="{'required':true}"></td>--%>
                    </tr>
                    <tr>
                        <th>姓名</th>
                        <td>${dm.name}<input type="hidden" name="personName" readonly="readonly" value="${dm.name}" reg="{'required':true}"></td>
                    </tr>
                    <tr>
                        <th>地址</th>
                        <c:if test="${type eq 1}">
                        <td>${dm.address}<input type="hidden" name="address"  value="${dm.address}"/></td>
                        </c:if>
                        <c:if test="${type eq 2}">
                            <td>
                                <ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"/>
                                <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"/>
                                <ehr:dic dicmeta="FS990001" code="${personInfo.paGroup}"/>
                                <c:out value="${personInfo.pahouseNumber}"></c:out>
                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <th>身份证号</th>
                        <td>${dm.idNo}<input type="hidden" name="idcard" readonly="readonly" value="${dm.idNo}"></td>

                    </tr>
                    <tr>
                        <c:if test="${type eq 1}">
                        <th>体检号</th>
                        <td>${dm.meNumber}<input type="hidden" name="physicalExamNo" readonly="readonly" value="${dm.meNumber}"></td>
                        </c:if>
                        <c:if test="${type eq 2}">
                            <input type="hidden" name="physicalExamNo" readonly="readonly" value="${dm.meNumber}">
                        </c:if>
                    </tr>
                    <%--<tr>
                        </tr>--%>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width:250px;"/>
                        <col />
                    </colgroup>
                    <tr>
                        <td><b>A1.</b> 性别：</td>
                        <td><ehr:dic-radio name="a1" dicmeta="GBT226112003" code="1,2"
                                                         value="${question.a1}"/></td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top"><b>A2.</b> 民族：</td>
                        <td>
                            <label><input type="radio" name="a2"
                                          value="1" ${question.a2 eq '1' ? 'checked':''}/>汉</label>
                            <label><input type="radio" name="a2"
                                          value="2" ${question.a2 eq '2' ? 'checked':''}/>回</label>
                            <label><input type="radio" name="a2"
                                          value="8" ${question.a2 eq '8' ? 'checked':''}/>其他</label>
                            <div id="a2A" ${question.a2 eq '8' ? '' : 'hidden'}>（注明<input type="text" name="a2A" value="${question.a2A}" style="width:100px;"/>）</div>
                        </td>
                    </tr>
                    <tr>
                        <td><b>A3.</b> 您的实足年龄？</td>
                        <td>
                            <tag:numberInput name="a3" value="${question.a3}" style="width:50px" reg="{'max':999}"/>岁
                        </td>
                    </tr>
                    <tr>
                        <td><b>A4.</b> 文化程度：</td>
                        <td>
                            <label><input type="radio" name="a4"
                                          value="1" ${question.a4 eq '1' ? 'checked':''}/>未上学</label>
                            <label><input type="radio" name="a4"
                                          value="2" ${question.a4 eq '2' ? 'checked':''}/>小学</label>
                            <label><input type="radio" name="a4"
                                          value="3" ${question.a4 eq '3' ? 'checked':''}/>初中</label>
                            <label><input type="radio" name="a4"
                                          value="4" ${question.a4 eq '4' ? 'checked':''}/>高中/中专</label>
                            <label><input type="radio" name="a4"
                                          value="5" ${question.a4 eq '5' ? 'checked':''}/>大专/大学</label>
                            <label><input type="radio" name="a4"
                                          value="6" ${question.a4 eq '6' ? 'checked':''}/>硕士以上</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>A5.</b> 婚姻状况：</td>
                        <td>
                            <label><input type="radio" name="a5" value="1" ${question.a5 eq '1' ? 'checked':''}/>结婚/同居</label>
                            <label><input type="radio" name="a5" value="2" ${question.a5 eq '2' ? 'checked':''}/>丧偶</label>
                            <label><input type="radio" name="a5" value="3" ${question.a5 eq '3' ? 'checked':''}/>离婚/分居</label>
                            <label><input type="radio" name="a5" value="4" ${question.a5 eq '4' ? 'checked':''}/>未婚</label>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top"><b>A6.</b> 职业：</td>
                        <td>
                            <label><input type="radio" name="a6" value="1" ${question.a6 eq '1' ? 'checked':''}/>企业工人（包括农民工）</label>
                            <label><input type="radio" name="a6" value="2" ${question.a6 eq '2' ? 'checked':''}/>国家机关及事业单位（管理人员/干部）</label>
                            <label><input type="radio" name="a6" value="3" ${question.a6 eq '3' ? 'checked':''}/>专业技术人员（医护人员、教师）</label>
                            <label><input type="radio" name="a6" value="4" ${question.a6 eq '4' ? 'checked':''}/>服务人员/三资企业及民营企业职员</label>
                            <label><input type="radio" name="a6" value="5" ${question.a6 eq '5' ? 'checked':''}/>三资企业及民营企业主及个体经营者</label>
                            <label><input type="radio" name="a6" value="6" ${question.a6 eq '6' ? 'checked':''}/>退离休人员/家庭妇女/无业人员</label>
                            <label><input type="radio" name="a6" value="7" ${question.a6 eq '7' ? 'checked':''}/>交通运输业人员</label>
                            <label><input type="radio" name="a6" value="8" ${question.a6 eq '8' ? 'checked':''}/>无正式工作的临时工</label>
                            <label><input type="radio" name="a6" value="9" ${question.a6 eq '9' ? 'checked':''}/>其他</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>A7.</b> 您的家庭人均月收入为一下哪个水平？</td>
                        <td>
                            <label><input type="radio" name="a7" value="1" ${question.a7 eq '1' ? 'checked':''}/>501～1000元</label>
                            <label><input type="radio" name="a7" value="2" ${question.a7 eq '2' ? 'checked':''}/>1001～2000元</label>
                            <label><input type="radio" name="a7" value="3" ${question.a7 eq '3' ? 'checked':''}/>2001～3000元</label>
                            <label><input type="radio" name="a7" value="4" ${question.a7 eq '4' ? 'checked':''}/>3001～4000元</label>
                            <label><input type="radio" name="a7" value="5" ${question.a7 eq '5' ? 'checked':''}/>4001及以上</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>A8.</b> 腰围和臀围：</td>
                        <td>
                            腰围：<tag:numberInput name="a8A" value="${question.a8A}" style="width:50px;" reg="{'max':999}"/>CM
                            臀围：<tag:numberInput name="a8B" value="${question.a8B}" style="width:50px;" reg="{'max':999}"/>CM
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>生活习惯</legend>
                <h5>（一）吸烟情况</h5>
                <table class="posttable">
                    <colgroup>
                        <col style="width:270px;"/>
                        <col />
                    </colgroup>
                    <tr>
                        <td colspan="2">
                            <b>B1.</b> 您一生中吸过至少100支烟吗(约合5包卷烟或2两烟叶)
                            <label><input type="radio" name="b1"
                                          value="1" ${question.b1 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b1"
                                          value="0" ${question.b1 eq '0' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B2.</b> 您目前吸烟吗？</td>
                        <td>
                            <label><input type="radio" name="b2"
                                          value="1" ${question.b2 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b2"
                                          value="0" ${question.b2 eq '0' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B3.</b> 您开始吸第一支烟的年龄？</td>
                        <td><tag:numberInput name="b3" value="${question.b3}" style="width:50px;" reg="{'max':999}"/>岁</td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B4.</b> 您多大年龄开始规律吸烟？</td>
                        <td>
                            <tag:numberInput name="b4" value="${question.b4}" style="width:50px;" reg="{'max':999}"/>岁
                            （00＝从未规律吸烟 99＝不详）
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B4.a.</b> 您大概吸烟多少年？</td>
                        <td>
                            <tag:numberInput name="b4A" value="${question.b4A}" style="width:50px;" reg="{'max':999}"/>年
                            （00＝从未规律吸烟 99＝不详）
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B5.</b> 您每天平均吸烟多少支？</td>
                        <td>
                            <tag:numberInput name="b5" value="${question.b5}" style="width:50px;" reg="{'max':99}"/>支/天
                            （00＝少于每天1支）
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B6.</b> 您多大年龄戒烟的？</td>
                        <td>
                            <tag:numberInput name="b6" value="${question.b6}" style="width:50px;" reg="{'max':99}"/>岁
                            （00＝未戒烟 99＝不详）
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>B7.</b> 您周围是否有人吸烟？（每日大于1小时）
                        </td>
                        <td>
                            <label><input type="radio" name="b7"
                                          value="1" ${question.b7 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b7"
                                          value="0" ${question.b7 eq '0' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                </table>
                <br>
                <h5>（二）饮酒情况（询问过去1年的饮酒状况）</h5>
                <table class="posttable">
                    <tr>
                        <td style="width: 250px;"><b>B8.</b> 您喝酒吗？</td>
                        <td>
                            <label><input type="radio" name="b8"
                                          value="1" ${question.b8 eq '1' ? 'checked':''}/>经常</label>
                            <label><input type="radio" name="b8"
                                          value="2" ${question.b8 eq '2' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="b8"
                                          value="3" ${question.b8 eq '3' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr class="b8skip">
                        <td colspan="2"><b>B9.</b> 过去12个月中，您饮过何种以下不同的酒？</td>
                    </tr>
                    <tr class="b8skip">
                        <td>
                            <select name="b9A">
                                <option value="0" ${question.b9A eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b9A eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b9A eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            a. 啤酒
                        </td>
                        <td style="width:400px;">
                            <label><input type="radio" name="b9A1"
                                          value="1" ${question.b9A1 eq '1' ? 'checked':''}/>大瓶600ml</label>
                            <label><input type="radio" name="b9A1"
                                          value="2" ${question.b9A1 eq '2' ? 'checked':''}/>小瓶300ml</label>
                            <label><input type="radio" name="b9A1"
                                          value="3" ${question.b9A1 eq '3' ? 'checked':''}/>易拉罐355ml</label>
                        </td>
                        <td>
                            <tag:numberInput name="b9A2" value="${question.b9A2}" style="width: 50px;" reg="{'max':12}"/>月/年
                            <tag:numberInput name="b9A3" value="${question.b9A3}" style="width: 50px;" reg="{'max':999}"/>次/月
                            <tag:numberInput name="b9A4" value="${question.b9A4}" style="width: 50px;" reg="{'max':9999}"/>ml/次
                        </td>
                    </tr>
                    <tr class="b8skip">
                        <td>
                            <select name="b9B">
                                <option value="0" ${question.b9B eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b9B eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b9B eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            b. 白酒
                        </td>
                        <td style="width:400px;">
                            <tag:numberInput name="b9B1" value="${question.b9B1}" style="width:50px;"/>度
                        </td>
                        <td>
                            <tag:numberInput name="b9B2" value="${question.b9B2}" style="width: 50px;"  reg="{'max':12}"/>月/年
                            <tag:numberInput name="b9B3" value="${question.b9B3}" style="width: 50px;" reg="{'max':999}"/>次/月
                            <tag:numberInput name="b9B4" value="${question.b9B4}" style="width: 50px;" reg="{'max':9999}"/>两/次
                        </td>
                    </tr>
                    <tr class="b8skip">
                        <td>
                            <select name="b9C">
                                <option value="0" ${question.b9C eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b9C eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b9C eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            c. 葡萄酒
                        </td>
                        <td style="width:400px;">
                        </td>
                        <td>
                            <tag:numberInput name="b9C1" value="${question.b9C1}" style="width: 50px;" reg="{'max':12}"/>月/年
                            <tag:numberInput name="b9C2" value="${question.b9C2}" style="width: 50px;" reg="{'max':999}"/>次/月
                            <tag:numberInput name="b9C3" value="${question.b9C3}" style="width: 50px;" reg="{'max':9999}"/>两/次
                        </td>
                    </tr>
                    <tr class="b8skip">
                        <td>
                            <select name="b9D">
                                <option value="0" ${question.b9D eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b9D eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b9D eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            d. 米酒或黄酒
                        </td>
                        <td style="width:400px;">
                        </td>
                        <td>
                            <tag:numberInput name="b9D1" value="${question.b9D1}" style="width: 50px;" reg="{'max':12}"/>月/年
                            <tag:numberInput name="b9D2" value="${question.b9D2}" style="width: 50px;" reg="{'max':999}"/>次/月
                            <tag:numberInput name="b9D3" value="${question.b9D3}" style="width: 50px;" reg="{'max':9999}"/>两/次
                        </td>
                    </tr>
                    <tr class="b8skip">
                        <td colspan="3">
                            <b>B10.</b> 您多大年龄开始规律饮酒的？（每年至少12次以上） 00＝从未规律饮酒 99＝不详
                            <tag:numberInput name="b10" value="${question.b10}" style="width:50px" reg="{'max':99}"/>岁
                        </td>
                    </tr>
                </table>
                <br>
                <h5>（三）膳食习惯（记录过去一年您摄入下列事物的频率和食用量）</h5>
                <table class="posttable">
                    <tr>
                        <td style="width:250px;"><b>食物</b></td>
                        <td style="width:350px;"><b>食用频率（选择其中一种）</b></td>
                        <td><b>食用量</b></td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B11.</b> 主食</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b11A" value="0" ${question.b11A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b11A" value="1" ${question.b11A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b11A" value="2" ${question.b11A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b11A" value="3" ${question.b11A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b11A" value="4" ${question.b11A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b11B" value="${question.b11B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b11C" value="${question.b11C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B12.</b> 猪牛羊肉</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b12A" value="0" ${question.b12A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b12A" value="1" ${question.b12A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b12A" value="2" ${question.b12A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b12A" value="3" ${question.b12A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b12A" value="4" ${question.b12A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b12B" value="${question.b12B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b12C" value="${question.b12C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B13.</b> 鸡、鸭肉</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b13A" value="0" ${question.b13A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b13A" value="1" ${question.b13A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b13A" value="2" ${question.b13A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b13A" value="3" ${question.b13A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b13A" value="4" ${question.b13A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b13B" value="${question.b13B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b13C" value="${question.b13C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B14.</b> 各种鱼类</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b14A" value="0" ${question.b14A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b14A" value="1" ${question.b14A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b14A" value="2" ${question.b14A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b14A" value="3" ${question.b14A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b14A" value="4" ${question.b14A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b14B" value="${question.b14B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b14C" value="${question.b14C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B15.</b> 牛奶、酸奶</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b15A" value="0" ${question.b15A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b15A" value="1" ${question.b15A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b15A" value="2" ${question.b15A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b15A" value="3" ${question.b15A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b15A" value="4" ${question.b15A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b15B" value="${question.b15B}" style="width:50px" reg="{'max':9999}"/>ml
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B16.</b> 新鲜水果</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b16A" value="0" ${question.b16A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b16A" value="1" ${question.b16A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b16A" value="2" ${question.b16A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b16A" value="3" ${question.b16A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b16A" value="4" ${question.b16A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b16B" value="${question.b16B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b16C" value="${question.b16C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B17.</b> 新鲜蔬菜</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b17A" value="0" ${question.b17A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b17A" value="1" ${question.b17A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b17A" value="2" ${question.b17A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b17A" value="3" ${question.b17A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b17A" value="4" ${question.b17A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b17B" value="${question.b17B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b17C" value="${question.b17C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B18.</b> 豆类食品</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b18A" value="0" ${question.b18A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b18A" value="1" ${question.b18A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b18A" value="2" ${question.b18A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b18A" value="3" ${question.b18A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b18A" value="4" ${question.b18A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b18B" value="${question.b18B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b18C" value="${question.b18C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B19.</b> 各种坚果</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b19A" value="0" ${question.b19A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b19A" value="1" ${question.b19A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b19A" value="2" ${question.b19A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b19A" value="3" ${question.b19A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b19A" value="4" ${question.b19A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b19B" value="${question.b19B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b19C" value="${question.b19C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B20.</b> 咸菜</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b20A" value="0" ${question.b20A eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b20A" value="1" ${question.b20A eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b20A" value="2" ${question.b20A eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b20A" value="3" ${question.b20A eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b20A" value="4" ${question.b20A eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b20B" value="${question.b20B}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b20C" value="${question.b20C}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width:350px;"/>
                        <col />
                    </colgroup>
                    <tr>
                        <td><b>B21.</b> 您是否经常喝茶？（每周至少3次，连续喝茶6个月以上）</td>
                        <td>
                            <label><input type="radio" name="b21"
                                          value="0" ${question.b21 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="b21"
                                          value="1" ${question.b21 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="b21skip">
                        <td style="vertical-align: top"><b>B21.a.</b> 您喝哪种茶？</td>
                        <td>
                            <label><input type="radio" name="b21A"
                                          value="1" ${question.b21A eq '0' ? 'checked':''}/>绿茶</label>
                            <label><input type="radio" name="b21A"
                                          value="2" ${question.b21A eq '2' ? 'checked':''}/>红茶（普洱、铁观音等）</label>
                            <label><input type="radio" name="b21A"
                                          value="8" ${question.b21A eq '8' ? 'checked':''}/>其他</label>
                            <div id="b21A1" ${question.b21A eq '8' ? '' : 'hidden'}>（注明<input type="text" name="b21A1" value="${question.b21A1}" style="width:100px;"/>）</div>
                        </td>
                    </tr>
                    <tr class="b21skip">
                        <td><b>B21.b.</b> 您本人每月喝几两茶叶？</td>
                        <td><tag:numberInput name="b21B" value="${question.b21B}" style="width:50px" reg="{'max':999}"/>两</td>
                    </tr>
                    <tr class="b21skip">
                        <td><b>B21.c.</b> 您每天泡几次茶（指换几次茶叶或换新的茶袋）</td>
                        <td><tag:numberInput name="b21C" value="${question.b21C}" style="width:50px" reg="{'max':99}"/>次</td>
                    </tr>
                    <tr>
                        <td><b>B22.</b> 您的口味与当地一般人比：</td>
                        <td>
                            <label><input type="radio" name="b22" value="1" ${question.b22 eq '1' ? 'checked':''}/>偏咸</label>
                            <label><input type="radio" name="b22" value="2" ${question.b22 eq '2' ? 'checked':''}/>差不多</label>
                            <label><input type="radio" name="b22" value="3" ${question.b22 eq '3' ? 'checked':''}/>偏淡</label>
                            <label><input type="radio" name="b22" value="4" ${question.b22 eq '4' ? 'checked':''}/>偏甜</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <tr>
                        <td style="width:250px;"><b>高脂膳食：</b></td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B23.</b> 您最近一周吃肉是否＜75g/天</td>
                        <td>
                            <label><input type="radio" name="b23"
                                          value="0" ${question.b23 eq '0' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b23"
                                          value="1" ${question.b23 eq '1' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>B24.</b> 您吃肉的种类是：</td>
                        <td>
                            <label><input type="radio" name="b24" value="0" ${question.b24 eq '0' ? 'checked':''}/>瘦肉</label>
                            <label><input type="radio" name="b24" value="1" ${question.b24 eq '1' ? 'checked':''}/>肥瘦肉</label>
                            <label><input type="radio" name="b24" value="2" ${question.b24 eq '2' ? 'checked':''}/>肥肉</label>
                            <label><input type="radio" name="b24" value="3" ${question.b24 eq '3' ? 'checked':''}/>内脏</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>B25.</b> 您最近一周吃蛋的个数：</td>
                        <td>
                            <label><input type="radio" name="b25" value="0" ${question.b25 eq '0' ? 'checked':''}/>0-3个/周</label>
                            <label><input type="radio" name="b25" value="1" ${question.b25 eq '1' ? 'checked':''}/>3-7个/周</label>
                            <label><input type="radio" name="b25" value="2" ${question.b25 eq '2' ? 'checked':''}/>7个以上/周</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>B26.</b> 您近一周吃油炸食品数量：</td>
                        <td>
                            <label><input type="radio" name="b26" value="0" ${question.b26 eq '0' ? 'checked':''}/>未吃</label>
                            <label><input type="radio" name="b26" value="1" ${question.b26 eq '1' ? 'checked':''}/>1-4次/周</label>
                            <label><input type="radio" name="b26" value="2" ${question.b26 eq '2' ? 'checked':''}/>5-7次/周</label>
                            <label><input type="radio" name="b26" value="3" ${question.b26 eq '3' ? 'checked':''}/>7次以上/周</label>
                        </td>
                    <tr>
                        <td><b>B27.</b> 您近一周吃奶油糕点的数量：</td>
                        <td>
                            <label><input type="radio" name="b27" value="0" ${question.b27 eq '0' ? 'checked':''}/>未吃</label>
                            <label><input type="radio" name="b27" value="1" ${question.b27 eq '1' ? 'checked':''}/>1-4次/周</label>
                            <label><input type="radio" name="b27" value="2" ${question.b27 eq '2' ? 'checked':''}/>5-7次/周</label>
                            <label><input type="radio" name="b27" value="3" ${question.b27 eq '3' ? 'checked':''}/>7次以上/周</label>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>家族史、月经史和疾病史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width:100px;"/>
                        <col style="width:60px;"/>
                        <col style="width:60px;"/>
                        <col style="width:100px;"/>
                        <col style="width:100px;"/>
                    </colgroup>
                    <tr>
                        <td colspan="5"><b>家族史</b> 兄弟姐妹和子女填写具体人数，均包括本人。9=不详</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>父</td>
                        <td>母</td>
                        <td>兄弟姐妹的发病人数/总人数</td>
                        <td>子女的发病人数/总人数</td>
                    </tr>
                    <tr>
                        <td><b>C1.</b> 高血压</td>
                        <td>
                            <select name="c1A">
                                <option value="0" ${question.c1A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c1A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c1B">
                                <option value="0" ${question.c1B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c1B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c1C" value="${question.c1C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c1D" value="${question.c1D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c1E" value="${question.c1E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c1F" value="${question.c1F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                    <tr>
                        <td><b>C2.</b> 高血脂症</td>
                        <td>
                            <select name="c2A">
                                <option value="0" ${question.c2A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c2A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c2B">
                                <option value="0" ${question.c2B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c2B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c2C" value="${question.c2C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c2D" value="${question.c2D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c2E" value="${question.c2E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c2F" value="${question.c2F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                    <tr>
                        <td><b>C3.</b> 糖尿病</td>
                        <td>
                            <select name="c3A">
                                <option value="0" ${question.c3A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c3A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c3B">
                                <option value="0" ${question.c3B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c3B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c3C" value="${question.c3C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c3D" value="${question.c3D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c3E" value="${question.c3E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c3F" value="${question.c3F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                    <tr>
                        <td><b>C4.</b> 冠心病</td>
                        <td>
                            <select name="c4A">
                                <option value="0" ${question.c4A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c4A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c4B">
                                <option value="0" ${question.c4B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c4B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c4C" value="${question.c4C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c4D" value="${question.c4D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c4E" value="${question.c4E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c4F" value="${question.c4F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                    <tr>
                        <td><b>C5.</b> 脑卒中</td>
                        <td>
                            <select name="c5A">
                                <option value="0" ${question.c5A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c5A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c5B">
                                <option value="0" ${question.c5B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c5B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c5C" value="${question.c5C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c5D" value="${question.c5D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c5E" value="${question.c5E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c5F" value="${question.c5F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 250px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><b>月经和生育史（只对女性）</b></td>
                    </tr>
                    <tr>
                        <td><b>C6.</b> 您是否已绝经？</td>
                        <td>
                            <label><input type="radio" name="c6"
                                          value="0" ${question.c6 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c6"
                                          value="1" ${question.c6 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c6"
                                          value="2" ${question.c6 eq '2' ? 'checked':''}/>手术（切除子宫、卵巢）</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C6.1.</b> 如果否，您现在是否怀孕？</td>
                        <td>
                            <label><input type="radio" name="c6A"
                                          value="0" ${question.c6A eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c6A"
                                          value="1" ${question.c6A eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c6A"
                                          value="2" ${question.c6A eq '2' ? 'checked':''}/>可能</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C6.2.</b> 如果是，您是多大岁数绝经的？</td>
                        <td><tag:numberInput name="c6B" value="${question.c6B}" style="width:50px;" reg="{'max':99}"/>岁</td>
                    </tr>
                    <tr>
                        <td><b>C7.</b> 您第一次来月经的年龄是多大？</td>
                        <td><tag:numberInput name="c7" value="${question.c7}" style="width:50px;" reg="{'max':99}"/>岁</td>
                    </tr>
                    <tr>
                        <td><b>C8.</b> 您服用过避孕药吗？</td>
                        <td>
                            <label><input type="radio" name="c8"
                                          value="0" ${question.c8 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c8"
                                          value="1" ${question.c8 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c8"
                                          value="9" ${question.c8 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C9.</b> 您怀孕过吗？</td>
                        <td>
                            <label><input type="radio" name="c9"
                                          value="0" ${question.c9 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c9"
                                          value="1" ${question.c9 eq '1' ? 'checked':''}/>是</label>
                            （包括流产、死产、人工受孕、堕胎、活产和正在怀孕）
                        </td>
                    </tr>
                    <tr>
                        <td><b>C10.</b> 您怀孕过多少次？ 99＝不详</td>
                        <td><tag:numberInput name="c10" value="${question.c10}" style="width:50px;" reg="{'max':99}"/>次</td>
                    </tr>
                    <tr>
                        <td><b>C11.</b> 您有过哺乳经历么？</td>
                        <td>
                            <label><input type="radio" name="c11"
                                          value="0" ${question.c11 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c11"
                                          value="1" ${question.c11 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c11"
                                          value="9" ${question.c11 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><b>疾病史</b></td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>（一）高血压病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C12.</b> 首次确诊的年龄</td>
                        <td><tag:numberInput name="c12" value="${question.c12}" style="width:50px;" reg="{'max':99}"/>岁</td>
                    </tr>
                    <tr>
                        <td><b>C13.a.</b> 您现在是否服用降压药？</td>
                        <td>
                            <label><input type="radio" name="c13A"
                                          value="0" ${question.c13A eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c13A"
                                          value="1" ${question.c13A eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c13skip">
                        <td><b>C13.b.</b> 您是否遵医嘱服降压药？</td>
                        <td>
                            <label><input type="radio" name="c13B"
                                          value="0" ${question.c13B eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c13B"
                                          value="1" ${question.c13B eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c13skip">
                        <td><b>C14.</b> 您服用降压药已有多长时间了？00=少于1年</td>
                        <td><tag:numberInput name="c14" value="${question.c14}" style="width:50px;" reg="{'max':99}"/>年</td>
                    </tr>
                    <tr>
                        <td><b>C15.</b> 您患高血压后，采取了哪些措施来控制血压：</td>
                        <td>
                            <label><input type="checkbox" name="c15" value="1" ${fn:contains(question.c15, '1') ? 'checked':''}/>1.按医嘱服药</label>
                            <label><input type="checkbox" name="c15" value="2" ${fn:contains(question.c15, '2') ? 'checked':''}/>2.少盐的摄入</label>
                            <label><input type="checkbox" name="c15" value="3" ${fn:contains(question.c15, '3') ? 'checked':''}/>3.间断服药</label>
                            <label><input type="checkbox" name="c15" value="4" ${fn:contains(question.c15, '4') ? 'checked':''}/>4.做适宜的运动</label>
                            <label><input type="checkbox" name="c15" value="5" ${fn:contains(question.c15, '5') ? 'checked':''}/>5.控制体重</label>
                            <label><input type="checkbox" name="c15" value="6" ${fn:contains(question.c15, '6') ? 'checked':''}/>6.不用治疗</label>
                            <label><input type="checkbox" name="c15" value="7" ${fn:contains(question.c15, '7') ? 'checked':''}/>7.其他</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>（二）高脂血症病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C16.</b> 医生告诉过您血脂高吗？</td>
                        <td>
                            <label><input type="radio" name="c16"
                                          value="0" ${question.c16 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c16"
                                          value="1" ${question.c16 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c16"
                                          value="9" ${question.c16 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c16skip">
                        <td><b>C17.a.</b> 您是否服用降脂药？</td>
                        <td>
                            <label><input type="radio" name="c17A"
                                          value="0" ${question.c17A eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c17A"
                                          value="1" ${question.c17A eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c16skip">
                        <td><b>C17.b.</b> 您服用降脂药已经多长时间了？</td>
                        <td>
                            <tag:numberInput name="c17B" value="${question.c17B}" style="width:50px;" reg="{'max':99}"/>年（00=少于1年）
                        </td>
                    </tr>
                    <tr class="c16skip">
                        <td><b>C17.c.</b> 最近两周您服过降脂药吗？</td>
                        <td>
                            <label><input type="radio" name="c17C"
                                          value="0" ${question.c17C eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c17C"
                                          value="1" ${question.c17C eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><b>（三）糖尿病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C18.</b> 医生曾告诉过你有糖尿病吗？</td>
                        <td>
                            <label><input type="radio" name="c18"
                                          value="0" ${question.c18 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c18"
                                          value="1" ${question.c18 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c18"
                                          value="9" ${question.c18 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C18.a.</b> 诊断日期</td>
                        <td><tag:numberInput name="c18A" value="${question.c18A}" style="width:50px;" reg="{'length':4,'max':9999}"/>年</td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C18.b.</b> 诊断时的空腹血糖值：</td>
                        <td>
                            <tag:numberInput name="c18B1" value="${question.c18B1}" style="width:50px;" reg="{'max':9999}"/>mg/dl 或
                            <tag:numberInput name="c18B2" value="${question.c18B2}" style="width:50px;" reg="{'max':9999}"/>mmol/L
                        </td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C18.c.</b> 诊断时的餐后2小时糖耐量：</td>
                        <td>
                            <tag:numberInput name="c18C1" value="${question.c18C1}" style="width:50px;" reg="{'max':9999}"/>mg/dl 或
                            <tag:numberInput name="c18C2" value="${question.c18C2}" style="width:50px;" reg="{'max':9999}"/>mmol/L
                        </td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C19.</b> 并发症（此题可多选）</td>
                        <td>
                            <label><input type="checkbox" name="c19" value="1" ${fn:contains(question.c19, '1') ? 'checked':''}/>无</label>
                            <label><input type="checkbox" name="c19" value="2" ${fn:contains(question.c19, '2') ? 'checked':''}/>糖尿病眼底病变</label>
                            <label><input type="checkbox" name="c19" value="3" ${fn:contains(question.c19, '3') ? 'checked':''}/>糖尿病肾病</label>
                            <label><input type="checkbox" name="c19" value="4" ${fn:contains(question.c19, '4') ? 'checked':''}/>糖尿病足</label>
                            <label><input type="checkbox" name="c19" value="5" ${fn:contains(question.c19, '5') ? 'checked':''}/>糖尿病外周神经病变</label>
                            <label><input type="checkbox" name="c19" value="8" ${fn:contains(question.c19, '8') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c19" value="9" ${fn:contains(question.c19, '9') ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C20.</b> 医生第一次告诉你糖尿病时，您年龄多大？</td>
                        <td><tag:numberInput name="c20" value="${question.c20}" style="width:50px;" reg="{'max':99}"/>岁（不包括孕期内糖尿病）</td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C21.</b> 您目前使用胰岛素吗？</td>
                        <td>
                            <label><input type="radio" name="c21"
                                          value="0" ${question.c21 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c21"
                                          value="1" ${question.c21 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C22.</b> 您使用胰岛素多长时间了？ 00=少于1年</td>
                        <td><tag:numberInput name="c22" value="${question.c22}" style="width:50px;" reg="{'max':99}"/>年</td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C23.</b> 您目前服用口服降糖药吗？</td>
                        <td>
                            <label><input type="radio" name="c23"
                                          value="0" ${question.c23 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c23"
                                          value="1" ${question.c23 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c18skip">
                        <td><b>C24.</b> 您服用口服降糖药多长时间了？ 00=少于1年</td>
                        <td><tag:numberInput name="c24" value="${question.c24}" style="width:50px;" reg="{'max':99}"/>年</td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（四）脑卒中病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C25.</b> 医生是否诊断过您有脑卒中？</td>
                        <td>
                            <label><input type="radio" name="c25"
                                          value="0" ${question.c25 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c25"
                                          value="1" ${question.c25 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c25"
                                          value="9" ${question.c25 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c25skip">
                        <td><b>C26.</b> 脑卒中类型（可多选）</td>
                        <td>
                            <label><input type="checkbox" name="c26" value="1" ${fn:contains(question.c26, '1') ? 'checked':''}/>脑梗塞</label>
                            <label><input type="checkbox" name="c26" value="2" ${fn:contains(question.c26, '2') ? 'checked':''}/>脑出血</label>
                            <label><input type="checkbox" name="c26" value="8" ${fn:contains(question.c26, '8') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c26" value="9" ${fn:contains(question.c26, '9') ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（五）冠心病病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C27.</b> 医生是否诊断过您有冠心病？</td>
                        <td>
                            <label><input type="radio" name="c27"
                                          value="0" ${question.c27 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c27"
                                          value="1" ${question.c27 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c27"
                                          value="9" ${question.c27 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C28.</b> 冠心病类型（可多选）</td>
                        <td>
                            <label><input type="checkbox" name="c28" value="1" ${fn:contains(question.c28, '1') ? 'checked':''}/>心肌梗塞</label>
                            <label><input type="checkbox" name="c28" value="2" ${fn:contains(question.c28, '2') ? 'checked':''}/>心绞痛</label>
                            <label><input type="checkbox" name="c28" value="3" ${fn:contains(question.c28, '3') ? 'checked':''}/>心律失常</label>
                            <label><input type="checkbox" name="c28" value="4" ${fn:contains(question.c28, '4') ? 'checked':''}/>心衰</label>
                            <label><input type="checkbox" name="c28" value="8" ${fn:contains(question.c28, '8') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c28" value="9" ${fn:contains(question.c28, '9') ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 330px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（六）其他疾病史</b></td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top"><b>C29.</b> 医生是否诊断过您患有恶性肿瘤？</td>
                        <td>
                            <label><input type="radio" name="c29"
                                          value="0" ${question.c29 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c29"
                                          value="1" ${question.c29 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c29"
                                          value="9" ${question.c29 eq '9' ? 'checked':''}/>不详</label>
                            <div id="c29A" ${question.c29 eq '1' ? '' : 'hidden'}>
                                恶性肿瘤名称 <input type="text" name="c29A" value="${question.c29A}" style="width:100px;"/>
                                ICD-10编码 <input type="text" name="c29B" value="${question.c29B}" style="width:100px;"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C30.</b> 医生是否诊断过您患有肾脏疾病？</td>
                        <td>
                            <label><input type="radio" name="c30"
                                          value="0" ${question.c30 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c30"
                                          value="1" ${question.c30 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c30"
                                          value="9" ${question.c30 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c30skip">
                        <td><b>C31.</b> 肾脏疾病类型</td>
                        <td>
                            <label><input type="radio" name="c31" value="1" ${question.c31 eq '1' ? 'checked':''}/>肾小球或肾盂肾炎</label>
                            <label><input type="radio" name="c31" value="2" ${question.c31 eq '2' ? 'checked':''}/>糖尿病肾病</label>
                            <label><input type="radio" name="c31" value="3" ${question.c31 eq '3' ? 'checked':''}/>高血压肾病</label>
                            <label><input type="radio" name="c31" value="8" ${question.c31 eq '8' ? 'checked':''}/>其他</label>
                            <label><input type="radio" name="c31" value="9" ${question.c31 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c30skip">
                        <td><b>C32.</b> 医生是否诊断过您患有肾功能衰竭或终末期肾病？</td>
                        <td>
                            <label><input type="radio" name="c32"
                                          value="0" ${question.c32 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c32"
                                          value="1" ${question.c32 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c32"
                                          value="9" ${question.c32 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（七）血压血糖了解情况</b></td>
                    </tr>
                    <tr>
                        <td><b>C33.</b> 请问您知道自己的血压情况吗？</td>
                        <td>
                            <label><input type="radio" name="c33"
                                          value="1" ${question.c33 eq '1' ? 'checked':''}/>不知道</label>
                            <label><input type="radio" name="c33"
                                          value="2" ${question.c33 eq '2' ? 'checked':''}/>知道</label>
                            <input type="text" name="c33A" value="${question.c33A}" style="width:100px;"/>mm/hg（大概值）
                        </td>
                    </tr>
                    <tr>
                        <td><b>C34.</b> 请问您知道自己的血糖情况吗？</td>
                        <td>
                            <label><input type="radio" name="c34"
                                          value="1" ${question.c34 eq '1' ? 'checked':''}/>不知道</label>
                            <label><input type="radio" name="c34"
                                          value="2" ${question.c34 eq '2' ? 'checked':''}/>知道</label>
                            <tag:numberInput name="c34A" value="${question.c34A}" style="width:100px;" reg="{'max':9999}"/>mmol/l（大概值）
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>体力活动（最近1年的体力活动状况）</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 430px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><b>D1.</b> 您上班时每天的体力活动强度和时间情况（无此活动填“0”小时）</td>
                    </tr>
                    <tr>
                        <td><b>D1.1.</b> 重体力劳动（人力搬运、建筑、采矿、种地、炼钢等）</td>
                        <td>
                            每天<tag:numberInput name="d1A1" value="${question.d1A1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d1A2" value="${question.d1A2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D1.2.</b> 中等体力劳动（货车驾驶、电工、钳工、木工等）</td>
                        <td>
                            每天<tag:numberInput name="d1B1" value="${question.d1B1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d1B2" value="${question.d1B2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D1.3.</b> 轻体力劳动（以站为主：商店售货、教学、实验室等）</td>
                        <td>
                            每天<tag:numberInput name="d1C1" value="${question.d1C1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d1C2" value="${question.d1C2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D1.4.</b> 极轻体力劳动（以坐为主：办公室、电脑、组装工等）</td>
                        <td>
                            每天<tag:numberInput name="d1D1" value="${question.d1D1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d1D2" value="${question.d1D2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>D2.</b> 您每天上下班主要采用的方式及其时间（无此活动填“0”小时）</td>
                    </tr>
                    <tr>
                        <td><b>1.</b> 步行</td>
                        <td>
                            每天<tag:numberInput name="d2A1" value="${question.d2A1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d2A2" value="${question.d2A2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>2.</b> 自行车</td>
                        <td>
                            每天<tag:numberInput name="d2B1" value="${question.d2B1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d2B2" value="${question.d2B2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>3.</b> 公交、地铁、班车</td>
                        <td>
                            每天<tag:numberInput name="d2C1" value="${question.d2C1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d2C2" value="${question.d2C2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>4.</b> 自驾车、电动车、摩托车</td>
                        <td>
                            每天<tag:numberInput name="d2D1" value="${question.d2D1}" style="width:50px;" reg="{'max':24}"/>小时
                                <tag:numberInput name="d2D2" value="${question.d2D2}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>D3.</b> 您平时每周在家里进行家务劳动的情况（无此活动填“0”小时）</td>
                    </tr>
                    <tr>
                        <td>较重度家务劳动（种地、搬运重物、挑水等）</td>
                        <td>
                            <tag:numberInput name="d3A1" value="${question.d3A1}" style="width:50px;" reg="{'max':7}"/>天/周，
                            每天<tag:numberInput name="d3A2" value="${question.d3A2}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d3A3" value="${question.d3A3}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td>一般家务劳动（烹饪、清洁、带孩子、购物等）</td>
                        <td>
                            <tag:numberInput name="d3B1" value="${question.d3B1}" style="width:50px;" reg="{'max':7}"/>天/周，
                            每天<tag:numberInput name="d3B2" value="${question.d3B2}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d3B3" value="${question.d3B3}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D4.1.</b> 过去30天您是否参加过任何体育锻炼或运动？</td>
                        <td>
                            <label><input type="radio" name="d4A"
                                          value="1" ${question.d4A eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="d4A"
                                          value="2" ${question.d4A eq '2' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="d4A"
                                          value="9" ${question.d4A eq '9' ? 'checked':''}/>记不清</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>D5.</b> 您进行下述体育锻炼或休闲活动的情况（无此活动填“0”小时，少于每年1次忽略不计）</td>
                    </tr>
                    <tr>
                        <td><b>D5.1.</b> 重度体力活动（登山、负重跑或快跑、骑快车等剧烈运动）</td>
                        <td>
                            <tag:numberInput name="d5A1" value="${question.d5A1}" style="width:50px;" reg="{'max':12}"/>月/年，
                            <tag:numberInput name="d5A2" value="${question.d5A2}" style="width:50px;" reg="{'max':31}"/>天/月，
                            每天<tag:numberInput name="d5A3" value="${question.d5A3}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d5A4" value="${question.d5A4}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D5.2.</b> 中度体力活动（慢跑、快步走、秧歌、跳舞、健身操、游泳、球类）</td>
                        <td>
                            <tag:numberInput name="d5B1" value="${question.d5B1}" style="width:50px;" reg="{'max':12}"/>月/年，
                            <tag:numberInput name="d5B2" value="${question.d5B2}" style="width:50px;" reg="{'max':31}"/>天/月，
                            每天<tag:numberInput name="d5B3" value="${question.d5B3}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d5B4" value="${question.d5B4}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D5.3.</b> 轻度体力活动（散步、气功、伸展运动）</td>
                        <td>
                            <tag:numberInput name="d5C1" value="${question.d5C1}" style="width:50px;" reg="{'max':12}"/>月/年，
                            <tag:numberInput name="d5C2" value="${question.d5C2}" style="width:50px;" reg="{'max':31}"/>天/月，
                            每天<tag:numberInput name="d5C3" value="${question.d5C3}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d5C4" value="${question.d5C4}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D6. </b> 您每天在家的其他活动情况</td>
                    </tr>
                    <tr>
                        <td><b>D6.1.</b>看电视</td>
                        <td>
                            <tag:numberInput name="d6A1" value="${question.d6A1}" style="width:50px;" reg="{'max':7}"/>天/周，
                            每天<tag:numberInput name="d6A2" value="${question.d6A2}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d6A3" value="${question.d6A3}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D6.2.</b>其他静息活动（坐或躺：看书、吃饭、聊天、打牌等）</td>
                        <td>
                            <tag:numberInput name="d6B1" value="${question.d6B1}" style="width:50px;" reg="{'max':7}"/>天/周，
                            每天<tag:numberInput name="d6B2" value="${question.d6B2}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d6B3" value="${question.d6B3}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D7.1.</b> 您的睡眠质量如何：</td>
                        <td>日均睡<tag:numberInput name="d7A" value="${question.d7A}" style="width:50px;" reg="{'max':24}"/>小时/天</td>
                    </tr>
                    <tr>
                        <td><b>D7.2.</b> 睡眠障碍：</td>
                        <td>
                            <label><input type="radio" name="d7B" value="1" ${question.d7B eq '1' ? 'checked':''}/>无</label>
                            <label><input type="radio" name="d7B" value="2" ${question.d7B eq '2' ? 'checked':''}/>入睡困难</label>
                            <label><input type="radio" name="d7B" value="3" ${question.d7B eq '3' ? 'checked':''}/>早醒</label>
                            <label><input type="radio" name="d7B" value="4" ${question.d7B eq '4' ? 'checked':''}/>多醒</label>
                            <label><input type="radio" name="d7B" value="5" ${question.d7B eq '5' ? 'checked':''}/>其他</label>
                        </td>
                    </tr>
                </table>
            </fieldset>

            <hr>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                    <col style="width: 15%"/>
                    <col style="width: 35%"/>
                </colgroup>
                <tr>
                    <th>调查员</th>
                    <td><input type="text" name="surveyer" value="${question.surveyer}"/></td>
                    <th>调查日期</th>
                    <td>
                    <%-- <tag:dateInput name="surveyDt" nullToToday="true" date="${question.surveyDt}"/> --%>
                    <input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择日期" name="surveyDt" id="surveyDt" value="<fmt:formatDate value='${question.surveyDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#surveyDt' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
  });
</script>