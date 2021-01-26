package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

public class c_UserLoginPage extends JFrame implements ActionListener{
 
     private Container container=getContentPane();
    private JPanel headerPanel=new JPanel();
    private JPanel bodyPanel=new JPanel();
    private JLabel headerTitleLabel=new JLabel("BOOTCAMPE-PASS");
    private JLabel loginLabel=new JLabel("Hello User!");
    private JLabel userLabel=new JLabel("Email");
    private JLabel passwordLabel=new JLabel("Password");
    private JLabel messageLabel= new JLabel();
    private JTextField userTextField=new JTextField();
    private JPasswordField passwordField=new JPasswordField();
    private JButton loginButton=new JButton("Log in");
    private JButton signButton=new JButton("Sign up");
    private JCheckBox showPassword=new JCheckBox("ShowPassword");
    private JButton backButton=new JButton("Back");
 
 
    c_UserLoginPage() {
         setLayoutManager();
        setLocationAndSize();
        setHeaderPanel();
        setBodyPanel();
        setFontAndColor();
        addComponentsToContainer();
        setFrame();
        setBackButton();
        setButtonAction();
    }
 
    private void setLayoutManager(){
        container.setBackground(Color.WHITE);
        container.setLayout(null);

    }
    
    private void setHeaderPanel(){
        headerPanel.setBackground(new Color(251,5,37));
        headerPanel.setLayout(new GridLayout(1,1,0,0));
        ImageIcon iconLogo = new ImageIcon(new
        ImageIcon("C:\\Users\\Admin\\Desktop\\icon.png").getImage().getScaledInstance(75,75,
        Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto",Font.BOLD,26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
    }
   
  private void setBodyPanel(){
        loginLabel.setBounds(0,20,350,30);
        userLabel.setBounds(50,58,100,30);
        passwordLabel.setBounds(50,128,100,30);
        userTextField.setBounds(50,90,250,30);
        passwordField.setBounds(50,160,250,30);
        showPassword.setBounds(167,195,150,30);
        messageLabel.setBounds(0,230,350,30);
        loginButton.setBounds(95,270,160,35);
        signButton.setBounds(95,315,160,35);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        bodyPanel.add(loginLabel);
        bodyPanel.add(userLabel);
        bodyPanel.add(passwordLabel);
        bodyPanel.add(userTextField);
        bodyPanel.add(passwordField);
        bodyPanel.add(showPassword);
        bodyPanel.add(messageLabel);
        bodyPanel.add(loginButton);
        bodyPanel.add(signButton);
        bodyPanel.setLayout(null);
        }

    private void setFontAndColor(){
        loginLabel.setFont(new Font("Roboto",Font.BOLD,20));
        userLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        passwordLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        userTextField.setFont(new Font("Roboto",Font.PLAIN,17));
        passwordField.setFont(new Font("Roboto",Font.BOLD,17));
        showPassword.setFont(new Font("Roboto",Font.PLAIN,15));
        messageLabel.setFont(new Font("Roboto",Font.BOLD,15));
        loginButton.setFont(new Font("Roboto",Font.BOLD,17));
        signButton.setFont(new Font("Roboto",Font.BOLD,17));
        messageLabel.setForeground(Color.RED);
        loginButton.setBackground(new Color(251,5,37));
        signButton.setBackground(new Color(113,113,113));
        loginButton.setForeground(Color.white);
        signButton.setForeground(Color.white);
    }
     private void setLocationAndSize(){
        headerPanel.setBounds(0,0,870,70);
        bodyPanel.setBounds(250,125,350,390);
    }
    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
        container.add(backButton);
    }
    private void setBackButton(){
        backButton.setFont(new Font("Roboto", Font.BOLD,17));
        backButton.setBounds(10,532,90,40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
    }
    
     private void setFrame(){
        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png");
        //Image icon=Toolkit.getDefaultToolkit().getImage("C:\\image\\icon.png"); 
        setIconImage(icon);
        setVisible(true);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

 public void setButtonAction()
    {
        backButton.addActionListener((e) -> {
            this.toBack();
        });
        loginButton.addActionListener((e) -> 
        { int f=0;
        String email=userTextField.getText();
        String password=passwordField.getText();
        String d="";
        if(email.equals(d))
        {messageLabel.setText("Enter your email !");
         f=1;
        }
        if(password.equals(d) &&f!=1)
        {messageLabel.setText("Enter your Password!");
         f=1;
        }
        if(f==0)
        {try
        { Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");        	        	
    	  Statement st=con.createStatement();
    	  con.setAutoCommit(true);    	  
    	  String pass=password;
	      Base64.Encoder en=Base64.getEncoder();	  
          String encodepassword=en.encodeToString(pass.getBytes());    	      	  
    	  String query="select * from signuppagetable";
    	  ResultSet rs = st.executeQuery(query);
    	  int found=0;
    	  int acc=0;
          while(rs.next())
          { if(rs.getString("email").equals(email))
            { acc=1;
     	      if(rs.getString("password").equals(encodepassword))
               { found=1;
                 break;            	
               }
              else
               { messageLabel.setText("password incorrect");                  	  
               }
           }
         }
         if(found==1)
         {  messageLabel.setText("login success");         
          }
         if(acc==0)
         { messageLabel.setText("Incorrect username or password");
         }
         con.close();
         new g1_ListGeneratePage();
      }
      catch(Exception e1)
      {System.out.println("ERROR"+e1);
      }
      }}
        
        );
         signButton.addActionListener((e) -> 
         {
            new d_SignUpPage();
         });
        showPassword.addActionListener((e) -> {  
            if (showPassword.isSelected()) {
          passwordField.setEchoChar((char)0); //password = JPasswordField
          }
          else {
          passwordField.setEchoChar('*');
            }
        });
    }
  
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}