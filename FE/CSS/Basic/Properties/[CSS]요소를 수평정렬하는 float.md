# CSS - float

- 요소를 수평정렬(좌우방향)으로 띄움
- 말 그대로 요소를 "부유"시키는 것!
- 하지만 부유시키는 것보다는 수평정렬을 하기 위할 때 사용됨

[float의 속성값](https://www.notion.so/deee0a493e974851b2fb04a685eef517)

🌻 USAGE 🌻

float: 방향;

```html
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }

        .container .flower {
            background-image: url(https://cdn.pixabay.com/photo/2018/04/05/15/01/nature-3293045_960_720.jpg);
            width: 200px;
            height: 200px;
            float: left;
            margin-right: 10px;
        }
        .container .tour{
            background-image: url(https://cdn.pixabay.com/photo/2021/03/30/01/11/fife-6135609_960_720.jpg);
            width: 200px;
            height: 200px;
            float:right;
            margin-left:10px;
        }

    </style>
</head>

<body>
    <div class="container clearfix">
        <div class="flower"></div>
        <div class="bacon">
            Bacon ipsum dolor amet short loin chislic pork belly, meatloaf doner jowl shoulder sausage swine. Tenderloin
            porchetta tri-tip alcatra filet mignon andouille pork salami kielbasa. Rump pancetta turducken strip steak,
            shoulder corned beef capicola sausage pork loin flank tenderloin salami fatback. Cupim capicola pancetta
            tail, pork belly corned beef kevin flank ribeye sausage brisket bresaola t-bone ground round pork. Capicola
            drumstick shank boudin, tail tri-tip short ribs sirloin swine ribeye hamburger chicken ball tip. Andouille
            beef ribs picanha, tail pancetta shankle shoulder pork belly chislic sausage pork chop leberkas. Pancetta
            venison rump ribeye alcatra corned beef burgdoggen spare ribs kielbasa buffalo.

            Hamburger tenderloin short ribs meatloaf, ground round drumstick alcatra frankfurter brisket pork chop pork
            belly pastrami. Cow kevin venison boudin. Tongue short loin ground round, shoulder spare ribs meatball ham
            hock sausage pig shankle chuck chicken rump. Meatball tenderloin capicola bresaola kielbasa venison picanha
            ham hock porchetta chicken.

            Ham hock sirloin capicola buffalo chislic cow. Biltong corned beef meatloaf cupim sausage tri-tip bresaola
            drumstick. Brisket hamburger beef ribs swine drumstick venison capicola pig. Picanha bresaola ball tip
            porchetta beef pig meatball alcatra ribeye ham pork belly pork leberkas. Pig strip steak jowl, kielbasa
            ribeye pancetta picanha sirloin chuck landjaeger drumstick leberkas pork loin frankfurter doner. Pork chop
            hamburger frankfurter cupim doner.

            Pork loin chicken spare ribs alcatra. Spare ribs tenderloin short loin, chuck ground round prosciutto
            kielbasa pastrami sausage chicken ham frankfurter filet mignon meatball pork. Short loin short ribs pig ham
            tail buffalo chuck rump beef. Shank cupim pork loin turkey meatloaf sirloin alcatra kevin beef.

            Jerky kevin beef tri-tip. Ribeye bacon frankfurter jowl, kevin chislic beef ribs pork belly. Fatback ribeye
            sirloin strip steak chislic pork capicola cow ham ground round hamburger rump drumstick turkey kielbasa.
            Pork pig swine kevin rump, biltong ham hock sausage. Ball tip boudin burgdoggen meatball chislic prosciutto
            porchetta frankfurter cupim swine rump. Meatball jowl corned beef swine, cow meatloaf kielbasa bacon beef
            flank prosciutto capicola sausage.

            Does your lorem ipsum text long for something a little meatier? Give our generator a try… it’s tasty!
        </div>
    </div>
    <div class="container clearfix">
        <div class="tour"></div>
        <span>
            Bacon ipsum dolor amet short loin chislic pork belly, meatloaf doner jowl shoulder sausage swine. Tenderloin
            porchetta tri-tip alcatra filet mignon andouille pork salami kielbasa. Rump pancetta turducken strip steak,
            shoulder corned beef capicola sausage pork loin flank tenderloin salami fatback. Cupim capicola pancetta tail,
            pork belly corned beef kevin flank ribeye sausage brisket bresaola t-bone ground round pork. Capicola drumstick
            shank boudin, tail tri-tip short ribs sirloin swine ribeye hamburger chicken ball tip. Andouille beef ribs
            picanha, tail pancetta shankle shoulder pork belly chislic sausage pork chop leberkas. Pancetta venison rump
            ribeye alcatra corned beef burgdoggen spare ribs kielbasa buffalo.
            Hamburger tenderloin short ribs meatloaf, ground round drumstick alcatra frankfurter brisket pork chop pork
            belly pastrami. Cow kevin venison boudin. Tongue short loin ground round, shoulder spare ribs meatball ham hock
            sausage pig shankle chuck chicken rump. Meatball tenderloin capicola bresaola kielbasa venison picanha ham hock
            porchetta chicken.
            Ham hock sirloin capicola buffalo chislic cow. Biltong corned beef meatloaf cupim sausage tri-tip bresaola
            drumstick. Brisket hamburger beef ribs swine drumstick venison capicola pig. Picanha bresaola ball tip porchetta
            beef pig meatball alcatra ribeye ham pork belly pork leberkas. Pig strip steak jowl, kielbasa ribeye pancetta
            picanha sirloin chuck landjaeger drumstick leberkas pork loin frankfurter doner. Pork chop hamburger frankfurter
            cupim doner.
            Pork loin chicken spare ribs alcatra. Spare ribs tenderloin short loin, chuck ground round prosciutto kielbasa
            pastrami sausage chicken ham frankfurter filet mignon meatball pork. Short loin short ribs pig ham tail buffalo
            chuck rump beef. Shank cupim pork loin turkey meatloaf sirloin alcatra kevin beef.
            Jerky kevin beef tri-tip. Ribeye bacon frankfurter jowl, kevin chislic beef ribs pork belly. Fatback ribeye
            sirloin strip steak chislic pork capicola cow ham ground round hamburger rump drumstick turkey kielbasa. Pork
            pig swine kevin rump, biltong ham hock sausage. Ball tip boudin burgdoggen meatball chislic prosciutto porchetta
            frankfurter cupim swine rump. Meatball jowl corned beef swine, cow meatloaf kielbasa bacon beef flank prosciutto
            capicola sausage.
            Does your lorem ipsum text long for something a little meatier? Give our generator a try… it’s tasty!
        </span>
    </div>
</body>

</html>
```

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%20%EC%86%8D%EC%84%B1.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%20%EC%86%8D%EC%84%B1.PNG?raw=true)

