package cn.nieking.customview.Chapter01PaintBasis.Text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class Typeface @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val text = "床前明月光"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.typeface = Typeface.SERIF
        paint.textSize = 50f

        canvas.drawText(text, 10f, 100f, paint)

        // Typeface.NORMAL         正常字体
        // Typeface.BOLD           粗体
        // Typeface.ITALIC         斜体
        // Typeface.BOLD_NORMAL    粗斜体
        val typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC)
        paint.typeface = typeface
        paint.textSize = 50f
        canvas.drawText(text, 10f, 200f, paint)


        val familyName = "宋体"
        val font = Typeface.create(familyName, Typeface.NORMAL)
        paint.typeface = font
        canvas.drawText(text, 10f, 300f, paint)


        // 自定义字体样式
        // val mgr = applicationContext.assets
        // val typeface = Typeface.createFromAsset(mgr, "fonts/jian_luobo.ttf")
        // paint.typeface = typeface
        // canvas.drawText(text, 10f, 400f, paint)
    }
}