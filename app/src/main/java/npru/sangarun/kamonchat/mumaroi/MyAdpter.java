package npru.sangarun.kamonchat.mumaroi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 13/11/2558.
 */
public class MyAdpter extends BaseAdapter{

    //Explicit
    private Context objContext;
    private String[] nameString, typeSring;
    private  int[] iconInts;

    public MyAdpter(Context objContext, String[] nameString, String[] typeSring, int[] iconInts) {
        this.objContext = objContext;
        this.nameString = nameString;
        this.typeSring = typeSring;
        this.iconInts = iconInts;
    }   // Contructor

    @Override
    public int getCount() {
        return nameString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView = objLayoutInflater.inflate(R.layout.my_listview,parent, false);
        //Setup Name
        TextView nameTextView = (TextView) objView.findViewById(R.id.txtListName);
        nameTextView.setText(nameString[position]);

        //Setup Type
        TextView TypeTextView = (TextView) objView.findViewById(R.id.txtListType);
        TypeTextView.setText(typeSring[position]);

        //Setup Icon

        ImageView icomImageView = (ImageView) objView.findViewById(R.id.imvIcon);
        icomImageView.setImageResource(iconInts[position]);


        return objView;
    }
}    // Main Class
