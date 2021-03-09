package com.mac_available.ex06radiobtton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView tv;
    RatingBar ratingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        rg=findViewById(R.id.rg);
        tv=findViewById(R.id.tv);
        ratingbar = findViewById(R.id.rating);

        //RadioButton의 선택이 바뀌는 것을 듣는 리스너를 RadioGroup에 설정하기
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                tv.setText((rb.getText().toString()));
            }
        });

        //ratingbar 점수변경을 듣는 리스너 및 설정
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText(rating+"점");
            }
        });
    }

    public void clickBtn(View view) {
        //선택된 RadioButton의 글씨를 얻어오기
        //RadioGroup에게 선택된 RadioButton의 id를 얻어올 수 있음
        int id = rg.getCheckedRadioButtonId(); //R장부는 모든걸 다 인트형으로 가지고 있어

        //id를 이용하여 선택된 RadioButton객체를 참조하기
        RadioButton rb = findViewById(id); //여태 (R.id.btn_ko)이랬는데 이거 대신 R의 id를 직접넣은거
        tv.setText(rb.getText().toString());
    }
}