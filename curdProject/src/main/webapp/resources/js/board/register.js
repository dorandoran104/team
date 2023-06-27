const register_button = document.querySelector("#register-button");
const input_file = document.querySelector("#formFile");

register_button.addEventListener("click",(evnet)=>{
	event.preventDefault();
	
	const title = document.querySelector("#title").value;
	const body = document.querySelector("#body").value;
	
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

//파일 업로드
input_file.addEventListener("change",(event)=>{
	const imageArea = document.querySelector(".imageArea");
	
	let formData = new FormData();

	for(let i = 0; i<event.target.files.length; i++){
		console.log(event.target.files[i]);
		formData.append("files",event.target.files[i]);
	}
		
	fetch("../attach/upload",{
		method : 'post',
		headers : {
			 
		},
		body : formData
	})
	.then((response) => response.json())
	.then((response)=>{
		console.log(response);
		let str = '';
		response.forEach((target)=>{
			let fileUrl = encodeURIComponent(target.filePath + "\\" + target.uuid + "-" + target.fileName);
			
			str+= '<div class="delete_image" onclick="deleteAction(event)" data-fileurl="'+fileUrl+'">X</div>'
			str+= '<img src="../attach?fileUrl='+ fileUrl;
			str+= '" style="width : 100px; height: 100px" >';
		})
		imageArea.innerHTML = str;
	});
});

function deleteAction(event){
	let fileUrl = event.target.dataset.fileurl;
	
	fetch("../attach",{
		method : 'delete',
		headers : {
			'Content-type' : 'text/plain'
		},
		body : fileUrl
	})
	.then((response)=> response.text())
	.then((response)=>{
		if(response == 'success'){
			
		}else{
			alert('오류');
			return;
		}
	})
	
	
}

