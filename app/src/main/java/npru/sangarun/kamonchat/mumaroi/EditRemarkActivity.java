package npru.sangarun.kamonchat.mumaroi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditRemarkActivity extends AppCompatActivity {

    //Explicit
    private TextView nameTextView;
    private EditText remarkEditText;
    private String nameString, remarkString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_remark);

        //Bind Widget
        bindWidget();

        //Get Value
        getValue();

        //Show EditText
        showEditText();

    }   // Main Method

    public void clickClear(View view) {
        remarkEditText.setText("");
    }

    private void showEditText() {
        remarkEditText.setText(remarkString);
    }

    private void getValue() {
        nameString = getIntent().getStringExtra("Name");

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("aroi.db", MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM restaurantTABLE WHERE Name = " + "'" + nameString + "'", null);
        objCursor.moveToFirst();
        remarkString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_REMARK));

    }

    private void bindWidget() {
        nameTextView = (TextView) findViewById(R.id.textView8);
        remarkEditText = (EditText) findViewById(R.id.editText);
    }

}   // Main Class
