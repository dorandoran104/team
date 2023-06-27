/**
 * 
 */
 
let page = 1;

let tbody = document.querySelector("tbody");

getList(page);


//페이지 네이션 처리(페이지 이동)
let page_link = document.querySelectorAll(".page-link");
//페이지 로딩 시 1번 체크해놓기
page_link[0].classList.add('active');

page_link.forEach((target)=> target.addEventListener("click",(event)=>{
	event.preventDefault();
	
	page_link.forEach((target)=>{
		if( target.classList.contains('active') ){
			target.classList.remove('active');
			return;
		}
	})
	
	event.target.classList.add('active');
	let pageNum = event.target.dataset.page;
	getList(pageNum);
}));


//게시글 불러오기
function getList(page){
	fetch("boards/list/"+page,{
		headers : {
			'Content-type' : 'application/json',
		}
	})
	.then((response)=>response.json())
	.then((response)=>{
		writeHtml(response);
	});
}


//게시글 리스트 뿌리기
function writeHtml(response){
	let str = '';
	for(let i = 0; i<response.length; i++){
		str += '<tr><td>' + response[i].id + '</td>';
		str += '<td><a href="boards/' + response[i].id + '">' + response[i].title + '</a></td>';
		str += '<td>' + new Date(response[i].regDate).toLocaleString() + '</td></tr>';
	}
	tbody.innerHTML= str;
}
