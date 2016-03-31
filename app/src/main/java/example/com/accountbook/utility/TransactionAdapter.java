package example.com.accountbook.utility;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import example.com.accountbook.R;
import example.com.accountbook.entity.TransactionDetail;

/**
 * Created by c49 on 29/03/16.
 */
public class TransactionAdapter extends BaseAdapter {

    private Activity activity;
    private List<TransactionDetail> transactions;
    private TransactionAdapter transactionAdapter;
    private static LayoutInflater inflater=null;
    public double prevTotal=0L;
    public TransactionAdapter(Activity activity, List<TransactionDetail> transactions){
        this.activity = activity;
        this.transactions=transactions;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        transactionAdapter=this;
    }
    @Override
    public int getCount() {
        return transactions.size();
    }

    @Override
    public TransactionDetail getItem(int position) {
        return transactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null) {
            vi = inflater.inflate(R.layout.transaction_list_row, null);
            final TransactionDetail transaction=transactions.get(position);
            if(transaction.gettType().equals(AppConstance.CREDIT)){
                vi.setBackgroundColor(activity.getResources().getColor(R.color.light_gray));
            }

            TextView idTvDate = (TextView)vi.findViewById(R.id.idTvDate); // title
            idTvDate.setText(transaction.getDate());

            TextView idTvTransactionNumber = (TextView)vi.findViewById(R.id.idTvTransactionNumber); // title
            idTvTransactionNumber.setText(transaction.getTranNumber());

            TextView idPreviousTotal = (TextView)vi.findViewById(R.id.idPreviousTotal); // title
            idPreviousTotal.setText(""+prevTotal);
            Log.e("prevTotal","prevTotal"+prevTotal);

            TextView idTvTransactionAmount = (TextView)vi.findViewById(R.id.idTvTransactionAmount); // title
            idTvTransactionAmount.setText(""+transaction.getAmount());

            prevTotal=prevTotal+transaction.getAmount();
            Log.e("prevTotal","prevTotal"+prevTotal);
            TextView idTvfinalAmount = (TextView)vi.findViewById(R.id.idTvfinalAmount); // title
            idTvfinalAmount.setText(""+prevTotal);


            TextView idTvEdittransaction = (TextView)vi.findViewById(R.id.idTvEditTransaction); // edit transaction name
            idTvEdittransaction.setTypeface(FontManager.getTypeface(activity,FontManager.FONTAWESOME));
            idTvEdittransaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });


            TextView idTvDeletetransaction = (TextView)vi.findViewById(R.id.idTvDeleteTransaction); // delete transaction
            idTvDeletetransaction.setTypeface(FontManager.getTypeface(activity, FontManager.FONTAWESOME));
            idTvDeletetransaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    transactions.remove(position);
                    transaction.delete();
                    transactionAdapter.notifyDataSetChanged();
                }
            });

        }

        return vi;
    }
}
