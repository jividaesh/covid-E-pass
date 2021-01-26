package finalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class f_AdminLoginPage extends JFrame implements ActionListener{
    
    private Container container=getContentPane();
    private JPanel headerPanel=new JPanel();
    private JPanel bodyPanel=new JPanel();
    private JLabel headerTitleLabel=new JLabel("BOOTCAMP E-PASS");
    private JLabel loginLabel=new JLabel("Hello Admin!");
    private JLabel idLabel=new JLabel("Admin ID");
    private JLabel userLabel=new JLabel("Email");
    private JLabel passwordLabel=new JLabel("Password");
    private JLabel messageLabel=new JLabel();//"**IncorrectID,EmailorPassword**"
    private JTextField userTextField=new JTextField();
    private JTextField idTextField=new JTextField();
    private JPasswordField passwordField=new JPasswordField();
    private JButton loginButton=new JButton("Log in");
    private JCheckBox showPassword=new JCheckBox("ShowPassword");
    private JButton backButton=new JButton("Back");
 
 
    f_AdminLoginPage(){
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
        container.add(backButton);
    }
    
    private void setHeaderPanel(){
        headerPanel.setBackground(new Color(39,54,147));
        headerPanel.setLayout(new GridLayout(1,1,0,0));
        ImageIcon iconLogo = new ImageIcon(new
        ImageIcon("C:\\Users\\Admin\\Desktop\\dbluelogo.png").getImage().getScaledInstance(75,75,
        Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto",Font.BOLD,26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
    }
   
    private void setBodyPanel(){
        loginLabel.setBounds(0,18,350,30);
        idLabel.setBounds(50,54,100,30);
        userLabel.setBounds(50,124,100,30);
        passwordLabel.setBounds(50,194,100,30);
        idTextField.setBounds(50,86,250,30);
        userTextField.setBounds(50,156,250,30);
        passwordField.setBounds(50,226,250,30);
        showPassword.setBounds(167,261,150,30);
        messageLabel.setBounds(0,295,350,30);
        loginButton.setBounds(95,330,160,35);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        bodyPanel.add(loginLabel);
        bodyPanel.add(idLabel);
        bodyPanel.add(userLabel);
        bodyPanel.add(passwordLabel);
        bodyPanel.add(idTextField);
        bodyPanel.add(userTextField);
        bodyPanel.add(passwordField);
        bodyPanel.add(showPassword);
        bodyPanel.add(messageLabel);
        bodyPanel.add(loginButton);
        bodyPanel.setLayout(null);
        }

   private void setFontAndColor(){
        loginLabel.setFont(new Font("Roboto",Font.BOLD,20));
        idLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        userLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        passwordLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        idTextField.setFont(new Font("Roboto",Font.PLAIN,17));
        userTextField.setFont(new Font("Roboto",Font.PLAIN,17));
        passwordField.setFont(new Font("Roboto",Font.BOLD,17));
        showPassword.setFont(new Font("Roboto",Font.PLAIN,15));
        messageLabel.setFont(new Font("Roboto",Font.BOLD,15));
        loginButton.setFont(new Font("Roboto",Font.BOLD,17));
        messageLabel.setForeground(Color.red);
        loginButton.setBackground(new Color(39,54,147));
        loginButton.setForeground(Color.white);
    }
    
    private void setLocationAndSize(){
        headerPanel.setBounds(0,0,870,70);
        bodyPanel.setBounds(250,115,350,410);
    }
    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
    }
    
   private void setFrame(){
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\dbluelogo.png");  
        setIconImage(icon);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        }

   private void setBackButton(){
            backButton.setFont(new Font("Roboto", Font.BOLD,17));
            backButton.setBounds(10,532,90,40);
            backButton.setBackground(Color.BLACK);
            backButton.setForeground(Color.WHITE);
        }

   public void setButtonAction()
    {
        backButton.addActionListener((e) -> {
            this.toBack();
        });
         loginButton.addActionListener((e) ->
         {  int f=0;
            String adminid =idTextField.getText();
            String email=userTextField.getText();
            String password=passwordField.getText();
            String d="";
            if(adminid.equals(d))
            {messageLabel.setText("Enter your ID !");
             f=1;
            }
            if(email.equals(d)&& f!=1)
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
              //Connection con=DriverManager.getConnection("jdbc:sqlite:D:\\sqllitedb\\project.db");  
        	  Statement st=con.createStatement();
        	  con.setAutoCommit(true);    	    	      	  
        	  String query="select * from adminloginpagetable";
        	  ResultSet rs = st.executeQuery(query);
        	  int found=0;
        	  int acc=0;
              while(rs.next())
              { if(rs.getString("email").equals(email))
                { acc=1;
         	      if(rs.getString("password").equals(password))
                   { found=1;
                     break;            	
                   }
                  else
                   { messageLabel.setText("password incorrect");                  	  
                   }
               }
             }
             if(found==1)
              { // new nextform(); 
              }
             if(acc==0)
             { messageLabel.setText("Incorrect username or password");
             }
             con.close();
          }
          catch(Exception e1)
          {System.out.println("ERROR"+e1);
          }
          }                  	
       });
        showPassword.addActionListener((e) -> {
            if (showPassword.isSelected()) {
          passwordField.setEchoChar((char)0); //password = JPasswordField
       } else {
          passwordField.setEchoChar('*');
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}