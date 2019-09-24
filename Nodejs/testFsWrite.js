var fs = require('fs');
fs.writeFile('textData.txt', 'Hello World1234', function(err) {       //Hello World1234으로 변경하면 textData.txt에서  Hello World -> Hello World1234로 변경
if ( err ) {
console.error('파일 저장 실패 : ', err);
return;
}
console.log('파일 저장 성공');
});