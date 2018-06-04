package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.salajim.musab.schoolmanager.activities.AssignmentsDetailActivity;
import com.salajim.musab.schoolmanager.models.Students;

import org.parceler.Parcels;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.MyViewHolder>{
    private Context mContext;
    private List<Students> studentsLists;


    public AssignmentsAdapter(Context mContext, List<Students> studentsLists) {
        this.mContext = mContext;
        this.studentsLists = studentsLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YoYo.with(Techniques.FlipInX).playOn(holder.cardView);//RecyclerView animations
        final Students studentsList = studentsLists.get(position);

        holder.mName.setText(studentsList.getName());
        holder.mClass.setText("Class: " + studentsList.getClas());
        holder.mParent.setText("Parent: " + studentsList.getParent());

    }

    @Override
    public int getItemCount() {
        return studentsLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView mName;
        @Bind(R.id.parent) TextView mParent;
        @Bind({R.id.clas}) TextView mClass;
        @Bind(R.id.myCard)
        CardView cardView;

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, AssignmentsDetailActivity.class);
                    intent.putExtra("position", itemPosition);
                    intent.putExtra("studentsLists", Parcels.wrap(studentsLists) );
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}