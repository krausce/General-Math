
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class AlgebraTutor {
    
    public static void main(String[] args) {
        int user_problem_selection = 0;
		while(user_problem_selection != 4) {
			int total_questions_attempted = 0;
			int total_questions_correct = 0;
			int number_correct = 0;
			displayMenu();
			user_problem_selection = getUserProblemSelection();
			while(number_correct < 3) {
				if(user_problem_selection == 1) {
					boolean is_correct = solveForY();
					if(is_correct == true) {
						number_correct++;
						total_questions_correct++;
						total_questions_attempted++;
						if(number_correct == 3) {
							System.out.println("Great job! You got 3 in a row!");
			            	System.out.println("Your success rate was %" + getSuccessPercentage(total_questions_correct, total_questions_attempted));
						}
					} else if(is_correct != true){
						number_correct = 0;
						total_questions_attempted++;
						if(total_questions_attempted >= 4) {
			            	System.out.println("Hint: to solve for Y, first you multiply M by X and finally add B.");
			            }
					}
				} else if(user_problem_selection == 2) {
					boolean is_correct = solveForM();
					if(is_correct == true) {
						number_correct++;
						total_questions_correct++;
						total_questions_attempted++;
						if(number_correct == 3) {
							System.out.println("Great job! You got 3 in a row!");
			            	System.out.println("Your success rate was %" + getSuccessPercentage(total_questions_correct, total_questions_attempted));
						}
					} else {
						number_correct = 0;
						total_questions_attempted++;
						if((total_questions_attempted ) >= 4) {
			            	System.out.println("Hint: to solve for M, first you subtract B from Y, then divide that result by X.");
			            }
					}
				} else if(user_problem_selection == 3) {
					boolean is_correct = solveForB();
					if(is_correct == true) {
						number_correct++;
						total_questions_correct++;
						total_questions_attempted++;
						if(number_correct == 3) {
							System.out.println("Great job! You got 3 in a row!");
			            	System.out.println("Your success rate was %" + getSuccessPercentage(total_questions_correct, total_questions_attempted));
						}
					} else {
						number_correct = 0;
						total_questions_attempted++;
						if((total_questions_attempted ) >= 4) {
			            	System.out.println("Hint: to solve for B, first you multiply M * X, then subtract the result from Y.");
			            }
					}
					
				} else {
					break;
				}
			}
		}
    }
    
    
    public static int generateRandomInteger() {
		int min_value = -100;
		int max_value = 100;
		int random_number = ThreadLocalRandom.current().nextInt(min_value, max_value + 1);
		return random_number;
	}
    
    public static boolean solveForY() {
        int m = generateRandomInteger();
        int x = generateRandomInteger();
        int b = generateRandomInteger();
    	int y = m*x + b;
        System.out.println(y);
        System.out.println("Given: \nM = " + m + "\nX = " + x + "\nB = " + b);
        System.out.print("What is the correct value of Y? ");
        int user_answer = (int) getUserAnswer();
        boolean answer_is_correct = (user_answer == y);
        if(answer_is_correct == true){
            System.out.println("Correct!");
        } else if(answer_is_correct != true){
        	System.out.println("Sorry, that's wrong. The correct answer is Y = " + y);
        }
    	return (user_answer == y);
    }
    public static boolean solveForM() {
    	int y = generateRandomInteger();
        int x = generateRandomInteger();
        int b = generateRandomInteger();
    	double m = Math.round(((double) (y - b)/ (double) x)*100.00)/100.00;
    	System.out.println(m);
        System.out.println("Given: \nX = " + x + "\nB = " + b + "\nY = " + y);
        System.out.print("What is the correct value of M? ");
        double user_answer = getUserAnswer();
        boolean answer_is_correct = (user_answer == m);
        if(answer_is_correct == true){
            System.out.println("Correct!");
        } else if(answer_is_correct != true){
        	System.out.println("Sorry, that's wrong. The correct answer is M = " + m);
        }
    	return (user_answer == m);
    }
	public static boolean solveForB() {
		int y = generateRandomInteger();
        int x = generateRandomInteger();
        int m = generateRandomInteger();
    	int b = y - m*x;
    	System.out.println(b);
        System.out.println("Given: \nM = " + m + "\nX = " + x + "\nY = " + y);
        System.out.print("What is the correct value of B? ");
        double user_answer = getUserAnswer();
        boolean answer_is_correct = (user_answer == b);
        if(answer_is_correct == true){
            System.out.println("Correct!");
        } else if(answer_is_correct != true){
        	System.out.println("Sorry, that's wrong. The correct answer is B = " + b);
        }
    	return (user_answer == b);
	    }

    public static double getUserAnswer() {        
		Scanner user_input = new Scanner( System.in );
		double user_answer = 0.0;
        user_answer = user_input.nextDouble();
		
		return user_answer;
	}
    
    public static void displayMenu() {
		int height = 20;
		for(int count = 1; count <= height; count++) {
			if(count == 1 || count == height) {
				printFirstLineOrLastLine(height);
			} else if(count == 2) {
				System.out.println("*********************************************************");
				System.out.println("**    Welcome to Mr. Escalante's Algebra Challenge.    **");
				System.out.println("*********************************************************");
			} else if(count > 2 && count != Math.round((height/2))) {
				System.out.println("*                                                       *");
			} else if(count == Math.round((height/2))){
				System.out.println("*                    1. Solve for Y.                    *");
				System.out.println("*                                                       *");
				System.out.println("*                    2. Solve for M.                    *");
				System.out.println("*                                                       *");
				System.out.println("*                    3. Solve for B.                    *");
				System.out.println("*                                                       *");
				System.out.println("*                    4. End the program.                *");
			}
		}
	}
	
	public static void printFirstLineOrLastLine(int height) {
		for(int count = 1; count <= height; count++) {
			if(count == 1) {
				System.out.print("+ ");
			} else if (count == height) {
				System.out.println("+");
			} else {
				System.out.print("*  ");
			}
		}
	}
	
	public static int getUserProblemSelection() {
		Scanner user_input = new Scanner( System.in );
		int selection = 0;
		System.out.print("Enter the corresponding number to the problem you wish to practice: ");
		selection = user_input.nextInt();
		return selection;
	}
	
	public static double getSuccessPercentage(int total_questions_correct, int total_questions_attempted) {
    	System.out.println(total_questions_correct);
    	System.out.println(total_questions_attempted);
    	double success_percentage = (double) total_questions_correct/ (double) total_questions_attempted;
    	System.out.println(success_percentage);
    	success_percentage = Math.round(success_percentage*100.00);
    	return success_percentage;
    }
}