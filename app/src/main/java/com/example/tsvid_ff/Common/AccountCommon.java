package com.example.tsvid_ff.Common;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.tsvid_ff.Entity.Account;

import java.util.ArrayList;

import static com.example.tsvid_ff.Activity.LoginActivity.dbContext;
public class AccountCommon {

    public static String ID_ACCOUNT = "";
    public static Account acc;
    public static int Login(ArrayList<Account>accounts, String id, String passwood) {

        int result = -1;
        for (Account account :accounts
        ) {

            if (account.getId().equalsIgnoreCase(id) && account.getPassword().equalsIgnoreCase(passwood) && account.getPermission().equalsIgnoreCase("false") ){
                result = 0;
                ID_ACCOUNT = account.getId();
                acc=account;
            }

            if (account.getId().equalsIgnoreCase(id) && account.getPassword().equalsIgnoreCase(passwood) && account.getPermission().equalsIgnoreCase("true")){
                result = 1;
                ID_ACCOUNT = account.getId();
                acc=account;
            }
            if(account.getId().equalsIgnoreCase(id.trim()) && !account.getPassword().equalsIgnoreCase(passwood)){
                result = 2;

            }
        }
        return result;
    }

}
