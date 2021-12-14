package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DivideView {

    DataBase dataBase;
    NumberModel obj;
    // For MVP
    DividePresenter presenter;
    // For MVVM
    MultiplyViewModel viewModel;
    // Data Binding
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //For MVVM
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MultiplyViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        //For MVP
        presenter  = new DividePresenter(this);
        // Database Instance
        dataBase = new DataBase();
        //Buttons Listeners
        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);



    }
    // For MVC
    public int addButton (){
         obj = dataBase.getNumbers();
        return obj.getFirstNum() + obj.getSecondNum();
    }
    public void addResult (){
       int result =  addButton();
       binding.plusResultTextView.setText(String.valueOf(result));
    }
    // Listeners Interface
    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.plus_button){
            addResult();
       }else if (view.getId() == R.id.div_button){
            presenter.getResult();
       }else if (view.getId() == R.id.mul_button){
           viewModel.getResult();
       }
    }
    //MVP Interface
    @Override
    public void OnGetResult(int i) {
        binding.divResultTextView.setText(String.valueOf(i));
    }
}
