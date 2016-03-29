package example.com.accountbook.entity;

import com.orm.SugarRecord;

/**
 * Created by c49 on 29/03/16.
 */
public class TransactionDetail extends SugarRecord {

    private String tType;
    private long sellerId;
    private String description;
    private String tDate;
    private String tranNumber;
    private double amount;
    private String accountType;

    public  TransactionDetail(){

    }
    public TransactionDetail(long sellerId,String tType,String description,String tDate,String tranNumber,double amount,String accountType){

        this.sellerId=sellerId;
        this.tType=tType;
        this.description=description;
        this.tDate=tDate;
        this.tranNumber=tranNumber;
        this.amount=amount;
        this.accountType=accountType;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return tDate;
    }

    public void setDate(String date) {
        this.tDate = date;
    }

    public String getTranNumber() {
        return tranNumber;
    }

    public void setTranNumber(String tranNumber) {
        this.tranNumber = tranNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tType='" + tType + '\'' +
                ", sellerId=" + sellerId +
                ", description='" + description + '\'' +
                ", tDate='" + tDate + '\'' +
                ", tranNumber='" + tranNumber + '\'' +
                ", amount=" + amount +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
