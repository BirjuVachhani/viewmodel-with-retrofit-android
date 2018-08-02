
package com.birjuvachhani.viewmodelwithretrofit.api;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    public final static Creator<ApiResponse> CREATOR = new Creator<ApiResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApiResponse createFromParcel(Parcel in) {
            return new ApiResponse(in);
        }

        public ApiResponse[] newArray(int size) {
            return (new ApiResponse[size]);
        }

    }
    ;

    protected ApiResponse(Parcel in) {
        in.readList(this.results, (com.birjuvachhani.viewmodelwithretrofit.api.Result.class.getClassLoader()));
    }

    public ApiResponse() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
