import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stack.Stack;
import stack.implementation.ArrayStack;
import stack.implementation.LinkedStack;

public class StackTest {

    Stack<Integer> stack;
    @Before
    public void setUp(){
        stack = new ArrayStack<>();//new LinkedStack<>();
    }

    @Test
    public void initTest(){
        Assert.assertEquals(true,stack.empty());
        Assert.assertEquals(0,stack.getSize());
    }

    @Test
    public void testPushPop() throws Exception {

        stack.push(32);
        Assert.assertEquals(Integer.valueOf(32),stack.pop());
        Assert.assertEquals(0,stack.getSize());
        System.out.println(stack);
        stack.push(42);
        stack.push(45);
        stack.push(78);
        stack.push(100);
        System.out.println(stack);
        Assert.assertEquals(Integer.valueOf(100),stack.peek());
        System.out.println("Size: "+stack.getSize());
        System.out.println("Popped: "+stack.pop());
        System.out.println("Size: "+stack.getSize());
        System.out.println(stack);

    }
}
