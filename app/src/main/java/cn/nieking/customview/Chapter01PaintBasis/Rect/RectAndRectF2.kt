package cn.nieking.customview.Chapter01PaintBasis.Rect

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.orhanobut.logger.Logger

class RectAndRectF2 @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 合并两个矩形
        val paint = Paint()
        paint.style = Paint.Style.STROKE
        val rect_1 = Rect(10, 10, 20, 20)
        val rect_2 = Rect(100, 100, 110, 110)

        paint.color = Color.RED
        canvas.drawRect(rect_1, paint)
        paint.color = Color.GREEN
        canvas.drawRect(rect_2, paint)

        // 画出合并之后的结果
        paint.color = Color.YELLOW
        rect_1.union(rect_2)
        canvas.drawRect(rect_1, paint)

        // 合并矩形与某个点
        var rect_3 = Rect(10, 10, 20, 20)
        rect_3.union(100, 100)
        Logger.d(rect_3.toShortString())

        rect_3 = Rect()
        rect_3.union(100, 100)
        Logger.d(rect_3.toShortString())
    }
}