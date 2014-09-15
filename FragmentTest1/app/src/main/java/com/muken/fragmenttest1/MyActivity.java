package com.muken.fragmenttest1;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;



public class MyActivity extends Activity
        implements BookListFragment.OnSelectedBookChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectedBookChanged(int bookIndex) {
        // Access the FragmentManager
        FragmentManager fragmentManager = getFragmentManager();
        // Get the book description fragment
        BookDescFragment bookDescFragment = (BookDescFragment)
                fragmentManager.findFragmentById
                        (R.id.fragmentDescription);
        // Display the book title
        // Check validity of fragment reference
        if(bookDescFragment == null || !bookDescFragment.isVisible()){
            // Use activity to display description
            Intent intent = new Intent(this, BookDescActivity.class);
            intent.putExtra("bookIndex", bookIndex);
            startActivity(intent);
        }else {
            //if(bookDescFragment != null)
            bookDescFragment.setBook(bookIndex);
        }
    }


}
