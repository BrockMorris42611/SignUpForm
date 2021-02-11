package temple.edu.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    EditText email_tb; //define the text fields for the info input
    EditText name_tb;
    EditText pass_tb;
    EditText passConf_tb;

    Button send; //define button to confirm all info

    UserLoginInfo arriving_user; //use about which we store info

    TextView email_background;
    TextView name_background;
    TextView pass_background;
    TextView passConf_background;

    TextView email_err_mssg;
    TextView name_err_mssg;
    TextView pass_err_mssg;
    TextView passConf_err_mssg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_tb = findViewById(R.id.email_text_entry); //set up all my textBox fields for the user to enter data
        name_tb = findViewById(R.id.name_entry);
        pass_tb = findViewById(R.id.password_entry);
        passConf_tb = findViewById(R.id.passwordConf_entry);
        send = findViewById(R.id.send_info); //set up the button

        email_background = findViewById(R.id.email_view); //these are all the views behind the sections and boxes for info entry
        name_background =  findViewById(R.id.name_view);
        pass_background = findViewById(R.id.password_view);
        passConf_background = findViewById(R.id.confirm_view);

        email_err_mssg = findViewById(R.id.email_err_view);
        name_err_mssg = findViewById(R.id.name_err_view);
        pass_err_mssg = findViewById(R.id.pass_err_view);
        passConf_err_mssg = findViewById(R.id.conf_err_view);



        send.setOnClickListener(new View.OnClickListener() { //get the button ready to listen for click
            @Override
            public void onClick(View v) {
                arriving_user = new UserLoginInfo( //setting up new object for user with the new info
                        email_tb.getText().toString(),
                        name_tb.getText().toString(),
                        pass_tb.getText().toString(),
                        passConf_tb.getText().toString());
                check_input(arriving_user);
                Log.v("email> ", arriving_user.getEmail()); //print it all to logs to make sure
                Log.v("name> ", arriving_user.getName());
                Log.v("password> ",arriving_user.getPassword());
                Log.v("confirmed password> ", arriving_user.getPasswordConf());
            }
        });
    }
    public void check_input(UserLoginInfo new_info){ //make sure all our input is valid

        if(new_info.getEmail().equals(""))              //these are all checking for empty string
            email_err_mssg.setVisibility(View.VISIBLE);
        if(new_info.getName().equals(""))
            name_err_mssg.setVisibility(View.VISIBLE);
        if(new_info.getPassword().equals(""))
            pass_err_mssg.setVisibility(View.VISIBLE);
        if(new_info.getPasswordConf().equals(""))
            passConf_err_mssg.setVisibility(View.VISIBLE);

        if(!new_info.getPassword().equals(new_info.getPasswordConf())){
            passConf_err_mssg.setText(R.string.match_err);
            passConf_err_mssg.setVisibility(View.VISIBLE);
        }
    }
}
class UserLoginInfo {

    private String name;
    private String email;
    private String password;
    private String passwordConf;

    public UserLoginInfo(String email, String name, String password, String passwordConf){
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