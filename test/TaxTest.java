import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

/**
 * @author xiangwehao
 * create 2020/4/9
 */

@RunWith(Parameterized.class)
public class TaxTest {
    private Tax tax;
    private double expected;
    private double salary;
    @Before
    public void init(){
        System.out.println("初始化tax");
        tax=new Tax();
    }
    @Parameters
    public static List<Object[]> PrepareData(){
        Object[][] objects={{1000,0.0},{2000,0.0},
                            {2200,10.0},{2500,25.0},
                            {3000,75.0},{4000,175.0},
                            {10000,1225.0},{20000,3225.0},
                            {30000,5625.0},{40000,8125.0},
                            {50000,11025.0},{60000,14025.0},
                            {70000,17425.0},{80000,20925.0},
                            {90000,24825.0},{100000,28825.0},
                            {200000,73725.0},{300000,118725.0}
    };
    return Arrays.asList(objects);
    }
    @Test
    public void test1(){
        double a=tax.countTax(this.salary);
        System.out.println(a+"   "+this.expected);
        Assert.assertEquals(a,this.expected,0.0);
    }
    public TaxTest( double salary,double expected ){
        this.expected=expected;
        this.salary=salary;
    }

}