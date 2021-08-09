package com.example.tsvid_ff.Common;

import android.util.Log;

import com.example.tsvid_ff.Entity.Account;

import java.util.ArrayList;
import java.util.List;

import  static com.example.tsvid_ff.Activity.LoginActivity.dbContext;
public class ValidateData {
    public static boolean checkEmpty(String content){
        if(content.equals("")) return false;
        return true;
    }
    public static boolean checkUniqueID(String id,List<Account>accountList)
    {
        for (Account acc:accountList
        ) {
            if(acc.getId().equalsIgnoreCase(id))
            {
                return false;
            }
        }
        return true;
    }

}
