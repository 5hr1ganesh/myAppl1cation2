package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorActivity extends AppCompatActivity {


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

    public void powerOnClick(View view) {
        setWoRkings("^");
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
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();
        try {
            result = (double)engine.eval(fOrmula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result != null)
            textResulttv.setText(String.valueOf(result.doubleValue()));
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList();
        for (int i = 0; i < woRkings.length(); i++)
        {
            if(woRkings.charAt(i) == '^')
                indexOfPowers.add(i);
        }
        fOrmula = woRkings;
        tempFormula = woRkings;
        for (Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        fOrmula = tempFormula;
    }

    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i< woRkings.length(); i++)
        {
            if (isNumeric(woRkings.charAt(i)))
                numberRight = numberRight + woRkings.charAt(i);
            else
                break;;
        }
        for (int i = index - 1; i>= 0; i--)
        {
            if (isNumeric(woRkings.charAt(i)))
                numberLeft = numberLeft + woRkings.charAt(i);
            else
                break;;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original, changed);

    }

    private boolean isNumeric(char c)
    {
        if ((c <= '9' && c >= '0') || c == '.')
            return true;
        return false;
    }

}