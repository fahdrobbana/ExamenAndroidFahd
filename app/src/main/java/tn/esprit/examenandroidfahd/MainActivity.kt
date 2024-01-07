package tn.esprit.examenandroidfahd

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import tn.esprit.examenandroidfahd.databinding.ActivityMainBinding
import tn.esprit.examenandroidfahd.fragment.MovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar.appBar
        setSupportActionBar(toolbar)
        binding.btnMovie.setOnClickListener {
            changeFragment(MovieFragment(), "")
        }

    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        else
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(name)
                .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("Are you sure you want to logout ?")
                builder.setPositiveButton("Yes"){ _, _ ->
                    val mSharedPreferences: SharedPreferences = getSharedPreferences("pref", MODE_PRIVATE)
                    mSharedPreferences.edit().clear().apply()

                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}