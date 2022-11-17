<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-4-18
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk135/question/editLastQuestion.js" type="text/javascript"></script>
<div class="toolbar" align="right">
    <a href="javascript:void(0)" id="backToSearchBtn"><b class="fanhui">返回</b></a>
<c:if test="${dm.appraiseResult ne 1}" >
    <a href="javascript:void(0)" id="saveQuestionBtn"><b class="baocun">保存</b></a>
    <c:if test="${abc ne 1}">
    <a href="javascript:void(0)" onclick="question135.deleteQuestion('${question.id}', 2)"><b class="zuofei">删除</b></a>
    </c:if>
</c:if>
        </div>
<div class="postcontent">
    <i class="popno"><i class="popno">慢性病社区综合防治调查问卷终极</i></i>
    <div class="postdiv">
        <form id="questionForm" action="">
            <input type="hidden" name="id" value="${question.id}">
            <fieldset>
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
                        <td>${dm.idNo}<input type="hidden" name="idNo" readonly="readonly" value="${dm.idNo}"></td>
                        <th>体检号</th>
                        <td>${dm.meNumber}<input type="hidden" name="physicalExamNo" readonly="readonly" value="${dm.meNumber}"></td>
                    </tr>
                    <tr>
                        <th>手机</th>
                        <td><input type="text" name="cellPhone" value="${question.cellPhone}"/></td>
                        <th>联系人手机</th>
                        <td><input type="text" name="contactCellPhone" value="${question.contactCellPhone}"/></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset id="part1">
                <legend>一、一般情况</legend>
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
                        <td><b>A3.</b> 婚姻状况：</td>
                        <td>
                            <label><input type="radio" name="a3" value="1" ${question.a3 eq '1' ? 'checked':''}/>结婚/同居</label>
                            <label><input type="radio" name="a3" value="2" ${question.a3 eq '2' ? 'checked':''}/>丧偶</label>
                            <label><input type="radio" name="a3" value="3" ${question.a3 eq '3' ? 'checked':''}/>离婚/分居</label>
                            <label><input type="radio" name="a3" value="4" ${question.a3 eq '4' ? 'checked':''}/>未婚</label>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top"><b>A4.</b> 职业：</td>
                        <td>
                            <label><input type="radio" name="a4" value="1" ${question.a4 eq '1' ? 'checked':''}/>企业工人（包括农民工）</label>
                            <label><input type="radio" name="a4" value="2" ${question.a4 eq '2' ? 'checked':''}/>国家机关及事业单位（管理人员/干部）</label>
                            <label><input type="radio" name="a4" value="3" ${question.a4 eq '3' ? 'checked':''}/>专业技术人员（医护人员、教师）</label>
                            <label><input type="radio" name="a4" value="4" ${question.a4 eq '4' ? 'checked':''}/>服务人员/三资企业及民营企业职员</label>
                            <label><input type="radio" name="a4" value="5" ${question.a4 eq '5' ? 'checked':''}/>三资企业及民营企业主及个体经营者</label>
                            <label><input type="radio" name="a4" value="6" ${question.a4 eq '6' ? 'checked':''}/>退离休人员/家庭妇女/无业人员</label>
                            <label><input type="radio" name="a4" value="7" ${question.a4 eq '7' ? 'checked':''}/>交通运输业人员</label>
                            <label><input type="radio" name="a4" value="8" ${question.a4 eq '8' ? 'checked':''}/>无正式工作的临时工</label>
                            <label><input type="radio" name="a4" value="9" ${question.a4 eq '9' ? 'checked':''}/>其他</label>
                            <div id="a4A" ${question.a4 eq '9' ? '' : 'hidden'}>（注明<input type="text" name="a4A" value="${question.a4A}" style="width:100px;"/>）</div>
                        </td>
                    </tr>
                    <tr>
                        <td><b>A5.</b> 您的家庭人均月收入为一下哪个水平？</td>
                        <td>
                            <label><input type="radio" name="a5" value="1" ${question.a5 eq '1' ? 'checked':''}/>501～1000元</label>
                            <label><input type="radio" name="a5" value="2" ${question.a5 eq '2' ? 'checked':''}/>1001～2000元</label>
                            <label><input type="radio" name="a5" value="3" ${question.a5 eq '3' ? 'checked':''}/>2001～3000元</label>
                            <label><input type="radio" name="a5" value="4" ${question.a5 eq '4' ? 'checked':''}/>3001～4000元</label>
                            <label><input type="radio" name="a5" value="5" ${question.a5 eq '5' ? 'checked':''}/>4001及以上</label>
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top"><b>A6.</b> 医疗费用情况？</td>
                        <td>
                            <label><input type="radio" name="a6" value="1" ${question.a6 eq '1' ? 'checked':''}/>公费医疗</label>
                            <label><input type="radio" name="a6" value="2" ${question.a6 eq '2' ? 'checked':''}/>职工医疗保险</label>
                            <label><input type="radio" name="a6" value="3" ${question.a6 eq '3' ? 'checked':''}/>商业医疗保险</label>
                            <label><input type="radio" name="a6" value="4" ${question.a6 eq '4' ? 'checked':''}/>自费</label>
                            <label><input type="radio" name="a6" value="5" ${question.a6 eq '5' ? 'checked':''}/>合作医疗</label>
                            <label><input type="radio" name="a6" value="6" ${question.a6 eq '6' ? 'checked':''}/>其他</label>
                            <div id="a6A" ${question.a6 eq '6' ? '' : 'hidden'}>（注明<input type="text" name="a6A" value="${question.a6A}" style="width:100px;"/>）</div>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset id="part2">
                <legend>二、生活习惯</legend>
                <h3>（一）吸烟情况</h3>
                <table class="posttable">
                    <colgroup>
                        <col style="width:300px;"/>
                        <col />
                    </colgroup>
                    <tr>
                        <td><b>B1.</b> 您目前吸烟吗？</td>
                        <td>
                            <label><input type="radio" name="b1"
                                          value="1" ${question.b1 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b1"
                                          value="2" ${question.b1 eq '2' ? 'checked':''}/>以前吸</label>
                            <label><input type="radio" name="b1"
                                          value="0" ${question.b1 eq '0' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>b5.</b> 您大概吸烟多少年？</td>
                        <td>
                            <tag:numberInput name="b5" value="${question.b5}" style="width:50px;" reg="{'max':999}"/>年
                            （00＝从未规律吸烟 99＝不详）
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B3.</b> 您每天平均吸烟多少支？</td>
                        <td>
                            <tag:numberInput name="b3" value="${question.b3}" style="width:50px;" reg="{'max':99}"/>支/天
                            （00＝少于每天1支）
                        </td>
                    </tr>
                    <tr class="b1skip">
                        <td><b>B4.</b> 您多大年龄戒烟的？</td>
                        <td>
                            <tag:numberInput name="b4" value="${question.b4}" style="width:50px;" reg="{'max':99}"/>岁
                            （00＝未戒烟 99＝不详）
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>B5.</b> 您周围是否有人吸烟？（每日大于1小时）
                        </td>
                        <td>
                            <label><input type="radio" name="b5"
                                          value="1" ${question.b5 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b5"
                                          value="0" ${question.b5 eq '0' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                </table>
                <h3>（二）饮酒情况（过去1年的饮酒状况）</h3>
                <table class="posttable">
                    <colgroup>
                        <col style="width:300px;"/>
                        <col />
                    </colgroup>
                    <tr>
                        <td><b>B6.</b> 您喝酒吗？</td>
                        <td>
                            <label><input type="radio" name="b6"
                                          value="1" ${question.b6 eq '1' ? 'checked':''}/>经常</label>
                            <label><input type="radio" name="b6"
                                          value="2" ${question.b6 eq '2' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="b6"
                                          value="3" ${question.b6 eq '3' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr class="b6skip">
                        <td style="vertical-align: top"><b>B7.</b> 过去12个月中，您饮过何种以下不同的酒？</td>
                        <td>
                            <select name="b7A">
                                <option value="0" ${question.b7A eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b7A eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b7A eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            a. 啤酒 <br>
                            <select name="b7B">
                                <option value="0" ${question.b7B eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b7B eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b7B eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            b. 白酒 <br>
                            <select name="b7C">
                                <option value="0" ${question.b7C eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b7C eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b7C eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            c. 葡萄酒 <br>
                            <select name="b7D">
                                <option value="0" ${question.b7D eq '0' ? 'selected':''}>不饮</option>
                                <option value="1" ${question.b7D eq '1' ? 'selected':''}>饮</option>
                                <option value="9" ${question.b7D eq '9' ? 'selected':''}>不知道</option>
                            </select>
                            d. 米酒或黄酒
                        </td>
                    </tr>
                    <tr class="b6skip">
                        <td colspan="2">
                            <b>B8.</b> 您多大年龄开始规律饮酒的？（每年至少12次以上） 00＝从未规律饮酒 99＝不详
                            <tag:numberInput name="b8" value="${question.b8}" style="width:50px" reg="{'max':99}"/>岁
                        </td>
                    </tr>
                </table>
                <h3>（三）膳食习惯（记录通常您摄入下列食物的频率和食用量）</h3>
                <table class="posttable">
                    <tr>
                        <td style="width:250px;"><b>食物</b></td>
                        <td style="width:350px;"><b>食用频率（选择其中一种）</b></td>
                        <td><b>食用量</b></td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B9.</b> 主食</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b9" value="0" ${question.b9 eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b9" value="1" ${question.b9 eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b9" value="2" ${question.b9 eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b9" value="3" ${question.b9 eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b9" value="4" ${question.b9 eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b9A" value="${question.b9A}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b9B" value="${question.b9B}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B10.</b> 肉类</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b10" value="0" ${question.b10 eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b10" value="1" ${question.b10 eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b10" value="2" ${question.b10 eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b10" value="3" ${question.b10 eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b10" value="4" ${question.b10 eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b10A" value="${question.b10A}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b10B" value="${question.b10B}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B11.</b> 鱼类</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b11" value="0" ${question.b11 eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b11" value="1" ${question.b11 eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b11" value="2" ${question.b11 eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b11" value="3" ${question.b11 eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b11" value="4" ${question.b11 eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b11A" value="${question.b11A}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b11B" value="${question.b11B}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B12.</b> 蔬菜</td>
                        <td style="width:350px;">
                            <label><input type="radio" name="b12" value="0" ${question.b12 eq '0' ? 'checked':''}/>不吃</label>
                            <label><input type="radio" name="b12" value="1" ${question.b12 eq '1' ? 'checked':''}/>天</label>
                            <label><input type="radio" name="b12" value="2" ${question.b12 eq '2' ? 'checked':''}/>周</label>
                            <label><input type="radio" name="b12" value="3" ${question.b12 eq '3' ? 'checked':''}/>月</label>
                            <label><input type="radio" name="b12" value="4" ${question.b12 eq '4' ? 'checked':''}/>年</label>
                        </td>
                        <td>
                            <tag:numberInput name="b12A" value="${question.b12A}" style="width:50px" reg="{'max':999}"/>斤
                            <tag:numberInput name="b12B" value="${question.b12B}" style="width:50px" reg="{'max':999}"/>两
                        </td>
                    </tr>
                    <tr>
                        <td><b>B13.</b> 您的口味与当地一般人比：</td>
                        <td>
                            <label><input type="radio" name="b13" value="1" ${question.b13 eq '1' ? 'checked':''}/>偏咸</label>
                            <label><input type="radio" name="b13" value="2" ${question.b13 eq '2' ? 'checked':''}/>差不多</label>
                            <label><input type="radio" name="b13" value="3" ${question.b13 eq '3' ? 'checked':''}/>偏淡</label>
                            <label><input type="radio" name="b13" value="4" ${question.b13 eq '4' ? 'checked':''}/>偏甜</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <tr>
                        <td style="width:250px;"><b>高脂膳食：</b></td>
                    </tr>
                    <tr>
                        <td style="width:250px;"><b>B14.</b> 您最近一周吃肉是否＜75g/天</td>
                        <td>
                            <label><input type="radio" name="b14"
                                          value="0" ${question.b14 eq '0' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="b14"
                                          value="1" ${question.b14 eq '1' ? 'checked':''}/>否</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>B15.</b> 您吃肉的种类是：</td>
                        <td>
                            <label><input type="radio" name="b15" value="0" ${question.b15 eq '0' ? 'checked':''}/>瘦肉</label>
                            <label><input type="radio" name="b15" value="1" ${question.b15 eq '1' ? 'checked':''}/>肥瘦肉</label>
                            <label><input type="radio" name="b15" value="2" ${question.b15 eq '2' ? 'checked':''}/>肥肉</label>
                            <label><input type="radio" name="b15" value="3" ${question.b15 eq '3' ? 'checked':''}/>内脏</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>B16.</b> 您最近一周吃蛋的个数：</td>
                        <td>
                            <label><input type="radio" name="b16" value="0" ${question.b16 eq '0' ? 'checked':''}/>0-3个/周</label>
                            <label><input type="radio" name="b16" value="1" ${question.b16 eq '1' ? 'checked':''}/>3-7个/周</label>
                            <label><input type="radio" name="b16" value="2" ${question.b16 eq '2' ? 'checked':''}/>7个以上/周</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>B17.</b> 您近一周吃油炸食品数量：</td>
                        <td>
                            <label><input type="radio" name="b17" value="0" ${question.b17 eq '0' ? 'checked':''}/>未吃</label>
                            <label><input type="radio" name="b17" value="1" ${question.b17 eq '1' ? 'checked':''}/>1-4次/周</label>
                            <label><input type="radio" name="b17" value="2" ${question.b17 eq '2' ? 'checked':''}/>5-7次/周</label>
                            <label><input type="radio" name="b17" value="3" ${question.b17 eq '3' ? 'checked':''}/>7次以上/周</label>
                        </td>
                    <tr>
                        <td><b>B18.</b> 您近一周吃奶油糕点的数量：</td>
                        <td>
                            <label><input type="radio" name="b18" value="0" ${question.b18 eq '0' ? 'checked':''}/>未吃</label>
                            <label><input type="radio" name="b18" value="1" ${question.b18 eq '1' ? 'checked':''}/>1-4次/周</label>
                            <label><input type="radio" name="b18" value="2" ${question.b18 eq '2' ? 'checked':''}/>5-7次/周</label>
                            <label><input type="radio" name="b18" value="3" ${question.b18 eq '3' ? 'checked':''}/>7次以上/周</label>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>三、家族史、月经史和疾病史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width:100px;"/>
                        <col style="width:60px;"/>
                        <col style="width:60px;"/>
                        <col style="width:100px;"/>
                        <col style="width:100px;"/>
                    </colgroup>
                    <tr>
                        <td><h3>家族史</h3></td>
                        <td colspan="4">兄弟姐妹和子女填写具体人数，均包括本人。9=不详</td>
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
                    <tr>
                        <td><b>C6.</b> 乙肝</td>
                        <td>
                            <select name="c6A">
                                <option value="0" ${question.c6A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c6A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c6B">
                                <option value="0" ${question.c6B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c6B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c6C" value="${question.c6C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c6D" value="${question.c6D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c6E" value="${question.c6E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c6F" value="${question.c6F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                    <tr>
                        <td><b>C7.</b> 丙肝</td>
                        <td>
                            <select name="c7A">
                                <option value="0" ${question.c7A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c7A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c7B">
                                <option value="0" ${question.c7B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c7B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c7C" value="${question.c7C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c7D" value="${question.c7D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c7E" value="${question.c7E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c7F" value="${question.c7F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                    <tr>
                        <td><b>C8.</b> 结核</td>
                        <td>
                            <select name="c8A">
                                <option value="0" ${question.c8A eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c8A eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <select name="c8B">
                                <option value="0" ${question.c8B eq '0' ? 'selected' : ''}>无</option>
                                <option value="1" ${question.c8B eq '1' ? 'selected' : ''}>有</option>
                            </select>
                        </td>
                        <td>
                            <tag:numberInput name="c8C" value="${question.c8C}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c8D" value="${question.c8D}" style="width:50px;" reg="{'max':99}"/>
                        </td>
                        <td><tag:numberInput name="c8E" value="${question.c8E}" style="width:50px;" reg="{'max':99}"/>&nbsp;&nbsp;
                            /&nbsp;&nbsp;<tag:numberInput name="c8F" value="${question.c8F}" style="width:50px;" reg="{'max':99}"/></td>
                    </tr>
                </table>
                <br>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 250px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><h3>月经和生育史（只对女性）</h3></td>
                    </tr>
                    <tr>
                        <td><b>C9.</b> 您是否已绝经？</td>
                        <td>
                            <label><input type="radio" name="c9"
                                          value="0" ${question.c9 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c9"
                                          value="1" ${question.c9 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c9"
                                          value="2" ${question.c9 eq '2' ? 'checked':''}/>手术（切除子宫、卵巢）</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C9.1.</b> 如果否，您现在是否怀孕？</td>
                        <td>
                            <label><input type="radio" name="c9A"
                                          value="0" ${question.c9A eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c9A"
                                          value="1" ${question.c9A eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c9A"
                                          value="2" ${question.c9A eq '2' ? 'checked':''}/>可能</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C9.2.</b> 如果是，您是多大岁数绝经的？</td>
                        <td><tag:numberInput name="c9B" value="${question.c9B}" style="width:50px;" reg="{'max':99}"/>岁</td>
                    </tr>
                    <tr>
                        <td><b>C10.</b> 您服用过避孕药吗？</td>
                        <td>
                            <label><input type="radio" name="c10"
                                          value="0" ${question.c10 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c10"
                                          value="1" ${question.c10 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c10"
                                          value="9" ${question.c10 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C11.</b> 您怀孕过吗？</td>
                        <td>
                            <label><input type="radio" name="c11"
                                          value="0" ${question.c11 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c11"
                                          value="1" ${question.c11 eq '1' ? 'checked':''}/>是</label>
                            （包括流产、死产、人工受孕、堕胎、活产和正在怀孕）
                        </td>
                    </tr>
                    <tr class="c11skip">
                        <td><b>C12.</b> 您怀孕过多少次？ 99＝不详</td>
                        <td><tag:numberInput name="c12" value="${question.c12}" style="width:50px;" reg="{'max':99}"/>次</td>
                    </tr>
                    <tr class="c11skip">
                        <td><b>C13.</b> 您有过哺乳经历么？</td>
                        <td>
                            <label><input type="radio" name="c13"
                                          value="0" ${question.c13 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c13"
                                          value="1" ${question.c13 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c13"
                                          value="9" ${question.c13 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
                <br>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><h3>疾病史</h3></td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>（一）高血压病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C14.</b> 医生告诉过您血压高吗？</td>
                        <td>
                            <label><input type="radio" name="c14"
                                          value="0" ${question.c14 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c14"
                                          value="1" ${question.c14 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c14"
                                          value="9" ${question.c14 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c14skip">
                        <td><b>c15.</b> 首次确诊的年龄</td>
                        <td><tag:numberInput name="c15" value="${question.c15}" style="width:50px;" reg="{'max':99}"/>岁</td>
                    </tr>
                    <tr class="c14skip">
                        <td><b>C16.a.</b> 您现在是否服用降压药？</td>
                        <td>
                            <label><input type="radio" name="c16A"
                                          value="0" ${question.c16A eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c16A"
                                          value="1" ${question.c16A eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c14skip">
                        <td><b>C16.b.</b> 您是否遵医嘱服降压药？</td>
                        <td>
                            <label><input type="radio" name="c16B"
                                          value="0" ${question.c16B eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c16B"
                                          value="1" ${question.c16B eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c14skip">
                        <td><b>C16.c.</b> 服用药品名称</td>
                        <td><input type="text" name="c16C" value="${question.c16C}" style="width:200px;"/></td>
                    </tr>
                    <tr class="c14skip">
                        <td><b>C17.</b> 您服用降压药已有多长时间了？00=少于1年</td>
                        <td><tag:numberInput name="c17" value="${question.c17}" style="width:50px;" reg="{'max':99}"/>年</td>
                    </tr>
                    <tr class="c14skip">
                        <td><b>C18.</b> 您患高血压后，采取了哪些措施来控制血压：</td>
                        <td>
                            <label><input type="checkbox" name="c18" value="1" ${fn:contains(question.c18, '1') ? 'checked':''}/>1.按医嘱服药</label>
                            <label><input type="checkbox" name="c18" value="2" ${fn:contains(question.c18, '2') ? 'checked':''}/>2.少盐的摄入</label>
                            <label><input type="checkbox" name="c18" value="3" ${fn:contains(question.c18, '3') ? 'checked':''}/>3.间断服药</label>
                            <label><input type="checkbox" name="c18" value="4" ${fn:contains(question.c18, '4') ? 'checked':''}/>4.做适宜的运动</label>
                            <label><input type="checkbox" name="c18" value="5" ${fn:contains(question.c18, '5') ? 'checked':''}/>5.控制体重</label>
                            <label><input type="checkbox" name="c18" value="6" ${fn:contains(question.c18, '6') ? 'checked':''}/>6.不用治疗</label>
                            <label><input type="checkbox" name="c18" value="7" ${fn:contains(question.c18, '7') ? 'checked':''}/>7.其他</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>（二）高脂血症病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C19.</b> 医生告诉过您血脂高吗？</td>
                        <td>
                            <label><input type="radio" name="c19"
                                          value="0" ${question.c19 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c19"
                                          value="1" ${question.c19 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c19"
                                          value="9" ${question.c19 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c19skip">
                        <td><b>c20.a.</b> 您是否服用降脂药？</td>
                        <td>
                            <label><input type="radio" name="c20A"
                                          value="0" ${question.c20A eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c20A"
                                          value="1" ${question.c20A eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c19skip">
                        <td><b>C20.b.</b> 您服用降脂药已经多长时间了？</td>
                        <td>
                            <tag:numberInput name="c20B" value="${question.c20B}" style="width:50px;" reg="{'max':99}"/>年（00=少于1年）
                        </td>
                    </tr>
                    <tr class="c19skip">
                        <td><b>C20.c.</b> 最近两周您服过降脂药吗？</td>
                        <td>
                            <label><input type="radio" name="c20C"
                                          value="0" ${question.c20C eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c20C"
                                          value="1" ${question.c20C eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c19skip">
                        <td><b>C20.d.</b> 服用药品名称</td>
                        <td><input type="text" name="c20D" value="${question.c20D}" style="width:200px;"/></td>
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
                        <td><b>C21.</b> 医生曾告诉过你有糖尿病吗？</td>
                        <td>
                            <label><input type="radio" name="c21"
                                          value="0" ${question.c21 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c21"
                                          value="1" ${question.c21 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c21"
                                          value="9" ${question.c21 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C21.a.</b> 诊断日期</td>
                        <td><tag:numberInput name="c21A1" value="${question.c21A1}" style="width:50px;" reg="{'length':4,'max':9999}"/>年</td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C21.b.</b> 诊断时的空腹血糖值：</td>
                        <td>
                            <tag:numberInput name="c21B1" value="${question.c21B1}" style="width:50px;" reg="{'max':9999}"/>mg/dl 或
                            <tag:numberInput name="c21B2" value="${question.c21B2}" style="width:50px;" reg="{'max':9999}"/>mmol/L
                        </td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C21.c.</b> 诊断时的餐后2小时糖耐量：</td>
                        <td>
                            <tag:numberInput name="c21C1" value="${question.c21C1}" style="width:50px;" reg="{'max':9999}"/>mg/dl 或
                            <tag:numberInput name="c21C2" value="${question.c21C2}" style="width:50px;" reg="{'max':9999}"/>mmol/L
                        </td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C22.</b> 并发症（此题可多选）</td>
                        <td>
                            <label><input type="checkbox" name="c22" value="1" ${fn:contains(question.c22, '1') ? 'checked':''}/>无</label>
                            <label><input type="checkbox" name="c22" value="2" ${fn:contains(question.c22, '2') ? 'checked':''}/>糖尿病眼底病变</label>
                            <label><input type="checkbox" name="c22" value="3" ${fn:contains(question.c22, '3') ? 'checked':''}/>糖尿病肾病</label>
                            <label><input type="checkbox" name="c22" value="4" ${fn:contains(question.c22, '4') ? 'checked':''}/>糖尿病足</label>
                            <label><input type="checkbox" name="c22" value="5" ${fn:contains(question.c22, '5') ? 'checked':''}/>糖尿病外周神经病变</label>
                            <label><input type="checkbox" name="c22" value="8" ${fn:contains(question.c22, '8') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c22" value="9" ${fn:contains(question.c22, '9') ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C23.</b> 医生第一次告诉你糖尿病时，您年龄多大？</td>
                        <td><tag:numberInput name="c23" value="${question.c23}" style="width:50px;" reg="{'max':99}"/>岁（不包括孕期内糖尿病）</td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>c24.</b> 您目前使用胰岛素吗？</td>
                        <td>
                            <label><input type="radio" name="c24"
                                          value="0" ${question.c24 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c24"
                                          value="1" ${question.c24 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>c25.</b> 您使用胰岛素多长时间了？ 00=少于1年</td>
                        <td><tag:numberInput name="c25" value="${question.c25}" style="width:50px;" reg="{'max':99}"/>年</td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C25.a.</b> 服用药品名称</td>
                        <td><input type="text" name="c25A" value="${question.c25A}" style="width:200px;"/></td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C26.</b> 您目前服用口服降糖药吗？</td>
                        <td>
                            <label><input type="radio" name="c26"
                                          value="0" ${question.c26 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c26"
                                          value="1" ${question.c26 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C27.</b> 您服用口服降糖药多长时间了？ 00=少于1年</td>
                        <td><tag:numberInput name="c27" value="${question.c27}" style="width:50px;" reg="{'max':99}"/>年</td>
                    </tr>
                    <tr class="c21skip">
                        <td><b>C28.</b> 您患糖尿病后，采取了哪些措施来控制血糖？</td>
                        <td>
                            <label><input type="checkbox" name="c28" value="1" ${fn:contains(question.c28, '1') ? 'checked':''}/>按医嘱用药</label>
                            <label><input type="checkbox" name="c28" value="2" ${fn:contains(question.c28, '2') ? 'checked':''}/>间断用药</label>
                            <label><input type="checkbox" name="c28" value="3" ${fn:contains(question.c28, '3') ? 'checked':''}/>控制饮食</label>
                            <label><input type="checkbox" name="c28" value="4" ${fn:contains(question.c28, '4') ? 'checked':''}/>适量运动</label>
                            <label><input type="checkbox" name="c28" value="5" ${fn:contains(question.c28, '5') ? 'checked':''}/>控制体重</label>
                            <label><input type="checkbox" name="c28" value="6" ${fn:contains(question.c28, '6') ? 'checked':''}/>血糖监测</label>
                            <label><input type="checkbox" name="c28" value="7" ${fn:contains(question.c28, '7') ? 'checked':''}/>其它</label>
                            <label><input type="checkbox" name="c28" value="8" ${fn:contains(question.c28, '8') ? 'checked':''}/>未采取措施</label>
                        </td>
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
                        <td><b>C29.</b> 医生是否诊断过您有脑卒中？</td>
                        <td>
                            <label><input type="radio" name="c29"
                                          value="0" ${question.c29 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c29"
                                          value="1" ${question.c29 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c29"
                                          value="9" ${question.c29 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c29skip">
                        <td><b>C30.</b> 脑卒中类型（可多选）</td>
                        <td>
                            <label><input type="checkbox" name="c30" value="1" ${fn:contains(question.c30, '1') ? 'checked':''}/>脑梗塞</label>
                            <label><input type="checkbox" name="c30" value="2" ${fn:contains(question.c30, '2') ? 'checked':''}/>脑出血</label>
                            <label><input type="checkbox" name="c30" value="8" ${fn:contains(question.c30, '8') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c30" value="9" ${fn:contains(question.c30, '9') ? 'checked':''}/>不详</label>
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
                        <td><b>C31.</b> 医生是否诊断过您有冠心病？</td>
                        <td>
                            <label><input type="radio" name="c31"
                                          value="0" ${question.c31 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c31"
                                          value="1" ${question.c31 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c31"
                                          value="9" ${question.c31 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c31skip">
                        <td><b>C32.</b> 冠心病类型（可多选）</td>
                        <td>
                            <label><input type="checkbox" name="c32" value="1" ${fn:contains(question.c32, '1') ? 'checked':''}/>心肌梗塞</label>
                            <label><input type="checkbox" name="c32" value="2" ${fn:contains(question.c32, '2') ? 'checked':''}/>心绞痛</label>
                            <label><input type="checkbox" name="c32" value="3" ${fn:contains(question.c32, '3') ? 'checked':''}/>心律失常</label>
                            <label><input type="checkbox" name="c32" value="4" ${fn:contains(question.c32, '4') ? 'checked':''}/>心衰</label>
                            <label><input type="checkbox" name="c32" value="8" ${fn:contains(question.c32, '8') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c32" value="9" ${fn:contains(question.c32, '9') ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（六）肝炎病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C33.</b> 您是否患过肝病？</td>
                        <td>
                            <label><input type="radio" name="c33"
                                          value="0" ${question.c33 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c33"
                                          value="1" ${question.c33 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c33skip">
                        <td><b>C34.</b> 您患过何种肝炎</td>
                        <td>
                            <label><input type="checkbox" name="c34" value="1" ${fn:contains(question.c34, '1') ? 'checked':''}/>甲肝</label>
                            <label><input type="checkbox" name="c34" value="2" ${fn:contains(question.c34, '2') ? 'checked':''}/>乙肝</label>
                            <label><input type="checkbox" name="c34" value="3" ${fn:contains(question.c34, '3') ? 'checked':''}/>丙肝</label>
                            <label><input type="checkbox" name="c34" value="4" ${fn:contains(question.c34, '4') ? 'checked':''}/>戊肝</label>
                            <label><input type="checkbox" name="c34" value="5" ${fn:contains(question.c34, '5') ? 'checked':''}/>其他</label>
                            <label><input type="checkbox" name="c34" value="6" ${fn:contains(question.c34, '6') ? 'checked':''}/>脂肪肝</label>
                            <label><input type="checkbox" name="c34" value="7" ${fn:contains(question.c34, '7') ? 'checked':''}/>血吸虫</label>
                        </td>
                    </tr>
                    <%--<tr class="c33skip">
                        <td><b>C35.</b> 您哪一年被诊断患有肝病？</td>
                        <td><tag:numberInput name="c35" value="${question.c35}" style="width:50px;" reg="{'length':4,'max':9999}"/>年</td>
                    </tr>
                    <tr class="c33skip">
                        <td><b>C36.</b> 您是否接受过治疗？</td>
                        <td>
                            <label><input type="radio" name="c36"
                                          value="0" ${question.c36 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c36"
                                          value="1" ${question.c36 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>--%>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 300px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（七）结核病史</b></td>
                    </tr>
                    <tr>
                        <td><b>C38.</b> 您是否患过结核？</td>
                        <td>
                            <label><input type="radio" name="c38"
                                          value="0" ${question.c38 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c38"
                                          value="1" ${question.c38 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                    <tr class="c38skip">
                        <td><b>C39.</b> 您哪一年被诊断患有结核？</td>
                        <td><tag:numberInput name="c39" value="${question.c39}" style="width:50px;" reg="{'length':4,'max':9999}"/>年</td>
                    </tr>
                    <tr class="c38skip">
                        <td><b>C40.</b> 您是否接受过治疗？</td>
                        <td>
                            <label><input type="radio" name="c40"
                                          value="0" ${question.c40 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c40"
                                          value="1" ${question.c40 eq '1' ? 'checked':''}/>是</label>
                        </td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 330px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td><b>（八）其他疾病史</b></td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top"><b>C41.</b> 医生是否诊断过您患有恶性肿瘤？</td>
                        <td>
                            <label><input type="radio" name="c41"
                                          value="0" ${question.c41 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c41"
                                          value="1" ${question.c41 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c41"
                                          value="9" ${question.c41 eq '9' ? 'checked':''}/>不详</label>
                            <div id="c41A" ${question.c41 eq '1' ? '' : 'hidden'}>
                                如果是，填写名称 <input type="text" name="c41A" value="${question.c41A}" style="width:100px;"/>
                                ICD-10编码 <input type="text" name="c41B" value="${question.c41B}" style="width:100px;"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><b>C42.</b> 医生是否诊断过您患有肾脏疾病？</td>
                        <td>
                            <label><input type="radio" name="c42"
                                          value="0" ${question.c42 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c42"
                                          value="1" ${question.c42 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c42"
                                          value="9" ${question.c42 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c42skip">
                        <td><b>C43.</b> 肾脏疾病类型</td>
                        <td>
                            <label><input type="radio" name="c43" value="1" ${question.c43 eq '1' ? 'checked':''}/>肾小球或肾盂肾炎</label>
                            <label><input type="radio" name="c43" value="2" ${question.c43 eq '2' ? 'checked':''}/>糖尿病肾病</label>
                            <label><input type="radio" name="c43" value="3" ${question.c43 eq '3' ? 'checked':''}/>高血压肾病</label>
                            <label><input type="radio" name="c43" value="8" ${question.c43 eq '8' ? 'checked':''}/>其他</label>
                            <label><input type="radio" name="c43" value="9" ${question.c43 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                    <tr class="c42skip">
                        <td><b>C44.</b> 医生是否诊断过您患有肾功能衰竭或终末期肾病？</td>
                        <td>
                            <label><input type="radio" name="c44"
                                          value="0" ${question.c44 eq '0' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="c44"
                                          value="1" ${question.c44 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="c44"
                                          value="9" ${question.c44 eq '9' ? 'checked':''}/>不详</label>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>四、体力活动（询问最近1年的体力活动状况）</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 430px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td style="vertical-align: top"><b>D1.</b> 您每天上下班主要采用的方式及其时间</td>
                        <td>
                            步行
                            <label><input type="radio" name="d1A" value="0" ${question.d1A eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d1A" value="1" ${question.d1A eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d1A" value="2" ${question.d1A eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d1A" value="3" ${question.d1A eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d1A" value="4" ${question.d1A eq '4' ? 'checked':''}/>60分钟</label><br>
                            自行车
                            <label><input type="radio" name="d1B" value="0" ${question.d1B eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d1B" value="1" ${question.d1B eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d1B" value="2" ${question.d1B eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d1B" value="3" ${question.d1B eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d1B" value="4" ${question.d1B eq '4' ? 'checked':''}/>60分钟</label><br>
                            公交、地铁、班车
                            <label><input type="radio" name="d1C" value="0" ${question.d1C eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d1C" value="1" ${question.d1C eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d1C" value="2" ${question.d1C eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d1C" value="3" ${question.d1C eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d1C" value="4" ${question.d1C eq '4' ? 'checked':''}/>60分钟</label><br>
                            自驾车、电动车、摩托车
                            <label><input type="radio" name="d1D" value="0" ${question.d1D eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d1D" value="1" ${question.d1D eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d1D" value="2" ${question.d1D eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d1D" value="3" ${question.d1D eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d1D" value="4" ${question.d1D eq '4' ? 'checked':''}/>60分钟</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>D2.</b> 过去30天您是否参加过任何体育锻炼或运动？</td>
                        <td>
                            <label><input type="radio" name="d2"
                                          value="1" ${question.d2 eq '1' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="d2"
                                          value="2" ${question.d2 eq '2' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="d2"
                                          value="9" ${question.d2 eq '9' ? 'checked':''}/>记不清</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>D3.</b> 您进行下述体育锻炼或休闲活动的情况（无此活动填“0”小时，少于每年1次忽略不计）</td>
                    </tr>
                    <tr>
                        <td><b>D3.1.</b> 重度体力活动（登山、负重跑或快跑、骑快车等剧烈运动）</td>
                        <td>
                            <tag:numberInput name="d3A" value="${question.d3A}" style="width:50px;" reg="{'max':7}"/>天/周，
                            <label><input type="radio" name="d3A1" value="0" ${question.d3A1 eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d3A1" value="1" ${question.d3A1 eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d3A1" value="2" ${question.d3A1 eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d3A1" value="3" ${question.d3A1 eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d3A1" value="4" ${question.d3A1 eq '4' ? 'checked':''}/>60分钟</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>D3.2.</b> 中度体力活动（慢跑、快步走、秧歌、跳舞、健身操、游泳、球类）</td>
                        <td>
                            <tag:numberInput name="d3B" value="${question.d3B}" style="width:50px;" reg="{'max':7}"/>天/周，
                            <label><input type="radio" name="d3B1" value="0" ${question.d3B1 eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d3B1" value="1" ${question.d3B1 eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d3B1" value="2" ${question.d3B1 eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d3B1" value="3" ${question.d3B1 eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d3B1" value="4" ${question.d3B1 eq '4' ? 'checked':''}/>60分钟</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>D3.3.</b> 轻度体力活动（散步、气功、伸展运动、家务）</td>
                        <td>
                            <tag:numberInput name="d3C" value="${question.d3C}" style="width:50px;" reg="{'max':7}"/>天/周，
                            <label><input type="radio" name="d3C1" value="0" ${question.d3C1 eq '0' ? 'checked':''}/>0小时</label>
                            <label><input type="radio" name="d3C1" value="1" ${question.d3C1 eq '1' ? 'checked':''}/>15分钟</label>
                            <label><input type="radio" name="d3C1" value="2" ${question.d3C1 eq '2' ? 'checked':''}/>30分钟</label>
                            <label><input type="radio" name="d3C1" value="3" ${question.d3C1 eq '3' ? 'checked':''}/>45分钟</label>
                            <label><input type="radio" name="d3C1" value="4" ${question.d3C1 eq '4' ? 'checked':''}/>60分钟</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>D4.</b> 通常在工作日内，您一天坐着工作的时间有</td>
                        <td>
                            <tag:numberInput name="d4A" value="${question.d4A}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d4B" value="${question.d4B}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D5.</b> 其他静息活动（坐或躺：看书、吃饭、聊天、打牌、看电视等）</td>
                        <td>
                            <tag:numberInput name="d5A" value="${question.d5A}" style="width:50px;" reg="{'max':24}"/>小时
                            <tag:numberInput name="d5B" value="${question.d5B}" style="width:50px;" reg="{'max':60}"/>分钟
                        </td>
                    </tr>
                    <tr>
                        <td><b>D6.1.</b> 您的睡眠质量如何：</td>
                        <td>日均睡<tag:numberInput name="d6A" value="${question.d6A}" style="width:50px;" reg="{'max':24}"/>小时/天</td>
                    </tr>
                    <tr>
                        <td><b>D6.2.</b> 睡眠障碍：</td>
                        <td>
                            <label><input type="radio" name="d6B" value="1" ${question.d6B eq '1' ? 'checked':''}/>无</label>
                            <label><input type="radio" name="d6B" value="2" ${question.d6B eq '2' ? 'checked':''}/>入睡困难</label>
                            <label><input type="radio" name="d6B" value="3" ${question.d6B eq '3' ? 'checked':''}/>早醒</label>
                            <label><input type="radio" name="d6B" value="4" ${question.d6B eq '4' ? 'checked':''}/>多醒</label>
                            <label><input type="radio" name="d6B" value="5" ${question.d6B eq '5' ? 'checked':''}/>其他</label>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>五、睡眠调查</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 380px;">
                        <col/>
                    </colgroup>
                    <tr>
                        <td colspan="2"><b>E1.</b> 您是否出现过嗅觉问题？（持续至少3个月）即您无法闻到味道，或者当您闻某物时，您闻到的味道和该物应有的味道不符。</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <label><input type="radio" name="e1" value="1" ${question.e1 eq '1' ? 'checked':''}/>有</label>
                            <label><input type="radio" name="e1" value="2" ${question.e1 eq '2' ? 'checked':''}/>没有</label>
                            <label><input type="radio" name="e1" value="3" ${question.e1 eq '3' ? 'checked':''}/>不知道</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>E2.</b> 您是否出现过味觉问题？（持续至少3个月）即您无法尝到味道，或者口中感觉不到应该有的滋味，如苦、咸、酸、或者甜味。</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <label><input type="radio" name="e2" value="1" ${question.e2 eq '1' ? 'checked':''}/>有</label>
                            <label><input type="radio" name="e2" value="2" ${question.e2 eq '2' ? 'checked':''}/>没有</label>
                            <label><input type="radio" name="e2" value="3" ${question.e2 eq '3' ? 'checked':''}/>不知道</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E2.1.</b> 是哪种情况：</td>
                        <td>
                            <label><input type="radio" name="e2A" value="1" ${question.e2A eq '1' ? 'checked':''}/>丧失嗅觉</label>
                            <label><input type="radio" name="e2A" value="2" ${question.e2A eq '2' ? 'checked':''}/>口中出现不该有的味道</label>
                            <label><input type="radio" name="e2A" value="3" ${question.e2A eq '3' ? 'checked':''}/>都有</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E3.</b> 睡眠情况</td>
                    </tr>
                    <tr>
                        <td><b>E3.1.</b> 一般晚上几点钟睡觉</td>
                        <td><input type="text" name="e3A" value="${question.e3A}" style="width:100px;"/>点</td>
                    </tr>
                    <tr>
                        <td><b>E3.2.</b> 每天夜间睡眠时间：<tag:numberInput name="e3B1" value="${question.e3B1}" style="width:50px;" reg="{'max':24}"/>小时</td>
                        <td>平均每天午睡时间：<tag:numberInput name="e3B2" value="${question.e3B2}" style="width:50px;" reg="{'max':24}"/>小时</td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>E3.3.</b> 请对您近1个月的睡眠情况进行总体评估（第一列是问题）</td>
                    </tr>
                    <tr>
                        <td>是否有入睡困难</td>
                        <td>
                            <label><input type="radio" name="e3C1" value="0" ${question.e3C1 eq '0' ? 'checked':''}/>没问题</label>
                            <label><input type="radio" name="e3C1" value="1" ${question.e3C1 eq '1' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="e3C1" value="2" ${question.e3C1 eq '2' ? 'checked':''}/>经常发生</label>
                        </td>
                    </tr>
                    <tr>
                        <td>是否半夜会醒来</td>
                        <td>
                            <label><input type="radio" name="e3C2" value="0" ${question.e3C2 eq '0' ? 'checked':''}/>没问题</label>
                            <label><input type="radio" name="e3C2" value="1" ${question.e3C2 eq '1' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="e3C2" value="2" ${question.e3C2 eq '2' ? 'checked':''}/>经常发生</label>
                        </td>
                    </tr>
                    <tr>
                        <td>比期望的时间早醒</td>
                        <td>
                            <label><input type="radio" name="e3C3" value="0" ${question.e3C3 eq '0' ? 'checked':''}/>没问题</label>
                            <label><input type="radio" name="e3C3" value="1" ${question.e3C3 eq '1' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="e3C3" value="2" ${question.e3C3 eq '2' ? 'checked':''}/>经常发生</label>
                        </td>
                    </tr>
                    <tr>
                        <td>起床后觉得没有休息好</td>
                        <td>
                            <label><input type="radio" name="e3C4" value="0" ${question.e3C4 eq '0' ? 'checked':''}/>没问题</label>
                            <label><input type="radio" name="e3C4" value="1" ${question.e3C4 eq '1' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="e3C4" value="2" ${question.e3C4 eq '2' ? 'checked':''}/>经常发生</label>
                        </td>
                    </tr>
                    <tr>
                        <td>经常在白天觉得乏力、疲惫、或犯困吗</td>
                        <td>
                            <label><input type="radio" name="e3C5" value="0" ${question.e3C5 eq '0' ? 'checked':''}/>没问题</label>
                            <label><input type="radio" name="e3C5" value="1" ${question.e3C5 eq '1' ? 'checked':''}/>偶尔</label>
                            <label><input type="radio" name="e3C5" value="2" ${question.e3C5 eq '2' ? 'checked':''}/>经常发生</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E3.4.</b> 在过去的2年里，您是否使用药物改善睡眠（如安眠药等）</td>
                        <td>
                            <label><input type="radio" name="e3D" value="1" ${question.e3D eq '1' ? 'checked':''}/>从未使用</label>
                            <label><input type="radio" name="e3D" value="2" ${question.e3D eq '2' ? 'checked':''}/>每月>1次</label>
                            <label><input type="radio" name="e3D" value="3" ${question.e3D eq '3' ? 'checked':''}/>每月1-3次</label>
                            <label><input type="radio" name="e3D" value="4" ${question.e3D eq '4' ? 'checked':''}/>每周1次</label>
                            <label><input type="radio" name="e3D" value="5" ${question.e3D eq '5' ? 'checked':''}/>每周2-6次</label>
                            <label><input type="radio" name="e3D" value="6" ${question.e3D eq '6' ? 'checked':''}/>天天用</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E3.5.</b> 睡眠打鼾吗？</td>
                        <td>
                            <label><input type="radio" name="e3E" value="1" ${question.e3E eq '1' ? 'checked':''}/>从不</label>
                            <label><input type="radio" name="e3E" value="2" ${question.e3E eq '2' ? 'checked':''}/>每月>1次</label>
                            <label><input type="radio" name="e3E" value="3" ${question.e3E eq '3' ? 'checked':''}/>每月1-5次</label>
                            <label><input type="radio" name="e3E" value="4" ${question.e3E eq '4' ? 'checked':''}/>几乎每天</label>
                            <label><input type="radio" name="e3E" value="5" ${question.e3E eq '5' ? 'checked':''}/>不知道</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E3.5.1.</b> 鼾声比平时说话声还响或关着门也能听到吗？</td>
                        <td>
                            <label><input type="radio" name="e3E1" value="1" ${question.e3E1 eq '1' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="e3E1" value="2" ${question.e3E1 eq '2' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="e3E1" value="99" ${question.e3E1 eq '99' ? 'checked':''}/>不知道</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E3.5.2.</b> 有人说你睡觉时有呼吸暂停吗？（>10秒）</td>
                        <td>
                            <label><input type="radio" name="e3E2" value="1" ${question.e3E2 eq '1' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="e3E2" value="2" ${question.e3E2 eq '2' ? 'checked':''}/>是</label>
                            <label><input type="radio" name="e3E2" value="99" ${question.e3E2 eq '99' ? 'checked':''}/>不知道</label>
                        </td>
                    </tr>
                    <tr>
                        <td><b>E3.6.</b> 是否曾经被告知自己在做噩梦的时候，会随着梦境动手脚？</td>
                        <td>
                            <label><input type="radio" name="e3F" value="1" ${question.e3F eq '1' ? 'checked':''}/>否</label>
                            <label><input type="radio" name="e3F" value="2" ${question.e3F eq '2' ? 'checked':''}/>是，但只有1-2次</label>
                            <label><input type="radio" name="e3F" value="3" ${question.e3F eq '3' ? 'checked':''}/>是，至少3次</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><b>E4.</b> 在您最近几个月中，在以下情况下您打瞌睡的可能性</td>
                    </tr>
                    <tr>
                        <td>坐着阅读书刊</td>
                        <td>
                            <label><input type="radio" name="e4A" value="0" ${question.e4A eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4A" value="1" ${question.e4A eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4A" value="2" ${question.e4A eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4A" value="3" ${question.e4A eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>看电视</td>
                        <td>
                            <label><input type="radio" name="e4B" value="0" ${question.e4B eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4B" value="1" ${question.e4B eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4B" value="2" ${question.e4B eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4B" value="3" ${question.e4B eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>在公共场所坐着不动</td>
                        <td>
                            <label><input type="radio" name="e4C" value="0" ${question.e4C eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4C" value="1" ${question.e4C eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4C" value="2" ${question.e4C eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4C" value="3" ${question.e4C eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>作为乘客，在汽车里坐1个小时，中间不休息</td>
                        <td>
                            <label><input type="radio" name="e4D" value="0" ${question.e4D eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4D" value="1" ${question.e4D eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4D" value="2" ${question.e4D eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4D" value="3" ${question.e4D eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>在环境许可时，下午躺下休息</td>
                        <td>
                            <label><input type="radio" name="e4E" value="0" ${question.e4E eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4E" value="1" ${question.e4E eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4E" value="2" ${question.e4E eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4E" value="3" ${question.e4E eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>坐着与人谈话</td>
                        <td>
                            <label><input type="radio" name="e4F" value="0" ${question.e4F eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4F" value="1" ${question.e4F eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4F" value="2" ${question.e4F eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4F" value="3" ${question.e4F eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>午餐不喝酒情况下，餐后静坐时</td>
                        <td>
                            <label><input type="radio" name="e4G" value="0" ${question.e4G eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4G" value="1" ${question.e4G eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4G" value="2" ${question.e4G eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4G" value="3" ${question.e4G eq '3' ? 'checked':''}/>很可能瞌睡</label>
                        </td>
                    </tr>
                    <tr>
                        <td>遇堵车时，停车数分钟</td>
                        <td>
                            <label><input type="radio" name="e4H" value="0" ${question.e4H eq '0' ? 'checked':''}/>从不瞌睡</label>
                            <label><input type="radio" name="e4H" value="1" ${question.e4H eq '1' ? 'checked':''}/>轻度可能瞌睡</label>
                            <label><input type="radio" name="e4H" value="2" ${question.e4H eq '2' ? 'checked':''}/>中度可能瞌睡</label>
                            <label><input type="radio" name="e4H" value="3" ${question.e4H eq '3' ? 'checked':''}/>很可能瞌睡</label>
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
                    <td><tag:dateInput name="surveyDt" nullToToday="true" date="${question.surveyDt}"/>
                        <%--<tag:dateInput nullToToday="true" id="surveyDt" name="surveyDt"  pattern="yyyy/MM/dd"  onlypast="true"  style="width: 40%;"></tag:dateInput></td>--%>
                </tr>
            </table>
        </form>
    </div>
</div>