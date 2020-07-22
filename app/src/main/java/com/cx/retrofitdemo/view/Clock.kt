package com.cx.retrofitdemo.view


import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.cx.retrofitdemo.R
import java.lang.Math.cos
import java.lang.Math.sin
import java.util.*


/**
 * @ClassName: Clock
 * @Author: CX
 * @Date: 2020/7/20 9:47
 */
class Clock : View {


    private var isPointer: Boolean = true
    private var seconds: Int = 0
    private var minutes: Int = 0
    private var hours: Int = 0

    /*圆心坐标点x*/
    private var mCenterY: Float = 0f

    /*圆心坐标点y*/
    private var mCenterX: Float = 0f

    /*控件高度*/
    private var mheight: Int = 0

    /*控件宽度*/
    private var mWidth: Int = 0

    /*中心图片*/
    private lateinit var centerIcon: Bitmap

    /*秒针颜色*/
    private var secondHandColor: Int = 0

    /*分针颜色*/
    private var minuteHandColor: Int = 0

    /*时针颜色*/
    private var hourHandColor: Int = 0

    /*默认刻度颜色*/
    private var defScaleColor: Int = 0

    /*特殊特堵颜色*/
    private var scaleColor: Int = 0

    /*圆周颜色*/
    private var circleColor: Int = 0


    //时钟的外环宽度
    private var mClockRingWidth = 0f

    //时钟的半径
    private var mClockRadius = 0f

    // 默认刻度的宽度
    private var mDefaultWidth = 0f

    // 默认刻度的长度
    private var mDefaultLength = 0f

    // 特殊刻度的宽度
    private var mSpecialWidth = 0f

    // 特殊刻度的长度
    private var mSpecialLength = 0f

    // 时针的宽度
    private var mHWidth = 0f

    // 分针的宽度
    private var mMWidth = 0f

    //秒针的宽度
    private var mSWidth = 0f

    /*刻度画笔*/
    private var scalePaint = Paint()

    /*时针画笔*/
    private var hourHandPaint = Paint()

    /*分针画笔*/
    private var minuteHandPaint = Paint()

    /*秒针画笔*/
    private var secondHandPaint = Paint()

    /*中心图标*/
    private var centerIconPaint = Paint()

    /*圆周画笔*/
    private var circlePaint = Paint()

    /*路径画笔*/
    private var pathPaint = Paint()

    constructor(mContext: Context) : this(mContext, null)
    constructor(mContext: Context, attrs: AttributeSet?) : this(mContext, attrs!!, 0)
    constructor(mContext: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attrs,
        defStyleAttr
    ) {
        init(mContext, attrs)
    }

    fun init(context: Context, attrs: AttributeSet) {
        var ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.Clock)
        scaleColor = ta.getColor(R.styleable.Clock_scaleColor, Color.parseColor("#666666"))
        circleColor = ta.getColor(R.styleable.Clock_circleColor, Color.parseColor("#666666"))
        defScaleColor = ta.getColor(R.styleable.Clock_defScaleColor, Color.parseColor("#666666"))
        hourHandColor = ta.getColor(R.styleable.Clock_hourHandColor, Color.parseColor("#666666"))
        minuteHandColor =
            ta.getColor(R.styleable.Clock_minuteHandColor, Color.parseColor("#666666"))
        secondHandColor =
            ta.getColor(R.styleable.Clock_secondHandColor, Color.parseColor("#fc0101ff"))
        isPointer = ta.getBoolean(R.styleable.Clock_isPointer, true)


        //设置中心图标的大小
        var centerIconResourceId = ta.getResourceId(R.styleable.Clock_centerIcon, R.mipmap.star)
        centerIcon = BitmapFactory.decodeResource(context.resources, centerIconResourceId)
        var width = centerIcon.width
        var height = centerIcon.height
        var newWidth = 100
        var newHeight = 100
        val scaleWidth = newWidth.toFloat() / width
        val scaleHeight = newHeight.toFloat() / height


        //获取想要缩放的matrix
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        centerIcon = Bitmap.createBitmap(centerIcon, 0, 0, width, height, matrix, true)

        ta.recycle()

        circlePaint.color = circleColor
        circlePaint.isAntiAlias = true
        circlePaint.style = Paint.Style.STROKE
        circlePaint.strokeWidth = 4f

        scalePaint.color = scaleColor
        scalePaint.isAntiAlias = true
        scalePaint.style = Paint.Style.STROKE

        hourHandPaint.color = hourHandColor
        hourHandPaint.strokeWidth = 10f
        hourHandPaint.isAntiAlias = true
        hourHandPaint.style = Paint.Style.FILL_AND_STROKE

        minuteHandPaint.color = minuteHandColor
        minuteHandPaint.isAntiAlias = true
        minuteHandPaint.strokeWidth = 7f
        minuteHandPaint.style = Paint.Style.FILL_AND_STROKE

        secondHandPaint.color = secondHandColor
        secondHandPaint.isAntiAlias = true
        secondHandPaint.strokeWidth = 4f
        secondHandPaint.style = Paint.Style.FILL_AND_STROKE

        pathPaint.color = circleColor
        pathPaint.isAntiAlias = true
        pathPaint.strokeWidth = 4f
        pathPaint.style = Paint.Style.FILL

        var calendar = Calendar.getInstance()
        hours = calendar.get(Calendar.HOUR)
        minutes = calendar.get(Calendar.MINUTE)
        seconds = calendar.get(Calendar.SECOND)
        start()

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width: Int = getMeasureSize(true, widthMeasureSpec)
        var height: Int = getMeasureSize(false, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mheight = h
        mCenterX = w / 2.0f
        mCenterY = h / 2.0f
        mClockRadius = (h / 2.0f) * 0.9f

    }

