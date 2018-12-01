package com.techyourchance.mvc.screens.common;

import android.content.Context;
import android.view.View;

public class BaseViewMvc implements ViewMvc {

    protected View mRootView;

    protected  <T extends View> T findViewById(int id) {
        return mRootView.findViewById(id);
    }

    protected Context getContext() {
        return mRootView.getContext();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

}
