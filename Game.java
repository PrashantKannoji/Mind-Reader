import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
public class Game extends JFrame implements ActionListener
{
int x, count=1;
Scanner sc= new Scanner(System.in);
JFrame Frame;
JTextField tf;
JLabel jl;
JButton play;
JButton done;
JButton stop;
JButton next;

Game()
{
Frame = new JFrame(" NUMBER GUESSING GAME ");
Frame.setVisible(true);
Frame.setSize(1100,700);
Frame.setLayout(null);
Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Frame.setResizable(true);


jl=new JLabel("*-*-*-*-* MIND READER *-*-*-*-*");
Frame.add(jl);
jl.setBounds(80,80,1200,75);
jl.setFont(new Font("TAHOMA",Font.BOLD,50));
jl.setVisible(true);

play= new JButton("** PLAY **");
play.setBounds(235,430,250,80);
play.setFont(new Font("TAHOMA",Font.BOLD,25));
done= new JButton("** DONE **");
done.setBounds(235,430,250,80);
done.setFont(new Font("TAHOMA",Font.BOLD,25));
done.setVisible(false);
stop=new JButton("** STOP **");
stop.setBounds(500,430,250,80);
stop.setFont(new Font("TAHOMA",Font.BOLD,25));

next= new JButton("** NEXT **");
next.setBounds(235,430,250,80);
next.setFont(new Font("TAHOMA",Font.BOLD,25));
next.setVisible(false);

tf= new JTextField(" WELCOME TO THE MIND READER ");
tf.setFont(new Font("TAHOMA",Font.BOLD,40));
tf.setBounds(150,200,740,80);
tf.setBackground(Color.BLACK);
tf.setForeground(Color.GRAY);

Frame.add(play);
Frame.add(tf);
Frame.add(done);
Frame.add(stop);
Frame.add(next);

Frame.getContentPane().setBackground(Color.DARK_GRAY);
play.setBackground(Color.GREEN);
next.setBackground(Color.CYAN);
stop.setBackground(Color.RED);
done.setBackground(Color.ORANGE);
jl.setForeground(Color.RED);



play.addActionListener(this);
done.addActionListener(this);
stop.addActionListener(this);
next.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==stop)
{
done.setVisible(false);
next.setVisible(false);
play.setText("PLAY");
play.setVisible(true);
tf.setForeground(Color.GRAY);
tf.setText("          THINK  OF  A  NUMBER  ");

count=1;
}
 else if(e.getSource()==play)
{
tf.setForeground(Color.GRAY);
tf.setText("          THINK  OF  A  NUMBER  ");
play.setVisible(false);
next.setVisible(true);
}
 else if(e.getSource()==next&&count==1)
{

tf.setText("       NOW , DOUBLE THE NUMBER  ");
Random y =new Random();
 x = y.nextInt(50);
x=x+x;
count++;
}
 else if(e.getSource()==next&& count==2)
{
tf.setText("    NOW ADD  "+ x +" TO YOUR NUMBER ");
count++;
}
 else if(e.getSource()==next&& count==3)
{
tf.setText("        NOW HALF YOUR NUMBER ");
x=x/2;
count++;
}
 else if(e.getSource()==next&& count==4)
{
tf.setText("        NOW SUBTRACT THE ORIGINAL NUMBER ");
count++;
}
  else if(e.getSource()==next&& count==5)
{
tf.setText("       NOW SQUARE THE NUMBER ");
x=x*x;
done.setVisible(true);
count++;
}
  else if(e.getSource()==done)
{
tf.setForeground(Color.RED);
tf.setText("         IS YOUR NUMBER - "+x);
done.setVisible(false);
play.setText("* PLAY AGAIN *");
play.setVisible(true);
count =1;
}
}

public static void main(String args[])
{
Scanner sc= new Scanner(System.in);
new Game();
}
}