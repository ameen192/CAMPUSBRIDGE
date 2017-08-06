$.ajaxSetup({
    	cache: false
	});

function refresh()
{
	$(".loadhere").load(location.href + " .QnA_list");
}

//qanda

$(function(){
	
	$.ajaxSetup({
    	cache: false
	});
	
	
	
	
 		 $(document).on('click','#ask_ques', function(){
 		 	var quest = $('#ques_textarea').val();
		 	$('#ques_textarea').val('');
			$.ajax({
				url : 'insQues',
				data: {
					ques : quest
				},
				type : 'POST',
				success : function(data){
					if(data == "true"){
						$('#ques_textarea').val('');
						$('#newest').hide();
						refresh();	
					}else{
						$('#ques_textarea').val('an error occured!!');
					}
					
				}
		 	});


		 });
 alert("qna jquery working again");

		$(document).on('click','.del_but', function(){
				var $ans = $(this).siblings('.ans_but');										 
				var vquesID = $(this).attr("rel");
				$.ajax({
						url : 'insertQuesAjax.php',
						type : 'POST',
						data: {
							qID : vquesID
						},
						success : function(data){
							$('#newest').hide();
							refresh();
						},
				});
		});

		$(document).on('click', '#refreshqna', function(){
			refresh();
		});

		$(document).on('click','.sub_ans', function(){						//submit answer code in insertquesajax.php
			alert("clicked submit");
			var vquesID = $(this).attr("rel");
			if (($.trim($(this).siblings('.ansTextArea').val()) != '')) {
				var ansDesc = $(this).siblings('.ansTextArea').val();
				$(this).parent('.anser_textarea').slideUp();
				$(this).parent().siblings('.ans_but,.del_but,.ans_view').slideDown();
			}else{
				$(this).siblings('.ansSpan').html('please enter a valid answer<br>');
				return;
			}
			alert(vquesID+" "+ansDesc);
			$.ajax({
				url : 'insans',
				cache : false,
				data: {
					quesid : vquesID,
					ansDesc : ansDesc,
				},
				type : 'POST',
				success : function(data){
					alert("submit ans success");
					$('#newest').hide();
					refresh();
				}
			});


		});
		
		$(document).on('click','.ans_but', function(){
			$(this).hide();
			$(this).siblings('.del_but,.ans_view').hide();
			$(this).siblings('.anser_textarea').slideDown();     

		});

		$(document).on('click','.can_ans', function(){
			$(this).parent('.anser_textarea').slideUp();
			$(this).parent().siblings('.ans_but,.del_but,.ans_view').slideDown();
		});
		
		$(document).on('click', '.ans_view', function(){
			$(this).parent().siblings('.ans_list').slideToggle();
			var val = $(this).text() == 'view answers' ? 'hide answers' : 'view answers';
			$(this).html(val);
		});


});