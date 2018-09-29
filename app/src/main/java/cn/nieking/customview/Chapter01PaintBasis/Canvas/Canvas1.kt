package cn.nieking.customview.Chapter01PaintBasis.Canvas

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Canvas1 @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL

        // 平移
//        canvas.translate(100f, 100f)
//        val rect1 = Rect(0, 0, 400, 200)
//        canvas.drawRect(rect1, paint)

        /*
        画布并非屏幕。
        每次调用 drawXXX 系列函数来绘图时，都会产生一个全新的 Canvas1 透明图层
        如果调用 drawXXX 系列函数前，对画布进行平移、旋转等操作后，操作不可逆。
        Canvas1 图层与屏幕合成时，超出屏幕范围的图像是不会显示出来的。
         */

        // 旋转
        val paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)
        val paint_red = generatePaint(Color.RED, Paint.Style.STROKE, 5f)
//
//        val rect_1 = Rect(300, 10, 500, 100)
//        canvas.drawRect(rect_1, paint_red)
//        canvas.rotate(30f)
//        canvas.drawRect(rect_1, paint_green)

        // 缩放
//        val rect1 = Rect(10, 10, 200, 100)
//        canvas.drawRect(rect1, paint_green)
//        canvas.scale(0.5f, 1f)
//        canvas.drawRect(rect1, paint_red)

        // 扭曲
//        val rect1 = Rect(10, 10, 200, 100)
//        canvas.drawRect(rect1, paint_green)
//        canvas.skew(1.732f, 0f)  // 参数为角度的正切值 X轴倾斜60°，Y轴不变
//        canvas.drawRect(rect1, paint_red)

        // 裁剪
        canvas.drawColor(Color.RED)
        canvas.clipRect(Rect(100, 100, 200, 200))
        canvas.drawColor(Color.GREEN)
    }

    private fun generatePaint(color: Int, style: Paint.Style, width: Float): Paint {
        val paint = Paint()
        paint.color = color
        paint.style = style
        paint.strokeWidth = width
        return paint
    }
}