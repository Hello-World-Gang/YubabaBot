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
        return nickname.substring(0, 1);
    }
    
    public void onMessageReceived(MessageReceivedEvent event) {
    	User user = event.getAuthor();
    	TextChannel tc = event.getTextChannel();
    	Message msg = event.getMessage();
    	if (user.isBot()) return;
        if( "summonYubaba".equals(msg.getContentRaw())){
            tc.sendMessage("konnnichiwa, " + user.getAsMention()).queue();
            String newName = user.getName();
            int subIndex=0;
            for(int i=0;i<newName.length();i++){
                if(newName.charAt(i)=='a'||newName.charAt(i)=='i'||newName.charAt(i)=='u'
                        ||newName.charAt(i)=='e'||newName.charAt(i)=='o'){
                    subIndex=i+1;
                    System.out.println(subIndex);
                    break;
                }
            }
            event.getMember().modifyNickname(user.getName().substring(0,1)).queue();
        }
    }
}
