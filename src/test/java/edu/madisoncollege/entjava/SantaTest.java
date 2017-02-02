package edu.madisoncollege.entjava;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sando on 2/1/17.
 */
public class SantaTest {
    SantaInAnElevator newSanta = new SantaInAnElevator();
    List<String> testList = new ArrayList<String>();
    String inputFilePath = "/home/student/Documents/week-2-exercise-sandoschwert/src/test/resources/SantaUpDown.txt";
    String testFilePath = "/home/student/Documents/week-2-exercise-sandoschwert/src/test/resources/test.txt";
    String testHipsumFilePath = "/home/student/Documents/week-2-exercise-sandoschwert/src/test/resources/fakeFile.txt";
    String noFilePath = "iDoNotExist.txt";

    @Before
    public void setup() {

    }

    @Test
    public void testElevatorDirections() {
        testList.add("(");
        testList.add("(");
        testList.add(")");
        testList.add("(");
        testList.add("(");

        assertEquals("Current floor is correct", 3, newSanta.getSantasCurrentFloor(testList));
    }

    @Test
    public void testReadFile() {
        newSanta.readFile(testFilePath);

    }

    @Test
    public void testHipsumFile() {
        newSanta.readFile(testHipsumFilePath);
    }

    @Test
    public void testForFileNotFound() {
        newSanta.readFile(noFilePath);
    }

    @Test
    public void testSantasFloor() {
        newSanta.readFile(inputFilePath);
    }

}
