package com.example.cursoradapter;

import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.app.ListActivity;
import android.database.Cursor;
import android.view.Menu;

public class MainActivity extends ListActivity {
	private static final String[] PROJECTION = new String[] { Contacts._ID,
			Contacts.DISPLAY_NAME };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Cursor cursor = getContentResolver().query(Contacts.CONTENT_URI,
				PROJECTION, null, null, null);
		startManagingCursor(cursor);
		setListAdapter(new MyCursorAdapter(getApplicationContext(), cursor));
	}

}
