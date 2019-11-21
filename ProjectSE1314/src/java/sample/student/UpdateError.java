/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.student;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class UpdateError implements Serializable{
    private String classLengthErr;
    private String address1LengthErr;
    private String phoneLengthErr;
    private String phoneFormatErr;

    public UpdateError() {
    }

    public UpdateError(String classLengthErr, String address1LengthErr, String phoneLengthErr, String phoneFormatErr) {
        this.classLengthErr = classLengthErr;
        this.address1LengthErr = address1LengthErr;
        this.phoneLengthErr = phoneLengthErr;
        this.phoneFormatErr = phoneFormatErr;
    }

    public String getClassLengthErr() {
        return classLengthErr;
    }

    public void setClassLengthErr(String classLengthErr) {
        this.classLengthErr = classLengthErr;
    }

    public String getAddress1LengthErr() {
        return address1LengthErr;
    }

    public void setAddress1LengthErr(String address1LengthErr) {
        this.address1LengthErr = address1LengthErr;
    }

    public String getPhoneLengthErr() {
        return phoneLengthErr;
    }

    public void setPhoneLengthErr(String phoneLengthErr) {
        this.phoneLengthErr = phoneLengthErr;
    }

    public String getPhoneFormatErr() {
        return phoneFormatErr;
    }

    public void setPhoneFormatErr(String phoneFormatErr) {
        this.phoneFormatErr = phoneFormatErr;
    }
    
    
}
