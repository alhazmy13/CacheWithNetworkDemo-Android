package net.alhazmy13.cachewithnetworkdemo.app;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import net.alhazmy13.cachewithnetworkdemo.R;

/**
 * Created by Alhazmy13 on 12/25/16.
 * sprent_android
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mProgressDialog = new ProgressDialog(this);
        init();
    }

    public void showToast(String message) {
        Toast.makeText(this, String.valueOf(message), Toast.LENGTH_SHORT).show();
    }


    public void showProgressDialog() {
        mProgressDialog.setMessage(getString(R.string.please_wait));
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    public abstract void init();

    public abstract void setContentView();

    public abstract void checkPermission();
}
