package balti.myaddressapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import balti.myaddressapp.AdapterModule.SearchAdapter;
import balti.myaddressapp.MOdel.Contacts;

public class SearchActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    RecyclerView rv;
    LinearLayoutManager llm;
    ArrayList<Contacts> userlist;
    SearchAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);




        rv= (RecyclerView) findViewById(R.id.rv);
        llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);


        Contacts obj= new Contacts();
        obj.setName("Mehdi");
        obj.setPhoneNo("0347 5245268");
        obj.setEmail("mehdi.balti@syntecx.xom");
        obj.setId(1);

        userlist= new ArrayList<>();
        userlist.add(obj);

        obj.setName("Ali");

        userlist.add(obj);

        userlist.add(obj);
        obj.setName("Mehdi Balti");

        userlist.add(obj);
        userlist.add(obj);
        userlist.add(obj);
        userlist.add(obj);userlist.add(obj);
        userlist.add(obj);
        userlist.add(obj);userlist.add(obj);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search_user);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {
                adapter.filter(searchQuery.toString().trim());

                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                if (userlist.size()>=0){
                    adapter=new SearchAdapter(userlist,SearchActivity.this);
                    rv.setAdapter(adapter);}
                else
                    Toast.makeText(SearchActivity.this, "No one found at this time", Toast.LENGTH_SHORT).show();
                return true;  // Return true to expand action view
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search_user) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
