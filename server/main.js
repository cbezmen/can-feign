var http = require('http');

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'application/json'});
    res.end('{\"id\": 1, \"name\" : \"book 1\"}');
    console.log("called")
}).listen(8081);