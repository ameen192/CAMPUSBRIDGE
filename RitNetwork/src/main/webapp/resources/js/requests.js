$.ajaxSetup({
    cache: false
});

$(function() {
	
	$.ajaxSetup({
	    cache: false
	});
	
	function req_refresh_fun()					//req_refresh function
	{
		$(".unresponded").hide();
		$(".reunresponded").load(location.href + " .unresponded");
		another();
		
	}
	function another(){
		$(".responded").hide();
		$(".reresponded").load(location.href + " .responded");
	}
	
	$(document).on('click', '#refreshreq', function(){
		req_refresh_fun();
	});
	
	$(document).on('click','#req_but',function(){					//insert request						
		if(($.trim($('#req_title').val())) == ''){
			$('#reqtitleSpan').html('insert title<br>');
			return;
		}
		var title = $('#req_title').val();
		if(($.trim($('#req_textarea').val())) == ''){
			$('#reqtextSpan').html('insert description<br>');
			return;
		}
		var desc = $('#req_textarea').val();
		$.ajax({
			url : 'insReq',
			cache : false,
			data: {
				req_title : title,
				desc : desc
			},
			type : 'POST',
			success : function(data){
				$('#req_title').val('');
				$('#req_textarea').val('');
				req_refresh_fun();	
			}
		});
	});
	
	
	
	$(document).on('click','.resp_but',function(){
		$(this).siblings('.response_area').dialog({
			title : 'enter response details',
			modal : true,
			height : 350,
			width: 700,
			resizable: false,
			buttons :{
				Cancel: function() {
					$(this).dialog("close");
					req_refresh_fun();
	            },
			}
		});
	});
	
	$(document).on('click','.intrestednum', function(){
		$(this).siblings('.interestednumdialog').dialog({
			title : 'enter response details',
			modal : true,
			height : 350,
			width: 300,
			resizable: false,
			buttons :{
				OK: function() {
					$(this).dialog("close");
					req_refresh_fun();
	            },
			}
		});
	});
	
	$(document).on('click','.in_resp_butt', function(){
		var present = $(this);									//request response
		$(this).parent().addClass('respClass');
		var reqid = $(this).attr('rel');
			if(($.trim($('.respClass > .resp_textarea').val())) == ''){
				$('.respClass > .textSpan').html('cant leave blank<br>');
				return;
			}
			if($('.respClass > .datepicker').val() == ''){
				$('.respClass > .dateSpan').html('select date');
				return;
			}
		var resp_textarea = $('.respClass > .resp_textarea').val();
		var date = $('.respClass > .datepicker').val();
			$.ajax({
				url : 'insertResp',
				cache : false,
				data: {
					reqid : reqid,
					resp_textarea : resp_textarea,
					date : date
				},
				type : 'POST',
				success : function(){
					$('.respClass > .resp_textarea').val('');
					present.parent('.response_area').dialog("close");
					present.parent().removeClass('respClass');
					$('.datepicker').datepicker();
					req_refresh_fun();
				}
			});
	});
	
	$(document).on('click', '.req_interested', function(){
		var present = $(this);
		var reqid = $(this).attr('rel');
			$.ajax({
				url : 'reqInterested',
				cache : false,
				data: {
					reqid : reqid,
				},
				type : 'POST',
				success : function(data){
						req_refresh_fun();
				}
			});
	});
	
	
	
	
	$('.datepicker,.resp_textarea,#notice_textarea,.ansTextArea,#req_title,#req_textarea,#placeselect').on('click', function(){
		$('.dateSpan').html('');
		$('.textSpan').html('');
		$('#noticeSpan').html('');
		$('.ansSpan').html('');
		$('#reqtitleSpan').html('');
		$('#reqtextSpan').html('');
	});
	
});