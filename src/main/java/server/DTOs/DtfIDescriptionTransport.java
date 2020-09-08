package server.DTOs;

import server.annotations.ApiEntity;

@ApiEntity
public class DtfIDescriptionTransport {

    private String dtfiId;
    private String description;

    public DtfIDescriptionTransport(String dtfiId, String description) {
        this.dtfiId = dtfiId;
        this.description = description;
    }

    public String getDtfiId() {
        return dtfiId;
    }

    public void setDtfiId(String dtfiId) {
        this.dtfiId = dtfiId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
