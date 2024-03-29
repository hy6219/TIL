# 디자인패턴4-데코레이터 패턴

- 구조패턴
- 기존 뼈대(클래스)는 유지하지만, 이후 필요한 형태로 꾸밀 때 사용
- 확장이 필요한 경우 상속의 대안으로도 활용됨
- SOLID 중 개방폐쇄원칙 OCP와 의존역전원칙DIP를 따름

자동차를 예로 들어서 학습해보자!

먼저 자동차라는 기존 뼈대를 두고, 등급별로 가격을 올린다고 생각해보자

![https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4/%EA%B5%AC%EC%A1%B0%ED%8C%A8%ED%84%B4/Decorator%ED%8C%A8%ED%84%B4/%EB%8D%B0%EC%BD%94%EB%A0%88%EC%9D%B4%ED%84%B0%20%ED%8C%A8%ED%84%B4.png?raw=true](https://github.com/hy6219/TIL-Today-I-Learned-/blob/main/Spring/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4/%EA%B5%AC%EC%A1%B0%ED%8C%A8%ED%84%B4/Decorator%ED%8C%A8%ED%84%B4/%EB%8D%B0%EC%BD%94%EB%A0%88%EC%9D%B4%ED%84%B0%20%ED%8C%A8%ED%84%B4.png?raw=true)

데코레이터 패턴

먼저, 

- 금액 값을 출력하는 getter메서드 getPrice()
- 자동차 정보와 함께 금액을 출력해주는 showPrice()

가 들어있는 인터페이스인 "ICar"가 있다고 생각해보자

```java
package com.designPattern.structure.decorator;

public interface ICar {
    int getPrice();
    void showPrice();//금액 출력
}
```

그리고, 아우디 자동차 회사의 자동차는 이 ICar 인터페이스를 구현하는데

필드로 가격인 price를 가지고 있다고 생각하면 아래와 같이 표현할 수 있다

```java
package com.designPattern.structure.decorator;

public class Audi implements ICar{
    private int price;//가격

    public Audi(int price){
        this.price=price;
    }
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("audi의 가격은 "+this.price+" 원 입니다");
    }
}
```

여기서 우리는 이 회사의 자동차의 등급에 따라 금액을 증가시키고 싶고, 등급을 같이 출력해주고 싶다! 그래서, 이 두 속성에 대한 확장을 위해서 "Decorator"클래스로 AudiDecorator를 만들어 주자!

- 필드 : 모델명 modelName, 모델 등급에 따른 증가 금액인 modelPrice

```java
package com.designPattern.structure.decorator;

public class AudiDecorator implements ICar{

    protected ICar audi;
    protected String modelName;//모델명
    protected int    modelPrice;//모델 가격

    public AudiDecorator(ICar audi, String modelName, int modelPrice){
        this.audi = audi;
        this.modelName=modelName;
        this.modelPrice=modelPrice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice()+modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName+"의 가격은 "+getPrice()+"원 입니다");
    }
}
```

이렇게 모델에 따른 모델 가격을 꾸며주는 decorator를 가지고 이제는 모델에 따라 가격을 보여줄 수 있다! 바로! 이 decorator를 상속받은 concrete decorator로써의 A3, A4, A5를 통해서 아래와 같이 모델명을 입력해주고 생성자에 ICar 인스턴스를 같이 제공해준다면 각 모델 객체가 만들어지게 된다. 뿐만 아니라, 상속을 받기 때문에 AudiDecorator에서 오버라이딩한 내용을 바탕으로 메서드들을 사용할 수 있게 된다!

```java
package com.designPattern.structure.decorator;

public class A3 extends AudiDecorator{
    //생성자에 금액은 받지 않고 모델까지만
    public A3(ICar audi, String modelName) {
        super(audi, modelName,1000);
    }
}
```

```java
package com.designPattern.structure.decorator;

public class A4 extends AudiDecorator{
    //생성자에 금액은 받지 않고 모델까지만
    public A4(ICar audi, String modelName) {
        super(audi, modelName,2000);
    }
}
```

```java
package com.designPattern.structure.decorator;

public class A5 extends AudiDecorator{
    //생성자에 금액은 받지 않고 모델까지만
    public A5(ICar audi, String modelName) {
        super(audi, modelName,3000);
    }
}
```

```java
package com.designPattern.structure.decorator;

public class CarMain {
    public static void main(String[] args){
        ICar audi = new Audi(1000);
        audi.showPrice();//audi의 가격은 1000 원 입니다

        //등급을 한번 올려볼것
        //a3
        ICar audi3 = new A3(audi,"A3");
        audi3.showPrice();//A3의 가격은 2000원 입니다
        //a4
        ICar audi4 = new A4(audi,"A4");
        audi4.showPrice();//A4의 가격은 3000원 입니다
        //a5
        ICar audi5 = new A5(audi,"A5");
        audi5.showPrice();//A5의 가격은 4000원 입니다
    }
}
```

그 결과, 위의 CarMain에서처럼, 데코레이터로 인해서 가격 메서드 등이 꾸며졌기 때문에, 각 모델에 따른 금액 변동을 확인해볼 수 있다!

이와 같이 기본 뼈대인 인터페이스를 기반으로, 이를 건드리지 않고, 이를 구현한 클래스를 이용해서 기능을 확장할 수 있는 것이 바로 "데코레이터 패턴"이다!
