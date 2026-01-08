package org.quffik.telegram;

import org.telegram.telegrambots.meta.api.objects.message.Message;

public class User {

  public long chatId;
  public long userId;
  public Message msg;

  public User(long chatId, long userId) {
    this.chatId = chatId;
    this.userId = userId;
  }

  public User(long chatId, long userId, Message msg) {
    this.chatId = chatId;
    this.userId = userId;
    this.msg = msg;
  }
}
