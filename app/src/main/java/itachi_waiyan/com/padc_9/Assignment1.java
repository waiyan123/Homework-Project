package itachi_waiyan.com.padc_9;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Assignment1 extends AppCompatActivity implements View.OnClickListener {

    public static Intent newIntent(Context context,String msg){
        Intent intent = new Intent(context,Assignment1.class);
        return intent;
    }

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
        btnOk = findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(!checkValidationEditText(this.etName)){
            this.etName.setError("empty");
        }
        else if(!checkValidationEditText(this.etEmail)){
            this.etEmail.setError("empty");
        }
        else if(!checkValidationEditText(this.etPhone)){
            this.etPhone.setError("empty");
        }
        else if(!checkValidationEditText(this.etAddress)){
            this.etAddress.setError("empty");
        }
        else {
            boolean cbValid = false;
            int cb = 0 ;
            int rb = 0 ;
            if(rgMale.isChecked()){
                rb = 1;
            }
            else if(rgFemale.isChecked()){
                rb = 2;
            }
            if(checkValidationCheckbox(cbReading)){
                cbValid = true;
                cb = 1;
            }
            else if(checkValidationCheckbox(cbSwimming)){
                cbValid = true;
                cb = 2;
            }
            else if(checkValidationCheckbox(cbWalking)){
                cbValid = true;
                cb = 3;
            }
            else if(checkValidationCheckbox(cbTravelling)){
                cbValid = true;
                cb = 4;
            }

            if(cbValid){
                showDialog(this.etName.getText().toString(),this.etEmail.getText().toString(),
                        this.etPhone.getText().toString(),this.etAddress.getText().toString(),rb,cb);
            }
            else {
                Toast.makeText(Assignment1.this,"Checkbox is empty",Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void showDialog(String name,String email,String phone,String address,int isCheckRadio,int isCheckCb){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.user_info_dialog);

        TextView tvName = dialog.findViewById(R.id.tv_name);
        TextView tvEmail = dialog.findViewById(R.id.tv_email);
        TextView tvPhone = dialog.findViewById(R.id.tv_phone);
        TextView tvAddress = dialog.findViewById(R.id.tv_address);
        RadioGroup rgGroup = dialog.findViewById(R.id.rg_group);
        RadioButton rgMale = dialog.findViewById(R.id.rg_male);
        RadioButton rgFemale = dialog.findViewById(R.id.rg_female);
        CheckBox cbReading = dialog.findViewById(R.id.cb_reading);
        CheckBox cbSwimming = dialog.findViewById(R.id.cb_swimming);
        CheckBox cbWalking = dialog.findViewById(R.id.cb_walking);
        CheckBox cbTravelling = dialog.findViewById(R.id.cb_travelling);
        Button btnOk = dialog.findViewById(R.id.btn_ok);


        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvAddress.setText(address);
        switch (isCheckRadio){
            case 1 : rgMale.setChecked(true);
            break;
            case 2 : rgFemale.setChecked(true);
        }
        switch (isCheckCb){
            case 1 : cbReading.setChecked(true);
                break;
            case 2 : cbSwimming.setChecked(true);
                break;
            case 3 : cbWalking.setChecked(true);
                break;
            case 4 : cbTravelling.setChecked(true);
                break;
        }
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private boolean checkValidationEditText(EditText et){
        if(et.getText().toString().equals("")){
            return false;
        }
        else return true;
    }
    private boolean checkValidationCheckbox(CheckBox cb){
        if(cb.isChecked()){
            return true;
        }
        else return false;
    }
}