float 속성

위와 같이 float 속성은 어떤 다양한 요소, 매체들을 수평정렬하여 보여주고자 할 때 사용되는데, 이때 float으로 어떤 방향으로 띄우는지도 중요하지만, 이를 해제시키는 작업도 무척! 중요하다!

부유하는 것을 해제할 때에는 clear 속성을 이용하는데

clear: left는 왼쪽으로의 부유성질을 해제하는 것이 되고

clear:right는 오른쪽으로의 부유성질을 해제하고

clear:both는 왼쪽과 오른쪽 모두로의 부유 성질을 해제한다 ▶️ 효율적!

clear의 기본값은 none으로, 요소 띄움을 허용하게 하는 것이다!

그리고 이를 관리하기 가장 효율적인 방법은 일종의 해제를 위한 부모 클래스 요소를 만들고, 가상 요소 선택자 ::after를 활용해서 그 이후 내용이라던지 흐름 해제, display를 일괄 관리하는 방법이다

바로 위에서

```html

    <div class="container clearfix">
        <div class="flower"></div>
        <div class="bacon">
            Bacon ipsum dolor amet short loin chislic pork belly, meatloaf doner jowl shoulder sausage swine. Tenderloin
            porchetta tri-tip alcatra filet mignon andouille pork salami kielbasa. Rump pancetta turducken strip steak,
            shoulder corned beef capicola sausage pork loin flank tenderloin salami fatback. Cupim capicola pancetta
            tail, pork belly corned beef kevin flank ribeye sausage brisket bresaola t-bone ground round pork. Capicola
            drumstick shank boudin, tail tri-tip short ribs sirloin swine ribeye hamburger chicken ball tip. Andouille
            beef ribs picanha, tail pancetta shankle shoulder pork belly chislic sausage pork chop leberkas. Pancetta
            venison rump ribeye alcatra corned beef burgdoggen spare ribs kielbasa buffalo.

            Hamburger tenderloin short ribs meatloaf, ground round drumstick alcatra frankfurter brisket pork chop pork
            belly pastrami. Cow kevin venison boudin. Tongue short loin ground round, shoulder spare ribs meatball ham
            hock sausage pig shankle chuck chicken rump. Meatball tenderloin capicola bresaola kielbasa venison picanha
            ham hock porchetta chicken.

            Ham hock sirloin capicola buffalo chislic cow. Biltong corned beef meatloaf cupim sausage tri-tip bresaola
            drumstick. Brisket hamburger beef ribs swine drumstick venison capicola pig. Picanha bresaola ball tip
            porchetta beef pig meatball alcatra ribeye ham pork belly pork leberkas. Pig strip steak jowl, kielbasa
            ribeye pancetta picanha sirloin chuck landjaeger drumstick leberkas pork loin frankfurter doner. Pork chop
            hamburger frankfurter cupim doner.

            Pork loin chicken spare ribs alcatra. Spare ribs tenderloin short loin, chuck ground round prosciutto
            kielbasa pastrami sausage chicken ham frankfurter filet mignon meatball pork. Short loin short ribs pig ham
            tail buffalo chuck rump beef. Shank cupim pork loin turkey meatloaf sirloin alcatra kevin beef.

            Jerky kevin beef tri-tip. Ribeye bacon frankfurter jowl, kevin chislic beef ribs pork belly. Fatback ribeye
            sirloin strip steak chislic pork capicola cow ham ground round hamburger rump drumstick turkey kielbasa.
            Pork pig swine kevin rump, biltong ham hock sausage. Ball tip boudin burgdoggen meatball chislic prosciutto
            porchetta frankfurter cupim swine rump. Meatball jowl corned beef swine, cow meatloaf kielbasa bacon beef
            flank prosciutto capicola sausage.

            Does your lorem ipsum text long for something a little meatier? Give our generator a try… it’s tasty!
        </div>
    </div>

```

