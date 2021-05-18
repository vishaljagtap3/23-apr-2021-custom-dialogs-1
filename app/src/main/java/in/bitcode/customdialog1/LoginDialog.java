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

public class LoginDialog extends Dialog {

    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin;
    private Context mContext;

    public LoginDialog(@NonNull Context context) {

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
            if (mEdtUsername.getText().toString().equals("vishal") && mEdtPassword.getText().toString().equals("bitcode@123")) {

                Snackbar snackbar = Snackbar.make(
                        mBtnLogin,
                        "Login Successful!",
                        Snackbar.LENGTH_LONG
                );
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "Action undone!", Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.setActionTextColor(Color.RED);
                snackbar.setTextColor(Color.BLACK);
                snackbar.setBackgroundTint(Color.YELLOW);
                snackbar.show();

                dismiss();

                mContext.startActivity( new Intent(mContext, HomeActivity.class));


            } else {
                Snackbar.make(
                        mBtnLogin,
                        "Login Failed!",
                        Snackbar.LENGTH_LONG
                ).show();
            }
        }
    }


}
