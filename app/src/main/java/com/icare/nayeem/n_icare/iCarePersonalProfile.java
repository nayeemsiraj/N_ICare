package com.icare.nayeem.n_icare;

/**
 * Created by Mobile App Develop on 10-6-15.
 */
public class iCarePersonalProfile {
    private  String Name;
    private  String Phone;
    private  String Email;
    private  String Address;
    private  String Dob;
    private  String Photo;
    private  String BloodGroup;
    private  String Major;
    private  String PresentHealth;
    private  String SugarLabel;
    private  String BloodPressure;
    private  String Status;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getPresentHealth() {
        return PresentHealth;
    }

    public void setPresentHealth(String presentHealth) {
        PresentHealth = presentHealth;
    }

    public String getSugarLabel() {
        return SugarLabel;
    }

    public void setSugarLabel(String sugarLabel) {
        SugarLabel = sugarLabel;
    }

    public String getBloodPressure() {
        return BloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        BloodPressure = bloodPressure;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Name: "+Name+"Phone:"+Phone;
    }
}

