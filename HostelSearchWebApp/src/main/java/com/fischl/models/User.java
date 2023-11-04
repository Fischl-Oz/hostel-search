package com.fischl.models;

import com.fischl.DAOs.AccountDAO;
import com.fischl.DAOs.HostelMasterDAO;
import com.fischl.models.interfaces.IAccount;
import com.fischl.models.interfaces.IHostelMaster;
import com.fischl.tools.DatabaseContext;

import java.util.ArrayList;

public class User implements IAccount, IHostelMaster {
    private Account Account = null;
    private HostelMaster HostelMaster = null;
    private ArrayList<Hostel> Hostels = null;

    public User(Account account) {
        if (account == null) return;
        Account = account;
        if (account.getUserType().equals("hostelmaster")) {
            HostelMaster = new HostelMasterDAO().getById(account.getUserId());
            this.Hostels = new DatabaseContext().Hostels.Where(x -> x.getUserId() == account.getUserId());
        }
    }

    public User(HostelMaster hostelMaster) {
        if (hostelMaster == null) return;
        Account = new AccountDAO().getById(hostelMaster.getUserId());
        HostelMaster = hostelMaster;
        Hostels = new DatabaseContext().Hostels.Where(x -> x.getUserId() == hostelMaster.getUserId());
    }

    public User(Hostel hostel) {
        if (hostel == null) return;
        Account = new AccountDAO().getById(hostel.getUserId());
        HostelMaster = new HostelMasterDAO().getById(hostel.getUserId());
        Hostels = new DatabaseContext().Hostels.Where(x -> x.getUserId() == hostel.getUserId());
    }

    public User(String username) {
        if (username == null) return;
        Account = new AccountDAO().getUserByUsername(username);
        if (Account.getUserType().equals("hostelmaster")) {
            HostelMaster = new HostelMasterDAO().getById(Account.getUserId());
            Hostels = new DatabaseContext().Hostels.Where(x -> x.getUserId() == Account.getUserId());
        }
    }

    public Account getAccount() {
        return Account;
    }

    public HostelMaster toHostelMaster() {
        return HostelMaster;
    }

    public ArrayList<Hostel> getHostels() {
        if (getUserType() != "hostelmaster") return null;
        return Hostels;
    }

    public boolean isHostelMaster() {
        return !(HostelMaster == null);
    }

    @Override
    public int getUserId() {
        return Account.getUserId();
    }

    @Override
    public void setUserId(int user_id) {
        Account.setUserId(user_id);
    }

    @Override
    public String getHostelMasterAddress() {
        return HostelMaster.getHostelMasterAddress();
    }

    public void setHostelMasterAddress(String hm_addr) {
        HostelMaster.setHostelMasterAddress(hm_addr);
    }

    @Override
    public String getCccdFront() {
        return HostelMaster.getCccdFront();
    }

    @Override
    public void setCccdFront(String cccd_front) {
        HostelMaster.setCccdFront(cccd_front);
    }

    @Override
    public String getCccdBack() {
        return HostelMaster.getCccdBack();
    }

    @Override
    public void setCccdBack(String cccd_back) {
        HostelMaster.setCccdBack(cccd_back);
    }

    @Override
    public String getHbc() {
        return HostelMaster.getHbc();
    }

    @Override
    public void setHbc(String hbc) {
        HostelMaster.setHbc(hbc);
    }

    @Override
    public String getStatus() {
        return HostelMaster.getStatus();
    }

    @Override
    public void setStatus(String status) {
        HostelMaster.setStatus(status);
    }

    @Override
    public String getFullName() {
        return Account.getFullName();
    }

    @Override
    public void setFullName(String full_name) {
        Account.setFullName(full_name);
    }

    @Override
    public String getUserName() {
        return Account.getUserName();
    }

    @Override
    public void setUserName(String user_name) {
        Account.setUserName(user_name);
    }

    @Override
    public String getPassword() {
        return Account.getPassword();
    }

    @Override
    public void setPassword(String password) {
        Account.setPassword(password);
    }

    @Override
    public String getPhone() {
        return Account.getPhone();
    }

    @Override
    public void setPhone(String phone) {
        Account.setPhone(phone);
    }

    @Override
    public String getEmail() {
        return Account.getEmail();
    }

    @Override
    public void setEmail(String email) {
        Account.setEmail(email);
    }

    @Override
    public String getUserType() {
        return Account.getUserType();
    }

    @Override
    public void setUserType(String user_type) {
        Account.setUserType(user_type);
    }

    public boolean equal(Object o) {
        User obj = (User) o;
        return obj.getUserId() == this.getUserId();
    }

    public boolean isHostelMasterApproved() {
        return HostelMaster.getStatus().equals("accepted");
    }
}
