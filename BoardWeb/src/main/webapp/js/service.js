/**
 * service
 */


const svc = {//add메소드
	add: function(num1 = 0, num2 = 0) {
		return num1 + num2;
	},
	//목록출력메소드
	replyList(param = { bno, page }, successCallback, errorCallback) {
		//ajax호출
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},

	//댓글삭제메소드
	removeReply(rno, successCallback, errorCallback) {
		//ajax
		fetch('removeReply.do?rno=' + rno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	//속성값과 변수값이 같을때 생략가능 bno:bno = bno
	addReply(param = { bno, reply, replyer }, successCallback, errorCallback) {
		//ajax
		fetch('addReply.do?', {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer
		})
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
//댓글전체 건수
	replyCount(bno, successCallback, errorCallback) {
		fetch('replyCount.do?bno=' + bno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	}


}




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


