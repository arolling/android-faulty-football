package com.epicodus.faultyfootballleague.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.faultyfootballleague.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends DialogFragment implements TextView.OnEditorActionListener {
    @Bind(R.id.searchEditText) EditText mSearchEditText;

    public interface SearchDialogListener {
        void onFinishEditDialog(String inputText);
    }

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String title){
        SearchFragment frag = new SearchFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        String title = getArguments().getString("title", "Enter new category");
        getDialog().setTitle(title);
        mSearchEditText.setOnEditorActionListener(this);

        mSearchEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            SearchDialogListener listener = (SearchDialogListener) getActivity();
            listener.onFinishEditDialog(mSearchEditText.getText().toString());
            dismiss();
            return true;
        }
        return false;
    }
}
