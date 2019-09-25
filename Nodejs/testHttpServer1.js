// 모듈 로드
var http = require('http');
// http.server 객체 생성
var server = http.createServer();
// server event set : request
server.on('request', function (request, response) {
    console.log('request event');
});
// server event set : connection
server.on('connection', function (socket) {
    console.log('connection event');
});
// server event set : close
server.on('close', function () {
    console.log('close');
});
// port set
server.listen(3000);
//웹페이지에 localhost:8080 실행시 terminal창에 console.log들 출력





var http = require('http');
var server = http.createServer(function (req, res) {
    console.log('HTTP Method : ' + req.method);
    console.log('HTTP URL : ' + req.url);
    console.log('== HEADERS ==');
    console.log(req.headers);
    res.end('Hello Node.js');
}).listen(3001);