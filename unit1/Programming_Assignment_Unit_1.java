import java.util.Scanner;

public class Programming_Assignment_Unit_1 {
    public static void main(String[] args) {
        String option1 = "Elephant";
        String option2 = "Monkey";
        String option3 = "Donkey";
        String option4 = "Goat";

        int score = 0;
        String questionHandler = "A: " + option1 + "\n" + "B: " + option2 + "\n" + "C: " + option3 + "\n" + "D: " + option4;

        String question1 = "What animal starts with E?\n" + questionHandler;
        String question2 = "What animal starts with M?\n" + questionHandler;
        String question3 = "What animal starts with D?\n" + questionHandler;
        String question4 = "What animal starts with G?\n" + questionHandler;
        String question5 = "What animal does not have an E?\n" + questionHandler;

        Scanner scanner = new Scanner(System.in);
        score += getAnswer1(scanner, question1);
        score += getAnswer2(scanner, question2);
        score += getAnswer3(scanner, question3);
        score += getAnswer4(scanner, question4);
        score += getAnswer5(scanner, question5);

        System.out.println("Your final score is: " + score+"/5");
        double final_score = (score * 100) / 5;
        System.out.println(final_score+"%");
        scanner.close();
    }

    public static int getAnswer1(Scanner scanner, String question1) {
        System.out.println(question1 + "\nPlease enter A, B, C, or D");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("A")) {
            return 1;
        }
        return 0; 
    }

    public static int getAnswer2(Scanner scanner, String question2) {
        System.out.println(question2 + "\nPlease enter A, B, C, or D");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("B")) {
            return 1; 
        }
        return 0;
    }

    public static int getAnswer3(Scanner scanner, String question3) {
        System.out.println(question3 + "\nPlease enter A, B, C, or D");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("C")) {
            return 1;
        }
        return 0; 
    }

    public static int getAnswer4(Scanner scanner, String question4) {
        System.out.println(question4 + "\nPlease enter A, B, C, or D");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("D")) {
            return 1;
        }
        return 0;
    }

    public static int getAnswer5(Scanner scanner, String question5) {
        System.out.println(question5 + "\nPlease enter A, B, C, or D");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("D")) {
            return 1; 
        }
        return 0; 
    }

    public static void score_to_percentage(int score) {
        double final_score = (score / 5) * 100;
        System.out.println(final_score);
    }

}
