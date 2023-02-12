package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> numberResult;
    private MutableLiveData<String> historyResult;

    public LiveData<String> getNumberResult() {
        if (numberResult == null) {
            numberResult = new MutableLiveData<String>();
            numberResult.setValue("");
        }
        return numberResult;
    }

    public LiveData<String> getHistoryResult() {
        if (historyResult == null) {
            historyResult = new MutableLiveData<String>();
            historyResult.setValue("");
        }
        return historyResult;
    }

    public void onButtonAction(String button) {
        String currentResult = numberResult.getValue();
        String expression ="";
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        if (Arrays.asList(number).contains(button)) {
            if (currentResult.equals("0")) {
                currentResult = button;
            } else {
                currentResult += button;
            }
        }
        else {
            try {
                switch (button) {
                    case "=":
                        expression = evalute(currentResult);
                        currentResult = expression.split("=")[1];
                        historyResult.setValue(historyResult.getValue() + " " + expression);
                        break;
                    case "⌫":
                        currentResult = currentResult.substring(0, currentResult.length() - 1);
                        if (currentResult.equals("")) {
                            currentResult = "0";
                        }
                        break;
                    case "C":
                        currentResult = "0";
                        historyResult.setValue("");
                        break;
                    case ".":
                        currentResult += ".";
                        break;
                    case "+":
                        currentResult += "+";
                        break;
                    case "-":
                        currentResult += "-";
                        break;
                    case "x":
                        currentResult += "x";
                        break;
                    case "÷":
                        currentResult += "÷";
                        break;
                    default:
                        break;
                }
            }
            catch (Exception ee) {
                currentResult = "MATH ERROR";
            }
        }
        numberResult.setValue(currentResult);
    }

    public static String evalute(String expression) {
        char[] arr = expression.toCharArray();
        StringBuilder operand1 = new StringBuilder();
        StringBuilder operand2 = new StringBuilder();
        StringBuilder operator = new StringBuilder();

        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
                if (operator.length() == 0) {
                    operand1.append(arr[i]);
                } else {
                    operand2.append(arr[i]);
                }
            }

            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '÷' || arr[i] == 'x') {
                operator.append(arr[i]);
            }
        }
        if (operator.toString().equals("+"))
            result  = Double.parseDouble(operand1.toString()) + Double.parseDouble(operand2.toString());
        else if (operator.toString().equals("-"))
            result = Double.parseDouble(operand1.toString()) - Double.parseDouble(operand2.toString());
        else if (operator.toString().equals("÷")) {
            if(operand2.toString().equals('0')) {
                throw new ArithmeticException("Divide by zero!!");
            } else {
                result = Double.parseDouble(operand1.toString()) / Double.parseDouble(operand2.toString());
            }
        }
        else
            result = Double.parseDouble(operand1.toString()) * Double.parseDouble(operand2.toString());


        return operand1 + operator.toString() + operand2 + " = " + fmt(result);
    }

    public static String fmt(double d) {
        if (d == (int) d)
            return String.format("%d", (int) d);
        else
            return String.format("%s", d);
    }
}
