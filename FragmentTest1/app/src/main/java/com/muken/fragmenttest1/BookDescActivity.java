package com.muken.fragmenttest1;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by muken on 15/09/14.
 */
public class BookDescActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_desc);
        // Retrieve the book index from the Activity Intent
        Intent intent = getIntent();
        int bookIndex = intent.getIntExtra("bookIndex", -1);
        if (bookIndex != -1) {
            // Use FragmentManager to access BookDescFragment
            FragmentManager fm = getFragmentManager();
            BookDescFragment bookDescFragment = (BookDescFragment) fm.findFragmentById(R.id.fragmentDescription);
            // Display the book title
            bookDescFragment.setBook(bookIndex);
        }
    }
}
