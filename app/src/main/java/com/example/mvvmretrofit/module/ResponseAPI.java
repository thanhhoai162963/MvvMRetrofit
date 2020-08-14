package com.example.mvvmretrofit.module;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAPI {


private Integer totalpage;

private String currentpage;

private Boolean success;

private Object message;

private List<Word> data = null;

/**
* No args constructor for use in serialization
*
*/
public ResponseAPI() {
}

/**
*
* @param totalpage
* @param data
* @param success
* @param currentpage
* @param message
*/
public ResponseAPI(Integer totalpage, String currentpage, Boolean success, Object message, List<Word> data) {
super();
this.totalpage = totalpage;
this.currentpage = currentpage;
this.success = success;
this.message = message;
this.data = data;
}

public Integer getTotalpage() {
return totalpage;
}

public void setTotalpage(Integer totalpage) {
this.totalpage = totalpage;
}

public String getCurrentpage() {
return currentpage;
}

public void setCurrentpage(String currentpage) {
this.currentpage = currentpage;
}

public Boolean getSuccess() {
return success;
}

public void setSuccess(Boolean success) {
this.success = success;
}

public Object getMessage() {
return message;
}

public void setMessage(Object message) {
this.message = message;
}

public List<Word> getData() {
return data;
}

public void setData(List<Word> data) {
this.data = data;
}

}