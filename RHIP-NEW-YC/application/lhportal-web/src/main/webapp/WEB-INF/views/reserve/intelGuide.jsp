<%--
  Created by IntelliJ IDEA.
  User: Jingqiu
  Date: 2016/11/21
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/views/reserve/intelGuide/intelGuide.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/reserve/intelGuide/jquery.maphilight.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/reserve/intelGuide/maphilight_conf.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/intelGuide/intelGuide.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<div class="navRight">
    <div class="contentlist">
        <div class="location">
            当前位置:<label>预约挂号</label>&gt;&gt;<label>智能导诊</label>
        </div>
        <div class="searchInteraction" id="personalInfo">
            <form action="">
                <table id="">
                    <tr>
                        <td class="coltd">年龄: </td>
                        <td><input type="text" id="age" name="age"></td>
                    </tr>
                </table>
            </form>
        </div>
        <!--人体图  -->
        <div id="pic" class="">
            <img src="${pageContext.request.contextPath}/images/reserve/intelGuide/rtbwxz.png">
            <div class="zndz0203">
                <a href="javascript:void(0)" onclick="intelGuide.changeSymptomList()">症状列表</a>
                <input type="hidden" id="sex" name="sex" value="M">
                <a href="javascript:void(0)" style="font-size:0;" onclick="intelGuide.changeSex()" id="changeSex" v="0"><img
                        src="${pageContext.request.contextPath}/images/reserve/intelGuide/femalebtn.jpg"></a>
            </div>
            <div id="woman" class="wormanDisplay">
                <div class="wrap_fore"
                     style="display: block; background: url(&quot;${pageContext.request.contextPath}/images/reserve/intelGuide/woman.png&quot;); position: relative; padding: 0px; width: 513px; height: 386px;">
                    <canvas style="width: 513px; height: 386px; position: absolute; left: 0px; top: 0px; padding: 0px; border: 0px; opacity: 1;"
                            height="386" width="513"></canvas>
                    <img id="body_fore1" src="${pageContext.request.contextPath}/images/reserve/intelGuide/woman.png" usemap="#female_fore" alt="症状自检"
                         class="female_fore maphilighted"
                         style="opacity: 0; position: absolute; left: 0px; top: 0px; padding: 0px; border: 0px;"></div>
                <map name="female_fore" id="female_fore" class="female_fore">
                    <area shape="poly"
                          coords="73,70,79,99,77,108,73,116,64,134,53,152,39,165,30,177,28,188,22,200,20,202,4,207,3,204,22,174,40,141,52,123,66,90,73,74"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="151,74,142,95,158,129,164,142,193,176,195,182,202,201,205,201,220,207,222,206,206,178,183,137,166,110,152,76"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="79,162,109,191,108,222,110,256,106,278,109,299,104,341,104,354,106,365,102,381,86,379,86,373,93,357,87,322,86,285,89,271,77,209,77,184,79,167,81,159"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="115,193,142,165,143,166,146,192,145,212,133,265,133,270,138,301,129,353,130,360,138,377,124,383,120,382,117,373,116,356,118,343,115,310,114,296,116,279,112,264,113,240,114,209,114,193,114,192"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="99,179,106,172,113,174,119,174,125,179,121,184,115,190,110,190,107,187,103,181,101,179"
                          href="javascript:;" title="会阴" alt="会阴" onclick="intelGuide.showSymptom(13)">
                    <area shape="poly"
                          coords="88,124,101,122,107,117,112,114,120,120,130,123,135,124,137,137,140,152,140,160,115,174,101,169,93,162,86,154,84,148,87,139,88,131,89,126"
                          href="javascript:;" title="腹部" alt="腹部" onclick="intelGuide.showSymptom(2)">
                    <area shape="poly"
                          coords="93,61,102,67,112,69,121,65,130,62,136,62,146,64,152,72,143,88,141,94,141,105,139,113,133,116,127,114,117,108,111,107,107,108,100,114,86,117,83,114,79,105,81,98,81,92,82,85,77,79,73,74,78,70,86,68,93,64"
                          href="javascript:;" title="胸部" alt="胸部" onclick="intelGuide.showSymptom(3)">
                    <area shape="poly"
                          coords="101,48,101,52,98,55,95,58,96,60,101,64,109,66,114,67,119,64,123,63,126,59,125,52,123,48,122,46,121,46,118,49,115,51,109,53,105,51,103,49,102,49"
                          href="javascript:;" title="颈部" alt="颈部" onclick="intelGuide.showSymptom(10)">
                    <area shape="poly"
                          coords="110,1,102,3,98,7,95,12,93,15,93,17,99,18,103,18,107,20,111,20,115,20,119,20,127,18,130,18,134,18,130,12,129,8,125,5,122,3,118,2,114,2,106,1"
                          href="javascript:;" title="头部" alt="头部" onclick="intelGuide.showSymptom(4)">
                    <area shape="poly" coords="106,43,111,41,113,41,116,43,113,46,109,45,107,44,107,43"
                          href="javascript:;" title="嘴巴" alt="嘴巴" onclick="intelGuide.showSymptom(17)">
                    <area shape="poly"
                          coords="97,34,99,41,105,48,111,52,119,48,123,41,125,32,118,32,117,32,116,36,117,40,116,45,111,47,105,44,105,39,107,34,106,33,102,32,99,32,98,34"
                          href="javascript:;" title="面部" alt="面部" onclick="intelGuide.showSymptom(16)">
                    <area shape="poly"
                          coords="113,28,113,30,113,32,113,34,114,35,114,37,114,37,113,37,111,38,110,38,108,37,109,36,109,35,109,32,110,30,110,28,111,27,112,27"
                          href="javascript:;" title="鼻子" alt="鼻子" onclick="intelGuide.showSymptom(9)">
                    <area shape="poly"
                          coords="99,26,102,25,105,25,106,27,107,27,107,29,106,31,103,31,100,31,99,28,100,26"
                          href="javascript:;" title="眼睛" alt="眼睛" onclick="intelGuide.showSymptom(8)">
                    <area shape="poly" coords="114,28,117,27,119,25,122,25,123,27,124,29,120,31,118,31,116,30,115,29"
                          href="javascript:;" title="眼睛" alt="眼睛" onclick="intelGuide.showSymptom(8)">
                    <area shape="poly"
                          coords="125,29,123,31,125,34,124,36,126,36,127,35,128,32,128,30,127,29,126,29,125,29,124,29"
                          href="javascript:;" title="耳部" alt="耳部" onclick="intelGuide.showSymptom(9)">

                    <area shape="poly"
                          coords="363,186,379,197,395,195,394,244,396,266,392,283,394,299,393,316,389,352,389,365,392,381,383,385,369,381,376,372,378,360,370,302,372,291,376,274,366,228,363,210,363,194"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="401,195,416,195,433,188,433,209,420,265,420,276,424,300,423,323,418,347,418,364,424,379,425,380,412,385,404,379,408,351,403,324,402,303,404,287,398,265,400,234,400,201,400,195"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="359,71,367,106,355,124,352,128,346,141,325,166,314,180,305,203,286,210,286,205,306,175,327,134,339,120,346,103,359,72"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="442,86,432,110,442,128,448,140,480,179,491,204,509,210,510,206,489,176,468,134,456,115,441,86"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="424,148,399,162,371,149,364,165,363,184,379,195,389,195,399,193,413,195,433,188,431,171,428,159"
                          href="javascript:;" title="臀部" alt="臀部" onclick="intelGuide.showSymptom(15)">
                    <area shape="poly" coords="374,137,398,130,420,136,423,147,399,161,371,148" href="javascript:;"
                          title="腰部" alt="腰部" onclick="intelGuide.showSymptom(14)">
                    <area shape="poly"
                          coords="362,68,377,62,384,58,417,60,434,68,441,74,442,84,420,137,399,130,375,136,367,98,361,70"
                          href="javascript:;" title="背部" alt="背部" onclick="intelGuide.showSymptom(6)">
                    <area shape="poly"
                          coords="385,4,396,1,415,8,420,24,420,39,419,51,416,60,386,59,376,44,374,29,379,10,387,2"
                          href="javascript:;" title="头部" alt="头部" onclick="intelGuide.showSymptom(4)">
                </map>
            </div>
            <div id="man" class="">
                <div class="wrap_fore"
                     style="display: block; background: url(&quot;${pageContext.request.contextPath}/images/reserve/intelGuide/man.png&quot;); position: relative; padding: 0px; width: 513px; height: 386px;">
                    <canvas style="width: 513px; height: 386px; position: absolute; left: 0px; top: 0px; padding: 0px; border: 0px; opacity: 1;"
                            height="386" width="513"></canvas>
                    <img id="body_fore2" src="${pageContext.request.contextPath}/images/reserve/intelGuide/man.png" usemap="#male_fore" alt="症状自检"
                         class="male_fore maphilighted"
                         style="opacity: 0; position: absolute; left: 0px; top: 0px; padding: 0px; border: 0px;"></div>
                <map name="male_fore" id="male_fore" class="male_fore">
                    <area shape="poly"
                          coords="61,75,70,99,68,108,57,126,51,132,46,145,27,170,25,181,19,198,19,201,10,204,4,203,6,179,1,176,-1,174,5,168,16,162,32,135,39,123,49,101,55,80,60,74"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="144,68,141,95,142,107,158,129,164,143,186,169,193,187,194,200,201,203,210,204,215,194,212,184,210,176,216,173,208,165,198,164,176,125,173,120,162,98,156,78,150,70,145,68"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="76,162,104,193,105,196,96,234,85,266,82,277,82,291,72,337,74,344,74,350,74,352,73,356,74,369,69,381,66,384,50,373,52,365,59,348,58,344,58,340,61,334,59,286,64,268,68,245,69,213,73,174,75,162"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="137,162,136,158,122,180,109,193,118,232,126,260,130,269,130,276,132,296,141,336,141,347,142,355,140,371,146,382,151,383,157,379,164,370,157,351,157,342,155,338,153,333,154,285,152,274,148,265,145,245,144,202,142,184,139,165,136,156"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="93,167,106,170,120,166,122,166,122,173,120,180,115,190,108,193,104,192,95,184,91,174,91,166"
                          href="javascript:;" title="会阴" alt="会阴" onclick="intelGuide.showSymptom(13)">
                    <area shape="poly"
                          coords="75,112,104,113,118,113,138,106,132,125,133,143,135,152,135,156,124,164,110,171,102,170,89,164,78,158,80,135,78,123,72,108"
                          href="javascript:;" title="腹部" alt="腹部" onclick="intelGuide.showSymptom(2)">
                    <area shape="poly"
                          coords="91,57,61,72,70,96,75,110,105,110,125,114,138,106,145,68,122,59,106,66,91,58"
                          href="javascript:;" title="胸部" alt="胸部" onclick="intelGuide.showSymptom(3)">
                    <area shape="poly" coords="94,48,101,54,108,53,115,46,116,56,110,65,98,65,92,56" href="javascript:;"
                          title="颈部" alt="颈部" onclick="intelGuide.showSymptom(10)">
                    <area shape="poly"
                          coords="86,14,91,7,93,4,98,1,107,1,116,6,120,11,122,18,122,24,105,22,90,21,85,21,86,14"
                          href="javascript:;" title="头部" alt="头部" onclick="intelGuide.showSymptom(4)">
                    <area shape="poly" coords="100,44,104,42,108,42,109,43,109,45,102,46,100,45" href="javascript:;"
                          title="嘴巴" alt="嘴巴" onclick="intelGuide.showSymptom(17)">
                    <area shape="poly"
                          coords="90,28,89,34,92,44,97,51,103,54,108,54,116,47,118,33,116,32,110,33,111,41,111,45,108,48,100,48,97,41,98,34,90,29"
                          href="javascript:;" title="面部" alt="面部" onclick="intelGuide.showSymptom(16)">
                    <area shape="poly" coords="103,30,101,35,102,38,106,38,108,38,110,38,108,33,106,30"
                          href="javascript:;" title="鼻子" alt="鼻子" onclick="intelGuide.showSymptom(9)">
                    <area shape="poly"
                          coords="93,26,101,26,107,26,112,25,115,26,116,29,116,31,110,31,107,30,103,30,100,31,98,32,94,30,93,29,93,26"
                          href="javascript:;" title="眼睛" alt="眼睛" onclick="intelGuide.showSymptom(8)">
                    <area shape="poly" coords="86,26,89,38,85,32,85,26" href="javascript:;" title="耳部" alt="耳部"
                          onclick="intelGuide.showSymptom(9)">
                    <area shape="poly" coords="121,25,118,37,120,38,123,28,121,26" href="javascript:;" title="耳部"
                          alt="耳部" onclick="intelGuide.showSymptom(9)">

                    <area shape="poly"
                          coords="351,71,360,104,342,128,339,131,338,136,335,142,314,169,311,175,306,189,305,200,300,202,290,206,285,202,281,196,281,194,288,182,288,180,282,180,284,176,295,170,302,165,310,156,325,125,328,122,338,95,346,76,350,72"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="432,68,431,95,432,101,438,115,450,129,452,131,454,137,458,147,474,165,480,173,484,186,487,199,491,202,496,203,502,204,505,204,510,195,509,192,503,178,508,179,508,178,498,170,490,162,469,126,463,120,454,97,448,79,446,74,442,71,437,69,434,68,432,67"
                          href="javascript:;" title="手部" alt="手部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="361,186,360,199,359,218,357,233,357,240,357,249,354,261,353,270,350,278,348,292,349,312,350,332,350,340,349,343,347,348,345,355,342,363,340,370,340,374,342,378,356,384,360,381,363,374,363,362,362,354,362,345,362,338,369,300,373,291,373,276,377,261,384,242,396,196,396,194,383,196,373,194,366,190,363,188"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="399,195,401,207,406,231,411,242,413,254,420,270,420,282,426,308,431,335,431,345,432,351,431,362,431,370,433,381,439,385,447,381,454,374,455,372,446,346,445,337,444,307,445,291,444,281,440,270,436,251,435,217,433,184,431,189,425,195,418,197,413,197,408,196,404,196,401,195"
                          href="javascript:;" title="腿部" alt="腿部" onclick="intelGuide.showSymptom(18)">
                    <area shape="poly"
                          coords="367,157,364,164,362,174,363,183,362,187,374,192,382,194,392,195,396,194,397,194,402,195,413,196,420,196,428,193,432,189,432,185,432,176,430,168,429,160,428,161,422,164,417,166,411,166,404,168,398,168,388,167,384,165,376,163,371,162,368,160,366,159"
                          href="javascript:;" title="臀部" alt="臀部" onclick="intelGuide.showSymptom(15)">
                    <area shape="poly"
                          coords="369,139,381,132,395,128,403,131,410,134,416,136,422,140,424,142,424,149,426,155,428,158,420,158,410,162,400,166,397,168,391,163,382,160,374,155,369,155,367,155,368,144"
                          href="javascript:;" title="腰部" alt="腰部" onclick="intelGuide.showSymptom(14)">
                    <area shape="poly"
                          coords="374,56,366,63,358,68,353,70,361,91,360,102,364,114,367,128,368,138,378,132,388,128,396,128,403,127,410,130,416,134,422,137,424,140,424,123,427,111,431,99,431,90,430,79,430,69,431,65,416,58,409,55,403,61,396,64,386,61,379,57,378,54"
                          href="javascript:;" title="背部" alt="背部" onclick="intelGuide.showSymptom(6)">
                    <area shape="poly"
                          coords="383,46,390,42,398,42,404,43,406,44,407,51,409,54,403,58,394,62,387,59,382,56,380,52,383,48"
                          href="javascript:;" title="颈部" alt="颈部" onclick="intelGuide.showSymptom(10)">
                    <area shape="poly"
                          coords="383,2,388,0,393,-1,397,-1,401,1,404,2,409,8,410,17,410,24,409,32,405,40,404,43,399,42,392,42,386,43,382,45,379,36,376,28,375,20,374,13,376,10,378,5,384,2"
                          href="javascript:;" title="头部" alt="头部" onclick="intelGuide.showSymptom(4)">
                </map>

            </div>
        </div>
        <!-- 人体部位列表 -->
        <div id="body" class="wormanDisplay">
            <div class="zndz0301"><a href="javascript:void(0)" onclick="intelGuide.back()"><img src="${pageContext.request.contextPath}/images/reserve/intelGuide/fhrtbw.png" style="float: left;margin-left: 10px;"></a><span style="position: relative;left: -77px;">请选择疾病</span></div>
            <div id="bwList" class="bwList"></div>
            <div id="symptomList" class="symptomList">
            </div>
            <div id="questionList" class="questionList" style="display: none"></div>
            <div id="recDept" style="text-align: left; display: none">
                <div class="facultyinfo">
                    <div class="igsdrtop">导诊结果</div>
                </div>
            </div>
        </div>

    </div>
</div>
