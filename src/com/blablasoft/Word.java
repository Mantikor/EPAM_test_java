package com.blablasoft;

import java.util.LinkedList;

public class Word extends Sentence {
    public Word(String value)
    {
        this.setValue(value);
    }

    public void setValue(String value){
        this.value = new LinkedList<String>();
        for (int i = 0; i < value.length(); i++)
            this.value.add(String.valueOf(value.charAt(i)));
    }

    public String getValue(){
        String value = "";
        for (int i=0; i < this.value.size(); i++)
            value += this.value.get(i);
        return value;
    }


}
