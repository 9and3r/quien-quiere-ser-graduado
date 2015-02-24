package com.aorbegozo005.quienquieresergraduado;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class UserInfoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
    }

    public void elegirContacto(View v){
        Intent pickContactIntent = new Intent( Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI );
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(pickContactIntent, 1);
    }

    @Override
    public void onActivityResult( int requestCode, int resultCode, Intent intent ) {

        super.onActivityResult( requestCode, resultCode, intent );
        if ( requestCode == 1 ) {

            if ( resultCode == RESULT_OK ) {
                Uri pickedPhoneNumber = intent.getData();
                Intent intent2 = new Intent(Intent.ACTION_CALL, pickedPhoneNumber);
                startActivity(intent2);
                Toast t = Toast.makeText(this, Uri.parse(pickedPhoneNumber.toString()).toString(), Toast.LENGTH_LONG);
                t.show();
                // handle the picked phone number in here.
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
