/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan.Login_Signup_pages;

/**
 *
 * @author vince-kong
 */
public class StaffRole {
    private static String staffRole;
    
    public static void setUserRole(String role) {
        staffRole = role;
    }

    public static String getUserRole() {
        return staffRole;
    }
}
