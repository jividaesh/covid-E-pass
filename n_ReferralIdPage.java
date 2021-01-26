package finalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class n_ReferralIdPage extends JFrame implements ActionListener 
{   private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS");
    private JLabel passTitleLabel = new JLabel("Your E-Pass Reference ID");
    private JLabel noteLabel = new JLabel("NOTE:");
    private JTextArea screenShotTextArea = new JTextArea("Take screenshot of your epass 'Reference ID'.");
    private JTextArea veiwStatusTextArea = new JTextArea("Go to 'View Status' to check the status of your E-Pass.");
    private JPanel bodyPanel = new JPanel();
    private JLabel referenceIdLabel = new JLabel("");  
    private JLabel epassLabel = new JLabel("");
    private JButton logoutButton=new JButton("Log out");
    n_ReferralIdPage(){
    	setLabels();
        setLayoutManager();
        setLocationAndSize();
        setHeaderPanel();
        setContainerLabels();
        setFontAndColor();
        setBodyPanel();
        setLogoutButton();
        addComponentsToContainer();
        setFrame();
    }
    private void setLabels() 
    { int id=0;
      try
      { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");  
            //Connection con=DriverManager.getConnection("jdbc:sqlite:D:\\sqllitedb\\project.db");  
	    Statement st=con.createStatement();
	    con.setAutoCommit(true);			   			     
		  String type="";
		  String query1="select * from interstatepagetable";    	
  		  ResultSet r1= st.executeQuery(query1);
  		  while(r1.next())
  		  {  String str=r1.getString("id");
  			 int n=Integer.parseInt(str.substring(2,str.length()));
  		     if(n>id)
  		     {id=n;
  		      type=r1.getString("id");
  		     }
  		  }
  		  String query2="select * from withinstatepagetable";    	
  		  ResultSet r2= st.executeQuery(query2);
  		  while(r2.next())
  		  {  String str=r2.getString("id");
  			 int n=Integer.parseInt(str.substring(2,str.length()));
  		     if(n>id)
  		     {id=n;
  		      type=r2.getString("id");
  		     }
  		  }
  		  String query3="select * from emergencypagetable";    	
		  ResultSet r3 = st.executeQuery(query3);
		  while(r3.next())
		  {  String str=r3.getString("id");
			 int n=Integer.parseInt(str.substring(2,str.length()));
		     if(n>id)
		     {id=n;
		      type=r3.getString("id");
		     }
		  }
		 String query4="select * from OrganisationalPage";    	
 		  ResultSet r4= st.executeQuery(query4);
 		  while(r4.next())
 		  {  String str=r4.getString("id");
 			 int n=Integer.parseInt(str.substring(2,str.length()));
 		     if(n>id)
 		     {id=n;
 		      type=r4.getString("id");
 		     }
 		  }
 		  String tablename="";
		  if(type.substring(0,2).equals("IS"))
		  {	tablename="Inter State e-pass";	  
		  }
		  if(type.substring(0,2).equals("WS"))
		  {	tablename="Within State e-pass";		  
		  }
		  if(type.substring(0,2).equals("EM"))
		  { tablename="Emergency e-pass";			  
		  }
		  if(type.substring(0,2).equals("OR"))
		  { tablename="Organisational e-pass";			  
		  }
		  referenceIdLabel.setText(type);
		  epassLabel.setText(tablename);
   } 
	catch(Exception e4)
	{System.out.print(e4+"e");
	}		
	}
	private void setLayoutManager(){
        container.setBackground(Color.WHITE);
        container.setLayout(null);
    }
    private void setHeaderPanel(){
        headerPanel.setBackground(new Color(251,5,37));
        headerPanel.setLayout(new GridLayout(1,1,0,0));   
        ImageIcon iconLogo = new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon.png").getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto", Font.BOLD,26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
    }
    private void setBodyPanel(){
        referenceIdLabel.setBounds(0, 23, 460, 50); 
        epassLabel.setBounds(0, 73, 460, 50);               
        referenceIdLabel.setFont(new Font("Roboto",Font.BOLD,36));                 
        epassLabel.setFont(new Font("Roboto",Font.BOLD,32));
        bodyPanel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,new Color(251,5,37)));
        referenceIdLabel.setForeground(new Color(51,69,187));
        epassLabel.setForeground(Color.BLACK);
        referenceIdLabel.setHorizontalAlignment(JLabel.CENTER);
        epassLabel.setHorizontalAlignment(JLabel.CENTER);
        bodyPanel.add(epassLabel);
        bodyPanel.add(referenceIdLabel);
        bodyPanel.setLayout(null);
    }
 
    private void setContainerLabels(){
        passTitleLabel.setBounds(0,105,870,30);
        noteLabel.setBounds(155,155,80,407);
        screenShotTextArea.setBounds(227,344,500,40);
        veiwStatusTextArea.setBounds(227,384,520,60);
        screenShotTextArea.setEditable(false);
        screenShotTextArea.setLineWrap(true);
        veiwStatusTextArea.setEditable(false);
        veiwStatusTextArea.setLineWrap(true);
        passTitleLabel.setHorizontalAlignment(JLabel.CENTER);
    }
    private void setFontAndColor(){
         passTitleLabel.setFont(new Font("Roboto", Font.BOLD,23));
         noteLabel.setFont(new Font("Roboto", Font.BOLD,20));
         screenShotTextArea.setFont(new Font("Roboto", Font.PLAIN,20));
         veiwStatusTextArea.setFont(new Font("Roboto", Font.PLAIN,20));
         noteLabel.setForeground(new Color(51,69,187));
    }
    private void setLogoutButton(){
        logoutButton.setFont(new Font("Roboto", Font.BOLD,17));
        logoutButton.setBounds(350,455,150,40);
        logoutButton.addActionListener(this);
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setForeground(Color.WHITE);
        container.add(logoutButton);
    }
    private void setLocationAndSize(){
        headerPanel.setBounds(0, 0, 870, 70);
        bodyPanel.setBounds(210,155,460,150);
    }

    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
        container.add(passTitleLabel);
        container.add(noteLabel);
        container.add(screenShotTextArea);
        container.add(veiwStatusTextArea);
    }
    private void setFrame(){
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png");  
        setIconImage(icon);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setTitle("E-Pass Reference ID");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
	public void actionPerformed(ActionEvent e) 
	{  if(e.getSource()==logoutButton)
	   { 
            new a_HomePage();
	   }
	}
}
