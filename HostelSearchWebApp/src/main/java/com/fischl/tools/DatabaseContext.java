package com.fischl.tools;

import com.fischl.DAOs.AccountDAO;
import com.fischl.DAOs.HostelDAO;
import com.fischl.DAOs.HostelMasterDAO;
import com.fischl.DAOs.PostDAO;
import com.fischl.models.Account;
import com.fischl.models.Hostel;
import com.fischl.models.HostelMaster;
import com.fischl.models.Post;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DatabaseContext {
    public DataSet<Account> Accounts;
    public DataSet<HostelMaster> HostelMasters;
    public DataSet<Hostel> Hostels;
    public DataSet<Post> Posts;
    public DatabaseContext() {
        Accounts = new DataSet<Account>(new AccountDAO().getAll());
        HostelMasters = new DataSet<HostelMaster>(new HostelMasterDAO().getAll());
        Hostels = new DataSet<Hostel>(new HostelDAO().getAll());
        Posts = new DataSet<Post>(new PostDAO().getAll());
    }
    public class DataSet<T> {
        private ArrayList<T> list;
        DataSet(ArrayList<T> list) {
            this.list = list;
        }
        public ArrayList<T> toList() {
            return list;
        }
        public T SingleOrDefault(Predicate<? super T> condition) {
            Stream<T> stream = list.stream();
            T object = stream.filter(condition).findFirst().orElse(null);
            return object;
        }
    }
}
