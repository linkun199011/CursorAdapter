package com.example.cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
	private static final String TAG = MyCursorAdapter.class.getSimpleName();

	private LayoutInflater inflater;

	public MyCursorAdapter(Context context, Cursor c) {
		super(context, c);
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LinearLayout linearLayout = (LinearLayout) inflater.inflate(
				R.layout.lsit_item, null);
		TextView textView = (TextView) linearLayout.findViewById(R.id.name);
		textView.setText(cursor.getString(cursor
				.getColumnIndex(Contacts.DISPLAY_NAME)));
		Log.i(TAG, "newView: " + linearLayout);
		return linearLayout;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		LinearLayout linearLayout = (LinearLayout) view;
		TextView textView = (TextView) linearLayout.findViewById(R.id.name);
		textView.setText(cursor.getString(cursor
				.getColumnIndex(Contacts.DISPLAY_NAME)));
		Log.i(TAG, "bindView: " + linearLayout);
	}

}
