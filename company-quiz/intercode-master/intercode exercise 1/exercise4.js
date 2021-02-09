
function sum(list) {

	if(list.length <1)
	return 0;
	
	let total = list.pop();
	if(isNaN(total)){
			total = 0;
	}
	
	return Number.parseInt(total) + sum(list);

}



console.log(sum([1,2,"3",4,"cow",5,6,"chicken",7]));

console.log(sum(["1","2","3","4","cow","5"]));

console.log(sum(["cat","2","3","4","cow","5"]));