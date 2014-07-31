package fr.romainpotier.androidwearstarter.beans;


import java.sql.Timestamp;

public class Record {

    private String datasetid;
    private String recordid;
    private Fields fields;
    private Geometry geometry;
    private Timestamp record_timestamp;


    public Timestamp getRecord_timestamp() {
        return record_timestamp;
    }

    public void setRecord_timestamp(Timestamp record_timestamp) {
        this.record_timestamp = record_timestamp;
    }

    public String getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(final String datasetid) {
        this.datasetid = datasetid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(final String recordid) {
        this.recordid = recordid;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(final Fields fields) {
        this.fields = fields;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(final Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Record [datasetid=" + datasetid + ", recordid=" + recordid + ", fields=" + fields + ", geometry=" + geometry + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datasetid == null) ? 0 : datasetid.hashCode());
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        result = prime * result + ((geometry == null) ? 0 : geometry.hashCode());
        result = prime * result + ((recordid == null) ? 0 : recordid.hashCode());
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
        Record other = (Record) obj;
        if (datasetid == null) {
            if (other.datasetid != null) {
                return false;
            }
        } else if (!datasetid.equals(other.datasetid)) {
            return false;
        }
        if (fields == null) {
            if (other.fields != null) {
                return false;
            }
        } else if (!fields.equals(other.fields)) {
            return false;
        }
        if (geometry == null) {
            if (other.geometry != null) {
                return false;
            }
        } else if (!geometry.equals(other.geometry)) {
            return false;
        }
        if (recordid == null) {
            if (other.recordid != null) {
                return false;
            }
        } else if (!recordid.equals(other.recordid)) {
            return false;
        }
        return true;
    }

}
