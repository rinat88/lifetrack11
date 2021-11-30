package com.example.lifetrack1.custom_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifetrack1.R;

public class Custom_dialog extends Dialog implements View.OnClickListener {
    public Activity c;
    public Dialog d;
    Custom_dialog binding;



    public Custom_dialog(@NonNull Context context) {
        super(context);
    }

    public Custom_dialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Custom_dialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        Object view = null;
        boolean checked = ((RadioButton) view).isChecked();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.never:
                boolean checked = false;
                if (checked)

                c.finish();
                break;
            case R.id.every_day:

                dismiss();
                break;
            case R.id.every_year:

                break;
            case R.id.every_week:

                break;

            case R.id.every_month:

                break;
            default:
                break;
        }
        dismiss();


    }
}
