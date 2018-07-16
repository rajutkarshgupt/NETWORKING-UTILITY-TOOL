package iut;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import static java.lang.System.out;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Utkarsh Gupta
 */
class ProgressBarExample extends JFrame{    
JProgressBar jb;    
int i=0,num=0;     
ProgressBarExample(){    
jb=new JProgressBar(0,2000);    
jb.setBounds(40,40,160,30);         
jb.setValue(0);    
jb.setStringPainted(true);    
add(jb);    
setSize(250,150);    
setLayout(null);    
}    
public void iterate(){    
while(i<=2000){    
  jb.setValue(i);    
  i=i+20;    
  try{Thread.sleep(1);}catch(Exception e){}    
}    
}}
abstract class Utility
{
    abstract public void util() throws Exception;
}
class Ifconfig extends Utility{
    String arr[] = new String[100000];
    public void util() throws Exception
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception evt) {}
        JFrame frame = new JFrame(" IPCONFIG :- ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 1));
        String x = "Your Host addr: "+InetAddress.getLocalHost().getHostAddress();
        JTextField textField = new JTextField(x);
        textField.setHorizontalAlignment(JTextField.LEFT);
        content.add(textField);
        System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements();)
        {
            NetworkInterface e = n.nextElement();

            Enumeration<InetAddress> a = e.getInetAddresses();
            int i=0;
            for (; a.hasMoreElements();)
            {
                InetAddress addr = a.nextElement();
                arr[i++]=addr.getHostAddress();
                textField = new JTextField(addr.getHostAddress());
                textField.setHorizontalAlignment(JTextField.LEFT);
                content.add(textField);
                System.out.println("  " + addr.getHostAddress());
            }
        }
        frame.pack();
        frame.setSize(250, (int) frame.getSize().getHeight());
        frame.setVisible(true);
    }
}
class Ping extends Utility
{
  // Sends ping request to a provided IP address
  public void util()            throws Exception
  {
      String ipAddress=JOptionPane.showInputDialog("Please enter IP - ADDREESS whose reachability to be checked :- \n example: 172.1.31.4");
      ProgressBarExample m2=new ProgressBarExample();    
            m2.setVisible(true);    
            m2.iterate();
            m2.setVisible(false); 
    try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception evt) {}
        JFrame frame = new JFrame(" PING :- ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 1));
        JTextField textField = new JTextField(ipAddress);
        textField.setHorizontalAlignment(JTextField.LEFT);
        content.add(textField);
    InetAddress geek = InetAddress.getByName(ipAddress);
    System.out.println("Sending Ping Request to " + ipAddress);
    if (geek.isReachable(5000))
    {
        textField = new JTextField("Host is reachable");
        textField.setHorizontalAlignment(JTextField.LEFT);
        content.add(textField);
      System.out.println("Host is reachable");
    }
    else
    {
      textField = new JTextField("Sorry ! We can't reach to this host");
        textField.setHorizontalAlignment(JTextField.LEFT);
        content.add(textField);  
      System.out.println("Sorry ! We can't reach to this host");
    }
    frame.pack();
        frame.setSize(250, (int) frame.getSize().getHeight());
        frame.setVisible(true);
  }
}
class NetworkConnection extends Utility
{
	public void util() throws Exception{
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                 try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception evt) {}
        JFrame frame = new JFrame(" NETWORK - STATISTICS :- ");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 1));
        JTextField textField = new JTextField(null);
        int j=0;
		while (interfaces.hasMoreElements() && j<5)
                {
                        NetworkInterface networkInterface = interfaces.nextElement();
                        String x = "Network Interface Name : [" + networkInterface.getDisplayName() + "]";
                        textField = new JTextField(x);
                        textField.setHorizontalAlignment(JTextField.LEFT);
                        content.add(textField);
                        x = "Is It connected? : [" + networkInterface.isUp() + "]";
                        textField = new JTextField(x);
                        textField.setHorizontalAlignment(JTextField.LEFT);
                        content.add(textField);                    
                        System.out.println("Network Interface Name : [" + networkInterface.getDisplayName() + "]");
                        System.out.println("Is It connected? : [" + networkInterface.isUp() + "]");
                        for (InterfaceAddress i : networkInterface.getInterfaceAddresses()){
                            x = "Host Name : "+i.getAddress().getCanonicalHostName();
                        textField = new JTextField(x);
                        textField.setHorizontalAlignment(JTextField.LEFT);
                        content.add(textField);
                        x = "Host Address : "+i.getAddress().getHostAddress();
                        textField = new JTextField(x);
                        textField.setHorizontalAlignment(JTextField.LEFT);
                        content.add(textField);
		    	System.out.println("Host Name : "+i.getAddress().getCanonicalHostName());
		    	System.out.println("Host Address : "+i.getAddress().getHostAddress());
                        j++;
		    }
                    textField = new JTextField("\n");
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
		    System.out.println("----------------------");
		}
                JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    BoundedRangeModel brm = textField.getHorizontalVisibility();
    scrollBar.setModel(brm);
    panel.add(textField);
    panel.add(scrollBar);
    frame.getContentPane().add(panel);
                frame.pack();
        frame.setSize(250, (int) frame.getSize().getHeight());
        frame.setVisible(true);
	}
}
class PScanner extends Utility{
    
