package com.example.proyecto.time;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

import java.security.MessageDigest;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        System.out.print("KeyHashes"+KeyHashes());
    }

    private String KeyHashes() {
        PackageInfo info;
        String KeyHashes=null;
        try{
            info=getPackageManager().getPackageInfo("com.example.proyecto.time", PackageManager.GET_SIGNATURES);
            for(Signature signature: info.signatures){
                MessageDigest md;
                md=MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                KeyHashes=new String(Base64.encode(md.digest(),0));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return KeyHashes;
    }
}
