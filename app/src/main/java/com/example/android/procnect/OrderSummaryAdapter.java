package com.example.android.procnect;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class OrderSummaryAdapter extends RecyclerView.Adapter<OrderSummaryAdapter.ListViewHolder> {
    private final List<OrderQueryList> orderQueryList;

    public OrderSummaryAdapter(List<OrderQueryList> orderQueryList){
        super();
        this.orderQueryList = orderQueryList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIdForListItems = R.layout.activity_order_summary_list_item;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutIdForListItems, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        final OrderQueryList orderQueryList1 = orderQueryList.get(position);
        holder.orderId.setText(orderQueryList1.getorderId());
        holder.sale_company.setText(orderQueryList1.getsalecompany());
        holder.bf.setText(orderQueryList1.getbf());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderDetailsIntent = new Intent(view.getContext(), OrderDetailsActivity.class);
                orderDetailsIntent.putExtra("sale_company", orderQueryList1.getsalecompany());
                orderDetailsIntent.putExtra("order_id", orderQueryList1.getorderId());
                orderDetailsIntent.putExtra("bf", orderQueryList1.getbf());
                orderDetailsIntent.putExtra("price", orderQueryList1.getprice());
                orderDetailsIntent.putExtra("order_status", orderQueryList1.getorderstatus());
                orderDetailsIntent.putExtra("confirm_button", orderQueryList1.getbuttonstatus());
                orderDetailsIntent.putExtra("buyer_email", orderQueryList1.getbuyeremail());
                orderDetailsIntent.putExtra("payment_terms", orderQueryList1.getpaymentterms());
                orderDetailsIntent.putExtra("gsm1", orderQueryList1.getgsm1());
                orderDetailsIntent.putExtra("gsm2", orderQueryList1.getgsm2());
                orderDetailsIntent.putExtra("gsm3", orderQueryList1.getgsm3());
                orderDetailsIntent.putExtra("gsm4", orderQueryList1.getgsm4());
                orderDetailsIntent.putExtra("gsm5", orderQueryList1.getgsm5());
                orderDetailsIntent.putExtra("gsm6", orderQueryList1.getgsm6());
                orderDetailsIntent.putExtra("gsm7", orderQueryList1.getgsm7());
                orderDetailsIntent.putExtra("gsm8", orderQueryList1.getgsm8());
                orderDetailsIntent.putExtra("gsm9", orderQueryList1.getgsm9());
                orderDetailsIntent.putExtra("gsm10", orderQueryList1.getgsm10());
                orderDetailsIntent.putExtra("width1", orderQueryList1.getwidth1());
                orderDetailsIntent.putExtra("width2", orderQueryList1.getwidth2());
                orderDetailsIntent.putExtra("width3", orderQueryList1.getwidth3());
                orderDetailsIntent.putExtra("width4", orderQueryList1.getwidth4());
                orderDetailsIntent.putExtra("width5", orderQueryList1.getwidth5());
                orderDetailsIntent.putExtra("width6", orderQueryList1.getwidth6());
                orderDetailsIntent.putExtra("width7", orderQueryList1.getwidth7());
                orderDetailsIntent.putExtra("width8", orderQueryList1.getwidth8());
                orderDetailsIntent.putExtra("width9", orderQueryList1.getwidth9());
                orderDetailsIntent.putExtra("width10", orderQueryList1.getwidth10());
                orderDetailsIntent.putExtra("quantity1", orderQueryList1.getquantity1());
                orderDetailsIntent.putExtra("quantity2", orderQueryList1.getquantity2());
                orderDetailsIntent.putExtra("quantity3", orderQueryList1.getquantity3());
                orderDetailsIntent.putExtra("quantity4", orderQueryList1.getquantity4());
                orderDetailsIntent.putExtra("quantity5", orderQueryList1.getquantity5());
                orderDetailsIntent.putExtra("quantity6", orderQueryList1.getquantity6());
                orderDetailsIntent.putExtra("quantity7", orderQueryList1.getquantity7());
                orderDetailsIntent.putExtra("quantity8", orderQueryList1.getquantity8());
                orderDetailsIntent.putExtra("quantity9", orderQueryList1.getquantity9());
                orderDetailsIntent.putExtra("quantity10", orderQueryList1.getquantity10());
                orderDetailsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                view.getContext().startActivity(orderDetailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {return orderQueryList.size();}

    public class ListViewHolder extends RecyclerView.ViewHolder {

        final TextView orderId;
        final TextView sale_company;
        final TextView bf;

        public ListViewHolder(View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.tv_orderid);
            sale_company = itemView.findViewById(R.id.tv_salecompany);
            bf = itemView.findViewById(R.id.tv_bf);

        }
    }
}
