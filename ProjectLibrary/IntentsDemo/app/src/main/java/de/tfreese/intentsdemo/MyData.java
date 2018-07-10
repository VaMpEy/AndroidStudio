package de.tfreese.intentsdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class MyData implements Parcelable {
    public int zahl = 4711;
    public String text = "Ein Text";

    public MyData() {

    }

    protected MyData(Parcel in) {
        zahl = in.readInt();
        text = in.readString();
    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(zahl);
        dest.writeString(text);
    }

    @Override
    public String toString() {
        return "MyData{" +
                "zahl=" + zahl +
                ", text='" + text + '\'' +
                '}';
    }
}
