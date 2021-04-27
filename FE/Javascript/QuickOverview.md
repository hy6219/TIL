## js 파일 정리

1. let과 const의 차이, 시판 책에서 나오는 var를 붙이는 것의 문제점 확인
- let : 변수
- const : 상수
- var : 변수와 상수를 구별하기 어려움

2. 
일명 '변수'의 종류로 올 수 있는 자바스크립트의 데이터 타입에 대해서 공부
- String: "" '' "이모지"
- number: 정수
- boolean: true, false
- float : xx.x

3. 
- 데이터를 정렬하는 방법: 배열, 객체
- js의 강력한 특징: 배열을 선언 및 초기화 할때, const array_name = [데이터타입1,데이터타입2, 변수]; 로 한 줄안에 다양한 데이터타입과 변수를 넣을 수 있다는 점!
- object를 array 안에 넣을 수도 있음

```
[나의 생각]
자바로 비유하자면, 객체배열같은 것!--a
비슷하지만, 차이가 있다면, 자바스크립트는
배열 내부에 객체와 변수가 동시에 들어갈 수 있고, 다른 데이터타입이어도 한번에 들어갈 수 있음!

물론, 자바도 다형성, wrapper class 등을 적용한다면 가능하지만, 자바스크립트보다 다소 복잡함!(Duck Typing과 관련있는 부분이지 않을까..?)
```

- 배열에 .push(값)으로 값을 추가할 수 있음
5. 
- object : {}를 이용하여 사용
- object vs array:
1) object는 name : value로 사용이 가능
2) object에서 각 멤버 접근: object.name
3) array에서 각 인덱스 접근: array[인덱스]
- const object의 특징:
1) object.name = another value로 
멤버변수를 수정할 수 있지만
2) object = true로 객체 자체를 변경할 수는
없다(syntax error 발생)

- 데이터를 정렬할 때
1) array: db에서 가져온 리스트데이터를 처리할 때 사용

2) 데이터를 합쳐야 할때 object를 array안에 넣을 수 있음!--a

- object 내부에 array를 넣을 수도 있음!
- console 도 object!
- JSON.stringify(객체) : 객체를 string으로 형변환해줄 수 있음

→ localstorage는 data를 저장할 수 없고,
오로지 string으로만 저장할 수 있음

* JSON : Javascript Object Notation

→ 데이터를 전달할 때, 자바스크립트가 다룰 수 있도록, object 로 바꿔주는 기능

6. index05.js

