package tomi.sqlitetehtava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {





    Button b;
    EditText ed;
    TextView t;
    OmaAdapteri entityAdapteri;
    Context context;
    ListView listaView;

    ArrayList<MyEntity> adapteriLista;

    List<MyEntity> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;


        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        b = (Button) findViewById(R.id.button);
        ed = (EditText) findViewById(R.id.editText);
        Room.databaseBuilder(getApplicationContext(), Tietokanta.class, Tietokanta.NIMI);

        final Tietokanta tietokanta = Room.databaseBuilder(getApplicationContext(), Tietokanta.class, Tietokanta.NIMI).allowMainThreadQueries().build();
        tietokanta.myEntityDao().nukeTable();

        lista = tietokanta.myEntityDao().lista();

        adapteriLista = new ArrayList<MyEntity>(lista);

        entityAdapteri = new OmaAdapteri(getApplicationContext(),R.layout.omaleiska,adapteriLista);

        listaView = (ListView) findViewById(R.id.listaView);

        listaView.setAdapter(entityAdapteri);

        listaView.setVisibility(View.VISIBLE);

        View.OnClickListener kuuntelija = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                String aika = simpleDateFormat.format(cal.getTime());
                String teksti = ed.getText().toString();

                tietokanta.myEntityDao().InsertMyEntity(new MyEntity(teksti,aika));

                lista = tietokanta.myEntityDao().lista();

                adapteriLista = new ArrayList<MyEntity>(lista);

                entityAdapteri = new OmaAdapteri(getApplicationContext(),R.layout.omaleiska,adapteriLista);

                listaView.setAdapter(entityAdapteri);
            }
        };

        b.setOnClickListener(kuuntelija);

    }
}
