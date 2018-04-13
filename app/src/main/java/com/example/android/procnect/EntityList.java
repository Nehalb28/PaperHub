package com.example.android.procnect;

import java.util.ArrayList;

class EntityList extends ArrayList<String> {
    private String name;
    private String email;
    private String location;
    private String pbf14;
    private String pbf16;
    private String pbf18;
    private String pbf20;
    private String pbf22;
//    private String pbf24;
    private String pbf25;
//    private String pbf26;
    private String pbf28;
    private String pbf30;
    private String pbf32;
//    private String pbf34;
    private String pbf35;
    private String mingsm;
    private String maxgsm;
    private String insurance;
    private String payment_terms;

    public String getName() {
        return name;
    }
    public void setName(String tempname)
    {this.name = tempname;}
    public String getEmail() {
        return email;
    }
    public void setEmail(String tempemail)
    {this.email = tempemail;}
    public String getLocation() { return location;}
    public void setLocation(String templocation)
    {this.location = templocation;}
    String getPbf14() { return pbf14; }
    void setPbf14(String temppbf14)
    {this.pbf14 = temppbf14;}
    String getPbf16() { return pbf16; }
    void setPbf16(String temppbf16)
    {this.pbf16 = temppbf16;}
    String getPbf18() { return pbf18; }
    void setPbf18(String temppbf18)
    {this.pbf18 = temppbf18;}
    String getPbf20() { return pbf20; }
    void setPbf20(String temppbf20)
    {this.pbf20 = temppbf20;}
    String getPbf22() { return pbf22; }
    void setPbf22(String temppbf22)
    {this.pbf22 = temppbf22;}
//    public String getPbf24() { return pbf24; }
//    void setPbf24(String temppbf24)
//    {this.pbf24 = temppbf24;}
    String getPbf25() { return pbf25; }
    void setPbf25(String temppbf25)
    {this.pbf25 = temppbf25;}
//    public String getPbf26() { return pbf26; }
//    void setPbf26(String temppbf26)
//    {this.pbf26 = temppbf26;}
    String getPbf28() { return pbf28; }
    void setPbf28(String temppbf28)
    {this.pbf28 = temppbf28;}
    String getPbf30() { return pbf30; }
    void setPbf30(String temppbf30)
    {this.pbf30 = temppbf30;}
    String getPbf32() { return pbf32; }
    void setPbf32(String temppbf32)
    {this.pbf32 = temppbf32;}
//    public String getPbf34() { return pbf34; }
//    void setPbf34(String temppbf34)
//    {this.pbf34 = temppbf34;}
    String getPbf35() { return pbf35; }
    void setPbf35(String temppbf35)
    {this.pbf35 = temppbf35;}
    String getMingsm(){ return mingsm; }
    void setMingsm(String tempmingsm)
    {this.mingsm = tempmingsm;}
    String getMaxgsm(){ return maxgsm;}
    void setMaxgsm(String tempmaxgsm)
    {this.maxgsm = tempmaxgsm;}

    String getInsurance(){ return insurance;}
    void setInsurance(String tempinsurance)
    {this.insurance = tempinsurance;}

    String getPaymentTerms(){ return payment_terms;}
    void setPaymentTerms(String temp_payment_terms)
    {this.payment_terms = temp_payment_terms;}
}
