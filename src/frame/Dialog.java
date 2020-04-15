package frame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import data.MinMap;

public class Dialog extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Dialog(Game window,String str,MinMap map){
        super(window,str,true);
        Container container=getContentPane();
        Button button=new Button(map,this);
        container.add(button);
        setBounds(120, 120,100,100);


    }
}
class Button extends JButton{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    MinMap map=null;
    Dialog dig=null;
    Button(MinMap map,Dialog dig){
        super();
        this.map=map;
        this.dig=dig;
        addActionListener(new Act());
    }
    class Act implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            map.reStart();
            System.out.println("@@@@");
            dig.setVisible(false);
        }

    }
}
