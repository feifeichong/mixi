package com.lecotec.mixi.model.parameter;

import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.model.entity.Station;

public class RiderParam extends Rider {
    private long stationId;

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
        super.setStation(new Station() {{
            this.setId(stationId);
        }});
    }
}
