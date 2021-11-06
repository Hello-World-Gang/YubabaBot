package DiscordBot.DiscordBot;

import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter 
{
	ArrayList<String> names = new ArrayList<String>(Arrays.asList("Sen", "Chihiro", "Yubaba"));
	
    public static void main( String[] args ) throws LoginException, InterruptedException
    {
    	JDA jda = JDABuilder.createDefault("OTA2NTcxMzE0NjIwNDI4MzQ5.YYakVA.Rl59i7XERTTJ__ATxX5RqURgkLE")
    			.addEventListeners(new Bot())
    			.build();
    	jda.awaitReady();
    }
    public void onReady(ReadyEvent event)
    {
    	System.out.println("Bot Ready!");
    	System.out.println(event.getJDA().getToken());
    }
    
    public String getNickName(User user) {
    	String nickname = user.getAsMention().toString();
    	
    	
		return nickname.substring(0, 2);
    }
    
    public void onMessageReceived(MessageReceivedEvent event) {
    	User user = event.getAuthor();
    	TextChannel tc = event.getTextChannel();
    	Message msg = event.getMessage();
    	if (user.isBot()) return;
    	if (msg.getContentRaw().charAt(0) == '!') {
    		String[] args = msg.getContentRaw().substring(1).split(" ");
    		if (args.length <= 0) return;
    		if (args[0].equalsIgnoreCase("nickname")) {
    			tc.sendMessage("Hello, " + user.getAsMention()).queue();
    			event.getMember().modifyNickname(getNickName(user)).queue();
    			names.remove(0);
    		} else if (args[0].equalsIgnoreCase("hello")) {
    			if (args.length < 2) return;
    			if (args[1].equalsIgnoreCase("bot")) {
    				tc.sendMessage("Hello, Sir!").queue();
    			} else if (args[1].equalsIgnoreCase("human")) {
    				tc.sendMessage("I'M NOT HUMAN").queue();
    			}
    		}
    	}
    }
}
