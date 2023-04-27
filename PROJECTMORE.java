import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
/**
 * Snake Eyez.
 * 
 * If the sum
 * is 7 or 11 on the first roll, the player wins. If the sum is 2, 3 or 12 on the first roll the player loses.
 * If the sum is 4, 5, 6, 8, 9 or 10 on the first roll, that sum becomes the player’s “point”. To win, a
 * player must continue rolling the dice until the player rolls the point value. The player loses by
 * rolling a 7 before rolling the point.
 *
 * @Nikola Jocic Student ID: 20200041 email: 20200041@student.act.edu
 * @version 1.01 Date: 02/04/2021
 */
public class PROJECTMORE extends JFrame implements ActionListener
{
    // Variables Area
    private int random1;
    private int random2;
    private int check;
    private int sum;
    private int check2;
    private int check3;
    private String diceNumber1;
    private String diceNumber2;
    private int point;
    private int roundCount;
    private int score;
    private String textScoreLabel;
    
    //Series of other JElements
    JButton play;
    JButton roll;
    JButton quit;
    JButton rules;
    JTextField showResult;
    JTextField insertPlayerCount;
    JLabel Score;
    JLabel Score2;
    JLabel Score3;
    JLabel Score4;
    JLabel result;
    JLabel dice1;
    JLabel dice2;
    JLabel diceHidden1;
    JLabel diceHidden2;
    JLabel radioButton;
    JLabel playerCount;
    ImageIcon diceImage1;
    ImageIcon diceImage2;
    JRadioButton yes;
    JRadioButton no;
    
    //Series of JPanels
    JPanel panel_Play;
    JPanel panel_Roll;
    JPanel panel_Controls;
    JPanel panel_Score;
    JPanel panel_quit;
    JPanel panel_rules;
    JPanel panel_result;
    JPanel panel_titleBorder;
    JPanel panel_left;
    JPanel panel_right;
    JPanel panel_dice;
    JPanel panel_quitRulesResult;
    JPanel panel_showResult; 
    JPanel panel_players;
    JPanel panel_computerButton;
    JPanel panel_playerCount;
    JPanel panel_upperControls;
    JPanel panel_controlsAndDice;
    JPanel panel_labelScore;
    JPanel panel_labelScore2;
    JPanel panel_labelScore3;
    JPanel panel_labelScore4;
    JPanel panel_playersScore;
    
