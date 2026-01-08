package org.quffik.telegram;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class telegramClient {

  private final TelegramClient bot;

  public telegramClient(String token) {
    this.bot = new OkHttpTelegramClient(token);
  }

  public void Ping(User user) {
    SendMessage request = SendMessage
        .builder()
        .chatId(user.chatId)
        .text("<i>Pong!</i>")
        .parseMode(ParseMode.HTML)
        .build();
    execute(request);
  }

  public void execute(SendMessage request) {
    try {
      bot.execute(request);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
