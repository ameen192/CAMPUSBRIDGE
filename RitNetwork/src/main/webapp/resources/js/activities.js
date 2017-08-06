$.ajaxSetup({
    cache: false
});

$(function() {
	$(document).on('click','#post_actbutt',function(){
		var actdatetime = $('.actdate').val()+' '+$('.acttime').val();
		var actenddate = $('.actenddate').val()+' '+$('.actendtime').val();
		var acttitle = $('#act_title').val();
		var actdesc = $('#act_textarea').val();
		$.ajax({
			url : 'insact',
			data: {
				actdatetime : actdatetime,
				actenddate : actenddate,
				acttitle : acttitle,
				actdesc : actdesc,
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
});