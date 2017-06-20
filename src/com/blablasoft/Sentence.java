package com.blablasoft;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Sentence {
    protected LinkedList<String> value = null;

    public Sentence(){
        this.value = new LinkedList<String>();
    }

    public Sentence(String value){
        this.setValue(value);
    }

    public void processChanges(int index, char symbol){
        for (int i = 0; i < this.Lengtht(); i++){
            Word word = new Word(this.getItem(i));
            if (word.Lengtht() >= index) {
                word.setItem(index - 1, String.valueOf(symbol));
                this.setItem(i, word.getValue());
            }
        }
    }

    public void setValue(String value){
        StringTokenizer st = new StringTokenizer(value, " ");
        this.value = new LinkedList<String>();
        while(st.hasMoreTokens()) {
            this.value.add(st.nextToken());
            //System.out.println(st.nextToken());
        }
    }

    public String getValue(){
        String value = "";
        for (int i=0; i < this.value.size(); i++) {
            if (i != this.value.size() - 1) value += this.value.get(i) + " ";
            else value += this.value.get(i);
        }
        return value;
    }

    public int Lengtht(){
        return this.value.size();
    }

    public String getItem(int value){
        String item = this.value.get(value);
        return item;
    }

    public void setItem(int value, String item){
        this.value.set(value, item);
    }

}