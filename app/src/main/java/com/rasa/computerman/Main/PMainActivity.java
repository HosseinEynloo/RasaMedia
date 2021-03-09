package com.rasa.computerman.Main;


public class PMainActivity implements iPMainActivity {

    private com.rasa.computerman.Main.iVMainActivity iVMainActivity;
    M_MainActivity m_mainActivity;

    public PMainActivity(iVMainActivity iVMainActivity) {
        this.iVMainActivity = iVMainActivity;
        m_mainActivity=new M_MainActivity(this);

    }



}
