package data;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import conf.Seting;
import frame.Game;
public class MinMap {
    //
    //
    //
    int het=Seting.het;
    int wet=Seting.wet;
    int mnu=Seting.mnu;
    //
    public Button bt[][]=new Button[het][wet];
    boolean isM[][]=new boolean[het][wet];
    boolean isC[][]=new boolean[het][wet];
    //
    Game game=null;
    Random rad=new Random();
    public MinMap(Game game) {
        this.game=game;
        for(int i=0;i<het;i++) {
            for(int j=0;j<wet;j++) {
                bt[i][j]=new Button(i,j,this);
            }
        }
        /*
        // a yihuo code  I dont know why i write these codes here
        JButton button=new JButton("reStart");
        // to ReSize the Button  and a stop button to stop time
        //button.setSize(400,150);
        button.setPreferredSize(new Dimension(400,150));
        //
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                reStart();
            }
        });
        //
        */
        Container con=game.getContentPane();
        for(int i=0;i<het;i++) {
            for(int j=0;j<wet;j++) {
                con.add(bt[i][j]);
            }
        }
       //

        reStart();

    }
    public void reStart() {
        //
        // IninButton
        for(int i=0;i<het;i++) {
            for(int j=0;j<wet;j++) {
                bt[i][j].reBuild();
                isM[i][j]=false;
                isC[i][j]=false;
            }
        }
        int k=0;
        while(k<mnu) {
            int x=rad.nextInt();
            int y=rad.nextInt();
            if(x<0) x=-x;
            if(y<0) y=-y;
            x=x%het;
            y=y%wet;
            if(isM[x][y]) continue;
            isM[x][y]=true;
            bt[x][y].m=true;
            k++;
        }
    }
    public int click(int x, int y) {
        // TODO Auto-generated method stub
        int [][]dir=Seting.dir;
        int ret=0;
        if(isC[x][y]) return -2;
        if(isM[x][y]) return -1;
        isC[x][y]=true;
        for(int i=0;i<8;i++) {
            int nx=x+dir[0][i];
            int ny=y+dir[1][i];
            if(nx>=0 &&nx<het && ny>=0&&ny<wet) {
                boolean d=bt[nx][ny].m;
                if(d) ret++;
            }
        }

        bt[x][y].r=ret;
        return ret;
    }
}


