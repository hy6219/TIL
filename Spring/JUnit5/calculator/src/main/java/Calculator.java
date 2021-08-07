public class Calculator{
    //구현하지 않고
    //포함시켜서 진행
    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator){
        this.iCalculator=iCalculator;
    }

    public int sum(int x, int y){
        return this.iCalculator.sum(x,y);
    }

    public int minus(int x, int y){
        return this.iCalculator.minus(x,y);
    }

}
