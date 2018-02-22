package com.example.specter.sampleapi3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by specter on 2/20/18.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.jsonViewHolder> {

    private List<AppEvent> data;

    public NewAdapter(List<AppEvent> data, Index index)
    {
        this.data = data;

    }

    @Override
    public NewAdapter.jsonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.event_item, parent, false);
        return new jsonViewHolder(view);

    }

    @Override
    public void onBindViewHolder(jsonViewHolder holder, int position)
    {
        AppEvent event = data.get(position);
        holder.id.setText(String.valueOf(event.getId()));
        holder.name.setText(event.getName());
        holder.venue.setText(event.getAddressLine1());
        holder.amt.setText(event.getIsPaid().toString());
        holder.time.setText(event.getStartDatetime());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class jsonViewHolder extends RecyclerView.ViewHolder
    {
        TextView id;
        TextView name;
        TextView venue;
        TextView amt;
        TextView time;
        public jsonViewHolder(View itemView)
        {
                super(itemView);
                id= (TextView) itemView.findViewById(R.id.id);
                name= (TextView) itemView.findViewById(R.id.name);
                venue= (TextView) itemView.findViewById(R.id.venue);
                amt= (TextView) itemView.findViewById(R.id.amt);
                time= (TextView) itemView.findViewById(R.id.time);

        }
    }
}
