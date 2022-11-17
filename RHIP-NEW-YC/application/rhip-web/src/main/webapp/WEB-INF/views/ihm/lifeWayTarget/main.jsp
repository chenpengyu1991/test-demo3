<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
    require(['views/ihm/lifeWayTarget/main'],function(lifeWayMain){
        lifeWayMain.load();
    });
</script>
<div class="main_PS" style="width: 99%;">
    <div id="mainContent" style="width:99%;">

        <table  border="0" align="center" cellpadding="0" cellspacing="0">
            <colgroup>
                <col style="width: 25%"/>
                <col style="width: 25%"/>
            </colgroup>
            <tr>
                <td>
                    <div id="inquiry" style="height:340px;width:100%;display:inline;float:left;">
                        <b class="jiandang">饮食习惯</b>
                        <div id="chartEatingHabits" style="height: 270px;"></div>
                    </div>
                </td>
                <td>
                    <div id="inquiry" style="height:340px;width:100%;display:inline;float:left;">
                        <b class="jiandang">运动频率</b>
                        <div id="chartTrainFrequency" style="height: 270px;padding-left:15px"></div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="inquiry" style="height:340px;width:100%;display:inline;float:left;">
                        <b class="jiandang">吸烟频率</b>
                        <div id="chartSmodeStatus" style="height: 270px;"></div>
                    </div>
                </td>
                <td>
                    <div id="inquiry" style="height:340px;width:100%;display:inline;float:left;">
                        <b class="jiandang">饮酒频率</b>
                            <div id="chartDrinkFrequency" style="height: 270px;"></div>
                    </div>
                </td>
            </tr>
        </table>
        <!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><br class="clearfloat" />
    </div>
</div>
