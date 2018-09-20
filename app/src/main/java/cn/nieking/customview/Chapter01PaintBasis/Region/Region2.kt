package cn.nieking.customview.Chapter01PaintBasis.Region

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Region2 @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // union
        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        val region = Region(10, 10, 200, 100)
        region.union(Rect(10, 10, 50, 300))
//        drawRegion(canvas, region, paint)


        // 区域操作
        val rect1 = Rect(100, 100, 400, 200)
        val rect2 = Rect(200, 0, 300, 300)

        val paint2 = Paint()
        paint2.color = Color.RED
        paint2.style = Paint.Style.STROKE
        paint2.strokeWidth = 2f
        canvas.drawRect(rect1, paint2)
        canvas.drawRect(rect2, paint2)

        val region_1 = Region(rect1)
        val region_2 = Region(rect2)
        // 取两个区域的交集
        region_1.op(region_2, Region.Op.INTERSECT)  // DIFFERENCE          补集（a相对于b）
                                                    // INTERSECT          交集
                                                    // UNION              并集
                                                    // XOR                异并集
                                                    // REVERSE_DIFFERENCE 反转补集
                                                    // REPLACE            替换
        // 填充所选区域
        val paint_fill = Paint()
        paint_fill.color = Color.GREEN
        paint_fill.style = Paint.Style.FILL
        drawRegion(canvas, region_1, paint_fill)

        val region_3 = Region(100, 100, 400, 200)
        val region_4 = Region(200, 0, 300, 300)
        val regionA = Region()
        regionA.op(region_3, region_4, Region.Op.INTERSECT)
    }

    private fun drawRegion(canvas: Canvas, region: Region, paint: Paint) {
        val iterator = RegionIterator(region)
        val r = Rect()

        while (iterator.next(r)) {
            canvas.drawRect(r, paint)
        }
    }
}