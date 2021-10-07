package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import org.mariuszgromada.math.mxparser.Expression;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button add, mul, div, mod, sub, equals, dot, back, ac, seven, eight, nine, four, five, six, one, two, three, zero, dark,bo,bc;


    EditText initialtext;
    TextView finaltext;
    int clickcount=0;
    int darkcount=0;

    ArrayList<String> checkinarray = new ArrayList<String>(Arrays.asList(".", "+", "-", "*", "/", "%"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialtext = findViewById(R.id.resultview);
        finaltext = findViewById(R.id.historyview);
        initialtext.setShowSoftInputOnFocus(false);
        initialtext.setText("");
       // initialtext.setCursorVisible(false);

        add = findViewById(R.id.add);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        mod = findViewById(R.id.mod);
        sub = findViewById(R.id.sub);
        equals = findViewById(R.id.equals);
        dot = findViewById(R.id.dot);
        back = findViewById(R.id.back);
        ac = findViewById(R.id.ac);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        six = findViewById(R.id.six);
        nine = findViewById(R.id.nine);
        five = findViewById(R.id.five);
        four = findViewById(R.id.four);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        one = findViewById(R.id.one);
        zero = findViewById(R.id.zero);
        dark = findViewById(R.id.dark);
        bo=findViewById(R.id.bo);
        bc=findViewById(R.id.bc);



    }

    private void updatestring(String incomingstring)
    {
        String oldstring=initialtext.getText().toString();
        int cursorpos=initialtext.getSelectionStart();
        String leftstr=oldstring.substring(0,cursorpos);
        String rightstr=oldstring.substring(cursorpos);
        if(initialtext.getText().length()<20) {
            initialtext.setText(String.format("%s%s%s", leftstr, incomingstring, rightstr));
            initialtext.setSelection(cursorpos + 1);
        }
    }

    public void checklength()
    {
      int length=initialtext.getText().length();
      if(length>12)
      {
          initialtext.setTextSize(33);
      }
    }

    public boolean checktowrite(String input)
    {
        boolean tryit=false;
        String str = initialtext.getText().toString();
         String lastchar = str.substring(str.length()-1);
         if(checkinarray.contains(lastchar) && checkinarray.contains(input))
         {
             tryit=true;
         }

         if(str.isEmpty() || tryit )
         {
                  return false;
         }
         else{
             return true;
         }
    }

    public void addbtn(View view)
    {
        checklength();
        if(checktowrite("+"))
           updatestring("+");
    }

    public void mulbtn(View view)
    {
        checklength();
        if(checktowrite("*"))
        updatestring("*");
    }

    public void divbtn(View view)
    {
        checklength();
        if(checktowrite("/"))
        updatestring("/");
    }

    public void modbtn(View view)
    {
        checklength();
        if(checktowrite("%"))
        updatestring("%");
    }

    public void subbtn(View view)
    {
        checklength();
        if(checktowrite("-"))
        updatestring("-");
    }

    public void equalsbtn(View view)
    {
                  String tocalculate = initialtext.getText().toString();
                  Expression exp = new Expression(tocalculate);
                  String result = String.valueOf(exp.calculate());

//                  if(result.substring(result.length()-2)=="." && result.substring(result.length()-1)=="0" )
//                  {
//                      result=result.substring(0,result.length()-2);
//                  }
        if(tocalculate.length()>12) {
            finaltext.setTextSize(33);
            finaltext.setText(tocalculate);

        }
        else
            finaltext.setText(tocalculate);

                  BigDecimal number = new BigDecimal(result);
                  String finalresult = number.stripTrailingZeros().toPlainString();
                  initialtext.setText(finalresult);
                  initialtext.setSelection(finalresult.length());


    }

    public void dotbtn(View view)
    {
        checklength();
        if(checktowrite("."))
        updatestring(".");
    }

    public void acbtn(View view) {
        clickcount++;
        if (clickcount == 1) {
            initialtext.setText("");
            initialtext.setTextSize(50);
        } else if (clickcount == 2) {
            finaltext.setText("");
            clickcount=0;

        }
    }
    public void backbtn(View view)
    {
          int cursorposition=initialtext.getSelectionStart();
          if(cursorposition!=0 && initialtext.length()!=0)
          {
              SpannableStringBuilder span = (SpannableStringBuilder) initialtext.getText();
              span.replace(cursorposition-1,cursorposition,"");
              initialtext.setText(span);
              initialtext.setSelection(cursorposition-1);
          }
    }
    public void sevenbtn(View view)
    {
        checklength();
        updatestring("7");
    }

    public void eightbtn(View view)
    {
        checklength();
        updatestring("8");
    }
    public void ninebtn(View view)
    {
        checklength();
        updatestring("9");
    }

    public void sixbtn(View view)
    {
        checklength();
        updatestring("6");
    }
    public void fivebtn(View view)
    {
        checklength();
        updatestring("5");
    }

    public void fourbtn(View view)
    {
        checklength();
         updatestring("4");
    }
    public void threebtn(View view)
    {    checklength();
          updatestring("3");
    }

    public void twobtn(View view)
    {
        checklength();
        updatestring("2");
    }
    public void onebtn(View view)
    {
        checklength();
        updatestring("1");
    }

    public void zerobtn(View view)
    {
        checklength();
        updatestring("0");
    }
    public void bobtn(View view)
    {
        checklength();
        updatestring("(");
    }

    public void bcbtn(View view)
    {
        checklength();
        updatestring(")");
    }
    public void darkbtn(View view) {
        darkcount++;
        if (darkcount == 1) {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_YES);
        }

        else if(darkcount==2)
        {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_NO);
            darkcount=0;
        }
    }





}