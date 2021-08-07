package com.example.tsvid_ff.Database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tsvid_ff.Entity.Account;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBContext {

    public ArrayList<Account> getDataAccount()
    {
        ArrayList<Account> accounts=new ArrayList<>();
        DatabaseReference db= FirebaseDatabase.getInstance().getReference();
        db.child("Account").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot snapshot, String previousChildName) {
                accounts.add(snapshot.getValue(Account.class));
            }

            @Override
            public void onChildChanged( DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onChildRemoved( DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved( DataSnapshot snapshot, String previousChildName) {

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
        return accounts;
    }
    public boolean Unique(String id)
    {
        ArrayList<Account> accounts=getDataAccount();
        for (Account acc:accounts
             ) {
            if(acc.getId().equalsIgnoreCase(id))
            {
                return false;
            }
        }
        return true;
    }
    public void addAccount(Account acc){
        DatabaseReference db= FirebaseDatabase.getInstance().getReference();
        db.child("Account").setValue(acc);
    }
    public void updateAccountpassword(String id,String newpassword){
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Account");
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot snapshot,  String previousChildName) {
                if(snapshot.getValue(Account.class).getId().equalsIgnoreCase(id))
                {
                    db.child("password").setValue(newpassword);
                }
            }

            @Override
            public void onChildChanged( DataSnapshot snapshot,  String previousChildName) {

            }

            @Override
            public void onChildRemoved( DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved( DataSnapshot snapshot,  String previousChildName) {

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
    }
    public void deleteAccount(String id){
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Account");
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot snapshot,  String previousChildName) {
                if(snapshot.getValue(Account.class).getId().equalsIgnoreCase(id))
                {
                    db.setValue(null);
                }
            }

            @Override
            public void onChildChanged( DataSnapshot snapshot,  String previousChildName) {

            }

            @Override
            public void onChildRemoved( DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved( DataSnapshot snapshot,  String previousChildName) {

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
    }
}
