///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package barpiotr.util;
//
//
///**
// *
// * @author PiotrB. CCT - sb17018
// */
//public class SetWarningIfFieldEmpty {
//
//    private String theFirstName;
//    private String theLastName;
//    private String theLogin;
//    private String thePhone;
//    private String thePass;
//
//    InputFieldsData userInput;
//
//    public SetWarningIfFieldEmpty(InputFieldsData userInput) {
//        this.userInput = userInput;
//    }
//
//    public String getTheFirstName() {
//        if (userInput.getTheFirstName().equals("")) {
//            theFirstName = "FIRST NAME CAN'T BE EMPTY";
//        } else {
//            theFirstName = "";
//        }
//        return theFirstName;
//    }
//
//    public String getTheLastName() {
//        if (userInput.getTheLastName().equals("")) {
//            theLastName = "LAST NAME CAN'T BE EMPTY";
//        } else {
//            theLastName = "";
//        }
//        return theLastName;
//    }
//
//    public String getTheLogin() {
//        if (userInput.getTheLogin().equals("")) {
//            theLogin = "LOGIN CAN'T BE EMPTY";
//        } else {
//            theLogin = "";
//        }
//        return theLogin;
//    }
//
//    public String getThePhone() {
//        if (userInput.getThePhone().equals("")) {
//            thePhone = "PHONE CAN'T BE EMPTY";
//        } else {
//            thePhone = "";
//        }
//        return thePhone;
//    }
//
//    public String getThePass() {
//        if (userInput.getThePass().equals("")) {
//            thePass = "PASSWORD CAN'T BE EMPTY";
//        } else {
//            thePass = "";
//        }
//        return thePass;
//    }
//}
