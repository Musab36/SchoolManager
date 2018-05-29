package com.salajim.musab.schoolmanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.schoolmanager.R;
import com.salajim.musab.schoolmanager.models.Attendance;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AttendanceRecordsAdapter extends RecyclerView.Adapter<AttendanceRecordsAdapter.MyViewHolder>{
    private Context mContext;
    private List<Attendance> attRecords;

    public AttendanceRecordsAdapter(Context mContext, List<Attendance> attRecords) {
        this.mContext = mContext;
        this.attRecords = attRecords;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_record, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Attendance attendanceRecords = attRecords.get(position);


        holder.nameTextview.setText("Name:" + attendanceRecords.getName());
        holder.statusTextview.setText("Status: " + attendanceRecords.getStatus());
        holder.dateTextview.setText("Date: " + attendanceRecords.getDate());
        holder.dayTextview.setText("Day: " + attendanceRecords.getDay());

    }

    @Override
    public int getItemCount() {
        return attRecords.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView nameTextview;
        @Bind(R.id.status) TextView statusTextview;
        @Bind(R.id.date) TextView dateTextview;

        @Bind(R.id.day) TextView dayTextview;

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();


        }
    }
}