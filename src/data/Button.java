package data;

import java.awt.*;

import javax.swing.JButton;

import conf.Seting;
import frame.Dialog;

import java.awt.event.*;
class Button extends JButton{
    /**
     *
     */
    static int het=Seting.het;
    static int wet=Seting.wet;
    static int cmt;
    static int cnt;
    static int mnu=Seting.mnu;
    static Dialog dig=null;
    private static final long serialVersionUID = 1L;
    int x;
    int y;
    boolean m=false;
    boolean isM=false;
    int mark;
    int r;
    MinMap map=null;
    public void reBuild() {
        mark=0;
        cnt=0;
        cmt=0;
        r=0;
        m=false;
        isM=false;
        setBackground(Color.white);
        setContentAreaFilled(true);
        setText("");
    }
    public Button(int x,int y,MinMap map) {
        this.x=x;
        this.y=y;
        this.map=map;
        reBuild();
        setPreferredSize(new Dimension(Seting.Bw,Seting.Bh));
        addMouseListener(new ActA());
        setFont(new Font("宋体", Font.BOLD,Seting.FontSize));
    }
    public int clik() {

        int ret=map.click(x, y);
        //
        if(isM) {
            return 0;
        }
        isM=true;
        if(ret==0) setContentAreaFilled(false);
        else {
            if(ret==-1) {
                setBackground(Color.red);
                setText("*");
            }
            else setText(ret+"");
        }

        if(ret==0) {
            int [][]dir=Seting.dir;
            int het=Seting.het;
            int wet=Seting.wet;
            for(int i=0;i<8;i++) {
                int nx=x+dir[0][i];
                int ny=y+dir[1][i];
                if(nx>=0 &&nx<het && ny>=0&&ny<wet) {
                    if(map.bt[nx][ny].mark==0)
                        map.bt[nx][ny].clik();
                }
            }
        }
        cnt++;
        System.out.println(cnt);
        return ret;
    }
    class ActA extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(e.getButton()== MouseEvent.BUTTON1){
                if(mark!=0) return ;
                int ret=clik();
                // if lose
                if(ret==-1) {
                    for(int i=0;i<het;i++) {
                        for(int j=0;j<wet;j++) {
                            int x=map.bt[i][j].clik();
                            if(map.bt[i][j].mark==1) {
                                if(x==-1) {
                                    map.bt[i][j].setText("#");
                                    map.bt[i][j].setBackground(Color.green);
                                }
                                else     map.bt[i][j].setText("X");
                            }

                        }
                    }
                }
                //if win
                if(cnt==wet*het-mnu) {
                    if(dig==null) dig=new Dialog(map.game," ",map);
                    //
                    for(int i=0;i<het;i++) {
                        for(int j=0;j<wet;j++) {
                            int x=map.bt[i][j].clik();

                            if(x==-1) {
                                map.bt[i][j].setText("#");
                                map.bt[i][j].setBackground(Color.green);
                            }

                        }


                    }
                    //
                    dig.setVisible(true);
                }
            }
            if(e.getButton()== MouseEvent.BUTTON2){
                //do nothing
            }
            if(e.getButton()==MouseEvent.BUTTON3){

                if(isM) return;
                if(mark==0) cmt++;
                mark++;
                mark%=3;
                //

                if(mark==1) setText("@");
                if(mark==2) setText("?");
                if(mark==0) setText(" ");

                //
                if(mark==0) cmt--;

            }
        }

    }

}