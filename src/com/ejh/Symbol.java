package com.ejh;

import java.awt.*;
import java.util.ArrayList;

public class Symbol {
  private float x, y;
  private String character;
  private Color color;
  private ArrayList<Symbol> trail;
  private Color[] colorCycle;

  private static final float movement = 1;

  public Symbol(float x, float y, String character, Color color) {
    this.x = x;
    this.y = y;
    this.character = character;
    this.color = color;
    this.trail = new ArrayList<>();
    this.colorCycle = new Color[20];

    for (float i = 0; i <= 1; i += 0.05f) {
      if (i == 0) {
        colorCycle[0] = new Color(0.5f, 1, 0.5f);
        continue;
      }
      colorCycle[(int) (i / 0.05f)] = new Color(0, 1 - i, 0);
    }
  }

  public void cycle() {
    y += movement;
  }

  public void renderTrail(Graphics2D g2, int fontWidth, int fontHeight) {
    for (int i = 0; i < colorCycle.length; i++) {
      trail.add(new Symbol(x, y - i * movement, SymbolLib.generateRandomChar(), colorCycle[i]));
    }

    trail.forEach(symbol -> {
      g2.setPaint(symbol.getColor());
      g2.drawString(symbol.getCharacter(), symbol.getX() * fontWidth, symbol.getY() * fontHeight);
    });

    trail.clear();
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public Color getColor() {
    return color;
  }
}
