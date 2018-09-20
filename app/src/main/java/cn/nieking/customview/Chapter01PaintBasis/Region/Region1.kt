package cn.nieking.customview.Chapter01PaintBasis.Region

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Region
import android.util.AttributeSet
import android.view.View

/**
 * 区域
 */
class Region1 @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL
        paint.color = Color.RED

        val region = Region(Rect(50, 50, 200, 100))
//        drawRegion(canvas, region, paint)

        // 构造一条椭圆路径
        val ovalPath = Path()
        val rect = RectF(50f, 50f, 200f, 500f)
        ovalPath.addOval(rect, Path.Direction.CCW)
        // 传入一个比椭圆区域小的矩形区域，让其取交集
        val rgn = Region()
        rgn.setPath(ovalPath, Region(50, 50, 200, 200))
//        drawRegion(canvas, rgn, paint)


        paint.style = Paint.Style.STROKE
        val rgn2 = Region()
        rgn2.setPath(ovalPath, Region(50, 50, 200, 500))
        drawRegion(canvas, rgn2, paint)
    }

    private fun drawRegion(canvas: Canvas, region: Region, paint: Paint) {
        val iterator = RegionIterator(region)
        val r = Rect()

        while (iterator.next(r)) {
            canvas.drawRect(r, paint)
        }
    }
}