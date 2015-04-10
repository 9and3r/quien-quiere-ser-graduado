package com.aorbegozo005.quienquieresergraduado;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ander on 2015/03/16.
 */
public class DatuBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DATUBASE_GRADUATED";
    private static final int DATABASE_VERSION = 1;

    public DatuBase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE \"main\".\"Pregunta\" (\"galdera\" VARCHAR PRIMARY KEY  NOT NULL , \"erantzuna_zuzena\" VARCHAR, \"erantzuna_1\" VARCHAR, \"erantzuna_2\" VARCHAR, \"erantzuna_3\" VARCHAR, \"bloke\" INTEGER)");


        // Nivel 1
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cómo se declara una variable en ADA?','a: Integer:=0;','Integer a = 0;','int a:=0;','Integer a:=0;',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cómo es 12 en binario?','1100','1110','1101','1010',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Los humanos tenemos electrones?','Sí','No','Sólo las plantas','No. Tenemos protones',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Es (p^(p -> q) -> q)  una tautologia?','Sí','No','No siempre','Solo si p=F',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es el límite de: lim (sin(x)-x)/x^3 cuando x -> 0?','-1/6','0','1/2','2/5',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es la integral de x/(x+1)^3 entre 0 e infinito?','1/2','1/3','2','1/4',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('int res=3;for(int i=0;i<=10;i=i+2){res=i*2;} //¿Cuál es el resultado?','20','23','63','60',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Qué indica esta función en metodología de la programación: f:para_cualquier i en N(i != x and x mod i !=0)','Es primo','Es par','Es impar','No es entero',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Matriz A=[(1, 2); (0, 1)]; Matriz B=[(2, 4), (1, 1)]; det(A·B)=?','-2','2','1','-1',1)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es la capacidad máxima de un BluRay de doble capa?','54GB','30GB','70GB','24GB',1)");

        //Nivel 2

        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es el orden computacional de un árbol en Estructuras de Datos y Algoritmos?','O(log N)','O(N*log N)','O(N^2)','O(N)',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Patrón de programación modular','Factory','Factor','Single','Abstract',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('La fórmula del PIB = Consumo + ... + Gasto Público + (Exportación - Importación)','Inversión','Saldo público','Impuestos','Ninguno',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Sintaxis correcta:','Select * from...','Select from *...','Select from...','Ninguna está bien',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cómo se muestra un mensaje en pantalla en C?','printf(texto)','sysout(texto)','System.out(texto)','prints(texto)',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Una dirección IP privada empieza por...?','192.168.x.x','158.255.x.x','192.255.x.x','255.255.x.x',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es la resolución de VGA?','640x480','480x360','640x360','480x360',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál es la probabilidad de que al lanzar 3 dados, la suma sea 7?','5/72','4/63','1/8','3/16',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES (' A un vértice geométrico de la región factible le corresponde en el simplex una solución...','Factible básica','Óptima','Factible Óptima','Básica',2)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Una Máquina de Turing es un modelo ... que consiste en un autómata capaz de implementar cualquier problema matemático expresado por medio de un algoritmo','Matemático','Computacional','Lingüístico','Cifrado',2)");

        //Nivel 3

        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Duración media de un proyecto: ','(t0+4tm+tp)/6','(t0+4tm+tp)/2','(t0+tm+tp)/6','(2t0+4tm+tp)/6',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuántas tablas se forman con relación de N-N en Bases de Datos?','3','4','2','2 con foreignkey',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿En un cifrado Vigenère, cuál es la clave para el cambio de DESOXIRRIBONUCLEICO a DVJCP XZRZS CFJKL VZQG?','ARROSPI','ARBOL','ARREON','ARREBUJO',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál NO es un principio de la norma ISO9000?','Mínimo esfuerzo','Mejora continua','Liderazgo','Enfoque cliente',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿En un Diagrama de Casos de Uso, qué etiqueta indica una obligación a acometer un caso de uso, antes de proceder con otro?','includes','extends','excludes','intends',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál de éstas no es una herramienta de Business Intelligence?','SAP','Tableau','ClickView','Pentaho',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('En Weka, nos interesa aumentar el número de instancias de la muestra por generación aleatoria cuando la diferencia de instancias entre clase positiva y negativa es...','Alta','Baja','0','>1000',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('OAuth2.0 es un protocolo de...','Delegación','Autentificación','Seguridad','Encriptación',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Las tres partes interesadas en el pensamiento Lean Manufacturing son Clientes, Organización y...','Empleados','Proveedores','Técnicos','Gerentes',3)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál de las siguientes no es una función de agregación?','LIMIT()','COUNT()','MAX()','MIN()',3)");

        //Nivel 4

        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Zein da LABORATEGI hitzaren lexema semantikoa?','Ez dauka; (mailegua)','Labora','Labor','Laborategi',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Para la siguiente línea de Javascript: setTimeout(f, 1000); ¿cuántas veces se ejecutará f desde que se ejecute hasta que pasen 10 segundos?','1','10','9','11',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('En Máxima, qué comando se utiliza para convertir la función: (2*x^3+4*x^2+2*x)/(6*x^3-6*x); a (x+1)/(3*x-3);?','ratsimp','find_root','solve','simplify',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Qué algoritmo encuentra siempre la solución óptima?','Branch & Bound','Best First','Beam Search','Hill Climbing',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿A la hora de diseñar la interfaz de un Sistema de Interacción, qué elemento ayuda a la percepción de la profundidad?','Scroll','Cliquear','Arrastrar','Touchpad',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Qué tiene una PLC?','Entradas y salidas','Sólo entradas','Sólo salidas','Tiene swag',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('Para poder usar un servicio de GooglePlay, ¿dónde debes especificar la dependencia: com.google.android.gms:play-services:6.5.87?','gradle','Manifest','layout','drawable',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('El Clustering es una técnica...','Exploratoria','Clasificatoria','Ambas','Ninguna',4)");
        db.execSQL("INSERT INTO \"main\".\"Pregunta\" (\"galdera\",\"erantzuna_zuzena\",\"erantzuna_1\",\"erantzuna_2\",\"erantzuna_3\",\"bloke\") VALUES ('¿Cuál no es parte de un análisis socio-técnico?','Gastos','Actores','Obligaciones','Software',4)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getQuestion(int maila){//devuelve las preguntas del nivel seleccionado
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("Select * from Pregunta where bloke = "+ maila +";",null);
    }

}
