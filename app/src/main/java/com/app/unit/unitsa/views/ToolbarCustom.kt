package com.app.unit.unitsa.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.navigation.findNavController
import com.app.unit.unitsa.R
import com.app.unit.unitsa.databinding.ToolbarBinding
import com.app.unit.unitsa.extensions.hideKeyboard
import com.app.unit.unitsa.extensions.setIconTint

class ToolbarCustom(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    private lateinit var binding: ToolbarBinding

    init {
        initViews()
    }

    private fun initViews() {
        binding = ToolbarBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setToolbarBackground(@ColorRes color: Int): ToolbarCustom {
        binding.root.setBackgroundColor(ContextCompat.getColor(context, color))
        return this
    }

    fun setToolbarImage(@DrawableRes drawable: Int): ToolbarCustom {
        binding.centerToolbarImage.apply {
            setImageResource(drawable)
            visibility = View.VISIBLE
        }
        return this
    }

    fun setLeftIcon(@DrawableRes icon: Int): ToolbarCustom {
        binding.icLeftIcon.apply {
            setImageResource(icon)
            visibility = View.VISIBLE
        }
        return this
    }

    fun setLeftIconClick(listener: OnClickListener): ToolbarCustom {
        binding.icLeftIcon.setOnClickListener(listener)
        return this
    }

    fun setRightIcon(@DrawableRes icon: Int, @ColorRes color: Int = -1): ToolbarCustom {
        binding.icRightIcon.apply {
            setImageResource(icon)
            if (color != -1) {
                setIconTint(color)
            }
            visibility = View.VISIBLE
        }
        return this
    }

    fun setOnRightIconClick(listener: (view: View) -> Unit?): ToolbarCustom {
        binding.icRightIcon.setOnClickListener {
            listener.invoke(it)
        }
        return this
    }

    fun setSecondaryRightIcon(
        @DrawableRes icon: Int,
        @ColorRes color: Int = R.color.black
    ): ToolbarCustom {
        binding.icRightIconSecondary.apply {
            setImageResource(icon)
            DrawableCompat.setTint(
                DrawableCompat.wrap(this.drawable),
                ContextCompat.getColor(context, color)
            )
            visibility = View.VISIBLE
        }
        return this
    }

    fun setOnSecondaryRightIconClick(action: () -> Unit): ToolbarCustom {
        binding.icRightIconSecondary.setOnClickListener {
            action.invoke()
        }
        return this
    }

    fun setToolbarTitle(
        @StringRes title: Int,
        @ColorRes color: Int = R.color.dark_gray
    ): ToolbarCustom {
        binding.txtToolbarTitle.apply {
            setText(title)
            setTextColor(ContextCompat.getColor(context, color))
            visibility = View.VISIBLE
        }
        return this
    }

    fun setToolbarTitle(
        title: String,
        @ColorRes color: Int = R.color.dark_gray
    ): ToolbarCustom {
        binding.txtToolbarTitle.apply {
            text = title
            setTextColor(ContextCompat.getColor(context, color))
            visibility = View.VISIBLE
        }
        return this
    }

    fun setToolbarLeftTitle(
        @StringRes res: Int = -1,
        title: String = "",
        @ColorRes color: Int = R.color.dark_gray
    ): ToolbarCustom {
        binding.tvLeftTitle.apply {
            if (res == -1) {
                text = title
            } else {
                setText(res)
            }
            setTextColor(ContextCompat.getColor(context, color))
            visibility = View.VISIBLE
        }

        return this
    }

    fun setRightTitle(
        @StringRes titleRes: Int = -1,
        title: String = "",
        @ColorRes color: Int = R.color.dark_gray,
        @DrawableRes icon: Int = -1
    ): ToolbarCustom {
        binding.tvRightTitle.apply {
            if (titleRes == -1) {
                text = title
            } else {
                setText(titleRes)
            }
            if (icon != -1) {
                setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
            }
            setTextColor(ContextCompat.getColor(context, color))
            visibility = View.VISIBLE
        }
        return this
    }

    fun setRightTitleClick(action: () -> Unit): ToolbarCustom {
        binding.tvRightTitle.setOnClickListener {
            action.invoke()
        }
        return this
    }

    fun enableBackIcon(): ToolbarCustom {
        binding.icBackIcon.apply {
            setImageResource(R.drawable.ic_back)
            visibility = View.VISIBLE
            setOnClickListener {
                (it.parent as View).hideKeyboard()
                it.findNavController().navigateUp()
            }
        }
        return this
    }

    fun setBackIcon(@DrawableRes icon: Int): ToolbarCustom {
        binding.icBackIcon.apply {
            setImageResource(icon)
            visibility = View.VISIBLE
            setOnClickListener {
                (it.parent as View).hideKeyboard()
                it.findNavController().navigateUp()
            }
        }
        return this
    }

    fun setOnBackClick(action: () -> Unit): ToolbarCustom {
        binding.icBackIcon.setOnClickListener {
            action.invoke()
        }
        return this
    }
}