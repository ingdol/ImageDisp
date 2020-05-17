package com.example.imagedisp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View{ //view를 상속받아 MyView 클래스를 작성한다.
    public MyView(Context context){ //생성자 MyView가 객체 context를 생성한다.
        super(context); //상위클래스에 context 정보를 전달한다.
        setBackgroundColor(Color.YELLOW); //배경을 노랑색으로 한다.
    }
    @Override
    protected void onDraw(Canvas canvas){ //객체 canvas에 그린다.
        Paint paint = new Paint(); //paint 객체를 생성한다.
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        //Bitmap이 이미지에 대한 픽셀 정보를 가져온다.
        //클래스 BitmapFactory에 있는 메소드 decodeResource를 이용한다.
        //getResource는 패키지에 해당되는 리소스 정보를 가져온다.
        //식별자를 읽어서 비트맵으로 만든다.
        canvas.drawBitmap(b, 0, 0, null);
        //이미지를 캔버스에 그린다.


        //비트맵
        Matrix m = new Matrix(); //상하 반전 변환 행렬
        m.preScale(1, -1);

        Bitmap mb = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, false);
        //변환 행렬 m이 적용된 새로운 비트맵을 생성한다.
        Bitmap sb = Bitmap.createScaledBitmap(b, 600,600, false);
        //확대 축소 비트맵을 생성한다.
        canvas.drawBitmap(mb, 0, 0, null);
        //역상된 mb를 그린다.
        canvas.drawBitmap(sb, 100, 100, null);
        //scale한 mb를 그린다.
    }
}

public class MainActivity extends AppCompatActivity{ //클래스를 상속받아 MainActivity 클래스를 작성한다.
    @Override
    public void onCreate(Bundle savedInstanceState) { //onCreate 메소드의 매개변수는 앱이 이전 실행 상태를 전달한다.
        super.onCreate(savedInstanceState); //상위클래스 onCreate를 호출한다.
        MyView w = new MyView(this); //MyView를 생성한다.
        setContentView(w); //Myview를 띄운다.
    }
}
