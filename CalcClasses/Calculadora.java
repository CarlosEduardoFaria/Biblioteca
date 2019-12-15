
package calculadora;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends Applet{
 Panel p0, p1;
 TextField tf;
 String sn1, sn2;
 OperacaoMatematica op;
 
 Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bmais, bmenos, bmult, bdiv, bigual, bc;
 char num = ' '; 
        
 public void init()
 { p0 = new Panel(); //painel para o display
 tf = new TextField (10);
 p0.add(tf); //adiciona tf ao painel p0
   
 add ( p0, "North"); //adiciona p0 acima
 p1 = new Panel(); //painel para o teclado
 GridLayout g = new GridLayout(5, 5, 10, 10);
//layout com 5 lin, 3 col e espaçamento 10
 p1.setLayout(g); //aplica layout g a p1
//botões numéricos
//b1=new Button("1"); b1.addActionListener(this);
b1 = new Button ("1");
b1.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '1';
            tf.setText(tf.getText()+ num);
    }
}
);
b2=new Button("2"); 
b2.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '2';
            tf.setText(tf.getText()+ num);
    }
});
b3=new Button("3"); 
b3.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '3';
            tf.setText(tf.getText()+ num);
    }
});
b4=new Button("4");
b4.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '4';
            tf.setText(tf.getText()+ num);
    }
});
b5=new Button("5");
b5.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '5';
            tf.setText(tf.getText()+ num);
    }
});
b6=new Button("6");
b6.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '6';
            tf.setText(tf.getText()+ num);
    }
});
b7=new Button("7"); 
b7.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '7';
            tf.setText(tf.getText()+ num);
    }
});
b8=new Button("8"); 
b8.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '8';

            tf.setText(tf.getText()+ num);
    }
});
b9=new Button("9");
b9.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '9';
            tf.setText(tf.getText()+ num);
    }
});

b0=new Button("0");
b0.addActionListener(new ActionListener(){
    public void actionPerformed (ActionEvent e){
        num = '0';
            tf.setText(tf.getText()+ num);
    }
});
//botões das funções
 bmais = new Button("+");
 bmais.addActionListener(new ActionListener(){
     public void actionPerformed (ActionEvent e){
         //op = '+';
         sn1 = tf.getText();
         tf.setText("");//aspas sem conteúdo
         op = new Somar();
     }
 });
 
 bmenos = new Button ("-");
 bmenos.addActionListener(new ActionListener(){
     public void actionPerformed (ActionEvent e){
         //op = '-';
         sn1 = tf.getText();
         tf.setText("");//aspas sem conteúdo
         op = new Subtrair();
     }
 });
 
 bmult = new Button ("*");
 bmult.addActionListener(new ActionListener(){
     public void actionPerformed (ActionEvent e){
         //op = '*';
         sn1 = tf.getText();
         tf.setText("");//aspas sem conteúdo
         op = new Multiplicar();
     }
 });
 bdiv = new Button ("/");
 bdiv.addActionListener(new ActionListener(){
     public void actionPerformed (ActionEvent e){
         //op = '/';
         sn1 = tf.getText();
         tf.setText("");//aspas sem conteúdo
         op = new Dividir();
     }
 });
 
 bigual = new Button("=");
 bigual.addActionListener(new ActionListener(){
     public void actionPerformed (ActionEvent e){
     sn2 = tf.getText();
     Double n1 = Double.parseDouble(sn1), n2 = Double.parseDouble(sn2);
             tf.setText (Double.toString(op.Calcular(n1,n2)));
     }
 });
 
 bc = new Button("c");
 bc.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
         sn1 = "0";         
         tf.setText("");
     }
 });

 //adicionando ao painel
 p1.add(b1); p1.add(b2); p1.add(b3);
 p1.add(b4); p1.add(b5); p1.add(b6);
 p1.add(b7); p1.add(b8); p1.add(b9); p1.add(b0);
 p1.add(bmais);p1.add(bmenos); p1.add(bmult); p1.add(bdiv);
 p1.add(bigual); p1.add(bc);

 add (p1, "East"); //adiciona p1 a direita
 } //init
}//Applet

