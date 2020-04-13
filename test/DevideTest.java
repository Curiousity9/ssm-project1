import com.ay.model.AyUser;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author xiangwehao
 * create 2020/4/7
 */
//
//@RunWith(Suite.class)
//@Suite.SuiteClasses(Devide.class)
public class DevideTest {
    private Devide devide;
    @Before
    public void setUp() throws Exception{
        devide = new Devide();
        System.out.println("each initial before each test method");
    }
    @BeforeClass
    public static void init(){
        System.out.println("each initial before each test class!");
    }
    @Test(expected = Exception.class)
    public void testDivide2(){
        System.out.println("2");
        devide.devide(9,0);
    }
    @Test
    public void testDivide(){
        int a=devide.devide(10,2);
        Assert.assertEquals(a,5);
    }
    @After
    public void after(){
        System.out.println("end");
    }
//    @Test
//    public void test2(){
//         int a=devide.devide(10,2);
//        Assert.assertEquals(3,a);
//    }
}
