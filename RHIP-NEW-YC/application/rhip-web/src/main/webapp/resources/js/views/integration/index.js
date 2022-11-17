define(function () {
        function load() {
            $(function () {
                // 集成监控统计
                $("input[name=dateTypeIntegaration]").on("click", function () {
                    getChartData();
                });
                $("#logChart").html(loadingSource);
                calcPoplulaceEcharts();

                //院内数据监控统计
                $("input[name=dateTypeMedical]").on("click", function () {
                    getMedicalChartData();
                });
                $("#medicalChart").html(loadingSource);
                getMedicalChartData();

            });
            function calcPoplulaceEcharts() {
                getChartData();
            }
        }

        function getChartData() {
            var statisticsDate = $("input[name=dateTypeIntegaration]:checked").val();
            $.getJsonByUrl({
                url: "/im/chart",
                param: {'statisticsDate': statisticsDate},
                callback: getResult
            });
        }

        function getMedicalChartData() {
            var statisticsDate = $("input[name=dateTypeMedical]:checked").val();
            $.getJsonByUrl({
                url: "/im/medical/chart",
                param: {'statisticsDate': statisticsDate},
                callback: getMedicalResult
            });
        }

        function getResult(data) {
            document.getElementById("resultRightId").innerHTML = data["resultRight"];
            document.getElementById("resultErrorId").innerHTML = data["resultError"];

            var populaceEChartOption = {
                title: {
                    text: '常熟市区域卫生' + data.year + '年数据集成异常数',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['正确数量', '错误数量'],
                    y: 'bottom'
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: false},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        data: ['院内数据', '体检数据', '药品目录', '计免数据', '妇幼数据', '医药卫生用品', '血站', '120数据']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '正确数量',
                        type: 'bar',
                        data: [data.hospitalMedalDataRightMap, data.physicalExamRightMap, data.drugMonitorRightMap,
                            data.planimmuRightMap, data.wChildrenRightMap, data.medicalGoodsRightMap, data.bloodStationRightMap, data.data120RightMap]
                    },
                    {
                        name: '错误数量',
                        type: 'bar',
                        data: [data.hospitalMedalDataErrorMap, data.physicalExamErrorMap, data.drugMonitorErrorMap,
                            data.planimmuErrorMap, data.wChildrenErrorMap, data.medicalGoodsErrorMap, data.bloodStationErrorMap, data.data120ErrorMap]
                    }
                ]
            };
            var logChart = document.getElementById('logChart');
            require(
                [
                    'echarts',
                    'echarts/chart/bar',
                    'echarts/chart/line'
                ],
                function (ec) {
                    var myChart = ec.init(logChart);
                    myChart.setOption(populaceEChartOption);
                    window.onresize = myChart.resize;
                });
        }

        function getMedicalResult(data) {
            document.getElementById("shouldCountId").innerHTML = data.shouldCount;
            document.getElementById("actualCountId").innerHTML = data.actualCount;
            var populaceMedicalChartOption = {
                title: {
                    text: '常熟市区域卫生' + data.year + '年院内数据异常数',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['正确数量', '错误数量'],
                    y: 'bottom'
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: false},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        data: ['门诊记录', '住院记录', '诊断记录', '门诊处方', '医嘱用药', '手术记录',
                            '输血记录', '检验', '体检', '出院小结', '病案首页', '转诊', '会诊', '检查']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '正确数量',
                        type: 'bar',
                        data: [data.shouldOutpatientCount, data.shouldInpatientCount, data.shouldDiseaseDiagnosisCount,
                            data.shouldOutpatientPrescriptionCount, data.shouldDrugCount, data.shouldSurgeryCount,
                            data.shouldTransBloodCount, data.shouldExamineEventCount, data.shouldHealthExaminationCount,
                            data.shouldOuthospitalSummaryCount, data.shouldInpatientMedicalRecordCount,
                            data.shouldReferralCount, data.shouldConsultationCount, data.shouldStudyEventCount]
                    },
                    {
                        name: '错误数量',
                        type: 'bar',
                        data: [data.actualOutpatientCount, data.actualInpatientCount, data.actualDiseaseDiagnosisCount,
                            data.actualOutpatientPrescriptionCount, data.actualDrugCount, data.actualSurgeryCount,
                            data.actualTransBloodCount, data.actualExamineEventCount, data.actualHealthExaminationCount,
                            data.actualOuthospitalSummaryCount, data.actualInpatientMedicalRecordCount,
                            data.actualReferralCount, data.actualConsultationCount, data.actualStudyEventCount]
                    }
                ]
            };
            var medicalChart = document.getElementById('medicalChart');
            require(
                [
                    'echarts',
                    'echarts/chart/bar',
                    'echarts/chart/line'
                ],
                function (ec) {
                    var myChart = ec.init(medicalChart);
                    myChart.setOption(populaceMedicalChartOption);
                    window.onresize = myChart.resize;
                });

        }

        return {
            load: load
        }
    }
);
