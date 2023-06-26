const register_button = document.querySelector("#register-button");

register_button.addEventListener("click",(evnet)=>{
	event.preventDefault();
	
	const title = document.querySelector("#title").value;
	const body = document.querySelector("#body").value;
	console.log(title,body);
	
	if(!title || !body){
		alert('작성을 완료해주세요');
		return;
	}
	
	const param = {
		title : title,
		body : body
	}
	
	fetch("new",{
		method : 'post',
		headers : {
			'Content-type' : 'application/json'
		},
		body : JSON.stringify(param)
	})
	.then((response)=> response.json())
	.then((response)=>{
		const id = response.id;
		location.replace(id);
	})
	.catch((errer)=>{
		alert('오류');
		return;
	})
});	