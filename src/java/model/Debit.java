/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phanb
 */
public class Debit {
   int id;
   String name;
   String address;
   int phone;
   String email;
   long total;
   String crday;
   String uday;
   int aid;
   String note;

    public Debit() {
    }

    public Debit(int id, String name, String address, int phone, String email, long total, String crday, String uday, int aid, String note) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.total = total;
        this.crday = crday;
        this.uday = uday;
        this.aid = aid;
        this.note = note;
    }

   
    
    public Debit(int id, String name, String address, int phone, String email, long total, String crday, String uday, int aid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.total = total;
        this.crday = crday;
        this.uday = uday;
        this.aid = aid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getCrday() {
        return crday;
    }

    public void setCrday(String crday) {
        this.crday = crday;
    }

    public String getUday() {
        return uday;
    }

    public void setUday(String uday) {
        this.uday = uday;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    

   }