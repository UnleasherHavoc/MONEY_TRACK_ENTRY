package com.example.application.account;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BAIG1995 on 1/16/2017.
 */

public class CustomAdaptor  extends ArrayAdapter<String> {


    public CustomAdaptor(Context context,String Names[]) {
        super(context,R.layout.customadaptor,Names);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View customview =layoutInflater.inflate(R.layout.customadaptor,parent,false);

        //reference
        TextView textView=(TextView)customview.findViewById(R.id.textView2);
        ImageView imageView=(ImageView)customview.findViewById(R.id.img);
        String ft=getItem(position);
        TextView amt=(TextView)customview.findViewById(R.id.textView4);

        Context context=getContext();
        DatabaseHandler  handler=new DatabaseHandler(context,null,null,1);

try{
        if(ft.equals("CLIENT 1")) {
            textView.setText(ft);
            amt.setText("RS"+"\n"+handler.get_totalamount1(ft));


        }
        else if(ft.equals("CLIENT 2")){ textView.setText(ft);
            amt.setText("RS"+"\n"+handler.get_totalamount1(ft));


        }

        else if(ft.equals("CLIENT 3")){ textView.setText(ft);
            amt.setText("RS"+"\n"+handler.get_totalamount1(ft));


        }
        else if(ft.equals("CLIENT 4")){ textView.setText(ft);
            amt.setText("RS"+"\n"+handler.get_totalamount1(ft));


        }


        else  if (ft.equals("CLIENT 5")){textView.setText(ft);
            amt.setText("RS"+"\n"+handler.get_totalamount1(ft));



        }
        else  if (ft.equals("TOTAL")){textView.setText(ft);
            amt.setText("RS"+"\n"+handler.get_totalamount());
            imageView.setImageResource(R.drawable.total);

        }}catch (Exception e){}




        return customview;






    }
}
