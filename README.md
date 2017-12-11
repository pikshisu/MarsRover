# MarsRover

Programming language: Java 8

Testing framework: JUnit 5

How to run:
1. Open up project in an IDE that supports Java
2. Add JUnit 5 to the class path
  * Instructions for IntelliJ: Navigate to RoverTest.java, highlight @test, click Alt+Enter and install JUnit5 
  * (tests/com/company/RoverTest)
3. Run Main.java if you wish to test your own input
  * (src/com/company/Main)
4. Run RoverTest.java for various test cases that I've included

Assumptions:
* Lower left coordinates of the plateau are assumed to be 0,0
* Plateau cannot be changed once instantiated
* The only valid commands are L, R and M
* The rover can only face North, East, South or West

Design:
* Plateau
  * Instantiated with the upper left coordinates
  * Upper left coordinates are validated and will return an error if either of them is less that 1
  * Can check whether a specific coordinate is inside the plateau

* Rover
  * Rover position can be changed (allowing it to simulate additional rovers)
  * Implements rover instructions turnLeft(), turnRight() and move()
  * Bounds checking (with respect to the plateau)
  * Executes a string of character instructions (consisting of L, R and M only)

* RoverTest
  * TestCase1: Test data supplied in the email
  * TestCase2: Tests invalid plateau size
  * TestCase3: Tests invalid starting position
  * TestCase4: Tests invalid instruction
  * TestCase5: Tests bounds checking
