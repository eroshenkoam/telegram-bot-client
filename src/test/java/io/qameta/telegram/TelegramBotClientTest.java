package io.qameta.telegram;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TelegramBotClientTest {

    private static final String TOKEN = "<place token here>";

    private TelegramBotClient bot = TelegramClientBuilder.createBotClient(TOKEN);

    @Test
    @Ignore
    public void testMe() throws IOException {
        User user = bot.getMe().execute().body().getResult();
        System.out.println(user.getUsername());
    }

    @Test
    @Ignore
    public void testUpdates() throws IOException {
        List<Update> updates = bot.getUpdates(0, 100, 0).execute().body().getResult();
        for (Update update : updates) {
            System.out.println(update.getMessage().getText());
        }
    }

    @Test
    @Ignore
    public void testSendMessage() throws IOException {
        //chat id here
        int chatId = 1;

        Message messageResponse = bot.sendMessage(chatId, "Hello!").execute().body().getResult();
        System.out.println(messageResponse.getText());
    }

}
