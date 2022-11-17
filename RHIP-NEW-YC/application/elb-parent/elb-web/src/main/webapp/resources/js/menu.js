$(document).ready(function() {
	$(".sidemenu ul.nav_menu").hide();
	$(".sidemenu li.parent a.mainMenu").click(function() {
		if ($(this).attr("href") == "javascript:void(0);") {
			if ($(this).hasClass("linkClick")) {
				$(this).parent().find("ul.nav_menu").slideUp();
				$(this).parent().find("a.mainMenu").removeClass("linkClick");
			} else {
				$(this).parent().find("ul.nav_menu").slideDown();
				$(this).parent().find("a.mainMenu").addClass("linkClick");
			}
		} else {
			return true;
		}
	});
});