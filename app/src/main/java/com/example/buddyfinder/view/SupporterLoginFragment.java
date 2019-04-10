package com.example.buddyfinder.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.buddyfinder.R;
import com.example.buddyfinder.data.DAOSupporter;
import com.example.buddyfinder.model.Supporter;

public class SupporterLoginFragment extends DialogFragment implements View.OnClickListener {
    private EditText ptxtName;
    private EditText ptxtPhone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_supporter_login, container, false);

        Button btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        this.ptxtPhone = view.findViewById(R.id.ptxtPhone);
        this.ptxtName = view.findViewById(R.id.ptxtName);

        return view;
    }


    @Override
    public void onClick(View v) {
        String name = this.ptxtName.getText().toString();
        String phone = this.ptxtPhone.getText().toString();

        Supporter supporter = new Supporter(name, phone);
        DAOSupporter.getInstance().setSupporter(supporter);

        this.dismiss();
    }
}
