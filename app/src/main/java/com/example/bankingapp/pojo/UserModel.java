package com.example.bankingapp.pojo;

public class UserModel
{
    String userName;
    String phoneNumber;
    String email;
    String userBalance;
    String age;

    public UserModel(String userName, String phoneNumber, String email, String userBalance, String age)
    {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userBalance = userBalance;
        this.age = age;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUserBalance()
    {
        return userBalance;
    }

    public void setUserBalance(String userBalance)
    {
        this.userBalance = userBalance;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }
}
