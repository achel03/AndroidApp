package com.example.androidapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2,b3,b4;
    int selectedMenu = 0;
    String menu[] = {"농구", "수영", "축구"};
    boolean checked[] = {false, false, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        init();
    }

    private void init(){
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button4);
        b3 = findViewById(R.id.button5);
        b4 = findViewById(R.id.button6);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button3){
            displayDialog();
        }else if(v == b2){
            displayDialog2();
        }else if(v.getId() == R.id.button5){
            displayDialog3();
        }else if(v ==b4){
            displayDialog4();
        }
    }

    private void displayDialog4() {
        View view = View.inflate(this, R.layout.dialog, null);
        final EditText et = view.findViewById(R.id.etMsg);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this); // Main Activity 자체를 context로 부름
        dlg.setTitle("사용자 정의 대화상자");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(view);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("입력한 메세지: "+et.getText().toString());
            }
        }); //ctrl P : Type 변수
        dlg.setPositiveButton("CANCEL", null);
        dlg.show();
    }

    private void displayDialog3() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this); // Main Activity 자체를 context로 부름
        dlg.setTitle("CHECKBOX 대화상자");
        dlg.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                checked[which] = isChecked;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String list = ""; //반복문을 이용해 체크박스 체크된 것 출력하는 문장 추가 **
                for(int i=0; i<checked.length; i++) if(checked[i])  list = list+" "+ menu[i];
                displayToast(list+" 선택되었습니다! ");
            }
        }); //ctrl P : Type 변수
        dlg.show();
    }

    private void displayDialog2() {

        AlertDialog.Builder dig = new AlertDialog.Builder(this); // Main Activity 자체를 context로 부름
        dig.setTitle("Radio 대화상자");
        dig.setSingleChoiceItems(menu, selectedMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedMenu = which;
            }
        });
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectedMenu]+"가 선택되었습니다.");
            }
        }); //ctrl P : Type 변수
        dig.show();
    }

    private void displayDialog() {
       //Toast.makeText(this, "Dialog1", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder dig = new AlertDialog.Builder(this); // Main Activity 자체를 context로 부름
        dig.setTitle("기본대화상자");
        dig.setMessage("대화상자 메세지입니다.");
        dig.setIcon(R.mipmap.ic_launcher);
        dig.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("");
            }
        }); //ctrl P : Type 변수
        dig.show();
    }

    private void displayToast(String msg) {
        if(msg == null){
            msg = "OK Clicked";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showDatePicker(View view) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +"/" + day_string + "/" + year_string);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }
}