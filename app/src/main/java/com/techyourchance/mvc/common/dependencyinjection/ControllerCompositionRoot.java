package com.techyourchance.mvc.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.techyourchance.mvc.networking.StackOverFlowApi;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final Activity mActivity;
    private final CompositionRoot mCompositionRoot;

    public ControllerCompositionRoot(Activity activity, CompositionRoot compositionRoot) {
        mActivity = activity;
        this.mCompositionRoot = compositionRoot;
    }

    public StackOverFlowApi getStackOverFlowApi() {
        return mCompositionRoot.getStackOverFlowApi();
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(LayoutInflater.from(mActivity));
    }

}
