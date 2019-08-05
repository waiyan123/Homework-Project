package itachi_waiyan.com.padc_9;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Assignment1 extends AppCompatActivity {

    EditText etName,etEmail,etPhone,etAddress;
    RadioGroup rgGroup;
    RadioButton rgMale,rgFemale;
    CheckBox cbReading,cbSwimming,cbWalking,cbTravelling;
    Button btnOk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_layout1);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etAddress = findViewById(R.id.et_address);
        rgGroup = findViewById(R.id.rg_group);
        rgMale = findViewById(R.id.rg_male);
        rgFemale = findViewById(R.id.rg_female);
        cbReading = findViewById(R.id.cb_reading);
        cbSwimming = findViewById(R.id.cb_swimming);
        cbWalking = findViewById(R.id.cb_walking);
        cbTravelling = findViewById(R.id.cb_travelling);

    }
}