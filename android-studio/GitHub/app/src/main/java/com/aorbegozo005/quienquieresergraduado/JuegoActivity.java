package com.aorbegozo005.quienquieresergraduado;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
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
    private String tel;
    private DrawerLayout mDrawerLayout;
    private ListView lista;

    private TextView pregunta;
    private Button respuesta1;
    private Button respuesta2;
    private Button respuesta3;
    private Button respuesta4;

    private Button comodinCompensacion;
    private Button comodinLlamada;
    private Button comodin50;

    private Button respondida;
    private Button zuzena;

    private int numeroPregunta;

    private DatuBase db;

    private ArrayList<Integer> ikusitakoak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        userName = getIntent().getStringExtra("USER_INFO");
        tel = getIntent().getStringExtra("TEL");
        getSupportActionBar().setTitle(userName);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        lista = (ListView) findViewById(R.id.left_drawer);
        pregunta = (TextView) findViewById(R.id.preguntaText);
        respuesta1 = (Button) findViewById(R.id.respuesta1);
        respuesta2 = (Button) findViewById(R.id.respuesta2);
        respuesta3 = (Button) findViewById(R.id.respuesta3);
        respuesta4 = (Button) findViewById(R.id.respuesta4);
        comodin50 = (Button) findViewById(R.id.comodin_50);
        comodinCompensacion = (Button) findViewById(R.id.comodin_compensa);
        comodinLlamada = (Button) findViewById(R.id.comodin_llamada);

        ikusitakoak = new ArrayList<Integer>();

        nuevaPartida();
    }

    public void nuevaPartida(){

        numeroPregunta = 0;
        db = new DatuBase(this);

        String[] galderak = getResources().getStringArray(R.array.preguntas);
        lista.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, galderak){
                             public boolean isEnabled(int position)
                             {
                                 return false;
                             }
                         }
        );


        comodin50.setEnabled(true);
        comodin50.setBackgroundColor(Color.GRAY);

        comodinCompensacion.setEnabled(true);
        comodinCompensacion.setBackgroundColor(Color.GRAY);

        comodinLlamada.setEnabled(true);
        comodinLlamada.setBackgroundColor(Color.GRAY);

        cargarQuestion();
    }

    public void cargarQuestion(){
        //definimos en qué nivel está con esta pequeña operación
        double maila = numeroPregunta/4 + 1;
        if(maila<=1){
            maila = 1;
        }
        else if(maila <=2 && maila >1){
            maila = 2;
        }
        else if(maila <=3 && maila > 2){
            maila = 3;
        }
        else{
            maila = 4;
        }
        //conseguimos todas las preguntas de ese nivel, desde la base de datos
        Cursor c = db.getQuestion((int)maila);
        numeroPregunta++;
        lista.setItemChecked(lista.getCount() - numeroPregunta, true);
        if(numeroPregunta == 17){//si ya se han respondido todas las preguntas,
            //se muestra mensaje de felicitación y termina
            DialogCongratulations dialog = new DialogCongratulations();
            dialog.show(getSupportFragmentManager(), "DIALOGO_CONGRATULATIONS");
        }
        if (numeroPregunta==13){//si estamos en el cuarto nivel
            //deshabilitamos el comodín de "Compensación"
            comodinCompensacion.setBackgroundColor(Color.RED);
            comodinCompensacion.setEnabled(false);
        }
        respondida = null;
        respuesta1.setVisibility(View.VISIBLE);
        respuesta2.setVisibility(View.VISIBLE);
        respuesta3.setVisibility(View.VISIBLE);
        respuesta4.setVisibility(View.VISIBLE);
        if(c.moveToFirst()) {
            //elegimos una pregunta al azar
            Random r = new Random();
            int ran = r.nextInt(c.getCount());
            //si es apregunta ya ha sido respondida en la partida, la descartamos
            //y volvemos a elegir otra
            //cuando se encuentre una pregunta sin responder, se carga en la interfaz
            if (!ikusitakoak.contains(ran)) {
                ikusitakoak.add(ran);

                c.move(ran);
                pregunta.setText(c.getString(0));
                ArrayList<Button> botoiak = new ArrayList<>();
                botoiak.add(respuesta1);
                botoiak.add(respuesta2);
                botoiak.add(respuesta3);
                botoiak.add(respuesta4);
                int i = 1;
                while (botoiak.size() > 0) {
                    //elegimos, aleatoriamente, una posición para colocar la respuesta correcta
                    int ran2 = r.nextInt(botoiak.size());
                    botoiak.get(ran2).setText(c.getString(i));
                    if (i == 1) {
                        zuzena = botoiak.get(ran2);
                    }
                    i++;
                    botoiak.get(ran2).setBackgroundColor(Color.BLUE);
                    botoiak.remove(ran2);

                }
                c.close();
            }
        }else{
            cargarQuestion();
        }
    }


    public void comodin50(View v){
        if (zuzena == respuesta1 || zuzena == respuesta2){
            respuesta3.setVisibility(View.INVISIBLE);
            respuesta4.setVisibility(View.INVISIBLE);
        }else{
            respuesta1.setVisibility(View.INVISIBLE);
            respuesta2.setVisibility(View.INVISIBLE);
        }
        comodin50.setBackgroundColor(Color.RED);
        comodin50.setEnabled(false);
    }

    public void comodinLlamada(View v){
        Log.d("Proba", tel.toString());
        Intent intent2 = new Intent(Intent.ACTION_DIAL);
        intent2.setData(Uri.parse("tel:"+tel));
        startActivity(intent2);
        comodinLlamada.setBackgroundColor(Color.RED);
        comodinLlamada.setEnabled(false);
    }

    public void comodinCompensacion(View v){
        cargarQuestion();
        comodinCompensacion.setBackgroundColor(Color.RED);
        comodinCompensacion.setEnabled(false);
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
        if(respondida == null){
            v.setBackgroundColor(Color.parseColor("#FFBF00"));
            respondida = (Button) v;
            Handler handler = new Handler();
            Runnable runnable = new Runnable(){
                public void run() {
                    marcarRespuesta();
                }
            };

            //TODO ALDATU 1000*numeroPregunta/4
            handler.postDelayed(runnable,0 );
        }
    }

    public void marcarRespuesta(){
        zuzena.setBackgroundColor(Color.GREEN);
        Handler handler = new Handler();
        Runnable runnable = new Runnable(){
            public void run() {
                comprobarRespuesta();
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public void comprobarRespuesta(){
        if(zuzena == respondida){
            cargarQuestion();
        }else{
            DialogMagis dialog = new DialogMagis();
            dialog.show(getSupportFragmentManager(), "DIALOG_MAGIS");
        }
    }
}
