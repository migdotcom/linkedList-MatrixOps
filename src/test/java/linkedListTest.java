
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class linkedListTest {
//given when then

    private DoublyLinkedList list;


    @Before
    public void setUp() throws Exception {
        list = new DoublyLinkedList();
    }
    private void givenAListWithContaining(int... elements) {
        for (int i :elements) {
            list.addFirst(i);
        }
    }
    @Test
    public void nothing() throws Exception {
        assertEquals(0, list.size());

    }

    @Test
    public void testGivenOne_elementSizeIsOne() throws Exception {
        givenAListWithContaining(1);
        assertEquals(1,list.size());


    }
    @Test
    public void testGivenTwo_elementSizeIsTwo() throws Exception {
        givenAListWithContaining(1,2);
        assertEquals(2,list.size());
    }

    @Test
    public void create_row_based_matrix() throws Exception {

    }
    //    @Test
//    public void getOne_Value() throws Exception {
//        givenAListWithContaining(1);
//        int result = list.get(0);
//        assertEquals(1,result);
//
//    }
//    @Test
//    public void getSecond_Value() throws Exception {
//        givenAListWithContaining(1,2,6,4,20,34);
//        int result = list.get(2);
//        assertEquals(6,result);
//
//    }
//
//    @Test
//    public void getAny_AndReturnValue() throws Exception {
//        givenAListWithContaining(2,6,2,6, 2, 18,17, 11, 20);
//        int result = list.get(2);
//        assertEquals(2,result);
//
//    }
}

