/*!
 * jQuery Placeholder plugin
 *
 * This plugin is used to support the HTML5 placeholder attribute on most non-HTML5-compliant browsers.
 * 
 * Usage: $.Placeholder.init({ color : "rgb(0,0,0)" });
 * 
 * Date: Sept 2011
 * Author: Otacon (byf1987_at_gmail.com)
 * Project page: https://code.google.com/p/jquery-placeholder-js/
 * Version: 1.3
 * Changelog: 
    1.3 Added cleanBeforeSubmit global function, so that user can call before submitting form by JS. thanks to Krzysztof (kot**********ztof_at_gmail.com) for contributing this idea and some codes.
    1.2 Added semicolons to the end of function, so that the min version work. thanks to Tony (ty*****_at_gmail.com) for pointing this out and providing fix.
	1.1	Updated the code to meet jQuery plugin format. Added parameterized init. 
 	1.0 Initial release.
 * Tested on: Chrome (latest dev version); IE6 (IETester); IE8 (IETester)
 * Known Issues: 
 * 	Placeholder for Password is currently not supported
 */
(function($)
{
	$.Placeholder = {
		settings : {
			color : "rgb(169,169,169)", // 提示字体颜色
			dataName : "original-font-color", // 原字体颜保存data属性
			query : null,// 选择器
			callback : null
		// blur回调
		},

		// -- Bind event to components --
		init : function(settings)
		{
			// Merge default settings with the ones provided
			if (settings)
			{
				$.extend($.Placeholder.settings, settings);
			}

			// -- Util Methods --
			var getContent = function(element)
			{
				return $(element).val();
			};

			var setContent = function(element, content)
			{
				$(element).val(content);
			};

			var getPlaceholder = function(element)
			{
				return $(element).attr("placeholder");
			};

			var isContentEmpty = function(element)
			{
				var content = getContent(element);
				return (content.length === 0) || content == getPlaceholder(element);
			};

			var setPlaceholderStyle = function(element)
			{
				$(element).data($.Placeholder.settings.dataName, $(element).css("color"));
				$(element).css("color", $.Placeholder.settings.color);
			};

			var clearPlaceholderStyle = function(element)
			{
				$(element).css("color", $(element).data($.Placeholder.settings.dataName));
				$(element).removeData($.Placeholder.settings.dataName);
			};

			var showPlaceholder = function(element)
			{
				setContent(element, getPlaceholder(element));
				setPlaceholderStyle(element);
			};

			var hidePlaceholder = function(element)
			{
				if ($(element).data($.Placeholder.settings.dataName))
				{
					setContent(element, "");
					clearPlaceholderStyle(element);
				}
			};

			// -- Event Handlers --
			var inputFocused = function()
			{
				if (isContentEmpty(this))
				{
					hidePlaceholder(this);
				}
			};

			var inputBlurred = function()
			{
				if (isContentEmpty(this))
				{
					showPlaceholder(this);
				} else
				{
					if ($.Placeholder.settings.callback)
					{
						$.Placeholder.settings.callback(this);
					}
				}
			};

			var parentFormSubmitted = function()
			{
				if (isContentEmpty(this))
				{
					hidePlaceholder(this);
				}
			};

			// -- Execution --
			if ($.Placeholder.settings.query)
			{
				$($.Placeholder.settings.query).each(function(index, element)
				{
					if ($(element).attr("placeholder"))
					{
						$(element).focus(inputFocused);
						$(element).blur(inputBlurred);
						// triggers show place holder on module init
						// $(element).trigger("blur");
						// triggers form submitted event on parent form submit
						// $(element).parents("form").submit(function(){
						// parentFormSubmitted(element);
						// });
						if (isContentEmpty(this))
						{
							showPlaceholder(this);
						}
					}
				});
			}

			return this;
		}

	// When form is submitted by JS, call this before submit to avoid submitting
	// the placeholder value
	// cleanBeforeSubmit : function(){
	// $($.Placeholder.settings.query).each(function(index, element){
	// parentFormSubmitted(element);
	// });
	// }
	};
})(jQuery);