큰 틀에서 한 파트를 감싸고, 별도로 클래스인 clearfix 클래스를 만들고, ::after를 이용하여 해당 요소 이후에 추가할 내용은 없고, 양쪽방향으로의 흐름을 해제하고, 블록 디스플레이(or table 디스플레이)를 설정하는 것처럼 적용하는 것이 매우 효과적이다

특히 이렇게 클래스를 선언해두면 다른 문단 등에서도 재활용할 수 있기 때문에 효율적이다

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container{
            margin-bottom:30px;
        }
        .clearfix::after{
            content:"";
            clear:both;
            display:block;
        }
        .left{
            background-color:orange;
            float:left;
            margin-right:10px;
        }
        .left::after{
            content:"float left";
        }
        .right{
            background-color: yellowgreen;
            float:right;
            margin-left:10px;
        }
        .right::after{
            content:"float right";
        }
        .left,
        .right{
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
    <div class="container clearfix">
        <div class="left"></div>
        <div class="left"></div>
        <div class="left"></div>
    </div>
    <div class="container clearfix">
        <div class="right"></div>
        <div class="right"></div>
        <div class="right"></div>
    </div>
</body>
</html>
```

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%EC%9D%84%20%EC%9D%B4%EC%9A%A9%ED%95%9C%20%EC%88%98%ED%8F%89%EC%A0%95%EB%A0%AC.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%EC%9D%84%20%EC%9D%B4%EC%9A%A9%ED%95%9C%20%EC%88%98%ED%8F%89%EC%A0%95%EB%A0%AC.PNG?raw=true)

float을 이용한 수평정렬

마찬가지로, 동일한 원리를 이용해서 특정 요소들에 대해서 위와 같이 왼쪽방향으로 수평정렬을 하고, 그 이후 float 흐름을 해제한 후, 오른쪽 방향으로 수평정렬 후 float 흐름을 해제하여 각각에 대해서 수평정렬을 지정하여 사용할 수 있다

주의할 점은, 우측으로 float하게 되면, 맨 첫번째 요소부터 차례대로 오른쪽 끝부터 왼쪽 방향으로 차곡차곡 쌓여진다는 점이다!

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .box{
            width: 100px;
            height: 100px;
            background-color: tomato;
            float:left;
            margin-right:10px;
        }
        .box4{
            width: 300px;
            height: 300px;
            background-color: yellow;
        }
    </style>
</head>
<body>
    <div class="box">1</div>
    <div class="box">2</div>
    <div class="box">3</div>
    <div class="box4">4</div>
</body>
</html>
```

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%20%EC%9D%84%20%ED%95%B4%EC%A0%9C%ED%95%98%EC%A7%80%20%EC%95%8A%EC%9D%84%20%EB%95%8C%20%EB%82%98%ED%83%80%EB%82%A0%20%EC%88%98%20%EC%9E%88%EB%8A%94%20%EB%AC%B8%EC%A0%9C%EC%A0%90.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%20%EC%9D%84%20%ED%95%B4%EC%A0%9C%ED%95%98%EC%A7%80%20%EC%95%8A%EC%9D%84%20%EB%95%8C%20%EB%82%98%ED%83%80%EB%82%A0%20%EC%88%98%20%EC%9E%88%EB%8A%94%20%EB%AC%B8%EC%A0%9C%EC%A0%90.PNG?raw=true)

