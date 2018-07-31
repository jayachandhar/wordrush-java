package com.github.jayachandhar;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class App extends JFrame implements ActionListener
{
    JFrame f;
    String str;
    String hi[]={"bull","band","kilo","text","rush","rule","dock","milk","king","flip","wage","kind","cool","rain","fine","fall","find","cent","poll","good"};
    static int i=0,j=0;
    String ua=new String();
    JButton b,b1,b2,b3,r,end;
    JLabel la,la1,la2,la3;
    static int[] dn=new int[4];

    App()
    { ImageIcon img=new ImageIcon("target/classes/images/logo.png");
        setIconImage(img.getImage());
        setContentPane(new JLabel(new ImageIcon("target/classes/images/background.jpeg")));
        setTitle("WORDRUSH");
        b=new JButton("");
        b1=new JButton("");
        b2=new JButton("");
        b3=new JButton("");
        r=new JButton("RESET");
        end=new JButton("QUIT");
        la=new JLabel();
        la1=new JLabel();
        la2=new JLabel();
        la3=new JLabel();

        b.setBounds(170,170,50,50);
        b1.setBounds(220,170,50,50);
        b2.setBounds(170,220,50,50);
        b3.setBounds(220,220,50,50);
        r.setBounds(140,320,100,50);
        end.setBounds(240,320,100,50);

        la.setBounds(50,50,15,10);
        la1.setBounds(65,50,15,10);
        la2.setBounds(80,50,15,10);
        la3.setBounds(95,50,15,10);

        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        r.addActionListener(this);
        end.addActionListener(this);

        add(b);
        add(b1);
        add(b2);
        add(b3);
        add(r);
        add(end);
        add(la);
        add(la1);
        add(la2);
        add(la3);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    void rush()
    {
        i=0;
        ua="";
        ran();
        b.setText(String.valueOf(str.charAt(dn[0])));
        b1.setText(String.valueOf(str.charAt(dn[1])));
        b2.setText(String.valueOf(str.charAt(dn[2])));
        b3.setText(String.valueOf(str.charAt(dn[3])));
        la.setText("");
        la1.setText("");
        la2.setText("");
        la3.setText("");
    }

    public void add(String a)
    {
        if(i==0)
        { la.setText(a);
        }

        if(i==1)
        { la1.setText(a);
        }

        if(i==2)
        { la2.setText(a);
        }

        if(i==3)
        { la3.setText(a);
        }
        i++;
    }

    void reset()
    {
        rush();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            ua=ua.concat(b.getText());
            add(b.getText());
            b.setText("");
        }
        if(e.getSource()==b1)
        {
            ua=ua.concat(b1.getText());
            add(b1.getText());
            b1.setText("");
        }
        if(e.getSource()==b2)
        {
            ua=ua.concat(b2.getText());
            add(b2.getText());
            b2.setText("");
        }
        if(e.getSource()==b3)
        {
            ua=ua.concat(b3.getText());
            add(b3.getText());
            b3.setText("");
        }
        if(e.getSource()==r)
        {
            reset();
        }
        if(e.getSource()==end)
        {
            JOptionPane.showMessageDialog(this,"your score :"+j*10);
            System.exit(0);
        }
        check();
    }

    void check()
    {
        if(i>3)
            if(ua.equals(str))
            {
                JOptionPane.showMessageDialog(this,"You are correct");
                next();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"You are wrong");
                reset();
            }
    }

    void next()
    {
        if(j<19)
        {
            j++;
            str=hi[j];
            rush();
        }
    }
    void ran()
    {
        int k=0;
        Random t=new Random();
        for(k=0;k<4;k++)
        {
            dn[0]=t.nextInt(4);
            while(dn[1]==dn[0])
            { dn[1]=t.nextInt(4);
            }
            while(dn[2]==dn[1]||dn[2]==dn[0])
            { dn[2]=t.nextInt(4);
            }
            while(dn[3]==dn[2]||dn[3]==dn[1]||dn[3]==dn[0])
            { dn[3]=t.nextInt(4);
            }
        }
    }

    public static void main(String args[])
    {
        App app=new App();
        app.str=app.hi[0];
        app.rush();
    }
}