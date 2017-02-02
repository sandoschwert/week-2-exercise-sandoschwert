package edu.madisoncollege.entjava;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Practice working with JUnit by writing some test cases for the Interface List<E>:
 * 1.1 void add(int index, E e)
 * 1.2 void remove(int index)
 * 1.3 void get(int index)
 *
 * Add at least one test for an exception.
 */
public class ListTest {

    private List<String> myList;

    @Before
    public void setup() {
        myList = new ArrayList<String>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");
    }

    @Test
    public void testAddSuccess() {
        String elementToInsert = "Item 4";

        myList.add(elementToInsert);
        assertEquals("List size is incorrect", 4, myList.size());
        assertTrue("List missing inserted element", myList.contains(elementToInsert));
    }

    @Test
    public void testRemoveSuccess() {
        myList.remove(2);
        assertEquals("List size is correct", 2, myList.size());
    }

    @Test
    public void testGetElement() {
        String element = myList.get(1);
        assertEquals("Expected list item is correct", "Item 2", element);
    }

    @Test
    public void testForOutOfBoundsException() {
        String element = myList.get(12);
        //Can't remember what assert statement to use

    }
}