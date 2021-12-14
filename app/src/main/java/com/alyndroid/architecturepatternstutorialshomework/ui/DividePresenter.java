package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class DividePresenter {
    DivideView view;
    NumberModel obj;
    DataBase dataBase;

    public DividePresenter(DivideView view) {
        this.view = view;
    }
    public int divideButton(){
        dataBase = new DataBase();
        obj = dataBase.getNumbers();
        return obj.getFirstNum() / obj.getSecondNum();
    }

    public void getResult (){
        view.OnGetResult(divideButton());
    }
}
