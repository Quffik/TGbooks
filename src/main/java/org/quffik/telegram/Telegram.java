package org.quffik.telegram;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Telegram {

  @SuppressWarnings("resource")
  public Telegram(String token) {
    System.setProperty("org.slf4j.simpleLogger.log.org.telegram.telegrambots.longpolling.BotSession", "warn");
    try {
      new TelegramBotsLongPollingApplication().registerBot(token, new Updater(token));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
