package com.mycode.sparkspay;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    String Data_Base = "customerdb";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DB_Handler handler = new DB_Handler(this, Data_Base, null, 1);
        Customers a = new Customers();
        a.setSlNo(1);
        a.setName("Subhrajyoti Biswal");
        a.setAcNo("1234567890");
        a.setMob("8339828210");
        a.setEmail("abc123@gmail.com");
        a.setBalance(7000);
        a.setGender("Male");

        Customers b = new Customers();
        b.setSlNo(2);
        b.setName("Sudhansu Behera");
        b.setAcNo("1234567453");
        b.setMob("7978345234");
        b.setEmail("abcd12@gmail.com");
        b.setBalance(9500);
        b.setGender("Male");

        Customers c = new Customers();
        c.setSlNo(3);
        c.setName("Kumar Chand Sahoo");
        c.setAcNo("4563123498");
        c.setMob("8348345272");
        c.setEmail("acbs32@gmail.com");
        c.setBalance(6000);
        c.setGender("Male");

        Customers d = new Customers();
        d.setSlNo(4);
        d.setName("Kailash Sahoo");
        d.setAcNo("9087634528");
        d.setMob("7334123987");
        d.setEmail("dfg23@gmail.com");
        d.setBalance(7000);
        d.setGender("Male");

        Customers e = new Customers();
        e.setSlNo(5);
        e.setName("Rakesh Kumar Sarangi");
        e.setAcNo("4563789724");
        e.setMob("9938563425");
        e.setEmail("xyzs231@gmail.com");
        e.setBalance(8000);
        e.setGender("Male");

        Customers f = new Customers();
        f.setSlNo(6);
        f.setName("Satyanarayan Dalai");
        f.setAcNo("5467287622");
        f.setMob("9348753622");
        f.setEmail("abcdge23@gmail.com");
        f.setBalance(6250);
        f.setGender("Male");

        Customers g = new Customers();
        g.setSlNo(7);
        g.setName("Satyaprakash Acharya");
        g.setAcNo("4563767890");
        g.setMob("8334561234");
        g.setEmail("sgfdt3@gmail.com");
        g.setBalance(6500);
        g.setGender("Male");

        Customers h = new Customers();
        h.setSlNo(8);
        h.setName("Subhashree Biswal");
        h.setAcNo("1234545673");
        h.setMob("7723528210");
        h.setEmail("fstreftt43@gmail.com");
        h.setBalance(12000);
        h.setGender("Female");

        Customers i = new Customers();
        i.setSlNo(9);
        i.setName("Barnalata Samal");
        i.setAcNo("1234567123");
        i.setMob("8339828987");
        i.setEmail("gdhhety1@gmail.com");
        i.setBalance(9000);
        i.setGender("Female");

        Customers j = new Customers();
        j.setSlNo(10);
        j.setName("Subhransu Sekhar Biswal");
        j.setAcNo("9123456789");
        j.setMob("9938654271");
        j.setEmail("adfs123@gmail.com");
        j.setBalance(15000);
        j.setGender("Male");

        if(handler.getCustomer().isEmpty()) {
            handler.addCustomer(a);
            handler.addCustomer(b);
            handler.addCustomer(c);
            handler.addCustomer(d);
            handler.addCustomer(e);
            handler.addCustomer(f);
            handler.addCustomer(g);
            handler.addCustomer(h);
            handler.addCustomer(i);
            handler.addCustomer(j);
        }

        ArrayList<String> allCustomers = new ArrayList<>();
        List<Customers> customers = handler.getCustomer();
        for (Customers elements : customers) {
            allCustomers.add(elements.getName());
        }
        handler.close();
        listView = findViewById(R.id.listView);
        BiswalAdapter ad = new BiswalAdapter(this, R.layout.view_all_customers, allCustomers);
        listView.setAdapter(ad);
    }
}