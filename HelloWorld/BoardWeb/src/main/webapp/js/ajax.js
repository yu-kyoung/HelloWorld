/**
 * ajax.js
 * Asynchronous Javascript And Xml 
 */

// 비동기 vs 동기 방식
// setTimeout(function () {
// 	console.log("1");
// }, 2000);

// setTimeout(function () {
// 	console.log("2");
// }, 1000);

// setTimeout(function () {
// 	console.log("start");
// }, 1500);

// {"id": 1, "first_name": "Hong"} => json객체
// -> {id: 1, first_name: "Hong"} => javascript객체

// 객체. XMLHttpRequest
//console.log("start");

let xhtp = new XMLHttpRequest();

xhtp.open('get', 'replyList.do?bno=263'); // 요청할 페이지 지정.
xhtp.send(); // 페이지 요청.
xhtp.onload = function() {
	//console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item) {

		document
			.querySelector('table:nth-of-type(2) > tbody')
			.appendChild(makeRow(item));
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};


// 댓글 등록
document
	.querySelector("#addReply")
	.addEventListener('click', addReplyFnc);

function addReplyFnc(e) {

	// 입력값 변수에 저장
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;

	// 필수 입력
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}

	// Ajax 호출
	const addAjax = new XMLHttpRequest();
	addAjax.open('get', 'addReply.do?bno='
		+ bno
		+ '&reply='
		+ reply
		+ '&replyer='
		+ logId
	);
	addAjax.send();
	addAjax.onload = (ev) => {
		let result = JSON.parse(addAjax.responseText);
		console.log(result)
		if (result.retCode == 'Success') {
			alert('등록성공');
			let tr = makeRow(result.retVal);
			// 부모요소.insertBefore(새요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) > tbody tr');
			document.querySelector('table:nth-of-type(2) > tbody')
				.insertBefore(tr, target);
			/* document
				.querySelector('table:nth-of-type(2) > tbody')
				.appendChild(tr); */
		} else {
			alert('등록실패');
		}
	};

}

// 댓글을 로드

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


// 댓글 삭제
function deleteReplyFnc(e) {
	if (!confirm("삭제?")) {
		return;
	}

	let rno = e.target.parentElement.parentElement.dataset.rno; // dataset.'rno' => data-'rno'
	console.log(rno);
	const delAjax = new XMLHttpRequest(); // http Request 요청 함수
	delAjax.open('get', 'removeReply.do?rno=' + rno);
	delAjax.send();
	delAjax.onload = (ev) => {
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Success') {
			console.log(result.retCode);
			e.target.parentElement.parentElement.remove();
		} else {
			alert("삭제하는 도중 문제가 발생하였어요 :(");
		}
	}

}


function memberList() {
	//console.log("1");
	//console.log(xhtp.responseText); // parsing
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>";
	data.forEach(function(item, idx, arr) {
		console.log(item);
		str += "<li>" + item.id + "," + item.first_name + "</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
//console.log("end");

// fetch('data/sample.json')