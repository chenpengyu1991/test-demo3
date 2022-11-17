(function($)
{

	var ieVersion = 999;
	if (navigator.appVersion.indexOf("MSIE") != -1)
	{
		ieVersion = parseFloat(navigator.appVersion.split("MSIE")[1]);
	}

	var WRAP_TMPL = '<div class="placeholder" style="position: relative;display:' + (ieVersion > 7 ? 'inline-block' : 'inline') + ';zoom:1;"></div>';
	var TIP_TMPL = '<label style="display: none;color:#999;cursor: text;margin-left: 5px;position:absolute;left:0;top:1;">{tip}</label>';
	var isSupport = "placeholder" in document.createElement("input");

	$.fn.placeholder = function(callback, cfg)
	{
		if (isSupport)
		{
			this.on('blur', function(ev)
			{
				if ($(this).val() && callback)
				{
					callback($(this));
				}
			});
			return null;
		}
		return new Placeholder(this, callback, cfg);
	}

	var Placeholder = function(item, callback, options)
	{
		this.item = item;
		this.callback = callback;
		options = $.extend({}, this._defaults, options);
		this._init(item, options);
	};
	Placeholder.prototype = {
		constructor : Placeholder,
		_defaults : {

		},
		_init : function(target, cfg)
		{
			var self = this;

			if (!target)
			{
				return;
			}

			var placeHolderTip = target.attr('placeholder');

			if (!placeHolderTip)
				return;

			target.on('blur', function(ev)
			{
				if (!target.val())
				{
					self.triggerLabel.show();
				} else
				{
					if (self.callback)
						self.callback(target);
				}
			});

			if (isSupport)
				return;

			target.on('focus', function(ev)
			{
				self.triggerLabel.hide();
			});

			function _decorate()
			{
				var str = TIP_TMPL.replace("{tip}", placeHolderTip);
				var triggerLabel = self.triggerLabel = $(str);
				triggerLabel.css("width", target.css("width"));
				triggerLabel.css("font-size", target.css("font-size"));

				if (target.attr('id'))
				{
					triggerLabel.attr('for', target.attr('id'));
				} else
				{
					triggerLabel.on('click', function()
					{
						target.focus();
					});
				}

				var targetBox = $(WRAP_TMPL);
				targetBox.appendTo(target.parent()).append(target);

				triggerLabel.insertBefore(target);

				target.blur();
			};

			_decorate();

		}
	};

})(jQuery);