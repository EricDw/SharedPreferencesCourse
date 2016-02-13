package com.publicmethod.eric.sharedpreferencescourse.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.publicmethod.eric.sharedpreferencescourse.R;
import com.publicmethod.eric.sharedpreferencescourse.models.Hole;

/**
 * Created by Owner on 2016-02-10.
 */
public class ScoreCardAdapter extends RecyclerView.Adapter<ScoreCardAdapter.ScoreViewHolder> {

    private final Hole[] mHoles;

    public ScoreCardAdapter(Hole[] holes) {
        mHoles = holes;
    }


    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout_golf, parent, false);

        ScoreViewHolder scoreViewHolder = new ScoreViewHolder(view);

        return scoreViewHolder;
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {

        holder.bindHoles(mHoles[position]);

    }

    @Override
    public int getItemCount() {
        return mHoles.length;
    }


    public class ScoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTextViewHoleLabel;
        public TextView mTextViewScore;
        public Button mButtonMinus;
        public Button mButtonAdd;


        public ScoreViewHolder(View itemView) {
            super(itemView);

            mTextViewHoleLabel = (TextView) itemView.findViewById(R.id.textView_hole_label);
            mTextViewScore = (TextView) itemView.findViewById(R.id.textView_score);
            mButtonMinus = (Button) itemView.findViewById(R.id.button_minus);
            mButtonAdd = (Button) itemView.findViewById(R.id.button_add);

            mButtonMinus.setOnClickListener(this);
            mButtonAdd.setOnClickListener(this);

        }

        public void bindHoles(Hole hole) {

            mTextViewHoleLabel.setText(hole.getHoleLabel());
            mTextViewScore.setText(String.valueOf(hole.getStrokeCount()));

        }

        @Override
        public void onClick(View v) {

            int updatedStrokeCount = mHoles[getAdapterPosition()].getStrokeCount();

            if (v.getId() == mButtonMinus.getId()) {

                updatedStrokeCount--;
                if (updatedStrokeCount < 0) updatedStrokeCount = 0;
                mHoles[getAdapterPosition()].setStrokeCount(updatedStrokeCount);
                notifyDataSetChanged();

            }else {
                updatedStrokeCount++;
                mHoles[getAdapterPosition()].setStrokeCount(updatedStrokeCount);
                notifyDataSetChanged();
            }


        }
    }


}
