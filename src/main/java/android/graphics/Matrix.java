// Matrix.java
package android.graphics;

public class Matrix {
    
    public static Matrix a;
    public int b;
    
    public Matrix() {
        this.b = a(0);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix)) {
            return false;
        }
        Matrix other = (Matrix) obj;
        return a(this.b, other.b);
    }
    
    @Override
    public int hashCode() {
        return 44;
    }
    
    public void getValues(float[] values) {
        if (values.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        }
        a(this.b, values);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Matrix{");
        a(sb);
        sb.append('}');
        return sb.toString();
    }
    
    public void a(StringBuilder sb) {
        float[] values = new float[9];
        getValues(values);
        
        sb.append('[');
        sb.append(values[0]).append(", ").append(values[1]).append(", ").append(values[2]);
        sb.append("][");
        sb.append(values[3]).append(", ").append(values[4]).append(", ").append(values[5]);
        sb.append("][");
        sb.append(values[6]).append(", ").append(values[7]).append(", ").append(values[8]);
        sb.append(']');
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            b(this.b);
        } finally {
            super.finalize();
        }
    }
    
    private static int a(int arg) {
        return 0;
    }
    
    private static void a(int arg, float[] values) {
        // 空实现
    }
    
    private static boolean a(int arg0, int arg1) {
        return false;
    }
    
    private static void b(int arg) {
        // 空实现
    }
    
    static {
        a = new Matrix();
    }
    
    // 内部枚举类
    public enum ScaleToFit {
        FILL(0),
        START(1),
        CENTER(2),
        END(3);
        
        final int value;
        
        ScaleToFit(int value) {
            this.value = value;
        }
    }
}