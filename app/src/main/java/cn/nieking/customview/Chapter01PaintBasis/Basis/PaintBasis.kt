package cn.nieking.customview.Chapter01PaintBasis.Basis

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PaintBasis @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 设置画笔的基本属性
        val paint = Paint()
        paint.isAntiAlias = true              // 打开抗锯齿
        paint.color = Color.RED               // 设置画笔颜色
        paint.style = Paint.Style.FILL        // 设置填充样式
                                              // FILL 仅填充内部
                                              // FILL_AND_STROKE 填充内部并描边
                                              // STROKE 仅描边
        paint.strokeWidth = 50f               // 设置画笔宽度

        // 画圆
        canvas?.drawCircle(190f, 200f, 150f, paint)

        paint.color = 0x7EFFFF00
        canvas?.drawCircle(190f, 200f, 100f, paint)
    }
}