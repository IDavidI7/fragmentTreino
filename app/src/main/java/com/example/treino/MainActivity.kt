package com.example.treino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), OnClickListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var buttonHome: Button
    lateinit var buttonGame: Button
    lateinit var buttonMenu: Button

    lateinit var gameFragment: GameFragment
    lateinit var menuFragment: MenuFragment
    lateinit var homeFragment: HomeFragment

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHome = findViewById(R.id.home)
        buttonHome.setOnClickListener(this)

        buttonGame = findViewById(R.id.games)
        buttonGame.setOnClickListener(this)

        buttonMenu = findViewById(R.id.menu)
        buttonMenu.setOnClickListener(this)



        gameFragment = GameFragment()
        menuFragment = MenuFragment()
        homeFragment = HomeFragment()




        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)


    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragment, fragment)
        fragmentTransition.commit()
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.menu -> {
                setFragment(menuFragment)
            }
            R.id.home -> {
                setFragment(homeFragment)
            }
            R.id.games -> {
                setFragment(gameFragment)
            }

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_games ->
                setFragment(gameFragment)
            R.id.menu_home ->
                setFragment(homeFragment)
            R.id.menu_menu ->
                setFragment(menuFragment)
        }

        return true

    }

}


