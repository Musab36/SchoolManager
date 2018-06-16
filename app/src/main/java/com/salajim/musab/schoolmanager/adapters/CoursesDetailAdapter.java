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
import com.salajim.musab.schoolmanager.models.Courses;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoursesDetailAdapter extends RecyclerView.Adapter<CoursesDetailAdapter.MyViewHolder>{
    private Context mContext;
    private List<Courses> courses;

    public CoursesDetailAdapter(Context mContext, List<Courses> courses) {
        this.mContext = mContext;
        this.courses = courses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YoYo.with(Techniques.Swing).playOn(holder.cardView);//RecyclerView animations
        final Courses course = courses.get(position);

            holder.subject.setText(course.getSubject());
            holder.type.setText("Type: " + course.getType());
            holder.teacher.setText("Teacher: " + course.getTeacher());
        }

    @Override
    public int getItemCount() {
        if (courses == null)
            return 0;
        else
            return  courses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //@Bind(R.id.name) TextView mName;
       @Bind(R.id.subject)
        TextView subject;
       @Bind(R.id.type) TextView type;
       @Bind(R.id.teacher) TextView teacher;
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