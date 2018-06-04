package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.models.Schedule;

import java.util.List;

public class StudentListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Schedule> schedules;

    public StudentListAdapter(Context mContext, List<Schedule> schedules) {
        this.mContext = mContext;
        this.schedules = schedules;
    }

    @Override
    public int getCount() {
        return schedules.size();
    }

    @Override
    public Object getItem(int position) {
        return schedules.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_table, parent, false);
        final Schedule schedule = schedules.get(position);

        TextView subject = (TextView) v.findViewById(R.id.subject);
        TextView teacher = (TextView) v.findViewById(R.id.teacher);
        TextView clas = (TextView) v.findViewById(R.id.clas);
        TextView time = (TextView) v.findViewById(R.id.time);
        TextView term = (TextView) v.findViewById(R.id.term);
        CardView cardView = (CardView) v.findViewById(R.id.cardView);

            subject.setText(schedule.getSubject());
            teacher.setText("Teacher: " + schedule.getTeacher());
            time.setText("Time: " + schedule.getStart_time() + " - " + schedule.getEnd_time());
            term.setText("Term: " + schedule.getTerm());
            clas.setText("Class: " + schedule.getClas());

        return v;
    }
}
