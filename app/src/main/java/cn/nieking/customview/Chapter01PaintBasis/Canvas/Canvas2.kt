package cn.nieking.customview.Chapter01PaintBasis.Canvas

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Canvas2 @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        canvas.drawColor(Color.RED)
//
//        // 保存当前画布大小
//        canvas.save()
//
//        canvas.clipRect(Rect(100, 100, 800, 800))
//        canvas.drawColor(Color.GREEN)
//
//        // 恢复整屏幕画布
//        canvas.restore()
//
//        canvas.drawColor(Color.BLUE)

        canvas.drawColor(Color.RED)
        // 保存画布大小为全屏幕大小
        canvas.save()

        /*
        四次裁切画布
         */
        canvas.clipRect(Rect(100, 100, 800, 800))
        canvas.drawColor(Color.GREEN)
        canvas.save()

        canvas.clipRect(Rect(200, 200, 700, 700))
        canvas.drawColor(Color.BLUE)
        canvas.save()

        canvas.clipRect(Rect(300, 300, 600, 600))
        canvas.drawColor(Color.BLACK)
        canvas.save()

        canvas.clipRect(Rect(400, 400, 500, 500))
        canvas.drawColor(Color.WHITE)

        /*
        三次恢复画布
         */
        canvas.restore()
        canvas.restore()
        canvas.restore()
        canvas.drawColor(Color.YELLOW)
    }
}