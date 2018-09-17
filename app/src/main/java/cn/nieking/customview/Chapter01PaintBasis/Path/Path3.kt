package cn.nieking.customview.Chapter01PaintBasis.Path

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Path3 @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f

        // Path.Direction.CCW 逆时针方向的矩形路径
        // Path.Direction.CW  顺时针方向的矩形路径

        // 第一条路径逆向生成
        val CCWRectpath = Path()
        val rect_1 = RectF(50f, 50f, 240f, 240f)
        CCWRectpath.addRect(rect_1, Path.Direction.CCW)

        // 第二条路经顺向生成
        val CWRectpath = Path()
        val rect_2 = RectF(290f, 50f, 480f, 200f)
        CWRectpath.addRect(rect_2, Path.Direction.CW)

        canvas.drawPath(CCWRectpath, paint)
        canvas.drawPath(CWRectpath, paint)

        // 根据路径布局文字
        val text = "自定义控件教程"
        paint.color = Color.GREEN
        paint.textSize = 15f
        canvas.drawTextOnPath(text, CCWRectpath, 0f, 18f, paint)
        canvas.drawTextOnPath(text, CWRectpath, 0f, 18f, paint)

        // 添加圆角矩形路径
        val path2 = Path()
        val rect_3 = RectF(50f, 250f, 250f, 400f)
        path2.addRoundRect(rect_3, 10f, 15f, Path.Direction.CCW)

        val rect_4 = RectF(290f, 250f, 480f, 400f)
        val radii = floatArrayOf(10f, 15f, 20f, 25f, 30f, 35f, 40f, 45f)
        path2.addRoundRect(rect_4, radii, Path.Direction.CCW)

        canvas.drawPath(path2, paint)

        // 添加圆形路径
        val path4 = Path()
        path4.addCircle(500f, 500f, 50f, Path.Direction.CCW)
        canvas.drawPath(path4, paint)

        // 添加椭圆路径
        val path5 = Path()
        val rect_5 = RectF(10f, 600f, 100f, 700f)
        path5.addOval(rect_5, Path.Direction.CCW)
        canvas.drawPath(path5, paint)

        // 添加弧形路径
        val path6 = Path()
        val rect_6 = RectF(10f, 510f, 100f, 550f)
        path6.addArc(rect_6, 0f, 100f)
        canvas.drawPath(path6, paint)
    }
}