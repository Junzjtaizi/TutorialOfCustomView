package cn.nieking.customview.Chapter01PaintBasis.Path

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Path1 @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        // 画线
        val path = Path()
        path.moveTo(10f, 10f)
        path.lineTo(10f, 100f)
        path.lineTo(300f, 100f)
        path.close()

        canvas.drawPath(path, paint)

        // 画三角形
        val path2 = Path()
        path.moveTo(10f, 10f)
        path.lineTo(10f, 100f)
        path.lineTo(300f, 100f)
        path.close()

        canvas.drawPath(path, paint)
    }
}