package finalproject;

import javax.swing.*;
import java.awt.*;

public class  g1_ListGeneratePage extends JFrame{
     private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS");
    private JPanel mainPanel = new JPanel();
    private JPanel bodyPanel = new JPanel();
    private JButton generateButton = new JButton("Generate New E-Pass");
    private JButton statusButton = new JButton("View Status");
    private JButton historyButton = new JButton("View History");
    private JButton helplineButton = new JButton("Helpline");
    private JButton backButton=new JButton("Back");
    
     g1_ListGeneratePage(){
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
        
        bodyPanel.add(generateButton);
        bodyPanel.add(statusButton);
        bodyPanel.add(historyButton);
        bodyPanel.add(helplineButton);
        generateButton.setFont(new Font("Roboto", Font.BOLD,19));
        statusButton.setFont(new Font("Roboto", Font.BOLD,19));
        historyButton.setFont(new Font("Roboto", Font.BOLD,19));
        helplineButton.setFont(new Font("Roboto", Font.BOLD,19));
        generateButton.setBackground(new Color(251,5,37));
        statusButton.setBackground(new Color(251,5,37));
        historyButton.setBackground(new Color(251,5,37));
        helplineButton.setBackground(new Color(251,5,37));
        generateButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        statusButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        historyButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        helplineButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        generateButton.setForeground(Color.white);
        statusButton.setForeground(Color.white);
        historyButton.setForeground(Color.white);
        helplineButton.setForeground(Color.white);
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
        container.add(backButton);
    }
   public void setBackButton(){
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
        generateButton.addActionListener((e) -> {
            new h_EPassCategory();
        });
        statusButton.addActionListener((e) -> {
            //next frame
        });
        historyButton.addActionListener((e) -> {
            //next frame
        });
        helplineButton.addActionListener((e) -> {
            new g6_ChatBot();
        });
    }
   
     private void setFrame(){
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\icon.png"); 
        setIconImage(icon);
        setVisible(true);
        setSize(870, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
