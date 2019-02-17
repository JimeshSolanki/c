package com.progragon.c.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

import com.progragon.c.BR;

public class Service extends BaseObservable implements Parcelable {

    private String serviceCode;
    private String serviceName;
    private String serviceDateTime;

    public Service() {
    }

    private Service(Parcel in) {
        serviceCode = in.readString();
        serviceName = in.readString();
        serviceDateTime = in.readString();
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

    @Bindable
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        notifyPropertyChanged(BR.serviceCode);
    }

    @Bindable
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
        notifyPropertyChanged(BR.serviceCode);
    }

    @Bindable
    public String getServiceDateTime() {
        return serviceDateTime;
    }

    public void setServiceDateTime(String serviceDateTime) {
        this.serviceDateTime = serviceDateTime;
        notifyPropertyChanged(BR.serviceDateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(serviceCode);
        dest.writeString(serviceName);
        dest.writeString(serviceDateTime);
    }
}
