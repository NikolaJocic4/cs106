import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Window Quitter.
 * 
 * Quits window
 *
 * @Nikola Jocic Student ID: 20200041 email: 20200041@student.act.edu
 * @version 1.01 Date: 02/04/2021
 */
public class WindowQuitter extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        // Stop the program!
        System.exit(0);
    }
}

