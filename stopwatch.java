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
        JLabel label=new JLabel("adfsdf");
        boolean bool=false;
        int sayac=0;
        int stopper=2;
    int dakika=0;
    int saat=0;
    @Override
    public void run(){
         try {
             
             while(stopper==0){
                 if(dakika%60==0&&dakika!=0){
                    saat++;
                    dakika=0;
                    sayac=0;
                   
                    label.setText("0"+saat+":0"+dakika+":0"+sayac);
                }
                 if(sayac%60==0&&sayac!=0){
               this.dakika++;
               sayac=0;
              label.setText(dakika+":"+sayac);
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
                 Thread.sleep(1);

             }
     } catch (Exception e) {
     }
    
    }
   
}
public class Stopwatch extends JFrame implements Runnable,ActionListener {
    JLabel start=new JLabel("PRESS TO START");
JButton button=new JButton("START");
JPanel panel=new JPanel();
    int sayac=0;
  trd trd=new trd();
  public Stopwatch(){
        setLayout(null);
        add(start);
        start.setBounds(100, 200, 400, 100);
  add(button);
        button.setBounds(175,300,200,200);
       
        button.setBackground(Color.YELLOW);
            button.addActionListener(this);
            start.setFont(new Font("BOLD",Font.HANGING_BASELINE,40));
            button.setFont(new Font("BOLD",Font.BOLD,15));
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
        trd.label.setBounds(200,200,300,100);
        trd.label.setFont(new Font("ITALIC",Font.ITALIC,50));
         trd.run();
      }
      }
  }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button.getText()=="STOP"){
            trd.stopper=1;
        }
        else if(button.getText()=="START") {
       trd.stopper=0;
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