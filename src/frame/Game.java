package frame;
import data.MinMap;
import conf.Seting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import conf.Seting;

public class Game extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void begin() {
        // TODO Auto-generated method stub
        new Game().setVisible(true);
    }

    int het=Seting.het;
    int wet=Seting.wet;
    int mnu=Seting.mnu;
    //
    Container con=getContentPane();
    Game(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(Seting.Fw,Seting.Fh);
        setLayout(new FlowLayout(0,0,0));
        MinMap minMap=new MinMap(this);
        JButton button=new JButton("reStart");
        // to ReSize the Button  and a stop button to stop time
        //button.setSize(400,150);
        button.setPreferredSize(new Dimension(400,150));
        //
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                minMap.reStart();
            }
        });
        button.setBackground(Color.green);
        button.setFont(new Font("宋体", Font.BOLD,Seting.FontSize));
        con.add(button);

        //setBounds(100,100,100,100);

    }
}
