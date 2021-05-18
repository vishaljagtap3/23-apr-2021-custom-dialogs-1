package in.bitcode.customdialog1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;

public class LoginDialogFinal extends Dialog {

    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin;
    private Context mContext;

    public interface OnLoginListener {
        void onSuccess();
        void onFail();
    }

    private OnLoginListener mOnLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.mOnLoginListener = onLoginListener;
    }

    public LoginDialogFinal(@NonNull Context context) {

        super(context);
        mContext = context;

        setContentView(R.layout.login_dialog);

        mEdtUsername = findViewById(R.id.edtUsername);
        mEdtPassword = findViewById(R.id.edtPassword);
        mBtnLogin = findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if( mOnLoginListener != null) {
                if (mEdtUsername.getText().toString().equals("vishal") && mEdtPassword.getText().toString().equals("bitcode@123")) {
                    mOnLoginListener.onSuccess();
                } else {
                    mOnLoginListener.onFail();
                }
            }
        }
    }


}
