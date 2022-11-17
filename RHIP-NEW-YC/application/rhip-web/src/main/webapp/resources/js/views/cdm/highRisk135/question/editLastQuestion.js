/**
 * Created by jingqiu on 17-4-18.
 */
var editLastQuestion = (function() {
    var validate;
    $(function () {
        validate = $('#questionForm').easyValidate();
        $('#backToSearchBtn').click(function () {
            question135.back();
        });
        $('#saveQuestionBtn').click(function() {
            save();
        });
        $(':radio[name="a2"]').change(function() {
            chooseOthers('a2', 'a2A', '8');
        });
        $(':radio[name="a4"]').change(function() {
            chooseOthers('a4', 'a4A', '9');
        });
        $(':radio[name="a6"]').change(function() {
            chooseOthers('a6', 'a6A', '6');
        });
        $(':radio[name="c41"]').change(function() {
            chooseOthers('c41', 'c41A', '1');
        });
        initSkipQuestion('b1', 'b1skip', '0');
        initSkipQuestion('b6', 'b6skip', '3');
        initSkipQuestion('c11', 'c11skip', '0');
        initSkipQuestion('c14', 'c14skip', '0,9');
        initSkipQuestion('c19', 'c19skip', '0,9');
        initSkipQuestion('c21', 'c21skip', '0,9');
        initSkipQuestion('c29', 'c29skip', '0,9');
        initSkipQuestion('c31', 'c31skip', '0,9');
        initSkipQuestion('c33', 'c33skip', '0');
        initSkipQuestion('c38', 'c38skip', '0');
        initSkipQuestion('c42', 'c42skip', '0,9');
    });

    function save() {
        if (validate.validateForm()) {
            $('#questionForm').submitFormGetJson({
                url: '/cdm/highRisk135/question/saveLast',
                wait: true,
                callback: function(data) {
                    if (data.success) {
                    	layer.alert("保存成功！", {icon:0,title:'提示'});
                        question135.back();
                        question135.search(1);
                    } else {
                    	layer.alert(data.message, {icon:0,title:'提示'});
                    }
                }
            });
        }
    }

    function chooseOthers(radioName, otherId, conditionValue) {
        var $other = $('#'+otherId);
        if ($(':checked[name="' + radioName + '"]').val() == conditionValue) {
            $other.show();
        } else {
            $other.val(null);
            $other.find('input').val(null);
            $other.hide();
        }
    }

    function skipQuestions(radioName, skipClass, conditionValue) {
        var $skipPart = $('.'+skipClass);
        var value = $(':checked[name="' + radioName + '"]').val();
        if ($.inArray(value, conditionValue.split(',')) > -1) {
            $skipPart.val(null);
            $skipPart.find('input[type="text"]').val(null);
            $skipPart.find(':selected').each(function() {
                $(this).removeAttr('selected');
            });
            $skipPart.find(':checked').each(function () {
                $(this).removeAttr('checked');
            });
            $skipPart.hide();
        } else {
            $skipPart.show();
        }
    }

    function initSkipQuestion(radioName, skipClass, conditionValue) {
        var value = $(':checked[name="' + radioName + '"]').val();
        if ($.inArray(value, conditionValue.split(',')) > -1) {
            $('.'+skipClass).hide();
        }
        $(':radio[name="'+radioName+'"]').change(function() {
            skipQuestions(radioName, skipClass, conditionValue);
        });
    }
})();