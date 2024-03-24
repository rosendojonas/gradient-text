package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class GradientEditText(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {

    // Measure text width
    private val width = paint.measureText(text.toString())

    // Get the font metrics
    private val fontMetrics: Paint.FontMetrics = paint.fontMetrics

    // Calculate the text height
    private val textHeight = fontMetrics.descent - fontMetrics.ascent

    // Create a shader
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
        // Rotate shader to a fixed position and change pivot point to the center
        val matrix = Matrix().apply {
            setRotate(0f, width / 2, height / 2f)
        }
        textShader.setLocalMatrix(matrix)
        paint.shader = textShader
    }

}