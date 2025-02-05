import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0; // To track the number of correct answers
        
        System.out.println("Welcome to the Java Quiz Game!\n");
        
        // Array to store questions
        String[][] questions = {
            {"What is the capital of France?", "A. Berlin", "B. Madrid", "C. Paris", "D. Rome", "C"},
            {"Which programming language is used for Android development?", "A. Python", "B. Java", "C. C++", "D. Swift", "B"},
            {"What is 5 + 3?", "A. 6", "B. 8", "C. 9", "D. 10", "B"},
            {"Which data type is used to store true or false values in Java?", "A. int", "B. boolean", "C. char", "D. float", "B"},
            {"What does HTML stand for?", "A. Hyper Transfer Markup Language", "B. High Tech Modern Language", "C. Hyper Text Markup Language", "D. Home Tool Markup Language", "C"}
        };
        
        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            for (int j = 1; j <= 4; j++) {
                System.out.println(questions[i][j]);
            }
            
            System.out.print("Enter your answer (A, B, C, or D): ");
            String answer = scanner.next().toUpperCase();
            
            // Input validation
            while (!answer.matches("[ABCD]") ) {
                System.out.print("Invalid input. Please enter A, B, C, or D: ");
                answer = scanner.next().toUpperCase();
            }
            
            // Check the answer
            if (answer.equals(questions[i][5])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + questions[i][5] + "\n");
            }
        }
        
        // Calculate the final score
        double percentage = ((double) score / questions.length) * 100;
        System.out.println("Quiz Over!\nYour final score: " + score + "/" + questions.length);
        System.out.printf("Your score percentage: %.2f%%\n", percentage);
        
        scanner.close();
    }
}
