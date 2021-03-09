package com.rasa.computerman.Utils;


import com.rasa.computerman.App;
import com.rasa.computerman.R;

/**
 * Created by Mehdi on 1/23/2018 AD.
 */

public enum ErrorMessage {
        ERROR_NETWORK_SERVER_SIDE(-1, App.getContext().getString(R.string.error_server_side)),
        ERROR_NETWORK_UNAVALABLE(0, App.getContext().getString(R.string.error_network_connection)),
        ERROR_404(404,App.getContext().getString(R.string.error_server_not_found));





    /**************** Error Settings *****************************************************/
	/**/		 private int errorCode;
    /**/		 private String errorMessage;
    /**/
     ErrorMessage(int errorCode, String errorMessage) {
	/**/		        this.errorCode=errorCode;
	/**/			    this.errorMessage=errorMessage;
	/**/		    }
    /**/			public int getErrorCode() { return this.errorCode; }
    /**/		    public String getErrorMessage() { return this.errorMessage; }

    public static String getErrorByCode(int errorCode){

        for(ErrorMessage error:ErrorMessage.values()){
            if(error.errorCode==errorCode){
                return error.errorMessage;
            }
        }
        return ERROR_NETWORK_UNAVALABLE.errorMessage;
    }
    /**************** Sprite Settings *****************************************************/
}
