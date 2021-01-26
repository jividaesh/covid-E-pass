package finalproject;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.*;
import javax.swing.*;
public class g3_CertificatePage extends JFrame implements ActionListener {
    private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JPanel bodyPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS");
    private JLabel signLabel = new JLabel();
    private JLabel issueLabel=new JLabel("Issued by Team 29");
    private JLabel dbpassLabel=new JLabel();
    private JLabel referenceidLabel=new JLabel("Ref ID :");
    private JLabel dbReferenceIdLabel=new JLabel();
    private JLabel nameLabel=new JLabel("Name            :");
    private JLabel numberLabel=new JLabel("Mobile No     :");
    private JLabel fromDateLabel=new JLabel("Valid From   :");
    private JLabel toDateLabel=new JLabel("Valid Till    :");
    private JLabel fromLocationLabel=new JLabel("Start Point    :");
    private JLabel toLocationLabel=new JLabel("End Point  :");
    private JLabel imageLabel=new JLabel();
    private JLabel typeLabel=new JLabel("Return Type :");
    private JLabel vehicleNoLabel=new JLabel("Vehicle No   :");
    private JLabel dbvehicleno=new JLabel();
    private JLabel dbNameLabel=new JLabel();
    private JLabel dbNumberLabel=new JLabel();
    private JLabel dbFromDateLabel=new JLabel();
    private JLabel dbToDateLabel=new JLabel();
    private JLabel dbFromLocationLabel=new JLabel();
    private JLabel dbToLocationLabel=new JLabel();
    private JLabel dbTypeLabel=new JLabel();
    private JButton printButton=new JButton("PRINT");
    private JPanel certificateHeaderPanel = new JPanel();
    private JPanel certificateBodyPanel = new JPanel();
    private JLabel certiLabel = new JLabel("GOVERNMENT OF BOOTCAMP");
    g3_CertificatePage()
    {
        setLayoutManager();
        setLocationAndSize();
        setHeaderPanel();
        setBodyPanel();
        setFontAndColor();
        addComponentsToContainer();
        setCertificateHeaderPanel();
        setCertificateBodyPanel();
        setPrintButton();
        getdetails();
        Listener();
        setFrame();
    }
    public void setLayoutManager(){
        //container.setBackground(Color.WHITE);
        container.setLayout(null);
    }
    public void setHeaderPanel(){
        headerPanel.setBackground(new Color(251,5,37));
        headerPanel.setLayout(new GridLayout(1,1,0,0));  
        ImageIcon iconLogo = new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon.png").getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto", Font.BOLD,26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
    }
    private void setCertificateHeaderPanel(){
        certificateHeaderPanel.setBounds(0,0,715,55);
        certiLabel.setBounds(0, 0, 715, 55);
        certificateHeaderPanel.setBackground(new Color(251,5,37));
        certiLabel.setHorizontalAlignment(JLabel.CENTER);
        certiLabel.setVerticalAlignment(JLabel.CENTER);
        certiLabel.setFont(new Font("Roboto", Font.BOLD,25));
        certiLabel.setForeground(Color.white);
        certificateHeaderPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
        certificateHeaderPanel.setLayout(null);
        bodyPanel.add(certiLabel);
        bodyPanel.add(certificateHeaderPanel);
    }
    private void setCertificateBodyPanel(){
       
        signLabel.setBounds(540, 210,150, 70);
        referenceidLabel.setBounds(495,40,220,20);
        dbpassLabel.setBounds(0, 0, 690, 25);
        certificateBodyPanel.setBounds(12,55,690,305);
        imageLabel.setBounds(535,10,250,250);
        nameLabel.setBounds(20,50,120,20);
        numberLabel.setBounds(20,90,120,20);
        fromLocationLabel.setBounds(20,130,120,20);
        toLocationLabel.setBounds(290,130,120,20);
        fromDateLabel.setBounds(20,170,120,20);
        toDateLabel.setBounds(290,170,120,20);
        vehicleNoLabel.setBounds(20,210,120,20);
        typeLabel.setBounds(20,250,120,25);
                
        dbNameLabel.setBounds(150,50,170,20);
        dbNumberLabel.setBounds(150,90,170,20);
        dbFromDateLabel.setBounds(150,170,170,20);
        dbToDateLabel.setBounds(400,170,170,20);
        dbFromLocationLabel.setBounds(150,130,170,20);
        dbToLocationLabel.setBounds(400,130,170,20);
        dbvehicleno.setBounds(150,210,170,20);
        dbTypeLabel.setBounds(150,250,170,25);
        dbReferenceIdLabel.setBounds(582,37,85,25);
        //dbpasstype.setBounds(275,60,200,20);
        issueLabel.setBounds(540,250 ,200,30);
       
        
        ImageIcon imageSign = new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\signature.png").getImage().getScaledInstance(70,20, Image.SCALE_SMOOTH));
        signLabel.setIcon(imageSign);
     
        certificateBodyPanel.add(nameLabel);
        certificateBodyPanel.add(numberLabel);
        certificateBodyPanel.add(dbpassLabel);
        certificateBodyPanel.add(imageLabel);
        certificateBodyPanel.add(signLabel);
        certificateBodyPanel.add(fromLocationLabel);
        certificateBodyPanel.add(toLocationLabel);
        certificateBodyPanel.add(referenceidLabel);
        certificateBodyPanel.add(fromDateLabel);
        certificateBodyPanel.add(toDateLabel);
        certificateBodyPanel.add(vehicleNoLabel);
        certificateBodyPanel.add(typeLabel);
        certificateBodyPanel.add(dbNameLabel);
        certificateBodyPanel.add(dbNumberLabel);
        certificateBodyPanel.add(dbFromDateLabel);
        certificateBodyPanel.add(dbToDateLabel);
        certificateBodyPanel.add(dbFromLocationLabel);
        certificateBodyPanel.add(dbToLocationLabel);
        certificateBodyPanel.add(dbReferenceIdLabel);
        certificateBodyPanel.add(dbvehicleno);
        certificateBodyPanel.add(dbTypeLabel);
        certificateBodyPanel.add(issueLabel);
        dbpassLabel.setHorizontalAlignment(JLabel.CENTER);
        dbpassLabel.setBackground(Color.black);
        dbpassLabel.setForeground(Color.white);
        certificateBodyPanel.setBackground(Color.WHITE);
        dbpassLabel.setOpaque(true);
        certificateBodyPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        certificateBodyPanel.setLayout(null);  
    }
    private void setBodyPanel(){
        bodyPanel.add(certificateBodyPanel);    
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        bodyPanel.setLayout(null);
    }
    private void setFontAndColor(){  
        dbpassLabel.setFont(new Font("Roboto", Font.BOLD,17));
        referenceidLabel.setFont(new Font("Roboto", Font.BOLD,22));
        //organization.setFont(new Font("Roboto", Font.PLAIN,17));
        typeLabel.setFont(new Font("Roboto", Font.BOLD,18));
        nameLabel.setFont(new Font("Roboto", Font.BOLD,18));
        numberLabel.setFont(new Font("Roboto", Font.BOLD,18));
        fromDateLabel.setFont(new Font("Roboto", Font.BOLD,18));
        toDateLabel.setFont(new Font("Roboto", Font.BOLD,18));
        fromLocationLabel.setFont(new Font("Roboto", Font.BOLD,18));
        toLocationLabel.setFont(new Font("Roboto", Font.BOLD,18));
        vehicleNoLabel.setFont(new Font("Roboto", Font.BOLD,18));
        dbNameLabel.setFont(new Font("Roboto", Font.PLAIN,18));
        dbNumberLabel.setFont(new Font("Roboto", Font.PLAIN,18));
        dbFromDateLabel.setFont(new Font("Roboto", Font.PLAIN,18));
        dbToDateLabel.setFont(new Font("Roboto", Font.PLAIN,18));
        dbFromLocationLabel.setFont(new Font("Roboto", Font.PLAIN,18));
        dbToLocationLabel.setFont(new Font("Roboto", Font.PLAIN,18));
        dbReferenceIdLabel.setFont(new Font("Roboto", Font.PLAIN,22));
        dbReferenceIdLabel.setForeground(Color.RED);
        dbvehicleno.setFont(new Font("Roboto", Font.PLAIN,18));
        dbTypeLabel.setFont(new Font("Roboto", Font.PLAIN,18));
       
    }
    private void setPrintButton(){
        printButton.setBounds(340,510,140,35);
        printButton.setBackground(new Color(0, 0, 0));
        printButton.setForeground(Color.WHITE);
        printButton.setFont(new Font("Roboto", Font.BOLD,20));
    }
    private void setLocationAndSize(){
        headerPanel.setBounds(0, 0, 870, 70);
        bodyPanel.setBounds(60,125,715,375);
    }
    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
           container.add(printButton);
    }  
    private void getdetails()
    {
        
                //passtype=null;
         String id ="OR1033";
         String passtype="";
         //INTERSTATE   WITHIN STATE  EMERGENCY
         if(id.startsWith("EM")||id.startsWith("IS")||id.startsWith("OR") && (!id.startsWith("OR")))
         {
             String name=null,mobilenumber=null,fromdate=null,todate=null,travellingfrom=null,
                travellingto=null,vehiclenumber=null,returnviasameroute=null,photopath =null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");
                //Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\SQLiteStudio\\final.db");
                Statement st=con.createStatement();
                String query="";
                if(id.startsWith("EM"))
                {
                     query = "SELECT id,name,mobilenumber,fromdate,todate,travellingfrom,"
                        + "travellingto,vehiclenumber,returnviasameroute,photopath from emergencypagetable";
                }
                else if(id.startsWith("IS"))
                {
                    query = "SELECT id,name,mobilenumber,fromdate,todate,travellingfrom,"
                        + "travellingto,vehiclenumber,returnviasameroute,photopath  from interstatepagetable";
                }
                else if(id.startsWith("WS"))
                {
                     query = "SELECT id,name,mobilenumber,fromdate,todate,travellingfrom,"
                        + "travellingto,vehiclenumber,returnviasameroute,photopath  from withinstatepagetable";
                }
                
                 
		  if(id.substring(0,2).equals("IS"))
		  {	passtype="Inter State e-pass";	  
		  }
		  if(id.substring(0,2).equals("WS"))
		  {	passtype="Within State e-pass";		  
		  }
		  if(id.substring(0,2).equals("EM"))
		  {     passtype="Emergency e-pass";			  
		  }
                ResultSet rs = st.executeQuery(query);
                
                while(rs.next())
                {
                    if(id.equals(rs.getString("id")))
                    {
                    name=rs.getString("name");
                    mobilenumber=rs.getString("mobilenumber");
                    fromdate=rs.getString("fromdate");
                    todate=rs.getString("todate");
                    travellingfrom=rs.getString("travellingfrom");
                    travellingto=rs.getString("travellingto");
                    vehiclenumber=rs.getString("vehiclenumber");
                    returnviasameroute=rs.getString("returnviasameroute");
                    photopath = rs.getString("photopath");
                    //passtype=rs.getString("passtype");
                    break;
                    }
                }
            } catch (Exception ej) {
                System.out.println(ej+"gsf");
            }
            dbNameLabel.setText(name);
            dbNumberLabel.setText(mobilenumber);
            dbFromDateLabel.setText(fromdate);
            dbToDateLabel.setText(todate);
            dbFromLocationLabel.setText(travellingfrom);
            dbToLocationLabel.setText(travellingto);
            dbvehicleno.setText(vehiclenumber);
            dbReferenceIdLabel.setText(id);
            dbTypeLabel.setText(returnviasameroute);
            dbpassLabel.setText(passtype.toUpperCase());
            ImageIcon image = new ImageIcon(new ImageIcon(photopath).getImage().getScaledInstance(130,120, Image.SCALE_SMOOTH));
            imageLabel.setIcon(image);
            
            dbNameLabel.getText();
            dbNumberLabel.getText();
            dbFromDateLabel.getText();
            dbToDateLabel.getText();
            dbFromLocationLabel.getText();
            dbToLocationLabel.getText();
            dbvehicleno.getText();
            dbTypeLabel.getText();
            dbReferenceIdLabel.getText();
            dbTypeLabel.getText();
            dbpassLabel.getText();
         }
         else if(id.startsWith("OR"))  
         {
             String name=null,mobilenumber=null,fromdate=null,todate=null,travellingfrom=null,travellingto=null,
                     referenceid =null,vehiclenumber=null,organizationname=null,returnviasameroute=null,
                     photopath=null,organizationtype=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project","root0","root");
                //Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\SQLiteStudio\\final.db");
                Statement st=con.createStatement();
                String query="";
                    query = "SELECT id,name,mobilenumber,fromdate,todate,travellingfrom,"
                        + "travellingto,vehiclenumber,organizationname,returnviasameroute,"
                        + "organizationtype,photopath from organisationalpage";              
	        passtype="Organisational e-pass";	  

		 
                ResultSet rs = st.executeQuery(query);
                
                while(rs.next())
                {
                    if(id.equals(rs.getString("id")))
                    {
               
                    name=rs.getString("name");
                    mobilenumber=rs.getString("mobilenumber");
                    fromdate=rs.getString("fromdate");
                    todate=rs.getString("todate");
                    travellingfrom=rs.getString("travellingfrom");
                    travellingto=rs.getString("travellingto");
                    vehiclenumber=rs.getString("vehiclenumber");
                    organizationname=rs.getString("organizationname");
                    returnviasameroute=rs.getString("returnviasameroute");
                    organizationtype=rs.getString("organizationtype");
                    photopath = rs.getString("photopath");
                    }
                }
            } catch (Exception ej) {
                System.out.println(ej+"HD");
            }
            dbNameLabel.setText(name);
            dbNumberLabel.setText(mobilenumber);
            dbFromDateLabel.setText(fromdate);
            dbToDateLabel.setText(todate);
            dbFromLocationLabel.setText(travellingfrom);
            dbToLocationLabel.setText(travellingto);
            dbvehicleno.setText(vehiclenumber);
            dbReferenceIdLabel.setText(id);
            dbTypeLabel.setText(returnviasameroute);
            dbpassLabel.setText(passtype.toUpperCase());
            ImageIcon image = new ImageIcon(new ImageIcon(photopath).getImage().getScaledInstance(130,120, Image.SCALE_SMOOTH));
            imageLabel.setIcon(image);
            
            dbNameLabel.getText();
            dbNumberLabel.getText();
            dbFromDateLabel.getText();
            dbToDateLabel.getText();
            dbFromLocationLabel.getText();
            dbToLocationLabel.getText();
            dbvehicleno.getText();
            dbTypeLabel.getText();
            dbReferenceIdLabel.getText();
            dbTypeLabel.getText();
            dbpassLabel.getText();
         }
    }
    private void Listener()
    {
        printButton.addActionListener( this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==printButton)
        {
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");          
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.PORTRAIT);
                 if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.6,0.6);              
                bodyPanel.paint(g2);                  
                return Printable.PAGE_EXISTS;           
            }
    });         
        boolean ok = job.printDialog();
        if(ok){
        try{        
        job.print();
        }
        catch (PrinterException ex){}
        }
        }
    }
    private void setFrame()
        {
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png");  
        setIconImage(icon);
        setVisible(true);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        }
    public static void main(String[] args) {
        new g3_CertificatePage();
    }
}
