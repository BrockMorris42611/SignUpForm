package temple.edu.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {


    EditText email_tb; //define the text fields for the info input
    EditText name_tb;
    EditText pass_tb;
    EditText passConf_tb;

    Button send; //define button to confirm all info
    UserLoginInfo arriving_user; //use about which we store info

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_tb = findViewById(R.id.email_text_entry); //set up all my textBox fields for the user to enter data
        name_tb = findViewById(R.id.name_entry);
        pass_tb = findViewById(R.id.password_entry);
        passConf_tb = findViewById(R.id.passwordConf_entry);
        send = findViewById(R.id.send_info); //set up the button

        send.setOnClickListener(new View.OnClickListener() { //get the button ready to listen for click
            @Override
            public void onClick(View v) {
                arriving_user = new UserLoginInfo( //setting up new object for user with the new info
                        email_tb.getText().toString(),
                        name_tb.getText().toString(),
                        pass_tb.getText().toString(),
                        passConf_tb.getText().toString());
                Log.v("email> ", arriving_user.getEmail()); //print it all to logs to make sure
                Log.v("name> ", arriving_user.getName());
                Log.v("password> ",arriving_user.getPassword());
                Log.v("confirmed pasword> ", arriving_user.getPasswordConf());
            }
        });


    }



}
class UserLoginInfo {

    private String name;
    private String email;
    private String password;
    private String passwordConf;

    public UserLoginInfo(String name, String email, String password, String passwordConf){
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordConf = passwordConf;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPasswordConf() { return passwordConf; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setPasswordConf(String passwordConf) { this.passwordConf = passwordConf; }
}