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
import com.salajim.musab.schoolmanager.models.Assignments;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AssignmentsDetailAdapter extends RecyclerView.Adapter<AssignmentsDetailAdapter.MyViewHolder>{
    private Context mContext;
    private List<Assignments> assignments;

    public AssignmentsDetailAdapter(Context mContext, List<Assignments> assignments) {
        this.mContext = mContext;
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assigmnets_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YoYo.with(Techniques.Tada).playOn(holder.cardView);//RecyclerView animations
        final Assignments assignment = assignments.get(position);

        //holder.mName.setText("Name: " + assignment.getName());
        holder.mSubject.setText("Subject: " + assignment.getSubject());
        //holder.mClass.setText("Class: " + assignment.getmClass());
        holder.instructions.setText("Instructions: " + assignment.getInstructions());
        holder.mRemarks.setText("Remarks: " + assignment.getRemarks());
        holder.mScore.setText("Score: " + assignment.getRemarks());
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //@Bind(R.id.name) TextView mName;
        @Bind({R.id.subject}) TextView mSubject;
        @Bind(R.id.clas) TextView mClass;
        @Bind(R.id.remarks) TextView mRemarks;
        @Bind(R.id.score) TextView mScore;
        @Bind(R.id.instructions) TextView instructions;
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