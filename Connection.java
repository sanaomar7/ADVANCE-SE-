import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;


public class Connection {

    private static Scanner input;
    private boolean NoConnect;
    private boolean Connect;

    private static Connection instance ;

    public static int counter=0;

    // This private constructor is to prevent this object get instantiated more than once.
    private Connection(){
        NoConnect = true ;
        Connect = false ;
    }

    public static int increment()
    {
        counter++;
        return counter ;
    }

    public static int Decrement()
    {
        counter--;
        return counter ;
    }

    public static void Print(){

    }


    public static List<String> Add(String type){
        List<String> a = new ArrayList<String>();
        a.add(type) ;

        System.out.println(a);
        return a;
    }

    public static boolean connect(){

        int x  = Connection.increment();
        int y = Connection.Decrement() ;
        if (x >= 3 ){
            System.out.println("Cant do the operation you need ");
            return false ;
             }
        return true ;

    }


    public static synchronized Connection getInstance(String type)
    {
        Connection.connect() ;
        Connection.increment() ;

        System.out.println("\n=========================================="+ "\n \n "+"4 ------------ THIS IS " + type + " client ------------");
        Add(type) ;

        if(instance == null ){
            instance = new Connection();
            System.out.println("\n---> 1 Creating a new connection instance");

        }
        return instance ;

    }





    public static void release(  ) {

        if (instance == null ){
            System.out.println("2 release METHODE Already the instance was Empty ");
        }
        else {
            Connection.Decrement();
            instance = null ;
            System.out.println("2 release METHODE instance will be destroyed  ");
        }
    }




    public static void main (String args[])  {


        String T = "TELNET";
        String SS = "SSH" ;
        String H = "HTTP";
        String SC = "SCP" ;
        String F= "FTP" ;
        final String[] EMPTY_ARRAY = new String[0];




        Connection.release();
        /********************************************************************/


        Connection HTTP1 = Connection.getInstance( H ) ;



        Connection HTTP2 = Connection.getInstance( H );



        if (HTTP1 == HTTP2 ){
            System.out.println("--> HTTP1 AND HTTP2 ARE SAME CONNECTION ") ;
        }

        /********************************************************************/


        Connection.release();

        /********************************************************************/

        Connection TELNET = Connection.getInstance(T) ;
        Connection Tel = Connection.getInstance(T) ;
        Connection Ft = Connection.getInstance(F) ;
        /********************************************************************/


        
    }
}
