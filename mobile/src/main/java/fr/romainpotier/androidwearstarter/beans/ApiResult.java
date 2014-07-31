package fr.romainpotier.androidwearstarter.beans;

import java.util.List;

public class ApiResult {

    private long nhits;
    private Parameters parameters;
    private List<Record> records;

    public long getNhits() {
        return nhits;
    }

    public void setNhits(final long nhits) {
        this.nhits = nhits;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(final Parameters parameters) {
        this.parameters = parameters;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(final List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "ApiResult [nhits=" + nhits + ", parameters=" + parameters + ", records=" + records + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (nhits ^ (nhits >>> 32));
        result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
        result = prime * result + ((records == null) ? 0 : records.hashCode());
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
        ApiResult other = (ApiResult) obj;
        if (nhits != other.nhits) {
            return false;
        }
        if (parameters == null) {
            if (other.parameters != null) {
                return false;
            }
        } else if (!parameters.equals(other.parameters)) {
            return false;
        }
        if (records == null) {
            if (other.records != null) {
                return false;
            }
        } else if (!records.equals(other.records)) {
            return false;
        }
        return true;
    }

}
