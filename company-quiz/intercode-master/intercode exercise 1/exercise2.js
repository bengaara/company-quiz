
function rangeExpander() {
	let multiplier = 7/5;
	
	return rand5() * multiplier;
}
// assuming rand5 exists
function rand5() {
	return Math.random()*5;
}

for (x =0;x<10;x++)
console.log(rangeExpander());