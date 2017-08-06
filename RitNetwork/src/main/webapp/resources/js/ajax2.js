$.ajaxSetup({
    cache: false
});


$(function(){

	 function redatepicker(){
			$('.datepicker').datepicker({
				 minDate: 0,
				 maxDate: '+2m',
				 numberOfMonths: [1, 2],
				 dateFormat: 'yy-mm-dd'
			});
			$('#placedate').datepicker({
				minDate: 0,
				maxDate: '+2m',
				numberOfMonths: [1, 2],
				dateFormat: 'yy-mm-dd'
			});
			$('.actdate').datepicker({
				minDate: 0,
				maxDate: '+2m',
				numberOfMonths: [1, 2],
				dateFormat: 'yy-mm-dd',
				onSelect: function(){
			        $('.actenddate').datepicker('option', 'minDate', $(".actdate").datepicker("getDate"));
			    },
			});
			$('.actenddate').datepicker({
				minDate: new Date(),
				maxDate: '+2m',
				numberOfMonths: [1, 2],
				dateFormat: 'yy-mm-dd'
			});
			$('.acttime, .actendtime').timepicker({
			    timeFormat: 'hh:mm:ss',
			    interval: 30,
			    minTime: '9',
			    maxTime: '6:00pm',
			    //defaultTime: '11',
			    startTime: '9:00',
			    dynamic: false,
			    dropdown: true,
			    scrollbar: true
			});
		}

	redatepicker();
//alert("ajax2 page running");

});