package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class GradientTextView(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private val width = paint.measureText(text.toString())

    // Get the font metrics
    val fontMetrics = paint.fontMetrics

    // Calculate the text height
    val textHeight = fontMetrics.descent - fontMetrics.ascent

    private val textShader = LinearGradient(
        width,
        textHeight / 3,
        width,
        textHeight,
        intArrayOf(
            Color.parseColor("#ff0000"),
            Color.parseColor("#0000ff"),
            Color.parseColor("#0000ff"),
        ),
        null,
        Shader.TileMode.CLAMP,
    )

    init {
        val matrix = Matrix().apply {
            setRotate(0f, width / 2, height / 2f)
        }
        textShader.setLocalMatrix(matrix)
        paint.shader = textShader
    }
}