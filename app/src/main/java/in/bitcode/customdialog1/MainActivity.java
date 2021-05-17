package in.bitcode.customdialog1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog loginDialog = new Dialog(MainActivity.this);
                loginDialog.setTitle("BitCode Student Portal");
                loginDialog.setContentView(R.layout.login_dialog);

                EditText edtUsername = loginDialog.findViewById(R.id.edtUsername);
                EditText edtPassword = loginDialog.findViewById(R.id.edtPassword);
                Button btnLogin = loginDialog.findViewById(R.id.btnLogin);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edtUsername.getText().toString().equals("vishal") && edtPassword.getText().toString().equals("bitcode123")) {
                            //Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_LONG).show();
                            Snackbar snackbar = Snackbar.make(
                                    mBtnLogin,
                                    "Login Successful!",
                                    Snackbar.LENGTH_LONG
                            );
                            snackbar.setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Action undone!", Toast.LENGTH_LONG).show();
                                }
                            });
                            snackbar.setActionTextColor(Color.RED);
                            snackbar.setTextColor(Color.BLACK);
                            snackbar.setBackgroundTint(Color.YELLOW);
                            snackbar.show();

                            //loginDialog.dismiss();
                        } else {
                            //Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_LONG).show();
                            Snackbar.make(
                                    mBtnLogin,
                                    "Login Failed!",
                                    Snackbar.LENGTH_LONG
                            ).show();
                        }
                    }
                });

                loginDialog.show();

            }
        });
    }
}