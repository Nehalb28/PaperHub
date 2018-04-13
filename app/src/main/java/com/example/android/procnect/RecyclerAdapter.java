package com.example.android.procnect;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {
    private final List<EntityList> mEntityList;

    public RecyclerAdapter(List<EntityList> mEntityList){
        super();
        this.mEntityList = mEntityList;
    }


    @Override
    public RecyclerAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIdForListItems = R.layout.activity_recycler_list_item;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutIdForListItems, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ListViewHolder holder, final int position) {
        final EntityList entityList1 = mEntityList.get(position);
        holder.listItemName.setText(entityList1.getName());
        holder.minGsm.setText(entityList1.getMingsm());
        holder.maxGsm.setText(entityList1.getMaxgsm());
        holder.location.setText(entityList1.getLocation());
        String leastPrice, st_pbf14, st_pbf16, st_pbf18;
        double i_pbf14 = 0;
        double i_pbf16 = 0;
        double i_pbf18 = 0;

        if (entityList1.getPbf14().length() != 0) {
            st_pbf14 = entityList1.getPbf14();
            i_pbf14 = Double.parseDouble(st_pbf14);
        }
        if (entityList1.getPbf16().length() != 0) {
            st_pbf16 = entityList1.getPbf16();
            i_pbf16 = Double.parseDouble(st_pbf16);
        }
        if (entityList1.getPbf18().length() != 0) {
            st_pbf18 = entityList1.getPbf18();
            i_pbf18 = Double.parseDouble(st_pbf18);
        }

        double smallest = 0;

        if (i_pbf14 <= i_pbf16 && i_pbf14 <= i_pbf18){
            smallest = i_pbf14;
        }
        else if (i_pbf16 < i_pbf14 && i_pbf16 <= i_pbf18){
            smallest = i_pbf16;
        }
        else if(i_pbf18 < i_pbf14 && i_pbf18 < i_pbf16){
            smallest = i_pbf18;
        }

        leastPrice = String.valueOf(smallest);
        holder.listItemPbf14.setText(leastPrice);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent businessSelectedIntent = new Intent(v.getContext(), BusinessSelectedActivity.class);
                businessSelectedIntent.putExtra("listItemName", entityList1.getName());
                businessSelectedIntent.putExtra("Email", entityList1.getEmail());
                businessSelectedIntent.putExtra("pbf14", entityList1.getPbf14());
                businessSelectedIntent.putExtra("pbf16", entityList1.getPbf16());
                businessSelectedIntent.putExtra("pbf18", entityList1.getPbf18());
                businessSelectedIntent.putExtra("pbf20", entityList1.getPbf20());
                businessSelectedIntent.putExtra("pbf22", entityList1.getPbf22());
                businessSelectedIntent.putExtra("pbf25", entityList1.getPbf25());
                businessSelectedIntent.putExtra("pbf28", entityList1.getPbf28());
                businessSelectedIntent.putExtra("pbf30", entityList1.getPbf30());
                businessSelectedIntent.putExtra("pbf32", entityList1.getPbf32());
                businessSelectedIntent.putExtra("pbf35", entityList1.getPbf35());
                businessSelectedIntent.putExtra("mingsm", entityList1.getMingsm());
                businessSelectedIntent.putExtra("maxgsm", entityList1.getMaxgsm());
                businessSelectedIntent.putExtra("insurance", entityList1.getInsurance());
                businessSelectedIntent.putExtra("payment_terms", entityList1.getPaymentTerms());
                v.getContext().startActivity(businessSelectedIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEntityList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        final TextView listItemName;
        final TextView location;
        final TextView listItemPbf14;
        final TextView minGsm;
        final TextView maxGsm;

        public ListViewHolder(View itemView) {
            super(itemView);
            listItemName = itemView.findViewById(R.id.tv_listitemname);
            location = itemView.findViewById(R.id.tv_location);
            listItemPbf14 = itemView.findViewById(R.id.tv_listitempbf14);
            minGsm = itemView.findViewById(R.id.tv_gsm_min);
            maxGsm = itemView.findViewById(R.id.tv_gsm_max);
        }
    }
}
