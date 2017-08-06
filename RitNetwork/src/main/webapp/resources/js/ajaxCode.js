// ajax code for login
$.ajaxSetup({
    cache: false
});

$(function() {

		$(document).on('blur','#login_email', function(){		//login page
			//alert("on blur");
			if ($.trim($('#login_email').val()) != '') {
				var attr = $(this).attr('name');
				var value = $(this).val();
				//alert("attr value: "+attr+" value :"+value);
				$.post('LoginAjaxServ',{email : attr, value : value }, function(data){
					//alert("after call");
					$('#login_ajax').append(data);
//					if (data == 'true') {
//						$('#login_ajax').append("invalid username");
//						$('#login_ajax').append("<br>");
//						$('#login_sub').prop('disabled',true);
//					}else{
//						$('#login_ajax').html('');
//						$('#login_sub').prop('disabled',false);
//					}
				});
			}

		});

		

		$("body").on("click", ".datepicker", function(){
            $(this).datepicker();
            $(this).datepicker("show");
    	});

		$(document).on('click','#login_email', function(){		//login page
			$(login_ajax).html('');
			$('#login_sub').prop('disabled',false);
		});


//registration page		
		$('#reg_email').on('blur', function(){					
			if ($.trim($(this).val()) != '') {
				var attr = $(this).attr('name');
				var value = $(this).val();
				$.post('ajaxLogin.php',{attr : attr, value : value }, function(data){
					if (data == false) {
						$('#emailSpan').html('already exists<br>');
						$('#sub_but').prop('disabled',true);
						return;
					}
				});
				
			}
		});

		$('#reg_fid').on('blur', function(){
			if ($.trim($(this).val()) != '') {
				var attr = $(this).attr('name');
				var value = $(this).val();
				$.post('ajaxLogin.php',{ attr : attr, value : value  }, function(data){
					if (data == false) {
						$('#fidSpan').html("already exists<br>");
						$('#sub_but').prop('disabled',true);
						return;
					}
				});
			}

		});

alert("ajax code page running again");
		$('#reg_usn').on('blur', function(){
			if ($.trim($(this).val()) != '') {
				var attr = $(this).attr('name');
				var value = $(this).val();
				$.post('ajaxLogin.php',{attr : attr, value : value  }, function(data){
					if (data == false) {
						$('#usnSpan').html("already exists<br>");
						$('#sub_but').prop('disabled',true);
						return;
					}
				});
				
			}

		});

		$('#reg_email,#reg_usn,#reg_fid').on('click', function(){

			$('#emailSpan,#fidSpan,#usnSpan').html('');
			$('#sub_but').prop('disabled',false);
		});
// end of registration


//profile division code

		$(document).on('click', '.sprof_edit_button', function(){    //student update profile

			var name = $('.sedit_name').text();
			var sem = $('.sedit_sem').text();
			var about = $('.sedit_about').text();
			var skills = $('.sedit_skills').text();
			var hobbies = $('.sedit_hobbies').text();
			var phno = $('.sedit_phno').text();
			
			$.ajax({
				url : 'updateStud',
				cache : false,
				data: {
					name : name,
					sem : sem,
					about : about,
					skills : skills,
					hobbies : hobbies, 
					phno : phno
				},
				type : 'POST',
				success : function(data){
						$(":button").addClass("btn btn-primary");
						$(".reprof_container").load(location.href + " .prof_container");
				}
			});

		});

		$(document).on('click', '.fprof_edit_button', function(){				//update faculty profile

			var name = $('.fedit_name').text();
			var subs = $('.fedit_subs').text();
			var about = $('.fedit_about').text();
			var phno = $('.fedit_phno').text();

			$.ajax({
				url : 'updateFac',
				cache : false,
				data: {
					name : name,
					subs : subs,
					about : about, 
					phno : phno
				},
				type : 'POST',
				success : function(data){
					$(":button").addClass("btn btn-primary");
					$('.prof_container').hide();
					$(".reprof_container").load(location.href + " .prof_container");
				}
			});

		});


		$(document).on('click', '#post_notice_butt', function(){
						if(($.trim($('#notice_textarea').val())) == ''){
							$('#noticeSpan').html('blank notice :-(');
		 					return;
		 				}
		 	var desc = $('#notice_textarea').val();

		 	var dept = $('#filter_Dept').val();
		 		if(dept == 'all'){
		 			var course = 'all';
		 			var sem = 'all';
		 		}else if (dept == 'compapp') {
		 			var course = $('#filter_course_mca').val();
		 			var sem = $('#filter_sem').val();
		 		}else if(dept == 'engn'){
		 			var course = $('#filter_course_engn').val();
		 			var sem =  $('#filter_sem').val();
		 		}

		 	$.ajax({

		 		url : 'insNotice',
		 		cache : false,
		 		data : {
		 			desc : desc,
		 			dept : dept,
		 			course : course,
		 			sem : sem
		 		},
		 		type: 'POST',
		 		success : function(data){
		 				notice_refresh_fun();
		 				$('#notice_textarea').val('');
		 		}

		 	});
		});


		$(document).on('click', '.del_notice', function(){
			var id = $(this).attr('rel');
			$.ajax({
				url : 'delNotice',
				cache : false,
				data: {
					id : id
				},
				type : 'POST',
				success : function(data){
					notice_refresh_fun();
				}
			});

		});


		$(document).on('click', '#notice_refresh', function(){				//refresh button of notice refresh
			notice_refresh_fun();
		});

		function notice_refresh_fun()
			{
				alert("notice refresh called");
				$('.fetch_notice').hide();
				$(".refetch_notice").load(location.href + " .fetch_notice");
			}



		$(document).on('click', '.verify_user', function(){					//verify update student
			var usn = $(this).attr('rel');
			var email = $(this).attr('email');
			$.ajax({
				url : 'verifyusers.php',
				cache : false,
				data: {
					to : 'update',
					usn : usn,
					email: email
				},
				type : 'POST',
				success : function(data){
					$('.verify1').hide();
					$(".verify2").load(location.href + " .verify1");	
				}
			});
		});


		$(document).on('click', '.reject_user', function(){					//verify reject student
			var usn = $(this).attr('rel');
			$.ajax({
				url : 'verifyusers.php',
				cache : false,
				data: {
					to : 'reject',
					usn : usn
				},
				type : 'POST',
				success : function(data){
					//$('#notice_textarea').val(data);
					$('.verify1').hide();
					$(".verify2").load(location.href + " .verify1");	
				}
			});
		});



		$(document).on('click', '#place_but', function(){ 					//insert placement
			var comname = $('#comp_name').val();
			var lpa = $('#package').val();
			var desc = $('#comp_textarea').val();
			var date = $('#placedate').val();
			var fid = $('#place_but').attr('rel');
			var selected = $('#placeselect').val();
			if(selected == 'empty'){
				$('#packageSpan').val('select course');
				return;
			}else if(selected == 'mca'){
				var sem1 = 5;
				var sem2 = 6;
			}else{
				var sem1 = 7;
				var sem2 = 8;
			}
				$.ajax({
				url : 'insertQuesAjax.php',
				cache : false,
				data: {
					comname : comname,
					lpa : lpa,
					fid : fid,
					desc : desc,
					date : date,
					selected: selected,
					sem1 : sem1,
					sem2: sem2
				},
				type : 'POST',
				success : function(data){
						$('#comp_textarea').val(data + 'from ajax');
						place_refresh_fun();
						$('#placedate').datepicker();
				}
			});
		});

		function place_refresh_fun()
			{
				$('.placeArea').hide();
				$(".replaceArea").load(location.href + " .placeArea");
			}


});

























