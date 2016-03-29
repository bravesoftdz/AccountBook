package example.com.accountbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import example.com.accountbook.entity.Seller;
import example.com.accountbook.entity.TransactionDetail;
import example.com.accountbook.utility.AppConstance;
import example.com.accountbook.utility.Utility;
import example.com.accountbook.utility.Validation;

/**
 * Created by c49 on 29/03/16.
 */
public class AddTransactionFragment extends android.app.Fragment {
    View addTransaction;
    Spinner idSpnrSeller, idSpnrAccountType, idSpnrTranSType;

    EditText idEtTransactionNumber, idEtTransactionDescription, idEtTransactionAmount;
    Button btnSave;
    long sellerId;
    String accountType, transactionType, transactionNumber, description;
    double amount;
    private static final String TAG = "AddTransactionFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addTransaction = (View) inflater.inflate(
                R.layout.add_transaction, container, false);

        initViews();
        return addTransaction;
    }

    public void initViews() {
        idSpnrSeller = (Spinner) addTransaction.findViewById(R.id.idSpnrSeller);
        ArrayAdapter<Seller> spinnerSellerArrayAdapter = new ArrayAdapter<Seller>(getActivity(), android.R.layout.simple_spinner_item, Seller.listAll(Seller.class)); //selected item will look like a spinner set from XML
        spinnerSellerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSpnrSeller.setAdapter(spinnerSellerArrayAdapter);
        idSpnrSeller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Seller seller = (Seller) idSpnrSeller.getSelectedItem();
                sellerId = seller.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        idSpnrAccountType = (Spinner) addTransaction.findViewById(R.id.idSpnrAccountType);
        idSpnrAccountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                accountType = idSpnrAccountType.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        idSpnrTranSType = (Spinner) addTransaction.findViewById(R.id.idSpnrTranSType);
        idSpnrTranSType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                transactionType = idSpnrTranSType.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        idEtTransactionNumber = (EditText) addTransaction.findViewById(R.id.idEtTransactionNumber);
        idEtTransactionDescription = (EditText) addTransaction.findViewById(R.id.idEtTransactionDescription);
        idEtTransactionAmount = (EditText) addTransaction.findViewById(R.id.idEtTransactionAmount);
        btnSave = (Button) addTransaction.findViewById(R.id.idBtnSave);

        if (null != getArguments()) {
            final Long id = getArguments().getLong(AppConstance.TRANSACTION_ID);

            final TransactionDetail transaction = TransactionDetail.findById(TransactionDetail.class, id);
            idEtTransactionAmount.setText("" + transaction.getAmount());
            idEtTransactionDescription.setText(transaction.getDescription());
            idEtTransactionNumber.setText(transaction.getTranNumber());
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isValidate()) {
                        //Seller seller = new Seller(idEtName.getText().toString(), idEtMobile.getText().toString(), idEtAddress.getText().toString());
                        transaction.setAmount(Double.parseDouble(idEtTransactionAmount.getText().toString()));
                        transaction.save();

                    }
                }
            });

        } else {

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isValidate()) {
                        transactionType=idSpnrTranSType.getSelectedItem().toString();
                        amount=Double.parseDouble(idEtTransactionAmount.getText().toString());
                        if(transactionType.equalsIgnoreCase("Credit"))
                            amount*=1;
                        else if(transactionType.equalsIgnoreCase("debit"))
                            amount*=-1;

                        Seller seller=Seller.findById(Seller.class,sellerId);
                        seller.setTotalAmount(amount);
                        seller.save();
                        TransactionDetail transaction = new TransactionDetail(sellerId, transactionType, idEtTransactionDescription.getText().toString(), Utility.getCurrentDate(), idEtTransactionNumber.getText().toString(), amount, idSpnrAccountType.getSelectedItem().toString());
                        Log.e(TAG,transaction.toString());
                        transaction.save();

                    }
                }
            });
        }

    }

    public void assignValue() {
        transactionType = idSpnrTranSType.getSelectedItem().toString();
        accountType = idSpnrAccountType.getSelectedItem().toString();

    }

    public boolean isValidate() {
        boolean isValid = true;
        if (!Validation.chkRequired(getActivity(), idEtTransactionAmount, "Name is required.", 1, 64)) {
            isValid = false;
        }
        if (!Validation.chkSpinnerItemSelected(getActivity(), idSpnrAccountType)) {
            isValid = false;
        }
        if (!Validation.chkSpinnerItemSelected(getActivity(), idSpnrTranSType)) {
            isValid = false;
        }


        return isValid;
    }
}
