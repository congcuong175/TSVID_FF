package com.example.tsvid_ff.Database;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tsvid_ff.Activity.LoginActivity;
import com.example.tsvid_ff.Activity.RegisterActivity;
import com.example.tsvid_ff.Common.ValidateData;
import com.example.tsvid_ff.Entity.Account;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DBContext{
    int kt;
    Account ac;
    public Account getAccount(String id)
    {

        DatabaseReference db=FirebaseDatabase.getInstance().getReference().child("Account");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren())
                {
                    if(snapshot1.getValue(Account.class).getId().equalsIgnoreCase(id))
                    {
                        ac = snapshot1.getValue(Account.class);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return ac;

    }
    public ArrayList<Account> getDataAccount()
    {
        ArrayList<Account> accounts=new ArrayList<>();
        DatabaseReference db= FirebaseDatabase.getInstance().getReference().child("Account");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren())
                {
                    accounts.add(snapshot1.getValue(Account.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        return accounts;
    }
    ValidateData vld=new ValidateData();
    public void addAccount(Account acc,Context context){
        DatabaseReference db= FirebaseDatabase.getInstance().getReference();
        if(vld.checkEmpty(acc.getId()))
        {
            db.child("Account").push().setValue(acc).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(context,"Th??nh c??ng",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
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
                    snapshot.getRef().setValue(acc, new DatabaseReference.CompletionListener() {
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
