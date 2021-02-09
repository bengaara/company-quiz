


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
    var n = parseInt(readLine());
	console.log(binarySearch(n));
}
function isFailedTest(version){
	var status =false;
	
	if(version > 8 )status = true;
	console.log(`Testing version #${version} isFailedTest: ${status} `);
	return status;
}
//returns the lowest failed version or null if no version has failed
//to minimise api calls, binary search used
function binarySearch(value) {
    var lo = 1, hi = value, mid,lowest=null;
	
    while (lo <= hi) {
        mid = Math.floor((lo+hi)/2);
        if (isFailedTest(mid)){      
			hi = mid - 1;
			lowest = mid;
		} else{
			
			 lo = mid + 1;
		}
		console.log(`lo: ${lo} mid: ${mid} hi: ${hi} lowest Failed : ${lowest}`); 
    }
    return lowest;
}