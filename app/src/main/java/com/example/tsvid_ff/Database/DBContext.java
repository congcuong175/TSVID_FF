package com.example.tsvid_ff.Database;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.tsvid_ff.Activity.RegisterActivity;
import com.example.tsvid_ff.Entity.Account;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBContext {
    int kt;
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

    public int addAccount(Account acc){
        DatabaseReference db= FirebaseDatabase.getInstance().getReference();
        kt=0;
        db.child("Account").push().setValue(acc, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete( DatabaseError error,  DatabaseReference ref) {
                if(error ==null)
                {
                    kt=1;
                }
            }
        });
        return  kt;
    }
    public int updateAccountInfor(Account acc)
    {
        kt=1;
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Account");
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot snapshot,  String previousChildName) {
                if(snapshot.getValue(Account.class).getId().equalsIgnoreCase(acc.getId()))
                {
                    snapshot.getRef().child("name").setValue(acc.getName(), new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete( DatabaseError error,  DatabaseReference ref) {
                            if(error==null)
                            {
                                kt=0;
                            }
                        }
                    });
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
        return kt;
    }
    public int updateAccountpassword(String id,String newpassword){
        kt=0;
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Account");
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot snapshot,  String previousChildName) {
                if(snapshot.getValue(Account.class).getId().equalsIgnoreCase(id))
                {
                    snapshot.getRef().child("password").setValue(newpassword, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete( DatabaseError error, DatabaseReference ref) {
                            if(error==null)
                            {
                                kt=1;
                            }
                        }
                    });
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
        return kt;
    }
    public int deleteAccount(String id){
        kt=0;
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Account");
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot snapshot,  String previousChildName) {
                if(snapshot.getValue(Account.class).getId().equalsIgnoreCase(id))
                {
                   snapshot.getRef().removeValue(new DatabaseReference.CompletionListener() {
                       @Override
                       public void onComplete(DatabaseError error, DatabaseReference ref) {
                           if(error==null)
                           {
                               kt=1;
                           }
                       }
                   });
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
        return kt;
    }
}
