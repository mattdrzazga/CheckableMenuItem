package example.com.favoritemenuitem

import android.content.Context
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.favorite_button.view.*


class CheckableFrameLayout : FrameLayout, Checkable {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private val CHECKED_STATE_SET = intArrayOf(android.R.attr.state_checked)

    private var checked = false

    override fun isChecked() = checked

    override fun toggle() {
        checked = !checked
    }

    override fun setChecked(checked: Boolean) {
        if (this.checked != checked) {
            this.checked = checked
            refreshDrawableState()
            showRipple(ripple, ripple.width / 2, ripple.height / 2)
        }
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        if (checked) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET)
        }
        return drawableState
    }

    private fun showRipple(view: View, x: Int, y: Int) {
        val background = view.background
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && background is RippleDrawable) {
            background.setHotspot(x.toFloat(), y.toFloat())
        }
        view.isPressed = true
        // For a quick ripple, you can immediately set false.
        view.isPressed = false
    }
}
