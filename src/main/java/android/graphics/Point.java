/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package android.graphics;

import android.graphics.Point$1;
import android.os.Parcel;
import android.os.Parcelable;

public class Point
implements Parcelable {
    public int x;
    public int b;
    public static final Parcelable.Creator c = new Point$1();

    public Point() {
    }

    public Point(int n2, int n3) {
        this.x = n2;
        this.b = n3;
    }

    public void a(int n2, int n3) {
        this.x = n2;
        this.b = n3;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point)object;
        if (this.x != point.x) {
            return false;
        }
        return this.b == point.b;
    }

    public int hashCode() {
        int n2 = this.x;
        n2 = 31 * n2 + this.b;
        return n2;
    }

    public String toString() {
        return "Point(" + this.x + ", " + this.b + ")";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.x);
        parcel.writeInt(this.b);
    }

    public void a(Parcel parcel) {
        this.x = parcel.readInt();
        this.b = parcel.readInt();
    }
}

