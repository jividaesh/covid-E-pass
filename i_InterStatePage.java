package finalproject;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import finalproject.z_Emailvalidator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.*;
public class i_InterStatePage extends JFrame implements ActionListener{
    private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS");
    private JPanel mainPanel = new JPanel();
    private JPanel bodyPanel = new JPanel();
    private JButton nextButton = new JButton("Continue");
    private JButton backButton = new JButton("Back");
    private JScrollPane scrollable; 
    private JLabel passTitleLabel = new JLabel(" Inter State E-Pass Registration");
    private JLabel subTitleLabel = new JLabel("Valid for 1 day");
    private JLabel nativeLabel = new JLabel("Native State");
    String statesTN[]={"Tamil Nadu"}; 
    String states[]={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chattisgarh","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttaranchal","West Bengal"};  
    String vehicleType[] ={"Two Wheeler", "Four Wheeler", "Cab/Auto", "Truck/Lory/Goods", "Railways" ,"Without Vehicle"};
    private JComboBox nativeComboBox =new JComboBox(states);
    private JLabel nameLabel = new JLabel("Name");
    private JTextField nameTextField = new JTextField();
    private JLabel fromDateLabel = new JLabel("From date");
    private JLabel toDateLabel = new JLabel("To date");
    private JLabel purposeLabel = new JLabel("Purpose");
    private JTextField purposeTextField = new JTextField();
    private JLabel startLocLabel = new JLabel("Travelling from");
    private JComboBox startLocComboBox = new JComboBox(statesTN);
    private JLabel endLocLabel = new JLabel("Travelling to");
    private JComboBox endLocComboBox = new JComboBox(states);
    private JLabel vehicleTypeLabel = new JLabel("Vehicle type");
    private JComboBox vehicleTypeComboBox = new JComboBox(vehicleType);
    private JLabel vehicleNoLabel = new JLabel("Vehicle number");
    private JTextField vehicleNoTextField= new JTextField();
    private JLabel mobileNoLabel = new JLabel("Mobile number");
    private JTextField mobileNoTextField= new JTextField();
    private JLabel emailLabel = new JLabel("Email");
    private JTextField emailTextField= new JTextField();
    private JLabel addressLabel = new JLabel("Address");
    private JTextField addressTextField= new JTextField();
    private JLabel contaminatedLabel = new JLabel("Are you from contaminated zone?");
    private JLabel routeLabel = new JLabel("Are you planning to return via same route?");
    private JTextArea captureTextArea = new JTextArea("I allow the access to a webcam to capture a photograph");
    private JTextArea agreementTextArea = new JTextArea("I assure that the above provided details are true to my            knowledge");
    private JCheckBox agreementCheckBox = new JCheckBox(" Accept");
    private JLabel messageLabel=new JLabel();
    private ButtonGroup bgSet1 = new ButtonGroup();
    private ButtonGroup bgSet2 = new ButtonGroup();
    private JRadioButton yesButton = new JRadioButton("Yes");
    private JRadioButton noButton = new JRadioButton("No");
    private JRadioButton yessButton = new JRadioButton("Yes");
    private JRadioButton nooButton = new JRadioButton("No");
    private DatePicker fromDatePicker=new DatePicker();
    private DatePicker toDatePicker=new DatePicker();

   i_InterStatePage (){
        setLayoutManager();
        setHeaderPanel();
        setMainPanel();
        setBodyPanel();
        setPassLabel();
        setRadioButton();
        setLocationAndSize();
        setFontAndColor();
        setBackButton();
        setButtonAction();
        setFrame();
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

    private void setMainPanel(){
        mainPanel.setBackground(Color.WHITE);        
        mainPanel.setLayout(null);
    }
    private void setPassLabel(){
        passTitleLabel.setFont(new Font("Roboto", Font.BOLD,23));
        passTitleLabel.setBounds(0,15,840,30);
        passTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        subTitleLabel.setFont(new Font("Roboto", Font.BOLD,14));
        subTitleLabel.setBounds(0,40,840,30);
        subTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        subTitleLabel.setForeground(new Color(51, 69, 187));
        mainPanel.add(subTitleLabel);
        mainPanel.add(passTitleLabel);
    }
    private void setBodyPanel(){
        nativeLabel.setBounds(58,20,250,40);
        nativeComboBox.setBounds(58,61,250,40);
        nameLabel.setBounds(350,20,250,40);
        nameTextField.setBounds(350,61,250,40);
        fromDateLabel.setBounds(58,111,250,40);
        fromDatePicker.setBounds(58,154,250,40);
        toDateLabel.setBounds(350,111,250,40);
        toDatePicker.setBounds(350,154,250,40);
        purposeLabel.setBounds(58,202,250,40);
        purposeTextField.setBounds(58,245,540,40);
        startLocLabel.setBounds(58,295,250,40);
        startLocComboBox.setBounds(58,338,250,40);
        endLocLabel.setBounds(350,295,250,40);
        endLocComboBox.setBounds(350,338,250,40);
        vehicleTypeLabel.setBounds(58,388,250,40);
        vehicleTypeComboBox.setBounds(58,431,250,40);
        vehicleNoLabel.setBounds(350,388,250,40);
        vehicleNoTextField.setBounds(350,431,250,40);
        mobileNoLabel.setBounds(58,481,250,40);
        mobileNoTextField.setBounds(58,524,250,40);
        emailLabel.setBounds(350,481,250,40);
        emailTextField.setBounds(350,524,250,40);
        addressLabel.setBounds(58,574,250,40);
        addressTextField.setBounds(58,617,540,40);
        contaminatedLabel.setBounds(58, 670, 400, 40);
        yesButton.setBounds(365, 670, 70, 40);
        noButton.setBounds(440, 670, 70, 40);
        routeLabel.setBounds(58, 707, 400, 40);
        yessButton.setBounds(445, 707, 70, 40);
        nooButton.setBounds(520, 707, 70, 40);
        captureTextArea.setBounds(58, 777, 540,60);
        agreementTextArea.setBounds(58, 817, 540,60);
        agreementCheckBox.setBounds(284, 863, 540,40);
        messageLabel.setBounds(0,920,650,40);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        nextButton.setBounds(355,453,145, 42);
        bodyPanel.add(nativeLabel);
        bodyPanel.add(nativeComboBox);
        bodyPanel.add(nameLabel);
        bodyPanel.add(nameTextField);
        bodyPanel.add(fromDateLabel);
        bodyPanel.add(fromDatePicker);
        bodyPanel.add(toDateLabel);
        bodyPanel.add(toDatePicker);
        bodyPanel.add(purposeLabel);
        bodyPanel.add(purposeTextField);
        bodyPanel.add(startLocLabel);
        bodyPanel.add(startLocComboBox);
        bodyPanel.add(endLocLabel);
        bodyPanel.add(endLocComboBox);
        bodyPanel.add(vehicleTypeLabel);
        bodyPanel.add(vehicleTypeComboBox);
        bodyPanel.add(vehicleNoLabel);
        bodyPanel.add(vehicleNoTextField);
        bodyPanel.add(mobileNoLabel);
        bodyPanel.add(mobileNoTextField);
        bodyPanel.add(emailLabel);
        bodyPanel.add(emailTextField);
        bodyPanel.add(addressLabel);
        bodyPanel.add(addressTextField);
        bodyPanel.add(contaminatedLabel);
        bodyPanel.add(yesButton);
        bodyPanel.add(noButton);
        bodyPanel.add(routeLabel);
        bodyPanel.add(yessButton);
        bodyPanel.add(nooButton);
        bodyPanel.add(captureTextArea);
        bodyPanel.add(agreementTextArea);
        bodyPanel.add(agreementCheckBox);
        bodyPanel.add(messageLabel);
        bodyPanel.setLayout(null);
        
        scrollable= new JScrollPane(bodyPanel);
        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollable.setBounds(96,80,673,360);
        
        bodyPanel.setPreferredSize(new Dimension(760,997));
        mainPanel.add(nextButton);
        mainPanel.add(scrollable);
        toDatePicker.setEnabled(false);
        fromDatePicker.setDate( LocalDate.now());
        
        vehicleTypeComboBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if(vehicleTypeComboBox.getSelectedIndex()==5 || vehicleTypeComboBox.getSelectedIndex()==4)
                {
                    vehicleNoTextField.setEnabled(false);
                }
                else{
                    vehicleNoTextField.setEnabled(true);
                }
            }
        });
        fromDatePicker.addDateChangeListener((DateChangeEvent event) -> {
            LocalDate date= fromDatePicker.getDate();
            toDatePicker.setDate(date.plusDays((long)5));
            
        });
    }
    public void setRadioButton(){
        bgSet1.add(yesButton);
        bgSet1.add(noButton);       
        bgSet2.add(yessButton);
        bgSet2.add(nooButton);
    }
    private void setFontAndColor(){  
        nativeLabel.setFont(new Font("Roboto", Font.BOLD,18));
        nativeComboBox.setFont(new Font("Roboto", Font.PLAIN,18));
        nameLabel.setFont(new Font("Roboto", Font.BOLD,18));
        nameTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        fromDateLabel.setFont(new Font("Roboto", Font.BOLD,18));
        toDateLabel.setFont(new Font("Roboto", Font.BOLD,18));
        purposeLabel.setFont(new Font("Roboto", Font.BOLD,18));
        purposeTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        startLocLabel.setFont(new Font("Roboto", Font.BOLD,18));
        startLocComboBox.setFont(new Font("Roboto", Font.PLAIN,18));
        endLocLabel.setFont(new Font("Roboto", Font.BOLD,18));
        endLocComboBox.setFont(new Font("Roboto", Font.PLAIN,18));
        vehicleTypeLabel.setFont(new Font("Roboto", Font.BOLD,18));
        vehicleTypeComboBox.setFont(new Font("Roboto", Font.PLAIN,18));
        vehicleNoLabel.setFont(new Font("Roboto", Font.BOLD,18));
        vehicleNoTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        mobileNoLabel.setFont(new Font("Roboto", Font.BOLD,18));
        mobileNoTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        emailLabel.setFont(new Font("Roboto", Font.BOLD,18));
        emailTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        addressLabel.setFont(new Font("Roboto", Font.BOLD,18));
        addressTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        contaminatedLabel.setFont(new Font("Roboto", Font.BOLD,18));
        yesButton.setFont(new Font("Roboto", Font.PLAIN,18));
        noButton.setFont(new Font("Roboto", Font.PLAIN,18));
        routeLabel.setFont(new Font("Roboto", Font.BOLD,18));
        yessButton.setFont(new Font("Roboto", Font.PLAIN,18));
        nooButton.setFont(new Font("Roboto", Font.PLAIN,18));
        captureTextArea.setFont(new Font("Roboto", Font.BOLD,18));
        agreementTextArea.setFont(new Font("Roboto", Font.BOLD,18));
        agreementCheckBox.setFont(new Font("Roboto", Font.BOLD,18));
         messageLabel.setFont(new Font("Roboto",Font.BOLD,18));
        messageLabel.setForeground(new Color(51, 69, 187));
        captureTextArea.setLineWrap(true);
        captureTextArea.setEditable(false);
        captureTextArea.setOpaque(false);
        agreementTextArea.setLineWrap(true);
        agreementTextArea.setEditable(false);
        agreementTextArea.setOpaque(false);
        nativeComboBox.setEditable(false);
        startLocComboBox.setEditable(false);
        endLocComboBox.setEditable(false);
        vehicleTypeComboBox.setEditable(false);
        nativeComboBox.setBackground(Color.WHITE);
        startLocComboBox.setBackground(Color.WHITE);
        endLocComboBox.setBackground(Color.WHITE);
        vehicleTypeComboBox.setBackground(Color.WHITE);
        captureTextArea.setForeground(new Color(251,5,37));
        agreementTextArea.setForeground(new Color(251,5,37));
        nextButton.setFont(new Font("Roboto", Font.BOLD,21));
        nextButton.setBackground(new Color(113,113,113));
        nextButton.setForeground(Color.white);
    }
    private void setLocationAndSize(){
        headerPanel.setBounds(0, 0, 870, 70);
        mainPanel.setBounds(0,70,847,510); 
        bodyPanel.setBounds(96,80,810,360);    
    }
    private void setBackButton(){
        backButton.setFont(new Font("Roboto", Font.BOLD,17));
        backButton.setBounds(10,532,90,40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        container.add(backButton);
    }
    private void setButtonAction()
    {
        backButton.addActionListener((e) -> {
            this.toBack();
        });
        nextButton.addActionListener((e) -> 
        {   String nativestate=(String) nativeComboBox.getItemAt(nativeComboBox.getSelectedIndex());
            String name=nameTextField.getText();
            LocalDate fromdate= fromDatePicker.getDate();
            LocalDate todate= toDatePicker.getDate();
            String purpose=purposeTextField.getText();
            String travellingfrom=(String)startLocComboBox.getItemAt(startLocComboBox.getSelectedIndex());
            String travellingto=(String)endLocComboBox.getItemAt(endLocComboBox.getSelectedIndex());
            String vehicletype=(String)vehicleTypeComboBox.getItemAt(vehicleTypeComboBox.getSelectedIndex());
            String vehiclenumber=vehicleNoTextField.getText();
            String mobilenumber=mobileNoTextField.getText();
            String email=emailTextField.getText();
            String address=addressTextField.getText();
            String zone="";        	
        	int f=0;
        	String d="";
        	if(name.equals(d))
        	{ messageLabel.setText("Enter the name");
        		f=1;
        	}
             
                
        	if(purpose.equals(d)&& f!=1)
        	{ messageLabel.setText("Enter the Purpose");
    		  f=1;        		
        	}                   	        
        	if(vehiclenumber.equals(d)&& f!=1)
        	{ messageLabel.setText("Enter the vechiclenumber");
    		  f=1;        		
        	}
        	if(mobilenumber.equals(d)&& f!=1)
        	{ messageLabel.setText("Enter the mobilenumber");
    		  f=1;        		
        	}
        	if(!(mobilenumber.length()==10)&& f!=1)
        	{ messageLabel.setText("Enter the correct mobilenumber");
  		      f=1;        		
      	    }
        	if(email.equals(d)&& f!=1)
        	{ messageLabel.setText("Enter the email");
    		  f=1;        		
        	}
        	z_Emailvalidator emailvalid=new z_Emailvalidator();
            if(!emailvalid.validate(email)&&f!=1)
            { messageLabel.setText("Enter a valid Mail");
              f=1;
            }
        	if(address.equals(d)&& f!=1)
        	{ messageLabel.setText("Enter the address");
    		  f=1;        		
        	}             
        	int a=0;
        	if(yesButton.isSelected()&& f!=1)
            {  zone="yes";
               a=1;
            }
            if(noButton.isSelected()&& f!=1)
            { zone="no";
              a=1;
            }
            String contaminatedzone = zone;
            int b=0;
            String route="";
            if(yessButton.isSelected()&& f!=1)
            {  route="yes";
               b=1;
            }
            if(nooButton.isSelected()&& f!=1)
            { route="no";
              b=1;
            }
            String returnviasameroute = route;
            if(a==0&& f!=1)
            { messageLabel.setText("select the contaminatedzone");
              f=1;
            }
            if(b==0&& f!=1)
            { messageLabel.setText("select the returnviasameroute");
              f=1;
            }                        
            if(agreementCheckBox.isSelected() && f==0&& a==1 && b==1)
            {                                              
            int id=1000;
            try
    	    {Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");            	            
            	//Connection con=DriverManager.getConnection("jdbc:sqlite:D:\\sqllitedb\\project.db");  
         		  Statement st=con.createStatement();   		  
         		  con.setAutoCommit(true);
         		  String query1="select * from interstatepagetable";    	
         		  ResultSet r1= st.executeQuery(query1);
         		  while(r1.next())
         		  {  String str=r1.getString("id");
         			 int n=Integer.parseInt(str.substring(2,str.length()));
         		     if(n>id)
         		     {id=n;
         		     }
         		  }
         		  String query2="select * from withinstatepagetable";    	
         		  ResultSet r2= st.executeQuery(query2);
         		  while(r2.next())
         		  {  String str=r2.getString("id");
         			 int n=Integer.parseInt(str.substring(2,str.length()));
         		     if(n>id)
         		     {id=n;
         		     }
         		  }
         		  String query3="select * from emergencypagetable";    	
       		  ResultSet r3 = st.executeQuery(query3);
       		  while(r3.next())
       		  {  String str=r3.getString("id");
       			 int n=Integer.parseInt(str.substring(2,str.length()));
       		     if(n>id)
       		     {id=n;
       		     }
       		  }
       		 String query4="select * from OrganisationalPage";    	
        		  ResultSet r4= st.executeQuery(query4);
        		  while(r4.next())
        		  {  String str=r4.getString("id");
        			 int n=Integer.parseInt(str.substring(2,str.length()));
        		     if(n>id)
        		     {id=n;
        		     }
        		  }
    		  id++;
    		  con.close();
    	    }
            catch(Exception e3)
            {System.out.print("ee"+e3);}
            String status="pending";
            String photopath="";
            try 
            {   Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");
                //Connection con=DriverManager.getConnection("jdbc:sqlite:D:\\sqllitedb\\project.db");  
                Statement sta=con.createStatement();                
                 String qu="insert into interstatepagetable values('"
                        +"IS"+id+"','"+nativestate+"','"+name+"','"
                		+fromdate+"'"+ ",'"+todate+"',"
                        + "'"+purpose+"','"+travellingfrom+"'"
                        + ",'"+travellingto+"','"+vehicletype+"'"
                        + ",'"+vehiclenumber+"','"+mobilenumber+"'"
                        + ",'"+email+"','"+address+"',"
                        + "'"+contaminatedzone+"','"+returnviasameroute+"','"
                        +status+"','"+photopath+"')";	 
                sta.executeUpdate(qu);
	        con.close();
	        new m_WebCam();
            }
            catch (Exception ex) 
            {System.out.println("fail"+ex);
            } 
            }
            if(!(agreementCheckBox.isSelected()) && f==0&& a==1 && b==1)
            { messageLabel.setText("Please click the accept button to move to the next step");
            }
        });
        
    }    
    
    private void setFrame()
    {   Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png");   
        container.add(headerPanel);
        container.add(mainPanel);        
        setIconImage(icon);        
        setSize(870, 610);
        setLocationRelativeTo(null);
        setTitle("Inter State EPass");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}