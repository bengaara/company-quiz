http://mowson.org/karl/2016/2016-05-20_alpinelinux_vm_under_virtualbox/



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
    var prices = readLine().split(',').map(Number);
	
	console.log(findMax(prices));

}
function findMax(prices){
	console.log(`input:  ${prices}`);
	var profit = 0;
    for(var i=1; i<prices.length; i++){
        var diff = prices[i]-prices[i-1];
        if(diff > 0){
            profit += diff;
			console.log(`add profit  (${prices[i]} - ${prices[i-1]}) ${diff}`);
        }
    }
    return profit;
}