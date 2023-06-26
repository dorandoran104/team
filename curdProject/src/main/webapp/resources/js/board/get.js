/**
 * 
 */
 
 const delete_button = document.querySelector("#delete"); 	
	
	delete_button.addEventListener("click",(event)=>{
		event.preventDefault();
		const id = event.target.dataset.id;
		
		if(confirm('삭제하시겠습니까?')){
			fetch(id,{
				method : 'delete',
				header : {
					"Content-type" : "application/json"
				}
			})
			.then((response)=>{
				if(response.status == 200){
					location.replace("/curdProject/boards")
				}else{
					alert('잠시 후에 다시 시도해주세요');
					location.reload();
				}
			})
		}
	})