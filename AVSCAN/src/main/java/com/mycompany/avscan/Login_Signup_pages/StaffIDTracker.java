/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan.Login_Signup_pages;

/**
 *
 * @author vince-kong
 */
public class StaffIDTracker {
    private static String loggedInStaffID;

    public static String getLoggedInStaffID() {
        return loggedInStaffID;
    }

    public static void setLoggedInStaffID(String staffID) {
        loggedInStaffID = staffID;
    }
}
