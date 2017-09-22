package com.example.testapplication.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapplication.R;

public class RecycleDialog extends Dialog implements OnClickListener {

    private EditText et_name;
    private Button btn_hide_input_method;

    public RecycleDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public RecycleDialog(Context context, int theme) {
        super(context, theme);
    }

    public RecycleDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_recycle_content);
        LayoutParams params = getWindow().getAttributes();
        if (params == null) {
            params = new LayoutParams();
        }
        params.width = getWindow().getWindowManager().getDefaultDisplay().getWidth() / 2;
        params.height = getWindow().getWindowManager().getDefaultDisplay().getHeight() / 2;
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setAttributes(params);
        setCanceledOnTouchOutside(true);

        et_name = (EditText) findViewById(R.id.et_name);
        btn_hide_input_method = (Button) findViewById(R.id.btn_hide_input_method);
        btn_hide_input_method.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hide_input_method:
				//隐藏输入法
                InputMethodManager imm =
                                (InputMethodManager) getContext().getSystemService(
                                                Context.INPUT_METHOD_SERVICE);
                if (imm.isActive()) {
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DialogRecycle", "Dialog onStop");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("DialogRecycle", "Dialog onDetachedFromWindow");
    }

}
