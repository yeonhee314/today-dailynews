
$(function() {
	// 구독 버튼 클릭 시 모달 팝업을 띄운다.
	const subscribeElements = document.querySelectorAll('.subscribe');
	subscribeElements.forEach(function(subscribeElement){
		subscribeElement.addEventListener('click', function(){
			document.getElementById('previewModal').style.display = 'block';
			document.getElementById('modalBg').style.display = 'block';
		});
	});
	
	// 닫기 버튼을 누르면 모달 팝업을 닫는다.
	document.getElementById('closeModal').addEventListener('click', function() {
		document.getElementById('previewModal').style.display = 'none';
		document.getElementById('modalBg').style.display = 'none';
	});
	
	// 구독 처리
	$('#sub-apply').on('submit', function(e){
		e.preventDefault();
		const formData = new FormData(this);
		formData.append('name', $('#userName').val());
		formData.append('email', $('#userMail').val());
		formData.append('sub_path', $('#userSubPath').val());

		$.ajax({
			url: '/subscribe',
			type: 'POST',
			processData: false,
			contentType: false,
			data: formData,
			success: function(response){
				alert(response.message);
				window.location.href="/daily-news";
			},
			error: function(request, status, error) {
				console.error("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert('구독에 실패했습니다. 관리자에게 문의하세요.');
			 }
		});
	});
});

