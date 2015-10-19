package com.coderivium.sidorov.vadim.tweetsearch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bitmap sampleAvatar = BitmapFactory.decodeResource(getResources(), R.drawable.avatar_demo);

        List<TweetData> tweets = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            TweetData bufTweet = new TweetData(
                    sampleAvatar,
                    "@" + "durov",
                    "Pavel Durov",
                    "Working from Rome this week. @Rome, Italy https://instagram.com/p/9BDXa_L7bm/");
            tweets.add(bufTweet);
        }

        ListView listView = (ListView) findViewById(R.id.listView);

        TweetAdapter adapter = new TweetAdapter(this, R.layout.element_list, (ArrayList)tweets);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            SearchView searchView = (SearchView)findViewById(R.id.action_search);
            searchAction(searchView.getQuery().toString());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void searchAction(String searchString) {
        //placeholder
    }
}
