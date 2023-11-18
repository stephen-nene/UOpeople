// import textio.TextIO;

// public class Quime {

//     public static void main(String[] args) {

//         System.out.println("Please enter your name");
//         String name = TextIO.getln();

//         if (name.trim().isEmpty()) {
//             System.out.println("Name cannot be empty. Exiting the game.");
//             System.exit(0);
//         }

//         System.out.println("Hello and welcome to Quime quiz game, " + name + "!");
//         System.out.println("Lets start quizing, ");

//         int score = 0; // Track the number of correct answers

//                 // Question 1
//         System.out.println("Question 1");
//         System.out.println("Select an option:");
//         System.out.println("A:");
//         System.out.println("B:");
//         System.out.println("C:");
//         System.out.println("D:");
//         String ansa1 = TextIO.getln();

//         System.out.println("Question 2");
//         System.out.println("Select an option:");
//         System.out.println("A:");
//         System.out.println("B:");
//         System.out.println("C:");
//         System.out.println("D:");
//         String ansa2 = TextIO.getln();

//         System.out.println("Question 3");
//         System.out.println("Select an option:");
//         System.out.println("A:");
//         System.out.println("B:");
//         System.out.println("C:");
//         System.out.println("D:");
//         String ansa3 = TextIO.getln();

//         System.out.println("Question 4");
//         System.out.println("Select an option:");
//         System.out.println("A:");
//         System.out.println("B:");
//         System.out.println("C:");
//         System.out.println("D:");
//         String ansa4 = TextIO.getln();

//         System.out.println("Question 5");
//         System.out.println("Select an option:");
//         System.out.println("A:");
//         System.out.println("B:");
//         System.out.println("C:");
//         System.out.println("D:");
//         String ansa5 = TextIO.getln();

//     }
// }

import textio.TextIO;

public class Quime {

    static class Question {
        String text;
        String[] options;
        String correctAnswer;

        Question(String text, String[] options, String correctAnswer) {
            this.text = text;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {

        System.out.println("Please enter your name");
        String name = TextIO.getln();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Exiting the game.");
            System.exit(0);
        }

        System.out.println("Hello and welcome to Quime quiz game, " + name + "!");
        System.out.println("Let's start quizzing.");

        int score = 0; // Track the number of correct answers

        Question[] questions = {
                new Question(
                        "What is the primary purpose of the \"public static void main(String[] args)\" method in a Java program?",
                        new String[] { "A: Define variables", "B: Execute the program", "C: Declare methods",
                                "D: Import libraries" },
                        "B"),
                new Question(
                        "What is the primary purpose of the \"public static void main(String[] args)\" method in a Java program?",
                        new String[] { "A: Define variables", "B: Execute the program", "C: Declare methods",
                                "D: Import libraries" },
                        "B"),
                new Question(
                        "What is the primary purpose of the \"public static void main(String[] args)\" method in a Java program?",
                        new String[] { "A: Define variables", "B: Execute the program", "C: Declare methods",
                                "D: Import libraries" },
                        "B"),
                new Question(
                        "What is the primary purpose of the \"public static void main(String[] args)\" method in a Java program?",
                        new String[] { "A: Define variables", "B: Execute the program", "C: Declare methods",
                                "D: Import libraries" },
                        "B"),
                // Add other questions similarly
        };

        for (Question question : questions) {
            System.out.println();
            System.out.println(question.text);
            for (String option : question.options) {
                System.out.println(option);
            }

            String userAnswer;
            do {
                System.out.println("Select an option:");
                userAnswer = TextIO.getln().toUpperCase();
                if (!userAnswer.matches("[A-D]")) {
                    System.out.println("Invalid choice. Please choose A, B, C, or D.");
                }
            } while (!userAnswer.matches("[A-D]"));

            if (userAnswer.equals(question.correctAnswer)) {
                score++;
            }
        }

        // Display final score
        System.out.println("\nThank you for playing, " + name + "!");
        System.out.println("Your final score: " + (score/questions.length)*100 + "% out of " + questions.length + "questions.");
    }
}
