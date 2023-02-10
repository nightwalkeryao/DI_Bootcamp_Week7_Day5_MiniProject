import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Quiz game - the player has to answer a list of 10 questions from q1 to qf.
 * Each correct answer counts for 1 point.
 */
public class Quiz {
    private int score;
    private List<Question> questions = new ArrayList<Question>();

    public Quiz(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Add a new question to the quiz game questions list
     * @param q Question object
     * @return Quiz the current quiz object
     */
    public Quiz addQuestion(Question q) {
        this.questions.add(q);
        return this;
    }

    /**
     * Store a user answer for a question by updating Question's answer attribute
     * @param questionIndex int Index of answered question
     * @param answer char user input answer
     */
    public void addAnswer(int questionIndex, char answer) {
        Question q = this.questions.get(questionIndex);
        q.setAnswer(answer);
        this.questions.set(questionIndex, q);
    }

    public static void main(String[] args) {
        // create quiz and set its questions list
        Quiz quiz = new Quiz(0);
        String q1 = """
                What is hardware?
                (a)virtual machine
                (b)the physical machine
                (c)applications such as browsers
                (d)part of the processor
                """;

        String q2 = """
                What does counter++; do?
                (a)Adds 1 to counter
                (b)Adds 2 to counter
                (c)Gets the sum
                (d)Multiplies the numbers
                """;

        String q3 = """
                What is a loop that never stops?
                (a)For Loop
                (b)Infinite Loop
                (c)Do-While Loop
                (d)Full Loop
                """;

        String q4 = """
                In a while loop, if the boolean expression is true, what will the loop do?
                (a)Break
                (b)Program will exit
                (c)Repeat
                (d)Continue through program
                """;

        String q5 = """
                What special value is designated for controlling a loop?
                (a)Control value
                (b)Mutator Method
                (c)Accessor Method
                (d)Sentinel Value
                """;

        String q6 = """
                What is a method?
                (a)A collection of statements grouped together to perform an operation
                (b)A value returned from a method using the return statement
                (c)The portion of the program where the variable can be accessed.
                (d)The combination of the name of a method and the list of its parameters
                """;

        String q7 = """
                What is an object?
                (a)Representation of an entity in the real world that can be distinctly identified
                (b)A static method can be called without creating an instance of the class
                (c)Instance variable/instance method
                (d)A template, blueprint or contract that defines what an object's data fields and methods will be.
                """;

        String q8 = """
                What is an array?
                (a)Numbers of items ArrayList can store without increasing its size
                (b)Number used as an index to pinpoint a specific element within an array
                (c)Object that can store a group of values, all of the same type
                (d)Method of locating a specific item in a larger collection of data
                """;

        String q9 = """
                You use this statement to throw an exception manually.
                (a)Throw
                (b)call stack
                (c)try block
                (d)thrown
                """;

        String qF = """
                When an exception is generated, it is said to have been what?
                (a)Created
                (b)Called
                (c)Thrown
                (d)Generated
                """;

        quiz.addQuestion(new Question(q1, 'b'))
                .addQuestion(new Question(q2, 'a'))
                .addQuestion(new Question(q3, 'b'))
                .addQuestion(new Question(q4, 'c'))
                .addQuestion(new Question(q5, 'a'))
                .addQuestion(new Question(q6, 'a'))
                .addQuestion(new Question(q7, 'a'))
                .addQuestion(new Question(q8, 'c'))
                .addQuestion(new Question(q9, 'a'))
                .addQuestion(new Question(qF, 'c'));

        // Prompt user to answer each question from the questions list
        Scanner sc = new Scanner(System.in);
        quiz.getQuestions().forEach(q -> {
            System.out.println(q.getPrompt());
            int qIndex = quiz.getQuestions().indexOf(q);
            char answer = sc.nextLine().toLowerCase().charAt(0);
            quiz.addAnswer(qIndex, answer);
            // +1 point to quiz score for a correct answer
            if(answer == q.getCorrectAnswer()) {
                quiz.setScore(quiz.getScore()+1);
            }
        });
        // Display the final score
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Your final score: " + quiz.getScore());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        sc.close();
    }
}
