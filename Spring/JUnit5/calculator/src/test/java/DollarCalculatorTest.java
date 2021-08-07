import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {
    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi=new MarketApi();
        DollarCalculator d= new DollarCalculator(marketApi);
        d.init();

        Calculator c2=new Calculator(d);
        System.out.println(c2.sum(10,10));

        Assertions.assertEquals(22000,c2.sum(10,10));

    }

    @Test
    public void mockTest(){
     //   MarketApi marketApi=new MarketApi();
        DollarCalculator d= new DollarCalculator(marketApi);
        d.init();

        Calculator c2=new Calculator(d);
        System.out.println(c2.sum(10,10));

        Assertions.assertEquals(60000,c2.sum(10,10));

    }

}
