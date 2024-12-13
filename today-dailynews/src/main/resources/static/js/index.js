
$(function() {
	// 화면 로드 시 메인 애니메이션
	const elements = document.querySelectorAll('.animated');
	elements.forEach((e) =>{
		setTimeout(() =>{
			e.classList.add('visible');
		}, 100);
	})
	
	// 구독 버튼 클릭 시 모달 팝업을 띄운다.
	const subscribeElements = document.querySelectorAll('.subscribe');
	subscribeElements.forEach(function(subscribeElement){
		subscribeElement.addEventListener('click', function(){
			const modal = document.getElementById('previewModal');
			const modalBg = document.getElementById('modalBg');
			modal.style.display = 'block';
			modalBg.style.display = 'block';
			setTimeout(()=>{
				modal.classList.add('show');
			}, 10);
		});
	});
	
	// 닫기 버튼을 누르면 모달 팝업을 닫는다.
	document.getElementById('closeModal').addEventListener('click', function() {
		const modal = document.getElementById('previewModal');
		const modalBg = document.getElementById('modalBg');
		modal.classList.remove('show');
		setTimeout(()=>{
			modal.style.display = 'none';
			modalBg.style.display = 'none';
		}, 300);
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