float을 해제하지 않을때 나타날 수 있는 요소 겹침

위와 같이 float 흐름을 해제하지 않고, float속성을 갖지 않는 새로운 요소를 추가하게 되면 window 왼쪽에 요소가 위치하여 요소가 겹치게 된다! 따라서 만약 의도적으로 겹치고자 함이 아니라면 흐름을 clear로 해제해줌이 바람직하다(원하는 목적이 그것이 아니라하면, float:left를 노란 상자에도 추가해주면, 3 이라는 박스 뒤에 쌓여 수평정렬되는 것처럼 보인다)

아니다! 나는 4번 박스를 아래라인에 오도록 하고싶다! 라면,

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .box{
            width: 100px;
            height: 100px;
            background-color: tomato;
            float:left;
            margin-right:10px;
        }
        .box4{
            width: 300px;
            height: 300px;
            background-color: yellow;
            clear:left;
        }
    </style>
</head>
<body>
    <div class="box">1</div>
    <div class="box">2</div>
    <div class="box">3</div>
    <div class="box4">4</div>
</body>
</html>
```

위와 같이 box4요소에서 clear left를 해주면 된다

앞서 언급한 float을 해제하는 방법을 포함하여 다른 float 해제 방법들도 존재하는데, 이를 정리해보자

1. 형제요소에 clear: (left 혹은 right 혹은 both) 추가
-바로 위에 있는 코드가 그 예를 보여주고 있다!!
-다음 형제 요소를 만들어야한다는 단점이 있다!
2. 부모요소에 overflow:(hidden 혹은 auto)추가[넘치는 요소는 잘라내던가, 스크롤을 생성하여 보여주도록 하기]
3. 부모요소에 clearfix 클래스를 추가[위에서 언급된 방법] 강추!! 🌟

두번째 예만 확인해보자

```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .parent{
            overflow:hidden;
        }
        .box{
            width: 100px;
            height: 100px;
            background-color: tomato;
            float:right;
            margin-right:10px;
        }
        .box4{
            width: 300px;
            height: 300px;
            background-color: yellow;
            /*clear:both;형제요소에서 해제*/
        }
    </style>
