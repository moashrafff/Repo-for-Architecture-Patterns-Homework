package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MultiplyViewModel extends ViewModel {


     DataBase dataBase = new DataBase();
     NumberModel obj = dataBase.getNumbers();
    public MutableLiveData <Integer> resultMutableLiveData = new MutableLiveData<>() ;

    private int multiplyButton(){
        return obj.getFirstNum() * obj.getSecondNum();
    }

    public void getResult() {
        int result = multiplyButton();
        resultMutableLiveData.setValue(result);
    }
}