    // Constructor Area - will create the 'interface' of the program
    public PROJECTMORE()
    {
        //Sets the title
        setTitle("Snake Eyez");

        // Create the appropriate objects based on the variables area
        showResult = new JTextField(15);
        insertPlayerCount = new JTextField(7);
        Score = new JLabel("Player1: 0");
        Score2 = new JLabel("Player2: 1");
        Score3 = new JLabel("Player3: 2");
        Score4 = new JLabel("Player4: 3");
        dice1 = new JLabel(diceImage1);
        dice2 = new JLabel(diceImage2);
        diceHidden1 = new JLabel(diceImage2);
        diceHidden2 = new JLabel(diceImage1);
        playerCount = new JLabel("How many players are playing?");
        radioButton = new JLabel("Do you want to play with the computer?");
        play = new JButton("Play");
        roll = new JButton("Roll");
        quit = new JButton("Quit");
        yes = new JRadioButton("Yes", true);
        no = new JRadioButton("No", false);
        rules = new JButton("Rules");
        result = new JLabel("Result: ");
        
        showResult.setEditable(false);
        dice1.setVisible(false);
        dice2.setVisible(false);
        diceHidden1.setVisible(false);
        diceHidden2.setVisible(false);
        
        panel_Controls = new JPanel();
        panel_Score = new JPanel();
        panel_labelScore= new JPanel();
        panel_labelScore2= new JPanel();
        panel_labelScore3 = new JPanel();
        panel_labelScore4 = new JPanel();
        panel_quit= new JPanel();
        panel_titleBorder = new JPanel();
        panel_left = new JPanel();
        panel_right = new JPanel();
        panel_dice = new JPanel();
        panel_quitRulesResult= new JPanel();
        panel_rules= new JPanel();
        panel_result= new JPanel();
        panel_showResult= new JPanel();
        panel_Play = new JPanel();
        panel_Roll = new JPanel();
        panel_players= new JPanel();
        panel_upperControls= new JPanel();
        panel_computerButton = new JPanel();
        panel_playerCount = new JPanel();
        panel_controlsAndDice = new JPanel();
        panel_playersScore = new JPanel();
        
        //Setting button colours
        play.setBackground(Color.green);
        roll.setBackground(Color.yellow);
        rules.setBackground(Color.orange);
        quit.setBackground(Color.cyan);
        
        //SIDE CONTROLS PANELS   
        
        //adding label(playerCount) and textbox(insertPlayerCount) relating to the input of number of players to the same panel 
        panel_players.add(playerCount);        
        panel_players.add(insertPlayerCount);
        
        //addint radiobutton label(radioButton) and the actual radio buttons (yes, no) into the panel
        panel_computerButton.add(radioButton);
        panel_computerButton.add(yes);
        panel_computerButton.add(no);
        
        //putting the previous two panels into one panel with the box layout
        panel_playerCount.setLayout(new BoxLayout(panel_playerCount, BoxLayout.Y_AXIS));
        panel_playerCount.add(panel_players);
        panel_playerCount.add(panel_computerButton);
        
        
        //MIDDLE CONTROLS PANELS
        
        //putting the dice into the same panel
        panel_dice.setLayout( new FlowLayout());
        panel_dice.add(dice1);
        panel_dice.add(dice2);
        
        //putting the buttons into their own panels so that they dont stretch out when put into box/border panel layout style
        panel_Play.add(play);
        panel_Roll.add(roll);
        
        //putting buttons together in one panel
        panel_Controls.setLayout(new BoxLayout(panel_Controls, BoxLayout.Y_AXIS));
        panel_Controls.add(panel_Play);
        panel_Controls.add(panel_Roll);
        
        //putting the dice, buttons and the previous panel(with radiobuttons and player text field, (playerCount)) into one panel
        panel_upperControls.add(panel_playerCount);
        panel_upperControls.add(panel_Controls);
        panel_upperControls.add(panel_dice);
        
        //putting upperControls panel into controlsAndDice so as to add the style of Y_AXIS and add order to them
        panel_controlsAndDice.setLayout( new BoxLayout(panel_controlsAndDice, BoxLayout.Y_AXIS));
        panel_controlsAndDice.add(panel_upperControls);
        
        //Series of Panels regarding QUIT & RULES button as well as RESULT textbox
        
        //label and textbox being put into their respective panels
        panel_result.setLayout(new FlowLayout());
        panel_result.add(result); //result is the result label above the textbox
        
        panel_showResult.setLayout(new FlowLayout());
        panel_showResult.add(showResult); // showResult is the textbox showing the actual result
        
        //rule and quit button being put into their respective panels
        panel_rules.setLayout(new FlowLayout());
        panel_rules.add(rules); 
        
        panel_quit.setLayout(new FlowLayout());
        panel_quit.add(quit); 
        
        //Final panel for the bottom corner regarding quit and rules button and result textbox
        panel_quitRulesResult.setLayout( new BoxLayout(panel_quitRulesResult, BoxLayout.Y_AXIS));
        panel_quitRulesResult.add(panel_result);
        panel_quitRulesResult.add(panel_showResult);
        panel_quitRulesResult.add(panel_rules);
        panel_quitRulesResult.add(panel_quit);
        
        panel_labelScore.setLayout(new FlowLayout());
        panel_labelScore.add(Score);
        
        panel_labelScore2.setLayout(new FlowLayout());
        panel_labelScore2.add(Score2);
        
        panel_labelScore3.setLayout(new FlowLayout());
        panel_labelScore3.add(Score3);
        
        panel_labelScore4.setLayout(new FlowLayout());
        panel_labelScore4.add(Score4);
        
        panel_playersScore.setLayout(new BoxLayout(panel_playersScore, BoxLayout.Y_AXIS));
        panel_playersScore.add(panel_labelScore);
        panel_playersScore.add(panel_labelScore2);
        panel_playersScore.add(panel_labelScore3);
        panel_playersScore.add(panel_labelScore4);
        
        //scoreboeard that has the bordered panel with a label to record score inside of it
        panel_Score.setLayout(new BorderLayout());
        panel_Score.add(panel_playersScore);
        panel_Score.setBorder(BorderFactory.createTitledBorder("Score"));
        
        //putting the score panel and the quitRulesResult panel (panel with buttons quit & rules and result textbox) in the same panel
        panel_right.setLayout( new BoxLayout(panel_right, BoxLayout.Y_AXIS));
        panel_right.add(panel_Score);
        panel_right.add(panel_quitRulesResult);
        
        // putting the 'hidden' dice into their bordered panel titled "Point"
        panel_titleBorder.setLayout( new FlowLayout());
        //add title border and labels here
        panel_titleBorder.add(diceHidden1);
        panel_titleBorder.add(diceHidden2);
        panel_titleBorder.setBorder(BorderFactory.createTitledBorder("Point"));
        
        
        //Puttin the left side of the screen with upperControls and titled border into one panel and adding order to it
        panel_left.setLayout( new BorderLayout());
        panel_left.add(panel_upperControls, BorderLayout.CENTER);
        panel_left.add(panel_titleBorder, BorderLayout.SOUTH);
        
        getContentPane().setLayout( new BorderLayout());
        
        // Put the objects onto the content area of the frame
        getContentPane().add(panel_left, BorderLayout.CENTER);
        getContentPane().add(panel_right, BorderLayout.EAST);
        
        //Setting  up action listeners and commands as well as properties for how the GUI should look on start up
        play.addActionListener(this);
        play.setActionCommand("play");
        
        roll.addActionListener( this );
        roll.setActionCommand("roll");
        roll.setEnabled(false);
        
        quit.addActionListener(this);
        quit.setActionCommand("quit");
        
        rules.addActionListener(this);
        rules.setActionCommand("rules");
        
        //setting the round count to -1 so that when the round starts it starts with 0 and then as the player rolls it increases from there
        roundCount=-1;
    }
    
