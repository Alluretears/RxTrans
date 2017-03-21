package com.imzhiqiang.rxtranslator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.imzhiqiang.rxtrans.Langs;
import com.imzhiqiang.rxtrans.RxTrans;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private TextView mTvResult;
    private EditText mEtQuery;
    private Button mBtnYoudao;
    private Button mBtnBaidu;
    private ProgressBar mProgressBar;
    private Spinner mSpinner;
    private Langs mLang = Langs.ZH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtnYoudao.setOnClickListener(this);
        mBtnBaidu.setOnClickListener(this);
    }

    private void initView() {
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mEtQuery = (EditText) findViewById(R.id.et_query);
        mBtnYoudao = (Button) findViewById(R.id.btn_youdao);
        mBtnBaidu = (Button) findViewById(R.id.btn_baidu);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mLang = Langs.ZH;
                        break;
                    case 1:
                        mLang = Langs.EN;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(mEtQuery.getText().toString())) {
            shakeView(mEtQuery);
            return;
        }
        switch (v.getId()) {
            case R.id.btn_youdao:
                mProgressBar.setVisibility(View.VISIBLE);
                RxTrans.getInstance()
                        .useYoudao(Keys.YOUDAO_KEYFROM, Keys.YOUDAO_KEY)
                        .translate(mEtQuery.getText().toString(), Langs.AUTO.toString(),
                                mLang.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(@NonNull String s) throws Exception {
                                mTvResult.setText(s);
                                mProgressBar.setVisibility(View.GONE);
                            }
                        });
                break;
            case R.id.btn_baidu:
                mProgressBar.setVisibility(View.VISIBLE);
                RxTrans.getInstance()
                        .useBaidu(Keys.BAIDU_APP_ID, Keys.BAIDU_SECURITY_KEY)
                        .translate(mEtQuery.getText().toString(), Langs.AUTO.toString(),
                                mLang.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(@NonNull String s) throws Exception {
                                mTvResult.setText(s);
                                mProgressBar.setVisibility(View.GONE);
                            }
                        });
                break;
        }
    }

    static void shakeView(View targetView) {
        ObjectAnimator.ofFloat(targetView, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0)
                .setDuration(700)
                .start();
    }
}
