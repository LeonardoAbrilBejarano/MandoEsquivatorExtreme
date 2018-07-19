package com.example.leonardo.mandojavav2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private static int PORT = 1234;     // server details
    private static String HOST = "localhost";
    private MyAsyncTask at;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeContact(View view){

        EditText etip = (EditText) findViewById(R.id.ed1_ip);
        String ip = etip.getText().toString();
        if(ip!=null){
            HOST = ip;
        }
        EditText etport = (EditText) findViewById(R.id.ed2_port);
        String port = etport.getText().toString();
        if(ip!=null){
            PORT = Integer.parseInt(port);
        }
        at = new MyAsyncTask();
        at.setIpport(HOST,PORT);
        at.execute();
    }  // end of makeContact()

    public void sendRight(View view)
    {
        at.right();

    }  // end of sendGet()

    public void sendLeft(View view)
    {
        at.left();
    }  // end of sendGet()

    public void sendTop(View view)
    {
        at.top();
    }  // end of sendGet()

    public void sendBot(View view)
    {
        at.bot();
    }  // end of sendGet()

}
