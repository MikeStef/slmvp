package com.micste.slmvp.info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.micste.slmvp.R;
import com.micste.slmvp.netcom.model.Transport;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {

    private Context context;
    private List<Transport> data;

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView info;

        MyViewHolder(View view) {
            super(view);
            info = view.findViewById(R.id.tv_info);
        }
    }

    public InfoAdapter(Context context, List<Transport> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Transport transport = data.get(position);

        if (transport.getGroupOfLine() == null) {
            transport.setGroupOfLine("");
        }
        holder.info.setText(context.getString(R.string.formatted_departure, transport.getDisplayTime(),
                transport.getGroupOfLine(), transport.getLineNumber(), transport.getDestination()));

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