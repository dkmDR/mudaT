package com.itla.mudat.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Banner;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Miguel Peralta on 12/9/2017.
 */

public class BannerList extends BaseAdapter {

    List<Banner> banner;
    Activity context;

    public BannerList(List<Banner> banner, Activity context) {
        this.banner = banner;
        this.context = context;
    }

    @Override
    public int getCount() {
        return banner.size();
    }

    @Override
    public Object getItem(int i) {
        return banner.get(i);
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

        TextView tb = (TextView) view.findViewById(R.id.title_banner);
        TextView pb = (TextView) view.findViewById(R.id.price_banner);
        TextView db = (TextView) view.findViewById(R.id.details_banner);

        Banner b = banner.get(i);

        tb.setText(b.getTitle());
//        pb.setText(  b.getPrice() );

        return view;

    }
}
