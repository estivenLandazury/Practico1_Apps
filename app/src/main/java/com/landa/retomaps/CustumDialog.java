package com.landa.retomaps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("ValidFragment")
public class CustumDialog extends AppCompatDialogFragment {

    private EditText txt_Marcador;
    private DialogListener listener;

    public Activity c;
    public Dialog d;
    public Button aceptar, cancelar;

    public CustumDialog(Activity a) {
        super();
        // TODO Auto-generated constructor stub
        this.c = a;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inlfater = getActivity().getLayoutInflater();
        View view = inlfater.inflate(R.layout.activity_custum_dialog, null);
        txt_Marcador = view.findViewById(R.id.txt_nameUbication);
        builder.setView(view).setTitle("Marcador")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String textoMarcador = txt_Marcador.getText().toString();
                        listener.applyTexts(textoMarcador);

                    }
                })

                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();


    }


    public void onAttach(Context contex) {
        super.onAttach(contex);
        try {
            listener = (DialogListener) contex;

        } catch (ClassCastException e) {
           throw new ClassCastException("Error al castear el archivo");
        }
    }


    public interface DialogListener {
        void applyTexts(String ubication);
    }


}

