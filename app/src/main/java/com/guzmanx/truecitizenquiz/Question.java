package com.guzmanx.truecitizenquiz;

// Constructed our Question, which is the model part of our MVC Architecture
// blue print of a question displayed in our MainActivity (our view)
public class Question {
    // reference variables representing a question
    // represents each answer id being retrieved in this app inside our strings.xml resource
    private int answerResId;
    // represents answer being true or false
    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
