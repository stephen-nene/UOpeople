import textio.TextIO;

public class Quime {

    // Class representing a quiz question
    static class Question {
        String text;
        String[] options;
        String correctAnswer;

        // Constructor for initializing a question
        Question(String text, String[] options, String correctAnswer) {
            this.text = text;
            this.options = options;
            this.correctAnswer = correctAnswer.toUpperCase();
        }
    }

    // Main method to execute the quiz game
    public static void main(String[] args) {
        
        // Get the player's name
        System.out.println("Please enter your name💾 oh great wizard.🧙🏽‍♂️");
        String name = TextIO.getln();

        // Check if the name is empty and exit if true
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Exiting the game.");
            System.exit(0);
        }

        // Welcome message
        System.out.println("Hello and welcome to 🔮Quime🎲  game, " + name + "!");
        System.out.println("Let's start quizzing.❓❔⁉️");

        int score = 0; // Track the number of correct answers

        // Array of quiz questions
        Question[] questions = {
                new Question(
                        "What does JVM stand for?",
                        new String[] { "A: Java Virtual Machine", "B: Java Visual Machine", "C: Java Virtual Method",
                                "D: Java Visual Method" },
                        "A"),
                new Question(
                        "Which keyword is used for inheritance in Java?",
                        new String[] { "A: inherit", "B: extends", "C: inheritFrom", "D: extendsFrom" },
                        "B"),
                new Question(
                        "What is the output of 'System.out.println(5 / 2)' in Java?",
                        new String[] { "A: 2", "B: 2.5", "C: 2.0", "D: 2.5 (int)" },
                        "C"),
                new Question(
                        "What is the purpose of the 'break' statement in a switch statement?",
                        new String[] { "A: Exit the loop", "B: Skip to the next case", "C: End the program",
                                "D: Skip to the default case" },
                        "A"),
                new Question(
                        "Which collection class allows null values in Java?",
                        new String[] { "A: ArrayList", "B: HashSet", "C: TreeMap", "D: LinkedList" },
                        "B"),
                // Add other questions similarly
        };

        // Loop through each question and gather user input
        for (Question question : questions) {
            System.out.println();
            System.out.println(question.text);

            // Display answer options
            for (String option : question.options) {
                System.out.println(option);
            }

            // Get and validate user answer
            String userAnswer;
            do {
                System.out.println("Select an option:");
                userAnswer = TextIO.getln().toUpperCase();
                if (!userAnswer.matches("[A-D]")) {
                    System.out.println("Invalid choice. Please choose A, B, C, or D.");
                }
            } while (!userAnswer.matches("[A-D]"));

            // Check if the user's answer is correct and update the score
            if (userAnswer.equals(question.correctAnswer)) {
                score++;
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Incorrect! Correct answer is " + question.correctAnswer);
            }
        }

        // Display final score
        System.out.println("\nThank you for playing, " + name + "!");
        System.out.println("Scored " + score + " Out of " + questions.length + " ! 😃");
        System.out.println("Your final score: " + ((double) score / questions.length) * 100 + " % 🎉");
    }
}
