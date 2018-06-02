package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.models.Discipline;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DisciplineDetailAdapter extends RecyclerView.Adapter<DisciplineDetailAdapter.MyViewHolder>{
    private Context mContext;
    private List<Discipline> disciplineList;

    public DisciplineDetailAdapter(Context mContext, List<Discipline> disciplineList) {
        this.mContext = mContext;
        this.disciplineList = disciplineList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discipline_records, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Discipline discipline = disciplineList.get(position);

        holder.offence.setText("Offence: " + discipline.getOffence());
        holder.punishment.setText("Punishments: " + discipline.getPunishment());
        holder.teacher.setText("Teacher: " + discipline.getTeacher());

        if (disciplineList == null) {
            Toast.makeText(mContext, "No records found", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return disciplineList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //@Bind(R.id.name) TextView mName;
       @Bind(R.id.offence)
        TextView offence;
       @Bind(R.id.punishment) TextView punishment;
       @Bind(R.id.teacher) TextView teacher;

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();


        }
    }
}