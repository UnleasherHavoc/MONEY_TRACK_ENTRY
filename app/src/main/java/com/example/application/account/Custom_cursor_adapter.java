package com.example.application.account;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by BAIG1995 on 1/21/2017.
 */

public class Custom_cursor_adapter extends CursorAdapter {

    public Custom_cursor_adapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView sno=(TextView)view.findViewById(R.id.sno);
        sno.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0))));
        TextView Date=(TextView)view.findViewById(R.id.date);
       Date.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
        TextView AMount=(TextView)view.findViewById(R.id.camount);

        AMount.setText("RS"+" "+cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));



    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View customview =layoutInflater.inflate(R.layout.custom_cusror_adaptor,parent,false);

        return customview;
    }

}