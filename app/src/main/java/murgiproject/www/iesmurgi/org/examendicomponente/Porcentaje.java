package murgiproject.www.iesmurgi.org.examendicomponente;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


public class Porcentaje extends View {

    private int colorFondo, colorArco, colorText;
    private int sizeText;
    private Paint paint;
    private static int porciento;
    private int num=0;
    TextPaint pintaTexto = new TextPaint();
    Paint pintaPorcentaje = new Paint();
    Context context;


    public Porcentaje(Context context) {
        super(context);
        this.context=context;
    }

    public Porcentaje(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint= new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Porcentaje,
                0, 0);

        try {
            colorFondo = a.getColor(R.styleable.Porcentaje_colorFondo, Color.BLACK);
            colorArco = a.getColor(R.styleable.Porcentaje_colorArco,Color.BLUE);
            colorText= a.getColor(R.styleable.Porcentaje_colorText,Color.WHITE);
            sizeText = a.getInt(R.styleable.Porcentaje_sizeText,40);

        } finally {
            a.recycle();
        }

        pintaTexto.setFlags(Paint.ANTI_ALIAS_FLAG);
        pintaTexto.setColor(colorText);
        pintaTexto.setTextSize(sizeText);


        pintaPorcentaje.setFlags(Paint.ANTI_ALIAS_FLAG);
        pintaPorcentaje.setColor(colorText);
        pintaPorcentaje.setTextSize(sizeText);


    }

    public Porcentaje(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void setPorcentaje(int i){
        porciento=i;
        if(porciento>100 || porciento<0){
            Toast.makeText(context,"error inserta un porcentaje  0 a 100",Toast.LENGTH_SHORT).show();
        }
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x=getWidth();
        int y=getHeight();

        RectF rectF = new RectF(100, 100, 700, 700);

        paint.setColor(colorArco);
        paint.setStrokeWidth(80);
        paint.setStyle(Paint.Style.STROKE);
        int por;
        por=(360*porciento)/100;
        canvas.drawArc(rectF, 0, por, false, paint);





        paint.setColor(colorFondo);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x/2,y/2,300,paint);


        drawText(canvas, pintaTexto, String.valueOf((int) (porciento)), pintaPorcentaje);


    }




    private void drawText(Canvas canvas, Paint paint, String text, Paint pintaPorcentaje) {
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        Rect porcentaje = new Rect();
        pintaPorcentaje.getTextBounds("%", 0, 1, porcentaje);
        int x = (canvas.getWidth() / 2) - (bounds.width() / 2) - (porcentaje.width() / 2);
        int y = (canvas.getHeight() / 2) + (bounds.height() / 2);
        canvas.drawText(text, x, y, paint);
        canvas.drawText("%", x + bounds.width() + porcentaje.width() / 2, y - bounds.height() + porcentaje.height(), pintaPorcentaje);
    }




}
