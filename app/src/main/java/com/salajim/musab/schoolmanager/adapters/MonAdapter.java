package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.models.Schedule;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MonAdapter extends RecyclerView.Adapter<MonAdapter.MyViewHolder>{
    private Context mContext;
    private List<Schedule> schedules;

    public MonAdapter(Context mContext, List<Schedule> schedules) {
        this.mContext = mContext;
        this.schedules = schedules;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_table, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Schedule schedule = schedules.get(position);

        if(schedule.getDay().contains("Monday")) {
            holder.mSubject.setText(schedule.getSubject());
            holder.mTeacher.setText("Teacher: " + schedule.getTeacher());
            holder.mTime.setText("Time: " + schedule.getStart_time() + " - " + schedule.getEnd_time());
            holder.mTerm.setText("Term: " + schedule.getTerm());
            holder.mClass.setText("Class: " + schedule.getClas());
        } else {
            holder.cardView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return schedules == null ? 0 : schedules.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.subject) TextView mSubject;
        @Bind(R.id.teacher) TextView mTeacher;
        @Bind(R.id.time) TextView mTime;
        @Bind(R.id.cardView) CardView cardView;
        @Bind(R.id.term) TextView mTerm;
        @Bind(R.id.clas) TextView mClass;

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }
    }
}