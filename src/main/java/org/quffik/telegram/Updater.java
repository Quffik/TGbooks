package org.quffik.telegram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class Updater implements LongPollingSingleThreadUpdateConsumer {

  private telegramClient bot;

  public Updater(String token) {
    this.bot = new telegramClient(token);

  }

  // Executor
  ExecutorService executor = Executors.newFixedThreadPool(5);

  @Override
  public void consume(Update update) {
    executor.execute(() -> {
      UpdaterHandler(update);
    });
  }

  private void UpdaterHandler(Update update) {

    // Message
    if (update.hasMessage()) {
      Message msg = update.getMessage();
      User user = new User(msg.getChatId(), msg.getFrom().getId());

      // Text
      if (msg.hasText()) {
        String text = msg.getText();

        // Chat
        if (user.chatId > 0) {

          if (text.equals("/ping"))
            bot.Ping(user);

        }

        // Thread
        else {

        }

      }

    }

    // CallBackQuary
    else if (update.hasCallbackQuery()) {
      CallbackQuery clq = update.getCallbackQuery();
      User user = new User(clq.getMessage().getChatId(), clq.getFrom().getId());

    }

  }

}
