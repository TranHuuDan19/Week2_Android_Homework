package com.example.week2

import android.os.Parcel
import android.os.Parcelable

public class UserInformationData(val email: String?, val fullName: String?, val phoneNumber: String?): Parcelable
{

    override fun toString(): String {
        return "UserInformation(email=$email, fullName=$fullName, phoneNumber=$phoneNumber)"
    }
    constructor(email: String, fullName: String, phoneNumber: String, i: Int) : this(email, fullName, phoneNumber)
    constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString()
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(fullName)
        parcel.writeString(phoneNumber)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<UserInformationData> {
        override fun createFromParcel(parcel: Parcel): UserInformationData {
            return UserInformationData(parcel)
        }
        override fun newArray(size: Int): Array<UserInformationData?> {
            return arrayOfNulls(size)
        }
    }

}