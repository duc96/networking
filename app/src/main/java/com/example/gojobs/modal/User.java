package com.example.gojobs.modal;

public class User {

    private String id;
    private String tenNguoiDung;
    private String matKhau;
    private String email;
    private String phone;

    public User(String userName, String passWord, String email, String phone) {
        this.tenNguoiDung = userName;
        this.matKhau = passWord;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return tenNguoiDung;
    }

    public void setUserName(String userName) {
        this.tenNguoiDung = userName;
    }

    public String getPassWord() {
        return matKhau;
    }

    public void setPassWord(String passWord) {
        this.matKhau = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + tenNguoiDung + '\'' +
                ", passWord='" + matKhau + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
