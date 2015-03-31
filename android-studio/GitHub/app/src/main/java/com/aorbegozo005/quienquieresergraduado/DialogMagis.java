package com.aorbegozo005.quienquieresergraduado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Ander on 2015/03/31.
 */
public class DialogMagis extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder eldialogo = new AlertDialog.Builder(getActivity());
        eldialogo.setTitle(getString(R.string.perder));
        eldialogo.setMessage(getString(R.string.perder_msg));
        eldialogo.setPositiveButton(getString(R.string.aceptar),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((JuegoActivity)getActivity()).nuevaPartida();
            }
        });
        eldialogo.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String url = "http://www.ehu.eus/es/web/irakasleen-ue-bilbao/home";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                getActivity().finish();
            }
        });
        return eldialogo.create();
    }

}
