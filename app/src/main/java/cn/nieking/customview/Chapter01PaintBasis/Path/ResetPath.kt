package cn.nieking.customview.Chapter01PaintBasis.Path

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class ResetPath @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10f

        // reset
        val path = Path()
        path.fillType = Path.FillType.INVERSE_WINDING
        path.reset()
        path.addCircle(100f, 100f, 50f, Path.Direction.CW)
        canvas.drawPath(path, paint)

        // rewind
        val path2 = Path()
        path.fillType = Path.FillType.INVERSE_WINDING
        path.rewind()
        path.addCircle(200f, 100f, 50f, Path.Direction.CW)
        canvas.drawPath(path, paint)
    }
}