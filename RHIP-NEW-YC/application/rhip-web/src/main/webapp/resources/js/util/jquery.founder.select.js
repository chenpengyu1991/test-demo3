(function($)
{
	$.extend($.fn, {
		inputSize : function()
		{
			var objHeight = this.outerHeight();
			var objWidth = this.outerWidth();
			var size = {
				width : objWidth,
				height : objHeight
			};
			return size;
		},
		createtDiv : function()
		{
			$("div[ref=" + $(this).attr("id") + "]").undelegate();
			$("div[ref=" + $(this).attr("id") + "]").remove();
			var divId = "founder-select-div" + parseInt(Math.random() * 10000000);
			var selectDiv = $("<div id=\"" + divId + "\" ref=\"" + $(this).attr("id") + "\" style=\"position:absolute;z-index:99999999999999999999999;\"></div>");
			var size = this.inputSize();
			var ulleft = this.offset().left;
			var ulTop = this.offset().top + size.height;
			selectDiv.offset({
				left : ulleft,
				top : ulTop
			});

			selectDiv.css("min-width", size.width);
			// selectDiv.width(this.width());
			$("body").append(selectDiv);
			selectDiv.addClass("founderSelectDiv");
			selectDiv.hide();
			return selectDiv;
		},
		selectBox : function(option)
		{
			var pageSize = 10, currentPage = 1, pageCount = 1, showArray = new Array(), divClick = false, iupt = $(this);
			var op = selectBoxOption();
			var settings = $.getOption(op, option);

			var div = iupt.createtDiv();
			var hidden = $("input[ref=" + iupt.attr("id") + "]");

			iupt.off("keyup",getShowDataAgain);
			iupt.off("click",getShowDataAgain);
			div.off("click",divClickFun);

			$("*").on("scroll", setPosition);
			iupt.on("keyup", getShowDataAgain);
			iupt.on("click", getShowDataAgain);
			div.on("click", divClickFun);

			function getShowDataAgain(event)
			{
				if (event.keyCode == 13)
				{
					return;
				}
				currentPage = 1;
				getShowData();
			}

			function divClickFun()
			{
				divClick = true;
				iupt.focus();
			}

			iupt.blur(function()
			{
				var value = getValue($(iupt).val());
				
				if(value=="" && settings.submitEdit){
					value = $(iupt).val();
				}
				
				$(hidden).val(value);

				setTimeout(function()
				{
					if (!divClick)
					{
						$(div).html("");
						$(div).hide();
					}
					divClick = false;
				}, 350);
			});

			// 查询数据
			function getShowData()
			{
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
					callback : function(data)
					{
						showArray = data.objList;
						currentPage = data.currentPage;
						pageCount = data.pageCount;
						showli();
					}
				});
			}

			// 显示列表
			function showli()
			{
				$(div).html("");
				var showLength = showArray.length;
				if (showLength < 1)
				{
					return;
				}
				var str = "";
				for ( var i = 0; i < showLength; i++)
				{
					var obj = showArray[i];
					var desc = getDesc(obj);
					var lab = settings.feild.lable;
					var className = "";
					if (i % 2 == 1)
					{
						className = "line1";
					}
					str += "<p title=\"" + obj[lab] + "\"  class=\"" + className + "\" type=\"selectItem\" " + desc + ">" + obj[lab] + "</p>";
				}
				$(div).append(str);
				$("p[type=selectItem]").click(function()
				{
					$(iupt).val($(this).html());
					var valueName = settings.feild.value;
					$(hidden).val($(this).attr(valueName));
					currentPage = 1;
					$(div).hide();
					if (!$.isEmpty(settings.selectFun))
					{
						settings.selectFun($(this), $(iupt));
					}
				});
				$("p[type=selectItem]").mouseover(function()
				{
					$(this).addClass("pover");
				});
				$("p[type=selectItem]").mouseout(function()
				{
					$(this).removeClass("pover");
				});

				showPage();
				$(div).show();
				setPosition();
			}

			function getDesc(obj)
			{
				var propStr = '';
				for ( var prop in obj)
				{
					propStr += ' ' + prop + '="' + obj[prop] + '"';
				}
				return propStr;
			}

			function setPosition()
			{
				var leftv = $(iupt).offset().left;
				var topv = $(iupt).offset().top + $(iupt).outerHeight();
				$(div).offset({
					left : leftv,
					top : topv
				});
			}

			// 显示分页
			function showPage()
			{
				var s = "<p class=\"footer\">";
				s += "<a id=\"pageraUp\" href=\"javascript:void(0)\">上一页</a>&nbsp;&nbsp;&nbsp;";
				s += "<span id=\"pagerSpan\">" + currentPage + "/" + pageCount + "</span>&nbsp;&nbsp;&nbsp;";
				s += "<a id=\"pageraDown\" href=\"javascript:void(0)\">下一页</a></p>";
				$(div).append(s);
				$("#pageraUp").click(function()
				{
					currentPage--;
					currentPage = currentPage < 1 ? 1 : currentPage;
					getShowData();
				});
				$("#pageraDown").click(function()
				{
					currentPage++;
					currentPage = currentPage > pageCount ? pageCount : currentPage;
					getShowData();
				});
			}

			function getValue(inptLab)
			{
				if ($.isEmpty(showArray))
				{
					return "";
				}
				var showLength = showArray.length;
				if (showLength < 1)
				{
					return;
				}
				for ( var i = 0; i < showLength; i++)
				{
					var obj = showArray[i];
					var lab = settings.feild.lable;
					if (obj[lab] == inptLab)
					{
						var valueName = settings.feild.value;
						return obj[valueName];
					}
				}
				return "";
			}

			// 参数
			function selectBoxOption()
			{
				var opb = {
					url : "",
					feild : {
						value : "value",
						lable : "lable"
					},
					submitEdit:false,
					param : null,
					selectFun : null
				};
				return opb;
			}
			return option;
		}
	});
	$.extend($.fn, {

		initTreeSelect : function(option)
		{
			var setting = {
				url : "",
				field : {
					value : "id",
					label : "name",
					parentValue : "pId",
					rootValue : null,
					type : "type"
				},
				param : {},
				selectFun : null,
				unSelecteType : []
			};

			$.extend(setting, option);

			var treeSetting = {
				view : {
					dblClickExpand : false,
					selectedMulti : false
				},
				data : {
					simpleData : {
						enable : true,
						idKey : setting.field.value,
						pIdKey : setting.field.parentValue,
						rootPid : setting.field.rootValue
					},
					key : {
						name : setting.field.label
					}
				},
				callback : {
					beforeClick : beforeClick,
					onClick : treeClick
				},
				check : {
					enable : false
				}
			};

			var idKey = setting.field.value;
			var nameKey = setting.field.label;
			var typeKey = setting.field.type;
			var unSelecteType = setting.unSelecteType;
			
			var selectCallback=setting.selectFun;

			var $this = this;
			var id = $this.attr("id");

			// TODO
			var treeContentId = id + "TreeContent";
			var btnId = id + "ShowTreeBtn";
			var treeId = id + "Tree";

			//
			var $value = $("input[ref=" + id + "]");
			var $treeContent = $("#" + treeContentId);
			var $showTreeBtn = $("#" + btnId);

			$showTreeBtn.show();
			// 弹出树按钮
			$showTreeBtn.click(showTree);

			// 设置下拉最小宽度
			var size = $this.inputSize();
			$treeContent.css("min-width", size.width);
			$treeContent.css("z-index", 1970001);

			// 数据源
			var zNodes = [];
			var param = setting.param;
			var url = setting.url;
			if (url)
			{
				$.urlPost({
					url : url,
					checkRepeat : false,
					dataType : "json",
					param : param,
					callback : function(data)
					{
						zNodes = data.objList;
						initTree();
					}
				});
			} else
			{
				initTree();
			}

			function initTree()
			{
				// 初始化树
				$.fn.zTree.init($("#" + treeId), treeSetting, zNodes);
				// 设置默认值
				var selected = getNodeByIdKey();
				if (selected)
				{
					$this.val(selected[nameKey]);
				}
			}

			function beforeClick(treeId, treeNode)
			{
				var type = treeNode[typeKey];
				for ( var i = 0, size = unSelecteType.length; i < size; i++)
				{
					if (type == unSelecteType[i])
					{
						return false;
					}
				}
				return true;
			}

			function treeClick(e, treeId, treeNode)
			{
				var zTree = $.fn.zTree.getZTreeObj(treeId);
				var nodes = zTree.getSelectedNodes();
				if (nodes.length > 0)
				{
					var selected = nodes[0];
					$this.val(selected[nameKey]);
					$value.val(selected[idKey]);
					if(selectCallback){
						selectCallback(selected);
					}
					hideTree();
				}
			}

			function showTree()
			{
				var zTree = $.fn.zTree.getZTreeObj(treeId);
				// zTree.expandAll(false);

				var e = window.document.documentElement.clientHeight - ($this.offset().top - $(window).scrollTop()) - 30;
				var height = $treeContent.height();
				if (e < height)
				{
					$treeContent.css({
						top : -height
					});
				} else
				{
					$treeContent.css({
						top : 7 + $this.outerHeight()
					});
				}
				$treeContent.show();
				var selected = getNodeByIdKey();
				if (selected)
				{
					zTree.selectNode(selected);
					//zTree.expandNode(selecteds[0], true, true, true);
				}

				// 实现点击隐藏下拉树
				$(document).on("click", clickSomeWhereListener);
			}

			function getNodeByIdKey()
			{
				var value = $value.val();
				if (value)
				{
					var zTree = $.fn.zTree.getZTreeObj(treeId);
					var selecteds = zTree.getNodesByParam(idKey, value, null);
					if(selecteds&&selecteds.length>0){
						return selecteds[0];
					}
				}
				return null;
			}

			function hideTree()
			{
				$treeContent.hide();
				$(document).off("click", clickSomeWhereListener);
				$this.trigger("validatorEvent");
			}

			function clickSomeWhereListener(event)
			{
				if (!(event.target.id == btnId || isInTreeContent(event.target)))
				{
					hideTree();
				}
			}

			function isInTreeContent(node)
			{
//				var parent = $(node).parentsUntil(".treeContent");
//				if (parent.length > 0)
//				{
//					if (parent.hasClass("ztree"))
//					{
//						return true;
//					}
//				}
//				return false;
				return $.contains($treeContent[0],$(node)[0]);
			}

		}
	});

})($);