- 브라우저가 가지고 있는 자바스크립트도 object(쉽게 말해서 DOM)에
넣을 수 있음
[https://stackoverflow.com/questions/6432984/how-to-add-a-script-element-to-the-dom-and-execute-its-code/44902662]

- 내장함수(built-in function): console.log, alert 함수 등

* console.log(): 내부에 메시지가 없이는 동작하지 않음! && 
console 객체의 함수!

- 함수 : 어떤 것을 수행하려는 한 부분으로,
내가 원하는 만큼 사용할 수 있음! 기능!

- 함수는 매개변수 갯수만큼 작동하고
매개변수 갯수보다 데이터를 많게 넣으면
매개변수 갯수만큼 해당되는 값만 출력

- 반대로 매개변수 갯수를 적게 입력하면, 그 이전까지 해당되는 매개변수에 대해서는 그대로 반환하고, 부족한 부분은
undifined를 붙여서 출력하게 됨!

- 사용 방법

```js
function sayHelloWithArgs(potato)
{
    //매개변수를 통해서 외부에 있는 데이터를 읽어올 수 있음
    console.log('Hello ',potato,'!');
}


```

```js
function sayHello()
{
    //매개변수가 없는 함수
    console.log('hello!');
}

```

- 함수에 return이 없는 경우, 내부 구문을 실행 후에는 저장되어 남는 부분이 없기 때문에 변수로 외부에서 함수 반환 결과를 담는 expression을 지나가면 결국은 undefined로 인지되게 됨

- 단, return 을 해주었을 때에는 변수에 담은 후 console.log를 통해서 확인해야, 콘솔에서 확인 가능

- 정리해보면 함수 형태는 아래와 같다

```js
function키워드 함수명(매개변수)
{...}

function키워드 함수명(매개변수)
{return ~;}

```

- `(백틱)은 기존에 +나 ,를 이용해 문자열을 연결하는 방법보다 훨씬 효과적!
${}를 중간에 삽입하여 변수값을 포함하여 한줄로 표현이 가능하다!

```js
function sexyString2(name,age)
{
    console.log(`Hello ${name} you are ${age} years old`);
}

```

- 객체 내부에는 함수도 포함될 수 있다(다른 언어와 비슷한데, 표현이 다름)

```js
const 객체명 = {
    함수명 : function키워드(매개변수)
    {...}
    함수명 : function키워드(매개변수)
    {return ~;}
};

```

- 적용 예시: 
```js
const calculator = {
    //함수
    plus:function(a,b){
        return a+b;
    }
};

```

7. 
- DOM 내장 함수 : HTML과 상호작용하는 함수 예시를 보여줄 것

 - DOM(Document Object Module) : document에 있는
 모든 html 요소를 객체로 만드는 것
 
 - getElementId: document가 html 태그를 객체로 만듦



 - document에서 가져와서 객체로 만든 요소


 -  (DOM객체).innerHTML='~'; : 해당 요소의 값을 변경하여 DOM 객체에 적용하는 것


- (DOM객체).style.속성=값; : 해당 요소의 스타일을 변경하여 DOM 객체에 적용하는 것

- (DOM 객체).title=~; : 페이지 이름(탭에 뜨는 사이트명)을 변경하여 DOM 객체에 적용하는 것


 - document.getElementsByClassName("클래스명"):
 클래스명인 요소를 찾아서 "컬렉션"형태로 반환

 → 따라서 document.getElementsByClassName("tester")[0]; 처럼 접근해서 변수에 저장 후,
 innerHTML이나 .value, .style.속성=~ 등을 
 사용 가능

 -querySelector: 노드의 첫번째 자식을 반환
```js
 
  ex:
  const title=document.querySelector("#title");
  //#을 붙여서 id로 찾겠다는 것을 표시
  
  const title=document.querySelector(".title");
  //.을 붙여서 클래스로 찾겠다는 것을 표시

  /*
  id든 클래스든, 아이디로 되어있는데 .로 접근한다던지

  클래스로 되어있는데 #로 접근하면

  undefined가 뜸!
  */
```


8. 자바스크립트 이벤트, 이벤트 핸들러

- 이벤트가 동작할때마다 감지하기 위해서 event listener가 필요

- addEventListenr(이벤트명, 이벤트핸들러함수명)을 통해서 이벤트에 대한 감지 후 처리
```js
function handleResize(){
    console.log(`화면크기가 조정되었습니다!`);
    alert(`화면크기가 조정되었습니다!`);
}

window.addEventListener("resize", handleResize);
```

※ 주의할 점!!
```js
window.addEventListener("resize", handleResize());
```
와 같이 ()를 붙여서 실행하게 된다면, 지금 즉시 실행해주라는 의미라서
한번만 실행하고 끝남


그리고!!
--------------------------------------------------------------------------------------------------
```js
window.addEventListener("resize", function handler(){
    console.log(`화면크기가 조정되었습니다!`);
    alert(`화면크기가 조정되었습니다!`);

});
```
와 같이 적용하여 적용하면, ()가 붙었더라도, 매번 즉각적으로 감지하여 잘 작동함
[익명메서드]

- 아래와 같이 자바스크립트의 event 객체를 이용한 함수를 이벤트리스너에 전달해주면
자바스크립트는 자동적으로 함수를 객체에 붙임

```js
function handleResize(event)
{
    alert(event);
    console.log(event);
}

window.addEventListener("resize",handleResize);
```

9. if-else 문, 기타 내장함수

- 자바스크립트 if-else
- 기본적인 형태
```js
if(consition)
{
    block
}
else
{

}
```

- 자바스크립트에서는 ==뿐아니라 ===도
같은지를 비교해줌

- prompt(): 사용자로부터 입력을 받음
- confirm() : 사용자로부터 boolean 값을 입력받음(확인: true, 취소: false)
- prompt 사용은 이제는 오래된 방식!
html 등을 이용해서 더 나은 방식으로 접근하자!

- resource는 마치 이미지같은 것!
- className으로 접근하지 않고, classList를 이용하면 기존에
존재하던 클래스명을 인지하는 데에 효과적(btn clicked으로 클래스가
 기존의 btn 외에 clicked가 추가되어도 clicked를 붙이고 떼는 
 작업이 용이)
