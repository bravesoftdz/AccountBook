package example.com.accountbook.utility;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import example.com.accountbook.AddSellerFragment;
import example.com.accountbook.R;
import example.com.accountbook.entity.Seller;

/**
 * Created by c49 on 29/03/16.
 */
public class SellerAdapter extends BaseAdapter {

    private Activity activity;
    private List<Seller> sellers;
    private SellerAdapter sellerAdapter;
    private static LayoutInflater inflater=null;
    public SellerAdapter(Activity activity,List<Seller> sellers){
        this.activity = activity;
        this.sellers=sellers;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sellerAdapter=this;
    }
    @Override
    public int getCount() {
        return sellers.size();
    }

    @Override
    public Seller getItem(int position) {
        return sellers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.seller_list_row, null);
        final Seller seller=sellers.get(position);
        TextView list_image = (TextView)vi.findViewById(R.id.list_image); // title
        list_image.setTypeface(FontManager.getTypeface(activity,FontManager.FONTAWESOME));
        TextView idTvSellerName = (TextView)vi.findViewById(R.id.idTvSellerName); // title
        TextView idTvTotalAmount = (TextView)vi.findViewById(R.id.idTvTotalAmount); // title
        TextView idTvEditSeller = (TextView)vi.findViewById(R.id.idTvEditSeller); // edit seller name
        idTvEditSeller.setTypeface(FontManager.getTypeface(activity,FontManager.FONTAWESOME));
        idTvEditSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSellerFragment addSellerFragment = new AddSellerFragment();
                Bundle bundle = new Bundle();
                bundle.putLong(AppConstance.SELLER_ID, seller.getId());
                addSellerFragment.setArguments(bundle);
                activity.getFragmentManager().beginTransaction()
                        .replace(R.id.container, addSellerFragment)
                        .commit();
            }
        });
        TextView idTvDeleteSeller = (TextView)vi.findViewById(R.id.idTvDeleteSeller); // delete seller
        idTvDeleteSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sellers.remove(position);
                seller.delete();
                sellerAdapter.notifyDataSetChanged();

            }
        });
        idTvDeleteSeller.setTypeface(FontManager.getTypeface(activity, FontManager.FONTAWESOME));

        idTvSellerName.setText(seller.getName());
        idTvTotalAmount.setText("Total credit Amount:" + seller.getTotalAmount());




        return vi;
    }
}
