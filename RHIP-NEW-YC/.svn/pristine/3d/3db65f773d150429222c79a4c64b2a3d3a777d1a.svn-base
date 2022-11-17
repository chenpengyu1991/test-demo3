<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/mhm/clue/clue.js" type="text/javascript"></script>

<div style="padding-left: 20px; padding-right: 20px;" class="repeattable">
    <div style="text-align: center; font-size: 24px; padding-bottom: 20px; padding-top: 10px;"><b>精神疾病线索调查问卷</b></div>
    <div>
        <b>指导语：</b>我们需要了解您身边的人（居委会的居民、村里的人、家中的人）是不是患有精神疾病，无论何时有过以下任何一点症状，现在好或者没好，都请您提出来。您提供的情况我们将会保密，请您合作。谢谢。现在请问您。有没有人发生过一下情况：
    </div>
    <table class="layui-table x-admin-sm-table-list-small">
        <colgroup>
            <col style="min-width:35px;width:35px;"/>
            <col style="min-width:500px;width:100%;"/>
        </colgroup>
        <thead>
        <tr>
            <th><input type="checkbox" id="checkAllId" name="checkedAll"  onclick="chkAll(this);"/></th>
            <th>线索内容<input type="hidden" value="${checkIds}" id="checkIds"/></th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <input type="checkbox" name="check" id="clues01" value="01" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'01')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="一、变得孤僻少语，不愿与别人接触。">
                </td>
                <td><label for="clues01">一、变得孤僻少语，不愿与别人接触。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues02" value="02" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'02')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="二、经常无目的乱走，出现一些别人无法理解的行为，甚至不知羞耻。">
                </td>
                <td><label for="clues02">二、经常无目的乱走，出现一些别人无法理解的行为，甚至不知羞耻。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues03" value="03" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'03')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="三、无缘无故伤自己，或伤别人，或毁坏东西。">
                </td>
                <td><label for="clues03">三、无缘无故伤自己，或伤别人，或毁坏东西。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues04" value="04" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'04')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="四、动作非常缓慢，做什么事情都很慢，甚至整天躺在床上不动不说话。">
                </td>
                <td><label for="clues04">四、动作非常缓慢，做什么事情都很慢，甚至整天躺在床上不动不说话。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues05" value="05" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'05')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="五、爱管闲事，整天忙碌不停，或乱花钱。">
                </td>
                <td><label for="clues05">五、爱管闲事，整天忙碌不停，或乱花钱。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues06" value="06" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'06')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="六、毫无原因地大发脾气，什么都不顾忌。">
                </td>
                <td><label for="clues06">六、毫无原因地大发脾气，什么都不顾忌。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues07" value="07" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'07')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="七、哭笑无常，或独自发笑，或出怪像做鬼脸。">
                </td>
                <td><label for="clues07">七、哭笑无常，或独自发笑，或出怪像做鬼脸。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues08" value="08" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'08')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="八、兴奋、话多，说个不停，或吹嘘自己脑袋特别聪明。">
                </td>
                <td><label for="clues08">八、兴奋、话多，说个不停，或吹嘘自己脑袋特别聪明。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues09" value="09" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'09')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="九、情绪低沉，或常独自流泪，或厌世想死，或焦虑不安。">
                </td>
                <td><label for="clues09">九、情绪低沉，或常独自流泪，或厌世想死，或焦虑不安。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues10" value="10" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'10')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十、话少、冷谈、对任何事都不关心，对家中亲人也毫无感情。">
                </td>
                <td><label for="clues10">十、话少、冷谈、对任何事都不关心，对家中亲人也毫无感情。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues11" value="11" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'11')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十一、胡言乱语，或自言自语，或说些别人听不懂的话。">
                </td>
                <td><label for="clues11">十一、胡言乱语，或自言自语，或说些别人听不懂的话。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues12" value="12" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'12')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十二、认为自己的脑子不受自己控制。">
                </td>
                <td><label for="clues12">十二、认为自己的脑子不受自己控制。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues13" value="13" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'13')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十三、多疑，或没有根据地认为别人害他，控制他。">
                </td>
                <td><label for="clues13">十三、多疑，或没有根据地认为别人害他，控制他。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues14" value="14" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'14')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十四、极不现实地吹嘘自己才智过人，权重位高。">
                </td>
                <td><label for="clues14">十四、极不现实地吹嘘自己才智过人，权重位高。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues15" value="15" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'15')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十五、乱说别人追求他，或怀疑爱人有姘头。">
                </td>
                <td><label for="clues15">十五、乱说别人追求他，或怀疑爱人有姘头。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues16" value="16" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'16')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十六、听到别人听不到的声音，或乱说有人在谈论他。">
                </td>
                <td><label for="clues16">十六、听到别人听不到的声音，或乱说有人在谈论他。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues17" value="17" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'17')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十七、看到或闻道不存在的东西、气味，或尝到水里或饭里有怪味、毒药味等。">
                </td>
                <td><label for="clues17">十七、看到或闻道不存在的东西、气味，或尝到水里或饭里有怪味、毒药味等。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues18" value="18" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'18')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十八、生活工作能力明显下降，或变得呆滞滞、傻乎乎的。">
                </td>
                <td><label for="clues18">十八、生活工作能力明显下降，或变得呆滞滞、傻乎乎的。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues19" value="19" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'19')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="十九、记忆力非常差，甚至记不住子女的年龄，或常忘记东西，或出门后找不到回家的路。">
                </td>
                <td><label for="clues19">十九、记忆力非常差，甚至记不住子女的年龄，或常忘记东西，或出门后找不到回家的路。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues20" value="20" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'20')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="二十、变得衣着不整或穿戴怪异，或不知饥饱，或不知清洁，甚至大小便也不知避人。">
                </td>
                <td><label for="clues20">二十、变得衣着不整或穿戴怪异，或不知饥饱，或不知清洁，甚至大小便也不知避人。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues21" value="21" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'21')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="二十一、有”羊癫疯“（癫痫），后来出现过精神不正常，如说糊涂话，躁动不安，行为反常，呆痴、凶狠任性等。">
                </td>
                <td><label for="clues21">二十一、有”羊癫疯“（癫痫），后来出现过精神不正常，如说糊涂话，躁动不安，行为反常，呆痴、凶狠任性等。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues22" value="22" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'22')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="二十二、吃药成瘾，或吸毒，或经常大量饮酒，不喝就受不了。">
                </td>
                <td><label for="clues22">二十二、吃药成瘾，或吸毒，或经常大量饮酒，不喝就受不了。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues23" value="23" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'23')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="二十三、脾气特别古怪，变得幼稚、自私，连亲人也不相信，或认为别人偷他东西，或胡乱说子女不给他吃穿。">
                </td>
                <td><label for="clues23">二十三、脾气特别古怪，变得幼稚、自私，连亲人也不相信，或认为别人偷他东西，或胡乱说子女不给他吃穿。</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="check"  id="clues24" value="24" onclick="doChk(this);" <c:if test="${fn:contains(checkIds,'24')}">checked="checked"</c:if>/>
                    <input type="hidden" name="name" value="二十四、自幼呆傻，不能上学，不会自理生活，或虽能勉强读书，但又出现过行为反常，胡言乱语，吵闹毁物等。">
                </td>
                <td><label for="clues24">二十四、自幼呆傻，不能上学，不会自理生活，或虽能勉强读书，但又出现过行为反常，胡言乱语，吵闹毁物等。</label></td>
            </tr>
        </tbody>
    </table>
    <br>
    <div class="toolbarpop">
        <!-- <input type="button" id="saveClues" value="保存" onclick="clueEdit.saveClues()"> -->
        <button class="layui-btn layui-btn-sm"  onclick="clueEdit.saveClues()">保存</button>
        <!-- <input type="button" id="cancelClues" value="取消" onclick="mhmCommon.closePopUp('cluesDialog')"> -->
        <button class="layui-btn layui-btn-sm"  onclick="mhmCommon.closeLayUiDialog()">取消</button>
    </div>
    <br>
</div>