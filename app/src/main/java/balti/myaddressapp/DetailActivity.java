package balti.myaddressapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import balti.myaddressapp.LocalDb.TableControllerContact;
import balti.myaddressapp.MOdel.Contacts;

public class DetailActivity extends AppCompatActivity {
ImageView imginitials;
    TextView Name,Number,Mail,AddToFriend,AddToFamily;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdetailacly);

        imginitials= (ImageView) findViewById(R.id.detailini);

        Name= (TextView) findViewById(R.id.name);

Number= (TextView) findViewById(R.id.numberdd);
Mail= (TextView) findViewById(R.id.gmaildd);


        AddToFriend= (TextView) findViewById(R.id.addTofriend);

        AddToFamily= (TextView) findViewById(R.id.addTofamily);


        AddToFamily.setOnClickListener(new CHangeTypeListner());
AddToFriend.setOnClickListener(new CHangeTypeListner());



        Intent v= getIntent();
       Name.setText( v.getStringExtra("name"));
        Number.setText(v.getStringExtra("number"));
        Mail.setText(v.getStringExtra("email"));

        id=v.getStringExtra("id");





        String fullname=Name.getText().toString().toUpperCase();




        //  StringBuilder initials = new StringBuilder();
        // for (String s : fullname.split(" ")) {
        //     initials.append(s.charAt(0));
        // }

        Character initials=fullname.charAt(0);


        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
// generate random color
        int color1 = generator.getRandomColor();
// generate color based on a key (same key returns the same color), useful for list/grid views
        int color2 = generator.getColor("user@gmail.com");




        TextDrawable drawable3 = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.DEFAULT)
                .fontSize(80) /* size in px */
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound(initials.toString(), color1);



        imginitials.setImageDrawable(drawable3);



    }

    private class CHangeTypeListner implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if (view.getId()==R.id.addTofamily) {
                Contacts obj = new Contacts();
                obj.setId(Integer.parseInt(id));
                obj.setName(Name.getText().toString());
                obj.setPhoneNo(Number.getText().toString());
                obj.setEmail(Mail.getText().toString());
                obj.setType("1");
              Boolean  res = new TableControllerContact(DetailActivity.this).updatetype(obj);
                if (res){

                    Toast.makeText(DetailActivity.this, "Added to family", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Contacts obj = new Contacts();
                obj.setId(Integer.parseInt(id));
                obj.setName(Name.getText().toString());
                obj.setPhoneNo(Number.getText().toString());
                obj.setEmail(Mail.getText().toString());
                obj.setType("2");
                Boolean  res = new TableControllerContact(DetailActivity.this).updatetype(obj);
                if (res){

                    Toast.makeText(DetailActivity.this, "Added to friend", Toast.LENGTH_SHORT).show();
                }

            }

        }
    }
}
