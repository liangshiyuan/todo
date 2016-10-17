function toJson(arr){
	var result ="{";
	result = result+"title:"+arr.title +",";
	result = result+"typevalue:"+arr.typevalue +",";
	result = result+"time:"+arr.time +",";
	result = result+"text:"+arr.text;
	result = result+"}";
	return result;
}

function saveData(data){
	localStorage.setItem('data',data);
}

function getData(){
	return localStorage.getItem('data');
}

$('.btn-commit').click(function(){
	var data = Array();
	data.title = $('#title').val();
	data.typevalue = $('input[name="typevalue"]:checked').val();
	data.time = $('#time').val();
	data.text = $('#text').val();
	data = toJson(data);
	var oldData = getData();
	if(oldData != null){
		oldData = oldData.substr(1,oldData.length-2);
		data = "["+ oldData +","+ data+"]";
		console.log(data);
		saveData(data);
	}else{
		data = "["+ data +"]";
		console.log(data);
		saveData(data);
	}
});