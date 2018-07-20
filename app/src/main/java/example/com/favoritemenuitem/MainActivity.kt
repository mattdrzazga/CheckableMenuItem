package example.com.favoritemenuitem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.TooltipCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private lateinit var favoriteMenuItem: CheckableMenuItem

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            favoriteMenuItem.checked = !favoriteMenuItem.checked
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        favoriteMenuItem = CheckableMenuItem(menu.findItem(R.id.favoriteAction))
        menu.findItem(R.id.favoriteAction).run {
            TooltipCompat.setTooltipText(actionView, title)
            actionView.setOnClickListener {
                onOptionsItemSelected(this)
            }
        }
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.v(TAG, "item: ${item.itemId}")
        when (item.itemId) {
            R.id.favoriteAction -> {
                with(item) {
                    favoriteMenuItem.checked = !isChecked
                }
            }
            R.id.favoriteAction2 -> {
                with(item) {
                    isChecked = !isChecked
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
