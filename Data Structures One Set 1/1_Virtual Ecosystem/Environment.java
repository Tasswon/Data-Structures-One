/** Author: Joseph Tassone
 *  Description: Program creates a virtual ecosystem of cat and mice. The cat and mice
 *  objects move about the ecosystem (array) once per time frame (user set), and 
 *  act based on their collisions with each other (no movement, mice death, breeding). 
 */

import java.util.Arrays;
import java.util.Scanner;

public class Environment {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);


		int row = 0;
		int column = 0;

		//Prevents user from entering rows and columns less than 3
		while (true) {
			System.out.print("Enter the row size: ");
			row = input.nextInt();

			System.out.print("Enter the column size: ");
			column = input.nextInt();

			if(row < 3 || column < 3) {
				System.out.println("Rows and Columns must be greater than 3! Try again!");
			}
			else {
				break;
			}
		}

		Creature [][]array = new Creature[row][column];

		//Prevents user from entering certain values
		int catNumbers = 0;
		int mouseNumbers = 0;

		while(true) {
			System.out.print("Enter the number of cats: ");
			catNumbers = input.nextInt();

			System.out.print("Enter the number of mice: ");
			mouseNumbers = input.nextInt();

			if((row * column) < (catNumbers + mouseNumbers)) {
				System.out.println("Greater than the size of the array! Try again!");
			}
			else if (mouseNumbers == (row * column ) || catNumbers == (row * column )) {
				System.out.println("A single creature cannot fill the entire array! Try again!");
			}
			else if (mouseNumbers < 0 || catNumbers < 0) {
				System.out.println("Cat and/or Mouse numbers cannot be negative! Try again!");
			}
			else {
				break;
			}
		}

		//Inserts cat objects to random points in the array
		catPlacement(array, catNumbers, row, column);

		//Inserts mouse objects to random points in the array
		micePlacement(array, mouseNumbers, row, column);

		//Continues until you tell it to stop
		while(true) {

			System.out.print("What is the timeframe: ");
			int timeFrame = input.nextInt();

			if(timeFrame == 0) {
				System.out.println("Thank you!");
				break;
			}

			//Loops for the duration of the timeframe
			for(int time = 0; time < timeFrame; time ++) {

				//Ends the program if the array is filled with cats, and there's no mice or nulls
				if(catCounter(array) == (row * column)) {
					System.out.println("Array only has cats! \n" + Arrays.deepToString(array));
					System.out.println("\nTHANK YOU!!!");
					System.exit(0);
				}

				//Print statement
				for (int x = 0; x < array.length; x++) {
					for(int y = 0; y < array[x].length; y++) {

						if(array[x][y] == null) {
							System.out.print("-" + " ");
						}
						else {
							System.out.print(array[x][y] + " ");
						}
					}
					System.out.println();
				}
				System.out.println();


				//Sets the double movement flag to false
				for(int r1 = 0; r1 < array.length; r1++) {
					for(int c1 = 0; c1 < array[r1].length; c1++) {
						if (array[r1][c1] != null) {
							array[r1][c1].setMovement(false);
						}
					}
				}

				//Loops through it based on timeframe
				for(int r = 0; r < array.length; r++) {
					for(int c = 0; c < array[r].length; c++) {

						//Checks if index is empty
						if(array[r][c] == null) {
							continue;
						}

						//Checks if it's a cat
						else if(array[r][c] instanceof Cat) {

							//Checks if the cat is moving 
							int movementChance = (int) (1 + Math.random() * (10 - 1));
							if(movementChance > 6  && (array[r][c].isMoving()) == true) {
								continue;
							}

							//Randomizes movement and set movement to true (prevents double movement)
							else {

								array[r][c].setMovement(true);
								int movement = (int) (1 + Math.random() * (4 - 1));

								//Moves cat right
								if (movement == 1) {

									//Doesn't move if cat movement is out of bounds
									if ((c + 1) > (column - 1)) {
										continue;
									}

									//Moves if cat movement isn't out of bounds
									else {

										//Takes over index if it's equal to null or instance of a mouse object
										if (array[r][c + 1] == null || array[r][c + 1] instanceof Mouse) {
											array[r][c + 1] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r][c + 1].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												kittenPlacer(array, row, column);
											}
										}
									}
								}


								//Moves cat left
								else if (movement == 2) {

									//Doesn't move if cat movement is out of bounds
									if ((c - 1) < (0)) {
										continue;
									}

									//Moves if cat movement isn't out of bounds
									else {

										//Takes over index if it's equal to null or instance of a mouse object
										if (array[r][c - 1] == null || array[r][c - 1] instanceof Mouse) {
											array[r][c - 1] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r][c - 1].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												kittenPlacer(array, row, column);
											}
										}
									}
								}

								//Moves cat down
								else if (movement == 3) {

									//Doesn't move if cat movement is out of bounds
									if ((r + 1) > (row - 1)) {
										continue;
									}

									//Moves if cat movement isn't out of bounds
									else {

										//Takes over index if it's equal to null or instance of a mouse object
										if (array[r + 1][c] == null || array[r + 1][c] instanceof Mouse) {
											array[r + 1][c] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r + 1][c].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												kittenPlacer(array, row, column);
											}
										}
									}
								}

								//Moves cat up
								else {

									//Doesn't move if cat movement is out of bounds
									if ((r - 1) < (0)) {
										continue;
									}

									//Moves if cat movement isn't out of bounds
									else {

										//Takes over index if it's equal to null or instance of a mouse object
										if (array[r - 1][c] == null || array[r - 1][c] instanceof Mouse) {
											array[r - 1][c] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r - 1][c].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												kittenPlacer(array, row, column);
											}
										}
									}
								}
							}
						}


						//Checks if it's a mouse
						else {

							//Checks if the mouse is moving 
							int movementChance = (int) (1 + Math.random() * (10 - 1));
							if(movementChance > 9 && (array[r][c].isMoving()) == true) {
								continue;
							}

							//Randomizes movement
							else {
								array[r][c].setMovement(true);
								int movement = (int) (1 + Math.random() * (4 - 1));

								//Moves mouse right
								if (movement == 1) {

									//Doesn't move if mouse movement is out of bounds
									if ((c + 1) > (column - 1)) {
										continue;
									}

									//Moves if mouse movement isn't out of bounds
									else {

										//Takes over index if it's equal to null
										if (array[r][c + 1] == null ) {
											array[r][c + 1] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Mouse dies if it moves into a cat
										else if (array[r][c + 1] instanceof Cat) {
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r][c + 1].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												micePlacer(array, row, column);
											}
										}
									}
								}

								//Moves mouse left
								else if (movement == 2) {

									//Doesn't move if mouse movement is out of bounds
									if ((c - 1) < (0)) {
										continue;
									}

									//Moves if mouse movement isn't out of bounds
									else {

										//Takes over index if it's equal to null
										if (array[r][c - 1] == null ) {
											array[r][c - 1] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Mouse dies if it moves into a cat
										else if (array[r][c - 1] instanceof Cat) {
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r][c - 1].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												micePlacer(array, row, column);
											}
										}
									}
								}

								//Moves mouse down
								else if (movement == 3) {

									//Doesn't move if mouse movement is out of bounds
									if ((r + 1) > (row - 1)) {
										continue;
									}

									//Moves if mouse movement isn't out of bounds
									else {

										//Takes over index if it's equal to null
										if (array[r + 1][c] == null ) {
											array[r + 1][c] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Mouse dies if it moves into a cat
										else if (array[r + 1][c] instanceof Cat) {
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r + 1][c].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												micePlacer(array, row, column);
											}
										}
									}
								}

								//Moves mouse up
								else {

									//Doesn't move if cat movement is out of bounds
									if ((r - 1) < (0)) {
										continue;
									}

									//Moves if cat movement isn't out of bounds
									else {

										//Takes over index if it's equal to null
										if (array[r - 1][c] == null ) {
											array[r - 1][c] = array[r][c];
											array[r][c] = null;
											continue;
										}

										//Mouse dies if it moves into a cat
										else if (array[r - 1][c] instanceof Cat) {
											array[r][c] = null;
											continue;
										}

										//Checks if cats are the same gender
										else {

											if (array[r - 1][c].isGender() != array[r][c].isGender()) {
											}

											//If it is the same gender then counts the available slots (nulls) and puts cats into them
											else {

												micePlacer(array, row, column);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}						


	//Places cats randomly into the array
	public static Creature[][] catPlacement(Creature[][] array, int catNumbers, int row, int column) {
		int i = 0;
		while (i < catNumbers) {
			int randomRow = (int) (Math.random() * (row));
			int randomColumn = (int) (Math.random() * (column));

			if(array[randomRow][randomColumn] == null) {
				array[randomRow][randomColumn] = new Cat();
				i++;
			}
		}
		return array;
	}

	//Places mice randomly into the array
	public static Creature[][] micePlacement(Creature[][] array, int mouseNumbers, int row, int column) {
		int j = 0;
		while (j < mouseNumbers) {
			int randomRow = (int) (Math.random() * (row));
			int randomColumn = (int) (Math.random() * (column));

			if(array[randomRow][randomColumn] == null) {
				array[randomRow][randomColumn] = new Mouse();
				j++;
			}
		}
		return array;
	}


	//Method counts the number of cats in the array
	public static int catCounter(Creature[][] array) {
		int catCount = 0;

		for(int row = 0; row < array.length; row++) {
			for(int column = 0; column < array[row].length; column++) {
				if(array[row][column] instanceof Cat) {
					catCount++;
				}
			}
		}
		return catCount;
	}

	//Counts the number of nulls in the array
	public static int nullCounter(Creature[][] array) {
		int nullCount = 0;

		for(int row = 0; row < array.length; row++) {
			for(int column = 0; column < array[row].length; column++) {
				if(array[row][column] == null) {
					nullCount++;
				}
			}
		}
		return nullCount;
	}

	//Puts cats into random slots if they mated 
	public static Creature[][] kittenPlacer(Creature[][] array, int row, int column) {
		int kittens = 0;

		while (kittens < 2 && nullCounter(array) >= 1) {
			int randomRow = (int) (Math.random() * (row));
			int randomColumn = (int) (Math.random() * (column));

			if(array[randomRow][randomColumn] == null) {
				array[randomRow][randomColumn] = new Cat();
				array[randomRow][randomColumn].setMovement(true);

				kittens++;
			}
		}
		return array;
	}


	//Puts mice into random slots if they mated 
	public static Creature[][] micePlacer(Creature[][] array, int row, int column) {

		int randomMice = (int) (3 + Math.random() * (5 - 3));
		int mice = 0;

		while (mice < randomMice && nullCounter(array) >= 1) {
			int randomRow = (int) (Math.random() * (row));
			int randomColumn = (int) (Math.random() * (column));

			if(array[randomRow][randomColumn] == null) {
				array[randomRow][randomColumn] = new Mouse();
				array[randomRow][randomColumn].setMovement(true);

				mice++;
			}
		}
		return array;
	}
}