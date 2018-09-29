package cn.nieking.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import cn.nieking.customview.Chapter01PaintBasis.CustomViewExm.CustomView
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())

        // 动态添加控件
        val customView = CustomView(this)
//        val layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT)

//        val layoutParams = RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT)
//        layoutParams.addRule(RelativeLayout.RIGHT_OF, R.id.text)

//        // 设置 margin
//        val layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT)
//        layoutParams.setMargins(10, 20, 30, 40)

//        // 设置 layout_weight
//        val tvLike = TextView(this)
//        val layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                1f
//        )
//        tvLike.text = "赞（8）"
//        tvLike.textSize = 16f
//
//        // 设置 layout_weight
//        layoutParams.weight = 1f

        // 设置 layout_gravity
//        val layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
//        )
//        layoutParams.gravity = Gravity.TOP
//        val button = Button(this)

        // 设置 android:gravity
        val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                200
        )
        layoutParams.addRule(RelativeLayout.RIGHT_OF, R.id.text)

        val button = Button(this)
        button.gravity = Gravity.TOP
        button.text = "btn"

        rootView.addView(button, layoutParams)
        rootView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
    }
}
