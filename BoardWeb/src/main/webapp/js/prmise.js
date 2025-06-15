/**
 * 
 */
//Promise 객체 = 비동기방식의 처리를 동기방식의 순서로 처리
//목록출력
function add(num1, num2) {
	return num1 + num2;
}
//const add= (num1,num2)=>num1+num2;





fetch('replyList.do?bno=263')
	.then(function(data) {
		console.log(data);//Respnose결과 스트림형태(바이트값)
		return data.json();//json->objct
	})
	.then(function(result) {
		//console.log(result);
		result.forEach(function(item) {
			let tr = makeRow(item);//tr body에 추가
			document.querySelector('table:nth-of-type(2) > tbody')
				.appendChild(makeRow(item));
		});//댓글 수 만큼 tr생성
	})
	.catch(function(err) {//실패결과
		console.log(err);
	})//목록출력




// 댓글 등록
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
	}
	fetch('addReply.do?', {
		method:'post',
		headers: {'Content-type': 'application/x-www-form-urlencoded'},
		body:'bno='+ bno+ '&reply='	+ reply	+ '&replyer='+ logId})
		
		.then(json => json.json())
		.then(result => {
			if (result.retCode == 'Success') {
				alert('성공');

				let tr = makeRow(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) > tbody tr');
				document.querySelector('table:nth-of-type(2) > tbody')
					.insertBefore(tr, target);
			} else {
				alert('실패');
			}
		})
		.catch(err => console.error(err))

}
//삭제
function deleteReplyFnc(e) {
	if (!confirm("삭제하겠습니까?")) {
		return;
	}
	//removeReply.do?rno=23
	let rno = e.target.parentElement.parentElement.dataset.rno;
	//ajax 호출
	fetch('removeReply.do?rno=' + rno)
		.then(json => json.json())
		.then(data => {
			if (data.retCode == 'Success') {
				alert('성공');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('실패');
			}
		})
		.catch(err => console.error(err))
}//end of deletReplyfnc





//댓글을 row 생성
function makeRow(item) {
	let tr = document.createElement('tr'); // <tr></tr>
	tr.setAttribute("data-rno", item.replyNo);
	// 글번호,내용,작성자
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td'); // <td>3</td>
		td.innerHTML = item[prop]; // item['replyNo']
		tr.appendChild(td); // <tr><td>3</td></tr>
	}
	// button생성.
	let td = document.createElement('td');
	let btn = document.createElement('button');

	btn.addEventListener('click', deleteReplyFnc);

	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;

}
