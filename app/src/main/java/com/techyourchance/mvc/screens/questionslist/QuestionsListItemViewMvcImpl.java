package com.techyourchance.mvc.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemViewMvcImpl implements QuestionsListItemViewMvc {

    private final View mRootView;
    private final TextView mTxtTitle;

    private Question mQuestion;

    private final List<Listener> mListeners = new ArrayList<>();

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_question_list_item, parent, false);
        mTxtTitle = mRootView.findViewById(R.id.txt_title);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : mListeners) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        mTxtTitle.setText(question.getTitle());
    }

}
