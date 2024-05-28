
package stopwatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class trd  implements Runnable{
        JLabel label=new JLabel("");
        int sayac=0;
        int stopper=2;
    int dakika=0;
    int saat=0;
    int pauser=0;
    @Override
    public void run(){
         try {
             
             while(stopper==0){
                while(pauser==1){
                     System.out.print("");     
                }
                 if(dakika%60==0&&dakika!=0){
                    saat++;
                    dakika=0;
                    sayac=0;
                }
                 if(sayac%60==0&&sayac!=0){
               this.dakika++;
               sayac=0;
          }
                 if(saat<10&&sayac<10&&dakika<10){
                     label.setText("0"+saat+":0"+dakika+":0"+sayac);
                 }
                 else if(saat<10&&sayac<10&&dakika>=10){
                     label.setText("0"+saat+":"+dakika+":0"+sayac);
                 }
                 else if(saat<10&&sayac>=10&&dakika<10){
                     label.setText("0"+saat+":0"+dakika+":"+sayac);
                 }
                 else if(saat<10&&sayac>=10&&dakika>=10){
                     label.setText("0"+saat+":"+dakika+":"+sayac);
                 }
                else if(saat>=10&&sayac<10&&dakika<10){
                     label.setText(saat+":0"+dakika+":0"+sayac);
                 }
                 else if(saat>=10&&sayac<10&&dakika>=10){
                     label.setText(saat+":"+dakika+":0"+sayac);
                 }
                 else if(saat>=10&&sayac>=10&&dakika<10){
                     label.setText(saat+":0"+dakika+":"+sayac);
                 }
                 else if(saat>=10&&sayac>=10&&dakika>=10){
                     label.setText(saat+":"+dakika+":"+sayac);
                 }
         sayac++;
                 Thread.sleep(1000);
             }
     } catch (Exception e) {
     }
    }
}
public class Stopwatch extends JFrame implements Runnable,ActionListener {
    JLabel start=new JLabel("PRESS TO START");
JButton button=new JButton("START");
JButton button2=new JButton("LAP");
JButton button3=new JButton("PAUSE");
JLabel lap=new JLabel("1.00:00:00");
JLabel lap2=new JLabel("2.00:00:00");
    int sayac=0;
  trd trd=new trd();
  public Stopwatch(){
        setLayout(null);
        add(button2);
        button2.setBounds(225,300,150,150);
        button2.addActionListener(this);
        add(button3);
        button3.setBounds(25,300,150,150);
        button3.addActionListener(this);
        add(start);
        start.setBounds(100, 200, 400, 100);
  add(button);
  add(lap);
  lap.setBounds(200,0,200,200);
        button.setBounds(425,300,150,150);
       add(lap2);
       lap2.setBounds(200,75,200,200);
        lap.setFont(new Font("BOLD",Font.HANGING_BASELINE,30));
        lap2.setFont(new Font("BOLD",Font.HANGING_BASELINE,30));
            button.addActionListener(this);
            start.setFont(new Font("BOLD",Font.HANGING_BASELINE,40));
            button.setFont(new Font("BOLD",Font.BOLD,20));
  }
  @Override
  public void run(){
      while(true){
      while(trd.stopper!=0){
          button.setText("START");
          trd.label.setText("");
         start.setText("PRESS TO START");
         trd.saat=0;
         trd.dakika=0;
         trd.sayac=0;
      }
      while(trd.stopper==0){
     start.setText("");
     button.setText("STOP");
        add(trd.label);
        trd.label.setBounds(175,200,300,100);
        trd.label.setFont(new Font("ITALIC",Font.ITALIC,50));
         trd.run();
      }
      }
  }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
        if(button.getText().equals("STOP")){
            trd.stopper=1;
        }
        else if(button.getText().equals("START")) {
       trd.stopper=0;
        }
        }
        else if(e.getSource()==button2){
            if(!lap.getText().equals("")){
                lap2.setText("2."+lap.getText().substring(2));
                lap.setText("1."+trd.label.getText());
            }
            lap.setText("1."+trd.label.getText());
        }
        else if(e.getSource()==button3&&button3.getText().equals("PAUSE")){
           
            trd.pauser=1;
            button3.setText("UNPAUSE");
        }
        else if(e.getSource()==button3&&button3.getText().equals("UNPAUSE")){
            trd.pauser=0;
            button3.setText("PAUSE");
        }
    }
    public static void main(String[] args) {
        Stopwatch s=new Stopwatch();
        Thread thread2=new Thread(s);
            thread2.start();
        s.setVisible(true);
        s.setSize(600,600);
        s.setResizable(false);
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
       s.setTitle("Chronometer");
       s.setLocation(700,200);
    }
}
