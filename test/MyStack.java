/**
 * @author xiangwehao
 * create 2020/4/9
 */
public class MyStack {
    private String[] elements;
    int nextIndex;

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public MyStack(){
        elements = new String[100];
        nextIndex = 0;
    }
    public void push(String element) throws Exception{
        if(nextIndex == 100)
            throw new Exception("数组越界1！");
        elements[nextIndex++] = element;
    }
    public String pop() throws Exception{
        if(nextIndex == 0)
            throw new Exception("数组越界2！");
        return elements[--nextIndex];
    }
    public String top()throws Exception{
        if(nextIndex == 0)
            throw new Exception("数组越界3！");
        return elements[nextIndex-1];
    }
    public void delete(int n)throws  Exception{
        if(nextIndex-n < 0)
            throw new Exception("数组越界4！");
        nextIndex-=n;
    }
}
