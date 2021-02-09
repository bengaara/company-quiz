
var fs = require('fs');
var http = require('http');
	
function main() {
	
	req("http://nba.com")

}


function req(url) {
	

	var request = http.request(url, function (res) {
    var data = '';
	 console.log(res.headers);
	if (res.statusCode == 302) {//follow a redirect
        req(res.headers.location);
    } 
	
	
    res.on('data', function (chunk) {
        data += chunk;
    });
    res.on('end', function () {
        console.log(data);
		processData(data.toString());

    });
});
request.on('error', function (e) {
    console.log(e);
	
});
request.end();
}


function processData(data){


	let content = data.replace(/NBA/g, "MLS") ;
	
	fs.writeFile(__dirname + "/exercise5.txt",content, function(err) {
    if(err) {
        return console.log(err);
    }
    console.log("saved!");
	}); 
	
}

main();