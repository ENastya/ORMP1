package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.Math;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText editText;
    Integer firstValue;
    Integer secondValue;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText1);

    }

    public void buttonClick(View view){
        Button button = (Button) view;
        switch (button.getText().toString()) {
            case "C":
                firstValue = null;
                secondValue = null;
                operation = null;
                editText.setText("");
                break;
            case "<-":
                if (secondValue != null){
                secondValue = null;
                editText.setText( String.valueOf(firstValue) + String.valueOf(operation));}
                else if (operation != null) {
                    operation = null;
                    editText.setText( String.valueOf(firstValue));}
                else {
                    firstValue = null;
                    editText.setText("");
                    ;}

                break;
            case "+":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="+";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "sqr":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                editText.setText(String.valueOf((firstValue*firstValue)));
                break;
            case "sqrt":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                editText.setText(String.valueOf((Math.sqrt(firstValue))));
                break;
            case "-":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="-";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "*":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="*";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "/":
                firstValue =
                        Integer.valueOf(editText.getText().toString());
                operation="/";
                editText.setText(editText.getText().toString()+button.getText());
                break;
            case "=":
                switch (operation) {
                    case "+":
                        editText.setText(String.valueOf((firstValue+secondValue)));
                        break;
                    case "-":
                        editText.setText(String.valueOf((firstValue-secondValue)));
                        break;
                    case "*":
                        editText.setText(String.valueOf((firstValue*secondValue)));
                        break;
                    case "/":
                        editText.setText(String.valueOf((firstValue/secondValue)));
                        break;
                    default:
                        break;
                }
                firstValue = null;
                secondValue = null;
                operation = null;
                break;
            default:
                if(operation != null){
                    if(secondValue!=null)
                        secondValue =
                                Integer.valueOf((String.valueOf(secondValue)+button.getText().toString()));
                    else
                        secondValue =
                                Integer.valueOf(button.getText().toString());
                }
                editText.setText(editText.getText().toString()+button.getText());
                break;
        }
    }
}

