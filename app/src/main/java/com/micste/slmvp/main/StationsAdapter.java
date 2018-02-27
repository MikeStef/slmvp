package com.micste.slmvp.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.micste.slmvp.R;
import com.micste.slmvp.info.InfoActivity;
import com.micste.slmvp.netcom.model.Station;

import java.util.List;

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.MyViewHolder> {

    private Context context;
    private List<Station> data;

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        LinearLayout linearLayout;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            linearLayout = view.findViewById(R.id.item_linear_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    goToInfoActivity(data.get(pos).getSiteId());
                }
            });
        }
    }

    public StationsAdapter(Context context, List<Station> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.station_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Station station = data.get(position);
        holder.name.setText(station.getName());
    }

    private void goToInfoActivity(String id) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra("ID", id);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
