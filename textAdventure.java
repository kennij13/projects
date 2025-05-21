package games;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class textAdventure {

    JFrame window;
    Container con; 
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel ; 
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    JButton startButton, choice1, choice2, choice3, choice4 ;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30); 
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 70);
    JTextArea mainTextArea; 
    int playerHp;
    String weapon, position; 

    TitleScreenHandler tsHandler = new TitleScreenHandler(); 
    choiceHandler choicHandler = new choiceHandler(); 
    public static void main(String[] args) {
        
        new textAdventure();

    }

    public textAdventure(){
        window= new JFrame(); 
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con= window.getContentPane();

        titleNamePanel = new JPanel(); 
        titleNamePanel.setBounds(100, 100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel= new JLabel("MINI ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton= new JButton("START"); 
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel); 
        con.add(startButtonPanel);

    }
    
    public void createGameScreen() {
        titleNameLabel.setVisible(false);
        startButtonPanel.setVisible(false);


        mainTextPanel = new JPanel(); 
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea= new JTextArea(); 
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white); //text color 
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);// wraps long text
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1= new JButton("Choice 1"); //button label 
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);//text color
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.setActionCommand("c1");
        choice1.addActionListener(choicHandler);
        choiceButtonPanel.add(choice1);

        choice2= new JButton("Choice 2"); 
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);//text color
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.setActionCommand("c2");
        choice2.addActionListener(choicHandler);
        choiceButtonPanel.add(choice2);

        choice3= new JButton("Choice 3"); 
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);//text color
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.setActionCommand("c3");
        choice3.addActionListener(choicHandler);
        choiceButtonPanel.add(choice3);

        choice4= new JButton("Choice 4"); 
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);//text color
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.setActionCommand("c4");
        choice4.addActionListener(choicHandler);
        choiceButtonPanel.add(choice4);

        playerPanel= new JPanel(); 
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel= new JLabel("HP:"); 
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber= new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel= new JLabel("Weapon: "); 
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName= new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
        townGate();



    }

    public void playerSetup(){
        playerHp= 15;
        weapon= "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText(""+ playerHp);

    }

    public void townGate(){
        position= "townGate";
        mainTextArea.setText("You are at the gate of town. \n A guard is staning in front of you. \nWhat do you do?");
        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard(){
        position="talkGuard"; 
        mainTextArea.setText("Guard: Well you make a pretty good case. \n I'll let you in. \n Don't cause any trouble!");
        choice1.setText("Enter the town");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void attackGuard(){
        position="attackGuard"; 
        mainTextArea.setText("Guard: That wasn't a smart move. \n The guard hits you hard. \n You lose 3 HP");
        playerHp= playerHp- 3; 
        hpLabelNumber.setText(""+playerHp); 
        choice1.setText("Attack the guard");
        choice2.setText("Retreat and apologize");
        choice3.setText("Leave");
        choice4.setText("");

    }

    public void leave(){
        position="leave"; 
        mainTextArea.setText("You turn around and leave\n You come to a cross road with 4 directions" );
        choice1.setText("North");
        choice2.setText("South");
        choice3.setText("East");
        choice4.setText("West");
    }

    public void North(){
        position="North";
        mainTextArea.setText("You go north. \n You unexpectdely come across a cliff. \n You fall off and lose " + playerHp+ " HP");
        choice1.setText("End Game");
        playerHp= playerHp - playerHp; 
        hpLabelNumber.setText("" + playerHp);
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

     public void South(){
        position="South";
        mainTextArea.setText("You go south.\n You wander for age never to be seen again...");
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void West(){
        position="west";
        mainTextArea.setText("You go west.\n You trip and fall onto your knife. \n A rookie mistake.");
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void East(){
        position="East";
        mainTextArea.setText("You go east.\n A monster emerges!!!");
        choice1.setText("Attack the monster");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void attackNoGuardWeapon(){
        position="attackNoGuardWeapon";
        playerHp= playerHp - playerHp; 
        hpLabelNumber.setText("" + playerHp);
        mainTextArea.setText("You were no match for the monster with a"+ weapon +"\n The monster easily defeats you. \n If only there was some place you could get a better weapon...");
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void run(){
        position="run";
        playerHp= playerHp - playerHp; 
        hpLabelNumber.setText("" + playerHp);
        mainTextArea.setText("The monster catches you.\n You lose. \n If only there was some place you could get a better weapon...");
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void attackWithGuardWeapon(){
        position="attackWithGuardWeapon";
        mainTextArea.setText("You easily defeat the monster with you new weapon.\n You discover that the monster was guarding treasure. \n You collect all of the treasure and leave happily wealthy.");
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void endGame(){
        position="endGame";
        con.removeAll();
        con.repaint();
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        titleNameLabel.setVisible(true);
        startButtonPanel.setVisible(true);
        playerHp= 15;
        weapon= "Knife";

        window.revalidate(); 
        new textAdventure(); 
    }




    public void attackGuardAgain(){
        position="attackGuardAgain"; 
        mainTextArea.setText("Guard: Ready for another round? . \n The guard easily knocks your knife away. \n With no weapon, the guard  defeats you."); 
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

     public void retreat(){
        position="retreat"; 
        mainTextArea.setText("Guard: That wasn't very nice of you. \n The guard sends you away. \n You wander for ages, never to be seen again");
        hpLabelNumber.setText(""+playerHp); 
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void enterTown(){
        position="enterTown";
        mainTextArea.setText("You discover hidden treasure. Congrats!!!");
        choice1.setText("End Game");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void talkThenAttack(){
        position="talkThenAttack";
        mainTextArea.setText("You catch the guard off guard when you enter.\n You defeat him!");
        choice1.setText("Take his weapon");
        choice2.setText("Leave his weapon");
        choice3.setText("");
        choice4.setText("");
        
    }

     public void takeHisWeapon(){
        position="takeHisWeapon";
        weapon= "Sword";
        weaponLabelName.setText(weapon);
        mainTextArea.setText("You took his weapon.\n You now have a " + weapon);
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void next() {
        position= "continue";
        mainTextArea.setText("A monster emerges!!");
        choice1.setText("Attack the monster");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
        
    }

    public void leaveHisWeapon(){
        position="leaveHisWeapon";
        weaponLabelName.setText(weapon);
        mainTextArea.setText("You left his weapon.\n You still have a " + weapon);
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
    }




    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
            
        }
    }

    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice= event.getActionCommand(); 
            switch (position) {

            case "townGate":
                if (yourChoice.equals("c1")) {
                    talkGuard();
                } else if (yourChoice.equals("c2")) {
                    attackGuard();
                } else if (yourChoice.equals("c3")) {
                    leave();
                }
                break;

            case "talkGuard":
                if (yourChoice.equals("c1")) {
                    enterTown(); // peaceful entry
                } else if (yourChoice.equals("c2")) {
                    talkThenAttack(); // sneak attack guard
                } else if (yourChoice.equals("c3")) {
                    leave();
                }
                break;

            case "attackGuard":
                if (yourChoice.equals("c1")) {
                    attackGuardAgain();
                } else if (yourChoice.equals("c2")) {
                    retreat();
                } else if (yourChoice.equals("c3")) {
                    leave();
                }
                break;

            case "talkThenAttack":
                if (yourChoice.equals("c1")) {
                    takeHisWeapon(); // take sword
                } else if (yourChoice.equals("c2")) {
                    leaveHisWeapon();
                }
                break;

            case "takeHisWeapon":
            case "leaveHisWeapon":
                if (yourChoice.equals("c1")) {
                    leave(); // go back to crossroads
                }
                break;

            case "enterTown":
                if (yourChoice.equals("c1")) {
                    endGame();
                }
                break;

            case "attackGuardAgain":
            case "retreat":
                if (yourChoice.equals("c1")) {
                    endGame();
                }
                break;

            case "leave":
                if (yourChoice.equals("c1")) {
                    North();
                } else if (yourChoice.equals("c2")) {
                    South();
                } else if (yourChoice.equals("c3")) {
                    East();
                } else if (yourChoice.equals("c4")) {
                    West();
                }
                break;

            case "North":
            case "South":
            case "West":
                if (yourChoice.equals("c1")) {
                    endGame();
                }
                break;

            case "East":
                if (yourChoice.equals("c1")) {
                    if (weapon.equals("Sword")) {
                        attackWithGuardWeapon();
                    } else {
                        attackNoGuardWeapon();
                    }
                } else if (yourChoice.equals("c2")) {
                    run();
                }
                break;

            case "attackNoGuardWeapon":
            case "run":
           
            case "attackWithGuardWeapon":
    if (yourChoice.equals("c1")) {
        endGame();
    }
    break;

            case "endGame":
                endGame();
                break;
        }

    
             
        }
    }
}
