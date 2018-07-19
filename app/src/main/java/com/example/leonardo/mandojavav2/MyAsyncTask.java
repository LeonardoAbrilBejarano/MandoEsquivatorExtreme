package com.example.leonardo.mandojavav2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Leonardo on 08/02/2017.
 */

public class MyAsyncTask extends AsyncTask<Void, Void, Void>
{
    private static int PORT = 1234;     // server details
    private static String HOST = "172.16.6.135";
    private Socket sock;
    private BufferedReader in;     // i/o for the client
    private PrintWriter out;

    @Override
    protected void onPostExecute(Void result) {
        //Task you want to do on UIThread after completing Network operation
        //onPostExecute is called after doInBackground finishes its task.
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Do your network operation here
        try {
            sock = new Socket(HOST, PORT);
            in  = new BufferedReader( new InputStreamReader( sock.getInputStream() ) );
            out = new PrintWriter( sock.getOutputStream(), true );  // autoflush
        }
        catch(Exception e)
        {

            System.out.println(e);
        }
        
        return null;
    }

    public void setIpport(String ip,int port){
        this.HOST=ip;
        this.PORT=port;
    }

    public void right(){
        try {
            out.println("right");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void left(){
        try {
            out.println("left");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void top(){
        try {
            out.println("top");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void bot(){
        try {
            out.println("bot");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

}
