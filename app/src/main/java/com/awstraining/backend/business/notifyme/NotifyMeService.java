package com.awstraining.backend.business.notifyme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyMeService {
    private MessageSender sender;

    private Translator translator;
    private Sentiment sentimentDetector;
    
    // TODO: lab1
    //  1. Inject MessageSender.
    // TODO lab2
    //  1. Inject Translator
    // TODO lab3
    //  1. Inject sentiment detector
    @Autowired
    public NotifyMeService(MessageSender sender, Translator translator, Sentiment sentimentAssessor) {
        this.sender = sender;
        this.translator = translator;
        this.sentimentDetector = sentimentAssessor;
    }
    
    public String notifyMe(NotifyMeDO notifyMe) {
      
        // TODO: lab1
        //  1. Send text using sender.
        //  2. Return sent message.
        // TODO: lab2
        //  1. Translate text from using translator.
        //  2. Change sending of text to "translated text" and return it.
        // TODO: lab3
        //  1. Detect sentiment of translated message.
        //  2. Change sending of text to "setiment: translated text" and return it.
        final String translatedMessage = translator.translate(notifyMe);
        final String sentiment = sentimentDetector.detectSentiment(notifyMe.targetLc(), translatedMessage);
        final String sentMessage = sentiment + ": " + translatedMessage;
        sender.send(sentMessage);
        return sentMessage;
    }
    
}