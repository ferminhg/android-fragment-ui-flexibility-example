package com.muken.fragmenttest1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by muken on 15/09/14.
 */
public class BookListFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        // Translate radio button to book index
        int bookIndex = translateIdToIndex(id);
        // Get parent Activity and send notification
        OnSelectedBookChangeListener listener =
                (OnSelectedBookChangeListener) getActivity();
        listener.onSelectedBookChanged(bookIndex);
    }

    public interface OnSelectedBookChangeListener {
        void onSelectedBookChanged(int bookIndex);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        View viewHierarchy =
            inflater.inflate(R.layout.fragment_book_list,
                    container, false);

        // Connect the listener to the radio group
        RadioGroup group = (RadioGroup)
                viewHierarchy.findViewById(R.id.bookSelectGroup);
        group.setOnCheckedChangeListener(this);

        return viewHierarchy;
    }



    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.android1:
                index = 0 ;
                break;
            case R.id.android2:
                index = 1 ;
                break;
            case R.id.android3:
                index = 2 ;
                break;
            case R.id.android4:
                index = 3 ;
                break;
        }
        return index;
    }
}
