package com.padcmyanmar.androidftc.padcx_customviewassignment_nct.views.components

import android.content.Context
import android.graphics.*
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.androidftc.padcx_customviewassignment_nct.R

class CircularProgressBar @JvmOverloads constructor(context:Context,attrs:AttributeSet,defStyleAttr:Int=0):View(context,attrs,defStyleAttr) {
    private val paintBg = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG)
    private var lightColor = Color.rgb(255, 219, 197)
    private var darkColor = Color.rgb(227, 53, 30)
    private val borderWidth = 10.0f
    private val rect = RectF()
    private var percentText = "0"

    var percent = 0f

    init {
        setUpAttributes(attrs)
        setUpValues()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rect.set(10f,10f,width.toFloat()-10,height.toFloat()-10)
        canvas?.drawArc(rect,-90f,360f,false,paintBg)
        if(percent!=0f) {
            canvas?.drawArc(rect,-90f,(3.6f*percent),false,paint)
        }
        val xPos = width/2f
        val yPos = (height/2f)-((paintText.descent()+paintText.ascent())/2f)
        canvas?.drawText(percentText+"%",xPos,yPos,paintText)
    }


    private fun setUpAttributes(attrs:AttributeSet) {
        context.withStyledAttributes(attrs, R.styleable.CircularProgressBar) {
            percent = getFloat(R.styleable.CircularProgressBar_percent,0f)
        }
    }
    private fun setUpValues() {
        percentText = percent.toInt().toString()
        paintText.color = darkColor
        paintText.textAlign = Paint.Align.CENTER
        paintText.typeface = Typeface.create(Typeface.DEFAULT,Typeface.BOLD)
        paintText.textSize = 46f

        paintBg.color = lightColor
        paintBg.style = Paint.Style.STROKE
        paintBg.strokeWidth = borderWidth

        paint.color = darkColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
    }
    public fun setLightColor(color:Int) {
        lightColor = color
    }
    public fun setDarkColor(color:Int) {
        darkColor = color
    }
    public fun setPercentage(percentage:Float) {
        this.percent = percentage
    }
}