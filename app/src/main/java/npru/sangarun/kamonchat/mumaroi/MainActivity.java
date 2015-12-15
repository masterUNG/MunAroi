package npru.sangarun.kamonchat.mumaroi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Explicit
    private ManageTABLE objManageTABLE;
    private Spinner typeSpinner;
    private Button toAllBotton;
    private int indexAnInt, spinnerAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindwidget();

        //REquest Database
        objManageTABLE = new ManageTABLE(this);

        //Create Spinner
        createSpinner();


        //Botton Controllre
        buttoncontrollre();
    }   // Main Method

    private void buttoncontrollre() {
        toAllBotton.setOnClickListener(this);
    }

    private void bindwidget() {
        toAllBotton = (Button) findViewById(R.id.button2);
    }


    private void createSpinner() {


        typeSpinner = (Spinner) findViewById(R.id.spinner);
        String[] strType = getResources().getStringArray(R.array.type);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strType);
        typeSpinner.setAdapter(typeAdapter);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerAnInt = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerAnInt = 0;

            }
        });

    }   // createSpinner


    @Override
    public void onClick(View v) {

        //Intent to RestaurantListView
        Intent objIntent = new Intent(MainActivity.this, RestaurList.class);
        objIntent.putExtra("index", spinnerAnInt);
        startActivity(objIntent);

    } // onClick
}   // Main Class
