/**
 * ajax2
 */

console.log(svc.add(10, 20));
//목록 출력 메소드
svc.replyList(263,//게시글번호 
	function(result) {
		console.log(result);
		result.forEach(function(item) {
			let tr = makeRow(item);//tr body에 추가
			document.querySelector('table:nth-of-type(2) > tbody')
				.appendChild(makeRow(item));
		});//댓글 수 만큼 tr생성
	}, //성공시 콜백 함수
	function(err) {
		console.error(err);
	})//실패시 콜백 함수

//등록 이벤트
document
	.querySelector("#addReply")
	.addEventListener('click', addReplyFnc);

function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	//fetch(url, option) => post 요청
	// 필수 입력
	if (!bno || !reply || !logId) {
		alert('필수값 입력!!');
		return;
	}//메소드 호출 키:값
	svc.addReply({ bno, reply, replyer: logId },
		function(result) {
			if (result.retCode == 'Success') {
				alert('성공');

				let tr = makeRow(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) > tbody tr');
				document.querySelector('table:nth-of-type(2) > tbody')
					.insertBefore(tr, target);
			} else {
				alert('실패');
			}
		},
		function(err) {
			console.error(err);
		}
	);
}






//삭제 메소드
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result) {
			if (result.retCode == 'Success') {
				alert('성공');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('실패');
			}
		},
		function(err) {
			console.error(err);
		}
	)
}//end of deleteReplyFnc