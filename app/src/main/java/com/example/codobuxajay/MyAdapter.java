package com.example.codobuxajay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {

    Context context;
    GetClick getClick;
    List<PojoData.Datum> list;

    public MyAdapter(Context context, List<PojoData.Datum> list,GetClick getClick) {
        this.context=context;
        this.getClick=getClick;
        this.list=list;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myadapter, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, final int position) {

        holder.eName.setText(list.get(position).getEmployeeName());
        holder.eSalary.setText(""+list.get(position).getEmployeeSalary());
        holder.eAge.setText(""+list.get(position).getEmployeeAge());
        holder.eId.setText(""+list.get(position).getId());
        Glide.with(context).load(list.get(position).getProfileImage()).into(holder.imageView);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getClick.itemClick(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyView extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView eId;
        TextView eName, eSalary;
        TextView eAge;
        RelativeLayout relativeLayout;
        public MyView(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profilePic);
            eId = itemView.findViewById(R.id.eId);
            eAge = itemView.findViewById(R.id.eAge);
            eName = itemView.findViewById(R.id.eName);
            eSalary = itemView.findViewById(R.id.eSalary);
            relativeLayout=itemView.findViewById(R.id.relative);
        }
    }
    public interface GetClick{
        public void itemClick(int position);
    }
}
