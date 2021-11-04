
package controllers;


public class Customerlisttt {
    String accountnumber,name,dateofbirth,gender,mob,address;

    Customerlisttt(String accountnumber, String name, String dateofbirth, String gender, String mob, String address) {
        this.accountnumber = accountnumber;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.mob = mob;
        this.address = address; 
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public String getName() {
        return name;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public String getMob() {
        return mob;
    }

    public String getAddress() {
        return address;
    }

    public void setAccoutnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
