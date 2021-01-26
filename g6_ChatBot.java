package finalproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class g6_ChatBot extends JFrame implements KeyListener,ActionListener
{   private JLabel passTitleLabel = new JLabel(" Hi there! how can I help you ?");
    private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS");
    private JPanel mainPanel = new JPanel();    
    private JPanel bodyPanel = new JPanel();	
	private JTextArea chatBoxTextArea=new JTextArea();
	private JTextArea typeTextField=new JTextArea();
	private JScrollPane  scrollable=new JScrollPane();    
    private JButton backButton = new JButton("Back");
    private JLabel typeLabel = new JLabel("Type Here >");
	String[][] chatBot=
	    {  //standard greetings
			{"hi","hello","hola","ola","howdy"},
			{"hi","hello","hey"},
			//question greetings
			{"how are you","how r you","how r u","how are u"},
			{"good","doing well"},
			//yes
			{"yes"},
			{"no","NO","NO!!!!!!!"},
			//default
			{"shut up","you're bad","noob","stop talking",
			"I'm  is BUSY !! BYE  Hehe, due to LOL..Hehe"}
                    
		};	
    g6_ChatBot(){
        setLayoutManager();
        setHeaderPanel();
        setPassLabel();
        setBodyPanel();
        setLocationAndSize();
        setFontAndColor();
        setBackButton();
        setFrame();
        addComponentsToContainer();
        setFrame();
    }
    private void setLayoutManager(){
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
     private void setPassLabel(){
        passTitleLabel.setFont(new Font("Roboto", Font.BOLD,23));
        passTitleLabel.setBounds(0,85,870,30);
        passTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        
    }
    private void setBodyPanel(){
        chatBoxTextArea.setBounds(35,35,590,300);
        typeTextField.setBounds(157,320,469,30);
        typeLabel.setBounds(35,320,150,30);
        chatBoxTextArea.setLineWrap(true);
        chatBoxTextArea.setEditable(false);
        typeTextField.setBorder(BorderFactory.createEmptyBorder());
        chatBoxTextArea.setBorder(BorderFactory.createEmptyBorder());
        scrollable= new JScrollPane(chatBoxTextArea);
        scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollable.setBounds(35,35,590,270);
        chatBoxTextArea.setPreferredSize(new Dimension(760,400));        
        bodyPanel.add(scrollable);
        bodyPanel.add(typeTextField);    
        bodyPanel.add(typeLabel);
        bodyPanel.setLayout(null);        
        typeTextField.addKeyListener(this);	
    }    
    private void setFontAndColor(){ 
    	typeTextField.setFont(new Font("Roboto", Font.PLAIN,18));
        typeLabel.setFont(new Font("Roboto", Font.BOLD,20));
        chatBoxTextArea.setFont(new Font("Roboto", Font.PLAIN,18));
        typeTextField.setBackground(Color.WHITE);
        bodyPanel.setBackground(new Color(113,113,113));
        typeLabel.setForeground(Color.WHITE);
        chatBoxTextArea.setOpaque(true);
        typeTextField.setOpaque(true);
    }    
    private void setBackButton(){
        backButton.setFont(new Font("Roboto", Font.BOLD,17));
        backButton.setBounds(10,532,90,40);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        container.add(backButton);
    }    
    private void setLocationAndSize(){
        headerPanel.setBounds(0, 0, 870, 70);
        bodyPanel.setBounds(100,135,660,378);
    }     
    private void addComponentsToContainer(){
        container.add(headerPanel);
        container.add(bodyPanel);
        container.add(passTitleLabel);
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
  
    public void keyPressed(KeyEvent e){
    	if(e.getKeyCode()==KeyEvent.VK_ENTER)
	    {  typeTextField.setEditable(false);
			String quote=typeTextField.getText();
			typeTextField.setText("");
			addText("-->You  :\t"+quote);
			quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			)
			{ quote=quote.substring(0,quote.length()-1);
			}
			quote.trim();
			byte response=0;		
			int j=0;
			while(response==0)
			{ if(inArray(quote.toLowerCase(),chatBot[j*2]))
			    {   response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n-->Bot   :\t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatBot.length-1 && response==0)
				{ response=1;
				}
			}			
			if(response==1)
			{   int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n-->Bot   :\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}	
	public void keyReleased(KeyEvent e)
	{  if(e.getKeyCode()==KeyEvent.VK_ENTER)
	    { typeTextField.setEditable(true);
		}
	}
	public void keyTyped(KeyEvent e)
	{}	
	public void addText(String str)
	{ chatBoxTextArea.setText(chatBoxTextArea.getText()+str);
	}	
	public boolean inArray(String in,String[] str)
	{ boolean match=false;
		for(int i=0;i<str.length;i++)
		{ if(str[i].equals(in))
		  { match=true;
		  }
		}
		return match;
	}
	public void actionPerformed(ActionEvent e) 
	{  if(e.getSource()==backButton)
	   {  
               this.toBack();
	   }		
	}
}