package finalproject;

import javax.swing.*;
import java.awt.*;

public class h_EPassCategory extends JFrame{
     private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS");
    private JPanel mainPanel = new JPanel();
    private JPanel bodyPanel = new JPanel();
    private JButton intraButton = new JButton("Within State E -Pass");
    private JButton interButton = new JButton("Inter State E - Pass");
    private JButton emergencyButton = new JButton("Emergency E - Pass");
    private JButton organisationButton = new JButton("Organisational E - Pass");
    private JButton backButton=new JButton("Back");
    
     h_EPassCategory(){
        setLayoutManager();
        setLocationAndSize();
        setHeaderPanel();
        setBodyPanel();
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
        ImageIcon iconLogo = new ImageIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon.png").getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto", Font.BOLD,26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
    }
    private void setBodyPanel(){
        
        bodyPanel.add(intraButton);
        bodyPanel.add(interButton);
        bodyPanel.add(emergencyButton);
        bodyPanel.add(organisationButton);
        intraButton.setFont(new Font("Roboto", Font.BOLD,19));
        interButton.setFont(new Font("Roboto", Font.BOLD,19));
        emergencyButton.setFont(new Font("Roboto", Font.BOLD,19));
        organisationButton.setFont(new Font("Roboto", Font.BOLD,19));
        intraButton.setBackground(new Color(251,5,37));
        interButton.setBackground(new Color(251,5,37));
        emergencyButton.setBackground(new Color(251,5,37));
        organisationButton.setBackground(new Color(251,5,37));
        intraButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        interButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        emergencyButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        organisationButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        intraButton.setForeground(Color.white);
        interButton.setForeground(Color.white);
        emergencyButton.setForeground(Color.white);
        organisationButton.setForeground(Color.white);
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(new GridLayout(4,1,50,40));
    }
    private void setLocationAndSize(){
        headerPanel.setBounds(0, 0, 870, 70);
        bodyPanel.setBounds(250,145,350,350);
    }
 
    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
    }
    
    private void setFrame(){
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png");  
        setIconImage(icon);
        setVisible(true);
         setSize(870, 610);
        setLocationRelativeTo(null);
        setTitle("EPass Categories");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    private void setButtonAction()
    {
        backButton.addActionListener((e) -> {
            this.toBack();
        });
        interButton.addActionListener((e) -> {
            new  i_InterStatePage ();
        });
        intraButton.addActionListener((e) -> {
            new j_WithinStatePage();
        });
        emergencyButton.addActionListener((e) -> {
            new k_EmergencyPage();
        });
        organisationButton.addActionListener((e) -> {
            new l_OrganisationalPage();
        });
    }
     private void setBackButton()
    {
        
    backButton.setFont(new Font("Roboto", Font.BOLD,17));
        backButton.setBounds(10,532,90,40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        container.add(backButton);
    }
}
