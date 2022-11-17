/**
 * Created by Jingqiu on 2016/11/21.
 */
var intelGuide = (function() {
    $(function () {
        getBodyList();
    });

    function getBodyList() {
        $.getJsonByUrl({
            url: '/userSpace/reserve/getBodyList',
            callback: function(result) {
                if (result.code == 200) {
                    var items = result.data.items;
                    var bodyList = '';
                    for (var i in items) {
                        bodyList += '<a class="zndzzz" id="symptomList_'+items[i].id+'" href="javascript:void(0)" onclick="intelGuide.symptomList('+items[i].id+')">'+items[i].name+'</a>';
                    }
                    $("#bwList").html(bodyList);
                }
            }
        });
    }

    function symptomList(id) {
        var sex = $('#sex').val();
        var age = $("#personalInfo #age").val();
        if ($.isEmpty(age)) {
            msgUtil.alert("请输入年龄！");
            return;
        }
        $('[id^=symptomList_]').removeClass('changezndzzz');
        $('#symptomList_' + id).addClass('changezndzzz');
        $.getJsonByUrl({
            url: '/userSpace/reserve/getSymptomList',
            param: {
                sex: sex,
                bodyId: id,
                age: age
            },
            callback: function(result) {
                if (result.code == 200) {
                    var items = result.data.items;
                    var symptomList = '';
                    for (var i in items) {
                        symptomList += '<a href="javascript:void(0)" onclick="intelGuide.chooseSymptom('+items[i].id+', '+items[i].haveQa+')" id="symptomName_'+items[i].id+'">'+items[i].symptom+'</a>';
                    }
                    $("#symptomList").html(symptomList);
                }
            }
        });
    }

    function changeSymptomList() {
        $('#body').removeClass('wormanDisplay');
        $('#pic').addClass('wormanDisplay');
        $('#symptomList_18').trigger('click');
        $('#symptomList_18').addClass('changezndzzz');
    }

    function back() {
        $('#body').addClass('wormanDisplay');
        $('#pic').removeClass('wormanDisplay');
        $("#bwList").show();
        $("#symptomList").show();
        $("#symptomList").empty();
        $("#questionList").empty();
        $("#questionList").hide();
        $("#recDept .facultyinfo").empty();
        $("#recDept").hide();
    }

    function changeSex() {
        var changeSex = $('#changeSex').attr('v');
        if (changeSex == 0) {
            $('#man').addClass('wormanDisplay');
            $('#woman').removeClass('wormanDisplay');
            $('#changeSex').html('<img src="'+contextPath+'/images/reserve/intelGuide/malebtn.jpg">');
            $('#changeSex').attr('v', 1);
            $('#sex').val('F');
        } else {
            $('#man').removeClass('wormanDisplay');
            $('#woman').addClass('wormanDisplay');
            $('#changeSex').html('<img src="'+contextPath+'/images/reserve/intelGuide/femalebtn.jpg">');
            $('#changeSex').attr('v', 0);
            $('#sex').val('M');
        }
    }

    function showSymptom(id) {
        $('#pic').addClass('wormanDisplay');

        $('#body').removeClass('wormanDisplay');
        $('#zndz0202').removeClass('wormanDisplay');

        $('#symptomList_' + id).trigger('click');
        $('#symptomList_' + id).addClass('changezndzzz');

    }

    function chooseSymptom(id, haveqa) {
        var sex = $('#sex').val();
        var age = $("#personalInfo #age").val();
        if (haveqa == "1") {
            showQuestionList(age, sex, id);
        } else {
            showRecDept(age, sex, id);
        }
    }

    function showQuestionList(age, sex, symptomId) {
        $.getJsonByUrl({
            url: '/userSpace/reserve/getQuestionList',
            param: {
                sex: sex,
                symptomId: symptomId
            },
            callback: function(result) {
                if (result.code == 200) {
                    $("#bwList").hide();
                    $("#symptomList").hide();
                    $("#questionList").show();
                    var questions = result.data.items;
                    var questionList = '';
                    for (var i in questions) {
                        var questionNo = parseInt(i) + 1;
                        questionList += '<div class="questionItem">'
                        questionList += '<h4>' + questionNo + '. ' + questions[i].title + '</h4>';
                        questionList += '<ul class="options">'
                        var options = questions[i].options;
                        for (var j in options) {
                            questionList += '<li class="option"><input type="checkbox"><label>' + options[j].content + '</label></li>';
                        }
                        questionList += '</ul>';
                        questionList += '</div>';
                    }
                    questionList += '<div style="text-align: center"><input type="button" class="search_btn" value="查询" onclick="intelGuide.showRecDept('+age+',\''+sex+'\','+symptomId+')"></div>';
                    $("#questionList").html(questionList);
                }
            }
        });
    }

    function showRecDept(age, sex, symptomId) {
        $.getJsonByUrl({
            url: '/userSpace/reserve/getRecDept',
            param: {
                age: age,
                sex: sex,
                symptomId: symptomId
            },
            callback: function(result) {
                if (result.code == 200) {
                    $("#bwList").hide();
                    $("#symptomList").hide();
                    $("#questionList").hide();
                    $("#recDept").show();
                    var resultList = '<div class="igsdrtop">导诊结果</div>';
                    var recommends = result.data.recommends;
                    for (var i in recommends) {
                        var resultNo = parseInt(i) + 1;
                        resultList += '<div class="igresults">';
                        resultList += '<div class="igresultnum">结果'+resultNo+'</div>';
                        resultList += '<div class="igresultli">';
                        resultList += '<span style="color: #333;">可能疾病</span>';
                        var diseaseList = recommends[i].disease_list;
                        for (var j in diseaseList) {
                            resultList += '<span>' + diseaseList[j].name + '</span>';
                        }
                        resultList += '</div>';
                        resultList += '<div class="igresultli">';
                        resultList += '<span style="color: #333;">推荐科室</span>';
                        var facultyList = recommends[i].faculty_name;
                        for (var j in facultyList) {
                            resultList += '<span>' + facultyList[j].DeptName + '</span>';
                        }
                        resultList += '</div></div>';
                    }
                    $("#recDept .facultyinfo").html(resultList);
                    $('html,body').animate({
                        scrollTop: $("#recDept").offset().top
                    });
                }
            }
        });
    }

    return {
        symptomList: symptomList,
        changeSymptomList: changeSymptomList,
        back: back,
        changeSex: changeSex,
        showSymptom: showSymptom,
        chooseSymptom: chooseSymptom,
        showRecDept: showRecDept
    }
})();