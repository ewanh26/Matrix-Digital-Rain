package com.ejh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
  public Window() {
    initUI();
  }

  private void initUI() {
    int SF = 80;
    final Surface surface = new Surface();
    add(surface);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        Timer timer = surface.getTimer();
        timer.stop();
      }
    });

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
      }
    });

    setTitle("2D");
    setSize(new Dimension(16 * SF, 9 * SF));
    setLocationRelativeTo(null);
    setUndecorated(true);
    setExtendedState(MAXIMIZED_BOTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      Window window = new Window();
      window.setVisible(true);
    });
  }
}
