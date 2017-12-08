package com.itla.mudat.Adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Category;
import com.itla.mudat.Entity.User;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by mpcdr on 12/7/2017.
 */

public class CategoriesList extends BaseAdapter {

    List<Category> categories;
    Activity activity;

    public CategoriesList(List<Category> categories, Activity activity) {
        this.categories = categories;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if ( view == null ) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.category_list_row, null);
        }

        TextView na = (TextView) view.findViewById(R.id.category_name_in_row);

        Category c = categories.get(i);

        na.setText(c.getName());

        return view;

    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
