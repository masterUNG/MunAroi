package npru.sangarun.kamonchat.mumaroi;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    public void clickUpdateRemark(View view) {

        remarkString = remarkEditText.getText().toString().trim();

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_question);
        objBuilder.setTitle("กรุณาตรวจสอบ");
        objBuilder.setMessage("คุณต้องการ Remark ==> " + "\n" + remarkString);
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editSQLite();
                dialogInterface.dismiss();
            }
        });
        objBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();

    }   // clickUpdateRemark

    private void editSQLite() {

        //Delete & Read Where Name = nameString
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("aroi.db", MODE_PRIVATE, null);

        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM restaurantTABLE WHERE Name = " + "'" + nameString + "'", null);
        objCursor.moveToFirst();
        String strType = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_TYPE));
        String strName = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_NAME));
        String strImage = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_IMAGE));
        String strDetail = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_DETAIL));
        String strPotential = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_POTENTIAL));
        String strLat = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_LAT));
        String strLng = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUMN_LNG));
        objCursor.close();

        objSqLiteDatabase.delete("restaurantTABLE", "Name = " + "'" + nameString + "'", null);

        //UPDATE SQLite
        ManageTABLE objManageTABLE = new ManageTABLE(this);
        objManageTABLE.addValueToSQLite(strType, strName, strImage, strDetail, strPotential, strLat, strLng, remarkString);

    }   // editSQLite


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
        objCursor.close();
    }

    private void bindWidget() {
        nameTextView = (TextView) findViewById(R.id.textView8);
        remarkEditText = (EditText) findViewById(R.id.editText);
    }

}   // Main Class
