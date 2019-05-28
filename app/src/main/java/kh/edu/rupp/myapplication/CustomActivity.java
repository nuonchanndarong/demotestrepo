package kh.edu.rupp.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        listView = findViewById(R.id.listView);

        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("note 1", "Description 1"));
        notes.add(new Note("note 2", "Description 2"));

        NoteListAdapter adapter = new NoteListAdapter(this, notes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomActivity.this, "You clicked on row " + i, Toast.LENGTH_LONG).show();
            }
        });
    }
}


class NoteListAdapter extends ArrayAdapter<Note>{

    public ArrayList<Note> notes;
    public Context context;

    public NoteListAdapter(Context context, ArrayList<Note> notes){
        super(context, R.layout.note_item, notes);
        this.notes = notes;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Note n = notes.get(position);

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.note_item, parent, false);

        TextView title = convertView.findViewById(R.id.noteTitle);
        TextView descriptoin = convertView.findViewById(R.id.noteDescription);

        title.setText(n.title);
        descriptoin.setText(n.description);

        return convertView;
    }
}