         public void util() throws Exception{
             try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception evt) {}
             String host=null;
             host=JOptionPane.showInputDialog("Enter the IP - ADDRESS to scan:\n example: 172.1.31.4");
             ProgressBarExample m2=new ProgressBarExample();    
                   m2.setVisible(true);    
                   m2.iterate();
                   m2.setVisible(false);
             String p1=JOptionPane.showInputDialog("Enter starting PORT - NO. :- ");
             m2.setVisible(true);    
                   m2.iterate();
                   m2.setVisible(false);
             int port1 = Integer.parseInt(p1);
             String p2=JOptionPane.showInputDialog("Enter ending PORT - NO. :- ");
             m2.setVisible(true);    
                   m2.iterate();
                   m2.setVisible(false);
             int port2 = Integer.parseInt(p2);
         JFrame frame = new JFrame(" PORT - SCAN :- ");
         frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 1));
         InetAddress remote=null;
            try
            { 
                        if(host!=null)
                        {
                            remote = InetAddress.getByName(host);
                            String hostname = remote.getHostName();
                            for(int port = port1;port<=port2;port++)
                            {
                                  try
                                  {
                                      Socket s = new Socket(remote,port);
                                      String x = "Server is listening on port " + port+ " of " + hostname;
                                      JTextField textField = new JTextField(x);
                                      textField.setHorizontalAlignment(JTextField.LEFT);
                                      content.add(textField);
                                      System.out.println("Server is listening on port " + port+ " of " + hostname);
                                      s.close();
                                  }
                                  catch (IOException ex)
                                  {
                                  // The remote host is not listening on this port
                                      String x = "Server is not listening on port " + port+ " of " + hostname;
                                     JTextField textField = new JTextField(x);
                                     textField.setHorizontalAlignment(JTextField.LEFT);
                                     content.add(textField);
                                      System.out.println("Server is not listening on port " + port+ " of " + hostname);
                                  }
                           }               
                        }
            }
            catch (UnknownHostException e)
            {
                System.err.println(e );
            }
         String x = "Bye from NFS";
                    JTextField textField = new JTextField(x);
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
         System.out.println("Bye from NFS");
         //System.exit(0);
     }
}
class ListNets extends Utility
{
    public void util() throws Exception {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception evt) {}
        JFrame frame = new JFrame(" LIST - NETWORKS :- ");
         frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 1));
        int i=0,f=0;
        for (NetworkInterface netint : Collections.list(nets) )
        {
            String x = "Display name: "+netint.getDisplayName()+"\n";
                    JTextField textField = new JTextField(x);
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
            out.printf("Display name: %s\n", netint.getDisplayName());
            x = "Name: "+netint.getName()+"\n";
                    textField = new JTextField(x);
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
            out.printf("Name: %s\n", netint.getName());
            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
            for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                x = "InetAddress: "+inetAddress+"\n";
                    textField = new JTextField(x);
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
                out.printf("InetAddress: %s\n", inetAddress);
                i++;
                if(i==15)
                {
                    f=1;
                    break;
                }
            }
            if(f==1 || i==15)
                break;
                    textField = new JTextField("\n");
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
            out.printf("\n");
            i++;
        }
    }
}
class ListNIFs extends Utility
{
    public void util() throws Exception {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception evt) {}
        JFrame frame = new JFrame(" LIST - NETWORK - INTERFACES :- ");
         frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.setLayout(new GridLayout(0, 1));
        int i=0,f=0;
        for (NetworkInterface netIf : Collections.list(nets)) {
            String x = "Display name: "+netIf.getDisplayName()+"\n";
                    JTextField textField = new JTextField(x);
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
            out.printf("Display name: %s\n", netIf.getDisplayName());
            x = "Name: "+netIf.getName()+"\n";
                    textField = new JTextField(x);
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
            out.printf("Display name: %s\n", netIf.getDisplayName());
            out.printf("Name: %s\n", netIf.getName());
            Enumeration<NetworkInterface> subIfs = netIf.getSubInterfaces();        
            for (NetworkInterface subIf : Collections.list(subIfs)) {
                x = "\tSub Interface Display name: "+subIf.getDisplayName()+"\n";
                        textField = new JTextField(x);
                        textField.setHorizontalAlignment(JTextField.LEFT);
                        content.add(textField);
                out.printf("\tSub Interface Display name: %s\n", subIf.getDisplayName());
                x = "\tSub Interface Name: "+subIf.getName()+"\n";
                        textField = new JTextField(x);
                        textField.setHorizontalAlignment(JTextField.LEFT);
                        content.add(textField);
                out.printf("\tSub Interface Name: %s\n", subIf.getName());
                i++;
                if(i==1)
                {
                    f=1;
                    break;
                }
            }
            if(f==1 || i==15)
                break;
            textField = new JTextField("\n");
                    textField.setHorizontalAlignment(JTextField.LEFT);
                    content.add(textField);
            out.printf("\n");
            i++;
        }
    }
}
class MyCanvas extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit(); 

        Image i=t.getImage("net-tool.png");  
        g.drawImage(i, 180,150,this);  
          
    }
}
public class IUT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ProgressBarExample m2=new ProgressBarExample();  
        m2.setVisible(true);    
            m2.iterate();
            m2.setVisible(false);
        JOptionPane.showMessageDialog(null,
                              "                        WELCOME     ",
                              "   NETWORKING UTILITY TOOL  ",
                              JOptionPane.PLAIN_MESSAGE,
                              new ImageIcon("netty.jpg")
                              );
        MyCanvas m=new MyCanvas();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(3000,3000);  
        f.setVisible(true);
        //while(true)
        //{
            m2.setVisible(true);    
            m2.iterate();
            m2.setVisible(false);
            Utility utility = null;
            JFrame f2=new JFrame("   MENU    ");//creating instance of JFrame  
            f2.setVisible(true);
            
                    JButton b=new JButton("ipconfig");//creating instance of JButton  
                    b.setBounds(90,100,100, 40);//x axis, y axis, width, height  
                    b.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e){  
                      Utility utility = new Ifconfig();
                      //f2.setVisible(false);
                        try {
                            utility.util();
                        } catch (Exception ex) {
                            Logger.getLogger(IUT.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }  
            });
                    f2.add(b);
                    JButton b2=new JButton("ping");//creating instance of JButton  
                    b2.setBounds(200,100,100, 40);//x axis, y axis, width, height  
                    b2.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e){  
                      Utility utility = new Ping();
                      //f2.setVisible(false);
                      try {
                            utility.util();
                        } catch (Exception ex2) {
                            Logger.getLogger(IUT.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                }  
            });
                    f2.add(b2);
                    JButton b3=new JButton("netstat");//creating instance of JButton  
                    b3.setBounds(90,150,100, 40);//x axis, y axis, width, height  
                    b3.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e){  
                      Utility utility = new NetworkConnection();
                      //f2.setVisible(false);
                      try {
                            utility.util();
                        } catch (Exception ex3) {
                            Logger.getLogger(IUT.class.getName()).log(Level.SEVERE, null, ex3);
                        }
                }  
            });
                    f2.add(b3);
                    JButton b4=new JButton("portscanning");//creating instance of JButton  
                    b4.setBounds(200,150,100, 40);//x axis, y axis, width, height  
                    b4.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e){  
                      Utility utility = new PScanner();
                      //f2.setVisible(false);
                      try {
                            utility.util();
                        } catch (Exception ex4) {
                            Logger.getLogger(IUT.class.getName()).log(Level.SEVERE, null, ex4);
                        }
                }  
            });
                    f2.add(b4);  
                    JButton b5=new JButton("listnets");//creating instance of JButton  
                    b5.setBounds(90,200,100, 40);//x axis, y axis, width, height  
                    b5.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e){  
                      Utility utility = new ListNets();
                      //f2.setVisible(false);
                      try {
                            utility.util();
                        } catch (Exception ex5) {
                            Logger.getLogger(IUT.class.getName()).log(Level.SEVERE, null, ex5);
                        }
                }  
            });
                    f2.add(b5);JButton b6=new JButton("listnifs");//creating instance of JButton  
                    b6.setBounds(200,200,100, 40);//x axis, y axis, width, height  
                    b6.addActionListener(new ActionListener(){  
                    public void actionPerformed(ActionEvent e){  
                      Utility utility = new ListNIFs();
                      //f2.setVisible(false);
                      try {
                            utility.util();
                        } catch (Exception ex6) {
                            Logger.getLogger(IUT.class.getName()).log(Level.SEVERE, null, ex6);
                        }
                }  
            });
                    f2.add(b6);
            f2.setSize(400,500);//400 width and 500 height  
            f2.setLayout(null);//using no layout managers  
            /*String x=JOptionPane.showInputDialog("NETWORKING UTILTY TOOL\n\nEnter option from given menu :\n\n ipconfig            : LOCAL - IP - ADDRESS\n ping                  : TO CHECK HOST - IP's REACHABILITY\n netstat             : LIST NETWORK - INTERFACES\n portscanning : LIST WORKING PORTS \n listnets            : LIST DISPLAY - NAME + PORT - NAME + INET - ADDRESS\n listnifs             : LIST DISPLAY - NAME + PORT - NAME + INTERFACE - NAME + SUBINTERFACE - NAME\n "
                    + "\n");
            Utility utility = new Ifconfig();
            switch(x)
            {
                case "ping":
                    utility = new Ping();
                    break;
                case "netstat":
                    utility = new NetworkConnection();
                    break;
                case "portscanning":
                    utility = new PScanner();
                    break;
                case "listnets":
                    utility = new ListNets();
                    break;
                case "listnifs":
                    utility = new ListNIFs();
            } */  
            m2.setVisible(true);    
            m2.iterate();
            m2.setVisible(false);
        //}
    }   
}