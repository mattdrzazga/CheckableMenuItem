package example.com.favoritemenuitem

import android.view.MenuItem
import android.widget.Checkable

class CheckableMenuItem(private val menuItem: MenuItem) {
    private val checkableFrameLayout = menuItem.actionView as Checkable

    var checked: Boolean
        get() = menuItem.isChecked
        set(value) {
            menuItem.isChecked = value
            checkableFrameLayout.isChecked = value
        }
}
