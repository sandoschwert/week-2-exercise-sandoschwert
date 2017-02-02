package edu.madisoncollege.entjava;


import java.io.*;
import java.util.*;
import org.apache.log4j.*;

/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3. <= another unit test
 * ))((((( also results in floor 3. <= another unit test
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application: you will use only unit tests to run your code.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {
// your code to read in the file and determine the floor number goes here. 
//Remember to structure your code in small, single-purpose methods

    private final Logger logger = Logger.getLogger(this.getClass());

    public void readFile(String inputFilePath) {

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(inputFilePath));

            while (buffReader.ready()) { //while there is a line for me to read...
                splitFile(buffReader);
            }

        } catch(FileNotFoundException fileNotFound) {
            System.out.println("Where's yer file?");
            fileNotFound.printStackTrace();
        } catch(IOException ioException) {
            System.out.println("Yer file tengo problemos");
            ioException.printStackTrace();
        } catch(Exception exception) {
            System.out.println("Mo' code, mo' problems");
            exception.printStackTrace();
        }

    }

    public void splitFile(BufferedReader reader) throws IOException {
        String newLine;

        while (reader.ready()) {
            newLine = reader.readLine();

            String[] characterSplit = newLine.split("");

            getElevatorDirectionsFromFile(characterSplit);

        }
    }

    private void getElevatorDirectionsFromFile(String[] characterSplit) {
        List<String> elevatorDirections = new ArrayList<String>();;
        for (int i = 0; i < characterSplit.length; i++) {
            elevatorDirections.add(characterSplit[i]);
        }
        getSantasCurrentFloor(elevatorDirections);
    }

    public int getSantasCurrentFloor(List<String> elevatorDirections) {

        String goUp = "(";
        String goDown = ")";
        int currentFloor = 0;

        for (String elevatorDirection : elevatorDirections) {
            if (elevatorDirection.equals(goUp)) {
                currentFloor ++;
            } else if (elevatorDirection.equals(goDown)) {
                currentFloor --;
            } else {
                logger.info("this isn't a paren!");
            }

        }
        logger.info("Santa is on floor number: " + currentFloor);
        return currentFloor;
    }


}


