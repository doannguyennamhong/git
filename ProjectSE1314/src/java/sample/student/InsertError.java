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
public class InsertError implements Serializable{
    private String idLengthErr;
    private String firstnameLengthErr;
    private String lastnameLengthErr;
    private String classLengthErr;
    private String address1LengthErr;
    private String phoneLengthErr;
    private String phoneFormatErr;
    private String idExistedErr;

    public InsertError() {
    }

    public InsertError(String idLengthErr, String firstnameLengthErr, String lastnameLengthErr, String classLengthErr, String address1LengthErr, String phoneLengthErr, String phoneFormatErr, String idExistedErr) {
        this.idLengthErr = idLengthErr;
        this.firstnameLengthErr = firstnameLengthErr;
        this.lastnameLengthErr = lastnameLengthErr;
        this.classLengthErr = classLengthErr;
        this.address1LengthErr = address1LengthErr;
        this.phoneLengthErr = phoneLengthErr;
        this.phoneFormatErr = phoneFormatErr;
        this.idExistedErr = idExistedErr;
    }

    public String getIdLengthErr() {
        return idLengthErr;
    }

    public void setIdLengthErr(String idLengthErr) {
        this.idLengthErr = idLengthErr;
    }

    public String getFirstnameLengthErr() {
        return firstnameLengthErr;
    }

    public void setFirstnameLengthErr(String firstnameLengthErr) {
        this.firstnameLengthErr = firstnameLengthErr;
    }

    public String getLastnameLengthErr() {
        return lastnameLengthErr;
    }

    public void setLastnameLengthErr(String lastnameLengthErr) {
        this.lastnameLengthErr = lastnameLengthErr;
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

    public String getIdExistedErr() {
        return idExistedErr;
    }

    public void setIdExistedErr(String idExistedErr) {
        this.idExistedErr = idExistedErr;
    }
    
    
}
