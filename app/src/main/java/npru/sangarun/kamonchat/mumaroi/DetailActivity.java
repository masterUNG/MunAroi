package npru.sangarun.kamonchat.mumaroi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private String typeString, nameString, detailString,
            potentialString, latString, lngString, remarkString;
    private int imageAnInt;
    private ImageView imageView;
    private TextView nameTextView, typeTextView, detailTextView, potentailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Widget
        bindWidget();

        //Receive From Intent
        receiveFromIntent();

        //Show View
        showView();


    }   // onCreate

    private void showView() {
        imageView.setImageResource(imageAnInt);
        nameTextView.setText(nameString);
        typeTextView.setText(typeString);
        detailTextView.setText(detailString);
        potentailTextView.setText(potentialString);

    }

    private void bindWidget() {
        imageView = (ImageView) findViewById(R.id.imageView2);
        nameTextView = (TextView) findViewById(R.id.textView2);
        typeTextView = (TextView) findViewById(R.id.textView3);
        detailTextView = (TextView) findViewById(R.id.textView6);
        potentailTextView = (TextView) findViewById(R.id.textView7);


    }

    private void receiveFromIntent() {
        typeString = getIntent().getStringExtra("Type");
        nameString = getIntent().getStringExtra("Name");
        imageAnInt = getIntent().getIntExtra("Image", R.drawable.food1);
        detailString = getIntent().getStringExtra("Detail");
        potentialString = getIntent().getStringExtra("Potential");
        latString = getIntent().getStringExtra("Lat");
        lngString = getIntent().getStringExtra("Lng");
        remarkString = getIntent().getStringExtra("Remark");

        Log.d("aoi", typeString);
        Log.d("aoi", nameString);


    }

}   // Main Class
