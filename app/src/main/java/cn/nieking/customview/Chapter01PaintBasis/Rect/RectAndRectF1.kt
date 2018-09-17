package cn.nieking.customview.Chapter01PaintBasis.Rect

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.orhanobut.logger.Logger

class RectAndRectF1 @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mX = 0
    private var mY = 0
    private val mPaint: Paint = Paint()
    private val mRect: Rect

    init {
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 50f
        mRect = Rect(100, 10, 980, 1000)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (mRect.contains(mX, mY)) {
            mPaint.color = Color.RED
        } else {
            mPaint.color = Color.GREEN
        }
        canvas.drawRect(mRect, mPaint)

        val paint = Paint()
        paint.style = Paint.Style.STROKE

        val rect_1 = Rect(10, 10, 200, 200)
        val rect_2 = Rect(190, 10, 250, 200)
        val rect_3 = Rect(10, 210, 200, 300)

        paint.color = Color.RED
        canvas.drawRect(rect_1, paint)
        paint.color = Color.GREEN
        canvas.drawRect(rect_2, paint)
        paint.color = Color.YELLOW
        canvas.drawRect(rect_3, paint)

        // 判单是否相交
        val interset1_2 = Rect.intersects(rect_1, rect_2)
        val interset1_3 = Rect.intersects(rect_1, rect_3)

        Logger.d("isInterset \n rect1_2: $interset1_2 \n rect1_3: $interset1_3")
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        mX = event.x.toInt()
        mY = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                invalidate()
                return true
            }
            MotionEvent.ACTION_UP -> {
                mX = -1
                mY = -1
            }
        }
        invalidate()
        return super.onTouchEvent(event)
    }
}