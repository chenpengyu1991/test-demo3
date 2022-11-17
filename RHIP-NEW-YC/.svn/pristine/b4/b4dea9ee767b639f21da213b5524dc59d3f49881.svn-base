(function($) {
	$.extend($.fn, {
		inputSize : function() {
			var objHeight = this.outerHeight();
			var objWidth = this.outerWidth();
			var size = {
				width : objWidth,
				height : objHeight
			};
			return size;
		},
		createtDiv : function() {
			$("div[ref=" + $(this).attr("id") + "]").undelegate();
			$("div[ref=" + $(this).attr("id") + "]").remove();
			var divId = "founder-select-div" + parseInt(Math.random() * 10000000);
			var selectDiv = $("<div id=\"" + divId + "\" ref=\"" + $(this).attr("id") + "\" style=\"position:absolute;z-index:1970000;\"></div>");
			var size = this.inputSize();
			var ulleft = this.offset().left;
			var ulTop = this.offset().top + size.height;
			selectDiv.offset({
				left : ulleft,
				top : ulTop
			});
			selectDiv.width(this.width());
			$("body").append(selectDiv);
			selectDiv.addClass("founderSelectDiv");
			selectDiv.hide();
			return selectDiv;
		},
		selectBox : function(option) {
			var pageSize = 10, currentPage = 1, pageCount = 1, showArray = new Array(), divClick = false, iupt = $(this);
			var op = selectBoxOption();
			var settings = $.getOption(op, option);

			var div = iupt.createtDiv();
			var hidden = $("input[ref="+iupt.attr("id")+"]");

			iupt.undelegate();
			iupt.undelegate();
			div.undelegate();

			$("*").bind("scroll", setPosition);
			iupt.bind("keyup", getShowDataAgain);
			iupt.bind("click", getShowDataAgain);
			div.bind("click", divClickFun);
			
			function getShowDataAgain(event) {
				if(event.keyCode==13){
					return;
				}
				currentPage = 1;
				getShowData();
			}

			function divClickFun() {
				divClick = true;
				iupt.focus();
			}

			iupt.blur(function() {
				var value = getValue($(iupt).val());
				$(hidden).val(value);
				
				setTimeout(function() {
					if (!divClick) {
						$(div).html("");
						$(div).hide();
					}
					divClick = false;
				}, 350);
			});

			// 查询数据
			function getShowData() {
				var param = {
					pageSize : pageSize,
					inputValue : iupt.val(),
					currentPage : currentPage
				};
				param = $.extend(param, option.param);
				$.urlPost({
					url : settings.url,
					// 不进行重提交判断
					checkRepeat : false,
					dataType : "json",
					param : param,
					callback : function(data) {
						showArray = data.objList;
						currentPage = data.currentPage;
						pageCount = data.pageCount;
						showli();
					}
				});
			}

			// 显示列表
			function showli() {
				$(div).html("");
				var showLength = showArray.length;
				if (showLength < 1) {
					return;
				}
				var str = "";
				for ( var i = 0; i < showLength; i++) {
					var obj = showArray[i];
					var desc = getDesc(obj);
					var lab = settings.feild.lable;
					var className = "";
					if(i%2 == 1){
						className = "line1";
					}
					str += "<p title=\"" + obj[lab] + "\"  class=\"" + className + "\" type=\"selectItem\" " + desc + ">" + obj[lab] + "</p>";
				}
				$(div).append(str);
				$("p[type=selectItem]").click(function() {
					$(iupt).val($(this).html());
					var valueName = settings.feild.value;
					$(hidden).val($(this).attr(valueName));
					currentPage = 1;
					$(div).hide();
					if (!$.isEmpty(settings.selectFun)) {
						settings.selectFun($(this),$(iupt));
					}
				});
				$("p[type=selectItem]").mouseover(function() {
					$(this).addClass("pover");
				});
				$("p[type=selectItem]").mouseout(function() {
					$(this).removeClass("pover");
				});

				showPage();
				$(div).show();
				setPosition();
			}
			
			function getDesc(obj){
				var propStr = '';
				for(var prop in obj){
					propStr += ' ' + prop + '="' + obj[prop] + '"';
				}
				return propStr;
			}
			
			function setPosition() {
				var leftv = $(iupt).offset().left;
				var topv = $(iupt).offset().top + $(iupt).outerHeight();
				$(div).offset({
					left : leftv,
					top : topv
				});
			}

			// 显示分页
			function showPage() {
				var s = "<p class=\"footer\">";
				s += "<a id=\"pageraUp\" href=\"javascript:void(0)\">上一页</a>&nbsp;&nbsp;&nbsp;";
				s += "<span id=\"pagerSpan\">" + currentPage + "/" + pageCount + "</span>&nbsp;&nbsp;&nbsp;";
				s += "<a id=\"pageraDown\" href=\"javascript:void(0)\">下一页</a></p>";
				$(div).append(s);
				$("#pageraUp").click(function() {
					currentPage--;
					currentPage = currentPage < 1 ? 1 : currentPage;
					getShowData();
				});
				$("#pageraDown").click(function() {
					currentPage++;
					currentPage = currentPage > pageCount ? pageCount : currentPage;
					getShowData();
				});
			}

			function getValue(inptLab) {
				if ($.isEmpty(showArray)) {
					return "";
				}
				var showLength = showArray.length;
				if (showLength < 1) {
					return;
				}
				for ( var i = 0; i < showLength; i++) {
					var obj = showArray[i];
					var lab = settings.feild.lable;
					if (obj[lab] == inptLab) {
						var valueName = settings.feild.value;
						return obj[valueName];
					}
				}
				return "";
			}

			// 参数
			function selectBoxOption() {
				var opb = {
					url : "",
					feild:{
						value:"value",
						lable:"lable"
					},
					param : null,
					selectFun : null
				};
				return opb;
			}
		}
	});
})($);