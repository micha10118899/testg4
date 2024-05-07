package de.programmierenlernenhq.panzerhq;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author ProgrammierenLernenHQ
 */
public class GameWindow extends JFrame{ //Erweitert ein Grafisches Fenster
    
    private final GamePanel panzerGamePanel; //GamePanel Objekt wird verwendet
    
    public GameWindow() {   
        
        this.panzerGamePanel = new GamePanel();
                
        registerWindowListener();
        createMenu();
          
        add(panzerGamePanel);
        pack();
        
        setTitle("PanzerHQ");
        setLocation(10, 10);
        setResizable(false);
        
        setVisible(true);
    }
    
    private void registerWindowListener() {        
        addWindowListener(new WindowAdapter() {            
            @Override
            public void windowClosing(WindowEvent e) { 
                System.exit(0); 
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
                // hier wird das Spiel pausiert
                panzerGamePanel.pauseGame();
            }
            @Override
            public void windowActivated(WindowEvent e) {
                // hier wird das Spiel wieder fortgesetzt
                panzerGamePanel.continueGame();
            }            
        });        
    }
    
    private void createMenu() {
        
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefMenu = new JMenu("Preferences");
        
        menuBar.add(fileMenu);        
        menuBar.add(gameMenu);        
        menuBar.add(prefMenu);
        
        addFileMenuItems(fileMenu);  
        addGameMenuItems(gameMenu);
        addPrefMenuItems(prefMenu);
    }
    
    private void addFileMenuItems(JMenu fileMenu) {
        
        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 
    }
    
    private void addGameMenuItems(JMenu gameMenu) {
        JMenuItem pauseItem = new JMenuItem("Pause");
        gameMenu.add(pauseItem);        
        pauseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.pauseGame();
            }
        });
        
        JMenuItem continuetItem = new JMenuItem("Continue");
        gameMenu.add(continuetItem);       
        continuetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                panzerGamePanel.continueGame();
            }
        });
        
        gameMenu.addSeparator();
        JMenuItem restartItem = new JMenuItem("Restart");
        gameMenu.add(restartItem);       
        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                panzerGamePanel.restartGame();
            }
        });
    }
    
    private void addPrefMenuItems(JMenu prefMenu) {
        
        JMenu submenu = new JMenu("Choose Background");
        prefMenu.add(submenu);

        JMenuItem menuItem = new JMenuItem("Mud Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(0);
                repaint();
            }
        });

        menuItem = new JMenuItem("Snow Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(1);
                repaint();
            }
        });
        
        menuItem = new JMenuItem("Desert Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(2);
                repaint();
            }
        });
    }
    
}