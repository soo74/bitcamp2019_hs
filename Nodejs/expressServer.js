//모듈 로드
var express = require('express');

//서버 객체 생성
var app = express();

app.use(function(req,res,next){
    var now = new Date();
    console.log(now.toDateString()+ ':' + req.method + ':' + req.url);
    //시간 : get : /test
    next();            //다음 미들웨어로 이동
});

app.use(function(req,res){
    res.send('hello~ express');
});

//app.get('/v1/movies',movieList);    //movieList : 함수이름(movieList),콜백함수지정
//app.post('/v1/movies',movieCreate);
//app.put('/v1/movies/1',movieEdit);    //변수처리


app.listen(3000);          

function movieList(){
    console.log('movieList');
}
function movieCreate(){
    console.log('movieCreate');
}
function movieEdit(){
    console.log('movieEdit');
}