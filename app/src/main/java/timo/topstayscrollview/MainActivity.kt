package timo.topstayscrollview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        llAnswerAnalysis.addView(getTextView())
        llAnswerAnalysis.addView(getTextView())
        llAnswerAnalysis.addView(getTextView())
        nestedScrollView.setOnScrollChanged { l, t, oldl, oldt ->
            // 滑动距离
            llScrollTitle1.visibility = if (t > llAnswerAnalysisTitle.top) {
                View.VISIBLE
            } else {
                View.GONE
            }

            llScrollTitle2.visibility =  // 减去一个自身的高度
                    if (t > (llNetFriendDiscussionTitle.top - llNetFriendDiscussionTitle.height)) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
        }
    }

    private fun getTextView(): TextView {
        val textView = TextView(this)
        textView.text = "导数（Derivative），也叫导函数值。又名微商，是微积分中的重要基础概念。当函数y=f（x）的自变量x在一点x0上产生一个增量Δx时，函数输出值的增量Δy与自变量增量Δx的比值在Δx趋于0时的极限a如果存在，a即为在x0处的导数，记作f'（x0）或df（x0）/dx。\n" +
                "导数是函数的局部性质。一个函数在某一点的导数描述了这个函数在这一点附近的变化率。如果函数的自变量和取值都是实数的话，函数在某一点的导数就是该函数所代表的曲线在这一点上的切线斜率。导数的本质是通过极限的概念对函数进行局部的线性逼近。例如在运动学中，物体的位移对于时间的导数就是物体的瞬时速度。\n" +
                "不是所有的函数都有导数，一个函数也不一定在所有的点上都有导数。若某函数在某一点导数存在，则称其在这一点可导，否则称为不可导。然而，可导的函数一定连续；不连续的函数一定不可导。\n" +
                "对于可导的函数f(x)，x↦f'(x)也是一个函数，称作f(x)的导函数（简称导数）。寻找已知的函数在某点的导数或其导函数的过程称为求导。实质上，求导就是一个求极限的过程，导数的四则运算法则也来源于极限的四则运算法则。反之，已知导函数也可以倒过来求原来的函数，即不定积分。微积分基本定理说明了求原函数与积分是等价的。求导和积分是一对互逆的操作，它们都是微积分学中最为基础的概念。"
        return textView
    }
}
