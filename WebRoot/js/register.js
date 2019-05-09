// JavaScript Document
$(function(){
	$(".register p .txtinfo").focus(function(){
		$(this).parent().find(".tipinfo").show();
		});
		$(".register p .txtinfo").blur(function(){
		$(this).parent().find(".tipinfo").hide();
		});
	});