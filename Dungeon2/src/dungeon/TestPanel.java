package dungeon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestPanel extends JPanel implements KeyListener,MouseListener,ActionListener,Runnable {
    
    JLabel jl = new JLabel();
    
    
    
    public TestPanel(){
        jl.setBounds(0,0, 100,100);
        
        this.setLayout(null);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setBounds(10, 100, 3640, 3340);
        this.setPreferredSize(new Dimension(1500, 1400));
        this.setVisible(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        /*this.requestFocus();
        this.requestFocusInWindow();*/
        this.add(jl);    
        
        
       
    }
    
    //------------Imagenes A usar----------------
    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/VP1_Saki-Mitonoya_idle2.gif"));
    ImageIcon ayane = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/VP1_Ayane-Ikuse_idle.gif"));
    
    ImageIcon Yui_idle = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/Yui_idle.gif"));
    ImageIcon Yui_foward = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/YUI_foward.gif"));
    ImageIcon YUI_sword_HIT = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/YUI_sword_HIT.gif"));
    ImageIcon YUIback = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/YUI-Walk-back-Yui.gif"));
    ImageIcon YUI_jump = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/YUI_jump.gif"));
    ImageIcon YUI_jump_back = new javax.swing.ImageIcon(getClass().getResource("/Fuentes/YUI_jump_back.gif"));
    
    
    //----------------Variables Extra---------------
    boolean Paint_Ayane = false;
    boolean Paint_Saki = true;
    
    int CharX = 0;
    int CharY = 100;
    
    //boolean Char_idle = true;
    boolean Char_foward =false;
    boolean Char_hit = false;
    boolean CharJump = false;
    boolean CharJumBack = false;
    boolean Char_Back = false;
    
    boolean zPressed = false;
    
    @Override
     public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //this.Panel_back.paintIcon(this, g, 0,0);   
            for(int i =20 ;i<601;i=i+20){
                for(int j =20 ;j<301;j=j+20){
                    g.setColor(Color.DARK_GRAY);
                        g.drawRect(i, j, 20, 20);            
            }}
             Anim_Select(g);
    }
     
     //-------------Metodos de Repintados-----------------
    public void Ayane(Graphics g){ 
        ayane.setImageObserver(this);
        ayane.paintIcon(this, g, 0,0);
    }
    
    public void Char_idle (Graphics g){ 
        Yui_idle.setImageObserver(this);
        Yui_idle.paintIcon(this, g, CharX,CharY);
    }
    
    public void Anim_Select (Graphics g){ 
            if(Char_foward == true ){
                //CharX+=3;
                Yui_foward.setImageObserver(this);
                Yui_foward.paintIcon(this, g, CharX,CharY);
            }else if(Char_Back == true ){
                //CharX-=2;
                YUIback.setImageObserver(this);
                YUIback.paintIcon(this, g, CharX,CharY);                
            }else if(CharJump == true ){
                YUI_jump.setImageObserver(this);
                YUI_jump.paintIcon(this, g, CharX,(CharY-50));
            }else if(CharJumBack == true ){
                YUI_jump_back.setImageObserver(this);
                YUI_jump_back.paintIcon(this, g, CharX,CharY);
            }else if(Char_hit == true ){
                YUI_sword_HIT.setImageObserver(this);
                YUI_sword_HIT.paintIcon(this, g, (CharX-75),(CharY-65));
            }else{
                Char_idle(g);
            }          
    }
    
    

    //--------------MEtodos Abastractos del Implemment---------
        
    @Override
    public void keyTyped(KeyEvent ke) {
        
        System.out.println(ke.getKeyCode());
        if(ke.getKeyCode()==KeyEvent.VK_UP){
             jl.setText("putas");
             System.out.println("puts");
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) { 
        /*if(ke.getKeyCode()==KeyEvent.VK_UP){
             CharY -= 21;
             CharJump=true;
        }*/
        
        switch (ke.getKeyCode()) {
        case KeyEvent.VK_UP:
            /*CharY-=3;
            //jl.setText(""+CharX);
            this.setBounds((this.getX()), (this.getY()-5), (this.getWidth()), this.getHeight());*/
            if (!zPressed) {        
                CharJump=true;
                //System.out.println("hola1");
                zPressed = true;
            }
            break;    
        case KeyEvent.VK_LEFT:
            Char_Back=true; 
            CharX-=5;
            //jl.setText(""+CharX);
            this.setBounds((this.getX()+5), this.getY(), (this.getWidth()), this.getHeight());
            break;
        case KeyEvent.VK_RIGHT:            
            Char_foward=true;
            CharX+=5;
            //jl.setText(""+CharX);
            this.setBounds((this.getX()-5), this.getY(), (this.getWidth()), this.getHeight());
            //CharX-=2;
            break; 
        case KeyEvent.VK_DOWN:
            /*CharY+=3;
            //jl.setText(""+CharX);
            this.setBounds((this.getX()), (this.getY()+5), (this.getWidth()), this.getHeight());*/
            break;
        case KeyEvent.VK_D:
            Char_hit=true;
            break;    
        }
        
        /*if((ke.getKeyCode()==KeyEvent.VK_RIGHT)&&(ke.getKeyCode()==KeyEvent.VK_UP)){
            jl.setText("Right y UP");
        }else if((ke.getKeyCode()==KeyEvent.VK_LEFT)&&(ke.getKeyCode()==KeyEvent.VK_UP)){
            jl.setText("Left y UP");
        }else if(ke.getKeyCode()==KeyEvent.VK_UP){            
           jl.setText("hola UP");
        }else {
           jl.setText("me la chupa");
        }*/        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
        switch (ke.getKeyCode()) {
        case KeyEvent.VK_UP:
            CharJump=false;
            zPressed = false;
            break;
        case KeyEvent.VK_LEFT:
            Char_Back=false;
            break;
        case KeyEvent.VK_RIGHT:
            Char_foward=false;
            break;        
        case KeyEvent.VK_D:
            Char_hit=false;
            break;    
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }

    @Override
    public void run() {
      
    }
}
