//1.모듈을 로드
//http 모듈
var http = require('http');
//fs모듈
var fs = require('fs');

//server 생성
var server = http.createServer(function(req, res){

    var url = req.url;
    console.log(url);

    //1)  이미지 출력
    if(url == '/puppycat.jpg'){

        res.writeHeader(200,{'Content-Type': 'image/jpg'});

      
       var filepath = __dirname+'/puppycat.jpg';

    fs.access(filepath, fs.F_OK,function(err){            //사진 파일 추가해서  //fs.F_OK : 파일이 존재하는지 확인
            
        //파일 데이터를 로드해서 응답처리
            if(err){
                res.statusCode = 404;
                res.statusMessage = 'file not found';
                res.end();
               return;
            }
            fs.readFile(filepath,function(err,data){
                //if(err){}
                res.write(data);
                res.end();
            });
    });        //http://localhost:3000/puppycat.jpg      //ctrl누르고 클릭시 웹페이지이동


 
 //2) html 출력
}else if(url == '/test'){

    res.writeHeader(200,{'Content-Type' : 'text/html'});

   
var htmlStr = __dirname + '/test.html';

fs.access(htmlStr, fs.F_OK, function(err){
    if(err){
        res.statusCode = 404;
        res.statusMessage = 'file not found';
        res.end();
        return;

    }
        //파일이 존재한다면
        fs.createReadStream(htmlStr).pipe(res);


});     //http://localhost:3000/test

}


//res.end('hi','utf-8');

    });
//port 설정
server.listen(3000);