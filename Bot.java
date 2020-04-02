import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());

        if (update.getMessage().getText().equals("Привет")){
            sendMessage.setText("Покеда");
            try{
                execute(sendMessage);
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@MyFirstSocialBot";
    }

    @Override
    public String getBotToken() {
        return " (TOKEN) ";
    }
}
