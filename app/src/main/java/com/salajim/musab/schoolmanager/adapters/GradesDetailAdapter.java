package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.models.Grades;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GradesDetailAdapter extends RecyclerView.Adapter<GradesDetailAdapter.MyViewHolder>{
    private Context mContext;
    private List<Grades> grades;

    public GradesDetailAdapter(Context mContext, List<Grades> grades) {
        this.mContext = mContext;
        this.grades = grades;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grades_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YoYo.with(Techniques.Wave).playOn(holder.cardView);//RecyclerView animations
        final Grades grade = grades.get(position);

        holder.mSubject.setText("Subject: " + grade.getSubject());
        holder.mScore.setText("Score: " + grade.getScore());
        holder.mMaxScore.setText("Max Score: " + grade.getMaxScore());
        holder.mPercentage.setText("Percentage: " + grade.getPercent());
    }

    @Override
    public int getItemCount() {
        if (grades == null)
            return 0;
        else
            return  grades.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.subject)
        TextView mSubject;
        @Bind(R.id.score) TextView mScore;
        @Bind(R.id.maxScore) TextView mMaxScore;
        @Bind(R.id.percentage) TextView mPercentage;
        @Bind(R.id.myCard)
        CardView cardView;

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();


        }
    }
}