    private fun getMeasureSize(isWidth: Boolean, measureSpec: Int): Int {
        var result = 0
        var specSize = MeasureSpec.getSize(measureSpec)
        var specMode = MeasureSpec.getMode(measureSpec)
        when (specMode) {
            MeasureSpec.AT_MOST -> {
                result = if (isWidth) {
                    specSize.coerceAtMost(mWidth)
                } else {
                    specSize.coerceAtMost(mheight)
                }
            }
            MeasureSpec.EXACTLY -> {
                result = specSize
            }
            MeasureSpec.UNSPECIFIED -> {
                if (isWidth) {
                    result = suggestedMinimumWidth
                } else {
                    result = suggestedMinimumHeight
                }
            }
        }
        return result
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //这里是将画布的起始点移到画布中心，中心点的坐标就变成（0,0）
        canvas?.translate(mCenterX, mCenterY)
        drawCircle(canvas)
        drawScale(canvas)
        if (isPointer) {
            drawHour(canvas)
            drawminute(canvas)
            drawSeconds(canvas)
            drawCenterIcon(canvas)
        } else {
            drawPath(canvas)
        }
    }

    /*画出三个指针组成的三角形*/
    private fun drawPath(canvas: Canvas?) {
        canvas?.save()
        var path = Path()


        //计算角度，这里减90是起始位置按12点算的话，就是-90°
        var hoursAngle = hours * 30f + minutes * 0.5f - 90
        var minutesAngle = minutes * 6f - 90
        var secondsAngle = seconds * 6f - 90


        //根据角度算出时针分针秒针的坐标点
        var xHours =
            (mClockRadius - 120f) * kotlin.math.cos(hoursAngle * 3.14 / 180)
        var yHours =
            (mClockRadius - 120f) * kotlin.math.sin(hoursAngle * 3.14 / 180)

        var xMinutes =
            (mClockRadius - 80f) * kotlin.math.cos(minutesAngle * 3.14 / 180)
        var yMinutes =
            (mClockRadius - 80f) * kotlin.math.sin(minutesAngle * 3.14 / 180)

        var xSeconds =
            (mClockRadius - 40f) * kotlin.math.cos(secondsAngle * 3.14 / 180)
        var ySeconds =
            (mClockRadius - 40f) * kotlin.math.sin(secondsAngle * 3.14 / 180)


        //将坐标点连起来滑出三角形
        path.moveTo(xHours.toFloat(), yHours.toFloat())
        path.lineTo(xMinutes.toFloat(), yMinutes.toFloat())
        path.lineTo(xSeconds.toFloat(), ySeconds.toFloat())
        path.close()
        canvas?.drawPath(path, pathPaint)
        canvas?.restore()

    }

    /*画秒针*/
    private fun drawSeconds(canvas: Canvas?) {
        //分针一分钟会增加6度
        Log.i("cx----canvasSeconds", "" + seconds)
        canvas?.save()
        canvas?.rotate(seconds * 6f)
        canvas?.drawLine(0f, 10f, 0f, -mClockRadius + 40f, secondHandPaint)
        canvas?.restore()
    }


    /*画分针*/
    private fun drawminute(canvas: Canvas?) {
        //分针一分钟会增加6度
        canvas?.save()
        canvas?.rotate(minutes * 6f)
        canvas?.drawLine(0f, 10f, 0f, -mClockRadius + 80f, minuteHandPaint)
        canvas?.restore()
    }


    /*画时针*/
    private fun drawHour(canvas: Canvas?) {
        //时针一小时为30度，分针一分钟时针会增加0.5度
        canvas?.save()
        canvas?.rotate(hours * 30f + minutes * 0.5f)
        canvas?.drawLine(0f, 10f, 0f, -mClockRadius + 120f, hourHandPaint)
        canvas?.restore()
    }


    /*画表盘中心图标*/
    private fun drawCenterIcon(canvas: Canvas?) {
        canvas?.save()
        //这里的-50是上面bitmap款的一半，因为中心点是起始点，所以画图标的其实坐标是-50，-50
        canvas?.drawBitmap(centerIcon, -50f, -50f, centerIconPaint)
        canvas?.restore()
    }

    /*画刻度*/
    private fun drawScale(canvas: Canvas?) {
        for (i in 0 until 60) {
            if (i % 5 == 0) {
                //特殊刻度
                scalePaint.setColor(scaleColor)
                scalePaint.strokeWidth = 6f
                canvas?.drawLine(0f, -mClockRadius + 4f, 0f, -mClockRadius + 30f, scalePaint)
            } else {
                //一般刻度
                scalePaint.setColor(defScaleColor)
                scalePaint.strokeWidth = 3f
                canvas?.drawLine(0f, -mClockRadius + 4f, 0f, -mClockRadius + 20f, scalePaint)
            }

            //每画一个刻度将画布旋转6度（一分钟的一格）
            canvas?.rotate(6f)
        }
    }

    /*画时钟的外圆*/
    private fun drawCircle(canvas: Canvas?) {
        canvas?.drawCircle(0f, 0f, mClockRadius, circlePaint)
    }


    /**
     * 定时器
     */
    private val mTimer = Timer()
    private val task: TimerTask = object : TimerTask() {
        override fun run() {
            var calendar = Calendar.getInstance()
            hours = calendar.get(Calendar.HOUR)
            minutes = calendar.get(Calendar.MINUTE)
            seconds = calendar.get(Calendar.SECOND)
            postInvalidate()
        }
    }

    /**
     * 开启定时器
     */
    fun start() {
        mTimer.schedule(task, 0, 1000)
    }


}