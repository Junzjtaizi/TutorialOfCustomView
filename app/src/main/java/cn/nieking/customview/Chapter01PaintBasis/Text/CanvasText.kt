package cn.nieking.customview.Chapter01PaintBasis.Text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class CanvasText @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val text = "床前明月光"
    private val paint = Paint()

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        paint.color = Color.RED
        paint.textSize = 80f
//        canvas.drawText(text, 2, 4, 10f, 100f, paint)

        // 逐个指定文字位置
        val pos = floatArrayOf(80f, 100f,
                80f, 200f,
                80f, 300f,
                80f, 400f)
//        canvas.drawPosText("窗前明月", pos, paint)

        // 沿路径绘制
        val paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 5f
        paint.textSize = 45f
        paint.style = Paint.Style.STROKE

        val circlePath = Path()
        circlePath.addCircle(220f, 300f, 150f, Path.Direction.CCW)
        canvas.drawPath(circlePath, paint)
        val circlePath2 = Path()
        circlePath2.addCircle(600f, 300f, 150f, Path.Direction.CCW)
        canvas.drawPath(circlePath2, paint)

        val string = "华夏天工工业科技集团公司"
        canvas.drawTextOnPath(string, circlePath, 0f, 0f, paint)
        canvas.drawTextOnPath(string, circlePath2, 450f, 40f, paint)
    }
}