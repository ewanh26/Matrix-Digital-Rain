package com.ejh;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Surface extends JPanel implements ActionListener {
  private final int DELAY = 100;
  private Timer timer;
  private ArrayList<Symbol> symbols = new ArrayList<>();

  public Surface() {
    initTimer();
    setBackground(Color.BLACK);
//    setFont(new Font(""));
  }

  private void initTimer() {
    timer = new Timer(DELAY, this);
    timer.start();
  }

  private void updateGraphics(@NotNull Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    int fontSize = 16;
    Font font = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
    g2.setFont(font);
    FontMetrics fontMetrics = g.getFontMetrics(font);
    int fontHeight = fontMetrics.getHeight();
    int fontWidth = fontMetrics.stringWidth("A");

    g2.setPaint(Color.GREEN);

    int w = getWidth();
    int h = getHeight();

    Random r = new Random();

    int rand = r.nextInt();
    if (rand % 2 == 0) {
      int x = Math.abs(rand) % w / fontWidth;
      Symbol symbol = new Symbol(x, 0, SymbolLib.generateRandomChar(), Color.WHITE);
      symbols.add(symbol);
    }

    for (Symbol symbol : symbols) {
      symbol.setCharacter(SymbolLib.generateRandomChar());
      symbol.renderTrail(g2, fontWidth, fontHeight);
      symbol.cycle();
      g2.setPaint(symbol.getColor());
      g2.drawString(symbol.getCharacter(), symbol.getX() * fontWidth, symbol.getY() * fontHeight);
    }

    if (symbols.size() > 50) {
      symbols.remove(0);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    updateGraphics(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  public Timer getTimer() {
    return timer;
  }
}
