package balti.myaddressapp.AdapterModule;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

import balti.myaddressapp.DetailActivity;
import balti.myaddressapp.MOdel.Contacts;
import balti.myaddressapp.R;
import balti.myaddressapp.ShowFriendDetail;
import balti.myaddressapp.ShowfamilyDetail;

/**
 * Created by BALTI on 3/10/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {



    int rescode=0,pos;


    public Context mcontext;

    private List<Contacts> itemList;
    ProgressDialog pd;

    public ContactAdapter(List<Contacts> apps, Context context) {
        this.itemList = apps;
        this.mcontext = context;

    }


    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView id;

        TextView name;
        TextView number,Email;
        ImageView  imgInitials;


        ContactViewHolder(View itemView) {
            super(itemView);


            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
            Email= (TextView) itemView.findViewById(R.id.email);

            imgInitials = (ImageView) itemView.findViewById(R.id.image);



            imgInitials.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });


            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });

        }

    }



    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactitemlayout, parent, false);
        ContactAdapter.ContactViewHolder cvh=new ContactAdapter.ContactViewHolder(v);
        return cvh;
    }




    @Override
    public void onBindViewHolder(ContactAdapter.ContactViewHolder viewHolder, final int position) {
        ContactAdapter.ContactViewHolder cvh=viewHolder;

        pos=position;
        String fullname=itemList.get(position).getName().toUpperCase();




      //  StringBuilder initials = new StringBuilder();
       // for (String s : fullname.split(" ")) {
       //     initials.append(s.charAt(0));
       // }

        Character initials=fullname.charAt(0);

        viewHolder.id.setText(itemList.get(position).getId()+"");
        viewHolder.name.setText(itemList.get(position).getName());
        viewHolder.number.setText(itemList.get(position).getPhoneNo());
        viewHolder.Email.setText(itemList.get(position).getEmail());

viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

int id=itemList.get(position).getId();
        if (itemList.get(position).getType().equals("0")) {
            Intent i = new Intent(mcontext, DetailActivity.class);
            i.putExtra("name", itemList.get(position).getName());
            i.putExtra("number", itemList.get(position).getPhoneNo());
            i.putExtra("id", id + "");
            i.putExtra("email", itemList.get(position).getEmail());


            mcontext.startActivity(i);
        }
        else if (itemList.get(position).getType().equals("2")){
            Intent i = new Intent(mcontext, ShowFriendDetail.class);
            i.putExtra("name", itemList.get(position).getName());
            i.putExtra("number", itemList.get(position).getPhoneNo());
            i.putExtra("id", id + "");
            i.putExtra("email", itemList.get(position).getEmail());


            mcontext.startActivity(i);
        }
        else if (itemList.get(position).getType().equals("1")){
            Intent i = new Intent(mcontext, ShowfamilyDetail.class);
            i.putExtra("name", itemList.get(position).getName());
            i.putExtra("number", itemList.get(position).getPhoneNo());
            i.putExtra("id", id + "");
            i.putExtra("email", itemList.get(position).getEmail());


            mcontext.startActivity(i);
        }
    }
});



        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
// generate random color
        int color1 = generator.getRandomColor();
// generate color based on a key (same key returns the same color), useful for list/grid views
        int color2 = generator.getColor("user@gmail.com");




        TextDrawable drawable3 = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.WHITE)
                .useFont(Typeface.DEFAULT)
                .fontSize(50) /* size in px */
                .bold()
                .toUpperCase()
                .endConfig()
                .buildRound(initials.toString(), color1);


        viewHolder.imgInitials.setImageDrawable(drawable3);













    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
