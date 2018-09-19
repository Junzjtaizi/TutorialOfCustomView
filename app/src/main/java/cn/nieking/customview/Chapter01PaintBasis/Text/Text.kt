package cn.nieking.customview.Chapter01PaintBasis.Text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Text @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    init {
//        // 文字绘制相关属性设置
//        paint.strokeWidth = 5f
//        paint.isAntiAlias = true
//        paint.style = Paint.Style.FILL
//        paint.textAlign = Paint.Align.CENTER    // 文字对齐方式 Align.LEFT 活 Align.RIGHT
//        paint.textSize = 12f
//
//        paint.isFakeBoldText = true   // 设置是否为粗体文字
//        paint.isUnderlineText = true  // 设置下划线
//        paint.textSkewX = -0.25f      // 设置字体倾斜度
//        paint.isStrikeThruText = true // 设置字体删除线
//
//        paint.textScaleX = 2f         // 设置字体水平方向拉伸
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.strokeWidth = 5f
        paint.isAntiAlias = true
        paint.textSize = 60f

        // 绘图样式，设置为填充
//        paint.style = Paint.Style.FILL
//        paint.style = Paint.Style.STROKE
        paint.style = Paint.Style.FILL_AND_STROKE
//        canvas.drawText("床前明月光", 10f, 100f, paint)

        paint.textSize = 80f
        paint.textAlign = Paint.Align.RIGHT
        canvas.drawText("床前明月光", 400f, 100f, paint)
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText("床前明月光", 400f, 200f, paint)
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText("床前明月光", 400f, 300f, paint)

        paint.isFakeBoldText = true   // 设置粗体文字
        paint.isUnderlineText = true  // 设置下划线
        paint.isStrikeThruText = true // 设置删除线
        canvas.drawText("床前明月光", 400f, 400f, paint)


        paint.textSkewX = -0.25f   // 向右倾斜
        canvas.drawText("床前明月光", 400f, 500f, paint)
        paint.textSkewX = 0.25f    // 向左倾斜
        canvas.drawText("床前明月光", 400f, 600f, paint)


        paint.textScaleX = 2f   // 拉伸2倍
        canvas.drawText("床前明月光", 400f, 700f, paint)
    }
}