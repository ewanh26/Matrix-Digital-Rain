package com.ejh;

import java.util.Random;

public class SymbolLib {
  private static final String symbols_s = "ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩｦｱｲｳｴｵｶｷｸｹｺｻｼｽﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝЩЕРТЫУИОПАСДФГХЙКЛЗЦВБН@#~!£$%&?§";

  public static int getLength() {
    return symbols_s.length();
  }

  public static String getSymbols() {
    return symbols_s;
  }

  public static String generateRandomChar() {
    Random r = new Random();
    int randIdx = Math.abs(r.nextInt()) % (SymbolLib.getLength() - 1);
    return SymbolLib.getSymbols().substring(randIdx, randIdx + 1);
  }
}
