package com.guzmanx.wnrs;

// Constructed our Question, which is the model part of our MVC Architecture
// blue print of a question displayed in our MainActivity (our view)
enum QuestionType {
    LEVEL1_PERCEPTION,
    LEVEL2_CONNECTION,
    LEVEL3_REFLECTION,
    FINAL
};

public class Question {
    // reference variables representing a question
    // represents each answer id being retrieved in this app inside our strings.xml resource
    private int answerResId;
    // represents answer being true or false
    private QuestionType questionType;

    public Question(int answerResId, QuestionType questionType) {
        this.answerResId = answerResId;
        this.questionType = questionType;
    }


    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public QuestionType questionLevelIs() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

//    public boolean isAnswerTrue() {
//        return answerTrue;
//    }

//    public void setAnswerTrue(boolean answerTrue) {
//        this.answerTrue = answerTrue;
//    }
}
