package cn.nieking.customview.Chapter01PaintBasis.Path

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Path2 @JvmOverloads constructor(
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

        // 画弧线
        val path = Path()
        path.moveTo(10f, 10f)
        val rectF = RectF(100f, 10f, 200f, 100f)
        path.arcTo(rectF, 0f, 90f, true)

        canvas.drawPath(path, paint)

        // 添加
        path.moveTo(10f, 10f)
        path.lineTo(100f, 50f)
        val rectF2 = RectF(100f, 100f, 150f, 150f)
        path.addArc(rectF2, 0f, 90f)
        canvas.drawPath(path, paint)

        // 添加矩形路径

    }
}