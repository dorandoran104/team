/**
 * 
 */
 
const modify_button = document.querySelector("#modify-button");

modify_button.addEventListener("click",(event)=>{
	event.preventDefault();
	
	const id = document.querySelector("#id").value;
	const title = document.querySelector("#title").value;
	const body = document.querySelector("#body").value;
	
	if(!title || !body){
		alert('작성해주세요');
		return;
	}
	
	
	const param = {
		title : title,
		body : body
	}
	
	fetch("../"+id,{
		method : 'put',
		headers : {
			'Content-type' : 'application/json'
		},
		body : JSON.stringify(param)
	})
	.then((response)=>{
		if(response.status == 200){
			location.replace('../'+id);
		}else{
			alert('오류');
			return;
		}
	})
	;
	
	
	
});