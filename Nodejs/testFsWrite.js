var fs = require('fs');

var path = 'textData.txt';

fs.appendFile(path, '\n Additional data', function(err) {    //'Additional data'이 textData.txt에 추가된다.
    if ( err ) {
    console.error('파일 내용 추가 실패 : ', err);
    }
    console.log('파일 내용 추가 성공');

    
    });


//fs.writeFile('textData.txt', 'Hello World1234', function(err) {       //Hello World1234으로 변경하면 textData.txt에서  Hello World -> Hello World1234로 변경
//if ( err ) {
//console.error('파일 저장 실패 : ', err);
//return;
//}
//console.log('파일 저장 성공');
//});