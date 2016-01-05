/*
 * GATTView.java
 */

package gatt;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.io.*;
import java.util.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
/**
 * The application's main frame.
 */
public class GATTView extends FrameView {
     Toolkit tk = Toolkit.getDefaultToolkit();
Dimension dimension = tk.getScreenSize();

    public void update(){
        if(count1==10)
   {String str = "<html>" + "<font color=\"#FF0000\">" + "<b>" + "COMPLETED" + "</b>" + "</font>" + "</html>";
gn.setText(str);
gen.setEnabled(true);
   PB.setValue(count1);}
        else{
          tabout();  
         String str;
     str = "<html>" + "<font color=\"#008000\">" + "<b>" + "GENERATING ....." + "</b>" + "</font>" + "</html>";
     gn.setText(str);
     System.out.println(count1);
     PB.setValue(count1);
        }
}
    public void tabout(){
        for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
          jTable1.setValueAt("",k,j);   
        
  try{ 
      String sr;
  int flag;
      BufferedReader in=new BufferedReader(new FileReader("happy.pop"));
      BufferedReader inn=new BufferedReader(new FileReader("lab.pop"));
      BufferedReader innn=new BufferedReader(new FileReader("tut.pop"));
     
      for(int x=0;x<r;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
        {    
            sr=in.readLine();
              flag=Integer.parseInt(sr);
                       
              if(flag!=0)
                { System.out.println(flag);
                    
                  sr=CSNX[flag-1]+" By "+LN[(CTCX[flag-1])-1]+" in"+RNM[x]; 
                  jTable1.setValueAt(sr,k,j);  
                 
                 }
              }
      for(int x=0;x<lb;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
        {  sr=inn.readLine();
              flag=Integer.parseInt(sr);
              if(flag!=0)
                { sr=(String)jTable1.getValueAt(k,j)+PN[flag-(1)]+" in(L)"+LBN[x]+"/";
                    
                  jTable1.setValueAt(sr,k,j);  
                  
                 }
              }
            

     for(int x=0;x<r;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
      {  
                sr=innn.readLine();
              flag=Integer.parseInt(sr);
                       
              if(flag!=0)
                { System.out.println(flag);
                    
                  sr=(String)jTable1.getValueAt(k,j)+TUTOR[flag-1]+" in"+RNM[x]+"(T)"; 
                  jTable1.setValueAt(sr,k,j);  
                 
                 } 
                 
              }
     innn.close();
    in.close();
    inn.close();
 
  }catch(IOException e){
      System.out.println("filenot found");
  }
  
        
    }
        public void tabout1(){
        for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
          jTable2.setValueAt("",k,j);   
        
  try{ 
      String sr;
  int flag;
      BufferedReader in=new BufferedReader(new FileReader("happy.pop"));
      BufferedReader inn=new BufferedReader(new FileReader("lab.pop"));
      BufferedReader innn=new BufferedReader(new FileReader("tut.pop"));
     
      for(int x=0;x<r;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
        {    
            sr=in.readLine();
              flag=Integer.parseInt(sr);
                       
              if(flag!=0)
                { System.out.println(flag);
                    
                  sr=CSNX[flag-1]+" By "+LN[(CTCX[flag-1])-1]+" in"+RNM[x]; 
                  jTable2.setValueAt(sr,k,j);  
                 
                 }
              }
      for(int x=0;x<lb;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
        {  sr=inn.readLine();
              flag=Integer.parseInt(sr);
              if(flag!=0)
                { sr=(String)jTable2.getValueAt(k,j)+PN[flag-(1)]+" in(L)"+LBN[x]+" ";
                    
                  jTable2.setValueAt(sr,k,j);  
                  
                 }
              }
      
     for(int x=0;x<r;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
      {  
                sr=innn.readLine();
              flag=Integer.parseInt(sr);
                       
              if(flag!=0)
                { System.out.println(flag);
                    
                  sr=(String)jTable2.getValueAt(k,j)+TUTOR[flag-1]+" in"+RNM[x]+"(T)"; 
                  jTable2.setValueAt(sr,k,j);  
                 
                 } 
                 
              }
     innn.close();
    in.close();
    inn.close();
  }catch(IOException e){
      System.out.println("filenot found");
  }
  
        
    }
        
        public void tabout2(){
                    for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
          jTable3.setValueAt("",k,j);   
        
  try{ 
      String sr;
  int flag;
      BufferedReader in=new BufferedReader(new FileReader("unhappy.pop"));
      BufferedReader inn=new BufferedReader(new FileReader("ulab.pop"));
      BufferedReader innn=new BufferedReader(new FileReader("utut.pop"));
     
      for(int x=0;x<r;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
        {    
            sr=in.readLine();
              flag=Integer.parseInt(sr);
                       
              if(flag!=0)
                { System.out.println(flag);
                    
                  sr=CSNX[flag-1]+" By "+LN[(CTCX[flag-1])-1]+" in"+RNM[x]; 
                  jTable3.setValueAt(sr,k,j);  
                 
                 }
              }
      for(int x=0;x<lb;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
        {  sr=inn.readLine();
              flag=Integer.parseInt(sr);
              if(flag!=0)
                { sr=(String)jTable3.getValueAt(k,j)+PN[flag-(1)]+" in(L)"+LBN[x]+" ";
                    
                  jTable3.setValueAt(sr,k,j);  
                  
                 }
              }
      
     for(int x=0;x<r;x++)
      for(int k=0;k<6;k++)
        for(int j=0;j<8;j++)
      {  
                sr=innn.readLine();
              flag=Integer.parseInt(sr);
                       
              if(flag!=0)
                { System.out.println("T"+flag);
                    
                  sr=(String)jTable3.getValueAt(k,j)+TUTOR[flag-1]+" in"+RNM[x]+"(T)"; 
                  jTable3.setValueAt(sr,k,j);  
                 
                 } 
                 
              }
     innn.close();
    in.close();
    inn.close();
  }catch(IOException e){
      System.out.println("filenot found");
  }
            
        }
        
        
        
        
    class NewThread implements Runnable{
        
        
        public void run(){
            try
      {
           
    
     System.out.print("Generating");
     gen.setEnabled(false);
     PB.setValue(0);
      int exitVal,count=0,flag=0;
      char ch;
      String hpy=new String();
      
  Process process = Runtime.getRuntime().exec("cmd.exe /c Gatt.exe");
      //"cmd /c C:/hello.exe",}
  OutputStream stdin = process.getOutputStream ();
  InputStream stderr = process.getErrorStream ();
  InputStream stdout = process.getInputStream ();

  BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
  System.out.println("sucess able to hook");
  
  
do{ 
    ch=(char)reader.read();

    if(ch=='$')
     {  
        hpy="";
       ch=(char)reader.read();
       hpy=hpy+ch;
       ch=(char)reader.read();
       hpy=hpy+ch;
       System.out.println(hpy);
       hpp.setText(hpy);
           
       writer.write("5");
       writer.newLine();
       writer.flush();
     }
if(ch=='>')
 {    /* ch=(char)reader.read();
       hpy=hpy+ch;
       ch=(char)reader.read();
       hpy=hpy+ch;
       ch=(char)reader.read();
       hpy=hpy+ch;
       ch=(char)reader.read();
       hpy=hpy+ch;
       ch=(char)reader.read();
       hpy=hpy+ch;
      */
     count ++;
     count1=count/1000;
     if(flag!=count1)
     {update();     
      flag=count1;
      //Thread.sleep(1000);
     }
 }

}while(ch!='|');
exitVal=process.waitFor();
System.out.println("Exited with error code "+exitVal);
  
  }catch (Exception e)
  {
 System.out.println("unable to hook");
  }
            
        }
    }
    int l,c,cx=0,tut=0,r=2,lb=3,p=0,i=0,count1,condec=0;
    String CSN[]= new String[50];
    int NS[]=new int[50];
    int CTC[]=new int[50];
    int LBatch[]=new int[50];
    int LCRS[]=new int [50];
    int Ltut[]=new int[50];
    int Llab[]=new int[50];
    int Llabc[]=new int[50];
    
    String CSNX[]= new String[50];
    int NSX[]=new int[50];
    int CTCX[]=new int[50];
    int LBatchX[]=new int[50];
    
    String LN[]=new String[15];
    int H[][][]=new int[6][8][15];
    
    int HR[][][]=new int[6][8][5];
    int RC[]=new int[5];
    String RNM[]=new String[5];
    
    String PN[]=new String[30];
    int  PL[]=new int[30];
    int  PS[]=new int [30];
    int  PBatch[]=new int [30];
    
    String LBN[]=new String[6];
    int LS[]=new int [6];

    String TUTOR[]=new String[30];
    int TBatch[]=new int[30];

    public GATTView(SingleFrameApplication app) {
        super(app);
        

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int ii = 0; ii < busyIcons.length; ii++) {
            busyIcons[ii] = resourceMap.getIcon("StatusBar.busyIcons[" + ii + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = GATTApp.getApplication().getMainFrame();
            aboutBox = new GATTAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        GATTApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        Constraints = new javax.swing.JFrame();
        courses = new javax.swing.JTextField();
        lectures = new javax.swing.JTextField();
        rooms = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labs = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        Room = new javax.swing.JFrame();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox51 = new javax.swing.JCheckBox();
        jCheckBox52 = new javax.swing.JCheckBox();
        jCheckBox53 = new javax.swing.JCheckBox();
        jCheckBox54 = new javax.swing.JCheckBox();
        jCheckBox55 = new javax.swing.JCheckBox();
        jCheckBox56 = new javax.swing.JCheckBox();
        jCheckBox57 = new javax.swing.JCheckBox();
        jCheckBox58 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox61 = new javax.swing.JCheckBox();
        jCheckBox62 = new javax.swing.JCheckBox();
        jCheckBox63 = new javax.swing.JCheckBox();
        jCheckBox64 = new javax.swing.JCheckBox();
        jCheckBox65 = new javax.swing.JCheckBox();
        jCheckBox66 = new javax.swing.JCheckBox();
        jCheckBox67 = new javax.swing.JCheckBox();
        jCheckBox68 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jCheckBox71 = new javax.swing.JCheckBox();
        jCheckBox72 = new javax.swing.JCheckBox();
        jCheckBox73 = new javax.swing.JCheckBox();
        jCheckBox74 = new javax.swing.JCheckBox();
        jCheckBox75 = new javax.swing.JCheckBox();
        jCheckBox76 = new javax.swing.JCheckBox();
        jCheckBox77 = new javax.swing.JCheckBox();
        jCheckBox78 = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox81 = new javax.swing.JCheckBox();
        jCheckBox82 = new javax.swing.JCheckBox();
        jCheckBox83 = new javax.swing.JCheckBox();
        jCheckBox84 = new javax.swing.JCheckBox();
        jCheckBox85 = new javax.swing.JCheckBox();
        jCheckBox86 = new javax.swing.JCheckBox();
        jCheckBox87 = new javax.swing.JCheckBox();
        jCheckBox88 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox91 = new javax.swing.JCheckBox();
        jCheckBox92 = new javax.swing.JCheckBox();
        jCheckBox93 = new javax.swing.JCheckBox();
        jCheckBox94 = new javax.swing.JCheckBox();
        jCheckBox95 = new javax.swing.JCheckBox();
        jCheckBox96 = new javax.swing.JCheckBox();
        jCheckBox97 = new javax.swing.JCheckBox();
        jCheckBox98 = new javax.swing.JCheckBox();
        rnm = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        rc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        rn = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        Generation = new javax.swing.JFrame();
        PB = new javax.swing.JProgressBar();
        gen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        gn = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        hpp = new javax.swing.JLabel();
        Courses = new javax.swing.JFrame();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        csn = new javax.swing.JTextField();
        ctc = new javax.swing.JTextField();
        ns = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        cn = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Lecturers = new javax.swing.JFrame();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        m1 = new javax.swing.JCheckBox();
        m2 = new javax.swing.JCheckBox();
        m3 = new javax.swing.JCheckBox();
        m4 = new javax.swing.JCheckBox();
        m5 = new javax.swing.JCheckBox();
        m6 = new javax.swing.JCheckBox();
        m7 = new javax.swing.JCheckBox();
        m8 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        t1 = new javax.swing.JCheckBox();
        t2 = new javax.swing.JCheckBox();
        t3 = new javax.swing.JCheckBox();
        t4 = new javax.swing.JCheckBox();
        t5 = new javax.swing.JCheckBox();
        t6 = new javax.swing.JCheckBox();
        t7 = new javax.swing.JCheckBox();
        t8 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        w1 = new javax.swing.JCheckBox();
        w2 = new javax.swing.JCheckBox();
        w3 = new javax.swing.JCheckBox();
        w4 = new javax.swing.JCheckBox();
        w5 = new javax.swing.JCheckBox();
        w6 = new javax.swing.JCheckBox();
        w7 = new javax.swing.JCheckBox();
        w8 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        h1 = new javax.swing.JCheckBox();
        h2 = new javax.swing.JCheckBox();
        h3 = new javax.swing.JCheckBox();
        h4 = new javax.swing.JCheckBox();
        h5 = new javax.swing.JCheckBox();
        h6 = new javax.swing.JCheckBox();
        h7 = new javax.swing.JCheckBox();
        h8 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        f1 = new javax.swing.JCheckBox();
        f2 = new javax.swing.JCheckBox();
        f3 = new javax.swing.JCheckBox();
        f4 = new javax.swing.JCheckBox();
        f5 = new javax.swing.JCheckBox();
        f6 = new javax.swing.JCheckBox();
        f7 = new javax.swing.JCheckBox();
        f8 = new javax.swing.JCheckBox();
        nol = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        s1 = new javax.swing.JCheckBox();
        s2 = new javax.swing.JCheckBox();
        s3 = new javax.swing.JCheckBox();
        s4 = new javax.swing.JCheckBox();
        s5 = new javax.swing.JCheckBox();
        s6 = new javax.swing.JCheckBox();
        s7 = new javax.swing.JCheckBox();
        s8 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        ln = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        Pracs = new javax.swing.JFrame();
        jLabel15 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pcn = new javax.swing.JTextField();
        plc = new javax.swing.JTextField();
        ps = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        pn = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        c1 = new javax.swing.JRadioButton();
        c2 = new javax.swing.JRadioButton();
        c3 = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        Labs = new javax.swing.JFrame();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbn = new javax.swing.JTextField();
        ls = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        lbnb = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        bg = new javax.swing.ButtonGroup();
        Error = new javax.swing.JFrame();
        jLabel41 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        Result = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        Error2 = new javax.swing.JFrame();
        jLabel42 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        corses = new javax.swing.JFrame();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ccc = new javax.swing.JTable();
        Cn = new javax.swing.JTextField();
        Lc = new javax.swing.JComboBox();
        Cds = new javax.swing.JComboBox();
        Batch = new javax.swing.JComboBox();
        Tut = new javax.swing.JComboBox();
        Lab = new javax.swing.JComboBox();
        Labcode = new javax.swing.JComboBox();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        Error3 = new javax.swing.JFrame();
        jLabel46 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        Result1 = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();

        mainPanel.setMinimumSize(dimension);
        mainPanel.setName("mainPanel"); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gatt.GATTApp.class).getContext().getResourceMap(GATTView.class);
        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jButton16.setText(resourceMap.getString("jButton16.text")); // NOI18N
        jButton16.setName("jButton16"); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel50.setText(resourceMap.getString("jLabel50.text")); // NOI18N
        jLabel50.setName("jLabel50"); // NOI18N

        jLabel51.setText(resourceMap.getString("jLabel51.text")); // NOI18N
        jLabel51.setName("jLabel51"); // NOI18N

        jLabel52.setText(resourceMap.getString("jLabel52.text")); // NOI18N
        jLabel52.setName("jLabel52"); // NOI18N

        jLabel53.setText(resourceMap.getString("jLabel53.text")); // NOI18N
        jLabel53.setName("jLabel53"); // NOI18N

        jLabel54.setText(resourceMap.getString("jLabel54.text")); // NOI18N
        jLabel54.setName("jLabel54"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                                .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)))
                .addGap(69, 69, 69)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel54)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem4);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(gatt.GATTApp.class).getContext().getActionMap(GATTView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        Constraints.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Constraints.setTitle(resourceMap.getString("Constraints.title")); // NOI18N
        Constraints.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Constraints.setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        Constraints.setMinimumSize(dimension);
        Constraints.setName("Constraints"); // NOI18N

        courses.setText(resourceMap.getString("courses.text")); // NOI18N
        courses.setName("courses"); // NOI18N

        lectures.setText(resourceMap.getString("lectures.text")); // NOI18N
        lectures.setName("lectures"); // NOI18N

        rooms.setText(resourceMap.getString("rooms.text")); // NOI18N
        rooms.setName("rooms"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        labs.setText(resourceMap.getString("labs.text")); // NOI18N
        labs.setName("labs"); // NOI18N

        jButton17.setText(resourceMap.getString("jButton17.text")); // NOI18N
        jButton17.setName("jButton17"); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConstraintsLayout = new javax.swing.GroupLayout(Constraints.getContentPane());
        Constraints.getContentPane().setLayout(ConstraintsLayout);
        ConstraintsLayout.setHorizontalGroup(
            ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConstraintsLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConstraintsLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap())
                    .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ConstraintsLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addContainerGap())
                        .addGroup(ConstraintsLayout.createSequentialGroup()
                            .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lectures, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(courses)
                                .addComponent(rooms)
                                .addComponent(labs))
                            .addContainerGap(639, Short.MAX_VALUE)))))
            .addGroup(ConstraintsLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(764, Short.MAX_VALUE))
        );
        ConstraintsLayout.setVerticalGroup(
            ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConstraintsLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(courses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lectures, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConstraintsLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel14))
                    .addGroup(ConstraintsLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(labs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84)
                .addGroup(ConstraintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton17))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        Room.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Room.setTitle(resourceMap.getString("Room.title")); // NOI18N
        Room.setMinimumSize(dimension);
        Room.setName("Room"); // NOI18N
        Room.setResizable(false);

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        jCheckBox51.setSelected(true);
        jCheckBox51.setText(resourceMap.getString("jCheckBox51.text")); // NOI18N
        jCheckBox51.setName("jCheckBox51"); // NOI18N

        jCheckBox52.setSelected(true);
        jCheckBox52.setText(resourceMap.getString("jCheckBox52.text")); // NOI18N
        jCheckBox52.setName("jCheckBox52"); // NOI18N

        jCheckBox53.setSelected(true);
        jCheckBox53.setText(resourceMap.getString("jCheckBox53.text")); // NOI18N
        jCheckBox53.setName("jCheckBox53"); // NOI18N

        jCheckBox54.setSelected(true);
        jCheckBox54.setText(resourceMap.getString("jCheckBox54.text")); // NOI18N
        jCheckBox54.setName("jCheckBox54"); // NOI18N

        jCheckBox55.setSelected(true);
        jCheckBox55.setText(resourceMap.getString("jCheckBox55.text")); // NOI18N
        jCheckBox55.setName("jCheckBox55"); // NOI18N

        jCheckBox56.setSelected(true);
        jCheckBox56.setText(resourceMap.getString("jCheckBox56.text")); // NOI18N
        jCheckBox56.setName("jCheckBox56"); // NOI18N

        jCheckBox57.setSelected(true);
        jCheckBox57.setText(resourceMap.getString("jCheckBox57.text")); // NOI18N
        jCheckBox57.setName("jCheckBox57"); // NOI18N

        jCheckBox58.setSelected(true);
        jCheckBox58.setText(resourceMap.getString("jCheckBox58.text")); // NOI18N
        jCheckBox58.setName("jCheckBox58"); // NOI18N

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        jCheckBox61.setSelected(true);
        jCheckBox61.setText(resourceMap.getString("jCheckBox61.text")); // NOI18N
        jCheckBox61.setName("jCheckBox61"); // NOI18N

        jCheckBox62.setSelected(true);
        jCheckBox62.setText(resourceMap.getString("jCheckBox62.text")); // NOI18N
        jCheckBox62.setName("jCheckBox62"); // NOI18N

        jCheckBox63.setSelected(true);
        jCheckBox63.setText(resourceMap.getString("jCheckBox63.text")); // NOI18N
        jCheckBox63.setName("jCheckBox63"); // NOI18N

        jCheckBox64.setSelected(true);
        jCheckBox64.setText(resourceMap.getString("jCheckBox64.text")); // NOI18N
        jCheckBox64.setName("jCheckBox64"); // NOI18N

        jCheckBox65.setSelected(true);
        jCheckBox65.setText(resourceMap.getString("jCheckBox65.text")); // NOI18N
        jCheckBox65.setName("jCheckBox65"); // NOI18N

        jCheckBox66.setSelected(true);
        jCheckBox66.setText(resourceMap.getString("jCheckBox66.text")); // NOI18N
        jCheckBox66.setName("jCheckBox66"); // NOI18N

        jCheckBox67.setSelected(true);
        jCheckBox67.setText(resourceMap.getString("jCheckBox67.text")); // NOI18N
        jCheckBox67.setName("jCheckBox67"); // NOI18N

        jCheckBox68.setSelected(true);
        jCheckBox68.setText(resourceMap.getString("jCheckBox68.text")); // NOI18N
        jCheckBox68.setName("jCheckBox68"); // NOI18N

        jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N

        jCheckBox71.setSelected(true);
        jCheckBox71.setText(resourceMap.getString("jCheckBox71.text")); // NOI18N
        jCheckBox71.setName("jCheckBox71"); // NOI18N

        jCheckBox72.setSelected(true);
        jCheckBox72.setText(resourceMap.getString("jCheckBox72.text")); // NOI18N
        jCheckBox72.setName("jCheckBox72"); // NOI18N

        jCheckBox73.setSelected(true);
        jCheckBox73.setText(resourceMap.getString("jCheckBox73.text")); // NOI18N
        jCheckBox73.setName("jCheckBox73"); // NOI18N

        jCheckBox74.setSelected(true);
        jCheckBox74.setText(resourceMap.getString("jCheckBox74.text")); // NOI18N
        jCheckBox74.setName("jCheckBox74"); // NOI18N

        jCheckBox75.setSelected(true);
        jCheckBox75.setText(resourceMap.getString("jCheckBox75.text")); // NOI18N
        jCheckBox75.setName("jCheckBox75"); // NOI18N

        jCheckBox76.setSelected(true);
        jCheckBox76.setText(resourceMap.getString("jCheckBox76.text")); // NOI18N
        jCheckBox76.setName("jCheckBox76"); // NOI18N

        jCheckBox77.setSelected(true);
        jCheckBox77.setText(resourceMap.getString("jCheckBox77.text")); // NOI18N
        jCheckBox77.setName("jCheckBox77"); // NOI18N

        jCheckBox78.setSelected(true);
        jCheckBox78.setText(resourceMap.getString("jCheckBox78.text")); // NOI18N
        jCheckBox78.setName("jCheckBox78"); // NOI18N

        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        jCheckBox81.setSelected(true);
        jCheckBox81.setText(resourceMap.getString("jCheckBox81.text")); // NOI18N
        jCheckBox81.setName("jCheckBox81"); // NOI18N

        jCheckBox82.setSelected(true);
        jCheckBox82.setText(resourceMap.getString("jCheckBox82.text")); // NOI18N
        jCheckBox82.setName("jCheckBox82"); // NOI18N

        jCheckBox83.setSelected(true);
        jCheckBox83.setText(resourceMap.getString("jCheckBox83.text")); // NOI18N
        jCheckBox83.setName("jCheckBox83"); // NOI18N

        jCheckBox84.setSelected(true);
        jCheckBox84.setText(resourceMap.getString("jCheckBox84.text")); // NOI18N
        jCheckBox84.setName("jCheckBox84"); // NOI18N

        jCheckBox85.setSelected(true);
        jCheckBox85.setText(resourceMap.getString("jCheckBox85.text")); // NOI18N
        jCheckBox85.setName("jCheckBox85"); // NOI18N

        jCheckBox86.setSelected(true);
        jCheckBox86.setText(resourceMap.getString("jCheckBox86.text")); // NOI18N
        jCheckBox86.setName("jCheckBox86"); // NOI18N

        jCheckBox87.setSelected(true);
        jCheckBox87.setText(resourceMap.getString("jCheckBox87.text")); // NOI18N
        jCheckBox87.setName("jCheckBox87"); // NOI18N

        jCheckBox88.setSelected(true);
        jCheckBox88.setText(resourceMap.getString("jCheckBox88.text")); // NOI18N
        jCheckBox88.setName("jCheckBox88"); // NOI18N

        jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        jCheckBox91.setSelected(true);
        jCheckBox91.setText(resourceMap.getString("jCheckBox91.text")); // NOI18N
        jCheckBox91.setName("jCheckBox91"); // NOI18N

        jCheckBox92.setSelected(true);
        jCheckBox92.setText(resourceMap.getString("jCheckBox92.text")); // NOI18N
        jCheckBox92.setName("jCheckBox92"); // NOI18N

        jCheckBox93.setSelected(true);
        jCheckBox93.setText(resourceMap.getString("jCheckBox93.text")); // NOI18N
        jCheckBox93.setName("jCheckBox93"); // NOI18N

        jCheckBox94.setSelected(true);
        jCheckBox94.setText(resourceMap.getString("jCheckBox94.text")); // NOI18N
        jCheckBox94.setName("jCheckBox94"); // NOI18N

        jCheckBox95.setSelected(true);
        jCheckBox95.setText(resourceMap.getString("jCheckBox95.text")); // NOI18N
        jCheckBox95.setName("jCheckBox95"); // NOI18N

        jCheckBox96.setSelected(true);
        jCheckBox96.setText(resourceMap.getString("jCheckBox96.text")); // NOI18N
        jCheckBox96.setName("jCheckBox96"); // NOI18N

        jCheckBox97.setSelected(true);
        jCheckBox97.setText(resourceMap.getString("jCheckBox97.text")); // NOI18N
        jCheckBox97.setName("jCheckBox97"); // NOI18N

        jCheckBox98.setSelected(true);
        jCheckBox98.setText(resourceMap.getString("jCheckBox98.text")); // NOI18N
        jCheckBox98.setName("jCheckBox98"); // NOI18N

        rnm.setName("rnm"); // NOI18N

        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
        jLabel23.setName("jLabel23"); // NOI18N

        rc.setText(resourceMap.getString("rc.text")); // NOI18N
        rc.setName("rc"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jCheckBox1.setSelected(true);
        jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        jCheckBox2.setSelected(true);
        jCheckBox2.setText(resourceMap.getString("jCheckBox2.text")); // NOI18N
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        jCheckBox3.setSelected(true);
        jCheckBox3.setText(resourceMap.getString("jCheckBox3.text")); // NOI18N
        jCheckBox3.setName("jCheckBox3"); // NOI18N

        jCheckBox4.setSelected(true);
        jCheckBox4.setText(resourceMap.getString("jCheckBox4.text")); // NOI18N
        jCheckBox4.setName("jCheckBox4"); // NOI18N

        jCheckBox5.setSelected(true);
        jCheckBox5.setText(resourceMap.getString("jCheckBox5.text")); // NOI18N
        jCheckBox5.setName("jCheckBox5"); // NOI18N

        jCheckBox6.setSelected(true);
        jCheckBox6.setText(resourceMap.getString("jCheckBox6.text")); // NOI18N
        jCheckBox6.setName("jCheckBox6"); // NOI18N

        jCheckBox7.setSelected(true);
        jCheckBox7.setText(resourceMap.getString("jCheckBox7.text")); // NOI18N
        jCheckBox7.setName("jCheckBox7"); // NOI18N

        jCheckBox8.setSelected(true);
        jCheckBox8.setText(resourceMap.getString("jCheckBox8.text")); // NOI18N
        jCheckBox8.setName("jCheckBox8"); // NOI18N

        jLabel31.setText(resourceMap.getString("jLabel31.text")); // NOI18N
        jLabel31.setName("jLabel31"); // NOI18N

        rn.setText(resourceMap.getString("rn.text")); // NOI18N
        rn.setName("rn"); // NOI18N

        jButton21.setText(resourceMap.getString("jButton21.text")); // NOI18N
        jButton21.setName("jButton21"); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RoomLayout = new javax.swing.GroupLayout(Room.getContentPane());
        Room.getContentPane().setLayout(RoomLayout);
        RoomLayout.setHorizontalGroup(
            RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomLayout.createSequentialGroup()
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RoomLayout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RoomLayout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6))
                            .addComponent(jLabel10)
                            .addComponent(jLabel22)
                            .addGroup(RoomLayout.createSequentialGroup()
                                .addComponent(jCheckBox81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox83)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox86))
                            .addComponent(jLabel21)
                            .addGroup(RoomLayout.createSequentialGroup()
                                .addComponent(jCheckBox71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox76))
                            .addComponent(jLabel20)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addGroup(RoomLayout.createSequentialGroup()
                                .addComponent(jCheckBox91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox94)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox96))
                            .addComponent(jLabel19)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RoomLayout.createSequentialGroup()
                                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(RoomLayout.createSequentialGroup()
                                        .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox51)
                                            .addComponent(jCheckBox61))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox52)
                                            .addComponent(jCheckBox63))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(RoomLayout.createSequentialGroup()
                                                .addComponent(jCheckBox62)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox64)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox65)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox66))
                                            .addGroup(RoomLayout.createSequentialGroup()
                                                .addComponent(jCheckBox53)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox54)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox55)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBox56)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(RoomLayout.createSequentialGroup()
                                                        .addComponent(jCheckBox67)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckBox68))
                                                    .addGroup(RoomLayout.createSequentialGroup()
                                                        .addComponent(jCheckBox57)
                                                        .addGap(2, 2, 2)
                                                        .addComponent(jCheckBox58))
                                                    .addGroup(RoomLayout.createSequentialGroup()
                                                        .addComponent(jCheckBox77)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckBox78))
                                                    .addGroup(RoomLayout.createSequentialGroup()
                                                        .addComponent(jCheckBox87)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckBox88))
                                                    .addGroup(RoomLayout.createSequentialGroup()
                                                        .addComponent(jCheckBox97)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckBox98))
                                                    .addGroup(RoomLayout.createSequentialGroup()
                                                        .addComponent(jCheckBox7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckBox8))))
                                            .addComponent(rnm, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)
                                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(RoomLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(120, 120, 120)
                                        .addComponent(rc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(RoomLayout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(354, Short.MAX_VALUE))
        );
        RoomLayout.setVerticalGroup(
            RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(rc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(1, 1, 1)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox51)
                    .addComponent(jCheckBox52)
                    .addComponent(jCheckBox53)
                    .addComponent(jCheckBox54)
                    .addComponent(jCheckBox55)
                    .addComponent(jCheckBox56)
                    .addComponent(jCheckBox57)
                    .addComponent(jCheckBox58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(7, 7, 7)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox63)
                    .addComponent(jCheckBox62)
                    .addComponent(jCheckBox64)
                    .addComponent(jCheckBox65)
                    .addComponent(jCheckBox66)
                    .addComponent(jCheckBox61)
                    .addComponent(jCheckBox68)
                    .addComponent(jCheckBox67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox71)
                    .addComponent(jCheckBox72)
                    .addComponent(jCheckBox73)
                    .addComponent(jCheckBox74)
                    .addComponent(jCheckBox75)
                    .addComponent(jCheckBox76)
                    .addComponent(jCheckBox78)
                    .addComponent(jCheckBox77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox81)
                    .addComponent(jCheckBox82)
                    .addComponent(jCheckBox83)
                    .addComponent(jCheckBox84)
                    .addComponent(jCheckBox85)
                    .addComponent(jCheckBox86)
                    .addComponent(jCheckBox88)
                    .addComponent(jCheckBox87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox91)
                    .addComponent(jCheckBox92)
                    .addComponent(jCheckBox93)
                    .addComponent(jCheckBox94)
                    .addComponent(jCheckBox95)
                    .addComponent(jCheckBox96)
                    .addComponent(jCheckBox98)
                    .addComponent(jCheckBox97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox7))
                .addGap(63, 63, 63)
                .addGroup(RoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(jButton7))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        Generation.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Generation.setMinimumSize(dimension);
        Generation.setName("Generation"); // NOI18N
        Generation.setResizable(false);

        PB.setMaximum(10);
        PB.setBorderPainted(false);
        PB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PB.setMaximumSize(new java.awt.Dimension(32767, 34));
        PB.setMinimumSize(new java.awt.Dimension(146, 34));
        PB.setName("PB"); // NOI18N
        PB.setStringPainted(true);
        PB.setVerifyInputWhenFocusTarget(false);

        gen.setText(resourceMap.getString("gen.text")); // NOI18N
        gen.setName("gen"); // NOI18N
        gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "8-9 AM", "9-10 AM", "10-11 AM", "11-12 AM", "12-1 PM", "2-3 PM", "3-4 PM", "4-5 PM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMinimumSize(new java.awt.Dimension(800, 96));
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setRowHeight(50);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(100);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setMinWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setMinWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable1.getColumnModel().getColumn(3).setMinWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N
        jTable1.getColumnModel().getColumn(4).setMinWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N
        jTable1.getColumnModel().getColumn(5).setMinWidth(100);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTable1.columnModel.title5")); // NOI18N
        jTable1.getColumnModel().getColumn(6).setMinWidth(100);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable1.columnModel.title6")); // NOI18N
        jTable1.getColumnModel().getColumn(7).setMinWidth(100);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(500);
        jTable1.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("jTable1.columnModel.title7")); // NOI18N

        gn.setFont(resourceMap.getFont("gn.font")); // NOI18N
        gn.setText(resourceMap.getString("gn.text")); // NOI18N
        gn.setName("gn"); // NOI18N

        jLabel38.setFont(resourceMap.getFont("jLabel38.font")); // NOI18N
        jLabel38.setForeground(resourceMap.getColor("jLabel38.foreground")); // NOI18N
        jLabel38.setText(resourceMap.getString("jLabel38.text")); // NOI18N
        jLabel38.setName("jLabel38"); // NOI18N

        hpp.setFont(resourceMap.getFont("hpp.font")); // NOI18N
        hpp.setText(resourceMap.getString("hpp.text")); // NOI18N
        hpp.setName("hpp"); // NOI18N

        javax.swing.GroupLayout GenerationLayout = new javax.swing.GroupLayout(Generation.getContentPane());
        Generation.getContentPane().setLayout(GenerationLayout);
        GenerationLayout.setHorizontalGroup(
            GenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenerationLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(GenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GenerationLayout.createSequentialGroup()
                        .addComponent(gn, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(GenerationLayout.createSequentialGroup()
                        .addComponent(gen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(GenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GenerationLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(hpp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PB, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(269, 269, 269))))
            .addGroup(GenerationLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        GenerationLayout.setVerticalGroup(
            GenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenerationLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(GenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gen, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(PB, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(GenerationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hpp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );

        Courses.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Courses.setTitle(resourceMap.getString("Courses.title")); // NOI18N
        Courses.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Courses.setMinimumSize(new java.awt.Dimension(559, 270));
        Courses.setName("Courses"); // NOI18N
        Courses.setResizable(false);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        csn.setText(resourceMap.getString("csn.text")); // NOI18N
        csn.setName("csn"); // NOI18N

        ctc.setText(resourceMap.getString("ctc.text")); // NOI18N
        ctc.setName("ctc"); // NOI18N

        ns.setText(resourceMap.getString("ns.text")); // NOI18N
        ns.setName("ns"); // NOI18N

        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cn.setText(resourceMap.getString("cn.text")); // NOI18N
        cn.setName("cn"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        javax.swing.GroupLayout CoursesLayout = new javax.swing.GroupLayout(Courses.getContentPane());
        Courses.getContentPane().setLayout(CoursesLayout);
        CoursesLayout.setHorizontalGroup(
            CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursesLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(88, 88, 88)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoursesLayout.createSequentialGroup()
                        .addComponent(cn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoursesLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoursesLayout.createSequentialGroup()
                        .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ns, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(csn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(ctc, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                        .addGap(72, 72, 72))))
        );
        CoursesLayout.setVerticalGroup(
            CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(cn))
                .addGap(18, 18, 18)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(csn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(CoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(33, 33, 33))
        );

        Lecturers.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Lecturers.setTitle(resourceMap.getString("Lecturers.title")); // NOI18N
        Lecturers.setMinimumSize(dimension);
        Lecturers.setName("Lecturers"); // NOI18N
        Lecturers.setResizable(false);

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        m1.setSelected(true);
        m1.setText(resourceMap.getString("m1.text")); // NOI18N
        m1.setName("m1"); // NOI18N

        m2.setSelected(true);
        m2.setText(resourceMap.getString("m2.text")); // NOI18N
        m2.setName("m2"); // NOI18N

        m3.setSelected(true);
        m3.setText(resourceMap.getString("m3.text")); // NOI18N
        m3.setName("m3"); // NOI18N

        m4.setSelected(true);
        m4.setText(resourceMap.getString("m4.text")); // NOI18N
        m4.setName("m4"); // NOI18N

        m5.setSelected(true);
        m5.setText(resourceMap.getString("m5.text")); // NOI18N
        m5.setName("m5"); // NOI18N

        m6.setSelected(true);
        m6.setText(resourceMap.getString("m6.text")); // NOI18N
        m6.setName("m6"); // NOI18N

        m7.setSelected(true);
        m7.setText(resourceMap.getString("m7.text")); // NOI18N
        m7.setName("m7"); // NOI18N

        m8.setSelected(true);
        m8.setText(resourceMap.getString("m8.text")); // NOI18N
        m8.setName("m8"); // NOI18N

        jLabel26.setText(resourceMap.getString("jLabel26.text")); // NOI18N
        jLabel26.setName("jLabel26"); // NOI18N

        jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
        jLabel27.setName("jLabel27"); // NOI18N

        t1.setSelected(true);
        t1.setText(resourceMap.getString("t1.text")); // NOI18N
        t1.setName("t1"); // NOI18N

        t2.setSelected(true);
        t2.setText(resourceMap.getString("t2.text")); // NOI18N
        t2.setName("t2"); // NOI18N

        t3.setSelected(true);
        t3.setText(resourceMap.getString("t3.text")); // NOI18N
        t3.setName("t3"); // NOI18N

        t4.setSelected(true);
        t4.setText(resourceMap.getString("t4.text")); // NOI18N
        t4.setName("t4"); // NOI18N

        t5.setSelected(true);
        t5.setText(resourceMap.getString("t5.text")); // NOI18N
        t5.setName("t5"); // NOI18N

        t6.setSelected(true);
        t6.setText(resourceMap.getString("t6.text")); // NOI18N
        t6.setName("t6"); // NOI18N

        t7.setSelected(true);
        t7.setText(resourceMap.getString("t7.text")); // NOI18N
        t7.setName("t7"); // NOI18N

        t8.setSelected(true);
        t8.setText(resourceMap.getString("t8.text")); // NOI18N
        t8.setName("t8"); // NOI18N

        jLabel28.setText(resourceMap.getString("jLabel28.text")); // NOI18N
        jLabel28.setName("jLabel28"); // NOI18N

        w1.setSelected(true);
        w1.setText(resourceMap.getString("w1.text")); // NOI18N
        w1.setName("w1"); // NOI18N

        w2.setSelected(true);
        w2.setText(resourceMap.getString("w2.text")); // NOI18N
        w2.setName("w2"); // NOI18N

        w3.setSelected(true);
        w3.setText(resourceMap.getString("w3.text")); // NOI18N
        w3.setName("w3"); // NOI18N

        w4.setSelected(true);
        w4.setText(resourceMap.getString("w4.text")); // NOI18N
        w4.setName("w4"); // NOI18N

        w5.setSelected(true);
        w5.setText(resourceMap.getString("w5.text")); // NOI18N
        w5.setName("w5"); // NOI18N

        w6.setSelected(true);
        w6.setText(resourceMap.getString("w6.text")); // NOI18N
        w6.setName("w6"); // NOI18N

        w7.setSelected(true);
        w7.setText(resourceMap.getString("w7.text")); // NOI18N
        w7.setName("w7"); // NOI18N

        w8.setSelected(true);
        w8.setText(resourceMap.getString("w8.text")); // NOI18N
        w8.setName("w8"); // NOI18N

        jLabel29.setText(resourceMap.getString("jLabel29.text")); // NOI18N
        jLabel29.setName("jLabel29"); // NOI18N

        h1.setSelected(true);
        h1.setText(resourceMap.getString("h1.text")); // NOI18N
        h1.setName("h1"); // NOI18N

        h2.setSelected(true);
        h2.setText(resourceMap.getString("h2.text")); // NOI18N
        h2.setName("h2"); // NOI18N

        h3.setSelected(true);
        h3.setText(resourceMap.getString("h3.text")); // NOI18N
        h3.setName("h3"); // NOI18N

        h4.setSelected(true);
        h4.setText(resourceMap.getString("h4.text")); // NOI18N
        h4.setName("h4"); // NOI18N

        h5.setSelected(true);
        h5.setText(resourceMap.getString("h5.text")); // NOI18N
        h5.setName("h5"); // NOI18N

        h6.setSelected(true);
        h6.setText(resourceMap.getString("h6.text")); // NOI18N
        h6.setName("h6"); // NOI18N

        h7.setSelected(true);
        h7.setText(resourceMap.getString("h7.text")); // NOI18N
        h7.setName("h7"); // NOI18N

        h8.setSelected(true);
        h8.setText(resourceMap.getString("h8.text")); // NOI18N
        h8.setName("h8"); // NOI18N

        jLabel30.setText(resourceMap.getString("jLabel30.text")); // NOI18N
        jLabel30.setName("jLabel30"); // NOI18N

        f1.setSelected(true);
        f1.setText(resourceMap.getString("f1.text")); // NOI18N
        f1.setName("f1"); // NOI18N

        f2.setSelected(true);
        f2.setText(resourceMap.getString("f2.text")); // NOI18N
        f2.setName("f2"); // NOI18N

        f3.setSelected(true);
        f3.setText(resourceMap.getString("f3.text")); // NOI18N
        f3.setName("f3"); // NOI18N

        f4.setSelected(true);
        f4.setText(resourceMap.getString("f4.text")); // NOI18N
        f4.setName("f4"); // NOI18N

        f5.setSelected(true);
        f5.setText(resourceMap.getString("f5.text")); // NOI18N
        f5.setName("f5"); // NOI18N

        f6.setSelected(true);
        f6.setText(resourceMap.getString("f6.text")); // NOI18N
        f6.setName("f6"); // NOI18N

        f7.setSelected(true);
        f7.setText(resourceMap.getString("f7.text")); // NOI18N
        f7.setName("f7"); // NOI18N

        f8.setSelected(true);
        f8.setText(resourceMap.getString("f8.text")); // NOI18N
        f8.setName("f8"); // NOI18N

        nol.setName("nol"); // NOI18N

        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setName("jButton9"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        s1.setSelected(true);
        s1.setText(resourceMap.getString("s1.text")); // NOI18N
        s1.setName("s1"); // NOI18N

        s2.setSelected(true);
        s2.setText(resourceMap.getString("s2.text")); // NOI18N
        s2.setName("s2"); // NOI18N

        s3.setSelected(true);
        s3.setText(resourceMap.getString("s3.text")); // NOI18N
        s3.setName("s3"); // NOI18N

        s4.setSelected(true);
        s4.setText(resourceMap.getString("s4.text")); // NOI18N
        s4.setName("s4"); // NOI18N

        s5.setSelected(true);
        s5.setText(resourceMap.getString("s5.text")); // NOI18N
        s5.setName("s5"); // NOI18N

        s6.setText(resourceMap.getString("s6.text")); // NOI18N
        s6.setName("s6"); // NOI18N

        s7.setText(resourceMap.getString("s7.text")); // NOI18N
        s7.setName("s7"); // NOI18N

        s8.setText(resourceMap.getString("s8.text")); // NOI18N
        s8.setName("s8"); // NOI18N

        jLabel32.setText(resourceMap.getString("jLabel32.text")); // NOI18N
        jLabel32.setName("jLabel32"); // NOI18N

        ln.setText(resourceMap.getString("ln.text")); // NOI18N
        ln.setName("ln"); // NOI18N

        jButton18.setText(resourceMap.getString("jButton18.text")); // NOI18N
        jButton18.setName("jButton18"); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LecturersLayout = new javax.swing.GroupLayout(Lecturers.getContentPane());
        Lecturers.getContentPane().setLayout(LecturersLayout);
        LecturersLayout.setHorizontalGroup(
            LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturersLayout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LecturersLayout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(584, 584, 584))
                    .addGroup(LecturersLayout.createSequentialGroup()
                        .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel30)
                                .addGroup(LecturersLayout.createSequentialGroup()
                                    .addComponent(h1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(h2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(h4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h6))
                                .addComponent(jLabel29)
                                .addGroup(LecturersLayout.createSequentialGroup()
                                    .addComponent(w1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(w2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(w3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(w4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(w5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(w6))
                                .addComponent(jLabel28)
                                .addComponent(jLabel27)
                                .addComponent(jLabel26)
                                .addGroup(LecturersLayout.createSequentialGroup()
                                    .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(m1)
                                        .addComponent(t1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(LecturersLayout.createSequentialGroup()
                                            .addComponent(t3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t2))
                                        .addGroup(LecturersLayout.createSequentialGroup()
                                            .addComponent(m2)
                                            .addGap(10, 10, 10)
                                            .addComponent(m3)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(LecturersLayout.createSequentialGroup()
                                            .addComponent(m4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(m5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(m6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(m7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(m8))
                                        .addGroup(LecturersLayout.createSequentialGroup()
                                            .addComponent(t4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(LecturersLayout.createSequentialGroup()
                                                    .addComponent(w7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(w8))
                                                .addGroup(LecturersLayout.createSequentialGroup()
                                                    .addComponent(t7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(t8))
                                                .addGroup(LecturersLayout.createSequentialGroup()
                                                    .addComponent(h7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(h8))
                                                .addGroup(LecturersLayout.createSequentialGroup()
                                                    .addComponent(f7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(f8))
                                                .addGroup(LecturersLayout.createSequentialGroup()
                                                    .addComponent(s7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(s8))))))
                                .addGroup(LecturersLayout.createSequentialGroup()
                                    .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(LecturersLayout.createSequentialGroup()
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ln)
                                                    .addComponent(nol, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4))
                                            .addGroup(LecturersLayout.createSequentialGroup()
                                                .addComponent(f1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(f2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(f3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(f4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(f5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(f6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(LecturersLayout.createSequentialGroup()
                                            .addComponent(s1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(s2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(s3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(s4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(s5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(s6)))
                                    .addGap(10, 10, 10)))
                            .addComponent(jLabel32)
                            .addComponent(jLabel25))
                        .addGap(621, 621, 621))))
        );
        LecturersLayout.setVerticalGroup(
            LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturersLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(ln))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(1, 1, 1)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m1)
                    .addComponent(m2)
                    .addComponent(m3)
                    .addComponent(m4)
                    .addComponent(m5)
                    .addComponent(m6)
                    .addComponent(m7)
                    .addComponent(m8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addGap(7, 7, 7)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t3)
                    .addComponent(t1)
                    .addComponent(t2)
                    .addComponent(t4)
                    .addComponent(t5)
                    .addComponent(t6)
                    .addComponent(t7)
                    .addComponent(t8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(w1)
                    .addComponent(w2)
                    .addComponent(w3)
                    .addComponent(w4)
                    .addComponent(w5)
                    .addComponent(w6)
                    .addComponent(w7)
                    .addComponent(w8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(h1)
                    .addComponent(h2)
                    .addComponent(h3)
                    .addComponent(h4)
                    .addComponent(h5)
                    .addComponent(h6)
                    .addComponent(h7)
                    .addComponent(h8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f1)
                    .addComponent(f2)
                    .addComponent(f3)
                    .addComponent(f4)
                    .addComponent(f5)
                    .addComponent(f7)
                    .addComponent(f6)
                    .addComponent(f8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s1)
                    .addComponent(s2)
                    .addComponent(s3)
                    .addComponent(s4)
                    .addComponent(s5)
                    .addComponent(s7)
                    .addComponent(s6)
                    .addComponent(s8))
                .addGap(59, 59, 59)
                .addGroup(LecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton18))
                .addContainerGap(292, Short.MAX_VALUE))
        );

        Pracs.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Pracs.setTitle(resourceMap.getString("Pracs.title")); // NOI18N
        Pracs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pracs.setMinimumSize(new java.awt.Dimension(570, 290));
        Pracs.setName("Pracs"); // NOI18N
        Pracs.setResizable(false);

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel33.setText(resourceMap.getString("jLabel33.text")); // NOI18N
        jLabel33.setName("jLabel33"); // NOI18N

        jLabel34.setText(resourceMap.getString("jLabel34.text")); // NOI18N
        jLabel34.setName("jLabel34"); // NOI18N

        pcn.setName("pcn"); // NOI18N

        plc.setName("plc"); // NOI18N

        ps.setName("ps"); // NOI18N

        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        pn.setText(resourceMap.getString("pn.text")); // NOI18N
        pn.setName("pn"); // NOI18N

        jLabel35.setText(resourceMap.getString("jLabel35.text")); // NOI18N
        jLabel35.setName("jLabel35"); // NOI18N

        bg.add(c1);
        c1.setText(resourceMap.getString("c1.text")); // NOI18N
        c1.setName("c1"); // NOI18N

        bg.add(c2);
        c2.setText(resourceMap.getString("c2.text")); // NOI18N
        c2.setName("c2"); // NOI18N

        bg.add(c3);
        c3.setText(resourceMap.getString("c3.text")); // NOI18N
        c3.setName("c3"); // NOI18N

        jLabel36.setText(resourceMap.getString("jLabel36.text")); // NOI18N
        jLabel36.setName("jLabel36"); // NOI18N

        javax.swing.GroupLayout PracsLayout = new javax.swing.GroupLayout(Pracs.getContentPane());
        Pracs.getContentPane().setLayout(PracsLayout);
        PracsLayout.setHorizontalGroup(
            PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PracsLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(PracsLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel36)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PracsLayout.createSequentialGroup()
                        .addComponent(pn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PracsLayout.createSequentialGroup()
                        .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pcn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(plc, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(ps, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addGroup(PracsLayout.createSequentialGroup()
                                .addComponent(c1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(c2)
                                .addGap(44, 44, 44)
                                .addComponent(c3)))
                        .addGap(72, 72, 72))))
        );
        PracsLayout.setVerticalGroup(
            PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PracsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addComponent(pn))
                .addGap(18, 18, 18)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(pcn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(17, 17, 17)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c3)
                    .addComponent(c1)
                    .addComponent(c2)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(PracsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PracsLayout.createSequentialGroup()
                        .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(jLabel34))
                .addGap(28, 28, 28))
        );

        Labs.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Labs.setTitle(resourceMap.getString("Labs.title")); // NOI18N
        Labs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Labs.setMinimumSize(dimension);
        Labs.setName("Labs"); // NOI18N
        Labs.setResizable(false);

        jLabel37.setText(resourceMap.getString("jLabel37.text")); // NOI18N
        jLabel37.setName("jLabel37"); // NOI18N

        jLabel39.setText(resourceMap.getString("jLabel39.text")); // NOI18N
        jLabel39.setName("jLabel39"); // NOI18N

        lbn.setName("lbn"); // NOI18N

        ls.setName("ls"); // NOI18N

        jButton10.setText(resourceMap.getString("jButton10.text")); // NOI18N
        jButton10.setName("jButton10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        lbnb.setText(resourceMap.getString("lbnb.text")); // NOI18N
        lbnb.setName("lbnb"); // NOI18N

        jLabel40.setText(resourceMap.getString("jLabel40.text")); // NOI18N
        jLabel40.setName("jLabel40"); // NOI18N

        jButton19.setText(resourceMap.getString("jButton19.text")); // NOI18N
        jButton19.setName("jButton19"); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LabsLayout = new javax.swing.GroupLayout(Labs.getContentPane());
        Labs.getContentPane().setLayout(LabsLayout);
        LabsLayout.setHorizontalGroup(
            LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LabsLayout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addGroup(LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ls)
                    .addComponent(lbn, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(lbnb))
                .addContainerGap(536, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LabsLayout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(596, 596, 596))
        );
        LabsLayout.setVerticalGroup(
            LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LabsLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LabsLayout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LabsLayout.createSequentialGroup()
                        .addComponent(lbnb)
                        .addGap(27, 27, 27)))
                .addGroup(LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LabsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39))
                    .addGroup(LabsLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(ls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(LabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton10))
                .addGap(571, 571, 571))
        );

        Error.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Error.setTitle(resourceMap.getString("Error.title")); // NOI18N
        Error.setMinimumSize(new java.awt.Dimension(277, 140));
        Error.setName("Error"); // NOI18N
        Error.setResizable(false);

        jLabel41.setFont(resourceMap.getFont("jLabel41.font")); // NOI18N
        jLabel41.setText(resourceMap.getString("jLabel41.text")); // NOI18N
        jLabel41.setName("jLabel41"); // NOI18N

        jButton8.setText(resourceMap.getString("jButton8.text")); // NOI18N
        jButton8.setName("jButton8"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGroup(ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ErrorLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(ErrorLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        Result.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Result.setMinimumSize(dimension);
        Result.setName("Result"); // NOI18N
        Result.setResizable(false);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "8-9 AM", "9-10 AM", "10-11 AM", "11-12 AM", "12-1 PM", "2-3 PM", "3-4 PM", "4-5 PM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setName("jTable2"); // NOI18N
        jTable2.setRowHeight(50);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setMinWidth(100);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
        jTable2.getColumnModel().getColumn(1).setMinWidth(100);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable2.getColumnModel().getColumn(2).setMinWidth(100);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable2.getColumnModel().getColumn(3).setMinWidth(100);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N
        jTable2.getColumnModel().getColumn(4).setMinWidth(100);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(4).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N
        jTable2.getColumnModel().getColumn(5).setMinWidth(100);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(5).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTable1.columnModel.title5")); // NOI18N
        jTable2.getColumnModel().getColumn(6).setMinWidth(100);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(6).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable1.columnModel.title6")); // NOI18N
        jTable2.getColumnModel().getColumn(7).setMinWidth(100);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(7).setMaxWidth(500);
        jTable2.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("jTable1.columnModel.title7")); // NOI18N

        jLabel9.setFont(resourceMap.getFont("jLabel9.font")); // NOI18N
        jLabel9.setForeground(resourceMap.getColor("jLabel9.foreground")); // NOI18N
        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        javax.swing.GroupLayout ResultLayout = new javax.swing.GroupLayout(Result.getContentPane());
        Result.getContentPane().setLayout(ResultLayout);
        ResultLayout.setHorizontalGroup(
            ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultLayout.createSequentialGroup()
                .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        ResultLayout.setVerticalGroup(
            ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        Error2.setTitle(resourceMap.getString("Error2.title")); // NOI18N
        Error2.setMinimumSize(new java.awt.Dimension(320, 190));
        Error2.setName("Error2"); // NOI18N

        jLabel42.setText(resourceMap.getString("jLabel42.text")); // NOI18N
        jLabel42.setName("jLabel42"); // NOI18N

        jButton11.setText(resourceMap.getString("jButton11.text")); // NOI18N
        jButton11.setName("jButton11"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel44.setText(resourceMap.getString("jLabel44.text")); // NOI18N
        jLabel44.setName("jLabel44"); // NOI18N

        jLabel45.setText(resourceMap.getString("jLabel45.text")); // NOI18N
        jLabel45.setName("jLabel45"); // NOI18N

        javax.swing.GroupLayout Error2Layout = new javax.swing.GroupLayout(Error2.getContentPane());
        Error2.getContentPane().setLayout(Error2Layout);
        Error2Layout.setHorizontalGroup(
            Error2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Error2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Error2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel44))
            .addGroup(Error2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Error2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel45))
        );
        Error2Layout.setVerticalGroup(
            Error2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Error2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addGap(27, 27, 27)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        corses.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        corses.setTitle(resourceMap.getString("corses.title")); // NOI18N
        corses.setMinimumSize(dimension);
        corses.setName("corses"); // NOI18N

        jLabel43.setText(resourceMap.getString("jLabel43.text")); // NOI18N
        jLabel43.setName("jLabel43"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        ccc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo.", "Course Name", "Lectures", "Tutorials", "Labs", "Lab Code", "Instructor", "Batch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ccc.setName("ccc"); // NOI18N
        jScrollPane3.setViewportView(ccc);
        ccc.getColumnModel().getColumn(0).setPreferredWidth(50);
        ccc.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("ccc.columnModel.title0")); // NOI18N
        ccc.getColumnModel().getColumn(1).setPreferredWidth(200);
        ccc.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("ccc.columnModel.title1")); // NOI18N
        ccc.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("ccc.columnModel.title2")); // NOI18N
        ccc.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("ccc.columnModel.title3")); // NOI18N
        ccc.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("ccc.columnModel.title4")); // NOI18N
        ccc.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("ccc.columnModel.title5")); // NOI18N
        ccc.getColumnModel().getColumn(6).setPreferredWidth(200);
        ccc.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("ccc.columnModel.title6")); // NOI18N
        ccc.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("ccc.columnModel.title7")); // NOI18N

        Cn.setText(resourceMap.getString("Cn.text")); // NOI18N
        Cn.setName("Cn"); // NOI18N

        Lc.setName("Lc"); // NOI18N

        Cds.setName("Cds"); // NOI18N

        Batch.setName("Batch"); // NOI18N

        Tut.setName("Tut"); // NOI18N

        Lab.setName("Lab"); // NOI18N

        Labcode.setName("Labcode"); // NOI18N

        jButton12.setText(resourceMap.getString("jButton12.text")); // NOI18N
        jButton12.setName("jButton12"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText(resourceMap.getString("jButton13.text")); // NOI18N
        jButton13.setName("jButton13"); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText(resourceMap.getString("jButton14.text")); // NOI18N
        jButton14.setName("jButton14"); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel47.setText(resourceMap.getString("jLabel47.text")); // NOI18N
        jLabel47.setName("jLabel47"); // NOI18N

        jLabel48.setText(resourceMap.getString("jLabel48.text")); // NOI18N
        jLabel48.setName("jLabel48"); // NOI18N

        jButton20.setText(resourceMap.getString("jButton20.text")); // NOI18N
        jButton20.setName("jButton20"); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout corsesLayout = new javax.swing.GroupLayout(corses.getContentPane());
        corses.getContentPane().setLayout(corsesLayout);
        corsesLayout.setHorizontalGroup(
            corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corsesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(corsesLayout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(corsesLayout.createSequentialGroup()
                        .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, corsesLayout.createSequentialGroup()
                                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(corsesLayout.createSequentialGroup()
                                        .addComponent(Cds, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Tut, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Labcode, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Lc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Batch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(485, 485, 485))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, corsesLayout.createSequentialGroup()
                .addGap(489, 489, 489)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(647, 647, 647))
        );
        corsesLayout.setVerticalGroup(
            corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corsesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel12))
                .addGap(32, 32, 32)
                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Labcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Batch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(corsesLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(corsesLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)))
                .addGap(33, 33, 33)
                .addGroup(corsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        Error3.setTitle(resourceMap.getString("Error3.title")); // NOI18N
        Error3.setMinimumSize(new java.awt.Dimension(271, 130));
        Error3.setName("Error3"); // NOI18N

        jLabel46.setText(resourceMap.getString("jLabel46.text")); // NOI18N
        jLabel46.setName("jLabel46"); // NOI18N

        jButton15.setText(resourceMap.getString("jButton15.text")); // NOI18N
        jButton15.setName("jButton15"); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Error3Layout = new javax.swing.GroupLayout(Error3.getContentPane());
        Error3.getContentPane().setLayout(Error3Layout);
        Error3Layout.setHorizontalGroup(
            Error3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Error3Layout.createSequentialGroup()
                .addGroup(Error3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Error3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Error3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        Error3Layout.setVerticalGroup(
            Error3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Error3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        Result1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Result1.setMinimumSize(dimension);
        Result1.setName("Result1"); // NOI18N
        Result1.setResizable(false);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "8-9 AM", "9-10 AM", "10-11 AM", "11-12 AM", "12-1 PM", "2-3 PM", "3-4 PM", "4-5 PM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setName("jTable3"); // NOI18N
        jTable3.setRowHeight(50);
        jScrollPane4.setViewportView(jTable3);
        jTable3.getColumnModel().getColumn(0).setMinWidth(100);
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
        jTable3.getColumnModel().getColumn(1).setMinWidth(100);
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(1).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable3.getColumnModel().getColumn(2).setMinWidth(100);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(2).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable3.getColumnModel().getColumn(3).setMinWidth(100);
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(3).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N
        jTable3.getColumnModel().getColumn(4).setMinWidth(100);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(4).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N
        jTable3.getColumnModel().getColumn(5).setMinWidth(100);
        jTable3.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(5).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTable1.columnModel.title5")); // NOI18N
        jTable3.getColumnModel().getColumn(6).setMinWidth(100);
        jTable3.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(6).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable1.columnModel.title6")); // NOI18N
        jTable3.getColumnModel().getColumn(7).setMinWidth(100);
        jTable3.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable3.getColumnModel().getColumn(7).setMaxWidth(500);
        jTable3.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("jTable1.columnModel.title7")); // NOI18N

        jLabel49.setFont(resourceMap.getFont("jLabel49.font")); // NOI18N
        jLabel49.setForeground(resourceMap.getColor("jLabel49.foreground")); // NOI18N
        jLabel49.setText(resourceMap.getString("jLabel49.text")); // NOI18N
        jLabel49.setName("jLabel49"); // NOI18N

        javax.swing.GroupLayout Result1Layout = new javax.swing.GroupLayout(Result1.getContentPane());
        Result1.getContentPane().setLayout(Result1Layout);
        Result1Layout.setHorizontalGroup(
            Result1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Result1Layout.createSequentialGroup()
                .addGroup(Result1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Result1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Result1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        Result1Layout.setVerticalGroup(
            Result1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Result1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    Constraints.setVisible(true);
    //Constraints.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
}//GEN-LAST:event_jButton1ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
 Generation.setVisible(true);

}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    Generation.setVisible(true);
}//GEN-LAST:event_jButton2ActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
Constraints.setVisible(true);
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
// TODO add your handling code here:
    if(condec==1){
    Result.setVisible(true);
    tabout1();
    }
    else
    Error.setVisible(true);    
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
     if(condec==1){
    Result.setVisible(true);
    tabout1();
    }
    else
    Error.setVisible(true);    
                            
}//GEN-LAST:event_jButton3ActionPerformed

private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
System.exit(0);
// TODO add your handling code here:
}//GEN-LAST:event_fileMenuActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
String t;
    t=courses.getText();
    c=Integer.parseInt(t);
    t=lectures.getText();
    l=Integer.parseInt(t);
    t=rooms.getText();
    r=Integer.parseInt(t);
    //t=pracs.getText();
    //p=Integer.parseInt(t);
    t=labs.getText();
    lb=Integer.parseInt(t);
    Constraints.dispose();
    Lecturers.setVisible(true);
   // Lecturers.setVisible(true);
    //Room.setVisible(true);
    // TODO add your handling code here:
    
    
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
int check;
    String t;
    t=ctc.getText();
    check=Integer.parseInt(t);
    if(check<=l)
    { CSN[i]=csn.getText();
     t=ctc.getText();
     CTC[i]=Integer.parseInt(t);
     t=ns.getText();
     NS[i]=Integer.parseInt(t);
     i++;
     if(i!=c)
    { //csn.setText("");
        ctc.setText("");
     //ns.setText("");
      t=String.valueOf((i+1));
      cn.setText(t);
     }
    else{
        Courses.dispose();
        csn.setText("");
        ctc.setText("");
        ns.setText("");
        i=0;
        cn.setText("1");
        Pracs.setVisible(true);
       }
    }
    else{
        //Error2.setVisible(true);
        t=String.valueOf((l));
        ctc.setText("Error Here its b/w 1-"+t);
    }

    // TODO add your handling code here:
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
String t;

    LN[i]=nol.getText();
    for(int k=0;k<6;k++)
    for(int j=0;j<8;j++)
        H[k][j][i]=0;
    if(m1.isSelected())H[0][0][i]=1;
    if(m2.isSelected())H[0][1][i]=1;
    if(m3.isSelected())H[0][2][i]=1;
    if(m4.isSelected())H[0][3][i]=1;
    if(m5.isSelected())H[0][4][i]=1;
    if(m6.isSelected())H[0][5][i]=1;
    if(m7.isSelected())H[0][6][i]=1;
    if(m8.isSelected())H[0][7][i]=1;
    if(t1.isSelected())H[1][0][i]=1;
    if(t2.isSelected())H[1][1][i]=1;
    if(t3.isSelected())H[1][2][i]=1;
    if(t4.isSelected())H[1][3][i]=1;
    if(t5.isSelected())H[1][4][i]=1;
    if(t6.isSelected())H[1][5][i]=1;
    if(t7.isSelected())H[1][6][i]=1;
    if(t8.isSelected())H[1][7][i]=1;
    if(w1.isSelected())H[2][0][i]=1;
    if(w2.isSelected())H[2][1][i]=1;
    if(w3.isSelected())H[2][2][i]=1;
    if(w4.isSelected())H[2][3][i]=1;
    if(w5.isSelected())H[2][4][i]=1;
    if(w6.isSelected())H[2][5][i]=1;
    if(w7.isSelected())H[2][6][i]=1;
    if(w8.isSelected())H[2][7][i]=1;    
    if(h1.isSelected())H[3][0][i]=1;
    if(h2.isSelected())H[3][1][i]=1;
    if(h3.isSelected())H[3][2][i]=1;
    if(h4.isSelected())H[3][3][i]=1;
    if(h5.isSelected())H[3][4][i]=1;
    if(h6.isSelected())H[3][5][i]=1;
    if(h7.isSelected())H[3][6][i]=1;
    if(h8.isSelected())H[3][7][i]=1;
    if(f1.isSelected())H[4][0][i]=1;
    if(f2.isSelected())H[4][1][i]=1;
    if(f3.isSelected())H[4][2][i]=1;
    if(f4.isSelected())H[4][3][i]=1;
    if(f5.isSelected())H[4][4][i]=1;
    if(f6.isSelected())H[4][5][i]=1;
    if(f7.isSelected())H[4][6][i]=1;
    if(f8.isSelected())H[4][7][i]=1;
    if(s1.isSelected())H[5][0][i]=1;
    if(s2.isSelected())H[5][1][i]=1;
    if(s3.isSelected())H[5][2][i]=1;
    if(s4.isSelected())H[5][3][i]=1;
    if(s5.isSelected())H[5][4][i]=1;
    if(s6.isSelected())H[5][5][i]=1;
    if(s7.isSelected())H[5][6][i]=1;
    if(s8.isSelected())H[5][7][i]=1; 
     i++;
    if(i!=l)
    {nol.setText("");
   
    t=String.valueOf((i+1));
    ln.setText(t);  
        }
    else{
        Lecturers.dispose();
        i=0;
        nol.setText("");
        ln.setText("1");
        Labs.setVisible(true);
    }
     // TODO add your handling code here:
}//GEN-LAST:event_jButton9ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
String t;
FileOutputStream fout;
    RNM[i]=rnm.getText();
    t=rc.getText();
    RC[i]=Integer.parseInt(t);
    for(int k=0;k<6;k++)
    for(int j=0;j<8;j++)
        HR[k][j][i]=0;
    if(jCheckBox51.isSelected())HR[0][0][i]=1;
    if(jCheckBox52.isSelected())HR[0][1][i]=1;
    if(jCheckBox53.isSelected())HR[0][2][i]=1;
    if(jCheckBox54.isSelected())HR[0][3][i]=1;
    if(jCheckBox55.isSelected())HR[0][4][i]=1;
    if(jCheckBox56.isSelected())HR[0][5][i]=1;
    if(jCheckBox57.isSelected())HR[0][6][i]=1;
    if(jCheckBox58.isSelected())HR[0][7][i]=1;
    if(jCheckBox61.isSelected())HR[1][0][i]=1;
    if(jCheckBox62.isSelected())HR[1][1][i]=1;
    if(jCheckBox63.isSelected())HR[1][2][i]=1;
    if(jCheckBox64.isSelected())HR[1][3][i]=1;
    if(jCheckBox65.isSelected())HR[1][4][i]=1;
    if(jCheckBox66.isSelected())HR[1][5][i]=1;
    if(jCheckBox67.isSelected())HR[1][6][i]=1;
    if(jCheckBox68.isSelected())HR[1][7][i]=1;
    if(jCheckBox71.isSelected())HR[2][0][i]=1;
    if(jCheckBox72.isSelected())HR[2][1][i]=1;
    if(jCheckBox73.isSelected())HR[2][2][i]=1;
    if(jCheckBox74.isSelected())HR[2][3][i]=1;
    if(jCheckBox75.isSelected())HR[2][4][i]=1;
    if(jCheckBox76.isSelected())HR[2][5][i]=1;
    if(jCheckBox77.isSelected())HR[2][6][i]=1;
    if(jCheckBox78.isSelected())HR[2][7][i]=1;    
    if(jCheckBox81.isSelected())HR[3][0][i]=1;
    if(jCheckBox82.isSelected())HR[3][1][i]=1;
    if(jCheckBox83.isSelected())HR[3][2][i]=1;
    if(jCheckBox84.isSelected())HR[3][3][i]=1;
    if(jCheckBox85.isSelected())HR[3][4][i]=1;
    if(jCheckBox86.isSelected())HR[3][5][i]=1;
    if(jCheckBox87.isSelected())HR[3][6][i]=1;
    if(jCheckBox88.isSelected())HR[3][7][i]=1;
    if(jCheckBox91.isSelected())HR[4][0][i]=1;
    if(jCheckBox92.isSelected())HR[4][1][i]=1;
    if(jCheckBox93.isSelected())HR[4][2][i]=1;
    if(jCheckBox94.isSelected())HR[4][3][i]=1;
    if(jCheckBox95.isSelected())HR[4][4][i]=1;
    if(jCheckBox96.isSelected())HR[4][5][i]=1;
    if(jCheckBox97.isSelected())HR[4][6][i]=1;
    if(jCheckBox98.isSelected())HR[4][7][i]=1;
    if(jCheckBox1.isSelected())HR[5][0][i]=1;
    if(jCheckBox2.isSelected())HR[5][1][i]=1;
    if(jCheckBox3.isSelected())HR[5][2][i]=1;
    if(jCheckBox4.isSelected())HR[5][3][i]=1;
    if(jCheckBox5.isSelected())HR[5][4][i]=1;
    if(jCheckBox6.isSelected())HR[5][5][i]=1;
    if(jCheckBox7.isSelected())HR[5][6][i]=1;
    if(jCheckBox8.isSelected())HR[5][7][i]=1; 
    i++;
    System.out.println(i);
    if(i!=r)
    {rnm.setText("");
    //rc.setText("");
    
    t=String.valueOf((i+1));
    rn.setText(t);  
        }
    else{i=0;
    rnm.setText("");
    rc.setText("");
        Room.dispose();
        rn.setText("1");        
        try{ int zero='0';
            BufferedWriter out=new BufferedWriter(new FileWriter("csll.ctr"));
            out.write("2nd semester\n");
            out.write(".Courses.\n"); 
            t=String.valueOf((cx));
            out.write(t);out.newLine();
            out.write("0\n");
            for(i=0;i<cx;i++)
            {out.write(CSNX[i]);out.newLine();
            out.write(CTCX[i]-1+zero);out.newLine();
            t=String.valueOf((LBatchX[i]));
            out.write(t);out.newLine();
            t=String.valueOf((NSX[i]));
            out.write(t);out.newLine();
            out.write((i/10)+zero);out.newLine();
            out.write((i%10)+zero);out.newLine();
            t=String.valueOf((i+1));
            out.write(t);out.newLine();
            }
            out.write(".Practicals.\n");
            
            t=String.valueOf((p));
            out.write(t);out.newLine();
            for(i=0;i<p;i++)
            {out.write(PN[i]);out.newLine();
            out.write(PL[i]-1+zero);out.newLine();
            out.write(PBatch[i]+zero);out.newLine();
            t=String.valueOf((PS[i]));
            out.write(t);out.newLine();
            
            }
            out.write(".Tutorials.\n");
            System.out.println("hellox");
            t=String.valueOf((tut));
            out.write(t);out.newLine();
            for(i=0;i<tut;i++)
            {out.write(TUTOR[i]);out.newLine();            
            out.write(TBatch[i]+zero);out.newLine();
                        
            }
            out.write(".Lectureres.\n");
            t=String.valueOf((l));
            out.write(t);out.newLine();
            for(i=0;i<l;i++)
            {out.write(LN[i]);out.newLine();
            out.write((i/10)+zero);out.newLine();
            out.write((i%10)+zero);out.newLine();
            for(int k=0;k<6;k++)
              { for(int j=0;j<8;j++)
                out.write(H[k][j][i]+zero);
                out.newLine();
              }
            }
            out.write(".rooms.\n");
            out.write(r+zero);out.newLine();
            for(i=0;i<r;i++)
            {out.write(RNM[i]);out.newLine();
            t=String.valueOf((RC[i]));
            out.write(t);out.newLine();            
            out.write((i/10)+zero);out.newLine();
            out.write((i%10)+zero);out.newLine();
            for(int k=0;k<6;k++)
              { for(int j=0;j<8;j++)
                out.write(HR[k][j][i]+zero);
                out.newLine();
              }
            }
            out.write(".Labs.\n");
            out.write(lb+zero);out.newLine();
            for(i=0;i<lb;i++)
            {out.write(LBN[i]);out.newLine();
            t=String.valueOf((LS[i]));
            out.write(t);out.newLine();
            out.write((i/10)+zero);out.newLine();
            out.write((i%10)+zero);out.newLine();
            for(int k=0;k<6;k++)
              { for(int j=0;j<8;j++)
                out.write("1");
                out.newLine();
              }
            }
            out.close();
        }catch(IOException e){
            System.out.print("Error Opening Output File");
        }
        
        condec=1;   
       
        
    }// TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        String t;
        int check;
        t=plc.getText();
    check=Integer.parseInt(t);
    if(check<=lb)
    {  t=pcn.getText();
        if(c1.isSelected())t=t+"C1";
        if(c2.isSelected())t=t+"C2";
        if(c3.isSelected())t=t+"C3" ;   
     
     PN[i]=t;
    t=plc.getText();
    PL[i]=Integer.parseInt(t);
    t=ps.getText();
    PS[i]=Integer.parseInt(t);
    i++;
    if(i!=p)
    { //pcn.setText("");
         //plc.setText("");
     //ps.setText("");
      t=String.valueOf((i+1));
      pn.setText(t);
     }
    else{
        Pracs.dispose();
        pcn.setText("");
        plc.setText("");
        ps.setText("");
        i=0;
        pn.setText("1");
        Labs.setVisible(true);
       }
    }  
    else{
        //Error2.setVisible(true);
        t=String.valueOf((lb));        
        plc.setText("Error Here its b/w 1-"+t);
    }
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
// TODO add your handling code here:
    String t;
    LBN[i]=lbn.getText();
    t=ls.getText();
    LS[i]=Integer.parseInt(t);
    i++;
    if(i!=lb)
    { //lbn.setText("");
        //ls.setText("");
      t=String.valueOf((i+1));
      lbnb.setText(t);
     }
    else{
        Labs.dispose();
        lbn.setText("");
        ls.setText("");
        i=0;
        lbnb.setText("1");
        corses.setVisible(true);
        
        Labcode.setModel(new javax.swing.DefaultComboBoxModel(LBN));
        Lc.setModel(new javax.swing.DefaultComboBoxModel(LN));
        Tut.addItem("0");
        Tut.addItem("1");
        Lab.addItem("0");
        Lab.addItem("1");
        
        Cds.addItem("1");
         Cds.addItem("2");
          Cds.addItem("3");
        Batch.addItem("2nd year");
        Batch.addItem("3rd year");
        Batch.addItem("final year");
        t=String.valueOf(c);
        jLabel48.setText(t);
        
    }
    
}//GEN-LAST:event_jButton10ActionPerformed

private void genActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genActionPerformed
// TODO add your handling code here:
       if(condec==1){
           count1=0;
       
        String str;
     str = "<html>" + "<font color=\"#008000\">" + "<b>" + "GENERATING ....." + "</b>" + "</font>" + "</html>";
     gn.setText(str);
   Thread t = new Thread(new NewThread()); 
   t.start();
       }
       else{
           Error.setVisible(true);
       }


}//GEN-LAST:event_genActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
Error.dispose();
    // TODO add your handling code here:
}//GEN-LAST:event_jButton8ActionPerformed

private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
Error2.dispose();// TODO add your handling code here:
}//GEN-LAST:event_jButton11ActionPerformed

private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
String t;

DefaultTableModel m= (DefaultTableModel)ccc.getModel();
ccc.getModel();
int row=m.getRowCount();
if(row <c){
t=Cn.getText();
CSN[i]=t;
NS[i]=70;
LBatch[i]=Batch.getSelectedIndex()+1;
CTC[i]=Lc.getSelectedIndex()+1;
LCRS[i]=Cds.getSelectedIndex()+1;
Ltut[i]=Tut.getSelectedIndex();
Llabc[i]=Labcode.getSelectedIndex()+1;
Llab[i]=Lab.getSelectedIndex();        

m.addRow(new Object[] {row+1,CSN[i],LCRS[i],Ltut[i],Llab[i],Llabc[i],LN[CTC[i]-1],LBatch[i]});
i++;
}

else{
   
    Error2.setVisible(true);
};


    // TODO add your handling code here:
}//GEN-LAST:event_jButton12ActionPerformed

private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

    // TODO add your handling code here:
    String t;

DefaultTableModel m= (DefaultTableModel)ccc.getModel();
ccc.getModel();
int row=m.getRowCount();

if(row>0)
{
  m.removeRow(row-1);
  i--;
}

}//GEN-LAST:event_jButton13ActionPerformed

private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

DefaultTableModel m= (DefaultTableModel)ccc.getModel();
ccc.getModel();
int row=m.getRowCount();
cx=0;p=0;tut=0;
if(row==c)
{
    for(int a=0;a<=c;a++)
    { 
        
        if(Llab[a]==1)
        {
          PN[p]=CSN[a]+"C1";
          PL[p]=Llabc[a];
          PBatch[p]=LBatch[a];
          p++;
          PN[p]=CSN[a]+"C2";
          PL[p]=Llabc[a];
          PBatch[p]=LBatch[a];
          p++;
          PN[p]=CSN[a]+"C3";
          PL[p]=Llabc[a];
          PBatch[p]=LBatch[a];
          p++;                
          
        }
        if(Ltut[a]==1)
        {TUTOR[tut]=CSN[a]+"C1";
         TBatch[tut]=LBatch[a];
          //PL[p]=Llabc[a];
          //PBatch[p]=LBatch[a];
          tut++;
          TUTOR[tut]=CSN[a]+"C2";
          TBatch[tut]=LBatch[a];
          //PL[p]=Llabc[a];
          //PBatch[p]=LBatch[a];
          tut++;
          TUTOR[tut]=CSN[a]+"C3";
          TBatch[tut]=LBatch[a];
          //PL[p]=Llabc[a];
          //PBatch[p]=LBatch[a];
          tut++;
            
        }
        
        
        
    }
    for(int k=0;k<3;k++)
    for(int l=0;l<=c;l++)
    {
        if((LCRS[l])!=0)
        { CSNX[cx]=CSN[l];
          CTCX[cx]=CTC[l];
          NSX[cx]=NS[l];
          LBatchX[cx]=LBatch[l];
          LCRS[l]=LCRS[l]-1;
          cx++;
        }
        
    }
        
   i=0;
  corses.dispose();
  Room.setVisible(true);
}
else {
Error3.setVisible(true);
}
}//GEN-LAST:event_jButton14ActionPerformed

private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
Error3.dispose();// TODO add your handling code here:
}//GEN-LAST:event_jButton15ActionPerformed

private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
// TODO add your handling code here:
    if(condec==1){
    Result1.setVisible(true);
    tabout2();
    }
    else
    Error.setVisible(true);    
    
}//GEN-LAST:event_jButton16ActionPerformed

private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
Constraints.dispose();// TODO add your handling code here:
}//GEN-LAST:event_jButton17ActionPerformed

private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
if(i!=0){
    i--;
    nol.setText(LN[i]);
    String t=String.valueOf((i+1));
    ln.setText(t); 
}
else{
Lecturers.dispose();  
Constraints.setVisible(true);
}
    // TODO add your handling code here:
}//GEN-LAST:event_jButton18ActionPerformed

private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
String t;
    if(i!=0){
    
    i--;
    lbn.setText(LBN[i]);
    t=String.valueOf(LS[i]);
    ls.setText(t);
    t=String.valueOf((i+1));
      lbnb.setText(t);
    }
else{
    Labs.dispose();
    Lecturers.setVisible(true);
    i=l-1;
    nol.setText(LN[i]);
    t=String.valueOf((i+1));
    ln.setText(t);
    
}// TODO add your handling code here:
}//GEN-LAST:event_jButton19ActionPerformed

private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
corses.dispose();
        Tut.removeAllItems();
        
        Lab.removeAllItems();
        
        Cds.removeAllItems();
        Batch.removeAllItems();
Labs.setVisible(true);
String t;
i=lb-1;
lbn.setText(LBN[i]);
    t=String.valueOf(LS[i]);
    ls.setText(t);
    t=String.valueOf((i+1));
      lbnb.setText(t);
    // TODO add your handling code here:
}//GEN-LAST:event_jButton20ActionPerformed

private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
if(i!=0){
i--;
String t;
rnm.setText(RNM[i]);
t=String.valueOf(RC[i]);    
rc.setText(t);
 
    t=String.valueOf((i+1));
    rn.setText(t); 

}
else{
    corses.setVisible(true);
    i=c;
}// TODO add your handling code here:
}//GEN-LAST:event_jButton21ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
if(condec==1){
    Result1.setVisible(true);
    tabout2();
    }
    else
    Error.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jMenuItem4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Batch;
    private javax.swing.JComboBox Cds;
    private javax.swing.JTextField Cn;
    private javax.swing.JFrame Constraints;
    private javax.swing.JFrame Courses;
    private javax.swing.JFrame Error;
    private javax.swing.JFrame Error2;
    private javax.swing.JFrame Error3;
    private javax.swing.JFrame Generation;
    private javax.swing.JComboBox Lab;
    private javax.swing.JComboBox Labcode;
    private javax.swing.JFrame Labs;
    private javax.swing.JComboBox Lc;
    private javax.swing.JFrame Lecturers;
    private javax.swing.JProgressBar PB;
    private javax.swing.JFrame Pracs;
    private javax.swing.JFrame Result;
    private javax.swing.JFrame Result1;
    private javax.swing.JFrame Room;
    private javax.swing.JComboBox Tut;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JRadioButton c1;
    private javax.swing.JRadioButton c2;
    private javax.swing.JRadioButton c3;
    private javax.swing.JTable ccc;
    private javax.swing.JLabel cn;
    private javax.swing.JFrame corses;
    private javax.swing.JTextField courses;
    private javax.swing.JTextField csn;
    private javax.swing.JTextField ctc;
    private javax.swing.JCheckBox f1;
    private javax.swing.JCheckBox f2;
    private javax.swing.JCheckBox f3;
    private javax.swing.JCheckBox f4;
    private javax.swing.JCheckBox f5;
    private javax.swing.JCheckBox f6;
    private javax.swing.JCheckBox f7;
    private javax.swing.JCheckBox f8;
    private javax.swing.JButton gen;
    private javax.swing.JLabel gn;
    private javax.swing.JCheckBox h1;
    private javax.swing.JCheckBox h2;
    private javax.swing.JCheckBox h3;
    private javax.swing.JCheckBox h4;
    private javax.swing.JCheckBox h5;
    private javax.swing.JCheckBox h6;
    private javax.swing.JCheckBox h7;
    private javax.swing.JCheckBox h8;
    private javax.swing.JLabel hpp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox53;
    private javax.swing.JCheckBox jCheckBox54;
    private javax.swing.JCheckBox jCheckBox55;
    private javax.swing.JCheckBox jCheckBox56;
    private javax.swing.JCheckBox jCheckBox57;
    private javax.swing.JCheckBox jCheckBox58;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox61;
    private javax.swing.JCheckBox jCheckBox62;
    private javax.swing.JCheckBox jCheckBox63;
    private javax.swing.JCheckBox jCheckBox64;
    private javax.swing.JCheckBox jCheckBox65;
    private javax.swing.JCheckBox jCheckBox66;
    private javax.swing.JCheckBox jCheckBox67;
    private javax.swing.JCheckBox jCheckBox68;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox71;
    private javax.swing.JCheckBox jCheckBox72;
    private javax.swing.JCheckBox jCheckBox73;
    private javax.swing.JCheckBox jCheckBox74;
    private javax.swing.JCheckBox jCheckBox75;
    private javax.swing.JCheckBox jCheckBox76;
    private javax.swing.JCheckBox jCheckBox77;
    private javax.swing.JCheckBox jCheckBox78;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox81;
    private javax.swing.JCheckBox jCheckBox82;
    private javax.swing.JCheckBox jCheckBox83;
    private javax.swing.JCheckBox jCheckBox84;
    private javax.swing.JCheckBox jCheckBox85;
    private javax.swing.JCheckBox jCheckBox86;
    private javax.swing.JCheckBox jCheckBox87;
    private javax.swing.JCheckBox jCheckBox88;
    private javax.swing.JCheckBox jCheckBox91;
    private javax.swing.JCheckBox jCheckBox92;
    private javax.swing.JCheckBox jCheckBox93;
    private javax.swing.JCheckBox jCheckBox94;
    private javax.swing.JCheckBox jCheckBox95;
    private javax.swing.JCheckBox jCheckBox96;
    private javax.swing.JCheckBox jCheckBox97;
    private javax.swing.JCheckBox jCheckBox98;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField labs;
    private javax.swing.JTextField lbn;
    private javax.swing.JLabel lbnb;
    private javax.swing.JTextField lectures;
    private javax.swing.JLabel ln;
    private javax.swing.JTextField ls;
    private javax.swing.JCheckBox m1;
    private javax.swing.JCheckBox m2;
    private javax.swing.JCheckBox m3;
    private javax.swing.JCheckBox m4;
    private javax.swing.JCheckBox m5;
    private javax.swing.JCheckBox m6;
    private javax.swing.JCheckBox m7;
    private javax.swing.JCheckBox m8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField nol;
    private javax.swing.JTextField ns;
    private javax.swing.JTextField pcn;
    private javax.swing.JTextField plc;
    private javax.swing.JLabel pn;
    private javax.swing.JTextField ps;
    private javax.swing.JTextField rc;
    private javax.swing.JLabel rn;
    private javax.swing.JTextField rnm;
    private javax.swing.JTextField rooms;
    private javax.swing.JCheckBox s1;
    private javax.swing.JCheckBox s2;
    private javax.swing.JCheckBox s3;
    private javax.swing.JCheckBox s4;
    private javax.swing.JCheckBox s5;
    private javax.swing.JCheckBox s6;
    private javax.swing.JCheckBox s7;
    private javax.swing.JCheckBox s8;
    private javax.swing.JCheckBox t1;
    private javax.swing.JCheckBox t2;
    private javax.swing.JCheckBox t3;
    private javax.swing.JCheckBox t4;
    private javax.swing.JCheckBox t5;
    private javax.swing.JCheckBox t6;
    private javax.swing.JCheckBox t7;
    private javax.swing.JCheckBox t8;
    private javax.swing.JCheckBox w1;
    private javax.swing.JCheckBox w2;
    private javax.swing.JCheckBox w3;
    private javax.swing.JCheckBox w4;
    private javax.swing.JCheckBox w5;
    private javax.swing.JCheckBox w6;
    private javax.swing.JCheckBox w7;
    private javax.swing.JCheckBox w8;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    
}
