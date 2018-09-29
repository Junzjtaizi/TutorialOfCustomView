package cn.nieking.customview.Chapter01PaintBasis.Canvas

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Canvas3 @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.RED)
        val c1 = canvas.save()

        canvas.clipRect(Rect(100, 100, 800, 800))
        canvas.drawColor(Color.GREEN)
        val c2 = canvas.save()

        canvas.clipRect(Rect(200, 200, 700, 700))
        canvas.drawColor(Color.GREEN)
        val c3 = canvas.save()

        canvas.clipRect(Rect(300, 300, 600, 600))
        canvas.drawColor(Color.GREEN)
        val c4 = canvas.save()

        canvas.clipRect(Rect(400, 400, 500, 500))
        canvas.drawColor(Color.WHITE)

        // 连续三次出栈，将最后一次出战的画布状态作为当前画布，并填充为黄色
        canvas.restoreToCount(c2)
        canvas.drawColor(Color.YELLOW)
    }
}