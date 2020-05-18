package com.battcn.factory.method;

/**
 * 图片读取器
 */
interface ImageReader {
    void read();
}
interface ImageReaderFactory {
    /**
     * 实例化对象
     *
     * @return ImageReader
     */
    ImageReader create();
}

class JpgReader implements ImageReader {
    public JpgReader() {
        System.out.println("创建Jpg读取器");
    }

    @Override
    public void read() {
        System.out.println("读取Jpg文件");
    }
}

class PngReader implements ImageReader {
    public PngReader() {
        System.out.println("创建Png读取器");
    }

    @Override
    public void read() {
        System.out.println("读取Png文件");
    }
}

class JpgFactory implements ImageReaderFactory {
    @Override
    public ImageReader create() {
        System.out.println("实例化Jpg文件工厂");
        return new JpgReader();
    }
}

class PngFactory implements ImageReaderFactory {
    @Override
    public ImageReader create() {
        System.out.println("实例化Png文件工厂");
        return new PngReader();
    }
}

/**
 * @author Levin
 * @create 2017/10/24 0024
 */
public class MethodFactory {
    public static void main(String[] args) {
        ImageReaderFactory png = new PngFactory();
        ImageReader pngReader = png.create();
        pngReader.read();

        ImageReaderFactory jpg = new JpgFactory();
        ImageReader jpgReader = jpg.create();
        jpgReader.read();
    }
}
