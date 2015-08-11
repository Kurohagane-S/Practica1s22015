
package dungeon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Select extends javax.swing.JFrame implements ActionListener{
    
    TestPanel TestP = new TestPanel();    
    
    DoubleList dl = new DoubleList();
    ListaObjetos ObjetosAdded;//    
    
    String[][] MatrizLogica;
    String DireccionTxt = "";
    String FileName = "\\graphTest.txt";
    
    JPanel jp = new JPanel();   
    JScrollPane scrollFrame = new JScrollPane(jp);  
    boolean Colas = false;
    boolean Pilas = false;
    boolean LastoDraw = false;
    boolean FristDraw = false;
    
    int rows = 4;
    int columns= 5;
    
    public Select() {         
        initComponents(); 
        this.add(TestP); 
        TestP.requestFocusInWindow();     
        /*panelBuild();
        MatrizLogicaButt(); 
        this.add(scrollFrame);*/
        
        
            /*jPanel1.setEnabled(false);
            jPanel1.setVisible(false);
            jPanel2.setEnabled(false);
            jPanel2.setVisible(false);
            jPanel3.setEnabled(false);
            jPanel3.setVisible(false); */ 
            jPanel4.disable();
            jPanel4.hide();
        
        TestP.setEnabled(false);
        TestP.setVisible(false);        
        
        //this.add(jp);
    }
        
    public void panelBuild(){
        jp.setBounds(0, 0, 500, 500);
        jp.setLayout( null);
        jp.setBackground(new java.awt.Color(255, 255, 255));   
        jp.setEnabled(true);
        jp.setVisible(true);        
        //jp.setPreferredSize(new Dimension( 500,500));        
        jp.setAutoscrolls(true);
        MatrizLogicaButt(); 
        //scrollFrame.setPreferredSize(new Dimension( 800,300));
        scrollFrame.setBounds(15, 110, 765, 400);
        scrollFrame.setVisible(true);
    }
       
    
    public void MatrizLogicaButt(){
        try{
            rows  = Integer.parseInt(filastxt.getText());
            columns = Integer.parseInt(colTxt.getText());
        }catch(Exception e){
            System.out.println(e.toString());
            rows = 4;
            columns= 5;
        }
        
        MatrizLogica = new String[rows][columns];
        
        for(int i=rows-1;i>=0;i--)
        {
            for(int j=columns-1;j>=0;j--)
            {          
                JButton btn = new JButton(String.valueOf(i)+ "," +String.valueOf(j) );
                btn.setName(String.valueOf(i)+ "," +String.valueOf(j) );
                if(i==1 && j==1){
                    btn.setBackground(Color.yellow);
                    btn.setText("Character");
                }
                if(i==2 && j==1){
                    btn.setBackground(Color.yellow);
                    btn.setText("Character");
                }
                btn.setBounds((40+j*80),((rows*50)-50*i), 70, 45);
                btn.setVisible(true);
                //System.out.println(btn.getText());
                    if(i==0 && j==0 ){
                    //System.out.println(" X " + (50+15*57) +" Y "+(50+57*15));
                    jp.setPreferredSize(new Dimension(100+columns*80,100+60*rows));
                    }                    
                btn.addActionListener(this);
                jp.add(btn);
                try{
                MatrizLogica[i][j] = btn.getText();
                }catch(Exception e){
                    System.out.println(e.toString());
                }
            }
        }
    }
    
    public void GraphicarGraphViz(){
        try {
      
        String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
        String Putas = FileName.replace("txt", "jpg");
        
        String fileInputPath = DireccionTxt + "\\" +FileName;
        String fileOutputPath = DireccionTxt + "\\"+ Putas;
      
        String tParam = "-Tjpg";
        String tOParam = "-o";
        
        String[] cmd = new String[5];
        cmd[0] = dotPath;
        cmd[1] = tParam;
        cmd[2] = fileInputPath;
        cmd[3] = tOParam;
        cmd[4] = fileOutputPath;
                  
        Runtime rt = Runtime.getRuntime();
      
        rt.exec( cmd );
      
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
        }
    }
    
    public void llenar(){
         //String record;
         String direccion = "";
         JFileChooser fc = new JFileChooser("./");
         //JFileChooser fc = new JFileChooser("C:\\Users\\Squall\\Documents");         
         FileNameExtensionFilter CSV_TXT=new FileNameExtensionFilter("txt","TXT");
         fc.setFileFilter(CSV_TXT); 
         //fc.setSelectedFile(new File("pussy.txt"));
         fc.setSelectedFile(new File(""));
         int respuesta = fc.showOpenDialog(this);         
         File archivoElegido = null ;
         if (respuesta == JFileChooser.APPROVE_OPTION)
         {             
             archivoElegido = fc.getSelectedFile(); 
             
             if(!archivoElegido.getPath().equals("")){
                direccion = archivoElegido.getPath();
                DireccionTxt = archivoElegido.getParent();
                //DireccionTxt = direccion;
                try{        
                    FileReader in = new FileReader (direccion);
                    //FileReader in = new FileReader ("C:\\Users\\Cloud\\Documents\\NetBeansProjects\\Empresa\\Usuarios.csv");
                    BufferedReader bin = new BufferedReader(in); 
                   /* while((record = bin.readLine()) != null){
                    //area.append(record + "\n");             
                    }*/
                bin.close();
                in.close();               
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"en algo la cagaste!!");
                }
                } else {}
             
         }
         else if(respuesta == JFileChooser.CANCEL_OPTION){
             
         }
    
    }
    
    public void SaveDialog(String texto){
        try{
            
        JFileChooser jFileC = new JFileChooser("./");
        jFileC.setSelectedFile(new File("Nombre.txt"));
        FileNameExtensionFilter CSV_TXT=new FileNameExtensionFilter("txt","TXT");
        jFileC.setFileFilter(CSV_TXT);
        //jFileC.showSaveDialog(null);
        //String url = jFileC.getName(null);
        int respuesta = jFileC.showSaveDialog(this);
         //Comprobar si se ha pulsado Aceptar
        File archivoElegido = null ;
         if (respuesta == JFileChooser.APPROVE_OPTION)
         {             
             archivoElegido = jFileC.getSelectedFile();  
             DireccionTxt = archivoElegido.getParent();
             FileName = archivoElegido.getName();
         }
         else if(respuesta == JFileChooser.CANCEL_OPTION){
         
         }
        String newFile = archivoElegido.getPath();
        File file = new File(newFile);
        //File file = new File("./");
        
            if(file.exists()==false){
            file.createNewFile();}
            PrintWriter fileName = new PrintWriter(file);            
            BufferedWriter output = new BufferedWriter(fileName);                
                output.write(texto);
                output.close();
                                     
            }catch(Exception e){
                //jop.showMessageDialog(null,"IOException ESA DIRECCION NO EXISTE!!");
            }   
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Add_Suelo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Add_Pared = new javax.swing.JButton();
        Add_MBoss = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Add_Enemy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Add_Coin = new javax.swing.JButton();
        Add_life = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        NameChar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ViewListButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        AntButton = new javax.swing.JButton();
        SigButton = new javax.swing.JButton();
        DelButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ElementoTxt = new javax.swing.JTextField();
        filastxt = new javax.swing.JTextField();
        colTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        GraphVizMatrix = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        GamePanel = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        PlayGame = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/spinning_coin.gif"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 200, 110, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/Metalfloor_100.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 80, 50);

        Add_Suelo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Add_Suelo.setText("Add Suelo");
        Add_Suelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_SueloActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Suelo);
        Add_Suelo.setBounds(130, 30, 140, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/42_Bricks_Dk.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 20, 80, 50);

        Add_Pared.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Add_Pared.setText("Add Pared");
        Add_Pared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ParedActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Pared);
        Add_Pared.setBounds(420, 30, 140, 40);

        Add_MBoss.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Add_MBoss.setText("Add Mini Boss");
        Add_MBoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_MBossActionPerformed(evt);
            }
        });
        jPanel1.add(Add_MBoss);
        Add_MBoss.setBounds(420, 120, 140, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/Charizard-12.gif"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 80, 110, 100);

        Add_Enemy.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Add_Enemy.setText("Add Enemy");
        Add_Enemy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_EnemyActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Enemy);
        Add_Enemy.setBounds(130, 120, 140, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/Enemy_one.gif"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(-10, 90, 140, 90);

        Add_Coin.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Add_Coin.setText("Add Coin");
        Add_Coin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_CoinActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Coin);
        Add_Coin.setBounds(130, 220, 140, 40);

        Add_life.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        Add_life.setText("Add Life");
        Add_life.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_lifeActionPerformed(evt);
            }
        });
        jPanel1.add(Add_life);
        Add_life.setBounds(420, 220, 140, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/195_icon.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(320, 200, 60, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 10, 570, 290);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        NameChar.setForeground(new java.awt.Color(102, 102, 102));
        NameChar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NameChar.setText("Yui");

        jLabel7.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Main Character");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/YUi_face.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameChar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NameChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(580, 10, 210, 580);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fuentes/WoodCastleDoor2.png"))); // NOI18N
        jPanel3.add(jLabel8);
        jLabel8.setBounds(20, 0, 300, 260);

        ViewListButton.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        ViewListButton.setText("Ver Lista");
        ViewListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewListButtonActionPerformed(evt);
            }
        });
        jPanel3.add(ViewListButton);
        ViewListButton.setBounds(350, 20, 170, 40);

        jTextField1.setEditable(false);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(350, 80, 170, 20);

        AntButton.setText("Ant");
        AntButton.setEnabled(false);
        AntButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntButtonActionPerformed(evt);
            }
        });
        jPanel3.add(AntButton);
        AntButton.setBounds(360, 120, 49, 23);

        SigButton.setText("Sig");
        SigButton.setEnabled(false);
        SigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigButtonActionPerformed(evt);
            }
        });
        jPanel3.add(SigButton);
        SigButton.setBounds(460, 120, 47, 23);

        DelButton.setText("Delete this Node");
        DelButton.setEnabled(false);
        DelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelButtonActionPerformed(evt);
            }
        });
        jPanel3.add(DelButton);
        DelButton.setBounds(370, 160, 120, 30);

        jButton1.setText("View FULL list");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(370, 200, 120, 23);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 310, 570, 280);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(800, 100));
        jPanel4.setMinimumSize(new java.awt.Dimension(800, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel4.setLayout(null);

        jButton2.setText("Colas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(110, 50, 90, 30);

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(510, 60, 67, 23);

        ElementoTxt.setText("elemento");
        jPanel4.add(ElementoTxt);
        ElementoTxt.setBounds(110, 20, 201, 20);

        filastxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filastxt.setText("4");
        jPanel4.add(filastxt);
        filastxt.setBounds(440, 30, 90, 20);

        colTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        colTxt.setText("5");
        jPanel4.add(colTxt);
        colTxt.setBounds(560, 30, 90, 20);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Filas");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(420, 10, 80, 14);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Columnas");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(550, 10, 110, 14);

        jButton3.setText("Pilas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(220, 50, 90, 30);

        GraphVizMatrix.setText("Graphviz");
        GraphVizMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphVizMatrixActionPerformed(evt);
            }
        });
        jPanel4.add(GraphVizMatrix);
        GraphVizMatrix.setBounds(10, 10, 80, 70);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 800, 100);

        jMenu1.setText("File");

        jMenuItem1.setText("No deberias ver esto PUTO!");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Esta mierda no hace NADA!");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("PLAY GAME");

        GamePanel.setText("Create GamePanel");
        GamePanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GamePanelActionPerformed(evt);
            }
        });
        jMenu2.add(GamePanel);

        jMenuItem4.setText("View Full List");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        PlayGame.setText("Play the Fucking Game!");
        PlayGame.setEnabled(false);
        jMenu2.add(PlayGame);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");

        jMenuItem3.setText("Crear Reporte Lista");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Add_SueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_SueloActionPerformed
        if(dl.estavacio()==true){
            dl.SetObjeto("Suelo");            
            ObjetosAdded=dl.primero;
        }else{
            dl.SetObjeto("Suelo");        
        }       
        
        //System.out.println(ObjetosAdded.getName());
    }//GEN-LAST:event_Add_SueloActionPerformed

    private void Add_lifeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_lifeActionPerformed
       
       if(dl.estavacio()==true){
            dl.SetObjeto("Life");
            ObjetosAdded=dl.primero;
        }else{
            dl.SetObjeto("Life");    
        }   
       //System.out.println(ObjetosAdded.getName());
    }//GEN-LAST:event_Add_lifeActionPerformed

    private void Add_ParedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ParedActionPerformed
        
        if(dl.estavacio()==true){
            dl.SetObjeto("Wall");
            ObjetosAdded=dl.primero;
        }else{
            dl.SetObjeto("Wall");       
        }   
        //System.out.println(ObjetosAdded.getName());
    }//GEN-LAST:event_Add_ParedActionPerformed

    private void Add_EnemyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_EnemyActionPerformed
       
       if(dl.estavacio()==true){
            dl.SetObjeto("Enemy");
            ObjetosAdded=dl.primero;
        }else{
            dl.SetObjeto("Enemy");   
        }   
       //System.out.println(ObjetosAdded.getName());
    }//GEN-LAST:event_Add_EnemyActionPerformed

    private void Add_MBossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_MBossActionPerformed
        
        if(dl.estavacio()==true){
            dl.SetObjeto("Mini_Boss");
            ObjetosAdded=dl.primero;
        }else{
            dl.SetObjeto("Mini_Boss"); 
        }   
        //System.out.println(ObjetosAdded.getName());
    }//GEN-LAST:event_Add_MBossActionPerformed

    private void Add_CoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_CoinActionPerformed
        
        if(dl.estavacio()==true){
            dl.SetObjeto("Coin");
            ObjetosAdded=dl.primero;
        }else{
            dl.SetObjeto("Coin");
        }   
        //System.out.println(ObjetosAdded.getName());
    }//GEN-LAST:event_Add_CoinActionPerformed

    private void AntButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntButtonActionPerformed
        ObjetosAdded=ObjetosAdded.anterior;//lo mueve al anterior
        //System.out.println("NombreAnterior: "+NodoActual.Name);
        if(!ObjetosAdded.Name.contains("Deleted")){
            
            jTextField1.setText(""+ObjetosAdded.Name);
        }else{
             ObjetosAdded=ObjetosAdded.anterior;
             jTextField1.setText(""+ObjetosAdded.Name);
         } 
    }//GEN-LAST:event_AntButtonActionPerformed

    private void ViewListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewListButtonActionPerformed
        /*NodoActual=dl.primero;//fija el nodo al inicio de la lista
        //System.out.println("NombreActual: "+NodoActual.Name);
        Name_texto.setText(""+NodoActual.Name);
        ID_texto.setText(""+NodoActual.ID);*/
        
        if(dl.estavacio() == false){
            ObjetosAdded=dl.primero;
            AntButton.setEnabled(true);
            SigButton.setEnabled(true);
            DelButton.setEnabled(true);
            jButton1.setEnabled(true);
            //GamePanel.setEnabled(true);
            
            jTextField1.setText(ObjetosAdded.Name); 
            /*
            dl.imprimirNombre();
            dl.imprimirObjetos();*/
            
            
            
        }      
        
        
    }//GEN-LAST:event_ViewListButtonActionPerformed

    private void SigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigButtonActionPerformed
        ObjetosAdded=ObjetosAdded.siguiente;// lo mueve al siguiente
        //System.out.println("NombreSiquiente: "+NodoActual.Name);              
         if(!ObjetosAdded.Name.contains("Deleted")){
            
            jTextField1.setText(""+ObjetosAdded.Name);
        }else{
             ObjetosAdded=ObjetosAdded.siguiente;
             jTextField1.setText(""+ObjetosAdded.Name);
         } 
    }//GEN-LAST:event_SigButtonActionPerformed

    private void DelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelButtonActionPerformed
        if(!ObjetosAdded.Name.contains("Deleted")){
            ObjetosAdded.Name = ObjetosAdded.Name+"Deleted";  
            ObjetosAdded=ObjetosAdded.siguiente;
            jTextField1.setText(""+ObjetosAdded.Name);
        }else{} 
    }//GEN-LAST:event_DelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame FrameLista = new JFrame();
        JTextArea FrameT_Area = new JTextArea();
        
        FrameT_Area.setBounds(0,0,400,300);
        FrameT_Area.setVisible(true);
        FrameT_Area.setEditable(false);
        dl.AreaObjetos(FrameT_Area);
        
        
        FrameLista.setTitle("Lista Completa");
        FrameLista.setSize(400, 300);
        FrameLista.setResizable(false);
        FrameLista.setLocationRelativeTo(null);
        FrameLista.setVisible(true);
        FrameLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FrameLista.add(FrameT_Area);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       JOptionPane.showMessageDialog(null, "Te dije que esta pendejada \n NO HACE NADA IMBECIL DE MIERDA!! \n Aprende a Leer!!");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void GamePanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GamePanelActionPerformed
        /*if(TestP.isEnabled()==false){
            jPanel1.setEnabled(false);
            jPanel1.setVisible(false);
            jPanel2.setEnabled(false);
            jPanel2.setVisible(false);
            jPanel3.setEnabled(false);
            jPanel3.setVisible(false);        
        
            TestP.setEnabled(true);
            TestP.setVisible(true);
            TestP.requestFocus();
            TestP.requestFocusInWindow();
            
        }*/
        if(!dl.estavacio()){
         jPanel1.setEnabled(false);
            jPanel1.setVisible(false);
            jPanel2.setEnabled(false);
            jPanel2.setVisible(false);
            jPanel3.setEnabled(false);
            jPanel3.setVisible(false); 
            jPanel4.enable();
            jPanel4.show();}
        
        
    }//GEN-LAST:event_GamePanelActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       ImageIcon icon = new ImageIcon(getClass().getResource("/Fuentes/VP1_Saki-Mitonoya_idle2.gif"));
                /*JOptionPane.showMessageDialog(
                        null,
                        "Hello world",
                        "Hello", JOptionPane.INFORMATION_MESSAGE,
                        icon);*/
                JOptionPane.showMessageDialog(
                        null,
                        new JLabel("", icon, JLabel.LEFT),
                        "Hello", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
            
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ObjetosAdded = dl.primero;
        LastoDraw = false;
        Colas = true;
        ElementoTxt.setText(ObjetosAdded.Name);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jp.removeAll();
        jp.disable();
        jp.hide();
        jp.invalidate();
        scrollFrame.removeAll();
        scrollFrame.disable();
        scrollFrame.hide();
        scrollFrame.invalidate();
        jp = null;
        scrollFrame =null;
        jp = new JPanel();   
        scrollFrame = new JScrollPane(jp);
        panelBuild();
        this.add(scrollFrame);
        
        Pilas = false;
        Colas = false;
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String Texto2 = "";        
        Texto2 = dl.List_to_JPG(Texto2);
        
        if(!Texto2.equals("")){
            SaveDialog(Texto2);
            //System.out.println(DireccionTxt);
            //System.out.println(FileName);
            GraphicarGraphViz();
        }
        
        //System.out.println(Texto2);
        
        /*llenar();
        System.out.println(DireccionTxt);
        GraphicarGraphViz();*/
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ObjetosAdded = dl.ultimo;
        FristDraw = false;
        Pilas = true;
        ElementoTxt.setText(ObjetosAdded.Name);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void GraphVizMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphVizMatrixActionPerformed
       String Texto3 = "";          
        
        //System.out.println ("Recorrido Reverse\n");
        Texto3 = "";
        Texto3 = "digraph G \n" +
                "{ \n"+ " node [shape=circle];\n" +
                        " node [style=filled];\n" +
                        " node [fillcolor=\"#EEEEEE\"];\n" +
                        " node [color=\"#EEEEEE\"];\n" +
                        " edge [color=\"#31CEF0\"];\n";   
        
        
        
                    for (int i=MatrizLogica.length-1; i>=0; i--) {
                        for (int j=0; j<MatrizLogica[0].length; j++){
                            if((i == (0)&&(j==(MatrizLogica[0].length-1)))){
                                System.out.println("hola");
                            }else{
                                Texto3 += i+","+j+" "+MatrizLogica[i][j]  + " ->" + "\n";
                            }
                        }                        
                    }
                    
        Texto3 += ";\nrankdir=LR;\n" +
        "}" ;
        
        System.out.println(Texto3);
        /*
        if(!Texto3.equals("")){
            SaveDialog(Texto3);
            //System.out.println(DireccionTxt);
            //System.out.println(FileName);
            GraphicarGraphViz();
        }*/
    }//GEN-LAST:event_GraphVizMatrixActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       if(!dl.estavacio()){
           JFrame FrameLista = new JFrame();
        JTextArea FrameT_Area = new JTextArea();
        
        FrameT_Area.setBounds(0,0,400,300);
        FrameT_Area.setVisible(true);
        FrameT_Area.setEditable(false);
        dl.AreaObjetos(FrameT_Area);
        
        
        FrameLista.setTitle("Lista Completa");
        FrameLista.setSize(400, 300);
        FrameLista.setResizable(false);
        FrameLista.setLocationRelativeTo(null);
        FrameLista.setVisible(true);
        FrameLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FrameLista.add(FrameT_Area);
       }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Select().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Coin;
    private javax.swing.JButton Add_Enemy;
    private javax.swing.JButton Add_MBoss;
    private javax.swing.JButton Add_Pared;
    private javax.swing.JButton Add_Suelo;
    private javax.swing.JButton Add_life;
    private javax.swing.JButton AntButton;
    private javax.swing.JButton DelButton;
    private javax.swing.JTextField ElementoTxt;
    private javax.swing.JMenuItem GamePanel;
    private javax.swing.JButton GraphVizMatrix;
    private javax.swing.JTextField NameChar;
    private javax.swing.JMenuItem PlayGame;
    private javax.swing.JButton SigButton;
    private javax.swing.JButton ViewListButton;
    private javax.swing.JTextField colTxt;
    private javax.swing.JTextField filastxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
         if( ae.getSource() instanceof JButton) {
            //((JButton)ae.getSource()).setBackground(Color.red);
            //((JButton)ae.getSource()).setText(ElementoTxt.getText());
            /*String string = "004-034556";
            String[] parts = string.split("-");
            String part1 = parts[0]; // 004
            String part2 = parts[1]; // 034556*/
             
            String str;
             if(Colas == true){
                 
            if(ObjetosAdded != dl.ultimo){
                
                str = ((JButton)ae.getSource()).getName();
                String[] parts = str.split(",");
                int part1 = Integer.parseInt(parts[0]); // 004
                int part2 = Integer.parseInt(parts[1]); // 034556
                
                MatrizLogica[part1][part2] = ObjetosAdded.Name;
                
                
                ((JButton)ae.getSource()).setBackground(Color.red);
                ((JButton)ae.getSource()).setText(ElementoTxt.getText());
                
                ObjetosAdded = ObjetosAdded.siguiente;
                ElementoTxt.setText(ObjetosAdded.Name);
                
                
            }else if(ObjetosAdded == dl.ultimo ){                
                if(LastoDraw == false){              
                    str = ((JButton)ae.getSource()).getName();
                    String[] parts = str.split(",");
                    int part1 = Integer.parseInt(parts[0]); // 004
                    int part2 = Integer.parseInt(parts[1]); // 034556
                
                    MatrizLogica[part1][part2] = ObjetosAdded.Name;  
                    
                    ((JButton)ae.getSource()).setBackground(Color.red);
                    ((JButton)ae.getSource()).setText(ElementoTxt.getText());
                    LastoDraw = true;                
                    ElementoTxt.setText(ObjetosAdded.Name);
                    
                    System.out.println ("Recorrido Reverse\n");
                    for (int i=MatrizLogica.length-1; i>=0; i--) {
                        for (int j=0; j<MatrizLogica[0].length; j++){
                            System.out.print ("    " + MatrizLogica[i][j]);    
                        }
                    System.out.println ("");
                    }
                                      
                }          
            }else{
                      
             
            }
             
             }else if(Pilas == true){
                 if(ObjetosAdded != dl.primero){
                
                str = ((JButton)ae.getSource()).getName();
                String[] parts = str.split(",");
                int part1 = Integer.parseInt(parts[0]); // 004
                int part2 = Integer.parseInt(parts[1]); // 034556
                
                MatrizLogica[part1][part2] = ObjetosAdded.Name;
                
                
                ((JButton)ae.getSource()).setBackground(Color.red);
                ((JButton)ae.getSource()).setText(ElementoTxt.getText());
                
                ObjetosAdded = ObjetosAdded.anterior;
                ElementoTxt.setText(ObjetosAdded.Name);
                
                
            }else if(ObjetosAdded == dl.primero ){                
                if(FristDraw == false){              
                    str = ((JButton)ae.getSource()).getName();
                    String[] parts = str.split(",");
                    int part1 = Integer.parseInt(parts[0]); // 004
                    int part2 = Integer.parseInt(parts[1]); // 034556
                
                    MatrizLogica[part1][part2] = ObjetosAdded.Name;  
                    
                    ((JButton)ae.getSource()).setBackground(Color.red);
                    ((JButton)ae.getSource()).setText(ElementoTxt.getText());
                    FristDraw = true;                
                    ElementoTxt.setText(ObjetosAdded.Name);
                    
                    System.out.println ("Recorrido Reverse\n");
                    for (int i=MatrizLogica.length-1; i>=0; i--) {
                        for (int j=0; j<MatrizLogica[0].length; j++){
                            System.out.print ("    " + MatrizLogica[i][j]);    
                        }
                    System.out.println ("");
                    }
                                      
                }}         
             
             }
            
            
             //System.out.println(((JButton)ae.getSource()).getText());
            
            /*System.out.println ("Recorrido Reverse\n");
            for (int i=MatrizLogica.length-1; i>=0; i--) {
            for (int j=0; j<MatrizLogica[0].length; j++){
                System.out.print ("    " + MatrizLogica[i][j]);    
            }
            System.out.println ("");
            }*/
            /*
            System.out.println ("Recorrido iterativo\n");
            for (int i=0; i<matriz.length; i++) {
            for (int j=0; j<matriz[0].length; j++){
                System.out.print ("    " + matriz[i][j]);    
            }
                System.out.println ("");
            }
            System.out.println ("\n\n");*/
            
        }
    }
}
