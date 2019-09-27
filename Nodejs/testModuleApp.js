//필요한 모듈 로드
var greeting = require('./greeting.js');      //노드 환경에서는 같은 디렉토리안에 파일이있을때 greeting.js 는 오류   
                                            //./greeting.js로 바꿔줘야 한다
                                            
var Movie = require('./movie.js');

//모듈 함수 호출
//greeting.hi();
//greeting.bye();

var movie = new Movie('mini','pixar');

movie.showData();
console.log('data', movie.makeObj());