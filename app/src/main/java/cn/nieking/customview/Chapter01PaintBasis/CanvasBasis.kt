package cn.nieking.customview.Chapter01PaintBasis

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CanvasBasis @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 画布设置背景颜色的三种方法
        canvas?.drawColor(0xFFFFFF)
        canvas?.drawARGB(0xFF, 0xFF, 0xFF, 0xFF)
        canvas?.drawRGB(0xFF, 0xFF, 0xFF)



        // 画直线
        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 50f

        canvas?.drawLine(100f, 100f, 200f, 200f, paint)

        // 画多条直线
        val paint2 = Paint()
        paint2.color = Color.RED
        paint2.strokeWidth = 5f

        val pts = floatArrayOf(10f, 10f, 100f, 100f, 200f, 200f, 400f, 400f)
        canvas?.drawLines(pts, paint2)

        val pts2 = floatArrayOf(10f, 10f, 100f, 100f, 200f, 200f, 400f, 400f)
        canvas?.drawLines(pts2, 2, 4, paint2) // 从索引为2的数字开始绘图，有4个数值参与绘图



        // 画点
        val paint3 = Paint()
        paint3.color = Color.GREEN
        paint3.strokeWidth = 15f
        canvas?.drawPoint(500f, 500f, paint3)

        // 画多个点
        val paint4 = Paint()
        paint4.color = Color.RED
        paint4.strokeWidth = 25f

        val pts3 = floatArrayOf(10f, 10f, 100f, 100f, 200f, 200f, 400f, 400f)
        val drawPoints = canvas?.drawPoints(pts3, 2, 4, paint4)



        // 矩形工具
        val paint5 = Paint()
        paint5.color = Color.RED
        paint5.style = Paint.Style.STROKE
        paint5.strokeWidth = 15f
        // 直接构造
        canvas?.drawRect(200f, 200f, 300f, 400f, paint5)
        // 使用RectF构造
        paint5.style = Paint.Style.FILL
        val rect = RectF(200f, 0f, 300f, 200f)
        canvas?.drawRect(rect, paint5)



        // 圆角矩形
        val paint6 = Paint()
        paint6.color = Color.GREEN
        paint6.style = Paint.Style.FILL
        paint6.strokeWidth = 15f

        val rect2 = RectF(500f, 500f, 800f, 700f)
        canvas?.drawRoundRect(rect2, 20f, 10f, paint6)


        // 圆形
        canvas?.drawCircle(100f, 700f, 100f, paint6)


        // 椭圆
        val paint7 = Paint()
        paint7.color = Color.RED
        paint7.style = Paint.Style.STROKE
        paint7.strokeWidth = 5f

        val rect3 = RectF(700f, 800f, 1000f, 1000f)
        canvas?.drawRect(rect3, paint7)
        paint7.color = Color.GREEN
        canvas?.drawOval(rect3, paint7)


        // 弧
        val paint8 = Paint()
        paint8.color = Color.RED
        paint8.style = Paint.Style.STROKE
        paint8.strokeWidth = 5f

        // 带两边
        val rect4 = RectF(10f, 1000f, 100f, 1090f)
        canvas?.drawArc(rect4, 0f, 90f, true, paint8)

        // 不带两边
        val rect5 = RectF(100f, 1000f, 190f, 1090f)
        paint8.style = Paint.Style.FILL
        canvas?.drawArc(rect5, 0f, 90f, false, paint8)
    }
}