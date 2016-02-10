package com.publicmethod.eric.sharedpreferencescourse.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.publicmethod.eric.sharedpreferencescourse.R;

/**
 * Created by Owner on 2016-02-10.
 */
public class ScoreCardAdapter extends RecyclerView.Adapter<ScoreCardAdapter.ScoreViewHolder> {

    private int mNumberOfHolesOnCourse;

    public ScoreCardAdapter(int numberOfHolesOnCourse) {
        mNumberOfHolesOnCourse = numberOfHolesOnCourse;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mNumberOfHolesOnCourse;
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder {

        public TextView mHoleNumber;
        public TextView mScoreEditText;
        public Button mMinusButton;
        public Button mAddButton;

        public ScoreViewHolder(View itemView) {
            super(itemView);

            mHoleNumber = (TextView) itemView.findViewById(R.id.textView_hole_number);
            mScoreEditText = (TextView) itemView.findViewById(R.id.textView_score);
            mMinusButton = (Button) itemView.findViewById(R.id.button_minus);
            mAddButton = (Button) itemView.findViewById(R.id.button_add);
        }

        public void bindHoles(int numberOfHoles) {
            String holes = "Hole " + Integer.toString(numberOfHoles) + ":";

            mHoleNumber.setText(holes);
        }
    }


}
