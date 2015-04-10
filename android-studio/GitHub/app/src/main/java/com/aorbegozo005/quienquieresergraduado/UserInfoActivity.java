package com.aorbegozo005.quienquieresergraduado;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class UserInfoActivity extends ActionBarActivity {

    private Uri pickedPhoneNumber;
    private EditText userName;
    private String number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        userName = (EditText) findViewById(R.id.userName);
    }

    public void elegirContacto(View v){
        //Se elige el contacto y se almacena en un intent "pickContactIntent"
        Intent pickContactIntent = new Intent( Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI );
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(pickContactIntent, 1);
    }

    public void empezarJuego(View v){
        if (pickedPhoneNumber != null && userName.getText() != null && userName.getText().length()>0){
            Intent intent = new Intent(this, JuegoActivity.class);
            intent.putExtra("USER_INFO", userName.getText().toString());
            intent.putExtra("TEL", number);
            startActivity(intent);
        }else{
            DatosError error = new DatosError();
            error.show(getSupportFragmentManager(),"ERROR");
        }
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent intent ) {

        super.onActivityResult( requestCode, resultCode, intent );
        if ( requestCode == 1 ) {

            if ( resultCode == RESULT_OK ) {
                pickedPhoneNumber = intent.getData();

                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(pickedPhoneNumber, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                number = cursor.getString(column);


                /* Deitzeko kodigoa
                Intent intent2 = new Intent(Intent.ACTION_CALL, pickedPhoneNumber);
                startActivity(intent2);
                */
                // handle the picked phone number in here.
            }
        }
    }
}
