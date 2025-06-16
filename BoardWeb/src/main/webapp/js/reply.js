/**
 * reply.js
 */
let page = 1;//page 선택 .

console.log(bno);

Date.prototype.format = function() {
	let yyyy = this.getFullYear();//년도 yyyy-MM-dd hh:mm:ss
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();

	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2) + ' ' + ('0' + hh).slice(-2) + ':'//
		+ ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2);
}
//이벤트
//댓글등록이벤트
document.querySelector('#addReply').addEventListener('click', addReplyHandler);
//댓글링크이벤트
function pagingEvent() {
	document.querySelectorAll('.footer nav a').forEach(function(elem, idx) {
		console.log(elem);
		elem.addEventListener('click', function(e) {
			document.querySelector('#target').innerHTML = "";
			page = e.target.innerHTML;//a태그의 <a>1</a>
			svc.replyList({ bno, page }//게시글번호
				, result => {
					console.log(result);
					let ul = document.querySelector('#target');
					let template = "";// document.querySelector('#target li');
					//5건씩 화면에 출력
					for (let reply of result) {
						template = makeTemplate(reply);
						//
						ul.insertAdjacentHTML("beforeend", template);
					}
					//댓글페이지
						showPageList();
				}
				, err => console.log(err)
			);

		})
	});
}//end of pagingEvent

//댓글등록 핸들러	
function addReplyHandler(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert('값을 확인하세요');
		return;
	}


//댓글등록
	svc.addReply({ bno, reply, replyer: logId }
		, result => {
			console.log(result)
			if (result.retCode == "Success") {
				let ul = document.querySelector('#target');
				let rval = result.retVal;

				ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));
				document.querySelector('#reply').value = ""; //입력값 초기화 
			}//end of if
		}
		, err => console.log(err)
	)

}

//글목록 출력
page = 2;
svc.replyList({ bno, page }//게시글번호
	, result => {
		console.log(result);
		let ul = document.querySelector('#target');
		let template = document.querySelector('#target li');
		for (let reply of result) {
			template = makeTemplate(reply);
			//
			ul.insertAdjacentHTML("beforeend", template);
		}
		//댓글페이지
		showPageList();
	}
	, err => console.log(err)
);


//댓글페이징 출력
function showPageList() {
	svc.replyCount(bno//첫번째 매개값

		, result => {
			console.log(result.totalCnt);
			let totalCnt = result.totalCnt;
			let start, end;//첫페이지~마지막페이지
			let prev, next;//이전 이후 페이지 존재 여부
			let realEnd = Math.ceil(totalCnt / 5);//실제 건수를 기준으로 계산한 마지막페이지

			end = Math.ceil(page / 10) * 10;//계산상 마지막페이지
			start = end - 9;
			end = end > realEnd ? realEnd : end;
			prev = start > 1;
			next = end < realEnd;
			//기존페이징 클리어
			document.querySelector('nav ul.pagination-sm').innerHTML = "";

			//페이지 목록 출력
			let target = document.querySelector('nav ul.pagination-sm');
			//이전페이지
			let str;
			if (prev) {
				str = `<li class="page-item"><a class="page-link" href="#">Previous</a></li>`;

			} else {
				str = `<li class="page-item disabled"><span class="page-link" href="#">Previous</span></li>`;
			}
			target.insertAdjacentHTML('beforeend', str);

			//1~10 페이징
			for (let p = start; p <= end; p++) {
				if (p == page) {
					str = `<li class="page-item active" aria-current="page"><span
									class="page-link">${p}</span></li>`
				} else {
					str = `<li class="page-item"><a class="page-link" href="#">${p}</a></li>`
				};
				target.insertAdjacentHTML('beforeend', str);
			}
			//이후페이지
			if (next) {
				str = `<li class="page-item"><a class="page-link" href="#">Next</a></li>`;

			} else {
				str = `<li class="page-item disabled"><span class="page-link" href="#">Nest</span></li>`;
			}
			target.insertAdjacentHTML('beforeend', str);
			//생성한 a태그 이벤트 등록
			pagingEvent();
		}, err => console.log(err)
	);
};//end of showPageList

//댓글화면 출력
function makeTemplate(reply = {}) {
	let rdate = new Date(reply.replyDate).format();
	template = `
						<li data-rno=${reply.replyNo}>
							<span class="col-sm-2">${reply.replyNo}</span>
						 	<span class="col-sm-4">${reply.reply}</span>
							<span class="col-sm-2">${reply.replyer}</span> 
							<span class="col-sm-2">${rdate}</span>
							<span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
						</li>
				`;
	return template;//<li>...</li> 반환
}

//댓글삭제 함수
function deleteReply(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno
		, result => {
			console.log(result);
			if (result.retCode == "Success") {
				alert("성공")
				e.target.parentElement.parentElement.remove();
			} else {
				alert("실패")
			}
		}
		, err => console.log(err)
	)
}//end of deleteReply

