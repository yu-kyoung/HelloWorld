//covid.js
import { makeRow, url } from './covid_module.js';
let centerAry;
fetch(url)
	.then(data => data.json())
	.then(result => {
		centerAry = result.data;//[{},{}]
		//시도정보배열
		let sidoAry = [];
		//tr>td*2
		//#centerList     
		//[].forEach(function(elem, idx, ary))
		centerAry.forEach((center, idx) => {
			//sidoAry에 중복 제외 값 담기
			if (sidoAry.indexOf(center.sido) == -1) {//값이 있는지 없는지indexof
				sidoAry.push(center.sido);//추가push
			}

			if (idx < 10) {
				//tr 생성하기
				let tr = makeRow(center);
				document.querySelector('#centerList').appendChild(tr);
			}//end if
		});//end of for
		console.log(sidoAry);
		//sidoAry 갯수만큼 <option value="sido정보">sido정보</option>
		sidoAry.forEach(sido => {
			let opt = document.createElement('option');
			opt.value = sido;
			opt.innerText = sido;
			document.getElementById('sido').appendChild(opt);
		})

	})
	.catch(err => console.log(err));

//event

document.querySelector('button.btn-primary').addEventListener('click', function(e) {
	//목록지우기
	document.querySelector('#centerList').innerHTML = "";//클리어
	let keyword = document.getElementById('centerName').value;//검색값

	centerAry//배열
		//.filter(center => center.centerName.indexOf(keyword) != -1)//배열
		.filter(center => center.centerName.includes(keyword))//배열
		.forEach(center => {
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);

		})
});

//select 태그의 change이벤트
document.querySelector('#sido').addEventListener('change', function(e) {
	document.querySelector('#centerList').innerHTML = "";//클리어

	let keyword = document.getElementById('sido').value;//검색값
	centerAry
		.reduce((acc, center) => {
			if (center.sido == keyword) {
				let tr = makeRow(center);
				acc.appendChild(tr);
//
			}
			return acc;
		}, document.querySelector('#centerList'));
});


//	.filter(center => center.sido == keyword)
//.forEach(center => {
//let tr = makeRow(center);
//document.querySelector('#centerList').appendChild(tr);

//})


//[].push(),[].unshift 추가  ,[].pop(),[].shift 지우기 => [].splice()추가/지우기
//reduce(); 필터 포이치 둘다가능

let result = [1, 3, 5, 7].reduce(function(acc, elem, idnx, ary) {
	console.log(acc, elem);
	if (elem > 4) {

		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);

	}
	return acc;
}, document.querySelector('#target'));//초기값 document,[],0 다 사용가능
console.log('결과 : ', result);


