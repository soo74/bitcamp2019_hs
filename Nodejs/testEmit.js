// 자바스크립트 객체 생성

var obj = {};
obj.name = "HS";
obj.hello = function(){
    console.log(this.name);
};

//obj.hello();          ->TERMINAL 창에 "HS" 출력



var Person = function(){
}
//공용 메서드 정의
Person.prototype.sayHello = function(){
    console.log('안녕하세요');

};



class Member{  //생성자 표현하듯이 가능
}

var person = new Person();   //객체생성
var memeber = new Member();

//person.sayHello();           ->"안녕하세요" 출력



//상속처리를 위한 util 모듈 로드
var util = require('util');
//이벤트 등록을 위한 EventEmitter 생성
var EventEmitter = require('events').EventEmitter;
//상속 Person에 EventEmitter 상속
util.inherits(Person, EventEmitter);                     //util은 모듈함수로 사용

//Person 객체 생성
var person = new Person();
//이벤트 등록
person.on('hi',function(){
    console.log('안녕하세요! 반갑습니다.');
});

//이벤트 발생
person.emit('hi');                    // ->"안녕하세요! 반갑습니다." 출력