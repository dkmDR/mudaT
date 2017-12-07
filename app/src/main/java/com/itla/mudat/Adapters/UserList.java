package com.itla.mudat.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.User;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Miguel Peralta on 12/2/2017.
 */

public class UserList extends BaseAdapter {

    List<User> users;
    Activity context;

    public UserList(List<User> users, Activity context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if ( view == null ) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.row_user_list, null);
        }

        TextView na = (TextView) view.findViewById(R.id.userNameRow);
        TextView em = (TextView) view.findViewById(R.id.userEmailRow);

        User u = users.get(i);

        na.setText(u.getName());
        em.setText(u.getEmail());

        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
