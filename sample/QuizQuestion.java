package sample;

public class QuizQuestion {

    private String answer;

    public QuizQuestion(String a)
    /* each question and option is on the background image.
       Only the answer to each answer (i.e: A, B or C) is needed to compare with
       the button's title and determine the score.
    */
    {
        answer= a;
    }

    public String getAnswer ()
    {
        return answer;
    }
}
