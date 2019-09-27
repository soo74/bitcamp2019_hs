//모듈 로드
var express = require('express');

//서버 객체 생성
var app = express();

app.use(function(req,res){
    res.send('hello~ express');
});

app.listen(3000);