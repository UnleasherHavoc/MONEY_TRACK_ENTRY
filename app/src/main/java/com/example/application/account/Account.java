package com.example.application.account;

/**
 * Created by BAIG1995 on 1/12/2017.
 */

public class Account {
    private int _id;
    private String _name;
    private int _amount;


    public Account(String _name, int _amount) {
        this._name = _name;
        this._amount = _amount;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_amount() {
        return _amount;
    }

    public void set_amount(int _amount) {
        this._amount = _amount;
    }
}
