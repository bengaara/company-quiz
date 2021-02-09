//http://mowson.org/karl/2016/2016-05-20_alpinelinux_vm_under_virtualbox/



process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();   
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function main() {
	//sort in ascending order
    var greedyChild = readLine().split(',').map(Number).sort((a,b)=>a-b);
	var sweets = readLine().split(',').map(Number).sort((a,b)=>a-b);
	
	console.log(findMatches(greedyChild,sweets));

}
function findMatches(greedyChild,sweets){
	
	var matches = 0;
	for (var x = 0; x < greedyChild.length ; x++){
	
		for (var y = 0; y < sweets.length ; y++){
			if(greedyChild[x] <= sweets[y]){
			console.log(`found at greedyChild index ${x} sweets index ${y} match :${greedyChild[x]} <= ${sweets[y]} `);
				matches++;
				sweets = sweets.slice(y+1);
				break;
			}
		}
		
	}
	return matches;
}