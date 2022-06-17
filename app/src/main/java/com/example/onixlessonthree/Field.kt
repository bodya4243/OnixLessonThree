package com.example.onixlessonthree

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Field(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint()
    private var cellSize = width / 3


    private val typedArray: TypedArray = context.theme.obtainStyledAttributes(
        attrs, R.styleable.Field, 0, 0
    )
    private val boardColor = typedArray.getColor(R.styleable.Field_boardColor, 0)

    override fun onMeasure(width: Int, height: Int) {
        super.onMeasure(width, height)

        val dimension = measuredWidth.coerceAtMost(measuredHeight)
        cellSize = dimension / 3

        setMeasuredDimension(dimension, dimension)
    }

    override fun onDraw(canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        drawGameBoard(canvas)

    }
    private fun drawGameBoard(canvas: Canvas) {
        paint.color = boardColor
        paint.strokeWidth = 16f

        for (c in 1..2) {
            canvas.drawLine(
                cellSize * c.toFloat(),
                0f,
                cellSize * c.toFloat(),
                canvas.width.toFloat(),
                paint
            )
        }

        for (r in 1..2) {
            canvas.drawLine(
                0f,
                cellSize * r.toFloat(),
                canvas.width.toFloat(),
                cellSize * r.toFloat(),
                paint
            )
        }
    }
}