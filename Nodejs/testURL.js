//URL 모듈 로드
var url = require('url');

var urlStr = 'http://idols.com/q?group=EXID&name=하니&since=';

var parsed = url.parse(urlStr);

//console.log(parsed);
console.log(parsed.host);