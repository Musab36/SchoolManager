package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.models.StudentsList;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AttendenceStudentListAdapter extends RecyclerView.Adapter<AttendenceStudentListAdapter.MyViewHolder>{
    private Context mConext;
    private List<StudentsList> studentsLists;

    public AttendenceStudentListAdapter(Context mConext, List<StudentsList> studentsLists) {
        this.mConext = mConext;
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
        final StudentsList studentsList = studentsLists.get(position);

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

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mConext = itemView.getContext();
        }
    }
}
