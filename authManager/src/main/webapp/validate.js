$(document).ready(function () {	
	var regEx = /^\d*(?:[\.\,]?|$)[^\D]+$/;
	
	$('input[type="text"]').on({
		keyup: function (e) {
			if ($(this).val().search(regEx) == -1) {
				$(this).removeClass('valid');
				$(this).siblings('.error').css('display', 'inline');
			} else {				
				$(this).addClass('valid');
				$(this).siblings('.error').css('display', 'none');
			}
			if ($('.valid').length == 4) {
				$('#html').attr('disabled', false).val('Oblicz');
				$('#pdf').attr('disabled', false).val('Exportuj do PDF');
			} else {
				$('#html, #pdf').attr('disabled', true).val('Popraw błędy !!!');
			}
		},
		blur: function (e) {
			if ($(this).val().search(regEx) == -1) {
				$(this).removeClass('valid');
				$(this).siblings('.error').css('display', 'inline');
			} else {				
				$(this).addClass('valid');
				$(this).siblings('.error').css('display', 'none');
			}
			if ($('.valid').length == 4) {
				$('#html').attr('disabled', false).val('Oblicz');
				$('#pdf').attr('disabled', false).val('Exportuj do PDF');
			} else {
				$('#html, #pdf').attr('disabled', true).val('Popraw błędy !!!');
			}
		}
	});
});