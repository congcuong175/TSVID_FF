package com.example.tsvid_ff.Common;

import com.example.tsvid_ff.Entity.Account;
import static com.example.tsvid_ff.Activity.LoginActivity.dbContext;
public class AccountCommon {
    public static String ID_ACCOUNT = "";
    public static int Login(String id, String passwood) {
        int result = -1;
        for (Account account : dbContext.getDataAccount()
        ) {
            if (account.getId().equalsIgnoreCase(id.trim()) && account.getPassword().equalsIgnoreCase(passwood.trim()) && account.getPermission() == false){
                result = 0;
                ID_ACCOUNT = account.getId();
            }

            if (account.getId().equalsIgnoreCase(id.trim()) && account.getPassword().equalsIgnoreCase(passwood.trim()) && account.getPermission() == true){
                result = 1;
                ID_ACCOUNT = account.getId();
            }
            if(account.getId().equalsIgnoreCase(id.trim()) && !account.getPassword().equalsIgnoreCase(passwood)){
                result = 2;
            }
        }
        return result;
    }

}
