package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorActivity extends AppCompatActivity {


    private static final String TAG = "CalculatorActivity";
    TextView textCalculatetv;
    TextView textResulttv;
    String woRkings="";
    String fOrmula="";
    String tempFormula="";
    boolean leftBracket = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initTextViews();
    }

    private void initTextViews() {
        textCalculatetv=(TextView) findViewById(R.id.textCalculate);
        textResulttv=(TextView) findViewById(R.id.textResult);

    }

    public void setWoRkings(String s){
        woRkings+=s;
        textCalculatetv.setText(woRkings);
    }

    public void clearOnClick(View view) {
        textCalculatetv.setText("");
        woRkings="";
        textResulttv.setText("");
        leftBracket = true;
    }


    public void bracketOnClick(View view) {
        if (leftBracket)
        {
            setWoRkings("(");
            leftBracket = false;
        } else {
            setWoRkings(")");
            leftBracket = true;
        }
    }

    public void divideOnClick(View view) {
        setWoRkings("/");
    }

    public void modOnClick(View view) {
        setWoRkings("%");
    }

    public void seVen(View view) {
        setWoRkings("7");
    }

    public void eiGht(View view) {
        setWoRkings("8");
    }

    public void niNE(View view) {
        setWoRkings("9");
    }

    public void proDuct(View view) {
        setWoRkings("*");
    }

    public void foUr(View view) {
        setWoRkings("4");
    }

    public void fiVe(View view) {
        setWoRkings("5");
    }

    public void sIx(View view) {
        setWoRkings("6");
    }

    public void miNus(View view) {
        setWoRkings("–");
    }

    public void oNe(View view) {
        setWoRkings("1");
    }

    public void tWo(View view) {
        setWoRkings("2");
    }

    public void thRee(View view) {
        setWoRkings("3");
    }

    public void aDd(View view) {
        setWoRkings("+");
    }

    public void doubleZero(View view) {
        setWoRkings("00");
    }

    public void zeRo(View view) {
        setWoRkings("0");
    }

    public void dOt(View view) {
        setWoRkings(".");
    }

    public void eqUal(View view) {
        Double result = null;
        if (woRkings.contains("%")) {
            double val1;
            double val2;

            String[] data = woRkings.split("%");
            val1 = Double.parseDouble(data[0]);
            if (data.length > 1) {
                val2 = Double.parseDouble(data[1]);
                Log.e(TAG, "eqUal: " + val1 + val2);
                result = val1 % val2;
            } else {
                result = val1 / 100;
            }


        } else {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
//            checkForPowerOf();
            try {
                result = (double) engine.eval(woRkings);
                Toast.makeText(this, "Result = " + result, Toast.LENGTH_SHORT).show();
            } catch (ScriptException e) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }
        }
        if (result != null)
            textResulttv.setText(String.valueOf(result.doubleValue()));
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList();
        for (int i = 0; i < woRkings.length(); i++)
        {
            if(woRkings.charAt(i) == '%') {
                indexOfPowers.add(i);
            }
        }
        fOrmula = woRkings;
        tempFormula = woRkings;
        for (Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        fOrmula = tempFormula;
        Toast.makeText(this, "Formula = " + fOrmula, Toast.LENGTH_SHORT).show();
    }

    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";

        Log.e(TAG, "changeFormula: right" + numberLeft);
        for (int i = index + 1; i < woRkings.length(); i++)
        {
            Log.e(TAG, "changeFormula: right" + numberLeft);
            if (isNumeric(woRkings.charAt(i))) {
                numberRight = numberRight + woRkings.charAt(i);
                Log.e(TAG, "changeFormula: right" + numberLeft);
            } else {
                break;
            }
        }
        Log.e(TAG, "changeFormula: " + numberLeft);
        for (int i = 0; i<= index - 1; i++)
        {
            Log.e(TAG, "changeFormula: " + numberLeft);
            if (isNumeric(woRkings.charAt(i))) {
                Log.e(TAG, "changeFormula: " + numberLeft);
                numberLeft = numberLeft + woRkings.charAt(i);
            }
            else {
                break;
            }
        }
        Log.e(TAG, "changeFormula: " + numberLeft);

        String changed = "";
        if (numberRight.isEmpty()) {
            changed = numberLeft+"/100";
        } else {
            changed = numberLeft+"%"+numberRight;
        }
        tempFormula = changed;

    }

    private boolean isNumeric(char c)
    {
        if ((c <= '9' && c >= '0') || c == '.')
            return true;
        return false;
    }

}