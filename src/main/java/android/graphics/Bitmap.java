package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import java.io.OutputStream;

public final class Bitmap implements Parcelable {
    
    public final int a; // Native bitmap reference
    private final boolean d; // Is mutable
    private boolean e; // Has alpha
    private int f; // Width
    private int g; // Height
    private boolean h; // Is recycled
    int b; // Density
    private static volatile int i = -1; // Some static field
    public static final Parcelable.Creator<Bitmap> c = new BitmapCreator();

    // Private constructor - typically Bitmap instances are created via static methods
    private Bitmap(int nativeBitmap, int width, int height, boolean isMutable, boolean hasAlpha, int density) {
        this.a = nativeBitmap;
        this.f = width;
        this.g = height;
        this.d = isMutable;
        this.e = hasAlpha;
        this.b = density;
        this.h = false;
    }

    private void checkRecycled(String errorMessage) {
        if (h) {
            throw new IllegalStateException(errorMessage);
        }
    }

    private static void checkXY(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    public Bitmap copy(Config config, boolean isMutable) {
        checkRecycled("Can't copy a recycled bitmap");
        
        Bitmap result = nativeCopy(a, config.e, isMutable);
        if (result != null) {
            result.e = this.e;
            result.b = this.b;
        }
        return result;
    }

    public static Bitmap createBitmap(int width, int height, Config config) {
        return createBitmap(width, height, config, true);
    }

    private static Bitmap createBitmap(int width, int height, Config config, boolean hasAlpha) {
        return createBitmap(null, width, height, config, hasAlpha);
    }

    private static Bitmap createBitmap(DisplayMetrics displayMetrics, int width, int height, 
                                     Config config, boolean hasAlpha) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }

        Bitmap bitmap = nativeCreate(null, 0, width, width, height, config.e, true);
        
        if (displayMetrics != null) {
            bitmap.b = displayMetrics.densityDpi;
        }

        if (config == Config.ARGB_8888 && !hasAlpha) {
            nativeErase(bitmap.a, 0xFF000000); // Fill with black
        }
        
