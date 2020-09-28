package com.example.a1wechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * log 日志打印 调试代码
 * 通过logcat查看日志打印的内容
 * v - Verbose
 * d - Debug
 * i - Info
 * e - Error
 * w - warn
 *
 * tag  用于过滤的标签
 * message 输出的内容
 */
/**
 * Activity的生命周期 -> 创建 -> 界面销毁  经历的过程
 * 程序第一次启动
 *      onCreate
 *      onStart
 *      onResume
 * 程序切花到后台
 *      onPause
 *      onStop
 * 程序从后台切换到前台
 *      onRestart
 *      onStart
 *      onResume
 * 如果当前界面是第一个界面  按返回键就会返回到桌面且当前页面会被释放掉
 *      onPause
 *      onStop
 *      onDestroy
 * 切换到其他页面
 *      onPause
 *      onStop
 * 程序从下一个页面切换回来
 *      onRestart
 *      onStart
 *      onResume
 * 当界面旋转时 会销毁当前界面 重新加载新的界面
 *      onPause
 *      onStop
 *      onDestroy
 *
 *      onCreate
 *      onStart
 *      onResume
 */
class MainActivity : AppCompatActivity() {
    //当activity被创建 需要对界面进行布局/初始化
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("wxw","onCreate")
        btn.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }

        //获取保存的数据
        savedInstanceState?.getString("content","").also {
            textView.text=it
        }
        btn2.setOnClickListener {
            textView.text="hello world"
        }
    }

    //开始启动页面
    override fun onStart() {
        super.onStart()
        Log.v("wxw","onStart")
    }

    //重新启动
    override fun onRestart() {
        super.onRestart()
        Log.v("wxw","onRestart")
    }

    //启动完毕 已经展现在用户面前  可以进行交互
    override fun onResume() {
        super.onResume()
        Log.v("wxw","onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("content",textView.text.toString())
    }

    //暂停交互
    override fun onPause() {
        super.onPause()
        Log.v("wxw","onPause")
    }

    //页面暂停
    override fun onStop() {
        super.onStop()
        Log.v("wxw","onStop")
    }

    //销毁页面
    override fun onDestroy() {
        super.onDestroy()
        Log.v("wxw","onDestroy")
    }

}