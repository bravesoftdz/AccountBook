package example.com.accountbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import example.com.accountbook.R;
import example.com.accountbook.SellerManagementFragment;
import example.com.accountbook.entity.Seller;
import example.com.accountbook.utility.AppConstance;
import example.com.accountbook.utility.Validation;

/**
 * Created by c49 on 29/03/16.
 */
public class AddSellerFragment extends android.app.Fragment {
    View addSeller;
    EditText idEtName,idEtMobile,idEtAddress;
    Button btnSave;
    private static final  String TAG = "AddSellerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addSeller = (View) inflater.inflate(
                R.layout.add_seller, container, false);



        initViews();
        return addSeller;
    }

    public void initViews(){
        idEtName=(EditText)addSeller.findViewById(R.id.idEtName);
        idEtMobile=(EditText)addSeller.findViewById(R.id.idEtMobile);
        idEtAddress=(EditText)addSeller.findViewById(R.id.idEtAddress);
        btnSave=(Button)addSeller.findViewById(R.id.idBtnSave);

        if(null!=getArguments()) {
            final Long id = getArguments().getLong(AppConstance.SELLER_ID);

                final Seller seller = Seller.findById(Seller.class, id);
                idEtName.setText(seller.getName());
                idEtAddress.setText(seller.getAddress());
                idEtMobile.setText(seller.getPhnNumber());
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (isValidate()) {
                            //Seller seller = new Seller(idEtName.getText().toString(), idEtMobile.getText().toString(), idEtAddress.getText().toString());
                            seller.setAddress(idEtAddress.getText().toString());
                            seller.setName(idEtName.getText().toString());
                            seller.setPhnNumber(idEtMobile.getText().toString());
                            seller.save();
                            getActivity().getFragmentManager().beginTransaction()
                                    .replace(R.id.container, new SellerManagementFragment())
                                    .commit();
                        }
                    }
                });

        }
        else {

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isValidate()) {
                        Seller seller = new Seller(idEtName.getText().toString(), idEtMobile.getText().toString(), idEtAddress.getText().toString());
                        seller.save();
                        getActivity().getFragmentManager().beginTransaction()
                                .replace(R.id.container, new SellerManagementFragment())
                                .commit();
                    }
                }
            });
        }

    }
    public boolean isValidate(){
        boolean isValid=true;
        if(!Validation.chkRequired(getActivity(), idEtName, "Name is required.", 3, 64)){
            Log.e(TAG, "validate ===>" + isValid);
            isValid=false;
        }
        return isValid;
    }
}
