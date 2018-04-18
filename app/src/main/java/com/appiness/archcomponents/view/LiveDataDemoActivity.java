package com.appiness.archcomponents.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.appiness.archcomponents.R;
import com.appiness.archcomponents.viewmodel.LiveDataTimerViewModel;
import com.appiness.archcomponents.viewmodel.MyObserver;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveDataDemoActivity extends AppCompatActivity {

    private static final String LOG_TAG = LiveDataDemoActivity.class.getSimpleName();

    private LiveDataTimerViewModel liveDataTimerViewModel;

    private final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
        @Override
        public void onChanged(@Nullable final Long newValue) {
            String newText = LiveDataDemoActivity.this.getResources().getString(R.string.seconds, newValue);
            displayTimerValue(newText);
            Log.e(LOG_TAG, "Updating timer");
        }
    };

    @BindView(R.id.timer_value_text)
    protected TextView timerValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata_demo);
        ButterKnife.bind(this);

        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribeElapsedTimeObserver();

        getLifecycle().addObserver(new MyObserver());
    }

    private void subscribeElapsedTimeObserver() {
        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }

    private void displayTimerValue(String value) {
        timerValueText.setText(String.valueOf(value));
    }
}
