package in.bitcode.customdialog1;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* LoginDialog loginDialog = new LoginDialog(MainActivity1.this);
                loginDialog.show();*/
                LoginDialogFinal  loginDialogFinal = new LoginDialogFinal(MainActivity1.this);
                loginDialogFinal.setOnLoginListener( new MyOnLoginListener() );
                loginDialogFinal.show();
            }
        });
    }

    private class MyOnLoginListener implements LoginDialogFinal.OnLoginListener {
        @Override
        public void onSuccess() {
            Snackbar.make(  mBtnLogin, "Login successful!", Snackbar.LENGTH_LONG).show();
            startActivity( new Intent(MainActivity1.this, HomeActivity.class));
        }

        @Override
        public void onFail() {
            Snackbar.make(  mBtnLogin, "Login failed!", Snackbar.LENGTH_LONG).show();
        }
    }
}