    // Methods Area
    
    // Add a method to respond to the action event
    public void actionPerformed(ActionEvent e)
    {
        //Action command for play button
        if(e.getActionCommand().equals("play"))
        {
            //reseting all the  variables and/or their properties as they were at the begining of the game
            roll.setEnabled(true);
            play.setEnabled(false);
            dice1.setVisible(false);
            dice2.setVisible(false);
            diceHidden1.setVisible(false);
            diceHidden2.setVisible(false);
            check2=1;
            check=0;
            sum=0;
            random1=0;
            random2=0;
            roundCount=-1;
            point=0;
            showResult.setText("");
        }
        
        //Action command for roll button
        if(e.getActionCommand().equals("roll"))
        {
            //setting the check2 to 1 to check for the first round winning/loosing
            check2=1;
            
            //if code checking if the first round passed so that the diceHidden can be put onto the screen
            if (check==1)
            {
                diceHidden1.setIcon(diceImage1);
                diceHidden2.setIcon(diceImage2);
                diceHidden1.setVisible(true);
                diceHidden2.setVisible(true);
                check2=2;   //reseting the check2 to 2 so that the if statements never check for first roll sums for loss or win
                textScoreLabel=Integer.toString(0);
            }
            //generate and store  randoms and add them into sum
            random1=(int)(Math.random()*(6)+1);
            random2=(int)(Math.random()*(6)+1);
            sum = random1 + random2;
            
            //store randoms as Strings
            diceNumber1= Integer.toString(random1);    
            diceNumber2= Integer.toString(random2);
            
            //store paths to the images
            diceNumber1= ("Dice " + diceNumber1 + ".png");
            diceNumber2= ("Dice " + diceNumber2 + ".png");
            
            //storing icons in the icon variables
            diceImage1= new ImageIcon(diceNumber1);
            diceImage2= new ImageIcon(diceNumber2);
            
            //putting the dice images
            dice1.setIcon(diceImage1);
            dice2.setIcon(diceImage2);
            dice1.setVisible(true);
            dice2.setVisible(true);
            check=1;    //setting check to 1 so that on next roll, the diceHidden labels will be visible
            roundCount++;   //counts the rounds to be deducted from the 10 point award on finding the same sum twice
            
            //Checks for the first round winning or losing sums
            if (check2==1)
            {
                //if the player won
                if(sum==7 || sum==11)
                {
                    showResult.setText("You win!");
                    roll.setEnabled(false);
                    score=+10;
                    textScoreLabel=Integer.toString(score);
                        Score.setText(textScoreLabel);
                        play.setText("Again");
                        play.setEnabled(true);
                
                }
                
                //if the player lost
                else if (sum ==2 || sum==3 || sum ==12)
                {
                    showResult.setText("You lose!");
                    roll.setEnabled(false);
                    score= score-5;
                    textScoreLabel=Integer.toString(score);
                    Score.setText(textScoreLabel);
                    play.setText("Again");  //changing the play button text to Again in case the player wants to play again
                    play.setEnabled(true);  //enabling the play button
                }
                //assings the first round sum to point so that it can be later compared to the new sums for potential win
                else
                {
                    point=sum;  
                }
            }
            
            //compares to see if the sum is the same as the point for potential win
            else if( point==sum)
            {
                showResult.setText("You win!");
                roll.setEnabled(false);
                score=+10-roundCount;
                //if the number of rounds it took the player is greater than 10, to avoid negatives, automatically gives 1 point
                if(roundCount>10)
                {
                    score=1;
                }
                textScoreLabel=Integer.toString(score);
                Score.setText(textScoreLabel);
                play.setText("Again");
                play.setEnabled(true);
            }
            
            //checks if the current sum after the first turn is 7 in which case the player loses
            else if(sum==7)
            {
                showResult.setText("You lose!");
                roll.setEnabled(false);
                score= score-3;
                textScoreLabel=Integer.toString(score);
                Score.setText(textScoreLabel);
                play.setText("Again");
                play.setEnabled(true);
            }

        }
        
        //Action command for button rules
        else if(e.getActionCommand().equals("rules"))
        {
            //Opens a pop up window displaying rules
            JOptionPane.showMessageDialog(this, "Press the roll button in order to roll the dice.“\r\n” If you get a 7 or 11 on the first roll you win and get plus 10 points. “\r\n”If you roll 2,3 or 12 on your first turn, you lose and get -5 points.“\r\n” When you get a sum that does not lose or win you the game in the first round, keep rolling till you get that same sum!“\r\n” If you roll that same sum again, you win! If you roll a sum of 7 before you roll the original sum again, you lose and get -3 points.“\r\n” When you win by rolling the same sum again you get 10 - (number of rounds it took you to score the same sum) points. “\r\n”If the number of rounds it took you to score the same sum again is larger than 10, “\r\n”you are awarded 1 point even if your roll the same sum.“\r\n” Good Luck!!!",
                        "Rules",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        
        //Action command for button quit
        else if(e.getActionCommand().equals("quit"))
        {
            //Quits the program
            System.exit(0);
        }
    }
    
    // main method
    public static void main(String[] args)
    {
        // Create a JFrame Object and show it on the screen
        PROJECTMORE frame = new PROJECTMORE();
        
        // Create a WindowQuitter Object
        WindowQuitter wquit = new WindowQuitter();
        
        // Attach the WindowQuitter to the JFrame Object
        frame.addWindowListener(wquit);        
        

        // Set the proper size for the frame
        frame.setSize(600,350);
        
        // Prevent the user from resizing the frame
        frame.setResizable(false);
        
        // Make myframe visible
        frame.setVisible(true);
    }
}


