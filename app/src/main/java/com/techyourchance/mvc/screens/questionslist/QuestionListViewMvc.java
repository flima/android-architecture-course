package com.techyourchance.mvc.screens.questionslist;

import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.ObservableViewMvc;

interface QuestionListViewMvc extends ObservableViewMvc<QuestionListViewMvc.Listener> {

    interface Listener {
        void onQuestionClicked(Question question);
    }

    void onQuestionClicked(Question question);

}