</head>
<body>
    <div class="parent">
        <div class="box">1</div>
        <div class="box">2</div>
        <div class="box">3</div>
    </div>
    <div class="box4">4</div>
</body>
</html>
```

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/%EB%B6%80%EB%AA%A8%EC%9A%94%EC%86%8C%EC%97%90%20overflow%20hidden%EC%9D%84%20%EC%A3%BC%EC%96%B4%20float%20%ED%95%B4%EC%A0%9C%ED%95%98%EB%8A%94%20%EB%B0%A9%EB%B2%95.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/%EB%B6%80%EB%AA%A8%EC%9A%94%EC%86%8C%EC%97%90%20overflow%20hidden%EC%9D%84%20%EC%A3%BC%EC%96%B4%20float%20%ED%95%B4%EC%A0%9C%ED%95%98%EB%8A%94%20%EB%B0%A9%EB%B2%95.PNG?raw=true)

부모 요소에 대해서 overflow 속성을 hidden 혹은 auto로 지정함으로써 float 해제시키기

위와 같이 float의 흐름대로 정렬을 하다가, 넘치는 경우는 보이지 않게 하거나, 자동계산하여 스크롤로 보여주게 함으로써 float을 해제한 효과를 보여줄 수 있다

하지만 이는 편리상 사용되는 것이지 권장되지는 않는다!(일종의 편법!)

세번째 방식을 다시 한번 복습해보자면

```html
<div class="parent clearfix">
	<div class="child"></div>
	<div class="child"></div>
</div>
```

위와 같은 html 골격 구조가 있다면

```css
.clearfix::after{
	content:"";
  clear:both;
  display:block;/*혹은 auto*/
}
.child{
	float:left;
}
```

아래와 같은 clearfix와 가상 요소 선택자 after를 이용하는데, clearfix 뒤에는 content는 넣지 않고 clear로 흐름을 모두 해제하고, block 디스플레이로 설정해줌으로써 float을 효과적으로 해제시켜줄 수 있다(다음 형제 요소를 만드는 것과 비교하면, 의미는 유사하지만 보다 효과적!)

🌟 단, clearfix의 자식요소에는 float이 되는 요소들만! 있어야 일괄적용,제어가 가능하다!

🌟 float 속성이 추가된 요소는 display 속성이 대부분 block으로 수정됨

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%20%EC%86%8D%EC%84%B1%EC%9D%80%20%EC%9A%94%EC%86%8C%EC%9D%98%20display%20%EC%86%8D%EC%84%B1%EC%9D%84%20block%EC%9C%BC%EB%A1%9C%20%EB%B3%80%EA%B2%BD.PNG?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/FE/CSS/Basic/float%20%EC%86%8D%EC%84%B1%EC%9D%80%20%EC%9A%94%EC%86%8C%EC%9D%98%20display%20%EC%86%8D%EC%84%B1%EC%9D%84%20block%EC%9C%BC%EB%A1%9C%20%EB%B3%80%EA%B2%BD.PNG?raw=true)

float 속성의 요소에 대한 display  속성 변경 특징

위와 같이, float은 요소의 display 속성을 block으로 변경시킬 수 있음을 확인해볼 수 있다!

즉, 인라인요소가 블록요소로 변경되면서 크기와 위아래 margin을 가질 수 있게 되는 것이다

단, flex와 inline-flex 디스플레이만이 float을 설정해도 디스플레이에 변화가 없다

(flex는 float 뿐아니라 flex를 적용해도 변화가 없다)

(inline-flex는 float뿐아니라 inline-flex를 적용해도 변화가 없다!)

이 두 속성을 제외한 나머지 디스플레이에서는 대부분 float을 사용하게 되면서 디스플레이값이 block으로 변경되어 적용된다
