package com.example.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> {
    Context context;
    ArrayList<String> data; //Adapter는 데이터와 연결의 역할

    // Context와 데이터를 MainActivity에서 가져와야 함
    MyListAdapter(Context context, ArrayList<String> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {// data를 보여주려는데 뷰홀더가 없으니까 여기서 inflate하는 작업
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, null);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyListViewHolder holder, int position) {// 여기서 data값 넣어서 setting해주는 역할
        //position은 ArrayList의 인덱스 순서 의미
        holder.tv.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvTitle);
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            tv.setText("Clicked - "+tv.getText().toString());
        }
    }

}