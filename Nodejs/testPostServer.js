// 모듈 로드
// Http.Server
var http = require('http');
var querystring = require('querystring');

// 데이터
var movieList = [                                   //배열을 객체형식으로 표현할 수 있다.
    {title : '아이덴티티', director : '제임스 맨골드'}
];          


var server = http.createServer(function(req, res){

        // GET / POST 구분
        var method = req.method.toLocaleLowerCase();  //소문자
        console.log('request Method :'+method);

        if(method == 'post'){
            console.log('post 요청일 때 처리');
            addMovie(req,res);
        }else{
            console.log('get 요청일 때 처리');
            list(req,res);
        }
});

//포트설정
server.listen(3000);

//크롬 웹스토어 -> Restlet Client - REST API Testing   크롬에 추가 -> 들어가서 http://localhost:3000 입력 후 send  (method: get이나 post등 방식을 바꿀때마다 설정된 것 출력) 
//ex) request Method :post
//    post 요청일 때 처리


function addMovie(req,res){
    console.log('addMovie');
    //res의 'data' / 'end' 이벤트를 이용해서 body의 내용을 읽어 처리한다.

    var body='';
    req.on('data',function(chunk){

        body += chunk;
        console.log(body);
    });

    req.on('end',function(){

        var parsedData = querystring.parse(body);

        console.log('parsed :', parsedData);
        movieList.push({title : parsedData.title, director : parsedData.director});          //insert를 통해 DB에 넣음
        //list(req,res);

        
        res.statusCode = 302;
        res.setHeader('Location','.');
        res.end('success');

    });
}



function list(req, res){
    // movieList 데이터를 출력해서 보여주는 html
    //헤더설정
    res.writeHeader(200,{'Content-Type':'text/html; charset=UTF-8'});
    //body 설정
    res.write('<html>');
    res.write('<meta charset=UTF-8>');
    res.write('<body>');
    res.write('<h3>Favorite Movie</h3>');
    res.write('<div><ul>');

    movieList.forEach(function(item){
        res.write('<li>'+item.title+'('+item.director+')'+'</li>')                  //제목 가져오기
    });
    res.write('</ul></div>');
    res.write(
        '<form method="post"><h4>새 영화 입력</h4>' +
        '<div><input type="text" name="title" placeholder="영화제목"></div>' +
        '<div><input type="text" name="director" placeholder="감독"></div>' +
        '<input type="submit" value="upload">' +
        '</form>'
        );
        res.write('</body>');
        res.write('</html>');
        res.end();
        
    // 응답실행
    res.end();

}

//list() 추가후 웹에 Favorite Movie
//                  아이덴티티(제임스 맨골드) 출력   --> get 방식으로 처리된다







//restlet client에
//body 부분에 form, 바디도 form으로 바꾸고
//title, Text, identity
//director Text, who
//입력후 post 방식으로 전송
//>
//request Method :post
//post 요청일 때 처리
//addMovie
//title=identity&director=who
//parsed : [Object: null prototype] { title: 'identity', director: 'who' }

//이렇게 출력
