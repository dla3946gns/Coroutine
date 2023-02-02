package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).async {

        }

        CoroutineScope(Dispatchers.Main).launch {
            val html = CoroutineScope(Dispatchers.IO).async {
                //getHtml()
            }.await()

            // getHtml()이 먼저 실행된 후 텍스트뷰에 세팅된다
            //textView.text = html.toString()
        }

        // 다른 UI 작업이다
        Toast.makeText(this, "토스트가 먼저 노출됨", Toast.LENGTH_SHORT).show()

        CoroutineScope(Dispatchers.Main).launch {
            val temp = CoroutineScope(Dispatchers.Default).async {
                // 내부 DB 데이터 삭제 코드
            }.await()

            // recyclerView 갱신 코드
        }
    }
}