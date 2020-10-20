import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import queue.Queue;
import queue.implementation.ArrayQueue;
import queue.implementation.CircularQueue;
import queue.implementation.LinkedQueue;

public class QueueTest {

    private Queue<Integer> queue;
    @Before
    public void setUp(){

        queue = new LinkedQueue<>();
        //queue = new ArrayQueue<>();
    }

    @Test
    public void initTest(){

        Assert.assertEquals(true,queue.empty());
        Assert.assertEquals(0,queue.size());
    }

    @Test
    public void enQdeQTest() throws Exception {

        queue.enqueue(32);
        queue.enqueue(43);
        queue.enqueue(90);
        Assert.assertEquals(3,queue.size());
        Assert.assertEquals(Integer.valueOf(32),queue.dequeue());
        Assert.assertEquals(2,queue.size());
        queue.dequeue();
        queue.enqueue(77);
        queue.enqueue(10);
        Assert.assertEquals(3,queue.size());
        queue.dequeue();
        Assert.assertEquals(2,queue.size());
        queue.enqueue(14);
        queue.enqueue(33);
        queue.enqueue(22);
        queue.enqueue(18);
        queue.dequeue();
        queue.enqueue(44);
        //System.out.println(queue);
        Assert.assertEquals("[ 10 , 14 , 33 , 22 , 18 , 44 ]",queue.toString());
    }
}
