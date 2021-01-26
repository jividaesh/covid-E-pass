package finalproject;

import javax.swing.*;
import java.awt.*;

public class b_AccountTypePage extends JFrame {
     private Container container =getContentPane();
    private JPanel headerPanel=new JPanel();
    private JPanel bodyPanel=new JPanel();
    private JLabel headerTitleLabel=new JLabel("BOOTCAMP E-PASS ");
    private JLabel bodyLabel=new JLabel("Select Profile Type");
    private JLabel userLabel = new JLabel("User");
    private JLabel officerLabel = new JLabel("Officer");
    private JLabel adminLabel = new JLabel("Admin");
    private Icon userIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\userIcon.png");
    private JButton userButton=new JButton(userIcon);
    private Icon officerIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\officerIcon.jpg");
    private JButton officerButton=new JButton(officerIcon);
    private Icon adminIcon = new ImageIcon("C:\\Users\\Admin\\Desktop\\adminIcon.jpg");
    private JButton adminButton=new JButton(adminIcon);
    private JButton backButton = new JButton("Back");
    
    b_AccountTypePage(){    
        setHeaderpanel();
        setLocation();
        setBodypanel();
        setBodyLabel();
        setFontandColor();
        setAddToCointainer(); 
        setBackButton();
        setButtonAction();
        setFrame();
    }
   
   private void setHeaderpanel(){
        headerPanel.setBackground(new Color(251,5,37));
        headerPanel.setLayout(new GridLayout(1,1,0,0));   
        ImageIcon iconLogo = new ImageIcon(new ImageIcon ("C:\\Users\\Admin\\Desktop\\icon.png").getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto", Font.BOLD,26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
    }
   private void setBodyLabel(){
        bodyLabel.setBounds(0,120,870,30);
        bodyLabel.setHorizontalAlignment(JLabel.CENTER);
    }
    private void setBodypanel(){
        userButton.setBounds(75,66,121,121);
        userLabel.setBounds(75,145,120,120);
        officerButton.setBounds(233,66,121,121);
        officerLabel.setBounds(233,145,120,120);
        adminButton.setBounds(385,66,121,121);
        adminLabel.setBounds(385,145,120,120);
        bodyPanel.add(userButton);
        bodyPanel.add(userLabel);
        bodyPanel.add(officerButton);
        bodyPanel.add(officerLabel);
        bodyPanel.add(adminButton);
        bodyPanel.add(adminLabel);
        bodyPanel.setLayout(null);
    }
    private void setFontandColor(){
        bodyLabel.setFont(new Font("Robata",Font.BOLD,25));
        userLabel.setFont(new Font("Robata",Font.BOLD,19));
        officerLabel.setFont(new Font("Robata",Font.BOLD,19));
        adminLabel.setFont(new Font("Robata",Font.BOLD,19));
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        officerLabel.setHorizontalAlignment(JLabel.CENTER);
        adminLabel.setHorizontalAlignment(JLabel.CENTER);
        userButton.setBackground(Color.black);
        officerButton.setBackground(Color.black);
        adminButton.setBackground(Color.black);
    }
    private void setBackButton(){
        backButton.setFont(new Font("Roboto", Font.BOLD,17));
        backButton.setBounds(10,532,90,40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
    }
    private void setLocation(){
       headerPanel.setBounds(0, 0, 870, 70);
       bodyPanel.setBounds(126,178,580,265);
    }

    private void setAddToCointainer(){
        container.setBackground(Color.WHITE);
        container.setLayout(null);
        container.add(headerPanel);
        container.add(bodyPanel);
        container.add(backButton);
        add(bodyLabel);
    }
    
      
    public void setButtonAction()
    {
        backButton.addActionListener((e) -> {
           this.toBack();
        });
       userButton.addActionListener((e) -> {
           new c_UserLoginPage();
       });
       officerButton.addActionListener((e) -> {
          new e_PoliceLoginPage();
       });
       adminButton.addActionListener((e) -> {
          new f_AdminLoginPage();
       });
    }
    private void setFrame(){
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png");
        setIconImage(icon);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }   
    
}