package example.com.accountbook;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import example.com.accountbook.entity.Seller;
import example.com.accountbook.utility.SellerAdapter;

/**
 * Created by c49 on 29/03/16.
 */
public class SellerManagementFragment extends Fragment {
    View sellerListView;
    ListView idSellerList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sellerListView = (View) inflater.inflate(
                R.layout.seller_list, container, false);
        idSellerList=(ListView)sellerListView.findViewById(R.id.idSellerList);
        final SellerAdapter sellerAdapter=new SellerAdapter(getActivity(), Seller.listAll(Seller.class));
        idSellerList.setAdapter(sellerAdapter);
        idSellerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Seller seller=sellerAdapter.getItem(position);
                Log.e("SellerManagementFragme",seller.toString());
            }
        });
        return sellerListView;
    }
}
