import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import javax.swing.plaf.ColorUIResource;
class sttr extends TimerTask implements ActionListener,ItemListener {

    Label l,l1,l2,l3;
    Choice ab,cb1,cb2,cb3,cb4;
    Frame f,f1;
    TextArea t;
    TextField tx;
    JButton ex,info,b1,b2;
    MenuBar mb;
    MenuItem nw,save,save_as,exit,open,font,color,cut,undo,redo,DarkMode,LightMode;
    Menu file,edit,view,Mode;
    String txt,a,u,rd;
    Color c,c1,c2,c3,c4,c5,c6;
    int flag=1;
    int m,n,o,p,q,r,b=15;
    void txta(String a,int b, Color c1,Color c2 ){
      t.setFont(new Font(a,Font.BOLD,b));
      t.setForeground(c1); 
      t.setBackground(c2); 
    }
    sttr(){
        c=new ColorUIResource(38,43,47);
        c1=new ColorUIResource( 1,1,39);
        c2=new ColorUIResource( 0,120,120);
        c3=new ColorUIResource( 0,120,144);
        c4=new ColorUIResource( 18,3,33);
        c5=new ColorUIResource( 50,23,77);
        c6=new ColorUIResource( 182,182,180);
        
       
        f=new Frame("Notepad");
        f.setLayout(null);
        f.setBounds(100,100,600,700);
        f.setBackground(c);
        mb=new MenuBar();
        mb.setFont(new Font("Arial",Font.BOLD,30));

        file=new Menu("File");
        file.setFont(new Font("arial",Font.BOLD,20));
        file.add(nw=new MenuItem("New"));
        nw.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,10));
        file.add(save=new MenuItem("Save"));
        save.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,10));
        file.add(save_as=new MenuItem("Save As"));
        save_as.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,10));
        file.addSeparator();
        file.add(exit=new MenuItem("Exit"));
        exit.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,10));
       
        mb.add(file);

        edit=new Menu("Edit");
        edit.setFont(new Font("arial",Font.BOLD,20));
        edit.add(font=new MenuItem("Font and Color"));
        font.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,10));
       
        edit.add(cut=new MenuItem("Cut all"));
        cut.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,10));

        mb.add(edit);

        view=new Menu("View");
        view.setFont(new Font("arial",Font.BOLD,20));
        view.add(open=new MenuItem("Open"));
        
        mb.add(view);
        f.setMenuBar(mb);
        f.add(t=new TextArea());
        txta(a,b,Color.WHITE,c1);
        t.setBounds(30,60,540,450);
        Mode=new Menu("Mode");
        Mode.setFont(new Font("arial",Font.BOLD,20));

        Mode.add(DarkMode=new MenuItem("Dark Mode"));
        Mode.add(LightMode=new MenuItem("Light Mode"));
       mb.add(Mode);
        // t.setCursor(Cursor.getDefaultCursor());
        f.add(ex=new JButton("Exit"));
        ex.setFont(new Font("arial",Font.BOLD,20));
        ex.setBounds(70,560,80,40);
        ex.setBackground(c3);
        f.add(info=new JButton("Info"));
        info.setFont(new Font("arial",Font.BOLD,20));
        info.setBounds(450,560,80,40);
        info.setBackground(c3);
        f.add(tx=new TextField());
        tx.setBounds(50, 650,500,30);
        tx.setForeground(Color.WHITE);
        tx.setText("No file chosen");
        tx.setBackground(c);
        tx.setEditable(false);

        nw.addActionListener(this);
        ex.addActionListener(this);
        save.addActionListener(this);
        save_as.addActionListener(this);
        exit.addActionListener(this);
        open.addActionListener(this);
        font.addActionListener(this);
        cut.addActionListener(this);
        info.addActionListener(this);
        DarkMode.addActionListener(this);
        LightMode.addActionListener(this);
                  
      f.setResizable(false);
      f1=new Frame("Color and Font");
      f1.setBounds(800,100,500,400);
      f1.setBackground(c);
      f1.setLayout(new GridLayout(4,2,10,10));
      f1.setResizable(false);
      f1.add(l=new Label("Font Style"));
      l.setFont(new Font("Arial",Font.BOLD,20));
      l.setForeground(Color.WHITE);
      f1.add(cb1=new Choice());
      cb1.setBackground(c4);
      cb1.setForeground(Color.WHITE);
      f1.add(l1=new Label("Font Colour"));
      l1.setFont(new Font("Arial",Font.BOLD,20));
      l1.setForeground(Color.WHITE);
      f1.add(b1=new JButton("Font Color pane"));

      f1.add(l2=new Label("Font size"));
      l2.setFont(new Font("Arial",Font.BOLD,20));
      l2.setForeground(Color.WHITE);
      f1.add(cb3=new Choice());
      cb3.setForeground(Color.WHITE);
      cb3.setBackground(c4);

      f1.add(l3=new Label("BackGround Colour"));
      l3.setFont(new Font("Arial",Font.BOLD,20));
      l3.setForeground(Color.WHITE);
      f1.add(b2=new JButton("BackGround Color pane"));
      b1.addActionListener(this);
      b2.addActionListener(this);

      GraphicsEnvironment gc=GraphicsEnvironment.getLocalGraphicsEnvironment();
      String fnt[]=gc.getAvailableFontFamilyNames();
      for(int i=0;i<fnt.length;i++){
        cb1.add(fnt[i]);
        cb3.add(Integer.toString(i));
      }
      cb1.addItemListener(this);
      cb3.addItemListener(this);
      f.setVisible(true);
      f1.setVisible(false);

    }
     void sv(String s){
       s=t.getText();
      JFileChooser j=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      int r=j.showSaveDialog(f);
      if(r==JFileChooser.APPROVE_OPTION){
        tx.setText(j.getSelectedFile().getAbsolutePath());
        String s1=j.getSelectedFile().getAbsolutePath();
       try (PrintWriter w=new PrintWriter(s1)){
        w.write(s);
        txt=s;
       }
       catch(IOException f){
        tx.setText("Exception");
       }
      }
      else{
        tx.setText("No file chosen!!");
      }
    
     }
    public void actionPerformed(ActionEvent e){
      String s2=t.getText();
      if(e.getSource()==nw){
        String d=JOptionPane.showInputDialog(f, "Want a new page?\n Or want to save the current file?\n(Enter s to save and  to exit");
        if(d=="e"){
        t.setText("\n");
        }
        else if(d=="s"){
         String s=t.getText();
         sv(s);
      }
      u=t.getText();
      t.setText("\n");
    }
    else if(e.getSource()==save){
      String s1=t.getText();
      s2=txt+"\n"+s1;
          String s3=tx.getText();
         try (PrintWriter w=new PrintWriter(s3)){
          w.write(s2);
          txt=s2;
         }
    
         catch(IOException f){
          tx.setText("Exception");
         }

    }
      else if(e.getSource()==open){
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r=j.showOpenDialog(f);
        if(r==JFileChooser.APPROVE_OPTION){
          tx.setText(j.getSelectedFile().getAbsolutePath());
        }
        else{
          tx.setText("No file chosen!!");

        }
      }
      else if(e.getSource()==save_as){
       String s=tx.getText();
       sv(s);
      }
      
      else if(e.getSource()==cut){
        String d=JOptionPane.showInputDialog(f,"Want to remove all?\nEnter Y/N");
        if(d=="Y"||d=="y"){
          u=t.getText();
          t.setText(" ");
        }
      }
     else if(e.getSource()==exit||e.getSource()==ex){
      System.exit(0);
    }
    else if(e.getSource()==info){
       String s3=t.getText();
       StringTokenizer st=new StringTokenizer(s3,".");
       int a=st.countTokens();
       StringTokenizer st2=new StringTokenizer(s3," ");
       int b=st2.countTokens();
       StringTokenizer st3=new StringTokenizer(s3,"\n");
       int c=st3.countTokens();  
       StringTokenizer st4=new StringTokenizer(s3,",");
       int d=st4.countTokens(); 
       f.add(ab=new Choice());
       ab.removeAll();
       ab.setBounds(200,560,200,100);
       ab.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,15));
       ab.setBackground(c4);
       ab.setForeground(Color.WHITE);
       ab.add("Number of Sentences:-"+a);
       ab.add("Number of Comas:-"+d);
       ab.add("Number of New Lines:-"+c);
       ab.add("Number of Words:-"+b);
       ab.setVisible(true);
  }
  else if(e.getSource()==font){
    f1.setVisible(true);
  }
  else if(e.getSource()==b1){
    Color c=JColorChooser.showDialog(f,"Select a color", Color.WHITE);
    txta(a,b,c,c1);

  }
  else if(e.getSource()==b2){
    Color c=JColorChooser.showDialog(f,"Select a color", Color.WHITE);
    txta(a,b,Color.WHITE,c);

  } 
  else if(e.getSource()==LightMode){
    f.setBackground(Color.WHITE);
    Color q=new Color(232,200,197);
    c1=q;
    txta(a,b,Color.black,q);
    flag=0;
  }
  else if(e.getSource()==DarkMode){
    f.setBackground(c);
    txta(a,b,Color.white,c1);
  }
}
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==cb1){
          a=cb1.getSelectedItem();
          if(flag==0){
            Color q=new Color(232,200,197);
            c1=q;
            txta(a,b,Color.BLACK,q);
          }
          else{
            txta(a,b,Color.WHITE,c1);
          }
         
      }
        else if(e.getSource()==cb3){
          b=Integer.parseInt(cb3.getSelectedItem());
          if(flag==0){
            Color q=new Color(232,200,197);
            c1=q;
            txta(a,b,Color.WHITE,c1);
          }
          else{
            txta(a,b,Color.WHITE,c1);
          }

        }
       
    }
    public void run(){
      save.setEnabled(t.getText().length()>0);
      save_as.setEnabled(t.getText().length()>0);
      cut.setEnabled(t.getText().length()>0);
      nw.setEnabled(t.getText().length()>0);

    }
   
}
class notepad{
  public static void main(String[] args) {
    sttr st=new sttr();
    Timer t=new Timer();
    t.schedule(st,100,10);
  }
}