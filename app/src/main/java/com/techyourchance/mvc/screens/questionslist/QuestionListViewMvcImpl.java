package com.techyourchance.mvc.screens.questionslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseObservableViewMvc;

import java.util.List;

public class QuestionListViewMvcImpl extends BaseObservableViewMvc<QuestionListViewMvc.Listener> implements QuestionListViewMvc,
        QuestionsListAdapter.OnQuestionClickListener {

    private ListView mLstQuestions;
    private QuestionsListAdapter mQuestionsListAdapter;

    public QuestionListViewMvcImpl(LayoutInflater inflater, ViewGroup viewGroup) {
        mRootView = inflater.inflate(R.layout.layout_questions_list, viewGroup, false);

        mLstQuestions = findViewById(R.id.lst_questions);
        mQuestionsListAdapter = new QuestionsListAdapter(getContext(), this);
        mLstQuestions.setAdapter(mQuestionsListAdapter);
    }

    public void bindQuestions(List<Question> questions) {
        mQuestionsListAdapter.clear();
        mQuestionsListAdapter.addAll(questions);
        mQuestionsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
        }
    }

}
