package fr.romainpotier.androidwearstarter.beans;

import com.google.android.gms.maps.model.Marker;

public class SpecificMarker {

    private Marker marker;

    private String markerInformations;

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(final Marker marker) {
        this.marker = marker;
    }

    public String getMarkerInformations() {
        return markerInformations;
    }

    public void setMarkerInformations(final String markerInformations) {
        this.markerInformations = markerInformations;
    }

    @Override
    public String toString() {
        return "SpecificMarker [marker=" + marker + ", markerInformations=" + markerInformations + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((marker == null) ? 0 : marker.hashCode());
        result = prime * result + ((markerInformations == null) ? 0 : markerInformations.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SpecificMarker other = (SpecificMarker) obj;
        if (marker == null) {
            if (other.marker != null) {
                return false;
            }
        } else if (!marker.equals(other.marker)) {
            return false;
        }
        if (markerInformations == null) {
            if (other.markerInformations != null) {
                return false;
            }
        } else if (!markerInformations.equals(other.markerInformations)) {
            return false;
        }
        return true;
    }

}
