package cn.nieking.customview.Chapter01PaintBasis.Path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class FillType @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // FillType.WINDING          默认值，当两个图形相交时，取相交部分显示
        // FillType.EVEN_ODD         取path所在不相交的区域
        // FillType.INVERSE_WINDING  取path的外部区域
        // FillType.INVERSE_EVEN_ODD 取path的外部和相交区域

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        val path = Path()
        path.addRect(100f, 100f, 300f, 300f, Path.Direction.CW)
        path.addCircle(300f, 300f, 100f, Path.Direction.CW)
//        path.fillType = Path.FillType.WINDING
//        path.fillType = Path.FillType.EVEN_ODD
        path.fillType = Path.FillType.INVERSE_WINDING
//        path.fillType = Path.FillType.INVERSE_EVEN_ODD
        canvas.drawPath(path, paint)
    }
}