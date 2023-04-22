import MMS.*;
/*
           Assignment number :10
           File Name : ListTest.java
           Name: Ran Zaaroor
           Student ID : 209374040
           Email : Ran.zaaroor@gmail.com
       */
/** Tests the methods of the List class.  */
public class ListTest {

    // To make the tests code compact, we declare a class-level list,  
    // and a few class-level memory blocks. The contents of the memory blocks 
    // is the same as described in the examples of the Homework 10 document.
    // All the tests in this class can use these class-level variables. 
    private static List list;

    private static MemBlock fb1 = new MemBlock(208,10);
    private static MemBlock fb2 = new MemBlock(352,12);
    private static MemBlock fb3 = new MemBlock(250,20);

    private static MemBlock ab1 = new MemBlock(50,3);
    private static MemBlock ab2 = new MemBlock(370,2);

    public static void main (String[] args) {
        testAddLast();
        testAddFirst();
        testRemoveFirst();
        testRemove();
    }  
    
    // Tests the AddLast method of the List class.
    // Illustrates how to use the class-level variables.
    // All the other tests in this class can look more or less the same as this test.
    private static void testAddLast() {
        list = new List();  System.out.println(list);
        list.addLast(fb1);  System.out.println(list);
        list.addLast(fb2);  System.out.println(list);
        list.addLast(fb3);  System.out.println(list);
    }

    private static void testAddFirst() {
        list = new List();
        list.addFirst(fb1);
        list.addFirst(fb2);
        list.addFirst(fb3);
        list.addFirst(ab2);
        System.out.println(list);
        list.remove(ab1);
        System.out.println(list);
    }

    private static void testRemoveFirst() {
        list = new List();
        list.addFirst(fb1);
        list.addFirst(fb2);
        list.addFirst(fb3);
        list.addFirst(ab2);
        list.removeFirst();
        System.out.println(list);
        
    }

    private static void testRemove() {
        list = new List();
        list.addFirst(fb1);
        list.addFirst(fb2);
        list.addFirst(fb3);
        list.addFirst(ab2);
        list.remove(fb1);
        System.out.println(list);
    }
}
