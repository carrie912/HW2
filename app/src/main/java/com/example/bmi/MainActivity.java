package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText cm;                                                          //變數
    EditText kg;                                                          //變數
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cm = (EditText)findViewById(R.id.et1);                            // 取得身高
        kg = (EditText)findViewById(R.id.et2);                            // 取得體重
        Button submit = (Button)findViewById(R.id.to);                    // 取得按鈕

        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                if ( !("".equals(cm.getText().toString())
                        || "".equals(kg.getText().toString())) )
                {
                    float fh = Float.parseFloat(cm.getEditableText().toString());       // 取得身高輸入值
                    float fw = Float.parseFloat(kg.getEditableText().toString());        // 取 體重輸入值
                    float fresult;                                                     // BMI值 計算結果
                    TextView result = (TextView)findViewById(R.id.result);             // 取得 顯示結果
                    fh = fh/100;                                                      // 計算BMI
                    fh = fh*fh;                                                       // 計算BMI

                    NumberFormat nf = NumberFormat.getInstance();                       // 數字格式
                    nf.setMaximumFractionDigits(2);                                   // 限制小數第二位
                    fresult = fw/fh;                                                  // 計算BMI
                    result.setText(nf.format(fw/fh) +"");                  // 顯示BMI計算結果
                    TextView dia = (TextView)findViewById(R.id.text);                 // 取得 顯示診斷 物件

                                                                                      // 診斷結果 顯示
                    if (fresult<18.5)
                        dia.setText("體重過輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("正常範圍");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("過    重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖        ");
                }
            }
        });
    }
}
