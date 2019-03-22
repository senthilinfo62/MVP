package multipleimagepicker.com.mvp.Model;

import java.util.ArrayList;

public class CountryResponse {
    private boolean IsSuccess;
    private String UserMessage = null;
    private String TechnicalMessage = null;
    private float TotalCount;

    public ArrayList<CountryModel> getResponse() {
        return Response;
    }

    public void setResponse(ArrayList<CountryModel> response) {
        Response = response;
    }

    ArrayList<CountryModel> Response = new ArrayList<CountryModel>();


    // Getter Methods

    public boolean getIsSuccess() {
        return IsSuccess;
    }

    public String getUserMessage() {
        return UserMessage;
    }

    public String getTechnicalMessage() {
        return TechnicalMessage;
    }

    public float getTotalCount() {
        return TotalCount;
    }

    // Setter Methods

    public void setIsSuccess( boolean IsSuccess ) {
        this.IsSuccess = IsSuccess;
    }

    public void setUserMessage( String UserMessage ) {
        this.UserMessage = UserMessage;
    }

    public void setTechnicalMessage( String TechnicalMessage ) {
        this.TechnicalMessage = TechnicalMessage;
    }

    public void setTotalCount( float TotalCount ) {
        this.TotalCount = TotalCount;
    }
}
