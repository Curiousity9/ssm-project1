
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * @author xiangwehao
 * create 2020/4/9
 */
//@FixMethodOrder(MethodSorters.JVM)
public class MyStackTest {
    private MyStack myStack;
    @Before
    public void setUp()throws Exception{
        myStack = new MyStack();
        System.out.println("新建MyStack: ");
    }
//    @Ignore("not ready yet!")
//    @Test
//    public void test(){
//        fail("not yet implemented");
//    }
    @Test(expected = Exception.class)
    public void testPush1()throws Exception{
        System.out.println("tsetPush1");
        for(int i=0;i<120;i++)
            myStack.push(i+"");

    }
    @Test
    public void testPush2()throws Exception{
        System.out.println("tsetPush2");
        for(int i=0;i<10;i++){
            myStack.push(i+"");
        }
        String str = myStack.pop();
        Assert.assertEquals("9",str);
    }
    @Test
    public void testPush3()throws Exception{
        System.out.println("tsetPush3");

        for(int i=0;i<100;i++){
            myStack.push(i+"");
        }
        String str = myStack.pop();
        Assert.assertEquals("99",str);
    }
//    @Ignore("not ready yet2")
    @Test(expected = Exception.class)
    public void testPop1()throws Exception{
        System.out.println("tsetPop1");

        myStack.push("1");
        myStack.push("2");
        myStack.pop( );
        myStack.pop();
        myStack.pop();

    }
    @Test
    public void testPop2()throws Exception{
        System.out.println("tsetPop2");

        myStack.push("1");
        String a=myStack.pop();
        Assert.assertEquals("1",a);
    }
    @Test
    public void testTop1()throws Exception{
        System.out.println("tsetTop1");

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        Assert.assertEquals("c",myStack.top());
    }
    @Test(expected = Exception.class)
    public void testTop2()throws Exception{
        System.out.println("tsetTop2");
        myStack.top();
    }


}
