
function sum(list) {

	let sum = list.reduce((total, num)=>{
		if(isNaN(total)){
			total = 0;
		}
	if(!isNaN(num)){
		 return Number.parseInt(total) + Number.parseInt(num);
	}
	  return total;
	})
	
	return sum;
}



console.log(sum([1,2,"3",4,"cow",5,6,"chicken",7]));

console.log(sum(["1","2","3","4","cow","5"]));

console.log(sum(["cat","2","3","4","cow","5"]));