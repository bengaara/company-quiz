function main() {
   for(x=1;x<100;x++){
   
		if(x%3 ==0 && x%7==0){
			console.log("OpenSource")
		}else if(x%3 ==0 ){
			console.log("Open")
		}else if(x%7==0){
			console.log("Source")
		}else{
			console.log(x)
	   }
	}
}


main();

