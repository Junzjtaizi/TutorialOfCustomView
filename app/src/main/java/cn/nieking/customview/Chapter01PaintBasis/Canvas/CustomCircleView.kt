package cn.nieking.customview.Chapter01PaintBasis.Canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import cn.nieking.customview.R

class CustomCircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mBmp: Bitmap
    private var mPaint: Paint
    private var mPath: Path

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mBmp = BitmapFactory.decodeResource(resources, R.mipmap.avator)
        mPaint = Paint()
        mPath = Path()
        val width = mBmp.width.toFloat()
        val height = mBmp.height.toFloat()
        mPath.addCircle(width / 2,
                height / 2,
                width / 2,
                Path.Direction.CCW)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()
        canvas.clipPath(mPath)
        canvas.drawBitmap(mBmp, 0f, 0f, mPaint)
        canvas.restore()
    }
}