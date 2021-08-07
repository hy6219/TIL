public class Main {
    public static void main(String[] args){
        System.out.println("hello JUnit");

//        Calculator c=new Calculator(new KrwCalculator());
//
//        System.out.println(c.sum(10,10));

        MarketApi marketApi=new MarketApi();
        DollarCalculator d= new DollarCalculator(marketApi);
        d.init();

        Calculator c2=new Calculator(d);
        System.out.println(c2.sum(10,10));

    }
}
