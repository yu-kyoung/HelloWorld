/**
 *module 
 */

 const defaultNum=10;
 let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=GNicjQkf3UggTTQc6CvOTfFo2On2BDCyWQjiKPa2VyajuDVAYTW%2BkzTnhpL1DZ8lV%2Ff%2ByiAZpz5V05%2B%2FCWs2%2FA%3D%3D`

 function makeRow(center){
	let tr=document.createElement('tr');
	    
		for(const prop of ['id','centerName','phoneNumber']){
			let td=document.createElement('td');
			td.innerHTML=center[prop];//center['id']//<td>1</td>
			tr.appendChild(td);
	    }
	return tr;
 }
 
export{defaultNum,makeRow,url}