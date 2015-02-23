package com.aorbegozo005.quienquieresergraduado;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Ander on 2015/02/23.
 */
public class Instrucciones extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder eldialogo = new AlertDialog.Builder(getActivity());
        eldialogo.setTitle(getString(R.string.instrucciones));
        eldialogo.setMessage(getString(R.string.instrucciones_texto));
        eldialogo.setPositiveButton(getString(R.string.instrucciones_aceptar),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        return eldialogo.create();
    }
}
