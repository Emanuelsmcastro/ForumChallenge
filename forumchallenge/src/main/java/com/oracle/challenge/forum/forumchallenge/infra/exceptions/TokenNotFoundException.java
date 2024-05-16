package com.oracle.challenge.forum.forumchallenge.infra.exceptions;

public class TokenNotFoundException extends RuntimeException{
    
    public TokenNotFoundException(){
        super("Token Not Found");
    }
}
