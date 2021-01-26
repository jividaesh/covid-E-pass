package finalproject;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
public class d_SignUpPage extends JFrame implements ActionListener{
     private Container container=getContentPane();
    private JPanel headerPanel=new JPanel();
    private JPanel bodyPanel=new JPanel();
    private JLabel headerTitleLabel=new JLabel("BOOTCAMP E-PASS");
    private JLabel signUpLabel=new JLabel("Sign Up");
    private JLabel userLabel=new JLabel("Email");
    private JLabel captchaLabel=new JLabel("Captcha");
    String str = generateCaptchaString();
    private JLabel setCaptchaLabel=new JLabel(str);//setcaptchafunctionhere
    private JLabel passwordLabel=new JLabel("Password");
    private JLabel rePasswordLabel=new JLabel("Confirm password");
    private JLabel messageLabel=new JLabel();//"**Incorectemailorpassword**"
    private JTextField userTextField=new JTextField();
    private JPasswordField passwordField=new JPasswordField();
    private JPasswordField rePasswordField=new JPasswordField();
    private JTextField getCaptchaField=new JTextField();
    private JButton signUpButton=new JButton("Sign up");
    private JButton loginButton=new JButton("Log in");
    private JButton backButton=new JButton("Back");

    d_SignUpPage(){
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
 
     String generateCaptchaString() {
        Random rand = new Random();
        int length = 7;
        //System.out.println(length);

        StringBuffer captcha = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = Math.abs(rand.nextInt(26));
            // System.out.println(baseCharNumber+"****");
            int charNumber = 0;
            charNumber = 65 + baseCharNumber;
            // System.out.println(charNumber);

            captcha.append((char) charNumber);
        }

        return captcha.toString();
    }
    
    private void setLayoutManager(){
        container.setBackground(Color.WHITE);
        container.setLayout(null);
        container.add(backButton);
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
        signUpLabel.setBounds(0,13,350,30);
        userLabel.setBounds(50,49,100,30);
        passwordLabel.setBounds(50,119,100,30);
        rePasswordLabel.setBounds(50,189,200,30);
        captchaLabel.setBounds(50,259,200,30);
        setCaptchaLabel.setBounds(45,292,150,30);
        userTextField.setBounds(50,82,250,30);
        passwordField.setBounds(50,152,250,30);
        rePasswordField.setBounds(50,222,250,30);
        getCaptchaField.setBounds(138,292,161,30);
        messageLabel.setBounds(0,325,350,30);
        signUpButton.setBounds(95,360,160,35);
        loginButton.setBounds(95,405,160,35);
        signUpLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        bodyPanel.add(signUpLabel);
        bodyPanel.add(userLabel);
        bodyPanel.add(passwordLabel);
        bodyPanel.add(rePasswordLabel);
        bodyPanel.add(captchaLabel);
        bodyPanel.add(setCaptchaLabel);
        bodyPanel.add(userTextField);
        bodyPanel.add(passwordField);
        bodyPanel.add(rePasswordField);
        bodyPanel.add(getCaptchaField);
        bodyPanel.add(signUpButton);
        bodyPanel.add(loginButton);
        bodyPanel.add(messageLabel);
        bodyPanel.setLayout(null);
    }
   private void setFontAndColor(){
        signUpLabel.setFont(new Font("Roboto",Font.BOLD,20));
        userLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        passwordLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        rePasswordLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        captchaLabel.setFont(new Font("Roboto",Font.PLAIN,17));
        setCaptchaLabel.setFont(new Font("Informal Roman",Font.BOLD,17));
        messageLabel.setFont(new Font("Roboto",Font.BOLD,12));
        userTextField.setFont(new Font("Roboto",Font.PLAIN,17));
        passwordField.setFont(new Font("Roboto",Font.BOLD,17));
        rePasswordField.setFont(new Font("Roboto",Font.BOLD,17));
        getCaptchaField.setFont(new Font("Roboto",Font.PLAIN,17));
        signUpButton.setFont(new Font("Roboto",Font.BOLD,17));
        loginButton.setFont(new Font("Roboto",Font.BOLD,17));
        signUpButton.setBackground(new Color(251,5,37));
        loginButton.setBackground(new Color(113,113,113));
        messageLabel.setForeground(Color.RED);
        setCaptchaLabel.setForeground(new Color(51,69,187));
        signUpButton.setForeground(Color.white);
        loginButton.setForeground(Color.white);
    }
    
   private void setLocationAndSize(){
        headerPanel.setBounds(0,0,870,70);
        bodyPanel.setBounds(250,95,350,458);
    }
    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
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
        setTitle("Sign up");
        setVisible(true);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
   public void setButtonAction()
        { backButton.addActionListener((e) -> 
            { new a_HomePage();
            });
            signUpButton.addActionListener((e) -> 
            { int found=0;
              String email=userTextField.getText();
              String password=passwordField.getText();
              String repassword=rePasswordField.getText();
              String captchas=setCaptchaLabel.getText();
              String getCaptch=getCaptchaField.getText();
              z_Emailvalidator emailvalid=new z_Emailvalidator();
              if(!emailvalid.validate(email))
              { messageLabel.setText("Enter a valid Mail");
                found=1;
              }
              if(!password.equals(repassword)&& found!=1)
              {messageLabel.setText("***Password does not Match***");
               found=1;
              }
              if(password.equals(repassword)&&found!=1)
        	  {String reg="^(?=.*[0-9])"
        			    +"(?=.*[a-z])(?=.*[A-Z])"
        			    +"(?=.*[~!@#$%^&*?])"
        			    +"(?=\\S+$).{8,20}$";
        	   Pattern p=Pattern.compile(reg);
        	   Matcher m=p.matcher(password);
        	   if(m.matches())
        	   { found=0;
        	   }
        	   else
        	   { messageLabel.setText("Atleast one digit,special character,uppercase,lowercase");
        		 found=1;
        	   }	
        	  }
              if(!captchas.equals(getCaptch)&&found!=1)
              { messageLabel.setText("Enter yout Captcha correctly"); 
                found=1;
              }
            if(found==0)
           {try
            { Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");            	
              //Connection con=DriverManager.getConnection("jdbc:sqlite:D:\\sqllitedb\\project.db");  
        	  Statement st=con.createStatement();
        	  con.setAutoCommit(true);
        	  String query="select * from signuppagetable";
        	  ResultSet rs = st.executeQuery(query);
        	  int f=0;
        	  int acc=0;
              while(rs.next())
              { if(rs.getString("email").equals(email))
                {   f=1;
                    break;            	           
               }
             }
             if(f==1)
              {  messageLabel.setText("Already you have a account");
              }
             else
             {   String pass=password;
       	         Base64.Encoder en=Base64.getEncoder();	  
               	 String encodepassword=en.encodeToString(pass.getBytes());
            	 String qu="insert into signuppagetable values('"+email+"','"+encodepassword+"')";	 	 
        	    st.executeUpdate(qu);
        	    messageLabel.setText("Account is created plz login");
             }
             con.close();
            }
            catch(Exception e1)
            { System.out.println("ERROR"+e1);
            }
           }}            
            );
       loginButton.addActionListener((e) -> {
                //if already registered then directly login
                new c_UserLoginPage();
            });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}