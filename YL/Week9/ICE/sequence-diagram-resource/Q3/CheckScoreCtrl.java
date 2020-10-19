public class CheckScoreCtrl {
    private QuizDAO quizDAO;

    public CheckScoreCtrl() {
        quizDAO = new QuizDAO();
    }

    public double calculateDifferenceFromAverage(String studentName, String quizName) {
        Quiz quiz = quizDAO.retrieve(quizName);
        if(quiz == null) throw new IllegalArgumentException("Invalid Quiz Name");

        double avgScore = quiz.getAverageScore();

        Student student = quiz.getStudent(studentName);
        if(student == null) throw new IllegalArgumentException("Invalid Student Name");

        int score = student.getScore();
        return score - avgScore;
    }
}
