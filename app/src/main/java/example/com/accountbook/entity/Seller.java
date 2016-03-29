package example.com.accountbook.entity;

import com.orm.SugarRecord;

/**
 * Created by c49 on 29/03/16.
 */
public class Seller extends SugarRecord {

    private String name;
    private String phnNumber;
    private String address;
    private double totalAmount;

    public Seller(){

    }
    public Seller(String name,String phnNumber,String address){
        this.name=name;
        this.phnNumber=phnNumber.equals("")?"000-000-0000":phnNumber;
        this.address=address.equals("")?"Address not available":address;
        this.totalAmount=00.00;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber) {
        this.phnNumber = phnNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount+=totalAmount;
    }

    @Override
    public String toString() {
        return name;
    }
}
