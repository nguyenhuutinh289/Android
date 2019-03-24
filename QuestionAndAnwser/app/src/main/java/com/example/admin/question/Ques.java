package com.example.admin.question;

/**
 * Created by Admin on 24/03/2019.
 */
public class Ques {
    private  int Id;
    private boolean answer;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public Ques(int id, boolean answer) {

        Id = id;
        this.answer = answer;
    }
}
