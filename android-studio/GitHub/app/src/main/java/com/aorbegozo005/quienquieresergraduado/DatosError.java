package com.aorbegozo005.quienquieresergraduado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Ander on 2015/03/03.
 */
public class DatosError extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder eldialogo = new AlertDialog.Builder(getActivity());
        eldialogo.setTitle(getString(R.string.datos_error_titulo));
        eldialogo.setMessage(getString(R.string.datos_error_mensaje));
        eldialogo.setPositiveButton(getString(R.string.aceptar),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        return eldialogo.create();
    }
}
