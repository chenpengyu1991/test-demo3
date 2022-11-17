(function ($) {

    "use strict";

    $.fn.boxRefresh = function (options) {
        var loadStart = options.loadStart;
        var loadDone = options.loadDone;
        var trigger = options.trigger == null?'.box-value':options.trigger;
        // Render options
        var settings = $.extend({
            //Refresh button selector
            trigger: ".refresh-btn",
            //File source to be loaded (e.g: ajax/src.php)
            source: options.url,
            //Callbacks
            onLoadStart: function (box) {
                if(typeof loadStart === 'function'){
                    loadStart(box);
                }
                return box;
            }, //Right after the button has been clicked
            onLoadDone: function (box) {
                if(typeof loadDone === 'function'){
                    loadDone(box);
                }
                return box;
            } //When the source has been loaded

        }, options);

        //The overlay
        var overlay = $('<div class="overlay"><div class="fa fa-refresh fa-spin"></div></div>');

        return this.each(function () {
            //if a source is specified
            if (settings.source === "") {
                if (window.console) {
                    window.console.log("Please specify a source first - boxRefresh()");
                }
                return;
            }
            //the box
            var box = $(this);
            //the button
            var rBtn = box.find('.refresh-btn').first();

            //On trigger click
            rBtn.on('click', function (e) {
                e.preventDefault();
                //Add loading overlay
                start(box);

                //Perform ajax call
                box.find('.box-value').load(settings.source, function () {
                    done(box);
                });
            });
        });

        function start(box) {
            //Add overlay and loading img
            box.append(overlay);

            settings.onLoadStart.call(box);
        }

        function done(box) {
            //Remove overlay and loading img
            box.find(overlay).remove();

            settings.onLoadDone.call(box);
        }

    };

})(jQuery);

(function ($) {

    "use strict";

    $.fn.boxInit = function (options) {
        var loadStart = options.loadStart;
        var loadDone = options.loadDone;
        var trigger = options.trigger == null?'.box-value':options.trigger;
        // Render options
        var settings = $.extend({
            //init content selector
            trigger: trigger,
            //File source to be loaded (e.g: ajax/src.php)
            source: options.url,
            //Callbacks
            onLoadStart: function (box) {
                if(typeof loadStart === 'function'){
                    loadStart(box);
                }
                return box;
            }, //Right after the button has been clicked
            onLoadDone: function (box) {
                if(typeof loadDone === 'function'){
                    loadDone(box);
                }
                return box;
            } //When the source has been loaded

        }, options);

        //The overlay
        var overlay = $('<div class="overlay"><div class="fa fa-refresh fa-spin"></div></div>');

        return this.each(function () {
            //if a source is specified
            if (settings.source === "") {
                if (window.console) {
                    window.console.log("Please specify a source first - boxInit()");
                }
                return;
            }
            //the box
            var box = $(this);
            box.boxRefresh(options);
            start(box);

            //Perform ajax call
            box.find('.box-value').load(settings.source, function () {
                done(box);
            });
        });

        function start(box) {
            //Add overlay and loading img
            box.append(overlay);

            settings.onLoadStart.call(box);
        }

        function done(box) {
            //Remove overlay and loading img
            box.find(overlay).remove();

            settings.onLoadDone.call(box);
        }

    };

})(jQuery);
