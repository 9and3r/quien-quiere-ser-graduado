package com.aorbegozo005.quienquieresergraduado;

import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class JuegoActivity extends ActionBarActivity {

    private String userName;
    private Uri tel;
    private DrawerLayout mDrawerLayout;
    private ListView lista;

    private TextView pregunta;
    private Button respuesta1;
    private Button respuesta2;
    private Button respuesta3;
    private Button respuesta4;

    private Button comodin1;
    private Button comodin2;
    private Button comodin3;

    private boolean respondida;
    private Button zuzena;

    private DatuBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        userName = getIntent().getStringExtra("USER_INFO");
        tel = Uri.parse(getIntent().getStringExtra("TEL"));
        getSupportActionBar().setTitle(userName);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        lista = (ListView) findViewById(R.id.left_drawer);
        pregunta = (TextView) findViewById(R.id.preguntaText);
        respuesta1 = (Button) findViewById(R.id.respuesta1);
        respuesta2 = (Button) findViewById(R.id.respuesta2);
        respuesta3 = (Button) findViewById(R.id.respuesta3);
        respuesta4 = (Button) findViewById(R.id.respuesta4);

        db = new DatuBase(this);

        String[] galderak = getResources().getStringArray(R.array.preguntas);
        lista.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, galderak));

        cargarQuestion();
    }

    public void cargarQuestion(){
        Cursor c = db.getQuestion(1);
        if(c.moveToFirst()){
            Random r = new Random();
            int ran = r.nextInt(c.getCount());
            c.move(ran);
            pregunta.setText(c.getString(0));
            ArrayList<Button> botoiak = new ArrayList<>();
            botoiak.add(respuesta1);
            botoiak.add(respuesta2);
            botoiak.add(respuesta3);
            botoiak.add(respuesta4);
            int i = 1;
            while(botoiak.size()>0){
                int ran2 = r.nextInt(botoiak.size());
                botoiak.get(ran2).setText(c.getString(i));
                if(i == 1){
                    zuzena = botoiak.get(ran2);
                }
                i++;

                botoiak.remove(ran2);

            }
            c.close();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego, menu);
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


    public void respuesta(View v){
        if(!respondida){
            v.setBackgroundColor(Color.CYAN);
            respondida = true;
        }

    }
}
