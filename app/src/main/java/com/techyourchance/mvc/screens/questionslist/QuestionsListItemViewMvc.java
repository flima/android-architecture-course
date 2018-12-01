package com.techyourchance.mvc.screens.questionslist;

import android.view.View;

import com.techyourchance.mvc.questions.Question;

public interface QuestionsListItemViewMvc {

    interface Listener {
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    View getRootView();

    void bindQuestion(Question question);

}
