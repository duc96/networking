package com.example.gojobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gojobs.view.fragment.BillFragment;
import com.example.gojobs.view.fragment.ProductFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    /**
     * bán sản phẩm online (giày và xe = > 2 project)
     * <p>
     * đăng kí đăng nhập (id và tài khoản)
     * màn hình home -> draw navigation, tool bar, view pager + tab layout (phân loại mặt hàng cần bán)
     */

    private DrawerLayout mDrawerLayout;
    private FragmentManager fragmentManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItem();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ProductFragment productFragment = new ProductFragment();
        transaction.replace(R.id.content_frame, productFragment)
                .commit();

        createNaviDraw();
    }

    /**
     * map all item on screen
     */
    private void initItem() {
        fragmentManager = getSupportFragmentManager();
        mDrawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
    }

    /**
     * create draw navigation menu left
     */
    private void createNaviDraw() {

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        NavigationView navigationView = findViewById(R.id.navi_draw__home_left);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_home:
                                Toast.makeText(MainActivity.this, "product fragment", Toast.LENGTH_SHORT).show();
                                ProductFragment productFragment = new ProductFragment();
                                transaction.replace(R.id.content_frame, productFragment)
                                        .commit();
                                break;
                            case R.id.nav_card:
                                Toast.makeText(MainActivity.this, "bill fragment", Toast.LENGTH_SHORT).show();
                                BillFragment billFragment = new BillFragment();
                                transaction.replace(R.id.content_frame, billFragment)
                                        .commit();
                                break;
                            default:
                                break;
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}