package tomi.sqlitetehtava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OmaAdapteri extends ArrayAdapter<MyEntity> {

    private Context context;
    private LayoutInflater layoutInflater;

    private TextView aikaView;
    private TextView tekstiView;

    private ArrayList<MyEntity> entities;

    public OmaAdapteri(@NonNull Context context, int resource, @Nullable ArrayList<MyEntity> entities) {
        super(context, resource, entities);
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.entities = entities;

    }



    @Override
    public void add(@Nullable MyEntity object) {
        super.add(object);
        entities.add(object);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.omaleiska, parent, false);

        aikaView = (TextView) view.findViewById(R.id.aikaView);
        tekstiView = (TextView)view.findViewById(R.id.tekstiView);



        aikaView.setText(entities.get(position).time);
        tekstiView.setText(entities.get(position).text_from_edittext);




        return view;

    }

}