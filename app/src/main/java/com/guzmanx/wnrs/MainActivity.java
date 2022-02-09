package com.guzmanx.wnrs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

// After adding onClick(), now MainActivity class implements View.OnClickListener interface because
// we want to use the interface's onClick() behavior in our MainActivity class
// In Java, it doesn't allow multiple inheritance, so we use interface to bypass this limitation
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // reference button and text widgets
    private Button levelButton;
    private ImageButton nextButton;
    private ImageButton previousButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;

    // Array contains instantiated objects of model Question class, initialized with string
    // resources and the correct answer associated
    private Question[] questionBank = new Question[] {
        new Question(R.string.lvl_1_perception_q1, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q2, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q3, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q4, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q5, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q6, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q7, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q8, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q9, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q10, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q11, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_1_perception_q12, QuestionType.LEVEL1_PERCEPTION),
        new Question(R.string.lvl_2_connection_q1, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q2, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q3, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q4, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q5, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q6, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q7, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q8, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q9, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q10, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q11, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q12, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q13, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_2_connection_q14, QuestionType.LEVEL2_CONNECTION),
        new Question(R.string.lvl_3_reflection_q1, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q2, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q3, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q4, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q5, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q6, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q7, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q8, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q9, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q10, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q11, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q12, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q13, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q14, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q15, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q16, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q17, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q18, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q19, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q20, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.lvl_3_reflection_q21, QuestionType.LEVEL3_REFLECTION),
        new Question(R.string.final_card_q1, QuestionType.FINAL)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);

        setContentView(R.layout.activity_main);

        // Connect to button and text ids
        levelButton = findViewById(R.id.level_button);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.prev_button);
        questionTextView = findViewById(R.id.answer_text_view);

        // Two ways to attach on click listener to buttons
        // Approach 1 (Not Used): simplistic come to activity_main.xml buttons and add on click
        // Approach 2 (Used): more robust way in code call buttons setOnClickListener()
        // register our buttons to View.OnClickListener, so they can be listened in onClick()
        levelButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    // Override onClick() from View.OnClickListener, so we listen to clicks on false and true button
    @Override
    public void onClick(View v) {
        // Check view to see which button id was clicked (falseButton or trueButton)
        switch(v.getId()) {
            // Create toast message for button clicked
            case R.id.level_button:
                checkQuestionLevel();
                break;
            case R.id.next_button:
                // go to next question, make sure once counter gets to end of length, go back to 0
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.prev_button:
                // go to prior question, make sure once dec count gets to first question, then stop
                if(currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
        }
    }

    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        // Make sure we are within bounds of our question bank
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkQuestionLevel() {
        // Get actual type from question bank at current question index
        QuestionType questionLevel = questionBank[currentQuestionIndex].questionLevelIs();
        int toastMessageId = 0;

        // check whatever the question level type is from question bank
        if(questionLevel == QuestionType.LEVEL1_PERCEPTION) {
            // toast message id will point to correct answer
            toastMessageId = R.string.level_1_perception;
        } else if(questionLevel == QuestionType.LEVEL2_CONNECTION) {
            toastMessageId = R.string.level_2_connection;
        } else if(questionLevel == QuestionType.LEVEL3_REFLECTION) {
            toastMessageId = R.string.level_3_reflection;
        } else {
            toastMessageId = R.string.final_card;
        }

        // Create a toast message displaying question level type based on question
        Toast.makeText(MainActivity.this, toastMessageId,
                Toast.LENGTH_SHORT)
                .show();

    }
}
