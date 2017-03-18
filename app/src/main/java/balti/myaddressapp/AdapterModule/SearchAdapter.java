package balti.myaddressapp.AdapterModule;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import balti.myaddressapp.MOdel.Contacts;
import balti.myaddressapp.R;

/**
 * Created by BALTI on 8/22/2016.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ContactViewHolder> {


    public List<Contacts> parkingList;

    public Context context;
    public ArrayList<Contacts> arraylist;

    public SearchAdapter(List<Contacts> apps, Context context) {
        this.parkingList = apps;
        this.context = context;
        arraylist = new ArrayList<Contacts>();
        arraylist.addAll(parkingList);
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView id;

        TextView name;
        TextView number,Email;
        ImageView imgInitials;



        ContactViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
            Email= (TextView) itemView.findViewById(R.id.email);

            imgInitials = (ImageView) itemView.findViewById(R.id.image);


            itemView.setOnClickListener(new MyUseropenviewProfuleListener());
        }

        private class MyUseropenviewProfuleListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {

            }
        }
    }
    @Override
    public SearchAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactitemlayout, parent, false);
        ContactViewHolder cvh=new ContactViewHolder(v);
        return cvh;
    }




    @Override
    public void onBindViewHolder(SearchAdapter.ContactViewHolder viewHolder, int position) {
        ContactViewHolder cvh=viewHolder;

     //   viewHolder.txtId.setText(parkingList.get(position).getId() + "");
      //  viewHolder.txt_name.setText(parkingList.get(position).getName() + "");
     //   viewHolder.txtGender.setText(parkingList.get(position).getGender());
     //  viewHolder.txtBldGroup.setText(parkingList.get(position).getBlodGroup());
        //  cvh.txt_ph.setText(contact.getMobile());
       // cvh.txt_name.setText(contact.getName());

        String fullname=parkingList.get(position).getName().toUpperCase();




        //  StringBuilder initials = new StringBuilder();
        // for (String s : fullname.split(" ")) {
        //     initials.append(s.charAt(0));
        // }

        Character initials=fullname.charAt(0);

        viewHolder.id.setText(parkingList.get(position).getId()+"");
        viewHolder.name.setText(parkingList.get(position).getName());
        viewHolder.number.setText(parkingList.get(position).getPhoneNo());
        viewHolder.Email.setText(parkingList.get(position).getEmail());


        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final CharSequence[] options = {"EDIT","DELETE","Cancel"};

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("TEAM");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("EDIT")) {




                        }
                        else if (options[item].equals("DELETE")) {


                        }
                        else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();


                return false;
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
        return parkingList.size();
    }


    public void filter(String charText) {


        charText = charText.toLowerCase(Locale.getDefault());

        parkingList.clear();
        if (charText.length() == 0) {
            parkingList.addAll(arraylist);

        } else {
            for (Contacts postDetail : arraylist) {
                if (charText.length() != 0 && postDetail.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    parkingList.add(postDetail);
                } else if (charText.length() != 0 && postDetail.getPhoneNo().toLowerCase(Locale.getDefault()).contains(charText)) {
                    parkingList.add(postDetail);
                }
            }
        }
        notifyDataSetChanged();

    }








}
