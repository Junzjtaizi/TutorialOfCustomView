package cn.nieking.customview.Chapter01PaintBasis.Example

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 雷达图
 */
class RadarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val radarPaint: Paint = Paint()
    private val valuePaint: Paint = Paint()

    /**
     * 最大半径
     */
    private var radius: Float = 0f
    /**
     * 中心点横坐标
     */
    private var centerX = 0
    /**
     * 中心点纵坐标
     */
    private var centerY = 0
    /**
     * 各属性总等级
     */
    private val count = 6
    /**
     * 各属性级间的角度（弧度）
     */
    private val angle = Math.PI * 2 / count
    /**
     * 数据
     */
    private val data = intArrayOf(1, 2, 3, 4, 5, 6)
    /**
     * 最大等级
     */
    private val maxValue = 6

    init {
        radarPaint.style = Paint.Style.STROKE
        radarPaint.color = Color.GREEN
        radarPaint.strokeWidth = 10f

        valuePaint.color = Color.BLUE
        valuePaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawPolygon(canvas)
        drawLines(canvas)
        drawRegion(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = Math.min(h, w) / 2 * 0.9f
        // 中心坐标
        centerX = w / 2
        centerY = h / 2
        invalidate()
        super.onSizeChanged(w, h, oldw, oldh)
    }

    /**
     * 画出雷达图图盘
     */
    private fun drawPolygon(canvas: Canvas) {
        val path = Path()
        val r = radius / count             // r是蜘蛛丝之间的间距
        for (i in 1..count) {                // 中心点不用绘制
            val curR = r * i               // 当前半径
            path.reset()
            for (j in 0 until count) {
                if (j == 0) {
                    path.moveTo(centerX + curR, centerY.toFloat())
                } else {
                    //根据半径，计算出蜘蛛丝上每个点的坐标
                    val x = (centerX + curR * Math.cos(angle * j)).toFloat()
                    val y = (centerY + curR * Math.sin(angle * j)).toFloat()
                    path.lineTo(x, y)
                }
            }
            path.close()//闭合路径
            canvas.drawPath(path, radarPaint)
        }
    }

    /**
     * 画出属性线
     */
    private fun drawLines(canvas: Canvas) {
        val path = Path()
        radarPaint.strokeWidth = 5f
        for (i in 1..count) {
            path.reset()
            path.moveTo(centerX.toFloat(), centerY.toFloat())
            val x = centerX + radius * Math.cos(angle * i).toFloat()
            val y = centerY + radius * Math.sin(angle * i).toFloat()
            path.lineTo(x, y)
            canvas.drawPath(path, radarPaint)
        }

    }

    /**
     * 画出数据图
     */
    private fun drawRegion(canvas: Canvas) {
        val path = Path()
        valuePaint.alpha = 127
        for (i in 0 until count) {
            val percent: Double = data[i].toDouble() / maxValue.toDouble()
            val x = (centerX + radius * Math.cos(angle * i) * percent).toFloat()
            val y = (centerY + radius * Math.sin(angle * i) * percent).toFloat()
            if (i == 0) {
                path.moveTo(x, centerY.toFloat())
            } else {
                path.lineTo(x, y)
            }
            canvas.drawCircle(x, y, 10f, valuePaint)
        }
        valuePaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawPath(path, valuePaint)
    }
}