package com.opencvcamera;
import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat source = null;
        Mat template = null;
        String filePath = "C:\\Users\\Administrator\\Pictures\\Resimler\\";
        source = Imgcodecs.imread(filePath + "biz.jpg");

        Mat outputImage = new Mat();
        int machMethod = Imgproc.TM_CCOEFF;

        // "Alper" ismini bulma
        template = Imgcodecs.imread(filePath + "Alper.jpg");
        Imgproc.matchTemplate(source, template, outputImage, machMethod);

        MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
        Point matchLoc = mmr.maxLoc;

        // Şablonun sol üst köşesine metni eklemek için yeni bir Point nesnesi oluştur
        Point textPosition = new Point(matchLoc.x, matchLoc.y);

        // Metin ayarları
        String text = "Alper";
        int fontFace = Imgproc.FONT_HERSHEY_SIMPLEX;
        double fontScale = 1.0;
        Scalar color = new Scalar(0, 255, 0); // Yeşil renk
        int thickness = 2;

        // Metnin boyutlarını al
        int[] baseline = new int[1];
        Size textSize = Imgproc.getTextSize(text, fontFace, fontScale, thickness, baseline);

        // Metnin sol üst köşesini hesapla
        Point textStartPoint = new Point(matchLoc.x, matchLoc.y + textSize.height);

        Imgproc.putText(source, text, textStartPoint, fontFace, fontScale, color, thickness);

        // Çerçeve için gerekli ayarlar
        Rect boundingRect = new Rect(matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()));
        Scalar rectColor = new Scalar(0, 255, 0); // Yeşil renk

        // Görüntü üzerine çerçeve çizme
        Imgproc.rectangle(source, boundingRect.tl(), boundingRect.br(), rectColor, thickness);

     // Yeni objeyi bulma
        template = Imgcodecs.imread(filePath + "Yusuf.jpg");
        Imgproc.matchTemplate(source, template, outputImage, machMethod);

        mmr = Core.minMaxLoc(outputImage);
        matchLoc = mmr.maxLoc;

        // Şablonun sol üst köşesine metni eklemek için yeni bir Point nesnesi oluştur
        textPosition = new Point(matchLoc.x, matchLoc.y);

        // Metin ayarları
        text = "Yusuf";
        color = new Scalar(0, 0, 255); // Kırmızı renk

        // Metnin boyutlarını al
        baseline = new int[1];
        textSize = Imgproc.getTextSize(text, fontFace, fontScale, thickness, baseline);

        // Metnin sol üst köşesini hesapla
        textStartPoint = new Point(matchLoc.x, matchLoc.y + textSize.height);

        Imgproc.putText(source, text, textStartPoint, fontFace, fontScale, color, thickness);

        // Çerçeve için gerekli ayarlar
        boundingRect = new Rect(matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()));

        // Yeni objenin çerçeve rengi (örneğin, kırmızı)
        rectColor = new Scalar(0, 0, 255); // Kırmızı renk

        // Görüntü üzerine çerçeve çizme
        Imgproc.rectangle(source, boundingRect.tl(), boundingRect.br(), rectColor, thickness);

        
        // Yeni objeyi bulma
        template = Imgcodecs.imread(filePath + "Omer.jpg");
        Imgproc.matchTemplate(source, template, outputImage, machMethod);

        mmr = Core.minMaxLoc(outputImage);
        matchLoc = mmr.maxLoc;

        // Şablonun sol üst köşesine metni eklemek için yeni bir Point nesnesi oluştur
        textPosition = new Point(matchLoc.x, matchLoc.y);

        // Metin ayarları
        text = "Ömer";
        color = new Scalar(0, 255, 255); // Sarı renk

        // Metnin boyutlarını al
        baseline = new int[1];
        textSize = Imgproc.getTextSize(text, fontFace, fontScale, thickness, baseline);

        // Metnin sol üst köşesini hesapla
        textStartPoint = new Point(matchLoc.x, matchLoc.y + textSize.height);

        Imgproc.putText(source, text, textStartPoint, fontFace, fontScale, color, thickness);

        // Çerçeve için gerekli ayarlar
        boundingRect = new Rect(matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()));

        // Yeni objenin çerçeve rengi (örneğin, sarı)
        rectColor = new Scalar(0, 255, 255); // Sarı renk

        // Görüntü üzerine çerçeve çizme
        Imgproc.rectangle(source, boundingRect.tl(), boundingRect.br(), rectColor, thickness);


        Imgcodecs.imwrite(filePath + "sonuc.jpg", source);
        System.out.println("İşlem tamamlandı.");
    }
}

