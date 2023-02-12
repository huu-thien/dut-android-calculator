package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        model = new ViewModelProvider(this).get(MainViewModel.class);

        model.getHistoryResult().observe(this, result -> {
            binding.expressionHistory.setText(result);
        });

        model.getNumberResult().observe(this, value -> {
            binding.expression.setText(value);
        });

        binding.btn0.setOnClickListener(e -> {
            model.onButtonAction("0");
        });
        binding.btnClear.setOnClickListener(e -> {

            model.onButtonAction("C");

        });
        binding.btn1.setOnClickListener(e -> {

            model.onButtonAction("1");

        });
        binding.btn2.setOnClickListener(e -> {

            model.onButtonAction("2");

        });
        binding.btn3.setOnClickListener(e -> {

            model.onButtonAction("3");

        });
        binding.btn4.setOnClickListener(e -> {

            model.onButtonAction("4");

        });
        binding.btn5.setOnClickListener(e -> {

            model.onButtonAction("5");

        });
        binding.btn6.setOnClickListener(e -> {

            model.onButtonAction("6");

        });
        binding.btn7.setOnClickListener(e -> {

            model.onButtonAction("7");

        });
        binding.btn8.setOnClickListener(e -> {

            model.onButtonAction("8");

        });
        binding.btn9.setOnClickListener(e -> {

            model.onButtonAction("9");

        });
        binding.btnPlus.setOnClickListener(e -> {

            model.onButtonAction("+");

        });
        binding.btnMinus.setOnClickListener(e -> {

            model.onButtonAction("-");

        });
//        binding.buttonNegative.setOnClickListener(e -> {
//
//            model.onButtonAction("+/-");
//
//        });
        binding.btnEqual.setOnClickListener(e -> {

            model.onButtonAction("=");

        });
        binding.btnDot.setOnClickListener(e -> {

            model.onButtonAction(".");

        });
        binding.btnMultiply.setOnClickListener(e -> {
            model.onButtonAction("x");
        });
        binding.btnDivide.setOnClickListener(e -> {

            model.onButtonAction("÷");

        });
        binding.btnDelete.setOnClickListener(e -> {

            model.onButtonAction("⌫");

        });

    }
}