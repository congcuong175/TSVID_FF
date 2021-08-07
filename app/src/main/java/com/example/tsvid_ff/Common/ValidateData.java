package com.example.tsvid_ff.Common;

import com.example.tsvid_ff.Entity.Account;

import java.util.ArrayList;
import  static com.example.tsvid_ff.Activity.LoginActivity.dbContext;
public class ValidateData {
    public static boolean checkEmpty(String content){
        if(content.equals("")) return false;
        return true;
    }
    public static boolean checkUniqueID(String id)
    {
        ArrayList<Account> accounts=dbContext.getDataAccount();
        for (Account acc:accounts
        ) {
            if(acc.getId().equalsIgnoreCase(id))
            {
                return false;
            }
        }
        return true;
    }

}
