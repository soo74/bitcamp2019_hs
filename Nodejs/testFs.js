var fs = require('fs');                                     //모듈 로드
//파일 위치 경로
var file = 'helloWorld.txt';                                 //파일의 경로
try {                                                        //try-catch 사용
    //파일 존재 유무 확인                      
    fs.accessSync(file, fs.F_OK)                            //accessSync : 파일 유무확인 함수
    console.log('파일 존재');                               //helloworld.txt 추가 후 '파일 존재' 출력 
    //파일 읽기, text문서를 받아오기 때문에 data는 String으로 들어온다.
    fs.readFile(file, 'UTF-8',function(err, data){         //return타입이 void, 콜백함수는 return이 없다
            if(err){
                console.error('File Read Error :' + err);
                return;
            }

            console.log('Read Text File UTF-8 Encoding');
            console.log(data);
        });                      
    }
catch ( err ) {
// 파일이 없을 때, 종료
console.log('파일 존재하지 않음');                          //helloWorld.txt 가 존재하지않을때 '파일 존재하지 않음' 출력
process.exit(1);
}