

$.ajaxSetup({
    cache: false
});


$(function(){

	$.ajaxSetup({
	    cache: false
	});

alert("myjquery.js is working again");


	$('input:radio[name="type"]').change(function(){
		if($(this).val() == 'student'){
			$('#studdiv :input').attr('required', true);
		    $('#facultydivision').hide();
		    $('#studdiv').slideDown();
		}else if($(this).val() == 'faculty'){
			$('#facultydivision :input').attr('required', true);
			$('#studdiv').hide();
		    $('#facultydivision').slideDown();
		}
	});
	
	$(document).on('change','#deptsel', function(){ 		//registration
    	var value = $(this).val();
    	if (value == 'compApp') {
    		$('#mca').slideDown();
    		$('#engn').hide();
    	}else if(value == 'engn'){
    		$('#mca').hide();
    		$('#engn').slideDown();
    	}else if(value == 'empty'){
    		$('#mca').hide();
    		$('#engn').hide();
    	}
	});

	$(document).on('change','#filter_Dept', function(){			//activties
		var selval = $(this).val();
		if(selval == 'compapp'){
			$('#filter_course_mca').show();
			$('#filter_course_engn').hide();
			$('#filter_sem').slideDown();
		}else if(selval == 'engn'){
			$('#filter_course_mca').hide();
			$('#filter_course_engn').show();
			$('#filter_sem').slideDown();
		}else if(selval == 'all'){
			$('#filter_course_mca').hide();
			$('#filter_sem').hide();
			$('#filter_course_engn').hide();
		}
	});

	$(document).on('click', '#viewprof_radio', function(){
		var selval = $("input[name='type']:checked").val();
		if(selval == 'student'){
			$('#viewfacultiesprof').fadeOut();
			$('#viewstudentsprof').slideDown();
		}else if(selval == 'faculty'){
			$('#viewstudentsprof').slideUp();
			$('#viewfacultiesprof').slideDown();
		}
	});
	
	$(document).on('click','.cardprofview',function(){
		alert("clicked prof view");
		$(this).parent().parent().siblings('.profdialog').dialog({
			title : 'profile details',
			modal : true,
			height : 450,
			width: 800,
			resizable: false,
			buttons :{
				OK: function() {
					$(this).dialog("close");
	            },
			}
		});
	});


	$('#pwd').on('blur', function(){
		if($(this).val().length < 6 && $(this).val().length > 0){
			$('#passSpan').html('too short<br>');
			return;
		}
	});

	$('#pwd').on('click', function(){
		$('#passSpan').html('');
	});

	$('#pwd2').on('blur', function(){
		if(($(this).val() != $('#pwd').val()) && ($(this).val().length > 0)){
			$('#pass2Span').html('password do not match<br>');
			return;
		}
	});

	$('#pwd2').on('click', function(){
		$('#pass2Span').html('');
	});


	// $(document).on('click', '.resp_but', function(){
	// 	var reject = $(this).siblings('.reject_but');
	// 	$(this).hide();
	// 	reject.hide();
	// 	$(this).siblings().slideDown();
	// });

	// $(document).on('click', '.in_canresp_butt', function(){
	// 	$(this).parent().slideUp();
	// 	$(this).parent().siblings('.reject_but,.resp_but').slideDown();
	// });


	
});


















































