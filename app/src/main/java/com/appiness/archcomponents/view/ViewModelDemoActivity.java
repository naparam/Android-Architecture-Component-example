package com.appiness.archcomponents.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.appiness.archcomponents.R;
import com.appiness.archcomponents.viewmodel.ClickCounterViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewModelDemoActivity extends AppCompatActivity {

    @BindView(R.id.click_count_text)
    protected TextView clickCountText;

    private ClickCounterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel_demo);
        ButterKnife.bind(this);

        //get view model constructed
        viewModel = ViewModelProviders.of(this).get(ClickCounterViewModel.class);
        displayClickCount(viewModel.getCount());
    }

    @OnClick(R.id.increment_button)
    public void incrementClickCount(View button) {
        viewModel.setCount(viewModel.getCount() + 1);
        displayClickCount(viewModel.getCount());
    }

    private void displayClickCount(int clickCount) {
        clickCountText.setText(String.valueOf(clickCount));
    }
}
