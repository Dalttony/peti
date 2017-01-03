package ext;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Samsung on 28/12/2016.
 */

public class CategoryPetiAdapter extends FragmentStatePagerAdapter {
    private ArrayList<JSONObject> tabs;
    public CategoryPetiAdapter(FragmentManager fm) {
        super(fm);
    }

    public CategoryPetiAdapter(FragmentManager fm, ArrayList<JSONObject> tabs){
        super(fm);
        this.tabs = tabs;
    }
    @Override
    public Fragment getItem(int position) {
        try {
            String idCategory = this.tabs.get(position).getString("idCategory");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.tabs.size();
    }
}
