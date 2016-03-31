package example.com.accountbook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import example.com.accountbook.entity.Seller;
import example.com.accountbook.entity.TransactionDetail;
import example.com.accountbook.utility.AppConstance;
import example.com.accountbook.utility.TransactionAdapter;

public class AccountDetail extends AppCompatActivity {
    Long id;
    TextView textView;
    Spinner selectAccount;
    ListView transactionListView;
    List<TransactionDetail>  transactionDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        initViews();
        id=getIntent().getLongExtra(AppConstance.SELLER_ID,0L);
        if(id>0)
        {
            Seller  seller=Seller.findById(Seller.class,id);
            restoreActionBar(seller.getName());
            selectAccount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long ids) {
                    if(position>0){
                       transactionDetails=TransactionDetail.find(TransactionDetail.class," ACCOUNT_TYPE=? AND SELLER_ID="+id,new String[]{selectAccount.getSelectedItem().toString()},null,null,null);
                        TransactionAdapter transactionAdapter=new TransactionAdapter(AccountDetail.this,transactionDetails);
                        transactionListView.setAdapter(transactionAdapter);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account_detail, menu);
        return true;
    }

    public void initViews(){
        textView=(TextView)findViewById(R.id.idTvSellerName);
        selectAccount=(Spinner)findViewById(R.id.idSpnrAccountType);
        transactionListView=(ListView)findViewById(R.id.idTransactionList);
    }
    public void restoreActionBar(String mTitle) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