        nativeSetHasAlpha(bitmap.a, hasAlpha);
        return bitmap;
    }

    public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        checkRecycled("Can't compress a recycled bitmap");
        
        if (stream == null) {
            throw new NullPointerException();
        }
        
        if (quality < 0 || quality > 100) {
            throw new IllegalArgumentException("quality must be 0..100");
        }

        return nativeCompress(a, format.d, quality, stream, new byte[4096]);
    }

    public final boolean isMutable() {
        return d;
    }

    public final int getWidth() {
        return f;
    }

    public final int getHeight() {
        return g;
    }

    public final Config getConfig() {
        int nativeConfig = nativeConfig(a);
        return Config.fromNative(nativeConfig);
    }

    public void setHasAlpha(boolean hasAlpha) {
        nativeSetHasAlpha(a, hasAlpha);
        this.e = hasAlpha;
    }

    public void eraseColor(int color) {
        checkRecycled("Can't erase a recycled bitmap");
        
        if (!isMutable()) {
            throw new IllegalStateException("cannot erase immutable bitmaps");
        }

        nativeErase(a, color);
    }

    public int getPixel(int x, int y) {
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkCoordinates(x, y);
        
        return nativeGetPixel(a, x, y, e);
    }

    public void getPixels(int[] pixels, int offset, int stride, 
                         int x, int y, int width, int height) {
        checkRecycled("Can't call getPixels() on a recycled bitmap");
        
        if (width == 0 || height == 0) {
            return;
        }

        checkPixelsParameters(x, y, width, height, stride, offset, pixels);
        nativeGetPixels(a, pixels, offset, stride, x, y, width, height, e);
    }

    private void checkCoordinates(int x, int y) {
        checkXY(x, y);
        
        if (x >= getWidth()) {
            throw new IllegalArgumentException("x must be < bitmap.width()");
        }
        if (y >= getHeight()) {
            throw new IllegalArgumentException("y must be < bitmap.height()");
        }
    }

    private void checkPixelsParameters(int x, int y, int width, int height, 
                                     int stride, int offset, int[] pixels) {
        checkXY(x, y);
        
        if (width < 0) {
            throw new IllegalArgumentException("width must be >= 0");
        }
        if (height < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        if (x + width > getWidth()) {
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        }
        if (y + height > getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }
        if (Math.abs(stride) < width) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }

        int lastScanline = offset + (height - 1) * stride;
        int length = pixels.length;
        
        if (offset < 0 || offset + width > length || 
            lastScanline < 0 || lastScanline + width > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void setPixel(int x, int y, int color) {
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        
        if (!isMutable()) {
            throw new IllegalStateException();
        }

        checkCoordinates(x, y);
        nativeSetPixel(a, x, y, color, e);
    }

    public void setPixels(int[] pixels, int offset, int stride, 
                         int x, int y, int width, int height) {
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        
        if (!isMutable()) {
            throw new IllegalStateException();
        }

        if (width == 0 || height == 0) {
            return;
        }

        checkPixelsParameters(x, y, width, height, stride, offset, pixels);
        nativeSetPixels(a, pixels, offset, stride, x, y, width, height, e);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        checkRecycled("Can't parcel a recycled bitmap");
        
        if (!nativeWriteToParcel(a, d, b, parcel)) {
            throw new RuntimeException("native writeToParcel failed");
        }
    }

    // Native methods
    private static native Bitmap nativeCreate(int[] colors, int offset, int stride, 
                                            int width, int height, int config, boolean isMutable);
    private static native Bitmap nativeCopy(int nativeBitmap, int config, boolean isMutable);
    private static native boolean nativeCompress(int nativeBitmap, int format, int quality, 
                                               OutputStream stream, byte[] tempStorage);
    private static native void nativeErase(int nativeBitmap, int color);
    private static native int nativeConfig(int nativeBitmap);
    private static native int nativeGetPixel(int nativeBitmap, int x, int y, boolean hasAlpha);
    private static native void nativeGetPixels(int nativeBitmap, int[] pixels, int offset, int stride,
                                             int x, int y, int width, int height, boolean hasAlpha);
    private static native void nativeSetPixel(int nativeBitmap, int x, int y, int color, boolean hasAlpha);
    private static native void nativeSetPixels(int nativeBitmap, int[] pixels, int offset, int stride,
                                             int x, int y, int width, int height, boolean hasAlpha);
    private static native Bitmap nativeCreateFromParcel(Parcel parcel);
    private static native boolean nativeWriteToParcel(int nativeBitmap, boolean isMutable, 
                                                    int density, Parcel parcel);
    private static native void nativeSetHasAlpha(int nativeBitmap, boolean hasAlpha);

    // Package-private method for Parcelable.Creator
    static Bitmap createFromParcel(Parcel parcel) {
        return nativeCreateFromParcel(parcel);
    }

    // Nested Config enum
    public enum Config {
        ALPHA_8(2),
        RGB_565(4),
        ARGB_4444(5),
        ARGB_8888(6);

        final int e; // Native config value

        Config(int nativeInt) {
            this.e = nativeInt;
        }

        private static final Config[] NATIVE_VALUES = new Config[7];
        
        static {
            NATIVE_VALUES[2] = ALPHA_8;
            NATIVE_VALUES[4] = RGB_565;
            NATIVE_VALUES[5] = ARGB_4444;
            NATIVE_VALUES[6] = ARGB_8888;
        }

        static Config fromNative(int nativeInt) {
            if (nativeInt >= 0 && nativeInt < NATIVE_VALUES.length) {
                return NATIVE_VALUES[nativeInt];
            }
            return ARGB_8888; // Default
        }
    }

    // Nested CompressFormat enum
    public enum CompressFormat {
        JPEG(0),
        PNG(1),
        WEBP(2);

        final int d; // Native format value

        CompressFormat(int nativeInt) {
            this.d = nativeInt;
        }
    }

    // Parcelable.Creator implementation
    private static class BitmapCreator implements Parcelable.Creator<Bitmap> {
        @Override
        public Bitmap createFromParcel(Parcel source) {
            Bitmap bitmap = Bitmap.createFromParcel(source);
            if (bitmap == null) {
                throw new RuntimeException("Failed to unparcel Bitmap");
            }
            return bitmap;
        }

        @Override
        public Bitmap[] newArray(int size) {
            return new Bitmap[size];
        }
    }
}