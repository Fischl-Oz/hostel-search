package com.fischl.tools;

import com.fischl.DAOs.*;
import com.fischl.models.*;

public class DatabaseContext {
    public final DataSet<Account> Accounts;
    public final DataSet<HostelMaster> HostelMasters;
    public final DataSet<Hostel> Hostels;
    public final DataSet<Post> Posts;
    public final DataSet<Tag> Tags;
    public DatabaseContext() {
        Accounts = new DataSet<>(new AccountDAO().getAll());
        HostelMasters = new DataSet<>(new HostelMasterDAO().getAll());
        Hostels = new DataSet<>(new HostelDAO().getAll());
        Posts = new DataSet<>(new PostDAO().getAll());
        Tags = new DataSet<>(new TagDAO().getAll());
    }
}
