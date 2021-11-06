package DiscordBot.DiscordBot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter 
{
    public static void main( String[] args ) throws LoginException, InterruptedException
    {
    	JDA jda = JDABuilder.createDefault("OTA2NTcxMzE0NjIwNDI4MzQ5.YYakVA.RLppb6Wh5XhFw6_JJQQj-acpXPA")
    			.addEventListeners(new Bot())
    			.build();
    	jda.awaitReady();
    }
    public void onReady(ReadyEvent event)
    {
    	System.out.println("Bot Ready!");
    	System.out.println(event.getJDA().getToken());
    }
    
}
