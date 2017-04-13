/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assig;


// : c14:SimpleMenus.java
// <applet code=SimpleMenus width=200 height=75></applet>
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Menu extends JApplet {
  private JTextField t = new JTextField(15);

  private ActionListener al = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      t.setText(((JMenuItem) e.getSource()).getText());
    }
  };

  private JMenu menu = new JMenu("Winken");

  private JMenuItem[] items = { new JMenuItem("Fee"), new JMenuItem("Fi"),
      new JMenuItem("Fo") };

  public void init() {
    for (int i = 0; i < items.length; i++) {
      items[i].addActionListener(al);
      menu.add(items[i]);
    }
    JMenuBar mb = new JMenuBar(); 
      mb.add(menu);
    setJMenuBar(mb);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    
  //  cp.add(t);
  }

//  public static void main(String[] args) {
  //  run(new Menu(), 200, 125);
 // }
/*
  public static void run(JApplet applet, int width, int height) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel();
    p.add(applet);
    
    frame.getContentPane().add(p);
 //   frame.getContentPane().setLayout(new GridLayout(1,2));
    frame.setSize(width, height);
    applet.init();
    applet.start();
    frame.setVisible(true);
  }
*/
} ///:~

